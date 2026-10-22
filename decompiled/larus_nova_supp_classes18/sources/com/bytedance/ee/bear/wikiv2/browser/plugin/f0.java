package com.bytedance.ee.bear.wikiv2.browser.plugin;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f0<T> implements Consumer {
    public static final f0<T> a = null;

    static {
        a = new f0();
    }

    public f0() {
    }

    public final void accept(Object r3) {
        tt5.a.d(WikiFolderBlockMorePlugin.TAG, "get perm info failed, error = " + ((Throwable) r3));
    }
}
