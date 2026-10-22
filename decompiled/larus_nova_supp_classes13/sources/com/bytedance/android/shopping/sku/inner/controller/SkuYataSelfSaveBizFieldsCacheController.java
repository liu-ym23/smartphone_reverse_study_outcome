package com.bytedance.android.shopping.sku.inner.controller;

import android.util.LruCache;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuRunCatchExtKt;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuYataSelfSaveBizFieldsCacheController {
    public static final a a = null;

    public static final class a extends LruCache<String, HashMap<String, Object>> {
        public a() {
            super(10);
        }
    }

    static {
        a = new a();
    }

    public static Map a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "promotionId");
        return a.get(r1);
    }

    public static void b(final String r1, final Map r2) {
        Intrinsics.checkNotNullParameter(r1, "promotionId");
        Intrinsics.checkNotNullParameter(r2, "map");
        SkuRunCatchExtKt.a(null, "SkuYataTradeModeCacheController", new SkuYataSelfSaveBizFieldsCacheController$putCurrentSaveData$1(r1, r2));
    }
}
