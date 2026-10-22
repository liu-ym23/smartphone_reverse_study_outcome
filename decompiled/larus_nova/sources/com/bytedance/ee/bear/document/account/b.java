package com.bytedance.ee.bear.document.account;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T> f218674a = null;

    static {
        f218674a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("DocumentAccountPlugin", "GetCurrentAccountHandler failed, " + ((Throwable) r100));
    }
}
