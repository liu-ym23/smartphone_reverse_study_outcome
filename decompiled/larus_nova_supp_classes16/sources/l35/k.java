package l35;

import a35.y;
import com.bytedance.ee.bear.contract.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k {
    public static int b;
    public static int c;
    public static boolean d;
    public boolean a;

    public static class a {
        public static final k a = null;

        static {
            a = new k();
        }
    }

    public final void a() {
        if (b != 0) goto L10;
        ((com.bytedance.ee.bear.doc.resupdate.g) org.koin.java.a.a(com.bytedance.ee.bear.doc.resupdate.g.class)).a();
        if (this.a == true) goto L7;
        return;
    L7:
        if (y.e().f() == true) goto L12;
        tt5.a.h("ReloadManager", "checkReload reload: ");
        this.a = false;
        ((m) org.koin.java.a.a(m.class)).c(true).subscribe(new l35.a(), new b());
        return;
    L12:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [l35.c] */
    public k() {
        this.a = false;
        ((com.bytedance.ee.bear.doc.resupdate.g) org.koin.java.a.a(com.bytedance.ee.bear.doc.resupdate.g.class)).b(new c(this));
        com.bytedance.ee.util.ui.m.a(new d(this));
    }
}
