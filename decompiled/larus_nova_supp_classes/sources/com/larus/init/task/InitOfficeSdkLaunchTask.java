package com.larus.init.task;

import android.util.EventsUtils;
import bf6.d;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.drive.sdk.api.IDriveSdkServiceV2;
import com.larus.larkfeed.IFlowLarkFeedApi;
import com.larus.office.base.OfficeSdkInitor;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.OfficeSDK;
import com.ss.android.lark.officesdk.api.init.OfficeSDKInitConfig;
import com.ss.android.lark.officesdk.experiment.LaunchExperiment;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/larus/init/task/InitOfficeSdkLaunchTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "bypassObricSkip", XmlPullParser.NO_NAMESPACE, "scene", XmlPullParser.NO_NAMESPACE, "getScene", "()Ljava/lang/String;", "runLazyInit", XmlPullParser.NO_NAMESPACE, "runInternal", "initOfficeSdk", "runtimeType", "Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$RuntimeType;", "isRecreate", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitOfficeSdkLaunchTask extends d implements bg9.i {
    public boolean a;
    public final String b;

    public static final class a {
    }

    static {
    }

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        if (z2.a.getLarkSocialInitConfig().a() == true) goto L5;
    L8:
        IOfficeSdkServiceV2 r0 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r0 == null) goto L11;
        r0.w0();
    L11:
        IDriveSdkServiceV2 r1 = (IDriveSdkServiceV2) ServiceManager.get().getService(IDriveSdkServiceV2.class);
        if (r1 == null) goto L14;
        r1.h();
    L14:
        LarkContext.setApplication(AppHost.a.getApplication());
        AtomicBoolean r2 = x0.a;
        if (this.a == false) goto L17;
    L19:
        boolean r3 = false;
    L21:
        if (r3 == false) goto L24;
        FLogger.a.i("InitOfficeSdkLaunchTask", "skip: lazy=true, deferred to UI entry (tryInit)");
        return;
    L24:
        com.larus.platform.exp.q r4 = com.larus.platform.exp.q.a;
        boolean r5 = r4.b();
        LaunchExperiment.a r6 = LaunchExperiment.Companion;
        r4.a();
        int r7 = com.larus.platform.exp.q.d.get();
        r6.getClass();
        if (r7 == 0) goto L32;
        if (r7 != 1) goto L28;
        LaunchExperiment r8 = LaunchExperiment.LAUNCH_OFFICE_SDK_ALL;
    L33:
        FLogger r9 = FLogger.a;
        r9.i("InitOfficeSdkLaunchTask", "Init office im sdk, hit socialHit=" + r5 + ", performance=" + r8);
        AtomicBoolean r10 = OfficeSDK.a;
        ptb.a r11 = new ptb.a(r8);
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        OfficeSDK.b = r11;
        LaunchExperiment r12 = OfficeSDK.b.a;
        if (r5 == true) goto L36;
        r9.i("InitOfficeSdkLaunchTask", "not init office in this task");
    L39:
        IFlowLarkFeedApi.a.i();
        return;
    L36:
        if (r12.isBeforeFirstFeed() == false) goto L39;
        OfficeSDKInitConfig.RuntimeType r13 = OfficeSDKInitConfig.RuntimeType.ASYNC;
        g0.a.b();
        r9.i("InitOfficeSdkLaunchTask", "launch office sdk application, runtimeType=" + r13 + ", recreate=false");
        OfficeSDKInitConfig.InitStageConfig r14 = new OfficeSDKInitConfig.InitStageConfig(r13);
        OfficeSdkInitor r15 = OfficeSdkInitor.a;
        e0 r16 = new e0();
        r15.getClass();
        OfficeSdkInitor.f(r14, r16, "InitOfficeSdkLaunchTask", false);
        goto L39
    L28:
        if (r7 == 2) goto L30;
        r8 = LaunchExperiment.LAUNCH_ALL_AFTER;
        goto L33
    L30:
        r8 = LaunchExperiment.LAUNCH_ONLY_OFFICE_SDK;
        goto L33
    L32:
        r8 = LaunchExperiment.LAUNCH_ALL_AFTER;
        goto L33
    L17:
        if (x0.a() == false) goto L19;
        r3 = true;
        goto L21
    L5:
        if (y0.b.compareAndSet(false, true) == true) goto L7;
        FLogger.a.i("InitOfficeImSdkTask", "registerOnce skipped, already registered");
        goto L8
    L7:
        y0 r17 = new y0();
        r17.a.registerActivityLifecycleCallbacks(new z0(r17));
        goto L8
    }

    public InitOfficeSdkLaunchTask() {
        this.b = "Office";
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
        return this.b;
    }
}
