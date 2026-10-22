package com.bytedance.ee.bear.drive.loader.impl;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g<T> implements Consumer {
    public static final g<T> a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final void accept(Object r3) {
        tt5.a.d("LocalFileLoader", "exe1 err-> " + ((Throwable) r3));
    }
}
