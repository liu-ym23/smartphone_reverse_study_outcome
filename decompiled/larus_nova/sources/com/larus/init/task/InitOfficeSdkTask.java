package com.larus.init.task;

import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.minutes.api.IMinutesService;
import com.larus.network.http.ServiceType;
import com.larus.office.base.OfficeSdkInitor;
import com.larus.platform.service.FlowDriveSdkService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.OfficeSDK;
import com.ss.android.lark.officesdk.api.api.OfficeSDKGlobalApi;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.officesdk.api.init.OfficeSDKInitConfig;
import com.ss.android.lark.officesdk.experiment.LaunchExperiment;
import com.ss.android.lark.officesdk.utils.di.ThreadUtil;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\u000eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/larus/init/task/InitOfficeSdkTask;", "Lcom/bytedance/lego/init/model/BaseFeedShowTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "bypassObricSkip", "", "scene", "", "getScene", "()Ljava/lang/String;", "runLazyInit", "", "runInternal", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitOfficeSdkTask extends bf6.a implements bg9.i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f351075c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f351076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f351077b;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes30.dex */
    public static final class b implements OfficeSdkInitor.a {
        public b() {
        }

        @Override // com.larus.office.base.OfficeSdkInitor.a
        public final void a(OfficeSDKUserApi r100) {
            Intrinsics.checkNotNullParameter(r100, "officeSDKUserApi");
            g0.f351329a.getClass();
            g0.a(r100);
        }

        @Override // com.larus.office.base.OfficeSdkInitor.a
        public final void b(OfficeSDKGlobalApi r100) {
            Intrinsics.checkNotNullParameter(r100, "officeSDKGlobalApi");
            FLogger.f375446a.w("InitOfficeSdkTask", "onSdkGlobalReady social_lazy");
        }
    }

    /* JADX INFO: loaded from: classes30.dex */
    public static final class c implements OfficeSdkInitor.a {
        public c() {
        }

        @Override // com.larus.office.base.OfficeSdkInitor.a
        public final void a(OfficeSDKUserApi r100) {
            Intrinsics.checkNotNullParameter(r100, "officeSDKUserApi");
            g0.f351329a.getClass();
            g0.a(r100);
        }

        @Override // com.larus.office.base.OfficeSdkInitor.a
        public final void b(OfficeSDKGlobalApi r100) {
            Intrinsics.checkNotNullParameter(r100, "officeSDKGlobalApi");
            FLogger.f375446a.w("InitOfficeSdkTask", "onSdkGlobalReady delay");
        }
    }

    static {
    }

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.larus.init.task.f0, java.lang.Object, java.lang.Runnable] */
    @Override // bg9.i
    public final void runInternal() {
        AtomicBoolean r100 = x0.f351465a;
        boolean r101 = true;
        if (this.f351076a == false) goto L5;
    L7:
        boolean r102 = false;
    L9:
        if (r102 == false) goto L12;
        FLogger.f375446a.i("InitOfficeSdkTask", "skip: lazy=true, deferred to first UI shown");
        return;
    L12:
        boolean r103 = com.larus.platform.exp.q.f365393a.b();
        z2 r104 = z2.f365865a;
        boolean r105 = r104.getDocFusionConfig().f547230a;
        boolean r106 = FlowDriveSdkService.f365704a.h();
        fr9.a r107 = r104.getAudioRecordConfig();
        IMinutesService r108 = (IMinutesService) ServiceManager.get().getService(IMinutesService.class);
        if (r108 != null) goto L15;
    L17:
        boolean r109 = false;
    L18:
        tq9.f r110 = r104.getDocFusionConfigV2();
        boolean r111 = Intrinsics.areEqual(r110.a(), "true");
        if (Intrinsics.areEqual(r110.c(), "init_after_cold_start") == false) goto L21;
    L24:
        boolean r112 = true;
    L25:
        g0.f351329a.b();
        if (r107.a() == false) goto L30;
        if (r107.b() == false) goto L30;
    L36:
        AtomicBoolean r113 = OfficeSDK.f433090a;
        LaunchExperiment r114 = OfficeSDK.f433091b.f530687a;
        FLogger r115 = FLogger.f375446a;
        r115.i("InitOfficeSdkTask", "Init office sdk, hit docHit=" + r105 + ", launchExperiment=" + r114 + ", minutesHit=" + r107 + ", needRestoreMMSdk=" + r109 + ", driveHit=" + r106 + "，socialHit=" + r103 + ", newDocHit=" + r110.a() + ", initStrategy=" + r110.c() + ", initDelay=" + r110.b());
        if (r103 == true) goto L39;
    L41:
        if (r101 == false) goto L46;
        int r116 = r104.getDocFusionConfigV2().b();
        Lazy<Handler> r117 = ThreadUtil.f437211a;
        ?? r118 = new f0();
        long r119 = ((long) r116) * 1000;
        Intrinsics.checkNotNullParameter(r118, "runnable");
        ntb.w r120 = ThreadUtil.a.c();
        if (r120 == 0) goto L45;
        r120.u(r118, r119);
        return;
    L45:
        ThreadUtil.f437211a.getValue().postDelayed(r118, r119);
        return;
    L46:
        r115.i("InitOfficeSdkTask", "not init office in this task");
        return;
    L39:
        if (r114 != LaunchExperiment.LAUNCH_ALL_AFTER) goto L41;
        r115.i("InitOfficeSdkTask", "im sdk task init lazy");
        OfficeSDKInitConfig.InitStageConfig r121 = new OfficeSDKInitConfig.InitStageConfig(OfficeSDKInitConfig.RuntimeType.ASYNC);
        OfficeSdkInitor r122 = OfficeSdkInitor.f360451a;
        b r123 = new b();
        r122.getClass();
        OfficeSdkInitor.f(r121, r123, "InitOfficeSdkTask#social_lazy", false);
        return;
    L30:
        if (r107.a() == false) goto L32;
        if (r109 == true) goto L36;
    L32:
        if (r111 == false) goto L35;
        if (r112 == true) goto L36;
    L35:
        r101 = false;
        goto L36
    L21:
        if (Intrinsics.areEqual(r110.c(), "init_after_cold_start_with_delay") == true) goto L24;
        r112 = false;
        goto L25
    L15:
        if (r108.H0() != true) goto L17;
        r109 = true;
        goto L18
    L5:
        if (x0.a() == false) goto L7;
        r102 = true;
        goto L9
    }

    public InitOfficeSdkTask() {
        this.f351077b = ServiceType.OFFICE;
    }

    @Override // java.lang.Runnable, bg9.i
    public final void run() {
        bg9.i.a.a(this);     // Catch: Throwable -> L4
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
        return this.f351077b;
    }
}
