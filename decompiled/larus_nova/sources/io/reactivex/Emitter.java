package io.reactivex;

/* JADX INFO: loaded from: classes41.dex */
public interface Emitter<T> {
    void onComplete();

    void onError(Throwable r100);

    void onNext(T r100);
}
