package com.bytedance.android.shopping.sku.common.controller;

import android.util.LruCache;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuRunCatchExtKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuCommonBigPicCacheController {
    public static final a a = null;

    public static final class a extends LruCache<String, b> {
        public a() {
            super(10);
        }
    }

    static {
        a = new a();
    }

    public static b a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "productId");
        return a.get(r1);
    }

    public static void b(final String r1, final boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "productId");
        SkuRunCatchExtKt.a(null, "SkuCommonBigPicCacheController", new SkuCommonBigPicCacheController$putCurrentBigPicMode$1(r1, r2));
    }
}
