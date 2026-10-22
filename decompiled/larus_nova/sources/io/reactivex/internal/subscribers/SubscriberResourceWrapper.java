package io.reactivex.internal.subscribers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class SubscriberResourceWrapper<T> extends AtomicReference<Disposable> implements io.reactivex.g<T>, Disposable, wwc.c {
    private static final long serialVersionUID = -8612022020200669122L;
    final wwc.b<? super T> downstream;
    final AtomicReference<wwc.c> upstream;

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        SubscriptionHelper.cancel(this.upstream);
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this.upstream.get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // wwc.b
    public void onComplete() {
        DisposableHelper.dispose(this);
        this.downstream.onComplete();
    }

    @Override // wwc.c
    public void cancel() {
        dispose();
    }

    public SubscriberResourceWrapper(wwc.b<? super T> r100) {
        this.upstream = new AtomicReference();
        this.downstream = r100;
    }

    @Override // wwc.b
    public void onError(Throwable r100) {
        DisposableHelper.dispose(this);
        this.downstream.onError(r100);
    }

    @Override // wwc.b
    public void onNext(T r100) {
        this.downstream.onNext(r100);
    }

    @Override // io.reactivex.g, wwc.b
    public void onSubscribe(wwc.c r100) {
        if (SubscriptionHelper.setOnce(this.upstream, r100) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // wwc.c
    public void request(long r100) {
        if (SubscriptionHelper.validate(r100) == false) goto L6;
        this.upstream.get().request(r100);
        return;
    }

    public void setResource(Disposable r100) {
        DisposableHelper.set(this, r100);
    }
}
