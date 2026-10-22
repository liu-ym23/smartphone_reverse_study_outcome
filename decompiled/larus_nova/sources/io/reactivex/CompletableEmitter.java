package io.reactivex;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes41.dex */
public interface CompletableEmitter {
    boolean isDisposed();

    void onComplete();

    void onError(Throwable r100);

    void setCancellable(ttc.c r100);

    void setDisposable(Disposable r100);

    boolean tryOnError(Throwable r100);
}
