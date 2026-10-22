package com.bytedance.ee.bear.task;

import android.app.Application;
import android.content.Context;
import androidx.arch.core.executor.ArchTaskExecutor;
import ao4.c;
import ao4.f;
import ao4.g;
import com.bytedance.ee.bear.basesdk.apisupport.l;
import com.bytedance.ee.bear.basesdk.apisupport.o;
import com.bytedance.ee.bear.basesdk.apisupport.w;
import com.bytedance.ee.bear.basesdk.config.LynxEntityWordRouteInterceptor;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.document.at.m;
import com.bytedance.ee.bear.integrator.di.KoinCommonModuleKt;
import com.bytedance.ee.bear.integrator.di.KoinSetupTask;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.bear.thread.BearExecutors;
import com.bytedance.ee.util.db.DBController;
import com.bytedance.ee.util.db.SecureTaskExecutor;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.integrator.ccm.dependency.di.q;
import com.ss.android.lark.vfs.BackupFileSystemProvider;
import com.ss.android.lark.vfs.FileSystemManager;
import eu5.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import ra5.d;
import ra5.e;
import ra5.i;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DocsBaseTask extends BaseTask {
    public DocsBaseTask() {
    }

    public static void j(final o r7) {
        i r0 = w.f;
        r0.getClass();
        boolean r2 = true;
        if (z.e(b.a) == false) goto L20;
        ao4.i r1 = ao4.i.b.a;
        d r4 = new d(r0);
        StringBuilder r5 = new StringBuilder("registerWatermarkChangeListener, watermarkAgent null?: ");
        if (r1.a != null) goto L8;
        boolean r6 = true;
    L9:
        r5.append(r6);
        a.h("WatermarkServiceImpl", r5.toString());
        f r3 = r1.a;
        if (r3 == null) goto L12;
        r3.b(r4);
    L12:
        e r8 = new e(r0);
        c r9 = (c) org.koin.java.a.a(c.class);
        StringBuilder r10 = new StringBuilder("registerAppUserConfigChangeListener, appUserConfigAgent null?: ");
        if (r9 != null) goto L15;
        boolean r11 = true;
    L16:
        r10.append(r11);
        a.h("AppUserConfigImpl", r10.toString());
        if (r9 == null) goto L19;
        r9.a(r8);
    L19:
        AppLifecycle r12 = AppLifecycle.a.a;
        r12.c(new ra5.f());
        qa5.b.a.a.a.c().setIsAppInFront(r12.h());
        goto L20
    L15:
        r11 = false;
        goto L16
    L8:
        r6 = false;
    L20:
        g r13 = g.b.a;
        ra5.c r14 = new ra5.c();
        StringBuilder r15 = new StringBuilder("registerLanguageChangeListener, languageSettingAgent null?: ");
        if (r13.a == null) goto L24;
        r2 = false;
    L24:
        r15.append(r2);
        a.h("LanguageSettingImpl", r15.toString());
        ao4.e r16 = r13.a;
        if (r16 == null) goto L42;
        r16.a(r14);
    L42:
        a.h("SdkInitImpl", "registerComponentCallbacks: DarkMode onConfigurationChanged");     // Catch: Throwable -> L35
        b.a.registerComponentCallbacks(new ra5.g());     // Catch: Throwable -> L35
        if (z.e(b.a) == false) goto L37;
        ao4.d r17 = (ao4.d) org.koin.java.a.a(ao4.d.class);     // Catch: Throwable -> L35
        a.h("SdkInitImpl", "registerDarkModeListener, iDarkModeAgent: " + r17);     // Catch: Throwable -> L35
        if (r17 == null) goto L37;
        r17.a(new go2.g());     // Catch: Throwable -> L35
    L37:
        ((h) org.koin.java.a.a(h.class)).re(new ra5.h());
        Application r18 = b.a;
        com.bytedance.ee.bear.lynx.api.d r19 = (com.bytedance.ee.bear.lynx.api.d) org.koin.java.a.a(com.bytedance.ee.bear.lynx.api.d.class);
        r19.c("/ccm/profile_main", new com.bytedance.ee.bear.basesdk.config.a());
        r19.c("/ccm/docs/share", new com.bytedance.ee.bear.basesdk.config.h());
        r19.c("/ccm/docs/entity_word", new LynxEntityWordRouteInterceptor());
        if (r7 == null) goto L40;
        r7.b();
    L40:
        w.b(new vn5.a(r7));
        return;
    L35:
        th = move-exception;
        a.f("SdkInitImpl", th, false);
        goto L37
    }

    @Override // com.bytedance.ee.bear.task.BaseTask
    public final void a(Context r6) {
        l r1 = w.e();     // Catch: Throwable -> L16
        Application r2 = r1.application();     // Catch: Throwable -> L16
        jmb.c r3 = r1.docBaseConfig();     // Catch: Throwable -> L16
        b.a = r2;     // Catch: Throwable -> L16
        r3.getClass();     // Catch: Throwable -> L16
        eu5.g.a = z.b(r2);     // Catch: Throwable -> L16
        jmb.f r4 = r1.dependency();     // Catch: Throwable -> L16
        List r5 = com.bytedance.ee.bear.integrator.di.f.a;     // Catch: Throwable -> L16
        r4.getClass();     // Catch: Throwable -> L16
        if (q.a == null) goto L6;
        boolean r7 = true;
    L8:
        if (r7 == false) goto L10;
        a.b("SpacekitDependencyImpl", "spacekitDependencyModule return empty.");     // Catch: Throwable -> L16
        kwc.a r8 = new kwc.a(false, false);     // Catch: Throwable -> L16
    L11:
        ((ArrayList) r5).add(r8);     // Catch: Throwable -> L16
        KoinSetupTask.b(r6);     // Catch: Throwable -> L16
        KoinSetupTask.c(r6);     // Catch: Throwable -> L16
        w.f.a();     // Catch: Throwable -> L16
        j((o) org.koin.java.a.a(o.class));     // Catch: Throwable -> L16
        m.a = ib5.e.getContext();     // Catch: Throwable -> L16
        if (com.bytedance.ee.bear.bizwidget.a.a != null) goto L14;
        int r9 = rb5.b.a;     // Catch: Throwable -> L16
    L14:
        hwc.a.a().c(Collections.singletonList(KoinCommonModuleKt.a()), false);     // Catch: Throwable -> L16
        yn4.b.f = w.e().docBaseConfig();     // Catch: Throwable -> L16
        yn4.b.z(w.e().docDynamicConfig());     // Catch: Throwable -> L16
        ((NetService) org.koin.java.a.a(NetService.class)).b();     // Catch: Throwable -> L16
        boolean r10 = ((Boolean) new ml5.b("debug_config").a("database_encrypt", Boolean.TRUE)).booleanValue();     // Catch: Throwable -> L16
        DBController.a().init(yn4.b.e.f.a);     // Catch: Throwable -> L16
        DBController.a().M0(r10);     // Catch: Throwable -> L16
        int r11 = ay4.a.a;     // Catch: Throwable -> L16
        FileSystemManager.f(new BackupFileSystemProvider());     // Catch: Throwable -> L16
    L18:
        ak5.g r12 = new ak5.g();
        Application r13 = b.a;
        Intrinsics.checkNotNullParameter(r6, "context");
        int r14 = ay4.c.a;
        a.h("FacadeInit", ay4.c.a.b(Biz.LOG, "/Journal/docs/log/", true, 8).getRealPath());
        b.a = r13;
        ArchTaskExecutor.getInstance().setDelegate(new SecureTaskExecutor());
        r12.a = r13;
        a.b("HttpConfig", "configHttpClient start");
        lr5.b.e = r12;
        BearExecutors.a().execute(new ak5.f(r12));
        a.b("HttpConfig", "configHttpClient end");
        rr5.b.a = r12;
        return;
    L10:
        a.k("SpacekitDependencyImpl", "spacekitDependencyModule return getLarkAppKoinModule() value.");     // Catch: Throwable -> L16
        r8 = q.a();     // Catch: Throwable -> L16
        goto L11
    L6:
        r7 = false;
    L16:
        th = move-exception;
        iu5.d.b("DocsBaseTask", th);
        goto L18
    }
}
