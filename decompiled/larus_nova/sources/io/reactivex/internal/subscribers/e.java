package io.reactivex.internal.subscribers;

/* JADX INFO: loaded from: classes41.dex */
public final class e<T> extends c<T> {
    public e() {
    }

    @Override // wwc.b
    public final void onError(Throwable r100) {
        this.f495023a = null;
        this.f495024b = r100;
        countDown();
    }

    @Override // wwc.b
    public final void onNext(T r100) {
        this.f495023a = r100;
    }
}
