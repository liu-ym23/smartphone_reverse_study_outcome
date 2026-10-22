package io.reactivex.internal.subscribers;

/* JADX INFO: loaded from: classes41.dex */
public interface g<T> {
    void drain();

    void innerComplete(InnerQueuedSubscriber<T> r100);

    void innerError(InnerQueuedSubscriber<T> r100, Throwable r101);

    void innerNext(InnerQueuedSubscriber<T> r100, T r101);
}
