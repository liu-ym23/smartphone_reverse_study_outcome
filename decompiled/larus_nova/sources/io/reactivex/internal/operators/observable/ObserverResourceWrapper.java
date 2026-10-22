package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class ObserverResourceWrapper<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -8612022020200669122L;
    final Observer<? super T> downstream;
    final AtomicReference<Disposable> upstream;

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this.upstream.get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        dispose();
        this.downstream.onComplete();
    }

    public ObserverResourceWrapper(Observer<? super T> r100) {
        this.upstream = new AtomicReference();
        this.downstream = r100;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r100) {
        dispose();
        this.downstream.onError(r100);
    }

    @Override // io.reactivex.Observer
    public void onNext(T r100) {
        this.downstream.onNext(r100);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r100) {
        if (DisposableHelper.setOnce(this.upstream, r100) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    public void setResource(Disposable r100) {
        DisposableHelper.set(this, r100);
    }
}
