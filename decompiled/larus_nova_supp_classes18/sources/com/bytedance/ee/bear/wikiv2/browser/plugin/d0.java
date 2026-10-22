package com.bytedance.ee.bear.wikiv2.browser.plugin;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d0<T> implements Consumer {
    public static final d0<T> a = null;

    static {
        a = new d0();
    }

    public d0() {
    }

    public final void accept(Object r4) {
        tt5.a.e(WikiFolderBlockMorePlugin.TAG, "requestOriginTitle fail. ", (Throwable) r4, false);
    }
}
