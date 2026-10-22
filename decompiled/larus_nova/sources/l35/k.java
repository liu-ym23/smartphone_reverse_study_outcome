package l35;

import a35.y;
import com.bytedance.ee.bear.contract.m;

/* JADX INFO: loaded from: classes16.dex */
public final class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f507256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f507257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f507258d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f507259a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f507260a = null;

        static {
            f507260a = new k();
        }
    }

    public final void a() {
        if (f507256b != 0) goto L10;
        ((com.bytedance.ee.bear.doc.resupdate.g) org.koin.java.a.a(com.bytedance.ee.bear.doc.resupdate.g.class)).a();
        if (this.f507259a == true) goto L7;
        return;
    L7:
        if (y.e().f() == true) goto L12;
        tt5.a.h("ReloadManager", "checkReload reload: ");
        this.f507259a = false;
        ((m) org.koin.java.a.a(m.class)).c(true).subscribe(new l35.a(), new b());
        return;
    L12:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [l35.c] */
    public k() {
        this.f507259a = false;
        ((com.bytedance.ee.bear.doc.resupdate.g) org.koin.java.a.a(com.bytedance.ee.bear.doc.resupdate.g.class)).b(new c(this));
        com.bytedance.ee.util.ui.m.a(new d(this));
    }
}
