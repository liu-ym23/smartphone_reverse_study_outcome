package io.reactivex.internal.subscriptions;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import wwc.c;

/* JADX INFO: loaded from: classes41.dex */
public final class AsyncSubscription extends AtomicLong implements c, Disposable {
    private static final long serialVersionUID = 7028635084060361255L;
    final AtomicReference<c> actual;
    final AtomicReference<Disposable> resource;

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        SubscriptionHelper.cancel(this.actual);
        DisposableHelper.dispose(this.resource);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this.actual.get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    public AsyncSubscription() {
        this.resource = new AtomicReference();
        this.actual = new AtomicReference();
    }

    @Override // wwc.c
    public void cancel() {
        dispose();
    }

    public AsyncSubscription(Disposable r100) {
        this();
        this.resource.lazySet(r100);
    }

    public boolean replaceResource(Disposable r100) {
        return DisposableHelper.replace(this.resource, r100);
    }

    @Override // wwc.c
    public void request(long r100) {
        SubscriptionHelper.deferredRequest(this.actual, this, r100);
    }

    public boolean setResource(Disposable r100) {
        return DisposableHelper.set(this.resource, r100);
    }

    public void setSubscription(c r100) {
        SubscriptionHelper.deferredSetOnce(this.actual, this, r100);
    }
}
