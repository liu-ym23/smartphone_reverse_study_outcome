package com.bytedance.ee.bear.bitable.websubpage.plugins;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T> f216303a = null;

    static {
        f216303a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        tt5.a.h("ContactServicePlugin", " goToCustomService Success ");
    }
}
