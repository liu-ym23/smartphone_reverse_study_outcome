package com.bytedance.android.shopping.sku.inner.controller;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public final com.bytedance.android.shopping.sku.inner.container.b a;

    public e(com.bytedance.android.shopping.sku.inner.container.b r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final int a(int r2) {
        if (r2 >= 50) goto L5;
    L6:
        r2 = 73;
    L7:
        int r0 = com.bytedance.android.shopping.sku.common.utils.c.a;
        return (int) ((r2 / 100.0f) * com.bytedance.android.shopping.sku.common.utils.c.a(this.a.P2()).b);
    L5:
        if (r2 <= 100) goto L7;
        goto L6
    }
}
