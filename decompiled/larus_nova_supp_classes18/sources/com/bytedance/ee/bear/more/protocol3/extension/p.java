package com.bytedance.ee.bear.more.protocol3.extension;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p<T> implements Consumer {
    public static final p<T> a = null;

    static {
        a = new p();
    }

    public p() {
    }

    public final void accept(Object r4) {
        tt5.a.e("DefMoreInfoBehavior", "objInfoFlow, wikiStateFlow err. ", (Throwable) r4, false);
    }
}
