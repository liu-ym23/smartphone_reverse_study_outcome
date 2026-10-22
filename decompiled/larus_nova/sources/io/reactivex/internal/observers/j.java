package io.reactivex.internal.observers;

/* JADX INFO: loaded from: classes41.dex */
public interface j<T> {
    void drain();

    void innerComplete(InnerQueuedObserver<T> r100);

    void innerError(InnerQueuedObserver<T> r100, Throwable r101);

    void innerNext(InnerQueuedObserver<T> r100, T r101);
}
