package com.lmax.disruptor;

/**
 * EntryConsumers waitFor {@link Entry}s to become available for consumption from the {@link RingBuffer}
 */
public interface EntryConsumer<T extends  Entry> extends Runnable
{
    /**
     * Get the sequence up to which this EntryConsumer has consumed {@link Entry}s
     *
     * @return the sequence of the last consumed {@link Entry}
     */
    long getSequence();

    /**
     * Get the ConsumerBarrier on which this EntryConsumer is waiting for {@link Entry}s
     *
     * @return the barrier being waited on.
     */
    ConsumerBarrier<T> getConsumerBarrier();

    /**
     * Signal that this EntryConsumer should stop when it has finished consuming at the next clean break.
     * It will call {@link ConsumerBarrier#alert()} to notify the thread to check status.
     */
    void halt();
}
