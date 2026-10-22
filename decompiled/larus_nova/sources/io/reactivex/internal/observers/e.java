package io.reactivex.internal.observers;

/* JADX INFO: loaded from: classes41.dex */
public final class e<T> extends c<T> {
    public e() {
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        this.f492872a = null;
        this.f492873b = r100;
        countDown();
    }

    @Override // io.reactivex.Observer
    public final void onNext(T r100) {
        this.f492872a = r100;
    }
}
