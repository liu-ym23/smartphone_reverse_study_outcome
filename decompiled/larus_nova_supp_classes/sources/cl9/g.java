package cl9;

import android.app.Application;
import android.os.Looper;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.mira.IALogSupport;
import com.bytedance.mira.Mira;
import com.bytedance.mira.MiraManager;
import com.bytedance.mira.MiraParam;
import com.bytedance.mira.MiraParamPre;
import com.bytedance.mira.event.PluginEventManager;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.plugin.core.func.soloader.SoLoader;
import com.bytedance.morpheus.mira.MiraMorpheusHelper$DownloadType;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.mirabridge.api.plugin.service.IPluginService;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class g {
    public static final g a = null;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final CountDownLatch d = null;
    public static final CopyOnWriteArraySet<Function0<Unit>> e = null;

    public static final class a implements SoLoader.ILog {
        public a() {
        }

        @Override // com.bytedance.mira.plugin.core.func.soloader.SoLoader.ILog
        public final void d(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r3, "info");
            FLogger.a.i(r2, r3);
        }

        @Override // com.bytedance.mira.plugin.core.func.soloader.SoLoader.ILog
        public final void e(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r3, "info");
            FLogger.a.e(r2, r3);
        }
    }

    public static final class b implements IALogSupport {
        public b() {
        }

        @Override // com.bytedance.mira.IALogSupport
        public final void i(String r2, String r3) {
            if (r2 == null) goto L5;
            FLogger.a.i(r2, r3);
            return;
        }

        @Override // com.bytedance.mira.IALogSupport
        public final void v(String r2, String r3) {
            if (r2 == null) goto L5;
            FLogger.a.v(r2, r3);
            return;
        }

        @Override // com.bytedance.mira.IALogSupport
        public final void w(String r2, String r3) {
            if (r2 == null) goto L5;
            FLogger.a.w(r2, r3);
            return;
        }

        @Override // com.bytedance.mira.IALogSupport
        public final void e(String r2, String r3, Throwable r4) {
            if (r2 == null) goto L5;
            FLogger.a.e(r2, r3, r4);
            return;
        }

        @Override // com.bytedance.mira.IALogSupport
        public final void w(String r2, String r3, Throwable r4) {
            if (r2 == null) goto L5;
            FLogger.a.w(r2, r3, r4);
            return;
        }
    }

    public g() {
    }

    static {
        a = new g();
        d = new CountDownLatch(1);
        e = new CopyOnWriteArraySet();
    }

    public static MiraParam a() {
        e10 r0 = e10.a;
        lu9.a r1 = e10.u();
        boolean r2 = r1.k();
        if (r2 == false) goto L5;
        boolean r3 = r1.g();
    L6:
        if (r2 == false) goto L8;
        boolean r4 = r1.x();
    L9:
        FLogger.a.i(MiraLogger.TAG_INIT, "plugin cleanup config: useExtended=" + r2 + ", deleteUndeclared=" + r3 + ", keepExpiredUntilInstallNew=" + r4);
        HashMap r5 = new HashMap();
        ArrayList r6 = new ArrayList();
        r6.add("com.samsung.android.permission.GET_APP_LIST");
        r6.add("com.android.permission.GET_INSTALLED_APPS");
        IPluginService r7 = (IPluginService) ServiceManager.get().getService(IPluginService.class);
        if (r7 == null) goto L17;
        Set<String> r8 = r7.b();
        if (r8 == null) goto L17;
        Iterator<T> r9 = r8.iterator();
    L15:
        if (r9.hasNext() == false) goto L17;
        r5.put((String) r9.next(), r6);
    L17:
        HashSet r10 = new HashSet();
        MiraParam.Builder r11 = new MiraParam.Builder().withClassLoaderHook(true).openMiraOpt(true);
        AppHost.Companion r12 = AppHost.a;
        MiraParam.Builder r13 = r11.withDebug(r12.isDebug());
        if (r12.isDebug() == false) goto L20;
        int r14 = 4;
    L21:
        MiraParam r15 = r13.withLogLevel(r14).withHookActivityViewRootImplCallback(null).withEnableDeleteUndeclaredPlugin(r3).withEnableOptIntent(true).withEnableOptMakeApplication(true).withoutHookHostActivityRes(r10).withKeepExpiredPluginUntilInstallNew(r4).withEnableDrawableAccessReport(false).withEnableArrayIndexExceptionFix(false).withEnableSkipCheckPermission(r5).withEnableOptRecovery(true).withEnableOptResourcesArch(true).withEnableInstallProcessOpt(true).withEnableDiffStorageOpt(true).build();
        Intrinsics.checkNotNull(r15);
        return r15;
    L20:
        r14 = 3;
        goto L21
    L8:
        r4 = true;
        goto L9
    L5:
        r3 = true;
        goto L6
    }

    public static SoLoader.Config b() {
        SoLoader.ConfigBuilder r0 = new SoLoader.ConfigBuilder();
        AppHost.Companion r1 = AppHost.a;
        return r0.setDebug(r1.isDebug()).setHostPackageName(r1.getApplication().getPackageName()).setClassloaderGet(new d()).setAction(new e()).setPkgToSoListMap(bl9.c.c).setSoLinkedMap(bl9.c.d).setSoToNeedLoadPkgMap(bl9.c.b).setLogImpl(new a()).build();
    }

    public static boolean e() {
        if (b == true) goto L5;
    L7:
        return false;
    L5:
        if (c == false) goto L7;
        return true;
    }

    public static void f() {
        if (c == false) goto L7;
        FLogger.a.i("mira/start", "morpheus already started");
        return;
    L7:
        monitor-enter(g.class);
    L17:
        th = move-exception;
        throw th;
    L9:
        if (c == false) goto L13;
        FLogger.a.i("mira/start", "morpheus already started2");     // Catch: Throwable -> L17
        monitor-exit(g.class);
        return;
    L13:
        boolean r3 = Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());     // Catch: Throwable -> L17
        FLogger r4 = FLogger.a;     // Catch: Throwable -> L17
        r4.i("mira/start", "start to start mira: isMainThread=" + r3);     // Catch: Throwable -> L17
        h27.b.a(new cl9.a());     // Catch: Throwable -> L17
        k27.d.b().b = MiraMorpheusHelper$DownloadType.CONCURRENCE;     // Catch: Throwable -> L17
        r4.i(MiraLogger.TAG_INIT, "use parallel download");     // Catch: Throwable -> L17
        c = true;     // Catch: Throwable -> L17
        r4.i("mira/start", "finish to start mira: isMainThread=" + r3);     // Catch: Throwable -> L17
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(g.class);
        d.countDown();
        IApplog.a.f(new c());
    }

    public static void c(Application r9) {
        Intrinsics.checkNotNullParameter(r9, "application");
        if (b == true) goto L18;
        FLogger r2 = FLogger.a;
        r2.i(MiraLogger.TAG_INIT, "start to init mira");
        monitor-enter(g.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (b == true) goto L12;
        Mira.initPre(AppHost.a.getApplication(), new MiraParamPre.Builder().withEnableOptInitProcess(true).withHostSupport(new cl9.b()).withALogSupport(new b()).build());     // Catch: Throwable -> L15
        boolean r4 = Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());     // Catch: Throwable -> L15
        r2.i(MiraLogger.TAG_INIT, "start to init mira: isMainThread=" + r4);     // Catch: Throwable -> L15
        bl9.b r1 = new bl9.b();     // Catch: Throwable -> L15
        MiraManager.getInstance().registerPluginEventBeforeLoadListener(r1);     // Catch: Throwable -> L15
        PluginEventManager.getInstance().addPluginEventListener(r1);     // Catch: Throwable -> L15
        MiraManager.getInstance().registerPluginEventListener(r1);     // Catch: Throwable -> L15
        r2.i(MiraLogger.TAG_INIT, "start to init SoLoader");     // Catch: Throwable -> L15
        r2.i(MiraLogger.TAG_INIT, "start to init native Hook");     // Catch: Throwable -> L15
        ByteHook.init();     // Catch: Throwable -> L15
        r2.i(MiraLogger.TAG_INIT, "init native Hook finished");     // Catch: Throwable -> L15
        a.getClass();     // Catch: Throwable -> L15
        d(b(), 500);     // Catch: Throwable -> L15
        Mira.init(r9, a());     // Catch: Throwable -> L15
        b = true;     // Catch: Throwable -> L15
        r2.i(MiraLogger.TAG_INIT, "finish to init mira: isMainThread=" + r4);     // Catch: Throwable -> L15
        Iterator<Function0<Unit>> r10 = e.iterator();     // Catch: Throwable -> L15
    L10:
        if (r10.hasNext() == false) goto L12;
        r10.next().invoke();     // Catch: Throwable -> L15
    L12:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(g.class);
        return;
    }

    public static void d(SoLoader.Config r2, long r3) {
        if (SoLoader.init(r2) == true) goto L5;
        t0.b(new f(r2, r3), r3);
        FLogger.a.e(MiraLogger.TAG_INIT, "init SoLoader Failed");
        return;
    L5:
        FLogger.a.i(MiraLogger.TAG_INIT, "init SoLoader Succeed");
    }
}
