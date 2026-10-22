package com.bytedance.ee.bear.container;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a0<T> implements Consumer {
    public static final a0<T> a = null;

    static {
        a = new a0();
    }

    public a0() {
    }

    public final void accept(Object r3) {
        ((wwc.c) r3).request(Long.MAX_VALUE);
    }
}
