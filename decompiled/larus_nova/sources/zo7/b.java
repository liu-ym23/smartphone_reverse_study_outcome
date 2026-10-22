package zo7;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static xo7.a f573134a;

    public static boolean e() {
        if (f573134a == null) goto L5;
        return true;
    L5:
        xo7.a r100 = bp7.a.C0335a.f19983a.f19982e;
        if (r100 == null) goto L9;
        f573134a = r100;
        return true;
    L9:
        return false;
    }

    public static void a(String r100, String r101) {
        if (e() == false) goto L6;
        f573134a.d("YZ_ALOG_" + r100, r101);
        return;
    }

    public static void b(String r100, String r101) {
        if (e() == false) goto L6;
        f573134a.e("YZ_ALOG_".concat(r100), r101);
        return;
    }

    public static void d(String r100, String r101) {
        if (e() == false) goto L6;
        f573134a.i("YZ_ALOG_".concat(r100), r101);
        return;
    }

    public static void c(String r100, String r101, Throwable r102) {
        if (e() == false) goto L6;
        f573134a.e("YZ_ALOG_".concat(r100), r101, r102);
        return;
    }
}
