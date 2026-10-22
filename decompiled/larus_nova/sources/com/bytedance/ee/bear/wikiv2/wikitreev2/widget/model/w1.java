package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class w1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w1<T> f242144a = null;

    static {
        f242144a = new w1();
    }

    public w1() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("Wiki_WikiTreeRepository", "delNodes, delCachedStatus err. ", (Throwable) r100, false);
    }
}
