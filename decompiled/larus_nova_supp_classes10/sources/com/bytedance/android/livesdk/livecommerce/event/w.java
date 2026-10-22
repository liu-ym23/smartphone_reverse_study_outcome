package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.bdlocation.exception.BDLocationException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w extends ECEventV3 {
    public w(String r2, String r3, long r4, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "productType");
        super("livesdk_create_product_duration");
        f("anchor_id", r2);
        f("room_id", r3);
        f("duration", String.valueOf(r4));
        f("live_product_type", r6);
        if (r7 == false) goto L5;
        String r5 = "1";
    L6:
        f("has_aftersale_insurance", r5);
        return;
    L5:
        r5 = BDLocationException.ERROR_TIMEOUT;
        goto L6
    }
}
