package com.bytedance.bdnavigationsdk;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f200007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f200008b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f200009c;

    static {
        f200008b = new Object();
    }

    public static b a() {
        if (f200009c == false) goto L9;
        b r100 = f200007a;
        if (r100 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        return null;
    L10:
        return r100;
    L9:
        throw new Exception("BDNAInit尚未初始化");
    }
}
