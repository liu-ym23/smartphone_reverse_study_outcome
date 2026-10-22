package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import ttc.a;
import wwc.b;
import wwc.c;

/* JADX INFO: loaded from: classes41.dex */
final class ParallelCollect$ParallelCollectSubscriber<T, C> extends DeferredScalarSubscriber<T, C> {
    private static final long serialVersionUID = -4767392946044436228L;
    C collection;
    final a<? super C, ? super T> collector;
    boolean done;

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, wwc.b
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        C r100 = this.collection;
        this.collection = null;
        complete(r100);
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
        this.collection = null;
        this.downstream.onError(r100);
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, wwc.b
    public void onNext(T r100) {
        if (this.done == false) goto L10;
        return;
    L10:
        this.collector.accept(this.collection, r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        cancel();
        onError(th);
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.g, wwc.b
    public void onSubscribe(c r100) {
        if (SubscriptionHelper.validate(this.upstream, r100) == false) goto L6;
        this.upstream = r100;
        this.downstream.onSubscribe(this);
        r100.request(Long.MAX_VALUE);
        return;
    }

    public ParallelCollect$ParallelCollectSubscriber(b<? super C> r100, C r101, a<? super C, ? super T> r102) {
        super(r100);
        this.collection = r101;
        this.collector = r102;
    }
}
