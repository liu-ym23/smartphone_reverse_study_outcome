package com.bytedance.applet.aibridge.navigation;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.platform.api.p1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/navigation/StopMapLocationMethod;", "Lcom/bytedance/applet/aibridge/navigation/AbsStopMapLocationIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/navigation/AbsStopMapLocationIDL$StopLocationParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/navigation/AbsStopMapLocationIDL$StopLocationResult;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StopMapLocationMethod extends AbsStopMapLocationIDL {

    public static final class a {
    }

    static {
    }

    public StopMapLocationMethod() {
    }

    public final void handle(e3.d r8, ParamModel r9, f3.h r10) {
        AbsStopMapLocationIDL.a r11 = (AbsStopMapLocationIDL.a) r9;
        Intrinsics.checkNotNullParameter(r8, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r10, "callback");
        String r12 = r11.getIdentifier();     // Catch: Exception -> L12
        int r5 = com.larus.navigation.api.j.a;     // Catch: Exception -> L12
        com.larus.navigation.api.j.a("flow.stopMapLocation", "identifier=" + r12);     // Catch: Exception -> L12
        int r3 = com.larus.navigation.api.c.a;     // Catch: Exception -> L12
        com.larus.navigation.api.c.d("nav_protocol_trace", "[FE_IN/flow.stopMapLocation] identifier=" + r12);     // Catch: Exception -> L12
        com.larus.platform.service.m r2 = com.larus.platform.service.m.a;     // Catch: Exception -> L12
        p1 r4 = com.larus.platform.service.m.i();     // Catch: Exception -> L12
        if (r4 != null) goto L8;
        com.larus.navigation.api.c.b("jsb_stop_location", "LocationService not available");     // Catch: Exception -> L12
        f3.h.a.a(r10, "location_service_not_available", null, null, 14);     // Catch: Exception -> L12
    L15:
        return;
    L8:
        if (r12 != null) goto L10;
        r12 = "";
    L10:
        r4.d(r12);     // Catch: Exception -> L12
        Intrinsics.checkNotNullParameter(AbsStopMapLocationIDL.b.class, "<this>");     // Catch: Exception -> L12
        AbsStopMapLocationIDL.b r13 = k3.c.a(AbsStopMapLocationIDL.b.class);     // Catch: Exception -> L12
        r13.setSuccess(Boolean.TRUE);     // Catch: Exception -> L12
        r10.b(r13, "");     // Catch: Exception -> L12
    L12:
        e = move-exception;
        int r6 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.c("jsb_stop_location", "handle error: " + e.getMessage(), e);
        com.larus.navigation.api.c.b("nav_protocol_trace", "[FE_FAIL/flow.stopMapLocation] " + e.getClass().getSimpleName() + ": " + e.getMessage());
        StringBuilder r0 = new StringBuilder("internal_error: ");
        r0.append(e.getMessage());
        f3.h.a.a(r10, r0.toString(), null, null, 14);
    }
}
