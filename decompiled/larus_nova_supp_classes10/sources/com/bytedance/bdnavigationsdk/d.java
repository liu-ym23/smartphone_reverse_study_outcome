package com.bytedance.bdnavigationsdk;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d {
    public static b a;
    public static final Object b = null;
    public static volatile boolean c;

    static {
        b = new Object();
    }

    public static b a() {
        if (c == false) goto L9;
        b r0 = a;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        return null;
    L10:
        return r0;
    L9:
        throw new Exception("BDNAInit尚未初始化");
    }
}
