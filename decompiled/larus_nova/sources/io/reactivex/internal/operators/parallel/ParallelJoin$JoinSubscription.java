package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.plugins.RxJavaPlugins;
import vtc.i;
import wwc.b;

/* JADX INFO: loaded from: classes41.dex */
final class ParallelJoin$JoinSubscription<T> extends ParallelJoin$JoinSubscriptionBase<T> {
    private static final long serialVersionUID = 6312374661811000451L;

    public void drainLoop() {
        ParallelJoin$JoinInnerSubscriber<T>[] r100 = this.subscribers;
        int r101 = r100.length;
        b<? super T> r102 = this.downstream;
        int r103 = 1;
    L3:
        long r104 = this.requested.get();
        long r110 = 0;
    L5:
        if (r110 == r104) goto L36;
        if (this.cancelled == true) goto L8;
        Throwable r111 = this.errors.get();
        if (r111 != null) goto L12;
        if (this.done.get() != 0) goto L17;
        boolean r112 = true;
    L18:
        int r113 = 0;
        boolean r114 = true;
    L20:
        if (r113 >= r100.length) goto L30;
        ParallelJoin$JoinInnerSubscriber<T> r105 = r100[r113];
        i<T> r115 = r105.queue;
        if (r115 == null) goto L29;
        T r116 = r115.poll();
        if (r116 == null) goto L29;
        r102.onNext(r116);
        r105.requestOne();
        r110 = r110 + 1;
        if (r110 == r104) goto L36;
        r114 = false;
    L29:
        r113 = r113 + 1;
        goto L20
    L30:
        if (r112 == false) goto L34;
        if (r114 == false) goto L34;
        r102.onComplete();
        return;
    L34:
        if (r114 == false) goto L5;
    L17:
        r112 = false;
        goto L18
    L12:
        cleanup();
        r102.onError(r111);
        return;
    L8:
        cleanup();
        return;
    L36:
        if (r110 != r104) goto L63;
        if (this.cancelled == true) goto L39;
        Throwable r106 = this.errors.get();
        if (r106 != null) goto L43;
        if (this.done.get() != 0) goto L48;
        boolean r107 = true;
    L49:
        int r117 = 0;
    L50:
        if (r117 >= r101) goto L57;
        i<T> r118 = r100[r117].queue;
        if (r118 == null) goto L56;
        if (r118.isEmpty() == true) goto L56;
        boolean r119 = false;
    L58:
        if (r107 == false) goto L63;
        if (r119 == false) goto L63;
        r102.onComplete();
        return;
    L56:
        r117 = r117 + 1;
        goto L50
    L57:
        r119 = true;
        goto L58
    L48:
        r107 = false;
        goto L49
    L43:
        cleanup();
        r102.onError(r106);
        return;
    L39:
        cleanup();
        return;
    L63:
        if (r110 != 0) goto L65;
    L67:
        int r108 = get();
        if (r108 != r103) goto L72;
        r108 = addAndGet(-r103);
        if (r108 != 0) goto L72;
        return;
    L72:
        r103 = r108;
        goto L3
    L65:
        if (r104 == Long.MAX_VALUE) goto L67;
        this.requested.addAndGet(-r110);
        goto L67
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
    public void onComplete() {
        this.done.decrementAndGet();
        drain();
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        drainLoop();
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
    public void onError(Throwable r100) {
        if (this.errors.compareAndSet(null, r100) == false) goto L6;
        cancelAll();
        drain();
        return;
    L6:
        if (r100 == this.errors.get()) goto L10;
        RxJavaPlugins.onError(r100);
        return;
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
    public void onNext(ParallelJoin$JoinInnerSubscriber<T> r100, T r101) {
        if (get() != 0) goto L23;
        if (compareAndSet(0, 1) == false) goto L23;
        if (this.requested.get() == 0) goto L13;
        this.downstream.onNext(r101);
        if (this.requested.get() == Long.MAX_VALUE) goto L11;
        this.requested.decrementAndGet();
    L11:
        r100.request(1);
    L20:
        if (decrementAndGet() != 0) goto L29;
        return;
    L29:
        drainLoop();
        return;
    L13:
        if (r100.getQueue().offer(r101) == true) goto L20;
        cancelAll();
        MissingBackpressureException r102 = new MissingBackpressureException("Queue full?!");
        if (this.errors.compareAndSet(null, r102) == false) goto L17;
        this.downstream.onError(r102);
        return;
    L17:
        RxJavaPlugins.onError(r102);
        return;
    L23:
        if (r100.getQueue().offer(r101) == true) goto L27;
        cancelAll();
        onError(new MissingBackpressureException("Queue full?!"));
        return;
    L27:
        if (getAndIncrement() == 0) goto L29;
    }

    public ParallelJoin$JoinSubscription(b<? super T> r100, int r101, int r102) {
        super(r100, r101, r102);
    }
}
