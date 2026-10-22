package com.bytedance.android.shopping.buynow.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object a(nl.c r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "fieldName");
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getQueryParam(r2);
    }
}
