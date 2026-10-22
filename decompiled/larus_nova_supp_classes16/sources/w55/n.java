package w55;

import android.app.Application;
import com.bytedance.ee.bear.contract.h0;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n extends e {
    public static volatile n c;
    public static volatile boolean d;

    public static n g() {
        if (c != null) goto L15;
        monitor-enter(n.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new n();     // Catch: Throwable -> L11
    L9:
        monitor-exit(n.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    public static synchronized void l() {
        monitor-enter(n.class);
        com.bytedance.ee.bear.appsetting.c r1 = com.bytedance.ee.bear.appsetting.c.a.a;     // Catch: Throwable -> L7
        Application r2 = LarkContext.getApplication();     // Catch: Throwable -> L7
        r1.getClass();     // Catch: Throwable -> L7
        UserSession r3 = ((com.ss.android.lark.passportc.convention.a) e0c.k.a(r2, com.ss.android.lark.passportc.convention.a.class)).b();     // Catch: Throwable -> L7
        d = ((dn4.a) e0c.k.b(((v) e0c.k.a(r2, v.class)).c(r3), dn4.a.class)).a().isCurrentEnable("ccm.mobile.android_pdf_quote_comment_enable");     // Catch: Throwable -> L7
        monitor-exit(n.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // w55.e
    public final boolean e() {
        Application r0 = eu5.b.a;
        boolean r1 = l.b;
        tt5.a.h("TTOfficePlugin", "isPkgCanUsePlugin, baseApplication: " + r0 + ", hasPackedMira: " + r1 + ", isAppBundle: false");
        if (r0 == null) goto L7;
        if (r1 == false) goto L7;
        return true;
    L7:
        return false;
    }

    static {
        l();
        ((h0) org.koin.java.a.a(h0.class)).Pe(new m());
    }

    @Override // w55.e
    public final boolean f() {
        if (e() == true) goto L7;
        tt5.a.d("TTOfficePlugin", "isPluginStateEnable() isPkgCanUsePlugin is false, return false.");
        return false;
    L7:
        if (e() == true) goto L10;
        tt5.a.d("com.bytedance.ee.plugin.ttoffice", "isInstalled() isPkgCanUsePlugin is false, return false.");
        return false;
    L10:
        return l.a.a();
    }

    public n() {
    }

    public static boolean h(q75.a r1) {
        boolean r2 = Boolean.TRUE.equals(r1.l.getUseExcel());
        if (g().d() == false) goto L6;
        if (r2 == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean i(q75.a r1) {
        boolean r2 = Boolean.TRUE.equals(r1.l.getUsePPT());
        if (g().d() == false) goto L6;
        if (r2 == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean j(q75.a r1) {
        boolean r2 = Boolean.TRUE.equals(r1.l.getUsePdf());
        if (g().d() == false) goto L6;
        if (r2 == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean k(q75.a r1) {
        boolean r2 = Boolean.TRUE.equals(r1.l.getUseWord());
        if (g().d() == false) goto L6;
        if (r2 == false) goto L6;
        return true;
    L6:
        return false;
    }
}
