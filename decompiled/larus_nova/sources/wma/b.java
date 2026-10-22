package wma;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f560377a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f560378b = 0;

    public b() {
    }

    static {
        f560377a = new a();
        f560378b = 31;
    }

    public static boolean e(int r100) {
        if ((r100 & f560378b) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        f(r100, 2, r101, null, 24);
    }

    @JvmStatic
    public static final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        f(r100, 16, r101, null, 24);
    }

    @JvmStatic
    public static final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        f(r100, 4, r101, null, 24);
    }

    @JvmStatic
    public static final void g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        f(r100, 1, r101, null, 24);
    }

    @JvmStatic
    public static final void h(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        f(r100, 8, r101, null, 24);
    }

    @JvmStatic
    public static final void c(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        f(r100, 16, r101, r102, 16);
    }

    public static void f(String r100, int r101, String r102, Throwable r103, int r104) {
        if (e(r101) == true) goto L7;
        f560377a.a(r100, r102);
        return;
    }
}
