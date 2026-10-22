package com.bytedance.ee.bear.task;

import android.app.Application;
import android.content.Context;
import androidx.arch.core.executor.ArchTaskExecutor;
import ao4.c;
import ao4.f;
import ao4.g;
import com.bytedance.ee.bear.basesdk.apisupport.l;
import com.bytedance.ee.bear.basesdk.apisupport.o;
import com.bytedance.ee.bear.basesdk.apisupport.p;
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
import com.ss.android.lark.utils.statistics.PerfLog;
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

/* JADX INFO: loaded from: classes18.dex */
public class DocsBaseTask extends BaseTask {
    public DocsBaseTask() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [ra5.c] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void j(final o r100) {
        i r101 = (i) w.f206578f;
        r101.getClass();
        boolean r102 = true;
        if (z.e(b.f474075a) == false) goto L20;
        ao4.i r103 = ao4.i.b.f15783a;
        d r104 = new d(r101);
        StringBuilder r105 = new StringBuilder("registerWatermarkChangeListener, watermarkAgent null?: ");
        if (r103.f15782a != null) goto L8;
        boolean r106 = true;
    L9:
        r105.append(r106);
        a.h("WatermarkServiceImpl", r105.toString());
        f r107 = r103.f15782a;
        if (r107 == null) goto L12;
        r107.b(r104);
    L12:
        e r108 = new e(r101);
        c r109 = (c) org.koin.java.a.a(c.class);
        StringBuilder r110 = new StringBuilder("registerAppUserConfigChangeListener, appUserConfigAgent null?: ");
        if (r109 != null) goto L15;
        boolean r111 = true;
    L16:
        r110.append(r111);
        a.h("AppUserConfigImpl", r110.toString());
        if (r109 == null) goto L19;
        r109.a(r108);
    L19:
        AppLifecycle r112 = AppLifecycle.a.f408803a;
        r112.c(new ra5.f());
        ((com.bytedance.ee.bear.basesdk.apisupport.b) qa5.b.a.f532259a.f532258a.c()).setIsAppInFront(r112.h());
        goto L20
    L15:
        r111 = false;
        goto L16
    L8:
        r106 = false;
    L20:
        g r113 = g.b.f15780a;
        ?? r114 = new ra5.c();
        StringBuilder r115 = new StringBuilder("registerLanguageChangeListener, languageSettingAgent null?: ");
        if (r113.f15779a == null) goto L24;
        r102 = false;
    L24:
        r115.append(r102);
        a.h("LanguageSettingImpl", r115.toString());
        ao4.e r116 = r113.f15779a;
        if (r116 == 0) goto L42;
        r116.a(r114);
    L42:
        a.h("SdkInitImpl", "registerComponentCallbacks: DarkMode onConfigurationChanged");     // Catch: Throwable -> L35
        b.f474075a.registerComponentCallbacks(new ra5.g());     // Catch: Throwable -> L35
        if (z.e(b.f474075a) == false) goto L37;
        ao4.d r117 = (ao4.d) org.koin.java.a.a(ao4.d.class);     // Catch: Throwable -> L35
        a.h("SdkInitImpl", "registerDarkModeListener, iDarkModeAgent: " + r117);     // Catch: Throwable -> L35
        if (r117 == null) goto L37;
        r117.a(new go2.g());     // Catch: Throwable -> L35
    L37:
        ((h) org.koin.java.a.a(h.class)).re(new ra5.h());
        Application r118 = b.f474075a;
        com.bytedance.ee.bear.lynx.api.d r119 = (com.bytedance.ee.bear.lynx.api.d) org.koin.java.a.a(com.bytedance.ee.bear.lynx.api.d.class);
        r119.c("/ccm/profile_main", new com.bytedance.ee.bear.basesdk.config.a());
        r119.c("/ccm/docs/share", new com.bytedance.ee.bear.basesdk.config.h());
        r119.c("/ccm/docs/entity_word", new LynxEntityWordRouteInterceptor());
        if (r100 == null) goto L40;
        r100.b();
    L40:
        w.b(new vn5.a(r100));
        return;
    L35:
        th = move-exception;
        a.f("SdkInitImpl", th, false);
        goto L37
    }

    @Override // com.bytedance.ee.bear.task.BaseTask, com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        l r101 = w.e();     // Catch: Throwable -> L16
        Application r102 = r101.application();     // Catch: Throwable -> L16
        on4.a r103 = r101.docBaseConfig();     // Catch: Throwable -> L16
        b.f474075a = r102;     // Catch: Throwable -> L16
        ((jmb.c) r103).getClass();     // Catch: Throwable -> L16
        eu5.g.f474081a = z.b(r102);     // Catch: Throwable -> L16
        p r104 = r101.dependency();     // Catch: Throwable -> L16
        List<kwc.a> r105 = com.bytedance.ee.bear.integrator.di.f.f227131a;     // Catch: Throwable -> L16
        ((jmb.f) r104).getClass();     // Catch: Throwable -> L16
        if (q.f427862a == null) goto L6;
        boolean r106 = true;
    L8:
        if (r106 == false) goto L10;
        a.b("SpacekitDependencyImpl", "spacekitDependencyModule return empty.");     // Catch: Throwable -> L16
        kwc.a r107 = new kwc.a(false, false);     // Catch: Throwable -> L16
    L11:
        ((ArrayList) r105).add(r107);     // Catch: Throwable -> L16
        KoinSetupTask.b(r100);     // Catch: Throwable -> L16
        KoinSetupTask.c(r100);     // Catch: Throwable -> L16
        ((i) w.f206578f).a();     // Catch: Throwable -> L16
        j((o) org.koin.java.a.a(o.class));     // Catch: Throwable -> L16
        m.f219111a = ib5.e.getContext();     // Catch: Throwable -> L16
        if (com.bytedance.ee.bear.bizwidget.a.f216306a != null) goto L14;
        int r108 = rb5.b.f536936a;     // Catch: Throwable -> L16
    L14:
        hwc.a.a().c(Collections.singletonList(KoinCommonModuleKt.a()), false);     // Catch: Throwable -> L16
        yn4.b.f568530f = w.e().docBaseConfig();     // Catch: Throwable -> L16
        yn4.b.z(w.e().docDynamicConfig());     // Catch: Throwable -> L16
        ((NetService) org.koin.java.a.a(NetService.class)).b();     // Catch: Throwable -> L16
        boolean r109 = ((Boolean) new ml5.b("debug_config").a("database_encrypt", Boolean.TRUE)).booleanValue();     // Catch: Throwable -> L16
        DBController.a().init(yn4.b.f568529e.f216922f.f216928a);     // Catch: Throwable -> L16
        DBController.a().M0(r109);     // Catch: Throwable -> L16
        int r110 = ay4.a.f16747a;     // Catch: Throwable -> L16
        FileSystemManager.f(new BackupFileSystemProvider());     // Catch: Throwable -> L16
    L18:
        ak5.g r111 = new ak5.g();
        Application r112 = b.f474075a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r113 = ay4.c.f16749a;
        a.h("FacadeInit", ay4.c.a.b(Biz.LOG, "/Journal/docs/log/", true, 8).getRealPath());
        b.f474075a = r112;
        ArchTaskExecutor.getInstance().setDelegate(new SecureTaskExecutor());
        r111.f4014a = r112;
        a.b("HttpConfig", "configHttpClient start");
        lr5.b.f510406e = r111;
        BearExecutors.a().execute(new ak5.f(r111));
        a.b("HttpConfig", "configHttpClient end");
        rr5.b.f539032a = r111;
        return;
    L10:
        a.k("SpacekitDependencyImpl", "spacekitDependencyModule return getLarkAppKoinModule() value.");     // Catch: Throwable -> L16
        r107 = q.a();     // Catch: Throwable -> L16
        goto L11
    L6:
        r106 = false;
    L16:
        th = move-exception;
        iu5.d.b("DocsBaseTask", th);
        goto L18
    }
}
