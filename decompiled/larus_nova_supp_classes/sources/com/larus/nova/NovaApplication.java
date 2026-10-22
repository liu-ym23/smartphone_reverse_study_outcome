package com.larus.nova;

import android.app.ActivityManager;
import android.app.Application;
import android.app.ApplicationStartInfo;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.util.EventsUtils;
import android.util.Log;
import com.bytedance.frameworks.baselib.network.http.cronet.TTAppStateManager;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.lego.init.util.InitContext;
import com.bytedance.mira.log.MiraMonitor;
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
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/nova/NovaApplication;", "Lcom/larus/OfficeSDKHiltApplication;", "<init>", "()V", "startTime", "Lkotlin/Pair;", XmlPullParser.NO_NAMESPACE, "getStartTime", "()Lkotlin/Pair;", "launcher", "Lcom/larus/nova/ILauncher;", "earlyStartupTakenOver", XmlPullParser.NO_NAMESPACE, "attachBaseContext", XmlPullParser.NO_NAMESPACE, "base", "Landroid/content/Context;", "traceApmCommonParams", "checkAgreed", "isOversea", "getApplicationContext", "onCreate", "unbindService", "conn", "Landroid/content/ServiceConnection;", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class NovaApplication extends OfficeSDKHiltApplication {
    public static NovaApplication e;
    public final Pair<Long, Long> b;
    public h c;
    public boolean d;

    public static final class a {
        public static NovaApplication a() {
            NovaApplication r0 = NovaApplication.e;
            if (r0 == null) goto L5;
            return r0;
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
        this.b = new Pair(Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(System.currentTimeMillis()));
        e = this;
        InitContext.d.put("application", this);
    }

    @Override // android.app.Application
    public final void onCreate() {
        long r0 = System.currentTimeMillis();
        if (this.d == true) goto L33;
        ObricAppServiceDelegate r2 = ObricAppServiceDelegate.b;
        r2.b(this);
        AppLaunchTracer r3 = AppLaunchTracer.a;
        r3.getClass();
        ((c) AppLaunchTracer.c.getValue()).a(null);
        r3.c("app_create", null);
        h r4 = this.c;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("launcher");
        r4 = null;
    L12:
        r4.b(this);
        super.onCreate();
        d r5 = d.a;
        i r6 = b.a;
        Intrinsics.checkNotNull(r6);
        NovaApplication r7 = r6.getApplication();
        Intrinsics.checkNotNullParameter(r7, "app");
        if (d.b == true) goto L23;
        monitor-enter(r5);
    L28:
        th = move-exception;
        throw th;
    L17:
        if (d.b == false) goto L21;
        monitor-exit(r5);
        goto L23
    L21:
        d.b = true;     // Catch: Throwable -> L28
        r7.registerActivityLifecycleCallbacks(r5);     // Catch: Throwable -> L28
        jm9.c.a.a();     // Catch: Throwable -> L28
        FLogger.a.i("AppStartManager", "AppStartManager initialized");     // Catch: Throwable -> L28
        TTAppStateManager.setAppStartUpState(TTAppStateManager.AppStartState.ColdStart);     // Catch: Throwable -> L28
        d.b(AppStartState.ColdStart);     // Catch: Throwable -> L28
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r5);
    L23:
        h r9 = this.c;
        if (r9 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("launcher");
        r9 = null;
    L26:
        r9.a(this);
        r3.b("app_create", null);
        r2.a(this);
        HomeService.a.I(r0);
        return;
    L33:
        ObricAppServiceDelegate r1 = ObricAppServiceDelegate.b;     // Catch: Throwable -> L6
        r1.b(this);     // Catch: Throwable -> L6
        super.onCreate();     // Catch: Throwable -> L6
        r1.a(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        ObricAppServiceDelegate.b.c(this);
        throw th;
    }

    @Override // com.larus.OfficeSDKHiltApplication, android.content.ContextWrapper
    public final void attachBaseContext(Context r20) {
        Intrinsics.checkNotNullParameter(r20, "base");
        ObricAppServiceDelegate r3 = ObricAppServiceDelegate.b;
        this.d = r3.e(r20);
        System.currentTimeMillis();
        Process.myPid();
        if (this.d == true) goto L181;
        HomeService r4 = HomeService.a;
        r4.B();
        r4.R(r20);
        i r5 = b.a;
        com.larus.init.task.imsdk.i r6 = com.larus.init.task.imsdk.i.a;
        Intrinsics.checkNotNullParameter(r6, "appHost");
        b.a = r6;
        q r7 = FlowRuntime.a;
        FlowRuntime.c(n.a);
        f.a(r20);
        LifecycleMonitor r8 = LifecycleMonitor.a;
        r8.getClass();
        Intrinsics.checkNotNullParameter(this, "app");
        LifecycleMonitor.b = System.currentTimeMillis();
        LifecycleMonitor.h = this;
        r8.a(this, "attachBaseContext, process:" + com.bytedance.apm.d.c());
        InitContext.d.put("base", r20);
        r3.beforeAttachBaseContext(r20);
        om9.a.a.getClass();
        Intrinsics.checkNotNullParameter(r20, "base");
        KevaBuilder r9 = KevaBuilder.getInstance();
        r9.setContext(r20);
        Intrinsics.checkNotNull(r9);
        com.larus.settings.coldboot.b.a.getClass();
        com.larus.settings.coldboot.a r0 = com.larus.settings.coldboot.b.a(r20);
        boolean r10 = true;
        if (r0.a == false) goto L13;
        r9.setInitRepoOpt(1);
    L13:
        if (r0.b == false) goto L16;
        r9.setGetRepoLockOpt(true);
    L16:
        if (r0.c == false) goto L187;
        r9.setEnableExecutorOpt(true);
    L187:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L21
        Object r2 = Result.m49constructorimpl(Boolean.valueOf(com.bytedance.apm.d.l()));     // Catch: Throwable -> L21
    L23:
        Result.m52exceptionOrNullimpl(r2);
        h r11 = null;
        if (Result.m55isFailureimpl(r2) == false) goto L26;
        r2 = null;
    L26:
        Boolean r12 = (Boolean) r2;
        if (r12 != null) goto L30;
    L31:
        boolean r13 = false;
    L42:
        if (r13 == true) goto L179;
    L49:
        FlowRuntime.a().isOversea();
        ISecPrivacyService.a r14 = ISecPrivacyService.a;
        r14.getClass();
        ISecPrivacyService r15 = ISecPrivacyService.a.a();
        if (r15 == null) goto L52;
        r15.g(r20);
    L52:
        v19.f.a(r20.getTheme());
        r14.getClass();
        ISecPrivacyService r16 = ISecPrivacyService.a.a();
        if (r16 == null) goto L55;
        boolean r17 = r16.h();
    L56:
        AppLaunchTracer r18 = AppLaunchTracer.a;
        Map r19 = MapsKt.mapOf(new Pair[]{TuplesKt.to("launch_time", this.b.getSecond()), TuplesKt.to("agree_privacy", Boolean.valueOf(r17))});
        r18.getClass();
        AppLaunchTracer.e(r19);
        FlowRuntime.a().isOversea();
        IApmTrace.Companion r21 = IApmTrace.a;
        if (r17 == false) goto L59;
        String r22 = "1";
    L60:
        r21.a("privacy_agreed", r22);
        String r23 = IExtraParams.a.b();
        if (r23.length() != 0) goto L63;
        boolean r110 = true;
    L64:
        if (r110 == false) goto L66;
        r23 = "obric";
    L66:
        r21.d("flow_app_variant", r23);
        Map<String, String> r24 = ObricConfigServiceDelegate.b.getCommonParams();
        if (r24 == null) goto L72;
        Iterator<Map.Entry<String, String>> r25 = r24.entrySet().iterator();
    L70:
        if (r25.hasNext() == false) goto L72;
        Map.Entry<String, String> r26 = r25.next();
        IApmTrace.a.d(r26.getKey(), r26.getValue());
    L72:
        IApmTrace.Companion r28 = IApmTrace.a;
        r28.a("git_branch", "obric/rls/15.2.0.1");
        r28.a("git_commit", "fc4b8ba9c915");
        Integer r29 = 887485629;
        if (r29.intValue() <= 0) goto L75;
        boolean r111 = true;
    L76:
        if (r111 == true) goto L79;
        r29 = null;
    L79:
        if (r29 == null) goto L81;
        r28.a("build_job_id", String.valueOf(r29.intValue()));
    L81:
        IAbTestInitiator r30 = (IAbTestInitiator) ServiceManager.get().getService(IAbTestInitiator.class);
        if (r30 == null) goto L84;
        r30.b();
    L84:
        IBootProtectorLauncher.a.getClass();
        Intrinsics.checkNotNullParameter(r20, "context");
        IBootProtectorLauncher r31 = IBootProtectorLauncher.a.c();
        if (r31 == null) goto L87;
        r31.init(r20);
    L87:
        Intrinsics.checkNotNullParameter(r20, "baseContext");
        IBootProtectorLauncher r32 = IBootProtectorLauncher.a.c();
        if (r32 == null) goto L90;
        boolean r33 = r32.c(r20);
    L91:
        FlowRuntime.b().a().isOversea();
        if (r17 == true) goto L101;
        SecurityService r34 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r34 != null) goto L96;
    L98:
        boolean r35 = false;
    L99:
        if (r35 == false) goto L101;
        p r36 = new p();
    L104:
        this.c = r36;
        r36.beforeAttachBaseContext(r20);
        super.attachBaseContext(r20);
        m.a.getClass();
        if (m.a() == true) goto L107;
    L168:
        int r37 = g.a;
        com.larus.utils.gson.d r38 = com.larus.utils.gson.d.a;
        g.a r39 = new g.a();
        r38.getClass();
        com.larus.utils.gson.d.b = r39;
        r39.log("init");
        h r40 = this.c;
        if (r40 != null) goto L171;
        Intrinsics.throwUninitializedPropertyAccessException("launcher");
    L172:
        r11.afterAttachBaseContext(r20);
        ObricAppServiceDelegate.b.f(this);
        if (com.bytedance.apm.d.l() == false) goto L177;
        IZlinkService r41 = (IZlinkService) ServiceManager.get().getService(IZlinkService.class);
        if (r41 == null) goto L177;
        r41.b();
    L177:
        HomeService.a.u();
        return;
    L171:
        r11 = r40;
        goto L172
    L107:
        if (com.bytedance.apm.d.l() == false) goto L168;
        Intrinsics.checkNotNullParameter(r20, "context");
        int r42 = Build.VERSION.SDK_INT;
        if (r42 >= 35) goto L183;
        FLogger r43 = FLogger.a;
        r43.i("BackgroundLazyInit", "system launch source unavailable: sdk=" + r42);
        m.c = false;
        r43.i("BackgroundLazyInit", "event=background_launch_state, isBackground=false");
        goto L168
    L183:
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L127
        Object r45 = r20.getSystemService("activity");     // Catch: Throwable -> L127
        if ((r45 instanceof ActivityManager) == false) goto L114;
        ActivityManager r46 = (ActivityManager) r45;     // Catch: Throwable -> L127
    L115:
        if (r46 != null) goto L117;
        ApplicationStartInfo r47 = null;
    L125:
        Object r48 = Result.m49constructorimpl(r47);     // Catch: Throwable -> L127
    L129:
        Throwable r49 = Result.m52exceptionOrNullimpl(r48);
        if (r49 == null) goto L133;
        FLogger.a.w("BackgroundLazyInit", "read system launch source failed", r49);
    L133:
        if (Result.m55isFailureimpl(r48) == false) goto L135;
        r48 = null;
    L135:
        ApplicationStartInfo r50 = (ApplicationStartInfo) r48;
        if (r50 == null) goto L138;
        Integer r51 = Integer.valueOf(r50.getReason());
    L139:
        if (r51 == null) goto L158;
        int r52 = r51.intValue();
        if (r52 == 0) goto L155;
        if (r52 == 1) goto L155;
        if (r52 == 2) goto L155;
        if (r52 == 3) goto L155;
        if (r52 == 4) goto L155;
        if (r52 == 5) goto L155;
        if (r52 == 9) goto L155;
        if (r52 == 10) goto L155;
        boolean r53 = false;
    L156:
        if (r53 == false) goto L158;
    L159:
        FLogger r54 = FLogger.a;
        StringBuilder r55 = new StringBuilder("event=system_launch_source, reason=");
        r55.append(r51);
        r55.append(", startType=");
        if (r50 == null) goto L162;
        Integer r56 = Integer.valueOf(r50.getStartType());
    L163:
        r55.append(r56);
        r55.append(", wasForceStopped=");
        if (r50 == null) goto L166;
        Boolean r57 = Boolean.valueOf(r50.wasForceStopped());
    L167:
        r55.append(r57);
        r55.append(", confirmedBackground=");
        r55.append(r10);
        r54.i("BackgroundLazyInit", r55.toString());
        m.c = r10;
        r54.i("BackgroundLazyInit", "event=background_launch_state, isBackground=" + r10);
        goto L168
    L166:
        r57 = null;
        goto L167
    L162:
        r56 = null;
    L155:
        r53 = true;
    L158:
        r10 = false;
        goto L159
    L138:
        r51 = null;
        goto L139
    L117:
        String r58 = Application.getProcessName();     // Catch: Throwable -> L127
        Iterator r59 = r46.getHistoricalProcessStartReasons(16).iterator();     // Catch: Throwable -> L127
    L119:
        if (r59.hasNext() == false) goto L123;
        Object r60 = r59.next();     // Catch: Throwable -> L127
        if (Intrinsics.areEqual(((ApplicationStartInfo) r60).getProcessName(), r58) == false) goto L119;
    L124:
        r47 = (ApplicationStartInfo) r60;     // Catch: Throwable -> L127
        goto L125
    L123:
        r60 = null;
        goto L124
    L114:
        r46 = null;
    L127:
        th = move-exception;
        Result.Companion r61 = Result.Companion;
        r48 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L129
    L96:
        if (r34.D() != true) goto L98;
        r35 = true;
    L101:
        if (r33 == false) goto L103;
        r36 = new e();
        goto L104
    L103:
        r36 = new r();
        goto L104
    L90:
        r33 = false;
        goto L91
    L75:
        r111 = false;
        goto L76
    L63:
        r110 = false;
        goto L64
    L59:
        r22 = MiraMonitor.VALUE_DEFAULT;
        goto L60
    L55:
        r17 = false;
        goto L56
    L179:
        int r62 = om9.a.a(r20);     // Catch: Throwable -> L46
        ThreadPoolExecutor r63 = NewThreadPoolHelper.INSTANCE.newThreadPool(r62, r62, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ExemptThreadFactory("keva", false, false), new ThreadPoolExecutor.AbortPolicy());     // Catch: Throwable -> L46
        r63.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L46
        r9.setExecutor(r63);     // Catch: Throwable -> L46
        Object r64 = Result.m49constructorimpl(Integer.valueOf(Log.i("NovaKevaInitializer", "enable Keva independent executor opt, corePoolSize=" + r62)));     // Catch: Throwable -> L46
    L48:
        Result.m52exceptionOrNullimpl(r64);
    L46:
        th = move-exception;
        Result.Companion r65 = Result.Companion;
        r64 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L48
    L30:
        if (r12.booleanValue() == false) goto L31;
        com.larus.settings.coldboot.c.a.getClass();
        Intrinsics.checkNotNullParameter(r20, "context");
        int r66 = EarlyFileSettingsStore.a;     // Catch: Throwable -> L35
        Object r67 = Result.m49constructorimpl(Boolean.valueOf(EarlyFileSettingsStore.b(r20, com.larus.settings.coldboot.c.b)));     // Catch: Throwable -> L35
    L37:
        Result.m52exceptionOrNullimpl(r67);
        Boolean r68 = Boolean.FALSE;
        if (Result.m55isFailureimpl(r67) == false) goto L40;
        r67 = r68;
    L40:
        r13 = ((Boolean) r67).booleanValue();
    L35:
        th = move-exception;
        Result.Companion r69 = Result.Companion;
        r67 = Result.m49constructorimpl(ResultKt.createFailure(th));
    L21:
        th = move-exception;
        Result.Companion r70 = Result.Companion;
        r2 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L23
    L181:
        HomeService.a.R(r20);     // Catch: Throwable -> L6
        i r71 = b.a;     // Catch: Throwable -> L6
        com.larus.init.task.imsdk.i r72 = com.larus.init.task.imsdk.i.a;     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r72, "appHost");     // Catch: Throwable -> L6
        b.a = r72;     // Catch: Throwable -> L6
        f.a(r20);     // Catch: Throwable -> L6
        r3.beforeAttachBaseContext(r20);     // Catch: Throwable -> L6
        super.attachBaseContext(r20);     // Catch: Throwable -> L6
        r3.f(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        ObricAppServiceDelegate.b.c(r20);
        throw th;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection r6) {
        Intrinsics.checkNotNullParameter(r6, "conn");
        super.unbindService(r6);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        String r0 = e.getMessage();
        if (r0 != null) goto L9;
    L12:
        throw e;
    L9:
        if (StringsKt.contains$default(r0, "Service not registered", false, 2, null) == false) goto L12;
        FLogger.a.e("NovaApplication", "Ignored Huawei & Honor WebView unbindService crash", e);
    }
}
