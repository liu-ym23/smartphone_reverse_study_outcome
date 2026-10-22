package com.bytedance.ee.bear.document.ssr;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i<T> f221871a = null;

    static {
        f221871a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("SsrDataLoader", "loadDataToCache failed", (Throwable) r100, false);
    }
}
