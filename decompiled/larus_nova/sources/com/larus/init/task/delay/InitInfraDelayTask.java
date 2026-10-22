package com.larus.init.task.delay;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.os.PowerManager;
import bf6.c;
import bg9.i;
import com.bytedance.ai.api.AppletService;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.relax.ttmlstatic.prewarm.TtmlStaticPrewarmPolicy;
import com.bytedance.relax.ttmlstatic.prewarm.TtmlStaticPrewarmer;
import com.flow.performance.perflog.scenario.ScreenStateMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.SecurityService;
import com.larus.home.api.main.HomeService;
import com.larus.init.task.m;
import com.larus.jato.api.IJato;
import com.larus.network.http.ServiceType;
import com.larus.platform.api.g3;
import com.larus.platform.service.k2;
import com.larus.settings.value.bs;
import com.larus.settings.value.e10;
import com.larus.utils.f;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import qv9.o;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0002J\r\u0010\f\u001a\u00020\nH\u0000¢\u0006\u0002\b\rJ\r\u0010\u000e\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000fJ\b\u0010\u0010\u001a\u00020\nH\u0002J\b\u0010\u0011\u001a\u00020\nH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/larus/init/task/delay/InitInfraDelayTask;", "Lcom/bytedance/lego/init/model/IDelayTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "runInternal", "", "initAppletServiceOnStartup", "runDeferredAppletInit", "runDeferredAppletInit$app_mainlandRelease", "runDeferredAppletInitSynchronously", "runDeferredAppletInitSynchronously$app_mainlandRelease", "initAppletService", "reportAlbumAuthorizeEvent", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitInfraDelayTask extends c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351201a;

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    public static void c() {
        AppletService r100 = (AppletService) ServiceManager.get().getService(AppletService.class);
        if (r100 == null) goto L6;
        AppHost.Companion r101 = AppHost.f326268a;
        r100.h(r101.getApplication(), com.larus.ivykit.c.a(), r101.isDebug(), pg9.b.f529212a);
        return;
    }

    @Override // bg9.i
    public final void runInternal() {
        e10 r100 = e10.f368561a;
        o r101 = e10.j0().c();
        com.flow.performance.perflog.scenario.b r102 = com.flow.performance.perflog.scenario.b.f274159a;
        HomeService r103 = HomeService.f344094a;
        Long r104 = r103.J();
        if (r104 == null) goto L5;
        long r105 = r104.longValue();
    L7:
        if (r101 == null) goto L9;
        boolean r106 = r101.a();
    L10:
        if (r101 == null) goto L12;
        long r107 = r101.b();
    L13:
        monitor-enter(r102);
    L73:
        th = move-exception;
        throw th;
    L15:
        if (com.flow.performance.perflog.scenario.b.f274163e == false) goto L18;
        monitor-exit(r102);
    L24:
        int r108 = b.f351217a;
        AppHost.Companion r109 = AppHost.f326268a;
        Application r110 = r109.getApplication();
        Intrinsics.checkNotNullParameter(r110, "application");
        int r111 = l0.f375430a;
        int r112 = ((Number) l0.a(2, new bs())).intValue();
        if (r112 == 1) goto L29;
        if (r112 == 2) goto L28;
        TtmlStaticPrewarmPolicy r113 = TtmlStaticPrewarmPolicy.EAGER;
    L30:
        TtmlStaticPrewarmPolicy r114 = r113;
        AtomicBoolean r115 = TtmlStaticPrewarmer.f267252a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r114, "policy");
        AtomicBoolean r116 = TtmlStaticPrewarmer.f267252a;
        if (r114 != TtmlStaticPrewarmPolicy.DISABLED) goto L34;
    L56:
        com.larus.platform.service.o r117 = com.larus.platform.service.o.f365780a;
        k2 r118 = k2.f365755a;
        r117.b("album_authorize_status", f.c(new Pair[]{TuplesKt.to("album_authorize_status", Integer.valueOf(g3.a.d() ? 1 : 0))}));
        SecurityService r119 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r119 == null) goto L59;
        r119.B();
    L59:
        r103.a0(r109.getApplication());
        m.f351424a.getClass();
        if (m.c("Applet", ((Boolean) m.f351428e.getValue()).booleanValue()) == false) goto L62;
        FLogger.f375446a.i("BackgroundLazyInit", "event=component_init_deferred, component=Applet, trigger=startup, reason=background_cold_launch");
    L63:
        com.larus.init.task.firstframe.jato.a.C4382a r120 = com.larus.init.task.firstframe.jato.a.f351302e;
        if (r120.a().f351306c.get() == false) goto L68;
        com.larus.init.task.firstframe.jato.a.e("reset RenderThread");
        IJato.f351658a.s();
    L68:
        if (r120.a().f351307d.get() == false) goto L71;
        IJato.f351658a.g();
    L71:
        r120.a();
        com.larus.init.task.firstframe.jato.a.e("resetCoreBind");
        IJato.f351658a.resetCoreBind();
        return;
    L62:
        FLogger.f375446a.i("BackgroundLazyInit", "event=component_init_request, component=Applet, trigger=startup");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new InitInfraDelayTask$runDeferredAppletInit$1(this, null), 3, null);
        goto L63
    L34:
        if (TtmlStaticPrewarmer.f267252a.compareAndSet(false, true) == false) goto L56;
        Context r121 = r110.getApplicationContext();
        if (r121 != null) goto L39;
        Context r122 = r110;
    L40:
        int r123 = TtmlStaticPrewarmer.b.f267269a[r114.ordinal()];
        if (r123 == 1) goto L50;
        if (r123 != 2) goto L44;
        TtmlStaticPrewarmer.f(r122, r114, 29, 1, 0);
        goto L56
    L44:
        if (r123 != 3) goto L56;
        throw new IllegalStateException("Disabled prewarm cannot pass request admission".toString());
    L50:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L53;
        TtmlStaticPrewarmer.f(r122, TtmlStaticPrewarmPolicy.EAGER, 29, 1, 0);
        goto L56
    L53:
        if (TtmlStaticPrewarmer.b() == true) goto L55;
        TtmlStaticPrewarmer.f(r122, TtmlStaticPrewarmPolicy.EAGER, 29, 2, 10000);
        goto L56
    L55:
        TtmlStaticPrewarmer.c(r122, 29);
        goto L56
    L39:
        r122 = r121;
        goto L40
    L28:
        r113 = TtmlStaticPrewarmPolicy.DISABLED;
        goto L30
    L29:
        r113 = TtmlStaticPrewarmPolicy.SYSTEM_MEMORY_AWARE;
        goto L30
    L18:
        com.flow.performance.perflog.scenario.b.f274163e = true;     // Catch: Throwable -> L73
        com.flow.performance.perflog.scenario.b.f274165g = r105;     // Catch: Throwable -> L73
        AppHost.Companion r124 = AppHost.f326268a;     // Catch: Throwable -> L73
        Object r125 = r124.getApplication().getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);     // Catch: Throwable -> L73
        Intrinsics.checkNotNull(r125, "null cannot be cast to non-null type android.os.PowerManager");     // Catch: Throwable -> L73
        if (((PowerManager) r125).isInteractive() == false) goto L21;
        ScreenStateMonitor.ScreenState r126 = ScreenStateMonitor.ScreenState.SCREEN_ON;     // Catch: Throwable -> L73
    L22:
        com.flow.performance.perflog.scenario.b.f274161c = r126.getValue();     // Catch: Throwable -> L73
        com.flow.performance.perflog.scenario.b.b();     // Catch: Throwable -> L73
        com.flow.performance.perflog.scenario.b.a();     // Catch: Throwable -> L73
        r124.a().j(new du7.a());     // Catch: Throwable -> L73
        cu7.c.f465433a.a(r106, r107);     // Catch: Throwable -> L73
        monitor-exit(r102);
        goto L24
    L21:
        r126 = ScreenStateMonitor.ScreenState.SCREEN_OFF;     // Catch: Throwable -> L73
        goto L22
    L12:
        r107 = 60;
        goto L13
    L9:
        r106 = true;
        goto L10
    L5:
        r105 = -1;
        goto L7
    }

    public InitInfraDelayTask() {
        this.f351201a = ServiceType.BASIC_SERVICE;
    }

    @Override // java.lang.Runnable, bg9.i
    public final void run() {
        i.a.a(this);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // bg9.i
    public final String getScene() {
        return this.f351201a;
    }
}
