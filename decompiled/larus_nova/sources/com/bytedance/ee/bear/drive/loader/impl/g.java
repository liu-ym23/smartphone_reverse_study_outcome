package com.bytedance.ee.bear.drive.loader.impl;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g<T> f224476a = null;

    static {
        f224476a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("LocalFileLoader", "exe1 err-> " + ((Throwable) r100));
    }
}
