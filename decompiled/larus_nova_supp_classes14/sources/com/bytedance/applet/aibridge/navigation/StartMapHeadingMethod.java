package com.bytedance.applet.aibridge.navigation;

import android.app.Application;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.common.apphost.AppHost;
import com.larus.lbs.trace.api.model.LbsTraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/navigation/StartMapHeadingMethod;", "Lcom/bytedance/applet/aibridge/navigation/AbsStartMapHeadingIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/navigation/AbsStartMapHeadingIDL$StartHeadingParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/navigation/AbsStartMapHeadingIDL$StartHeadingResult;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StartMapHeadingMethod extends AbsStartMapHeadingIDL {
    public static final Object b = null;
    public static volatile com.bytedance.applet.aibridge.baidunavi.h.a c;

    public static final class a {
        public static void a() {
            Object r0 = StartMapHeadingMethod.b;
            monitor-enter(r0);
            StartMapHeadingMethod.c = null;     // Catch: Throwable -> L8
            Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L8
            monitor-exit(r0);
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    static {
        b = new Object();
    }

    public StartMapHeadingMethod() {
    }

    public final void handle(e3.d r12, ParamModel r13, f3.h r14) {
        AbsStartMapHeadingIDL.a r15 = (AbsStartMapHeadingIDL.a) r13;
        Intrinsics.checkNotNullParameter(r12, "bridgeContext");
        Intrinsics.checkNotNullParameter(r15, "params");
        Intrinsics.checkNotNullParameter(r14, "callback");
        com.larus.lbs.trace.api.a r16 = new com.larus.lbs.trace.api.a(yv3.c.c(r15.getTraceContext()), "lbs_client_doubao_start_heading");
        Float r3 = r15.getMinDegreeChange();
        if (r3 == null) goto L5;
        float r4 = r3.floatValue();
    L30:
        int r9 = com.larus.navigation.api.c.a;     // Catch: Exception -> L25
        com.larus.navigation.api.c.d("jsb_start_heading", "handle: minDegreeChange=" + r4);     // Catch: Exception -> L25
        int r2 = com.larus.navigation.api.j.a;     // Catch: Exception -> L25
        com.larus.navigation.api.j.a("flow.startHeading", "minDegreeChange=" + r15.getMinDegreeChange());     // Catch: Exception -> L25
        com.larus.navigation.api.c.d("nav_protocol_trace", "[FE_IN/flow.startMapHeading] minDegreeChange=" + r4 + " rawMinDegreeChange=" + r15.getMinDegreeChange());     // Catch: Exception -> L25
        Application r17 = AppHost.a.getApplication();     // Catch: Exception -> L25
        if (r17 != null) goto L10;
        com.larus.navigation.api.c.b("jsb_start_heading", "application context not available");     // Catch: Exception -> L25
        r16.a(MapsKt.mapOf(new Pair[]{TuplesKt.to("min_degree_change", Float.valueOf(r4)), TuplesKt.to("is_success", Boolean.FALSE)}), LbsTraceLevel.ERROR);     // Catch: Exception -> L25
        f3.h.a.a(r14, "no_context", null, null, 14);     // Catch: Exception -> L25
        return;
    L10:
        f0 r0 = new f0(r4);     // Catch: Exception -> L25
        Object r1 = b;     // Catch: Exception -> L25
        monitor-enter(r1);     // Catch: Exception -> L25
        com.bytedance.applet.aibridge.baidunavi.h.a r5 = c;     // Catch: Throwable -> L22
        if (r5 == null) goto L15;
        com.bytedance.applet.aibridge.baidunavi.h.b(r17, r5);     // Catch: Throwable -> L22
    L15:
        c = r0;     // Catch: Throwable -> L22
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r1);     // Catch: Exception -> L25
        boolean r18 = com.bytedance.applet.aibridge.baidunavi.h.a(r17, r0);     // Catch: Exception -> L25
        Map r7 = MapsKt.mapOf(new Pair[]{TuplesKt.to("min_degree_change", Float.valueOf(r4)), TuplesKt.to("is_success", Boolean.valueOf(r18))});     // Catch: Exception -> L25
        if (r18 == false) goto L20;
        LbsTraceLevel r8 = LbsTraceLevel.INFO;     // Catch: Exception -> L25
    L21:
        r16.a(r7, r8);     // Catch: Exception -> L25
        Intrinsics.checkNotNullParameter(AbsStartMapHeadingIDL.b.class, "<this>");     // Catch: Exception -> L25
        AbsStartMapHeadingIDL.b r10 = k3.c.a(AbsStartMapHeadingIDL.b.class);     // Catch: Exception -> L25
        r10.setSuccess(Boolean.valueOf(r18));     // Catch: Exception -> L25
        r14.b(r10, "");     // Catch: Exception -> L25
        return;
    L20:
        r8 = LbsTraceLevel.ERROR;     // Catch: Exception -> L25
        goto L21
    L22:
        th = move-exception;
        throw th;     // Catch: Exception -> L25
    L25:
        e = move-exception;
        r16.a(MapsKt.mapOf(new Pair[]{TuplesKt.to("min_degree_change", Float.valueOf(r4)), TuplesKt.to("is_success", Boolean.FALSE)}), LbsTraceLevel.ERROR);
        int r19 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.c("jsb_start_heading", "handle error: " + e.getMessage(), e);
        com.larus.navigation.api.c.b("nav_protocol_trace", "[FE_FAIL/flow.startMapHeading] " + e.getClass().getSimpleName() + ": " + e.getMessage());
        StringBuilder r110 = new StringBuilder("internal_error: ");
        r110.append(e.getMessage());
        f3.h.a.a(r14, r110.toString(), null, null, 14);
        return;
    L5:
        r4 = 1.0f;
        goto L30
    }
}
