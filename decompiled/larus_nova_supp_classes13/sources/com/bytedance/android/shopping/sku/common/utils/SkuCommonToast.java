package com.bytedance.android.shopping.sku.common.utils;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuCommonToast {
    public static final /* synthetic */ int a = 0;

    public SkuCommonToast() {
    }

    static {
    }

    public static void a(final String r1) {
        e.a r0 = e.a;
        e.b(new SkuCommonToast$debugShowToast$1(r1));
    }

    public static void c(String r3) {
        e.a r0 = e.a;
        e.b(new SkuCommonToast$showToast$1(null, r3, false));
    }

    public static void b(Context r2, String r3) {
        e.a r0 = e.a;
        e.b(new SkuCommonToast$showToast$1(r2, r3, false));
    }
}
