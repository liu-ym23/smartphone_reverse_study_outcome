package com.bytedance.ee.bear.more.protocol3.extension;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k<T> implements Consumer {
    public static final k<T> a = null;

    static {
        a = new k();
    }

    public k() {
    }

    public final void accept(Object r4) {
        tt5.a.e("DefMoreInfoBehavior", "metaFlow err. ", (Throwable) r4, false);
    }
}
