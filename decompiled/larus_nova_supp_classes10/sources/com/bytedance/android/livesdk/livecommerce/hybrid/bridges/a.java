package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a<T> implements Consumer {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        dm.a.a("ECAnchorFlashUploadImage").b("request error", null);
    }
}
