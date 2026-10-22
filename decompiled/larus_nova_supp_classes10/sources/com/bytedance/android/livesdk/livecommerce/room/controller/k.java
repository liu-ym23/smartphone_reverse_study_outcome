package com.bytedance.android.livesdk.livecommerce.room.controller;

import io.reactivex.functions.Consumer;
import vi2.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ v0 a;

    public k(com.bytedance.android.livesdk.livecommerce.room.controller.business.n.b r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        v0 r4 = this.a;
        if (r4 == null) goto L6;
        r4.onError(null);
        return;
    }
}
