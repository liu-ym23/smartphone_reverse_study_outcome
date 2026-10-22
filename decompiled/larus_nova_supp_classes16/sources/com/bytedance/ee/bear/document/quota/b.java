package com.bytedance.ee.bear.document.quota;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<T> implements Consumer {
    public static final b<T> a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void accept(Object r4) {
        tt5.a.e(ShowQuotaBannerPlugin.TAG, " request  isExceedUserQuota fail ", (Throwable) r4, false);
    }
}
