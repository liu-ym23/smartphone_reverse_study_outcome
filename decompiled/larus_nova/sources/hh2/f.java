package hh2;

import el2.o;
import sg2.x;

/* JADX INFO: loaded from: classes10.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f485165a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f485166b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g f485167a;

        public a() {
            this.f485167a = hh2.a.a().f485155h.get();
        }
    }

    static {
        a r100 = new a();
        f485165a = r100;
        f485166b = r100.f485167a;
    }

    public static boolean a() {
        g r100 = f485165a.f485167a;
        if (r100 == null) goto L7;
        Boolean r101 = r100.b();
        if (r101 == null) goto L7;
        return r101.booleanValue();
    L7:
        return true;
    }

    public static x b() {
        g r100 = f485165a.f485167a;
        if (r100 == null) goto L6;
        x r101 = r100.f485168a;
        if (r101 == null) goto L6;
        return r101;
    L6:
        x.f541829a.getClass();
        return x.a.f541830a;
    }

    public static o c() {
        g r100 = f485165a.f485167a;
        if (r100 == null) goto L6;
        o r101 = r100.f485169b;
        if (r101 == null) goto L6;
        return r101;
    L6:
        o.f473005a.getClass();
        return o.a.f473006a;
    }

    public static boolean d() {
        g r100 = f485165a.f485167a;
        if (r100 == null) goto L7;
        Boolean r101 = r100.q();
        if (r101 == null) goto L7;
        return r101.booleanValue();
    L7:
        return false;
    }

    public static boolean e() {
        g r100 = f485165a.f485167a;
        if (r100 == null) goto L7;
        Boolean r101 = r100.j();
        if (r101 == null) goto L7;
        return r101.booleanValue();
    L7:
        return false;
    }

    public static boolean f() {
        g r100 = f485165a.f485167a;
        if (r100 == null) goto L7;
        Boolean r101 = r100.m();
        if (r101 == null) goto L7;
        return r101.booleanValue();
    L7:
        return false;
    }

    public static boolean g() {
        g r100 = f485165a.f485167a;
        if (r100 == null) goto L7;
        Boolean r101 = r100.n();
        if (r101 == null) goto L7;
        return r101.booleanValue();
    L7:
        return false;
    }
}
