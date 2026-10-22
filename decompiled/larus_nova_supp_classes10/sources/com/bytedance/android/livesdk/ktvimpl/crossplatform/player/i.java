package com.bytedance.android.livesdk.ktvimpl.crossplatform.player;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ cc0.c a;

    public i(k r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        cc0.c r0 = this.a;
        r0.a((String) r2);
    }
}
