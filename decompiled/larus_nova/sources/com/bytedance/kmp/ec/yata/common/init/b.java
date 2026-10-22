package com.bytedance.kmp.ec.yata.common.init;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PackYataSdkConfig f251424a;

    static {
    }

    public static PackYataSdkConfig a() {
        PackYataSdkConfig r100 = f251424a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100;
    }

    public static boolean b() {
        PackYataSdkConfig r100 = a();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.b() != true) goto L7;
        return true;
    }
}
