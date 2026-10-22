package com.bytedance.android.livesdk.live.listprovider;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d<T> implements Consumer {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final void accept(Object r1) {
        ((Throwable) r1).printStackTrace();
    }
}
