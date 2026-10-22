package io.reactivex.internal.observers;

/* JADX INFO: loaded from: classes41.dex */
public final class d<T> extends c<T> {
    public d() {
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        if (this.f492872a != null) goto L5;
        this.f492873b = r100;
    L5:
        countDown();
    }

    @Override // io.reactivex.Observer
    public final void onNext(T r100) {
        if (this.f492872a != null) goto L6;
        this.f492872a = r100;
        this.f492874c.dispose();
        countDown();
        return;
    }
}
