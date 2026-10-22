package com.bytedance.android.shopping.sku.common.controller.uplink;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public final String a;
    public final String b;

    public c(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "moduleKey");
        Intrinsics.checkNotNullParameter(r3, "triggerType");
        this.a = r2;
        this.b = r3;
    }
}
