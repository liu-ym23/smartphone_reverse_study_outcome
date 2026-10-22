package com.bytedance.ee.bear.document.quota;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T> f221252a = null;

    static {
        f221252a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e(ShowQuotaBannerPlugin.TAG, " request  isExceedUserQuota fail ", (Throwable) r100, false);
    }
}
