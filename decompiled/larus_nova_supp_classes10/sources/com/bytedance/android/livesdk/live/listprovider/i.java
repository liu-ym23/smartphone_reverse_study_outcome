package com.bytedance.android.livesdk.live.listprovider;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i<T> implements Consumer {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final void accept(Object r1) {
        ((Throwable) r1).printStackTrace();
    }
}
