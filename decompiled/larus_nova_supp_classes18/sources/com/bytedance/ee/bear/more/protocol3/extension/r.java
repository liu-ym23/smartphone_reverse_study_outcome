package com.bytedance.ee.bear.more.protocol3.extension;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r<T> implements Consumer {
    public static final r<T> a = null;

    static {
        a = new r();
    }

    public r() {
    }

    public final void accept(Object r4) {
        tt5.a.e("DefMoreInfoBehavior", "permFlow err. ", (Throwable) r4, false);
    }
}
