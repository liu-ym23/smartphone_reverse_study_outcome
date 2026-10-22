package com.bytedance.android.livesdk.ktvimpl.chorus;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h<T> implements Consumer {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public final void accept(Object r3) {
        a.a("ChorusWidget", "closeChorus failed " + ((Throwable) r3).getMessage());
    }
}
