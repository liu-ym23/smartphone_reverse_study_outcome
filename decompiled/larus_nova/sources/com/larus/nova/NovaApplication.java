package com.larus.nova;

import android.app.ActivityManager;
import android.app.Application;
import android.app.ApplicationStartInfo;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.bytedance.frameworks.baselib.network.http.cronet.TTAppStateManager;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.lego.init.util.InitContext;
import com.flow.performance.quality.appinit.AppLaunchTracer;
import com.larus.OfficeSDKHiltApplication;
import com.larus.apm.api.IApmTrace;
import com.larus.apm.api.IExtraParams;
import com.larus.bootprotector.IBootProtectorLauncher;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.common.mssdk.api.SecurityService;
import com.larus.common.zlinksdk.api.IZlinkService;
import com.larus.home.api.main.HomeService;
import com.larus.im.FlowRuntime;
import com.larus.im.b;
import com.larus.init.IAbTestInitiator;
import com.larus.init.task.anr.f;
import com.larus.init.task.m;
import com.larus.init.task.n;
import com.larus.network.quota.AppStartState;
import com.larus.settings.coldboot.EarlyFileSettingsStore;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricConfigServiceDelegate;
import com.obric.assistant.spi.app.ObricAppServiceDelegate;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.core.ExemptThreadFactory;
import com.ss.android.ugc.bytex.pthread.base.convergence.helper.NewThreadPoolHelper;
import gd9.i;
import gd9.q;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import jm9.d;
import ju7.c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mm9.e;
import mm9.g;
import mm9.h;
import mm9.p;
import mm9.r;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/nova/NovaApplication;", "Lcom/larus/OfficeSDKHiltApplication;", "<init>", "()V", DyPayConstant.KEY_START_TIME, "Lkotlin/Pair;", "", "getStartTime", "()Lkotlin/Pair;", "launcher", "Lcom/larus/nova/ILauncher;", "earlyStartupTakenOver", "", "attachBaseContext", "", "base", "Landroid/content/Context;", "traceApmCommonParams", "checkAgreed", "isOversea", "getApplicationContext", WidgetCostModule.TYPE_ON_CREATE, "unbindService", "conn", "Landroid/content/ServiceConnection;", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NovaApplication extends OfficeSDKHiltApplication {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static NovaApplication f360303e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Pair<Long, Long> f360304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f360305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f360306d;

    public static final class a {
        public static NovaApplication a() {
            NovaApplication r100 = NovaApplication.f360303e;
            if (r100 == null) goto L5;
            return r100;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("inst");
            return null;
        }
    }

    static {
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return this;
    }

    public NovaApplication() {
        this.f360304b = new Pair(Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(System.currentTimeMillis()));
        f360303e = this;
        InitContext.f254569d.put("application", this);
    }

    @Override // android.app.Application
    public final void onCreate() {
        long r100 = System.currentTimeMillis();
        if (this.f360306d == true) goto L33;
        ObricAppServiceDelegate r101 = ObricAppServiceDelegate.f392824b;
        r101.b(this);
        AppLaunchTracer r102 = AppLaunchTracer.f274169a;
        r102.getClass();
        ((c) AppLaunchTracer.f274171c.getValue()).a(null);
        r102.c("app_create", null);
        h r103 = this.f360305c;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("launcher");
        r103 = null;
    L12:
        r103.b(this);
        super.onCreate();
        d r104 = d.f499704a;
        i r105 = b.f346407a;
        Intrinsics.checkNotNull(r105);
        NovaApplication r106 = r105.getApplication();
        Intrinsics.checkNotNullParameter(r106, "app");
        if (d.f499705b == true) goto L23;
        monitor-enter(r104);
    L28:
        th = move-exception;
        throw th;
    L17:
        if (d.f499705b == false) goto L21;
        monitor-exit(r104);
        goto L23
    L21:
        d.f499705b = true;     // Catch: Throwable -> L28
        r106.registerActivityLifecycleCallbacks(r104);     // Catch: Throwable -> L28
        jm9.c.f499700a.a();     // Catch: Throwable -> L28
        FLogger.f375446a.i("AppStartManager", "AppStartManager initialized");     // Catch: Throwable -> L28
        TTAppStateManager.setAppStartUpState(TTAppStateManager.AppStartState.ColdStart);     // Catch: Throwable -> L28
        d.b(AppStartState.ColdStart);     // Catch: Throwable -> L28
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r104);
    L23:
        h r108 = this.f360305c;
        if (r108 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("launcher");
        r108 = null;
    L26:
        r108.a(this);
        r102.b("app_create", null);
        r101.a(this);
        HomeService.f344094a.I(r100);
        return;
    L33:
        ObricAppServiceDelegate r109 = ObricAppServiceDelegate.f392824b;     // Catch: Throwable -> L6
        r109.b(this);     // Catch: Throwable -> L6
        super.onCreate();     // Catch: Throwable -> L6
        r109.a(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        ObricAppServiceDelegate.f392824b.c(this);
        throw th;
    }

    @Override // com.larus.OfficeSDKHiltApplication, android.content.ContextWrapper
    public final void attachBaseContext(Context r210) {
        Intrinsics.checkNotNullParameter(r210, "base");
        ObricAppServiceDelegate r100 = ObricAppServiceDelegate.f392824b;
        this.f360306d = r100.e(r210);
        System.currentTimeMillis();
        Process.myPid();
        if (this.f360306d == true) goto L181;
        HomeService r101 = HomeService.f344094a;
        r101.B();
        r101.R(r210);
        i r102 = b.f346407a;
        com.larus.init.task.imsdk.i r103 = com.larus.init.task.imsdk.i.f351372a;
        Intrinsics.checkNotNullParameter(r103, "appHost");
        b.f346407a = r103;
        q r104 = FlowRuntime.f346398a;
        FlowRuntime.c(n.f351434a);
        f.a(r210);
        LifecycleMonitor r105 = LifecycleMonitor.f360292a;
        r105.getClass();
        Intrinsics.checkNotNullParameter(this, "app");
        LifecycleMonitor.f360293b = System.currentTimeMillis();
        LifecycleMonitor.f360299h = this;
        r105.a(this, "attachBaseContext, process:" + com.bytedance.apm.d.c());
        InitContext.f254569d.put("base", r210);
        r100.beforeAttachBaseContext(r210);
        om9.a.f524313a.getClass();
        Intrinsics.checkNotNullParameter(r210, "base");
        KevaBuilder r106 = KevaBuilder.getInstance();
        r106.setContext(r210);
        Intrinsics.checkNotNull(r106);
        com.larus.settings.coldboot.b.f368534a.getClass();
        com.larus.settings.coldboot.a r107 = com.larus.settings.coldboot.b.a(r210);
        boolean r108 = true;
        if (r107.f368531a == false) goto L13;
        r106.setInitRepoOpt(1);
    L13:
        if (r107.f368532b == false) goto L16;
        r106.setGetRepoLockOpt(true);
    L16:
        if (r107.f368533c == false) goto L187;
        r106.setEnableExecutorOpt(true);
    L187:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L21
        Object r110 = Result.m9449constructorimpl(Boolean.valueOf(com.bytedance.apm.d.l()));     // Catch: Throwable -> L21
    L23:
        Result.m9452exceptionOrNullimpl(r110);
        h r111 = null;
        if (Result.m9455isFailureimpl(r110) == false) goto L26;
        r110 = null;
    L26:
        Boolean r112 = (Boolean) r110;
        if (r112 != null) goto L30;
    L31:
        boolean r113 = false;
    L42:
        if (r113 == true) goto L179;
    L49:
        FlowRuntime.a().isOversea();
        ISecPrivacyService.a r114 = ISecPrivacyService.f326368a;
        r114.getClass();
        ISecPrivacyService r115 = ISecPrivacyService.a.a();
        if (r115 == null) goto L52;
        r115.g(r210);
    L52:
        v19.f.a(r210.getTheme());
        r114.getClass();
        ISecPrivacyService r116 = ISecPrivacyService.a.a();
        if (r116 == null) goto L55;
        boolean r117 = r116.h();
    L56:
        AppLaunchTracer r118 = AppLaunchTracer.f274169a;
        Map r119 = MapsKt.mapOf(new Pair[]{TuplesKt.to("launch_time", this.f360304b.getSecond()), TuplesKt.to("agree_privacy", Boolean.valueOf(r117))});
        r118.getClass();
        AppLaunchTracer.e(r119);
        FlowRuntime.a().isOversea();
        IApmTrace.Companion r120 = IApmTrace.f286937a;
        if (r117 == false) goto L59;
        String r121 = "1";
    L60:
        r120.a("privacy_agreed", r121);
        String r122 = IExtraParams.f286942a.b();
        if (r122.length() != 0) goto L63;
        boolean r123 = true;
    L64:
        if (r123 == false) goto L66;
        r122 = "obric";
    L66:
        r120.d("flow_app_variant", r122);
        Map<String, String> r124 = ObricConfigServiceDelegate.f387835b.getCommonParams();
        if (r124 == null) goto L72;
        Iterator<Map.Entry<String, String>> r125 = r124.entrySet().iterator();
    L70:
        if (r125.hasNext() == false) goto L72;
        Map.Entry<String, String> r126 = r125.next();
        IApmTrace.f286937a.d(r126.getKey(), r126.getValue());
    L72:
        IApmTrace.Companion r127 = IApmTrace.f286937a;
        r127.a("git_branch", "obric/rls/15.2.0.1");
        r127.a("git_commit", "fc4b8ba9c915");
        Integer r128 = 887485629;
        if (r128.intValue() <= 0) goto L75;
        boolean r129 = true;
    L76:
        if (r129 == true) goto L79;
        r128 = null;
    L79:
        if (r128 == null) goto L81;
        r127.a("build_job_id", String.valueOf(r128.intValue()));
    L81:
        IAbTestInitiator r130 = (IAbTestInitiator) ServiceManager.get().getService(IAbTestInitiator.class);
        if (r130 == null) goto L84;
        r130.b();
    L84:
        IBootProtectorLauncher.f317602a.getClass();
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        IBootProtectorLauncher r131 = IBootProtectorLauncher.a.c();
        if (r131 == null) goto L87;
        r131.init(r210);
    L87:
        Intrinsics.checkNotNullParameter(r210, "baseContext");
        IBootProtectorLauncher r132 = IBootProtectorLauncher.a.c();
        if (r132 == null) goto L90;
        boolean r133 = r132.c(r210);
    L91:
        FlowRuntime.b().a().isOversea();
        if (r117 == true) goto L101;
        SecurityService r134 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r134 != null) goto L96;
    L98:
        boolean r135 = false;
    L99:
        if (r135 == false) goto L101;
        h r136 = new p();
    L104:
        this.f360305c = r136;
        r136.beforeAttachBaseContext(r210);
        super.attachBaseContext(r210);
        m.f351424a.getClass();
        if (m.a() == true) goto L107;
    L168:
        int r137 = g.f514502a;
        com.larus.utils.gson.d r138 = com.larus.utils.gson.d.f375407a;
        g.a r139 = new g.a();
        r138.getClass();
        com.larus.utils.gson.d.f375408b = r139;
        r139.log("init");
        h r140 = this.f360305c;
        if (r140 != null) goto L171;
        Intrinsics.throwUninitializedPropertyAccessException("launcher");
    L172:
        r111.afterAttachBaseContext(r210);
        ObricAppServiceDelegate.f392824b.f(this);
        if (com.bytedance.apm.d.l() == false) goto L177;
        IZlinkService r141 = (IZlinkService) ServiceManager.get().getService(IZlinkService.class);
        if (r141 == null) goto L177;
        r141.b();
    L177:
        HomeService.f344094a.u();
        return;
    L171:
        r111 = r140;
        goto L172
    L107:
        if (com.bytedance.apm.d.l() == false) goto L168;
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r142 = Build.VERSION.SDK_INT;
        if (r142 >= 35) goto L183;
        FLogger r143 = FLogger.f375446a;
        r143.i("BackgroundLazyInit", "system launch source unavailable: sdk=" + r142);
        m.f351426c = false;
        r143.i("BackgroundLazyInit", "event=background_launch_state, isBackground=false");
        goto L168
    L183:
        Result.Companion r144 = Result.Companion;     // Catch: Throwable -> L127
        Object r145 = r210.getSystemService("activity");     // Catch: Throwable -> L127
        if ((r145 instanceof ActivityManager) == false) goto L114;
        ActivityManager r146 = (ActivityManager) r145;     // Catch: Throwable -> L127
    L115:
        if (r146 != null) goto L117;
        ApplicationStartInfo r147 = null;
    L125:
        Object r148 = Result.m9449constructorimpl(r147);     // Catch: Throwable -> L127
    L129:
        Throwable r149 = Result.m9452exceptionOrNullimpl(r148);
        if (r149 == null) goto L133;
        FLogger.f375446a.w("BackgroundLazyInit", "read system launch source failed", r149);
    L133:
        if (Result.m9455isFailureimpl(r148) == false) goto L135;
        r148 = null;
    L135:
        ApplicationStartInfo r150 = (ApplicationStartInfo) r148;
        if (r150 == null) goto L138;
        Integer r151 = Integer.valueOf(r150.getReason());
    L139:
        if (r151 == null) goto L158;
        int r152 = r151.intValue();
        if (r152 == 0) goto L155;
        if (r152 == 1) goto L155;
        if (r152 == 2) goto L155;
        if (r152 == 3) goto L155;
        if (r152 == 4) goto L155;
        if (r152 == 5) goto L155;
        if (r152 == 9) goto L155;
        if (r152 == 10) goto L155;
        boolean r153 = false;
    L156:
        if (r153 == false) goto L158;
    L159:
        FLogger r154 = FLogger.f375446a;
        StringBuilder r155 = new StringBuilder("event=system_launch_source, reason=");
        r155.append(r151);
        r155.append(", startType=");
        if (r150 == null) goto L162;
        Integer r156 = Integer.valueOf(r150.getStartType());
    L163:
        r155.append(r156);
        r155.append(", wasForceStopped=");
        if (r150 == null) goto L166;
        Boolean r157 = Boolean.valueOf(r150.wasForceStopped());
    L167:
        r155.append(r157);
        r155.append(", confirmedBackground=");
        r155.append(r108);
        r154.i("BackgroundLazyInit", r155.toString());
        m.f351426c = r108;
        r154.i("BackgroundLazyInit", "event=background_launch_state, isBackground=" + r108);
        goto L168
    L166:
        r157 = null;
        goto L167
    L162:
        r156 = null;
    L155:
        r153 = true;
    L158:
        r108 = false;
        goto L159
    L138:
        r151 = null;
        goto L139
    L117:
        String r158 = Application.getProcessName();     // Catch: Throwable -> L127
        Iterator r159 = r146.getHistoricalProcessStartReasons(16).iterator();     // Catch: Throwable -> L127
    L119:
        if (r159.hasNext() == false) goto L123;
        Object r160 = r159.next();     // Catch: Throwable -> L127
        if (Intrinsics.areEqual(((ApplicationStartInfo) r160).getProcessName(), r158) == false) goto L119;
    L124:
        r147 = (ApplicationStartInfo) r160;     // Catch: Throwable -> L127
        goto L125
    L123:
        r160 = null;
        goto L124
    L114:
        r146 = null;
    L127:
        th = move-exception;
        Result.Companion r161 = Result.Companion;
        r148 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L129
    L96:
        if (r134.D() != true) goto L98;
        r135 = true;
    L101:
        if (r133 == false) goto L103;
        r136 = new e();
        goto L104
    L103:
        r136 = new r();
        goto L104
    L90:
        r133 = false;
        goto L91
    L75:
        r129 = false;
        goto L76
    L63:
        r123 = false;
        goto L64
    L59:
        r121 = "0";
        goto L60
    L55:
        r117 = false;
        goto L56
    L179:
        int r162 = om9.a.a(r210);     // Catch: Throwable -> L46
        ThreadPoolExecutor r163 = NewThreadPoolHelper.INSTANCE.newThreadPool(r162, r162, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ExemptThreadFactory("keva", false, false), new ThreadPoolExecutor.AbortPolicy());     // Catch: Throwable -> L46
        r163.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L46
        r106.setExecutor(r163);     // Catch: Throwable -> L46
        Object r164 = Result.m9449constructorimpl(Integer.valueOf(Log.i("NovaKevaInitializer", "enable Keva independent executor opt, corePoolSize=" + r162)));     // Catch: Throwable -> L46
    L48:
        Result.m9452exceptionOrNullimpl(r164);
    L46:
        th = move-exception;
        Result.Companion r165 = Result.Companion;
        r164 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L48
    L30:
        if (r112.booleanValue() == false) goto L31;
        com.larus.settings.coldboot.c.f368540a.getClass();
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r166 = EarlyFileSettingsStore.f368526a;     // Catch: Throwable -> L35
        Object r167 = Result.m9449constructorimpl(Boolean.valueOf(EarlyFileSettingsStore.b(r210, com.larus.settings.coldboot.c.f368541b)));     // Catch: Throwable -> L35
    L37:
        Result.m9452exceptionOrNullimpl(r167);
        Boolean r168 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r167) == false) goto L40;
        r167 = r168;
    L40:
        r113 = ((Boolean) r167).booleanValue();
    L35:
        th = move-exception;
        Result.Companion r169 = Result.Companion;
        r167 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L21:
        th = move-exception;
        Result.Companion r170 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    L181:
        HomeService.f344094a.R(r210);     // Catch: Throwable -> L6
        i r171 = b.f346407a;     // Catch: Throwable -> L6
        com.larus.init.task.imsdk.i r172 = com.larus.init.task.imsdk.i.f351372a;     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r172, "appHost");     // Catch: Throwable -> L6
        b.f346407a = r172;     // Catch: Throwable -> L6
        f.a(r210);     // Catch: Throwable -> L6
        r100.beforeAttachBaseContext(r210);     // Catch: Throwable -> L6
        super.attachBaseContext(r210);     // Catch: Throwable -> L6
        r100.f(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        ObricAppServiceDelegate.f392824b.c(r210);
        throw th;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection r100) {
        Intrinsics.checkNotNullParameter(r100, "conn");
        super.unbindService(r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        String r101 = e.getMessage();
        if (r101 != null) goto L9;
    L12:
        throw e;
    L9:
        if (StringsKt.contains$default(r101, "Service not registered", false, 2, null) == false) goto L12;
        FLogger.f375446a.e("NovaApplication", "Ignored Huawei & Honor WebView unbindService crash", e);
    }
}
