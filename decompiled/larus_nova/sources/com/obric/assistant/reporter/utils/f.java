package com.obric.assistant.reporter.utils;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.base.interact.KeyguardLockedState;
import com.obric.assistant.reporter.IObricReporter;
import com.obric.assistant.trace.IObricTraceParam;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class f implements ow3.b {
    public f() {
    }

    @Override // ow3.b
    public final void a(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "flatParams");
        FLogger.f375446a.i("ObricLaunchReportManager", "onPause: called, report app terminate activityName = " + r100 + ", flatParams = " + r101);
    }

    @Override // ow3.b
    public final void b(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "flatParams");
        KeyguardLockedState r102 = IAssistantInteractionServiceKt.getInteractionStateService().getInteractionKeyguardLockedState();
        Object r103 = IAssistantInteractionServiceKt.getInteractionStateService().getWakeUpAppPkg();
        IObricReporter.f391335a.getClass();
        IObricReporter r104 = IObricReporter.a.a();
        String r105 = null;
        if (r104 == null) goto L5;
        String r106 = r104.a();
    L6:
        IObricReporter r107 = IObricReporter.a.a();
        if (r107 == null) goto L9;
        Object r108 = r107.getWakeupSource();
    L11:
        if (r102 != KeyguardLockedState.UNLOCKED) goto L13;
        Object r109 = "unlocked_screen";
    L14:
        IObricReporter r110 = IObricReporter.a.a();
        if (r110 == null) goto L17;
        r105 = r110.l();
    L17:
        r101.put("obric_launch_method", r106);
        r101.put("obric_launch_position_level1", r109);
        r101.put("obric_launch_position_level2", r103);
        r101.put("obric_launch_service", r105);
        r101.put("obric_launch_wakeup", r108);
        IObricTraceParam r111 = (IObricTraceParam) ServiceManager.get().getService(IObricTraceParam.class);
        if (r111 == null) goto L20;
        r111.n(r101);
    L20:
        if (r106 == null) goto L23;
        if (r105 == null) goto L23;
        Object r112 = ObricLaunchReportManager.a(ObricLaunchReportManager.f391417a, r106, r105);
    L24:
        r101.put("obric_window_mode", r112);
        FLogger.f375446a.i("ObricLaunchReportManager", "onResume: called, report app launch activityName = " + r100 + ", flatParams = " + r101);
        return;
    L23:
        r112 = "unknown";
        goto L24
    L13:
        r109 = "lock_screen";
        goto L14
    L9:
        r108 = null;
        goto L11
    L5:
        r106 = null;
        goto L6
    }
}
