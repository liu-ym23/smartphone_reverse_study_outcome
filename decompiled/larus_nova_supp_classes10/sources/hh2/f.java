package hh2;

import el2.o;
import sg2.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f {
    public static final a a = null;
    public static final g b = null;

    public static final class a {
        public g a;

        public a() {
            this.a = (g) hh2.a.a().h.get();
        }
    }

    static {
        a r0 = new a();
        a = r0;
        b = r0.a;
    }

    public static boolean a() {
        g r0 = a.a;
        if (r0 == null) goto L7;
        Boolean r1 = r0.b();
        if (r1 == null) goto L7;
        return r1.booleanValue();
    L7:
        return true;
    }

    public static x b() {
        g r0 = a.a;
        if (r0 == null) goto L6;
        x r1 = r0.a;
        if (r1 == null) goto L6;
        return r1;
    L6:
        x.a.getClass();
        return x.a.a;
    }

    public static o c() {
        g r0 = a.a;
        if (r0 == null) goto L6;
        o r1 = r0.b;
        if (r1 == null) goto L6;
        return r1;
    L6:
        o.a.getClass();
        return o.a.a;
    }

    public static boolean d() {
        g r0 = a.a;
        if (r0 == null) goto L7;
        Boolean r1 = r0.q();
        if (r1 == null) goto L7;
        return r1.booleanValue();
    L7:
        return false;
    }

    public static boolean e() {
        g r0 = a.a;
        if (r0 == null) goto L7;
        Boolean r1 = r0.j();
        if (r1 == null) goto L7;
        return r1.booleanValue();
    L7:
        return false;
    }

    public static boolean f() {
        g r0 = a.a;
        if (r0 == null) goto L7;
        Boolean r1 = r0.m();
        if (r1 == null) goto L7;
        return r1.booleanValue();
    L7:
        return false;
    }

    public static boolean g() {
        g r0 = a.a;
        if (r0 == null) goto L7;
        Boolean r1 = r0.n();
        if (r1 == null) goto L7;
        return r1.booleanValue();
    L7:
        return false;
    }
}
