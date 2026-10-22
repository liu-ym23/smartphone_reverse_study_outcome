package com.bytedance.android.livesdk.livecommerce.promotionlist.utils.instant;

import android.util.LruCache;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public final LruCache<String, Map<String, Long>> a;

    public static final class a {
    }

    static {
    }

    public b() {
        this.a = new LruCache(10);
    }

    public final Long a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "productId");
        Intrinsics.checkNotNullParameter("operation_start_time", "event");
        Map<String, Long> r4 = this.a.get(r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.get("operation_start_time");
    }
}
