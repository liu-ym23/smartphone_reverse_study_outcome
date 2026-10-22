package io.reactivex.internal.subscribers;

import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes41.dex */
public final class d<T> extends c<T> {
    public d() {
    }

    @Override // wwc.b
    public final void onError(Throwable r100) {
        if (this.f495023a != null) goto L5;
        this.f495024b = r100;
    L6:
        countDown();
        return;
    L5:
        RxJavaPlugins.onError(r100);
        goto L6
    }

    @Override // wwc.b
    public final void onNext(T r100) {
        if (this.f495023a != null) goto L6;
        this.f495023a = r100;
        this.f495025c.cancel();
        countDown();
        return;
    }
}
