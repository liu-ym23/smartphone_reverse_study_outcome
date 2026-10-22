package com.xiaomi.push;

import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes41.dex */
final class el {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        eh f463485a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        String f502a;

        public a() {
        }
    }

    public static a a(Exception r100) {
        m9048a(r100);
        boolean r101 = r100 instanceof fh;
        Throwable r102 = r100;
        if (r101 == false) goto L7;
        fh r103 = (fh) r100;
        r102 = r100;
        if (r103.a() == null) goto L7;
        r102 = r103.a();
    L7:
        a r104 = new a();
        String r105 = r102.getMessage();
        if (r102.getCause() == null) goto L10;
        r105 = r102.getCause().getMessage();
    L10:
        String r106 = r102.getClass().getSimpleName() + ":" + r105;
        int r107 = fb.a(r102);
        if (r107 == 0) goto L14;
        r104.f463485a = eh.a(eh.f463454l.a() + r107);
    L14:
        if (r104.f463485a != null) goto L17;
        r104.f463485a = eh.f463462t;
    L17:
        if (r104.f463485a != eh.f463462t) goto L19;
        r104.f502a = r106;
    L19:
        return r104;
    }

    public static a b(Exception r100) {
        m9048a(r100);
        boolean r101 = r100 instanceof fh;
        Throwable r102 = r100;
        if (r101 == false) goto L7;
        fh r103 = (fh) r100;
        r102 = r100;
        if (r103.a() == null) goto L7;
        r102 = r103.a();
    L7:
        a r104 = new a();
        String r105 = r102.getMessage();
        if (r102.getCause() == null) goto L10;
        r105 = r102.getCause().getMessage();
    L10:
        int r106 = fb.a(r102);
        String r107 = r102.getClass().getSimpleName() + ":" + r105;
        if (r106 == 0) goto L19;
        eh r108 = eh.a(eh.f463464v.a() + r106);
        r104.f463485a = r108;
        if (r108 != eh.G) goto L20;
        Throwable r109 = r102.getCause();
        if (r109 == null) goto L20;
        if ((r109 instanceof UnknownHostException) == false) goto L20;
        r104.f463485a = eh.F;
    L20:
        eh r110 = r104.f463485a;
        if (r110 != eh.D) goto L23;
    L26:
        r104.f502a = r107;
    L27:
        return r104;
    L23:
        if (r110 == eh.E) goto L26;
        if (r110 != eh.G) goto L27;
    L19:
        r104.f463485a = eh.E;
        goto L20
    }

    public static a c(Exception r100) {
        m9048a(r100);
        boolean r101 = r100 instanceof fh;
        Throwable r102 = r100;
        if (r101 == false) goto L7;
        fh r103 = (fh) r100;
        r102 = r100;
        if (r103.a() == null) goto L7;
        r102 = r103.a();
    L7:
        a r104 = new a();
        String r105 = r102.getMessage();
        if (r102.getCause() == null) goto L10;
        r105 = r102.getCause().getMessage();
    L10:
        int r106 = fb.a(r102);
        String r107 = r102.getClass().getSimpleName() + ":" + r105;
        if (r106 != 105) goto L13;
        r104.f463485a = eh.L;
    L28:
        eh r108 = r104.f463485a;
        if (r108 != eh.O) goto L31;
    L34:
        r104.f502a = r107;
    L35:
        return r104;
    L31:
        if (r108 == eh.P) goto L34;
        if (r108 != eh.R) goto L35;
    L13:
        if (r106 != 199) goto L15;
        r104.f463485a = eh.O;
        goto L28
    L15:
        if (r106 != 499) goto L17;
        r104.f463485a = eh.R;
        if (r105.startsWith("Terminal binding condition encountered: item-not-found") == false) goto L28;
        r104.f463485a = eh.Q;
        goto L28
    L17:
        if (r106 != 109) goto L19;
        r104.f463485a = eh.M;
        goto L28
    L19:
        if (r106 == 110) goto L21;
        r104.f463485a = eh.P;
        goto L28
    L21:
        r104.f463485a = eh.N;
        goto L28
    }

    public static a d(Exception r100) {
        m9048a(r100);
        boolean r101 = r100 instanceof fh;
        Throwable r102 = r100;
        if (r101 == false) goto L7;
        fh r103 = (fh) r100;
        r102 = r100;
        if (r103.a() == null) goto L7;
        r102 = r103.a();
    L7:
        a r104 = new a();
        String r105 = r102.getMessage();
        int r106 = fb.a(r102);
        String r107 = r102.getClass().getSimpleName() + ":" + r105;
        if (r106 != 105) goto L10;
        r104.f463485a = eh.X;
    L25:
        eh r108 = r104.f463485a;
        if (r108 != eh.f463439aa) goto L28;
    L31:
        r104.f502a = r107;
    L32:
        return r104;
    L28:
        if (r108 == eh.f463440ab) goto L31;
        if (r108 != eh.f463442ad) goto L32;
    L10:
        if (r106 != 199) goto L12;
        r104.f463485a = eh.f463439aa;
        goto L25
    L12:
        if (r106 != 499) goto L14;
        r104.f463485a = eh.f463442ad;
        if (r105.startsWith("Terminal binding condition encountered: item-not-found") == false) goto L25;
        r104.f463485a = eh.f463441ac;
        goto L25
    L14:
        if (r106 != 109) goto L16;
        r104.f463485a = eh.Y;
        goto L25
    L16:
        if (r106 == 110) goto L18;
        r104.f463485a = eh.f463440ab;
        goto L25
    L18:
        r104.f463485a = eh.Z;
        goto L25
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static void m9048a(Exception r100) {
        if (r100 == null) goto L5;
        return;
    L5:
        throw null;
    }
}
