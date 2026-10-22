package com.bytedance.android.livesdk.livecommerce.room.controller;

import com.bytedance.android.livesdk.livecommerce.network.response.ECEditCartResponse;
import io.reactivex.functions.Consumer;
import vi2.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ v0 a;

    public h(com.bytedance.android.livesdk.livecommerce.iron.helper.m r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        v0 r0 = this.a;
        r0.onSuccess((ECEditCartResponse) r2);
    }
}
