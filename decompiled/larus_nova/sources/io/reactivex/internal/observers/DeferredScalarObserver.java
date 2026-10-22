package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes41.dex */
public abstract class DeferredScalarObserver<T, R> extends DeferredScalarDisposable<R> implements Observer<T> {
    private static final long serialVersionUID = -266195175408988651L;
    protected Disposable upstream;

    @Override // io.reactivex.Observer
    public void onComplete() {
        T r100 = this.value;
        if (r100 == null) goto L5;
        this.value = null;
        complete(r100);
        return;
    L5:
        complete();
    }

    @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
    public void dispose() {
        super.dispose();
        this.upstream.dispose();
    }

    public DeferredScalarObserver(Observer<? super R> r100) {
        super(r100);
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r100) {
        this.value = null;
        error(r100);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r100) {
        if (DisposableHelper.validate(this.upstream, r100) == false) goto L6;
        this.upstream = r100;
        this.downstream.onSubscribe(this);
        return;
    }
}
