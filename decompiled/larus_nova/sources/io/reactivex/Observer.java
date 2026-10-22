package io.reactivex;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes41.dex */
public interface Observer<T> {
    void onComplete();

    void onError(Throwable r100);

    void onNext(T r100);

    void onSubscribe(Disposable r100);
}
