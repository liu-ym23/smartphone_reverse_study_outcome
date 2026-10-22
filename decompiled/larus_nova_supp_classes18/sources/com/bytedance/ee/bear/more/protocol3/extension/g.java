package com.bytedance.ee.bear.more.protocol3.extension;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g<T> implements Consumer {
    public static final g<T> a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final void accept(Object r4) {
        tt5.a.e("DefMoreInfoBehavior", "retentionFlow err. ", (Throwable) r4, false);
    }
}
