package io.reactivex;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes41.dex */
public interface b {
    void onComplete();

    void onError(Throwable r100);

    void onSubscribe(Disposable r100);
}
