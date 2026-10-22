package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.MissingBackpressureException;
import vtc.i;
import wwc.b;

/* JADX INFO: loaded from: classes41.dex */
final class ParallelJoin$JoinSubscriptionDelayError<T> extends ParallelJoin$JoinSubscriptionBase<T> {
    private static final long serialVersionUID = -5737965195918321883L;

    public void drainLoop() {
        ParallelJoin$JoinInnerSubscriber<T>[] r100 = this.subscribers;
        int r101 = r100.length;
        b<? super T> r102 = this.downstream;
        int r103 = 1;
    L3:
        long r104 = this.requested.get();
        long r110 = 0;
    L5:
        if (r110 == r104) goto L34;
        if (this.cancelled == true) goto L8;
        if (this.done.get() != 0) goto L13;
        boolean r111 = true;
    L14:
        int r112 = 0;
        boolean r113 = true;
    L15:
        if (r112 >= r101) goto L25;
        ParallelJoin$JoinInnerSubscriber<T> r105 = r100[r112];
        i<T> r114 = r105.queue;
        if (r114 == null) goto L24;
        T r115 = r114.poll();
        if (r115 == null) goto L24;
        r102.onNext(r115);
        r105.requestOne();
        r110 = r110 + 1;
        if (r110 == r104) goto L34;
        r113 = false;
    L24:
        r112 = r112 + 1;
        goto L15
    L25:
        if (r111 == false) goto L32;
        if (r113 == false) goto L32;
        if (this.errors.get() == null) goto L30;
        r102.onError(this.errors.terminate());
        return;
    L30:
        r102.onComplete();
        return;
    L32:
        if (r113 == false) goto L5;
    L13:
        r111 = false;
        goto L14
    L8:
        cleanup();
        return;
    L34:
        if (r110 != r104) goto L60;
        if (this.cancelled == true) goto L37;
        if (this.done.get() != 0) goto L42;
        boolean r106 = true;
    L43:
        int r116 = 0;
    L44:
        if (r116 >= r101) goto L51;
        i<T> r117 = r100[r116].queue;
        if (r117 == null) goto L50;
        if (r117.isEmpty() == true) goto L50;
        boolean r118 = false;
    L52:
        if (r106 == false) goto L60;
        if (r118 == false) goto L60;
        if (this.errors.get() == null) goto L57;
        r102.onError(this.errors.terminate());
        return;
    L57:
        r102.onComplete();
        return;
    L50:
        r116 = r116 + 1;
        goto L44
    L51:
        r118 = true;
        goto L52
    L42:
        r106 = false;
        goto L43
    L37:
        cleanup();
        return;
    L60:
        if (r110 != 0) goto L62;
    L64:
        int r107 = get();
        if (r107 != r103) goto L69;
        r107 = addAndGet(-r103);
        if (r107 != 0) goto L69;
        return;
    L69:
        r103 = r107;
        goto L3
    L62:
        if (r104 == Long.MAX_VALUE) goto L64;
        this.requested.addAndGet(-r110);
        goto L64
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
        this.errors.addThrowable(r100);
        this.done.decrementAndGet();
        drain();
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
    public void onNext(ParallelJoin$JoinInnerSubscriber<T> r100, T r101) {
        if (get() != 0) goto L20;
        if (compareAndSet(0, 1) == false) goto L20;
        if (this.requested.get() == 0) goto L13;
        this.downstream.onNext(r101);
        if (this.requested.get() == Long.MAX_VALUE) goto L11;
        this.requested.decrementAndGet();
    L11:
        r100.request(1);
    L17:
        if (decrementAndGet() != 0) goto L27;
        return;
    L27:
        drainLoop();
        return;
    L13:
        if (r100.getQueue().offer(r101) == true) goto L17;
        r100.cancel();
        this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
        this.done.decrementAndGet();
        drainLoop();
        return;
    L20:
        if (r100.getQueue().offer(r101) == true) goto L25;
        if (r100.cancel() == false) goto L25;
        this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
        this.done.decrementAndGet();
    L25:
        if (getAndIncrement() == 0) goto L27;
    }

    public ParallelJoin$JoinSubscriptionDelayError(b<? super T> r100, int r101, int r102) {
        super(r100, r101, r102);
    }
}
