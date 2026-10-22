package kmb;

import android.app.Application;
import com.bytedance.ee.bear.bizwidget.officesdk.CCMOfficeSDKAssembleFG;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.integrator.ccm.dependency.di.q;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes36.dex */
public final class a {
    public static void a() {
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == true) goto L5;
    L8:
        q.a();
        if (fmb.a.f477891b == true) goto L32;
        Object r100 = fmb.a.f477890a;
        monitor-enter(r100);
    L29:
        th = move-exception;
        throw th;
    L13:
        if (fmb.a.f477891b == true) goto L27;
        Application r101 = LarkContext.getApplication();     // Catch: Throwable -> L29
        com.bytedance.ee.bear.appsetting.c r102 = com.bytedance.ee.bear.appsetting.c.a.f206237a;     // Catch: Throwable -> L29
        r102.a(new fmb.a.C5930a());     // Catch: Throwable -> L29
        if ("release".equals(AppInfoUtils.d(r101)) == true) goto L17;
    L20:
        boolean r103 = true;
    L21:
        if (r103 == false) goto L23;
        r102.a(new fn4.b(LarkContext.getApplication()));     // Catch: Throwable -> L29
    L23:
        r102.a(new fn4.c());     // Catch: Throwable -> L29
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == false) goto L26;
        r102.a(new fmb.b());     // Catch: Throwable -> L29
    L26:
        fmb.a.f477891b = true;     // Catch: Throwable -> L29
        goto L27
    L17:
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == true) goto L20;
        r103 = false;
    L27:
        monitor-exit(r100);     // Catch: Throwable -> L29
        return;
    L32:
        return;
    L5:
        if (CCMOfficeSDKAssembleFG.b() == true) goto L8;
        tt5.a.h("CCMInitChecker", "OfficeSDK checkAndInit, but isEnable is false");
    }
}
