package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class SequentialDisposable extends AtomicReference<Disposable> implements Disposable {
    private static final long serialVersionUID = -754898800686245608L;

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    public SequentialDisposable() {
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public SequentialDisposable(Disposable r100) {
        lazySet(r100);
    }

    public boolean replace(Disposable r100) {
        return DisposableHelper.replace(this, r100);
    }

    public boolean update(Disposable r100) {
        return DisposableHelper.set(this, r100);
    }
}
