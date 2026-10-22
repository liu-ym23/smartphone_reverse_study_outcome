package com.bytedance.ee.bear.bitable.websubpage.plugins;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<T> f216304a = null;

    static {
        f216304a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("ContactServicePlugin", " goToCustomService Fail", (Throwable) r100, false);
    }
}
