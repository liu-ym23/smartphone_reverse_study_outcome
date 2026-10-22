package com.bytedance.android.window.shop.repository.tab.entity;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s {
    public static final String a(f r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$getUniqueId");
        String r0 = r1.c;
        if (r0 != null) goto L6;
        fo.b r2 = r1.f;
        fo.a<Map<String, String>> r3 = m0.a;
        return (String) r2.a(m0.c);
    L6:
        return r0;
    }

    public static final boolean b(f r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isDynamicInserted");
        if ((r2 instanceof n) == false) goto L6;
        return true;
    L6:
        if (r2.a != null) goto L10;
        return false;
    L10:
        return true;
    }

    public static final void c(f r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$setCardPosition");
        fo.b r0 = r3.f;
        fo.a<Map<String, String>> r1 = m0.a;
        r0.d(m0.e, Integer.valueOf(r4));
        if ((r3 instanceof n) == false) goto L6;
        n r5 = (n) r3;
        c(r5.k, r4);
        c(r5.l, r4 + 1);
        return;
    }
}
