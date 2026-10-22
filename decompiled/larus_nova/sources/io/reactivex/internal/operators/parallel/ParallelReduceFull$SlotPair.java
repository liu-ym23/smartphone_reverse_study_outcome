package io.reactivex.internal.operators.parallel;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes41.dex */
final class ParallelReduceFull$SlotPair<T> extends AtomicInteger {
    private static final long serialVersionUID = 473971317683868662L;
    T first;
    final AtomicInteger releaseIndex;
    T second;

    public boolean releaseSlot() {
        if (this.releaseIndex.incrementAndGet() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public ParallelReduceFull$SlotPair() {
        this.releaseIndex = new AtomicInteger();
    }

    public int tryAcquireSlot() {
    L2:
        int r100 = get();
        if (r100 >= 2) goto L4;
        if (compareAndSet(r100, r100 + 1) == false) goto L2;
        return r100;
    L4:
        return -1;
    }
}
