package com.larus.voicecall.impl.utils;

import java.util.concurrent.ArrayBlockingQueue;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u000f\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/voicecall/impl/utils/SumArrayBlockingQueue;", "Ljava/util/concurrent/ArrayBlockingQueue;", "", "capacity", "", "<init>", "(I)V", "getCapacity", "()I", "sum", "offer", "", "e", "poll", "()Ljava/lang/Long;", "offerAndRemoveOldest", "clear", "", "getSum", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SumArrayBlockingQueue extends ArrayBlockingQueue<Long> {
    private final int capacity;
    private long sum;

    @Override // java.util.concurrent.ArrayBlockingQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        super.clear();
        this.sum = 0;
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.concurrent.ArrayBlockingQueue, java.util.Queue
    public Long poll() {
        Long r100 = (Long) super.poll();
        if (r100 == null) goto L5;
        this.sum -= r100.longValue();
    L5:
        return r100;
    }

    @Override // java.util.concurrent.ArrayBlockingQueue, java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public final long getSum() {
        return this.sum;
    }

    @Override // java.util.concurrent.ArrayBlockingQueue, java.util.Queue
    public /* bridge */ /* synthetic */ Object poll() {
        return poll();
    }

    public SumArrayBlockingQueue(int r100) {
        super(r100);
        this.capacity = r100;
    }

    @Override // java.util.concurrent.ArrayBlockingQueue, java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public final /* bridge */ boolean contains(Object r100) {
        if (r100 != null) goto L4;
        boolean r101 = true;
    L5:
        if (r101 == true) goto L9;
        return false;
    L9:
        return contains((Long) r100);
    L4:
        r101 = r100 instanceof Long;
        goto L5
    }

    public boolean offer(long r100) {
        boolean r101 = super.offer(Long.valueOf(r100));
        if (r101 == false) goto L5;
        this.sum += r100;
    L5:
        return r101;
    }

    public final boolean offerAndRemoveOldest(long r100) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (size() != this.capacity) goto L6;
        poll();     // Catch: Throwable -> L9
    L6:
        boolean r101 = offer(r100);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r101;
    }

    @Override // java.util.concurrent.ArrayBlockingQueue, java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public final /* bridge */ boolean remove(Object r100) {
        if (r100 != null) goto L4;
        boolean r101 = true;
    L5:
        if (r101 == true) goto L9;
        return false;
    L9:
        return remove((Long) r100);
    L4:
        r101 = r100 instanceof Long;
        goto L5
    }

    public /* bridge */ boolean contains(Long r100) {
        return super.contains(r100);
    }

    @Override // java.util.concurrent.ArrayBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
    public /* bridge */ /* synthetic */ boolean offer(Object r100) {
        return offer(((Number) r100).longValue());
    }

    public /* bridge */ boolean remove(Long r100) {
        return super.remove(r100);
    }
}
