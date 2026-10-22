package com.bytedance.android.shopping.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class z {
    public static final /* synthetic */ int a = 0;

    public z() {
    }

    static {
    }

    public static void a(String r1, Throwable r2, String r3) {
        if (r1 == null) goto L9;
        if (r2 == null) goto L10;
        dm.a.b r0 = dm.a.a;
        if (r3 != null) goto L7;
        r3 = "EcomPdp";
    L7:
        dm.a.a(r3).b(r1, r2);
        return;
    L10:
        return;
    }

    public static void b(Object r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "message");
        xh.a r0 = xh.c.a("EcomPdp");
        xh.b r1 = new xh.b();
        r1.c(r3);
        r1.b(r4);
        r1.a(r2);
        r0.f(4, r1);
    }

    public static /* synthetic */ void c(Object r1, String r2, int r3) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        b(r1, r2, null);
    }
}
