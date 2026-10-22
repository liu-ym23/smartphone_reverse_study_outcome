package com.bytedance.android.livesdk.livecommerce.utils;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u0 extends a1 {
    public u0(boolean r4, String r5) {
        Intrinsics.checkNotNullParameter("", "logId");
        super("promotions");
        JSONObject r0 = this.a;
        r0.put("log_id", "");
        if (r5 == null) goto L5;
        r0.put("error", r5);
    L5:
        r0.put("show_cart", r4 ? 1 : 0);
    }
}
