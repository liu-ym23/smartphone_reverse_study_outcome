package com.bytedance.ee.bear.document;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f5<T> implements Consumer {
    public static final f5<T> a = null;

    static {
        a = new f5();
    }

    public f5() {
    }

    public final void accept(Object r3) {
        tt5.a.d(ImageResDeletePlugin.TAG, "exception " + ((Throwable) r3).getMessage());
    }
}
