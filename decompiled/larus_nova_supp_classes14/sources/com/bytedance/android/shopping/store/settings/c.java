package com.bytedance.android.shopping.store.settings;

import com.bytedance.android.ec.core.abtest.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static int a() {
        d r0 = d.a;
        jj4.b r1 = jj4.b.b;
        Object r2 = jj4.a.a("ec_shop_classify_filter_tab", Integer.class, 0, false);
        if (r2 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return ((Number) r2).intValue();
    }

    static {
    }
}
