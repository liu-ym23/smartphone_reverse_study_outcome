package mi7;

import ci7.p;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static void a(String r100, String r101) {
        d(3, r100, r101, null);
    }

    public static void b(String r100, String r101) {
        d(6, r100, r101, null);
    }

    public static void c(String r100, String r101) {
        d(4, r100, r101, null);
    }

    public static void d(int r100, String r101, String r102, Throwable r103) {
        if (p.a() == null) goto L6;
        p.a().log(r100, "ZlinkApi_" + r101, r102, r103);
        return;
    }
}
