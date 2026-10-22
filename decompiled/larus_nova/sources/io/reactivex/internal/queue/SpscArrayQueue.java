package io.reactivex.internal.queue;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import vtc.i;

/* JADX INFO: loaded from: classes41.dex */
public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements i<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Integer f494903a = null;
    private static final long serialVersionUID = -1296597691183856449L;
    final AtomicLong consumerIndex;
    final int lookAheadStep;
    final int mask;
    final AtomicLong producerIndex;
    long producerLookAhead;

    public int calcElementOffset(long r100, int r101) {
        return ((int) r100) & r101;
    }

    static {
        f494903a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    }

    @Override // vtc.j
    public boolean isEmpty() {
        if (this.producerIndex.get() != this.consumerIndex.get()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // vtc.i, vtc.j
    public E poll() {
        long r100 = this.consumerIndex.get();
        int r101 = calcElementOffset(r100);
        E r102 = lvElement(r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        soConsumerIndex(r100 + 1);
        soElement(r101, null);
        return r102;
    }

    @Override // vtc.j
    public void clear() {
    L3:
        if (poll() != null) goto L3;
        if (isEmpty() == false) goto L3;
    }

    public SpscArrayQueue(int r100) {
        super(1 << (32 - Integer.numberOfLeadingZeros(r100 - 1)));
        this.mask = length() - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        this.lookAheadStep = Math.min(r100 / 4, f494903a.intValue());
    }

    public int calcElementOffset(long r100) {
        int r101 = (int) r100;
        return this.mask & r101;
    }

    public E lvElement(int r100) {
        return get(r100);
    }

    @Override // vtc.j
    public boolean offer(E r100) {
        if (r100 == null) goto L15;
        int r101 = this.mask;
        long r102 = this.producerIndex.get();
        int r103 = calcElementOffset(r102, r101);
        if (r102 < this.producerLookAhead) goto L12;
        long r104 = ((long) this.lookAheadStep) + r102;
        if (lvElement(calcElementOffset(r104, r101)) != null) goto L9;
        this.producerLookAhead = r104;
        goto L12
    L9:
        if (lvElement(r103) == null) goto L12;
        return false;
    L12:
        soElement(r103, r100);
        soProducerIndex(r102 + 1);
        return true;
    L15:
        throw new NullPointerException("Null is not a valid element");
    }

    public void soConsumerIndex(long r100) {
        this.consumerIndex.lazySet(r100);
    }

    public void soProducerIndex(long r100) {
        this.producerIndex.lazySet(r100);
    }

    public boolean offer(E r100, E r101) {
        if (offer(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (offer(r101) == false) goto L7;
        return true;
    }

    public void soElement(int r100, E r101) {
        lazySet(r100, r101);
    }
}
