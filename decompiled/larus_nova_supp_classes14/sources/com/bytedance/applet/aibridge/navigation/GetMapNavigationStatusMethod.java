package com.bytedance.applet.aibridge.navigation;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.navigation.api.NavigationServiceDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/navigation/GetMapNavigationStatusMethod;", "Lcom/bytedance/applet/aibridge/navigation/AbsGetMapNavigationStatusIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/navigation/AbsGetMapNavigationStatusIDL$GetNavStatusParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/navigation/AbsGetMapNavigationStatusIDL$GetNavStatusResult;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetMapNavigationStatusMethod extends AbsGetMapNavigationStatusIDL {

    public static final class a {
    }

    static {
    }

    public GetMapNavigationStatusMethod() {
    }

    public final void handle(e3.d r7, ParamModel r8, f3.h r9) {
        Intrinsics.checkNotNullParameter(r7, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetMapNavigationStatusIDL.a) r8, "params");
        Intrinsics.checkNotNullParameter(r9, "callback");
        NavigationServiceDelegate r10 = NavigationServiceDelegate.b;     // Catch: Exception -> L5
        boolean r11 = r10.b();     // Catch: Exception -> L5
        int r5 = com.larus.navigation.api.c.a;     // Catch: Exception -> L5
        com.larus.navigation.api.c.d("jsb_nav_status", "handle: isNavigating=" + r11);     // Catch: Exception -> L5
        com.larus.navigation.api.j.a("flow.getMapNavigationStatus", "");     // Catch: Exception -> L5
        com.larus.navigation.api.c.d("nav_protocol_trace", "[FE_IN/flow.getMapNavigationStatus] (no params) → isNavigating=" + r11);     // Catch: Exception -> L5
        Intrinsics.checkNotNullParameter(AbsGetMapNavigationStatusIDL.b.class, "<this>");     // Catch: Exception -> L5
        AbsGetMapNavigationStatusIDL.b r3 = k3.c.a(AbsGetMapNavigationStatusIDL.b.class);     // Catch: Exception -> L5
        AbsGetMapNavigationStatusIDL.b r4 = r3;     // Catch: Exception -> L5
        r4.setNavigating(Boolean.valueOf(r11));     // Catch: Exception -> L5
        r4.setNavigationId(r10.c());     // Catch: Exception -> L5
        r4.setVoiceGuidanceEnabled(Boolean.valueOf(r10.h()));     // Catch: Exception -> L5
        r9.b(r3, "");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        int r12 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.c("jsb_nav_status", "handle error: " + e.getMessage(), e);
        com.larus.navigation.api.c.b("nav_protocol_trace", "[FE_FAIL/flow.getMapNavigationStatus] " + e.getClass().getSimpleName() + ": " + e.getMessage());
        StringBuilder r13 = new StringBuilder("internal_error: ");
        r13.append(e.getMessage());
        f3.h.a.a(r9, r13.toString(), null, null, 14);
    }
}
