package com.bytedance.android.livesdk.livecommerce.utils;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e0<T> implements Consumer {
    public final /* synthetic */ f0 a;

    public e0(f0 r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        this.a.b.invoke("file://" + ((String) r4), null);
    }
}
