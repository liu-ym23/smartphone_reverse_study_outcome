package w55;

import android.app.Application;
import com.bytedance.ee.bear.contract.h0;
import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginIds;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes16.dex */
public final class n extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile n f558338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f558339d;

    public static n g() {
        if (f558338c != null) goto L15;
        monitor-enter(n.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f558338c != null) goto L9;
        f558338c = new n();     // Catch: Throwable -> L11
    L9:
        monitor-exit(n.class);     // Catch: Throwable -> L11
    L15:
        return f558338c;
    }

    public static synchronized void l() {
        monitor-enter(n.class);
        com.bytedance.ee.bear.appsetting.c r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a;     // Catch: Throwable -> L7
        Application r101 = LarkContext.getApplication();     // Catch: Throwable -> L7
        r100.getClass();     // Catch: Throwable -> L7
        UserSession r102 = ((com.ss.android.lark.passportc.convention.a) e0c.k.a(r101, com.ss.android.lark.passportc.convention.a.class)).b();     // Catch: Throwable -> L7
        f558339d = ((dn4.a) e0c.k.b(((v) e0c.k.a(r101, v.class)).c(r102), dn4.a.class)).a().isCurrentEnable("ccm.mobile.android_pdf_quote_comment_enable");     // Catch: Throwable -> L7
        monitor-exit(n.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // w55.e
    public final boolean e() {
        Application r100 = eu5.b.f474075a;
        boolean r101 = l.f558337b;
        tt5.a.h("TTOfficePlugin", "isPkgCanUsePlugin, baseApplication: " + r100 + ", hasPackedMira: " + r101 + ", isAppBundle: false");
        if (r100 == null) goto L7;
        if (r101 == false) goto L7;
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
        tt5.a.d(OfficeSDKPluginIds.TT_OFFICE, "isInstalled() isPkgCanUsePlugin is false, return false.");
        return false;
    L10:
        return l.f558336a.a();
    }

    public n() {
    }

    public static boolean h(q75.a r100) {
        boolean r101 = Boolean.TRUE.equals(r100.f531969l.getUseExcel());
        if (g().d() == false) goto L6;
        if (r101 == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean i(q75.a r100) {
        boolean r101 = Boolean.TRUE.equals(r100.f531969l.getUsePPT());
        if (g().d() == false) goto L6;
        if (r101 == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean j(q75.a r100) {
        boolean r101 = Boolean.TRUE.equals(r100.f531969l.getUsePdf());
        if (g().d() == false) goto L6;
        if (r101 == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean k(q75.a r100) {
        boolean r101 = Boolean.TRUE.equals(r100.f531969l.getUseWord());
        if (g().d() == false) goto L6;
        if (r101 == false) goto L6;
        return true;
    L6:
        return false;
    }
}
