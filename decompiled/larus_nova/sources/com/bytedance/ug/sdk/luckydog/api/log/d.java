package com.bytedance.ug.sdk.luckydog.api.log;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f271582a = 6;

    public static void a(String r100, String r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (f271582a <= 3) goto L7;
    L7:
        LuckyDogALogHelper.f271580c.getClass();
        LuckyDogALogHelper.a(3, "LuckyDogLogger_" + r100, r101, null);
    }

    public static void b(String r100, String r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (f271582a <= 6) goto L7;
    L7:
        a.a("LuckyDogLogger_" + r100, r101);
    }

    public static void d(String r100, String r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (f271582a <= 4) goto L7;
    L7:
        a.c("LuckyDogLogger_" + r100, r101);
    }

    public static void e(String r100, String r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (f271582a <= 5) goto L7;
    L7:
        LuckyDogALogHelper.f271580c.getClass();
        LuckyDogALogHelper.a(5, "LuckyDogLogger_" + r100, r101, null);
    }

    public static void c(String r100, String r101, Throwable r102) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (f271582a <= 6) goto L7;
    L7:
        a.b("LuckyDogLogger_" + r100, r101, r102);
    }
}
