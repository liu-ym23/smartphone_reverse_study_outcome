package com.bytedance.applet.aibridge.navigation;

import android.app.Application;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import com.bytedance.ai.bridge.core.AIBridgeMethod;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.applet.task.NavigationCardSessionState;
import com.bytedance.applet.task.NavigationMultitaskCard;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.larus.common.apphost.AppHost;
import com.larus.navigation.api.NavigationServiceDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u000bH\u0016J&\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u001a\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¨\u0006\u0018"}, d2 = {"Lcom/bytedance/applet/aibridge/navigation/StartMapNavigationWithRouteMethod;", "Lcom/bytedance/applet/aibridge/navigation/AbsStartMapNavigationWithRouteIDL;", "<init>", "()V", "realHandle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/google/gson/JsonObject;", "resolve", "Landroidx/core/util/Consumer;", "reject", "Lcom/bytedance/ai/bridge/core/AIBridgeMethod$Error;", "handle", "Lcom/bytedance/applet/aibridge/navigation/AbsStartMapNavigationWithRouteIDL$StartNavWithRouteParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/navigation/AbsStartMapNavigationWithRouteIDL$StartNavWithRouteResult;", "stopPendingPrewarm", "reason", "", "identifier", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StartMapNavigationWithRouteMethod extends AbsStartMapNavigationWithRouteIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public StartMapNavigationWithRouteMethod() {
    }

    public final void c(String r2, String r3) {
        if (r3 == null) goto L5;
        NavigationServiceDelegate.b.o(r2, r3);
        return;
    }

    public static final void b(boolean r1, f3.h<AbsStartMapNavigationWithRouteIDL.b> r2, String r3) {
        Object r0 = l.a;
        l.d(r1, "jsb_start_nav_route_sync_failure");
        f3.h.a.a(r2, r3, null, null, 14);
    }

    public final void handle(e3.d r39, ParamModel r40, final f3.h r41) {
        f3.h r8 = r41;
        AbsStartMapNavigationWithRouteIDL.a r0 = (AbsStartMapNavigationWithRouteIDL.a) r40;
        String r9 = "nav_protocol_trace";
        String r10 = "jsb_start_nav_route";
        Intrinsics.checkNotNullParameter(r39, "bridgeContext");
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r8, "callback");
        Handler r6 = rv3.n.a;
        rv3.n.a r11 = rv3.n.g(r39);
        if (r11 == null) goto L5;
        String r13 = r11.b;
    L6:
        final boolean r14 = Intrinsics.areEqual(r0.isQuickRestart(), Boolean.TRUE);
        com.larus.navigation.api.m.a("T3/fe_start_map_nav_with_route", "");     // Catch: Exception -> L155
        String r7 = r0.getNavigateUniqueId();     // Catch: Exception -> L155
        if (r7 != null) goto L12;
        StringBuilder r12 = new StringBuilder("nav_");     // Catch: Exception -> L155
        String r15 = r13;
        r12.append(System.currentTimeMillis());     // Catch: Exception -> L153
        r7 = r12.toString();     // Catch: Exception -> L153
    L13:
        String r16 = r7;
        int r5 = com.larus.navigation.api.c.a;     // Catch: Exception -> L153
        com.larus.navigation.api.c.d("jsb_start_nav_route", "handle: navigateUniqueId[" + r16 + ']');     // Catch: Exception -> L153
        int r4 = com.larus.navigation.api.j.a;     // Catch: Exception -> L153
        com.larus.navigation.api.j.a("flow.startMapNavigationWithRoute", "uniqueId=" + r16 + ", routePlanType=" + r0.getRoutePlanType());     // Catch: Exception -> L153
        StringBuilder r3 = new StringBuilder("[FE_IN/flow.startMapNavigationWithRoute] routePlanType=");     // Catch: Exception -> L153
        r3.append(r0.getRoutePlanType());     // Catch: Exception -> L153
        r3.append(" prefer=");     // Catch: Exception -> L153
        r3.append(r0.getPrefer());     // Catch: Exception -> L153
        r3.append(" | hasStartPoint=");     // Catch: Exception -> L153
        if (r0.getStartPoint() == null) goto L16;
        boolean r2 = true;
    L17:
        r3.append(r2);     // Catch: Exception -> L153
        r3.append(" hasEndPoint=");     // Catch: Exception -> L153
        if (r0.getEndPoint() == null) goto L20;
        boolean r17 = true;
    L21:
        r3.append(r17);     // Catch: Exception -> L153
        r3.append(" | hasPoiId=");     // Catch: Exception -> L153
        String r18 = r0.getPoiId();     // Catch: Exception -> L153
        if (r18 != null) goto L24;
    L27:
        boolean r19 = true;
    L28:
        if (r19 == true) goto L30;
        boolean r20 = true;
    L31:
        r3.append(r20);     // Catch: Exception -> L153
        r3.append(" | verbalMode=");     // Catch: Exception -> L153
        r3.append(r0.getVerbalMode());     // Catch: Exception -> L153
        r3.append(" navigateUniqueId='");     // Catch: Exception -> L153
        r3.append(r16);     // Catch: Exception -> L153
        r3.append("' botId=");     // Catch: Exception -> L153
        r3.append(r0.getBotId());     // Catch: Exception -> L153
        r3.append(" conversationId=");     // Catch: Exception -> L153
        r3.append(r0.getConversationId());     // Catch: Exception -> L153
        r3.append(" businessId=");     // Catch: Exception -> L153
        r3.append(r0.getBusinessId());     // Catch: Exception -> L153
        r3.append(" routeDataLen=");     // Catch: Exception -> L153
        String r21 = r0.getRouteData();     // Catch: Exception -> L153
        if (r21 == null) goto L34;
        Integer r22 = Integer.valueOf(r21.length());     // Catch: Exception -> L153
    L35:
        r3.append(r22);     // Catch: Exception -> L153
        r3.append(" wayPoints=");     // Catch: Exception -> L153
        JsonArray r23 = r0.getWaypoints();     // Catch: Exception -> L153
        if (r23 == null) goto L38;
        int r24 = r23.size();     // Catch: Exception -> L153
    L39:
        r3.append(r24);     // Catch: Exception -> L153
        com.larus.navigation.api.c.d("nav_protocol_trace", r3.toString());     // Catch: Exception -> L153
        String r25 = r0.getRouteData();     // Catch: Exception -> L153
        if (StringsKt.isBlank(r25) == false) goto L42;
        com.larus.navigation.api.c.b("jsb_start_nav_route", "routeData is empty");     // Catch: Exception -> L153
        c("start_with_route_empty_route_data", r15);     // Catch: Exception -> L153
        b(r14, r8, "empty_route_data");     // Catch: Exception -> L153
        return;
    L42:
        com.larus.navigation.api.c.d("jsb_start_nav_route", "routeData length: " + r25.length());     // Catch: Exception -> L153
        Object r1 = l.a;     // Catch: Exception -> L153
        Application r26 = AppHost.a.getApplication();     // Catch: Exception -> L153
        if (r26 != null) goto L46;
    L50:
        boolean r27 = false;
    L52:
        if (r27 == true) goto L54;
        com.larus.navigation.api.c.b("jsb_start_nav_route", "location permission not granted");     // Catch: Exception -> L153
        c("start_with_route_no_location_permission", r15);     // Catch: Exception -> L153
        b(r14, r8, "no_location_permission");     // Catch: Exception -> L153
        return;
    L54:
        l.b();     // Catch: Exception -> L153
        com.larus.navigation.api.b r28 = com.larus.navigation.api.h.a;     // Catch: Exception -> L153
        if (com.larus.navigation.api.h.a != null) goto L59;
        com.larus.navigation.api.h.a = new y();     // Catch: Exception -> L153
    L59:
        NavigationServiceDelegate r29 = NavigationServiceDelegate.b;     // Catch: Exception -> L153
        Integer r30 = r0.getRoutePlanType();     // Catch: Exception -> L153
        if (r30 != null) goto L62;
        r30 = r0.getPlanType();     // Catch: Exception -> L153
    L62:
        Integer r110 = r30;
        if (r110 != null) goto L65;
        com.larus.navigation.api.c.b("jsb_start_nav_route", "routePlanType is null");     // Catch: Exception -> L153
        c("start_with_route_missing_plan_type", r15);     // Catch: Exception -> L153
        b(r14, r8, "no_planType");     // Catch: Exception -> L153
        return;
    L65:
        d r31 = r0.getEndPoint();     // Catch: Exception -> L153
        if (r31 != null) goto L68;
        com.larus.navigation.api.c.b("jsb_start_nav_route", "endPoint is null");     // Catch: Exception -> L153
        c("start_with_route_missing_end_point", r15);     // Catch: Exception -> L153
        b(r14, r8, "no_end_point");     // Catch: Exception -> L153
        return;
    L68:
        Double r32 = r31.b();     // Catch: Exception -> L153
        double r111 = 0.0d;
        if (r32 == null) goto L78;
        double r210 = r32.doubleValue();     // Catch: Exception -> L153
        Double r33 = r31.c();     // Catch: Exception -> L153
        if (r33 == null) goto L78;
        double r211 = r33.doubleValue();     // Catch: Exception -> L153
        Double r34 = r31.a();     // Catch: Exception -> L153
        if (r34 == null) goto L76;
        double r212 = r34.doubleValue();     // Catch: Exception -> L153
    L77:
        com.larus.navigation.api.a r112 = new com.larus.navigation.api.a(r210, r211, r212, 8);     // Catch: Exception -> L153
    L79:
        if (r112 == null) goto L172;
        d r35 = r0.getStartPoint();     // Catch: Exception -> L153
        if (r35 != null) goto L84;
        NavigationServiceDelegate r213 = r29;
        boolean r36 = false;
    L94:
        com.larus.navigation.api.a r113 = null;
    L95:
        if (r36 == true) goto L173;
        final Ref.ObjectRef r37 = new Ref.ObjectRef();     // Catch: Exception -> L153
        r9 = "nav_protocol_trace";
        r10 = "jsb_start_nav_route";
        final String r38 = r15;
        NavigationServiceDelegate r310 = r213;
        boolean r311 = r14;
        List<com.larus.navigation.api.y> r312 = n.d(r0.getWaypoints(), new k0(r37, this, r38, r14, r41));     // Catch: Exception -> L151
        if (r37.element != null) goto L174;
        Integer r214 = r0.getPrefer();     // Catch: Exception -> L151
        Integer r215 = r0.getVerbalMode();     // Catch: Exception -> L151
        String r216 = r0.getBotId();     // Catch: Exception -> L151
        String r217 = r0.getConversationId();     // Catch: Exception -> L151
        Boolean r42 = r0.isQuickRestart();     // Catch: Exception -> L151
        if (r42 == null) goto L105;
        boolean r218 = r42.booleanValue();     // Catch: Exception -> L151
    L106:
        Integer r219 = r0.getRidingType();     // Catch: Exception -> L151
        com.larus.navigation.api.x r313 = yv3.c.d(r0.getTraceContext());     // Catch: Exception -> L151
        String r220 = r0.getBusinessId();     // Catch: Exception -> L151
        String r221 = r0.getPoiId();     // Catch: Exception -> L151
        String r222 = r0.getPoiType();     // Catch: Exception -> L151
        Integer r43 = r0.getCoordType();     // Catch: Exception -> L151
        if (r43 == null) goto L109;
        int r314 = r43.intValue();     // Catch: Exception -> L151
    L110:
        Integer r44 = r0.getRotationChangeMinInterval();     // Catch: Exception -> L151
        if (r44 == null) goto L113;
        int r315 = r44.intValue();     // Catch: Exception -> L151
    L114:
        com.larus.navigation.api.w r45 = new com.larus.navigation.api.w(r113, r112, r110.intValue(), r214, r215, r16, r216, r217, r218, r219, r220, r221, r222, r314, false, r315, r312, r313);     // Catch: Exception -> L151
        rv3.i r46 = l.e(r45);     // Catch: Exception -> L151
        if (r46 == null) goto L127;
        String r47 = r46.f();     // Catch: Exception -> L151
        if (r47 == null) goto L127;
        if (r11 == null) goto L120;
        String r48 = r11.a;     // Catch: Exception -> L151
    L122:
        if (Intrinsics.areEqual(r47, r48) == true) goto L125;
        r47 = null;
    L125:
        if (r47 == null) goto L127;
        String r114 = r15;
    L128:
        if (r15 == null) goto L131;
        if (r114 != null) goto L131;
        c("start_with_route_prewarm_route_mismatch", r15);     // Catch: Exception -> L151
    L131:
        com.larus.navigation.api.v r49 = new com.larus.navigation.api.v(r114, r25);     // Catch: Exception -> L151
        r8 = r41;
        final e r50 = new e(r8, r45);     // Catch: Exception -> L137
        if (r310.b() == true) goto L162;
        r50.e = NavigationMultitaskCard.a.f();     // Catch: Exception -> L137
    L162:
    L142:
        e = move-exception;
        NavigationCardSessionState.a r51 = r50.e;     // Catch: Exception -> L137
        if (r51 == null) goto L150;
        NavigationMultitaskCard.a.getClass();     // Catch: Exception -> L137
        NavigationMultitaskCard.j("start_submission_failed", r51);     // Catch: Exception -> L137
    L150:
        throw e;     // Catch: Exception -> L137
    L140:
        if (r50.e == null) goto L144;
        Function0 r52 = new l0(r50);     // Catch: Exception -> L142
        Intrinsics.checkNotNullParameter("realtime_active", "from");     // Catch: Exception -> L142
        Intrinsics.checkNotNullParameter(r52, "ownerProvider");     // Catch: Exception -> L142
        m r53 = new m(r52);     // Catch: Exception -> L142
        NavigationServiceDelegate r54 = r310;
        r54.k(r53);     // Catch: Exception -> L142
    L145:
        r54.d(r45, r49, r50);     // Catch: Exception -> L142
    L175:
        return;
    L144:
        r54 = r310;
    L137:
        e = e;
    L157:
        int r55 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.b(r10, "handle error: type=".concat(e.getClass().getSimpleName()));
        c("start_with_route_exception", r15);
        com.larus.navigation.api.c.b(r9, "[FE_FAIL/flow.startMapNavigationWithRoute] type=".concat(e.getClass().getSimpleName()));
        b(r311, r8, "internal_error: " + e.getMessage());
        return;
    L120:
        r48 = null;
    L127:
        r114 = null;
        goto L128
    L113:
        r315 = 50;
        goto L114
    L109:
        r314 = 3;
        goto L110
    L105:
        r218 = false;
        goto L106
    L174:
        return;
    L151:
        e = e;
        r8 = r41;
        goto L157
    L173:
        return;
    L84:
        Double r56 = r35.b();     // Catch: Exception -> L153
        r213 = r29;
        if (r56 == null) goto L93;
        double r223 = r56.doubleValue();     // Catch: Exception -> L153
        Double r57 = r35.c();     // Catch: Exception -> L153
        if (r57 == null) goto L93;
        double r224 = r57.doubleValue();     // Catch: Exception -> L153
        Double r58 = r35.a();     // Catch: Exception -> L153
        if (r58 == null) goto L92;
        r111 = r58.doubleValue();     // Catch: Exception -> L153
    L92:
        r113 = new com.larus.navigation.api.a(r223, r224, r111, 8);     // Catch: Exception -> L153
        r36 = false;
    L93:
        com.larus.navigation.api.c.b("jsb_start_nav_route", "startPoint has null coordinates");     // Catch: Exception -> L153
        c("start_with_route_invalid_start_point", r15);     // Catch: Exception -> L153
        b(r14, r8, "invalid_start_point_coordinates");     // Catch: Exception -> L153
        r36 = true;
        goto L94
    L172:
        return;
    L76:
        r212 = 0.0d;
    L78:
        com.larus.navigation.api.c.b("jsb_start_nav_route", "endPoint has null coordinates");     // Catch: Exception -> L153
        c("start_with_route_invalid_end_point", r15);     // Catch: Exception -> L153
        b(r14, r8, "invalid_end_point_coordinates");     // Catch: Exception -> L153
        r112 = null;
        goto L79
    L46:
        if (ContextCompat.checkSelfPermission(r26, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L48;
    L51:
        r27 = true;
        goto L52
    L48:
        if (ContextCompat.checkSelfPermission(r26, "android.permission.ACCESS_COARSE_LOCATION") != 0) goto L50;
    L38:
        r24 = 0;
        goto L39
    L34:
        r22 = null;
        goto L35
    L30:
        r20 = false;
        goto L31
    L24:
        if (StringsKt.isBlank(r18) == true) goto L27;
        r19 = false;
        goto L28
    L20:
        r17 = false;
        goto L21
    L16:
        r2 = false;
    L153:
        e = e;
    L58:
        r311 = r14;
        goto L157
    L12:
        r15 = r13;
    L155:
        e = e;
        r15 = r13;
        goto L58
    L5:
        r13 = null;
        goto L6
    }

    public final void realHandle(e3.d r3, JsonObject r4, Consumer<JsonObject> r5, final Consumer<AIBridgeMethod.Error> r6) {
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r5, "resolve");
        Intrinsics.checkNotNullParameter(r6, "reject");
        Handler r0 = rv3.n.a;
        final rv3.n.a r1 = rv3.n.e(r3);
        super.realHandle(r3, r4, r5, new m0(r1, r6, this));
    }
}
