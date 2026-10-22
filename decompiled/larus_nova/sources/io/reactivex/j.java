package io.reactivex;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes41.dex */
public interface j<T> {
    void onComplete();

    void onError(Throwable r100);

    void onSuccess(T r100);

    void setDisposable(Disposable r100);
}
