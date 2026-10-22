package com.bytedance.applet.aibridge.navigation;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.applet.task.NavigationMultitaskCard;
import com.larus.navigation.api.NavigationServiceDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/navigation/StopMapNavigationMethod;", "Lcom/bytedance/applet/aibridge/navigation/AbsStopMapNavigationIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/navigation/AbsStopMapNavigationIDL$StopMapNavParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/navigation/AbsStopMapNavigationIDL$StopMapNavResult;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StopMapNavigationMethod extends AbsStopMapNavigationIDL {

    public static final class a {
    }

    static {
    }

    public StopMapNavigationMethod() {
    }

    public final void handle(e3.d r20, ParamModel r21, f3.h r22) {
        AbsStopMapNavigationIDL.a r0 = (AbsStopMapNavigationIDL.a) r21;
        Intrinsics.checkNotNullParameter(r20, "bridgeContext");
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r22, "callback");
        boolean r1 = Intrinsics.areEqual(r0.isQuickRestart(), Boolean.TRUE);     // Catch: Exception -> L30
        int r11 = com.larus.navigation.api.c.a;     // Catch: Exception -> L30
        com.larus.navigation.api.c.d("jsb_stop_map_nav", "handle: isQuickRestart=" + r1);     // Catch: Exception -> L30
        int r9 = com.larus.navigation.api.j.a;     // Catch: Exception -> L30
        com.larus.navigation.api.j.a("flow.stopMapNavigation", "isQuickRestart=" + r1);     // Catch: Exception -> L30
        com.larus.navigation.api.c.d("nav_protocol_trace", "[FE_IN/flow.stopMapNavigation] isQuickRestart=" + r1);     // Catch: Exception -> L30
        if (r1 == true) goto L16;
        long r12 = System.currentTimeMillis();     // Catch: Exception -> L30
        NavigationMultitaskCard.a.getClass();     // Catch: Exception -> L30
        long r13 = r12 - NavigationMultitaskCard.c;     // Catch: Exception -> L30
        if (NavigationMultitaskCard.c <= 0) goto L16;
        if (0 <= r13) goto L11;
    L13:
        boolean r14 = false;
    L14:
        if (r14 == false) goto L16;
        com.larus.navigation.api.c.e("jsb_stop_map_nav", "ignoring stopMapNavigation (" + r13 + "ms after D1 preempt, likely echo from cancel event); returning success without stopping SDK");     // Catch: Exception -> L30
        Intrinsics.checkNotNullParameter(AbsStopMapNavigationIDL.b.class, "<this>");     // Catch: Exception -> L30
        AbsStopMapNavigationIDL.b r2 = k3.c.a(AbsStopMapNavigationIDL.b.class);     // Catch: Exception -> L30
        AbsStopMapNavigationIDL.b r4 = r2;     // Catch: Exception -> L30
        r4.setStatus(1);     // Catch: Exception -> L30
        r4.setMessage(null);     // Catch: Exception -> L30
        r4.setNavigating(Boolean.FALSE);     // Catch: Exception -> L30
        r22.b(r2, "");     // Catch: Exception -> L30
        return;
    L11:
        if (r13 >= 1001) goto L13;
        r14 = true;
    L16:
        NavigationServiceDelegate r5 = NavigationServiceDelegate.b;     // Catch: Exception -> L30
        if (r1 == false) goto L19;
        String r15 = "jsb_quick_restart";
    L20:
        if (r1 == true) goto L22;
        Object r16 = l.a;     // Catch: Exception -> L30
        l.f = System.currentTimeMillis();     // Catch: Exception -> L30
    L22:
        boolean r17 = r5.b();     // Catch: Exception -> L30
        if (r5.a(r15) == false) goto L28;
        if (r1 == true) goto L27;
        if (r17 == true) goto L27;
        NavigationMultitaskCard.a.getClass();     // Catch: Exception -> L30
        Intrinsics.checkNotNullParameter("explicit_stop_between_sessions", "reason");     // Catch: Exception -> L30
        NavigationMultitaskCard.j("explicit_stop_between_sessions", null);     // Catch: Exception -> L30
    L27:
        com.larus.navigation.api.c.d("jsb_stop_map_nav", "stopNavigation succeeded, reason=" + r15 + " wasNavigating=" + r17);     // Catch: Exception -> L30
        Intrinsics.checkNotNullParameter(AbsStopMapNavigationIDL.b.class, "<this>");     // Catch: Exception -> L30
        AbsStopMapNavigationIDL.b r3 = k3.c.a(AbsStopMapNavigationIDL.b.class);     // Catch: Exception -> L30
        AbsStopMapNavigationIDL.b r6 = r3;     // Catch: Exception -> L30
        r6.setStatus(1);     // Catch: Exception -> L30
        r6.setMessage(null);     // Catch: Exception -> L30
        r6.setNavigating(Boolean.valueOf(r17));     // Catch: Exception -> L30
        r22.b(r3, "");     // Catch: Exception -> L30
        return;
    L28:
        com.larus.navigation.api.c.b("jsb_stop_map_nav", "stopNavigation returned false, reason=".concat(r15));     // Catch: Exception -> L30
        Intrinsics.checkNotNullParameter(AbsStopMapNavigationIDL.b.class, "<this>");     // Catch: Exception -> L30
        AbsStopMapNavigationIDL.b r7 = k3.c.a(AbsStopMapNavigationIDL.b.class);     // Catch: Exception -> L30
        AbsStopMapNavigationIDL.b r8 = r7;     // Catch: Exception -> L30
        r8.setStatus(0);     // Catch: Exception -> L30
        r8.setMessage("stop_returned_false");     // Catch: Exception -> L30
        r8.setNavigating(Boolean.FALSE);     // Catch: Exception -> L30
        r22.b(r7, "");     // Catch: Exception -> L30
        return;
    L19:
        r15 = "jsb";
    L30:
        e = move-exception;
        int r10 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.c("jsb_stop_map_nav", "handle error [" + e.getClass().getSimpleName() + "]: " + e.getMessage(), e);
        com.larus.navigation.api.c.b("nav_protocol_trace", "[FE_FAIL/flow.stopMapNavigation] " + e.getClass().getSimpleName() + ": " + e.getMessage());
        StringBuilder r18 = new StringBuilder("internal_error: ");
        r18.append(e.getMessage());
        f3.h.a.a(r22, r18.toString(), null, null, 14);
    }
}
