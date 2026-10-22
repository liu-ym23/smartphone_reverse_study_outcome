package com.bytedance.bdnavigationsdk.utils;

/* JADX INFO: loaded from: classes10.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f200379a = 0;

    static {
    }

    public static String a(float r100) {
        int r101 = (int) r100;
        int r102 = r101 % 1000;
        if ((r101 / 1000) <= 0) goto L6;
        return b.b(r101 / 1000.0f, 1) + "公里";
    L6:
        return r102 + "米";
    }
}
