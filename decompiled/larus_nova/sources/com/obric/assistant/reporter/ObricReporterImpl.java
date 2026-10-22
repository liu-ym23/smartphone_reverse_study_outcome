package com.obric.assistant.reporter;

import android.os.SystemClock;
import android.provider.Settings;
import com.bytedance.applog.AppLog;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.im.IInstantMessenger;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.IObricPluginActivityRecordHelper;
import com.obric.assistant.applog.AppLogIDLStub;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.reporter.utils.AppStartState;
import com.obric.assistant.reporter.utils.ObricLaunchReportManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import nba.i;
import nba.l;
import org.json.JSONObject;
import v48.g;
import v48.h;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J \u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\fH\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016J\b\u0010$\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\u0007H\u0016J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\nH\u0016J\b\u0010)\u001a\u00020\nH\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\u0005H\u0016R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/assistant/reporter/ObricReporterImpl;", "Lcom/obric/assistant/reporter/IObricReporter;", "<init>", "()V", "reportPerformanceCost", "", "scene", "", "stage", "costMs", "", "success", "", "extra", "", "flushCachedDialogClicks", "lastBackgroundTime", "launchMethod", "launchWakeup", "launchService", "dataLock", "", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "updateLaunchReportParams", "allowUpdateInForeground", "updateLaunchServiceParams", "updateWakeupSource", "source", "resetLaunchReportParams", "getLaunchMethod", "getLaunchService", "getKeepAliveLevelMode", "getLastLaunchType", "", "initObricAppStartManager", "getCurrentProcessAdj", "markStartedByExternalKeepAliveNormalService", "getWakeupSource", "setLastBackgroundTime", "time", "getLastBackgroundTime", "initLaunchReport", "initFrontierReport", "initBuildChannelWriteValue", "initFlowAppLogObserver", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricReporterImpl implements IObricReporter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f391339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f391340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f391341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f391342e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CoroutineScope f391343f;

    /* JADX INFO: loaded from: classes4.dex */
    public static final class a {
    }

    public static final class b implements f09.a.b {
        public b() {
        }

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
        }

        @Override // f09.a.b
        public final void onAppBackground() {
        }

        @Override // f09.a.b
        public final void onAppForeground() {
            AppHost.Companion r100 = AppHost.f326268a;
            r100.a().c(this);
            int r101 = com.obric.assistant.reporter.a.f391351a;
            com.obric.assistant.reporter.a.a(r100.getApplication());
        }
    }

    public static final class c implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.obric.assistant.reporter.utils.f f391344a;

        public c() {
            ObricLaunchReportManager.f391417a.getClass();
            this.f391344a = new com.obric.assistant.reporter.utils.f();
        }

        @Override // v48.g
        public final void a(String r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r100, "activityName");
            Intrinsics.checkNotNullParameter(r101, "flatParams");
            this.f391344a.a(r100, r101);
        }

        @Override // v48.g
        public final void b(String r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r100, "activityName");
            Intrinsics.checkNotNullParameter(r101, "flatParams");
            this.f391344a.b(r100, r101);
        }
    }

    public static final class d implements h {
        public d() {
        }

        @Override // v48.h
        public final void onSessionBatchEvent(long r100, String r101) {
            FLogger.f375446a.i("ObricReporterImpl", "onSessionBatchEvent: id = " + r100 + ", sessonId = " + r101);
        }

        @Override // v48.h
        public final void onSessionStart(long r100, String r101) {
            FLogger.f375446a.i("ObricReporterImpl", "onSessionStart: id = " + r100 + ", sessonId = " + r101);
        }

        @Override // v48.h
        public final void onSessionTerminate(long r100, String r101) {
            FLogger r102 = FLogger.f375446a;
            r102.i("ObricReporterImpl", "onSessionTerminate: id = " + r100 + ", sessonId = " + r101);
            ObricLaunchReportManager.f391417a.getClass();
            StringBuilder r103 = new StringBuilder("reportTerminateForAssistant: sessionId = ");
            r103.append(r101);
            r102.i("ObricLaunchReportManager", r103.toString());
            Map<String, JSONObject> r104 = ObricLaunchReportManager.R;
            if (r101 != null) goto L5;
            String r105 = "";
        L6:
            JSONObject r106 = r104.get(r105);
            if (r106 != null) goto L9;
            r102.i("ObricLaunchReportManager", "reportTerminateForAssistant: sessionId = " + r101 + ", cachedParams is null");
            return;
        L9:
            r102.i("ObricLaunchReportManager", "cachedParams = " + r106);
            by7.g.f21473d.onEvent(ObricLaunchReportManager.f391419c, r106);
            return;
        L5:
            r105 = r101;
            goto L6
        }
    }

    static {
    }

    @Override // com.obric.assistant.reporter.IObricReporter
    public final String a() {
        Object r100 = this.f391342e;
        monitor-enter(r100);
        String r101 = this.f391339b;     // Catch: Throwable -> L7
        FLogger.f375446a.d("ObricReporterImpl", "@getLaunchMethod@ " + r101);     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.assistant.reporter.IObricReporter
    public final void c() {
        com.obric.assistant.reporter.utils.e r100 = com.obric.assistant.reporter.utils.e.f391444a;
        if (com.obric.assistant.reporter.utils.e.f391446c != AppStartState.ColdStart) goto L5;
        com.obric.assistant.reporter.utils.e.f391446c = AppStartState.WarmStart;
    L5:
        FLogger.f375446a.d("ObricReporterImpl", "markStartedByExternalKeepAliveNormalService");
    }

    @Override // com.obric.assistant.reporter.IObricReporter
    public final void d() {
        FLogger.f375446a.d("ObricReporterImpl", "resetLaunchReportParams");
        Object r100 = this.f391342e;
        monitor-enter(r100);
        this.f391339b = "other";     // Catch: Throwable -> L8
        this.f391341d = "open_doubao";     // Catch: Throwable -> L8
        this.f391340c = "voice.other";     // Catch: Throwable -> L8
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r100);
        IAssistantInteractionServiceKt.getInteractionStateService().setWakeUpAppPkg("other", "resetLaunchReportParams");
        return;
    L8:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.obric.assistant.reporter.ObricReporterImpl$initLaunchReport$2] */
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
    @Override // com.obric.assistant.reporter.IObricReporter
    public final void e() {
        IApplog.Companion r100 = IApplog.f287053a;
        r100.w(new c());
        r100.s(new ObricReporterImpl$initLaunchReport$2(this));
        r100.r(new d());
        Lazy r101 = com.obric.assistant.reporter.utils.c.f391443a;
        AppHost.f326268a.getApplication().registerActivityLifecycleCallbacks(new com.obric.assistant.reporter.utils.b());
    }

    @Override // com.obric.assistant.reporter.IObricReporter
    public final void f() {
        nba.c.f518562a.getClass();
        FLogger.f375446a.d(AppLogIDLStub.TAG, "init FlowAppLogObserverHelper");
        AppLog.addSessionHook(new nba.g());
        AppLog.addEventObserver(new i());
        AppLog.addDataObserver(new l());
    }

    @Override // com.obric.assistant.reporter.IObricReporter
    public final void g() {
        Object r100 = this.f391342e;
        monitor-enter(r100);
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.assistant.reporter.IObricReporter
    public final String getWakeupSource() {
        Object r100 = this.f391342e;
        monitor-enter(r100);
        String r101 = this.f391340c;     // Catch: Throwable -> L7
        FLogger.f375446a.d("ObricReporterImpl", "@getLaunchWakeup@ " + r101);     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.assistant.reporter.IObricReporter
    public final void i() {
        AppHost.Companion r100 = AppHost.f326268a;     // Catch: Exception -> L4
        Settings.Global.putString(r100.getApplication().getContentResolver(), "obric_app_channel_com_larus_nova", r100.getBuildChannel());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        FLogger.f375446a.e("ObricReporterImpl", "initBuildChannelWriteValue try to write settings value error: " + e);
    }

    @Override // com.obric.assistant.reporter.IObricReporter
    public final String j() {
        return ObricFeatureServiceDelegate.f387839b.f();
    }

    @Override // com.obric.assistant.reporter.IObricReporter
    public final void k() {
        com.obric.assistant.reporter.utils.e r100 = com.obric.assistant.reporter.utils.e.f391444a;
        if (com.obric.assistant.reporter.utils.e.f391445b == true) goto L20;
        monitor-enter(r100);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (com.obric.assistant.reporter.utils.e.f391445b == false) goto L11;
        monitor-exit(r100);
        return;
    L11:
        com.obric.assistant.reporter.utils.e.f391445b = true;     // Catch: Throwable -> L15
        com.obric.assistant.reporter.utils.e.f391447d = SystemClock.elapsedRealtime();     // Catch: Throwable -> L15
        AppHost.f326268a.a().j(com.obric.assistant.reporter.utils.e.f391448e);     // Catch: Throwable -> L15
        FLogger.f375446a.i("ObricAppStartManager", "ObricAppStartManager initialized: applicationOnCreateFinishedElapsedRealtime=" + com.obric.assistant.reporter.utils.e.f391447d);     // Catch: Throwable -> L15
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r100);
        t0.f375468a.postDelayed(new com.obric.assistant.reporter.utils.d(), 2000);
        return;
    }

    @Override // com.obric.assistant.reporter.IObricReporter
    public final String l() {
        Object r100 = this.f391342e;
        monitor-enter(r100);
        String r101 = this.f391341d;     // Catch: Throwable -> L7
        FLogger.f375446a.d("ObricReporterImpl", "@getLaunchService@ " + r101);     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.assistant.reporter.IObricReporter
    public final int m() {
        com.obric.assistant.reporter.utils.e r100 = com.obric.assistant.reporter.utils.e.f391444a;
        int r101 = com.obric.assistant.reporter.utils.e.f391446c.getValue();
        FLogger.f375446a.d("ObricReporterImpl", "getLastLaunchType: " + r101);
        return r101;
    }

    @Override // com.obric.assistant.reporter.IObricReporter
    public final void o() {
        AtomicReference<String> r100 = vfa.c.f554605a;
        IInstantMessenger r101 = (IInstantMessenger) ServiceManager.get().getService(IInstantMessenger.class);
        com.larus.im.network.f r102 = null;
        if (r101 == null) goto L5;
        com.larus.im.network.f r103 = r101.a(0);
    L6:
        if (r103 == null) goto L8;
        r103.a(new vfa.b());
    L8:
        IInstantMessenger r104 = (IInstantMessenger) ServiceManager.get().getService(IInstantMessenger.class);
        if (r104 == null) goto L11;
        r102 = r104.a(0);
    L11:
        if (r102 == null) goto L14;
        r102.i(new vfa.a());
        return;
    L14:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.obric.assistant.reporter.IObricReporter
    public final int q() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(Integer.valueOf(CastIntegerProtector.parseInt(StringsKt.trim(FilesKt.readText$default(new PolarisFileWrapper("/proc/self/oom_score_adj"), null, 1, null)).toString())));     // Catch: Throwable -> L4
    L6:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L10;
        FLogger.f375446a.w("ObricReporterImpl", "getCurrentProcessAdj failed", r102);
    L10:
        if (Result.m9455isFailureimpl(r101) == false) goto L12;
        r101 = -1;
    L12:
        Number r103 = (Number) r101;
        int r104 = r103.intValue();
        FLogger.f375446a.d("ObricReporterImpl", "getCurrentProcessAdj: " + r104);
        return r103.intValue();
    L4:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    @Override // com.obric.assistant.reporter.IObricReporter
    public final void r() {
        AppHost.Companion r100 = AppHost.f326268a;
        if (r100.a().isAppBackground() == true) goto L6;
        int r101 = com.obric.assistant.reporter.a.f391351a;
        com.obric.assistant.reporter.a.a(r100.getApplication());
        return;
    L6:
        FLogger.f375446a.i("ObricReporterImpl", "flushCachedDialogClicks: app in background, defer until foreground");
        r100.a().j(new b());
    }

    public ObricReporterImpl() {
        this.f391339b = "other";
        this.f391340c = "voice.other";
        this.f391341d = "open_doubao";
        this.f391342e = new Object();
        this.f391343f = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    }

    @Override // com.obric.assistant.reporter.IObricReporter
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "launchService");
        n(this.f391339b, r100, false);
    }

    @Override // com.obric.assistant.reporter.IObricReporter
    public final void p(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        FLogger.f375446a.d("ObricReporterImpl", "updateLaunchWakeupSource: wakeupSource = " + r100);
        Object r101 = this.f391342e;
        monitor-enter(r101);
        this.f391340c = r100;     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.assistant.reporter.IObricReporter
    public final void n(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "launchMethod");
        Intrinsics.checkNotNullParameter(r101, "launchService");
        FLogger r103 = FLogger.f375446a;
        r103.d("ObricReporterImpl", "setLaunchReportParams: launchMethod = " + r100 + ", launchService = " + r101 + ", allowUpdateInForeground = " + r102);
        IObricPluginActivityRecordHelper.f385120a.getClass();
        IObricPluginActivityRecordHelper r104 = IObricPluginActivityRecordHelper.a.a();
        if (r104 == null) goto L7;
        boolean r105 = true;
        if (r104.e() != true) goto L7;
    L8:
        if (r102 == false) goto L10;
    L14:
        Object r106 = this.f391342e;
        monitor-enter(r106);
        this.f391339b = r100;     // Catch: Throwable -> L19
        this.f391341d = r101;     // Catch: Throwable -> L19
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r106);
        return;
    L19:
        th = move-exception;
        throw th;
    L10:
        if (AppHost.f326268a.a().isAppBackground() == false) goto L12;
        if (r105 == false) goto L14;
    L12:
        r103.d("ObricReporterImpl", "is not allow update in foreground, ignore");
        return;
    L7:
        r105 = false;
        goto L8
    }

    @Override // com.obric.assistant.reporter.IObricReporter
    public final void h(String r110, String r111, long r112, boolean r113, Map<String, String> r114) {
        Intrinsics.checkNotNullParameter(r110, "scene");
        Intrinsics.checkNotNullParameter(r111, "stage");
        CoroutineScope r100 = e.f391353a;
        Intrinsics.checkNotNullParameter(r110, "scene");
        Intrinsics.checkNotNullParameter(r111, "stage");
        BuildersKt.launch$default(e.f391353a, null, null, new ObricPerformanceCostReporter$report$1(r110, r111, r112, r114, r113, null), 3, null);
    }
}
