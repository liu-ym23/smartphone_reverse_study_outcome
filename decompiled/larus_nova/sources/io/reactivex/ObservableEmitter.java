package io.reactivex;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes41.dex */
public interface ObservableEmitter<T> extends Emitter<T> {
    boolean isDisposed();

    ObservableEmitter<T> serialize();

    void setCancellable(ttc.c r100);

    void setDisposable(Disposable r100);

    boolean tryOnError(Throwable r100);
}
