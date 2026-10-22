package io.reactivex;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes41.dex */
public interface SingleObserver<T> {
    void onError(Throwable r100);

    void onSubscribe(Disposable r100);

    void onSuccess(T r100);
}
