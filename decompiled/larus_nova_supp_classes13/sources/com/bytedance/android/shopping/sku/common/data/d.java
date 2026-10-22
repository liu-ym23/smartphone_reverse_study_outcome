package com.bytedance.android.shopping.sku.common.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public final String a;
    public final String b;
    public final String c;

    public d(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "specName");
        Intrinsics.checkNotNullParameter(r4, "specItemId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
