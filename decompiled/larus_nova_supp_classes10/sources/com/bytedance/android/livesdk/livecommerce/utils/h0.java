package com.bytedance.android.livesdk.livecommerce.utils;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h0 extends a1 {
    public h0(String r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r3, "logId");
        super("enter");
        JSONObject r0 = this.a;
        r0.put("log_id", r3);
        r0.put("toolbar_control", r4 ? 1 : 0);
        r0.put("has_commerce_goods", r5 ? 1 : 0);
        r0.put("room_cart", r6 ? 1 : 0);
        if (r6 == false) goto L5;
        r0.put("room_cart.show_cart", r7 ? 1 : 0);
    L5:
        if (r4 == false) goto L9;
        if (r6 == false) goto L10;
        r0.put("toolbar_equal_cart", r8 ? 1 : 0);
        return;
    L10:
        return;
    }
}
