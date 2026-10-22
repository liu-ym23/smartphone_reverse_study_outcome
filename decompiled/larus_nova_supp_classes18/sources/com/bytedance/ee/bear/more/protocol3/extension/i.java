package com.bytedance.ee.bear.more.protocol3.extension;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i<T> implements Consumer {
    public static final i<T> a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final void accept(Object r4) {
        tt5.a.e("DefMoreInfoBehavior", "feedShortcutFlow err. ", (Throwable) r4, false);
    }
}
