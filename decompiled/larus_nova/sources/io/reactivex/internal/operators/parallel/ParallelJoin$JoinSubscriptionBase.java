package io.reactivex.internal.operators.parallel;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import wwc.b;
import wwc.c;

/* JADX INFO: loaded from: classes41.dex */
abstract class ParallelJoin$JoinSubscriptionBase<T> extends AtomicInteger implements c {
    private static final long serialVersionUID = 3100232009247827843L;
    volatile boolean cancelled;
    final AtomicInteger done;
    final b<? super T> downstream;
    final AtomicThrowable errors;
    final AtomicLong requested;
    final ParallelJoin$JoinInnerSubscriber<T>[] subscribers;

    public abstract void drain();

    public abstract void onComplete();

    public abstract void onError(Throwable r100);

    public abstract void onNext(ParallelJoin$JoinInnerSubscriber<T> r100, T r101);

    @Override // wwc.c
    public void cancel() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        cancelAll();
        if (getAndIncrement() != 0) goto L9;
        cleanup();
        return;
    L9:
        return;
    }

    public void cancelAll() {
        ParallelJoin$JoinInnerSubscriber<T>[] r100 = this.subscribers;
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r100[r102].cancel();
        r102 = r102 + 1;
        goto L3
    }

    public void cleanup() {
        ParallelJoin$JoinInnerSubscriber<T>[] r100 = this.subscribers;
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r100[r102].queue = null;
        r102 = r102 + 1;
        goto L3
    }

    @Override // wwc.c
    public void request(long r100) {
        if (SubscriptionHelper.validate(r100) == false) goto L6;
        io.reactivex.internal.util.b.a(this.requested, r100);
        drain();
        return;
    }

    public ParallelJoin$JoinSubscriptionBase(b<? super T> r100, int r101, int r102) {
        this.errors = new AtomicThrowable();
        this.requested = new AtomicLong();
        this.done = new AtomicInteger();
        this.downstream = r100;
        ParallelJoin$JoinInnerSubscriber<T>[] r103 = new ParallelJoin$JoinInnerSubscriber[r101];
        int r104 = 0;
    L3:
        if (r104 >= r101) goto L5;
        r103[r104] = new ParallelJoin$JoinInnerSubscriber(this, r102);
        r104 = r104 + 1;
        goto L3
    L5:
        this.subscribers = r103;
        this.done.lazySet(r101);
    }
}
