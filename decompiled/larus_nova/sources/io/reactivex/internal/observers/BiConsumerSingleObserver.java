package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class BiConsumerSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
    private static final long serialVersionUID = 4943102778943297569L;
    final ttc.a<? super T, ? super Throwable> onCallback;

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public BiConsumerSingleObserver(ttc.a<? super T, ? super Throwable> r100) {
        this.onCallback = r100;
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable r100) {
        lazySet(DisposableHelper.DISPOSED);     // Catch: Throwable -> L4
        this.onCallback.accept(null, r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r100, th}));
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable r100) {
        DisposableHelper.setOnce(this, r100);
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T r100) {
        lazySet(DisposableHelper.DISPOSED);     // Catch: Throwable -> L4
        this.onCallback.accept(r100, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
    }
}
