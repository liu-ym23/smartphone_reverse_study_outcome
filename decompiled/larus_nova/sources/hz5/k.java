package hz5;

import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static h f487696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f487697b;

    @JvmStatic
    public static final void a(String r100, String r101) {
        b(r100, r101);
    }

    @JvmStatic
    public static final void c(String r100, String r101) {
        d(r100, r101);
    }

    static {
        f487697b = 1;
    }

    public static void b(String r100, String r101) {
        if (1 < f487697b) goto L7;
        h r102 = f487696a;
        if (r102 == null) goto L7;
        r102.d(r100, r101, null);
    L7:
        fz5.b.c().f();
    }

    public static void d(String r100, String r101) {
        if (3 < f487697b) goto L7;
        h r102 = f487696a;
        if (r102 == null) goto L7;
        r102.i(r100, r101, null);
    L7:
        fz5.b.c().f();
    }

    @JvmStatic
    public static final void e(String r100, String r101, Throwable r102) {
        if (4 < f487697b) goto L7;
        h r103 = f487696a;
        if (r103 == null) goto L7;
        r103.w(r100, r101, r102);
    L7:
        fz5.b.c().f();
    }
}
