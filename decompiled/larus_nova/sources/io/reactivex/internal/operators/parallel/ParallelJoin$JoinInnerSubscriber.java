package io.reactivex.internal.operators.parallel;

import io.reactivex.g;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import vtc.i;
import wwc.c;

/* JADX INFO: loaded from: classes41.dex */
final class ParallelJoin$JoinInnerSubscriber<T> extends AtomicReference<c> implements g<T> {
    private static final long serialVersionUID = 8410034718427740355L;
    final int limit;
    final ParallelJoin$JoinSubscriptionBase<T> parent;
    final int prefetch;
    long produced;
    volatile i<T> queue;

    public i<T> getQueue() {
        i<T> r100 = this.queue;
        if (r100 != null) goto L6;
        SpscArrayQueue r101 = new SpscArrayQueue(this.prefetch);
        this.queue = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // wwc.b
    public void onComplete() {
        this.parent.onComplete();
    }

    public void requestOne() {
        long r100 = this.produced + 1;
        if (r100 != this.limit) goto L5;
        this.produced = 0;
        get().request(r100);
        return;
    L5:
        this.produced = r100;
    }

    public boolean cancel() {
        return SubscriptionHelper.cancel(this);
    }

    @Override // wwc.b
    public void onError(Throwable r100) {
        this.parent.onError(r100);
    }

    @Override // wwc.b
    public void onNext(T r100) {
        this.parent.onNext(this, r100);
    }

    @Override // io.reactivex.g, wwc.b
    public void onSubscribe(c r100) {
        SubscriptionHelper.setOnce(this, r100, this.prefetch);
    }

    public void request(long r100) {
        long r101 = this.produced + r100;
        if (r101 < this.limit) goto L5;
        this.produced = 0;
        get().request(r101);
        return;
    L5:
        this.produced = r101;
    }

    public ParallelJoin$JoinInnerSubscriber(ParallelJoin$JoinSubscriptionBase<T> r100, int r101) {
        this.parent = r100;
        this.prefetch = r101;
        this.limit = r101 - (r101 >> 2);
    }
}
