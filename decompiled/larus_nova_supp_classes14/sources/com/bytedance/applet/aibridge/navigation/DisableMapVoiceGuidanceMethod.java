package com.bytedance.applet.aibridge.navigation;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.navigation.api.NavigationServiceDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/navigation/DisableMapVoiceGuidanceMethod;", "Lcom/bytedance/applet/aibridge/navigation/AbsDisableMapVoiceGuidanceIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/navigation/AbsDisableMapVoiceGuidanceIDL$DisableVoiceParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/navigation/AbsDisableMapVoiceGuidanceIDL$DisableVoiceResult;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DisableMapVoiceGuidanceMethod extends AbsDisableMapVoiceGuidanceIDL {

    public static final class a {
    }

    static {
    }

    public DisableMapVoiceGuidanceMethod() {
    }

    public final void handle(e3.d r7, ParamModel r8, f3.h r9) {
        AbsDisableMapVoiceGuidanceIDL.a r10 = (AbsDisableMapVoiceGuidanceIDL.a) r8;
        Intrinsics.checkNotNullParameter(r7, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r9, "callback");
        int r11 = com.larus.navigation.api.c.a;     // Catch: Exception -> L9
        com.larus.navigation.api.c.d("jsb_disable_voice", "handle: navigationId=" + r10.getNavigationId());     // Catch: Exception -> L9
        int r12 = com.larus.navigation.api.j.a;     // Catch: Exception -> L9
        com.larus.navigation.api.j.a("flow.disableMapVoiceGuidance", "navigationId=" + r10.getNavigationId());     // Catch: Exception -> L9
        com.larus.navigation.api.c.d("nav_protocol_trace", "[FE_IN/flow.disableMapVoiceGuidance] navigationId=" + r10.getNavigationId());     // Catch: Exception -> L9
        NavigationServiceDelegate r13 = NavigationServiceDelegate.b;     // Catch: Exception -> L9
        if (r13.b() == true) goto L7;
        com.larus.navigation.api.c.d("jsb_disable_voice", "not navigating yet, no-op");     // Catch: Exception -> L9
        Intrinsics.checkNotNullParameter(AbsDisableMapVoiceGuidanceIDL.b.class, "<this>");     // Catch: Exception -> L9
        AbsDisableMapVoiceGuidanceIDL.b r14 = k3.c.a(AbsDisableMapVoiceGuidanceIDL.b.class);     // Catch: Exception -> L9
        r14.setSuccess(Boolean.TRUE);     // Catch: Exception -> L9
        r9.b(r14, "");     // Catch: Exception -> L9
    L12:
        return;
    L7:
        r13.m();     // Catch: Exception -> L9
        Intrinsics.checkNotNullParameter(AbsDisableMapVoiceGuidanceIDL.b.class, "<this>");     // Catch: Exception -> L9
        AbsDisableMapVoiceGuidanceIDL.b r15 = k3.c.a(AbsDisableMapVoiceGuidanceIDL.b.class);     // Catch: Exception -> L9
        r15.setSuccess(Boolean.TRUE);     // Catch: Exception -> L9
        r9.b(r15, "");     // Catch: Exception -> L9
    L9:
        e = move-exception;
        int r16 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.c("jsb_disable_voice", "handle error: " + e.getMessage(), e);
        com.larus.navigation.api.c.b("nav_protocol_trace", "[FE_FAIL/flow.disableMapVoiceGuidance] " + e.getClass().getSimpleName() + ": " + e.getMessage());
        StringBuilder r17 = new StringBuilder("internal_error: ");
        r17.append(e.getMessage());
        f3.h.a.a(r9, r17.toString(), null, null, 14);
    }
}
