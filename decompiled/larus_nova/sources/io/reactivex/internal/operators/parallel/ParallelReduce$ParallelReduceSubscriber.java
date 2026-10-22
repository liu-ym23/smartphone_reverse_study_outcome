package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import wwc.b;
import wwc.c;

/* JADX INFO: loaded from: classes41.dex */
final class ParallelReduce$ParallelReduceSubscriber<T, R> extends DeferredScalarSubscriber<T, R> {
    private static final long serialVersionUID = 8200530050639449080L;
    R accumulator;
    boolean done;
    final BiFunction<R, ? super T, R> reducer;

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, wwc.b
    public void onComplete() {
        if (this.done == true) goto L6;
        this.done = true;
        R r100 = this.accumulator;
        this.accumulator = null;
        complete(r100);
        return;
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, wwc.c
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, wwc.b
    public void onError(Throwable r100) {
        if (this.done == false) goto L6;
        RxJavaPlugins.onError(r100);
        return;
    L6:
        this.done = true;
        this.accumulator = null;
        this.downstream.onError(r100);
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, wwc.b
    public void onNext(T r100) {
        if (this.done == true) goto L11;
        this.accumulator = (R) ObjectHelper.requireNonNull(this.reducer.apply(this.accumulator, r100), "The reducer returned a null value");
        return;
    L6:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        cancel();
        onError(th);
        return;
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.g, wwc.b
    public void onSubscribe(c r100) {
        if (SubscriptionHelper.validate(this.upstream, r100) == false) goto L6;
        this.upstream = r100;
        this.downstream.onSubscribe(this);
        r100.request(Long.MAX_VALUE);
        return;
    }

    public ParallelReduce$ParallelReduceSubscriber(b<? super R> r100, R r101, BiFunction<R, ? super T, R> r102) {
        super(r100);
        this.accumulator = r101;
        this.reducer = r102;
    }
}
