package com.bytedance.bdnavigationsdk.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(float r2) {
        int r3 = (int) r2;
        int r1 = r3 % 1000;
        if ((r3 / 1000) <= 0) goto L6;
        return b.b(r3 / 1000.0f, 1) + "公里";
    L6:
        return r1 + "米";
    }
}
