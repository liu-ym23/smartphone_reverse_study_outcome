package android.ss.com.vboost.h;

import android.content.Context;
import android.ss.com.vboost.utils.LogUtil;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f72a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static c f73b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static e.a f74c;
    private static boolean d;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f75a = null;

        static {
            int[] r0 = new int[e.a.values().length];
            f75a = r0;
            r0[e.a.f80c.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f75a[e.a.f79b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f75a[e.a.d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        f74c = e.a.f81f;
        d = false;
    }

    public static e.a a() {
        return f74c;
    }

    public static void a(long r1) {
        f73b.a(r1);
    }

    public static boolean a(Context r4) {
        f74c = e.b();
        int r0 = a.f75a[f74c.ordinal()];
        if (r0 != 1) goto L5;
        c r1 = new f();
    L12:
        f73b = r1;
    L13:
        c r2 = f73b;
        if (r2 != null) goto L16;
        return false;
    L16:
        if (r2.a(r4) == false) goto L21;
        d = true;
        return true;
    L21:
        return false;
    L5:
        if (r0 != 2) goto L7;
        r1 = new i();
        goto L12
    L7:
        if (r0 == 3) goto L9;
        LogUtil.error(f72a, "Platform " + f74c + " not support!");
        goto L13
    L9:
        r1 = new b();
        goto L12
    }

    public static void b(long r1) {
        f73b.b(r1);
    }

    public static boolean b() {
        return d;
    }

    public static void c() {
        f73b.a();
    }

    public static void c(long r1) {
        f73b.c(r1);
    }

    public static void d() {
        f73b.b();
    }
}
