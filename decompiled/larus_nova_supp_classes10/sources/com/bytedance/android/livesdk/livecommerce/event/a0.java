package com.bytedance.android.livesdk.livecommerce.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a0 extends ECEventV3 {

    public static final class a {
    }

    static {
    }

    public a0(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "productType");
        super("livesdk_create_product_buynow_auto_code_show");
        f("anchor_id", r2);
        f("room_id", r3);
        f("live_product_type", r4);
    }
}
