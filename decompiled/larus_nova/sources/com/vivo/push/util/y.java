package com.vivo.push.util;

/* JADX INFO: loaded from: classes41.dex */
public final class y {
    public static int a(com.vivo.push.b.c r110) {
        ad r100 = ad.c();
        int r101 = r110.b();
        long r102 = System.currentTimeMillis();
        int r103 = r100.b("com.vivo.push_preferences.operate." + r101 + "OPERATE_COUNT", 0);
        long r104 = r102 - r100.b("com.vivo.push_preferences.operate." + r101 + "START_TIME", 0);
        if (r104 <= 86400000) goto L5;
    L12:
        r100.a("com.vivo.push_preferences.operate." + r101 + "START_TIME", System.currentTimeMillis());
        r100.a("com.vivo.push_preferences.operate." + r101 + "OPERATE_COUNT", 1);
    L13:
        return 0;
    L5:
        if (r104 < 0) goto L12;
        if (r103 < r110.e()) goto L11;
        return 1001;
    L11:
        r100.a("com.vivo.push_preferences.operate." + r101 + "OPERATE_COUNT", r103 + 1);
        goto L13
    }
}
