package com.bytedance.applet.aibridge.navigation;

import android.app.Application;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.common.apphost.AppHost;
import com.larus.lbs.trace.api.model.LbsTraceLevel;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/navigation/StopMapHeadingMethod;", "Lcom/bytedance/applet/aibridge/navigation/AbsStopMapHeadingIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/navigation/AbsStopMapHeadingIDL$StopHeadingParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/navigation/AbsStopMapHeadingIDL$StopHeadingResult;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StopMapHeadingMethod extends AbsStopMapHeadingIDL {

    public static final class a {
    }

    static {
    }

    public StopMapHeadingMethod() {
    }

    public final void handle(e3.d r5, ParamModel r6, f3.h r7) {
        AbsStopMapHeadingIDL.a r8 = (AbsStopMapHeadingIDL.a) r6;
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "callback");
        com.larus.lbs.trace.api.a r9 = new com.larus.lbs.trace.api.a(yv3.c.c(r8.getTraceContext()), "lbs_client_doubao_stop_heading");
        com.larus.navigation.api.c.d("jsb_stop_heading", "handle");     // Catch: Exception -> L16
        com.larus.navigation.api.j.a("flow.stopMapHeading", "");     // Catch: Exception -> L16
        com.larus.navigation.api.c.d("nav_protocol_trace", "[FE_IN/flow.stopMapHeading] (no params)");     // Catch: Exception -> L16
        Application r1 = AppHost.a.getApplication();     // Catch: Exception -> L16
        if (r1 != null) goto L6;
        com.larus.navigation.api.c.b("jsb_stop_heading", "application context not available");     // Catch: Exception -> L16
        r9.a(MapsKt.mapOf(TuplesKt.to("is_success", Boolean.FALSE)), LbsTraceLevel.ERROR);     // Catch: Exception -> L16
        f3.h.a.a(r7, "no_context", null, null, 14);     // Catch: Exception -> L16
        return;
    L6:
        Object r2 = StartMapHeadingMethod.b;     // Catch: Exception -> L16
        monitor-enter(r2);     // Catch: Exception -> L16
        com.bytedance.applet.aibridge.baidunavi.h.a r3 = StartMapHeadingMethod.c;     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Exception -> L16
        if (r3 != null) goto L12;
        com.larus.navigation.api.c.d("jsb_stop_heading", "no active heading session to stop");     // Catch: Exception -> L16
        Boolean r4 = Boolean.TRUE;     // Catch: Exception -> L16
        r9.a(MapsKt.mapOf(TuplesKt.to("is_success", r4)), LbsTraceLevel.INFO);     // Catch: Exception -> L16
        Intrinsics.checkNotNullParameter(AbsStopMapHeadingIDL.b.class, "<this>");     // Catch: Exception -> L16
        AbsStopMapHeadingIDL.b r10 = k3.c.a(AbsStopMapHeadingIDL.b.class);     // Catch: Exception -> L16
        r10.setSuccess(r4);     // Catch: Exception -> L16
        r7.b(r10, "");     // Catch: Exception -> L16
        return;
    L12:
        com.bytedance.applet.aibridge.baidunavi.h.b(r1, r3);     // Catch: Exception -> L16
        StartMapHeadingMethod.a.a();     // Catch: Exception -> L16
        Boolean r11 = Boolean.TRUE;     // Catch: Exception -> L16
        r9.a(MapsKt.mapOf(TuplesKt.to("is_success", r11)), LbsTraceLevel.INFO);     // Catch: Exception -> L16
        Intrinsics.checkNotNullParameter(AbsStopMapHeadingIDL.b.class, "<this>");     // Catch: Exception -> L16
        AbsStopMapHeadingIDL.b r12 = k3.c.a(AbsStopMapHeadingIDL.b.class);     // Catch: Exception -> L16
        r12.setSuccess(r11);     // Catch: Exception -> L16
        r7.b(r12, "");     // Catch: Exception -> L16
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Exception -> L16
    L16:
        e = move-exception;
        r9.a(MapsKt.mapOf(TuplesKt.to("is_success", Boolean.FALSE)), LbsTraceLevel.ERROR);
        int r13 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.c("jsb_stop_heading", "handle error: " + e.getMessage(), e);
        com.larus.navigation.api.c.b("nav_protocol_trace", "[FE_FAIL/flow.stopMapHeading] " + e.getClass().getSimpleName() + ": " + e.getMessage());
        StringBuilder r14 = new StringBuilder("internal_error: ");
        r14.append(e.getMessage());
        f3.h.a.a(r7, r14.toString(), null, null, 14);
    }
}
