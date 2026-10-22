package com.bytedance.android.livesdk.livecommerce.room.controller;

import io.reactivex.functions.Consumer;
import vi2.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ v0 a;

    public m(com.bytedance.android.livesdk.livecommerce.room.smallwindow.viewmodel.b r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        v0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.onError(r3);
        return;
    }
}
