package ita;

import com.bytedance.applog.log.n;

/* JADX INFO: loaded from: classes6.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile h f495748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.applog.log.i f495749b = null;

    static {
        f495749b = n.w();
    }

    public static void a(String r100) {
        b(r100, null);
    }

    public static void d(String r100) {
        e(r100);
    }

    public static void e(String r100) {
        h r101 = f495748a;
        if (r101 == null) goto L5;
        r101.i(r100, null);
    L5:
        f495749b.l(r100, new Object[0]);
    }

    public static void f(String r100) {
        h r101 = f495748a;
        if (r101 == null) goto L5;
        r101.v(r100, null);
    L5:
        f495749b.t(r100, new Object[0]);
    }

    public static void b(String r100, Throwable r101) {
        h r102 = f495748a;
        if (r102 == null) goto L5;
        r102.d(r100, r101);
    L5:
        f495749b.j(r100, new Object[0]);
    }

    public static void c(String r100, Throwable r101) {
        h r102 = f495748a;
        if (r102 == null) goto L5;
        r102.e(r100, r101);
    L5:
        f495749b.q(r100, r101, new Object[0]);
    }

    public static void g(String r100, Throwable r101) {
        h r102 = f495748a;
        if (r102 == null) goto L5;
        r102.w(r100, r101);
    L5:
        f495749b.i(r100, new Object[0]);
    }
}
