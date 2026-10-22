package com.bytedance.android.shopping.new_cart.slice.viewmanagers;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m {
    public static final String a(Map<String, ? extends Object> r3, String... r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$firstString");
        Intrinsics.checkNotNullParameter(r4, "keys");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        Object r2 = r3.get(r4[r1]);
        if (r2 != null) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return r2.toString();
    L9:
        return null;
    }
}
