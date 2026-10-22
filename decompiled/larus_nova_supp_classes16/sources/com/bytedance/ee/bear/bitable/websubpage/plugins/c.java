package com.bytedance.ee.bear.bitable.websubpage.plugins;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<T> implements Consumer {
    public static final c<T> a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final void accept(Object r2) {
        String r3 = (String) r2;
        tt5.a.h("ContactServicePlugin", " goToCustomService Success ");
    }
}
