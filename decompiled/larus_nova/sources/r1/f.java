package r1;

import android.content.Context;

/* JADX INFO: loaded from: classes39.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f535558b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f535559a;

    public static class a extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public k1.c f535560c;

        public a() {
            this.f535560c = null;
        }

        @Override // r1.f
        public final Object b(String r100) {
            if (this.f535560c != null) goto L6;
            Context r101 = com.apm.lite.e.f29909a;
            k1.c r102 = k1.c.a();
            k1.c.d(r102);
            k1.c.f(r102);
            r102.i();
            r102.j();
            r102.l();
            this.f535560c = r102;
        L6:
            return this.f535560c.f501337a.opt(r100);
        }
    }

    static {
        f535558b = new a();
    }

    public Object a(String r100) {
        f r101 = this.f535559a;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.a(r100);
    }

    public Object b(String r100) {
        f r101 = this.f535559a;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.b(r100);
    }

    public f() {
        a r100 = f535558b;
        this.f535559a = null;
        this.f535559a = r100;
    }
}
