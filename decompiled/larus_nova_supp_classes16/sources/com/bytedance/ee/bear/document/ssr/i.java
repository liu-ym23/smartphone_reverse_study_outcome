package com.bytedance.ee.bear.document.ssr;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i<T> implements Consumer {
    public static final i<T> a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final void accept(Object r4) {
        tt5.a.e("SsrDataLoader", "loadDataToCache failed", (Throwable) r4, false);
    }
}
