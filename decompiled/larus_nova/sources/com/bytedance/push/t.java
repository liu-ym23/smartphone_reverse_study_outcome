package com.bytedance.push;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.push.trace.Constants;
import com.bytedance.android.service.manager.push.trace.PushTraceSceneType;
import com.bytedance.common.process.cross.CrossProcessHelper;
import com.bytedance.common.support.PushCommonSupport;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile t f267031c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f267032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f267033b;

    public class a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            PushServiceManager.get().getIRedBadgeExternalService().startOnWorkerProcess(w67.a.C8076a.f558434a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a() {
        }
    }

    public static t b() {
        if (f267031c != null) goto L15;
        monitor-enter(t.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f267031c != null) goto L9;
        f267031c = new t();     // Catch: Throwable -> L11
    L9:
        monitor-exit(t.class);     // Catch: Throwable -> L11
    L15:
        return f267031c;
    }

    public static void c() {
        com.bytedance.push.utils.f.b("ProcessLifeCycleObserver", "[onInitOnProcessIsolationProtectedMode]");
        if (a77.a.f2031a == null) goto L5;
    L14:
        a77.a r100 = a77.a.f2031a;
        Application r101 = c.O.f266761a;
        r100.getClass();
        if (ToolUtils.isMainProcess(r101) == false) goto L17;
    L18:
        CrossProcessHelper.getInstance().registerMethodObserver(r100);
    L19:
        c.O.getClass();
        com.bytedance.push.utils.f.b("ProcessLifeCycleObserver", "[onInitOnProcessIsolationProtectedMode]");
        PushThreadHandlerManager.inst().postRunnable(new o());
        if (PushCommonSupport.getInstance().getPushConfigurationService().keepOldInitTimeCostV2() == false) goto L22;
        v67.m r102 = PushSupporter.get().getPushNotificationManagerService();
        com.bytedance.push.notification.q r103 = (com.bytedance.push.notification.q) r102;
        r103.d(c.O.f266761a);
    L24:
        if (PushCommonSupport.getInstance().getPushConfigurationService().keepOldInitTimeCostV2() == false) goto L26;
        PushServiceManager.get().getIAllianceService().onInitOnProcessIsolationProtectedMode();
        return;
    L26:
        PushThreadHandlerManager.inst().postRunnable(new q());
        return;
    L22:
        PushThreadHandlerManager.inst().postRunnable(new p());
        goto L24
    L17:
        if (ToolUtils.isSmpProcess(r101) == false) goto L19;
    L5:
        monitor-enter(a77.a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (a77.a.f2031a != null) goto L9;
        a77.a.f2031a = new a77.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a77.a.class);     // Catch: Throwable -> L11
        goto L14
    }

    public final void a() {
        if (this.f267033b.getAndSet(true) == false) goto L5;
        return;
    L5:
        PushServiceManager.get().getPushTraceExternalService().getTraceScene(PushTraceSceneType.ALLIANCE_WAKEUP).enterNode(Constants.NODE_DO_ON_WORKER_PROCESS, "The logic of the worker process is executed");
        com.bytedance.push.utils.f.b("NON_MAIN_PROCESS_START_CONTROL", "ProcessLifeCycleObserver--> doOnWorkerProcess:start alliance");
        PushServiceManager.get().getIAllianceService().onWorkerApplicationStart();
        com.bytedance.push.utils.f.b("NON_MAIN_PROCESS_START_CONTROL", "ProcessLifeCycleObserver--> doOnWorkerProcess:start old red badge");
        PushThreadHandlerManager.inst().postRunnable(new a());
    }

    public t() {
        this.f267032a = false;
        this.f267033b = new AtomicBoolean(false);
    }

    public static void e(Context r100) {
        ToolUtils.setComponentEnable(r100, "com.xiaomi.push.service.receivers.MIPushMessageHandler", true);
        ToolUtils.setComponentEnable(r100, "com.xiaomi.push.service.receivers.SmpMIPushMessageHandler", false);
        ToolUtils.setComponentEnable(r100, "com.xiaomi.push.service.receivers.WidgetProviderMIPushMessageHandler", false);
        ToolUtils.setComponentEnable(r100, "com.heytap.msp.push.service.DataMessageCallbackService", true);
        ToolUtils.setComponentEnable(r100, "com.heytap.msp.push.service.SmpDataMessageCallbackService", false);
        ToolUtils.setComponentEnable(r100, "com.heytap.msp.push.service.CompatibleDataMessageCallbackService", true);
        ToolUtils.setComponentEnable(r100, "com.heytap.msp.push.service.SmpCompatibleDataMessageCallbackService", false);
    }

    public final void d(Context r100) {
        PushServiceManager.get().getPushTraceExternalService().getTraceScene(PushTraceSceneType.ALLIANCE_WAKEUP).enterNode(Constants.NODE_LIFECYCLE_START, "Start of LifeCycle");
        com.bytedance.push.utils.f.b("ProcessLifeCycleObserver", "on com.bytedance.push.ProcessLifeCycleObserver.start");
        com.bytedance.push.third.g.g().onStart();
        PushServiceManager.get().getPullExternalService().initOnApplication();
        boolean r101 = true;
        if (ToolUtils.isMainProcess(r100) == false) goto L15;
        if (PushCommonSupport.getInstance().getPushConfigurationService().keepOldInitTimeCost() == true) goto L12;
        if (((e77.c) PushSupporter.get().getProcessManagerService()).f471199c == ToolUtils.getCurProcess(r100)) goto L10;
        r101 = false;
    L10:
        this.f267032a = r101;
    L12:
        if (this.f267032a == false) goto L23;
        a();
        return;
    L23:
        return;
    L15:
        if (ToolUtils.isSmpProcess(r100) == false) goto L17;
        return;
    L17:
        if (((e77.c) PushSupporter.get().getProcessManagerService()).f471199c == ToolUtils.getCurProcess(r100)) goto L20;
        r101 = false;
    L20:
        if (r101 == false) goto L26;
        a();
        return;
    }
}
