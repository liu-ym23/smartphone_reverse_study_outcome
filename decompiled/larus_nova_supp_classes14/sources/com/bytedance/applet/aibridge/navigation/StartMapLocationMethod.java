package com.bytedance.applet.aibridge.navigation;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.platform.api.p1;
import com.larus.platform.model.CoordinateType;
import com.larus.platform.model.LocationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0017\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/applet/aibridge/navigation/StartMapLocationMethod;", "Lcom/bytedance/applet/aibridge/navigation/AbsStartMapLocationIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/navigation/AbsStartMapLocationIDL$StartLocationParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/navigation/AbsStartMapLocationIDL$StartLocationResult;", "mapCoordinateType", "Lcom/larus/platform/model/CoordinateType;", "type", "", "(Ljava/lang/Integer;)Lcom/larus/platform/model/CoordinateType;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StartMapLocationMethod extends AbsStartMapLocationIDL {

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LocationResult.values().length];
            r0[LocationResult.NOT_INITIALIZED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[LocationResult.NO_PERMISSION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public StartMapLocationMethod() {
    }

    public final void handle(e3.d r25, ParamModel r26, f3.h r27) {
        AbsStartMapLocationIDL.a r0 = (AbsStartMapLocationIDL.a) r26;
        Intrinsics.checkNotNullParameter(r25, "bridgeContext");
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r27, "callback");
        Integer r14 = r0.getMinInterval();     // Catch: Exception -> L34
        if (r14 == null) goto L6;
        int r15 = r14.intValue();     // Catch: Exception -> L34
    L7:
        long r16 = r15;
        Integer r17 = r0.getCoordinateType();     // Catch: Exception -> L34
        if (r17 != null) goto L11;
    L13:
        CoordinateType r13 = CoordinateType.GCJ_O2;     // Catch: Exception -> L34
    L14:
        String r18 = r0.getIdentifier();     // Catch: Exception -> L34
        String r12 = "";
        if (r18 == null) goto L19;
        r12 = r18;
    L19:
        int r19 = com.larus.navigation.api.c.a;     // Catch: Exception -> L34
        com.larus.navigation.api.c.d("jsb_start_location", "handle: interval=" + r16 + "ms, coordType=" + r13 + ", identifier=" + r12);     // Catch: Exception -> L34
        int r6 = com.larus.navigation.api.j.a;     // Catch: Exception -> L34
        StringBuilder r11 = new StringBuilder("interval=");     // Catch: Exception -> L34
        r11.append(r16);     // Catch: Exception -> L34
        r11.append("ms, coordType=");     // Catch: Exception -> L34
        r11.append(r13);     // Catch: Exception -> L34
        com.larus.navigation.api.j.a("flow.startMapLocation", r11.toString());     // Catch: Exception -> L34
        com.larus.navigation.api.c.d("nav_protocol_trace", "[FE_IN/flow.startMapLocation] minInterval=" + r16 + "ms coordType=" + r13 + " rawMinInterval=" + r0.getMinInterval() + " rawCoordinateType=" + r0.getCoordinateType());     // Catch: Exception -> L34
        com.larus.platform.service.m r3 = com.larus.platform.service.m.a;     // Catch: Exception -> L34
        p1 r4 = com.larus.platform.service.m.i();     // Catch: Exception -> L34
        if (r4 != null) goto L22;
        com.larus.navigation.api.c.b("jsb_start_location", "LocationService not available");     // Catch: Exception -> L34
        f3.h.a.a(r27, "location_service_not_available", null, null, 14);     // Catch: Exception -> L34
        return;
    L22:
        LocationResult r1 = r4.h(r16, r13, new g0(), r12, r0.getExtra());     // Catch: Exception -> L34
        if (r1 == LocationResult.SUCCESS) goto L32;
        int r5 = b.a[r1.ordinal()];     // Catch: Exception -> L34
        if (r5 != 1) goto L27;
        String r7 = "location_sdk_not_initialized";
    L31:
        com.larus.navigation.api.c.b("jsb_start_location", "continuousLocate failed: code=" + r1 + " errId=" + r7);     // Catch: Exception -> L34
        com.larus.navigation.api.c.b("nav_protocol_trace", "[FE_FAIL/flow.startMapLocation] code=" + r1 + " errId=" + r7);     // Catch: Exception -> L34
        f3.h.a.a(r27, r7, null, null, 14);     // Catch: Exception -> L34
        return;
    L27:
        if (r5 == 2) goto L29;
        r7 = "location_start_failed: " + r1.getMessage();     // Catch: Exception -> L34
        goto L31
    L29:
        r7 = "no_location_permission";
        goto L31
    L32:
        Intrinsics.checkNotNullParameter(AbsStartMapLocationIDL.b.class, "<this>");     // Catch: Exception -> L34
        AbsStartMapLocationIDL.b r2 = k3.c.a(AbsStartMapLocationIDL.b.class);     // Catch: Exception -> L34
        r2.setSuccess(Boolean.TRUE);     // Catch: Exception -> L34
        r27.b(r2, "");     // Catch: Exception -> L34
        return;
    L11:
        if (r17.intValue() != 1) goto L13;
        r13 = CoordinateType.WGS_84;     // Catch: Exception -> L34
        goto L14
    L6:
        r15 = ECDraweeView.SQUARE;
    L34:
        e = move-exception;
        int r8 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.c("jsb_start_location", "handle error: " + e.getMessage(), e);
        com.larus.navigation.api.c.b("nav_protocol_trace", "[FE_FAIL/flow.startMapLocation] " + e.getClass().getSimpleName() + ": " + e.getMessage());
        StringBuilder r9 = new StringBuilder("internal_error: ");
        r9.append(e.getMessage());
        f3.h.a.a(r27, r9.toString(), null, null, 14);
    }
}
