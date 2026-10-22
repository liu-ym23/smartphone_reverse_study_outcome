package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import wwc.b;

/* JADX INFO: loaded from: classes41.dex */
final class ParallelReduceFull$ParallelReduceFullMainSubscriber<T> extends DeferredScalarSubscription<T> {
    private static final long serialVersionUID = -5370107872170712765L;
    final AtomicReference<ParallelReduceFull$SlotPair<T>> current;
    final AtomicReference<Throwable> error;
    final BiFunction<T, T, T> reducer;
    final AtomicInteger remaining;
    final ParallelReduceFull$ParallelReduceFullInnerSubscriber<T>[] subscribers;

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, wwc.c
    public void cancel() {
        ParallelReduceFull$ParallelReduceFullInnerSubscriber<T>[] r100 = this.subscribers;
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r100[r102].cancel();
        r102 = r102 + 1;
        goto L3
    }

    public ParallelReduceFull$SlotPair<T> addValue(T r100) {
    L2:
        ParallelReduceFull$SlotPair<T> r101 = this.current.get();
        if (r101 != null) goto L14;
        ParallelReduceFull$SlotPair<T> r102 = new ParallelReduceFull$SlotPair();
        AtomicReference<ParallelReduceFull$SlotPair<T>> r103 = this.current;
    L6:
        if (r103.compareAndSet(null, r102) == true) goto L7;
        if (r103.get() == null) goto L6;
        boolean r104 = false;
    L11:
        if (r104 == false) goto L2;
        r101 = r102;
        goto L14
    L7:
        r104 = true;
    L14:
        int r105 = r101.tryAcquireSlot();
        if (r105 >= 0) goto L23;
        AtomicReference<ParallelReduceFull$SlotPair<T>> r106 = this.current;
    L18:
        if (r106.compareAndSet(r101, null) == true) goto L2;
        if (r106.get() == r101) goto L18;
    L23:
        if (r105 != 0) goto L25;
        r101.first = r100;
    L27:
        if (r101.releaseSlot() == false) goto L35;
        AtomicReference<ParallelReduceFull$SlotPair<T>> r107 = this.current;
    L30:
        if (r107.compareAndSet(r101, null) == true) goto L34;
        if (r107.get() == r101) goto L30;
    L34:
        return r101;
    L35:
        return null;
    L25:
        r101.second = r100;
        goto L27
    }

    public void innerComplete(T r100) {
        if (r100 == null) goto L11;
    L3:
        ParallelReduceFull$SlotPair<T> r101 = addValue(r100);
        if (r101 == null) goto L11;
        r100 = (T) ObjectHelper.requireNonNull(this.reducer.apply(r101.first, r101.second), "The reducer returned a null value");
    L7:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        innerError(th);
        return;
    L11:
        if (this.remaining.decrementAndGet() != 0) goto L21;
        ParallelReduceFull$SlotPair<T> r102 = this.current.get();
        this.current.lazySet(null);
        if (r102 == null) goto L15;
        complete(r102.first);
        return;
    L15:
        this.downstream.onComplete();
        return;
    }

    public void innerError(Throwable r100) {
        AtomicReference<Throwable> r101 = this.error;
    L4:
        if (r101.compareAndSet(null, r100) == true) goto L5;
        if (r101.get() == null) goto L4;
        boolean r102 = false;
    L9:
        if (r102 == false) goto L12;
        cancel();
        this.downstream.onError(r100);
        return;
    L12:
        if (r100 == this.error.get()) goto L19;
        RxJavaPlugins.onError(r100);
        return;
    L19:
        return;
    L5:
        r102 = true;
        goto L9
    }

    public ParallelReduceFull$ParallelReduceFullMainSubscriber(b<? super T> r100, int r101, BiFunction<T, T, T> r102) {
        super(r100);
        this.current = new AtomicReference();
        this.remaining = new AtomicInteger();
        this.error = new AtomicReference();
        ParallelReduceFull$ParallelReduceFullInnerSubscriber<T>[] r103 = new ParallelReduceFull$ParallelReduceFullInnerSubscriber[r101];
        int r104 = 0;
    L3:
        if (r104 >= r101) goto L5;
        r103[r104] = new ParallelReduceFull$ParallelReduceFullInnerSubscriber(this, r102);
        r104 = r104 + 1;
        goto L3
    L5:
        this.subscribers = r103;
        this.reducer = r102;
        this.remaining.lazySet(r101);
    }
}
