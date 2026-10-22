package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w1<T> implements Consumer {
    public static final w1<T> a = null;

    static {
        a = new w1();
    }

    public w1() {
    }

    public final void accept(Object r4) {
        tt5.a.e("Wiki_WikiTreeRepository", "delNodes, delCachedStatus err. ", (Throwable) r4, false);
    }
}
