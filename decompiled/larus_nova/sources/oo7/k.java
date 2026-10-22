package oo7;

/* JADX INFO: loaded from: classes22.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f524625a = 4;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f524626b = null;

    public static abstract class a {
        public a() {
        }
    }

    public static class b extends a {

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f524627a = null;

            static {
                f524627a = new b();
            }
        }

        public b() {
        }
    }

    static {
        f524626b = b.a.f524627a;
    }

    public static void b(String r100) {
        c("Logger", r100);
    }

    public static void f(Throwable r100) {
        r100.printStackTrace();
        if (f524625a > 3) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        return;
    L9:
        throw new RuntimeException("Error! Now in debug, we alert to you to correct it !", r100);
    L5:
        r101 = false;
        goto L6
    }

    public static void a(String r100, String r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        f524626b.getClass();
        jn7.d r102 = eo7.a.b.f473353a.f473335i;
        if (r102 == null) goto L8;
        r102.a(r100, r101);
        return;
    }

    public static void c(String r100, String r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        f524626b.getClass();
        jn7.d r102 = eo7.a.b.f473353a.f473335i;
        if (r102 == null) goto L8;
        r102.a(r100, r101);
        return;
    }

    public static void e(String r100, String r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        f524626b.getClass();
        jn7.d r102 = eo7.a.b.f473353a.f473335i;
        if (r102 == null) goto L8;
        r102.a(r100, r101);
        return;
    }

    public static void d(String r100, String r101, Throwable r102) {
        f524626b.getClass();
        jn7.d r103 = eo7.a.b.f473353a.f473335i;
        if (r103 == null) goto L6;
        r103.a(r100, r101);
        return;
    }
}
