package kn4;

import com.bytedance.ee.bear.atfinder.AtFinderViewModel;

/* JADX INFO: loaded from: classes15.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static l f504221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static l.b f504222b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C6577a f504223a = null;

        /* JADX INFO: renamed from: kn4.f$a$a, reason: collision with other inner class name */
        public class C6577a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public AtFinderViewModel f504224a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public com.bytedance.ee.bear.atfinder.g f504225b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f504226c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f504227d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f504228e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public d f504229f;

            public C6577a() {
            }

            public final void a(String r100) {
                com.bytedance.ee.bear.atfinder.g r101 = this.f504225b;
                if (r101 == null) goto L5;
                r101.a();
            L6:
                AtFinderViewModel r102 = this.f504224a;
                if (r102 == null) goto L10;
                r102.search(this.f504226c, r100, this.f504228e, this.f504227d, "");
                return;
            L10:
                return;
            L5:
                tt5.a.d("AtModule", "search() mOnSearchCallback is null: content = " + du5.b.g(r100));
                goto L6
            }
        }

        static {
            f504223a = new C6577a();
        }
    }

    public static l a() {
        if (f504221a != null) goto L6;
        tt5.a.d("AtModule", "getDependency sDependency = null, use default!");
        f504221a = new j();
    L6:
        return f504221a;
    }

    public static l.b b() {
        if (f504222b != null) goto L6;
        tt5.a.d("AtModule", "getExtraDependency sExtraDependency = null, use default!");
        f504222b = new i();
    L6:
        return f504222b;
    }
}
