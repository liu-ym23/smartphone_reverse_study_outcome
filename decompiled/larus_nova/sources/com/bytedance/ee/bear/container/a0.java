package com.bytedance.ee.bear.container;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class a0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a0<T> f216743a = null;

    static {
        f216743a = new a0();
    }

    public a0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ((wwc.c) r100).request(Long.MAX_VALUE);
    }
}
