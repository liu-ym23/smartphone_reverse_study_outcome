package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ k.d a;

    public q(k.d r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        JSONObject r4 = (JSONObject) r3;
        com.bytedance.android.livesdk.ktvimpl.base.sei.f r0 = this.a.a.a;
        if (r0 == null) goto L6;
        r0.a("ktv_hot_info", r4);
        return;
    }
}
