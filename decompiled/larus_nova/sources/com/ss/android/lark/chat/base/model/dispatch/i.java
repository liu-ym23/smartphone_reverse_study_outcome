package com.ss.android.lark.chat.base.model.dispatch;

/* JADX INFO: loaded from: classes35.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f411779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f411780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f411781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static PreprocessParams f411782d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f411783e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f411784f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f411785g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f411786h;

    static {
    }

    public static void a() {
        f411779a = 0;
        f411780b = 0;
        f411781c = 0;
        f411782d = null;
        f411783e = false;
        f411784f = 0;
        f411785g = 0;
        f411786h = 0;
    }

    public static void b(boolean r100) {
        long r101 = System.currentTimeMillis();
        if (f411779a != 0) goto L5;
        f411779a = r101;
    L5:
        f411780b = r101;
        if (r100 == false) goto L8;
        f411785g += r101 - f411784f;
        f411786h++;
    L8:
        f411782d = null;
        f411784f = 0;
        f411783e = false;
    }
}
