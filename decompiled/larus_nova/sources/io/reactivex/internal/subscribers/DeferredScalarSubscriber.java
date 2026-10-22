package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes41.dex */
public abstract class DeferredScalarSubscriber<T, R> extends DeferredScalarSubscription<R> implements io.reactivex.g<T> {
    private static final long serialVersionUID = 2984505488220891551L;
    protected boolean hasValue;
    protected wwc.c upstream;

    public abstract /* synthetic */ void onNext(T r100);

    public void onComplete() {
        if (this.hasValue == false) goto L5;
        complete(this.value);
        return;
    L5:
        this.downstream.onComplete();
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, wwc.c
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public DeferredScalarSubscriber(wwc.b<? super R> r100) {
        super(r100);
    }

    public void onError(Throwable r100) {
        this.value = null;
        this.downstream.onError(r100);
    }

    public void onSubscribe(wwc.c r100) {
        if (SubscriptionHelper.validate(this.upstream, r100) == false) goto L6;
        this.upstream = r100;
        this.downstream.onSubscribe(this);
        r100.request(Long.MAX_VALUE);
        return;
    }
}
