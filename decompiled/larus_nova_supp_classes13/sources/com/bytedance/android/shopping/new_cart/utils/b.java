package com.bytedance.android.shopping.new_cart.utils;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final Object a(Object r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        if ((r2 instanceof Map) == true) goto L5;
        r2 = null;
    L5:
        Map r4 = (Map) r2;
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4.get(r3);
    }
}
