package io.reactivex.internal.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class EmptyCompletableObserver extends AtomicReference<Disposable> implements io.reactivex.b, Disposable {
    private static final long serialVersionUID = -7545121636549663526L;

    public boolean hasCustomOnError() {
        return false;
    }

    @Override // io.reactivex.b
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    public EmptyCompletableObserver() {
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.b
    public void onError(Throwable r100) {
        lazySet(DisposableHelper.DISPOSED);
        RxJavaPlugins.onError(new OnErrorNotImplementedException(r100));
    }

    @Override // io.reactivex.b
    public void onSubscribe(Disposable r100) {
        DisposableHelper.setOnce(this, r100);
    }
}
