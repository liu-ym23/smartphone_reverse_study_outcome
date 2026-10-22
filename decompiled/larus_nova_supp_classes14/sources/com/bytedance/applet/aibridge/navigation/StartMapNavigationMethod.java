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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u000bH\u0016J&\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u001a\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¨\u0006\u0018"}, d2 = {"Lcom/bytedance/applet/aibridge/navigation/StartMapNavigationMethod;", "Lcom/bytedance/applet/aibridge/navigation/AbsStartMapNavigationIDL;", "<init>", "()V", "realHandle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/google/gson/JsonObject;", "resolve", "Landroidx/core/util/Consumer;", "reject", "Lcom/bytedance/ai/bridge/core/AIBridgeMethod$Error;", "handle", "Lcom/bytedance/applet/aibridge/navigation/AbsStartMapNavigationIDL$StartMapNavParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/navigation/AbsStartMapNavigationIDL$StartMapNavResult;", "stopPendingPrewarm", "reason", "", "identifier", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StartMapNavigationMethod extends AbsStartMapNavigationIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public StartMapNavigationMethod() {
    }

    public final void c(String r2, String r3) {
        if (r3 == null) goto L5;
        NavigationServiceDelegate.b.o(r2, r3);
        return;
    }

    public static final void b(boolean r1, f3.h<AbsStartMapNavigationIDL.b> r2, String r3) {
        Object r0 = l.a;
        l.d(r1, "jsb_start_map_nav_sync_failure");
        f3.h.a.a(r2, r3, null, null, 14);
    }

    public final void handle(e3.d r37, ParamModel r38, final f3.h r39) {
        AbsStartMapNavigationIDL.a r0 = (AbsStartMapNavigationIDL.a) r38;
        Intrinsics.checkNotNullParameter(r37, "bridgeContext");
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r39, "callback");
        Handler r5 = rv3.n.a;
        rv3.n.a r11 = rv3.n.g(r37);
        if (r11 == null) goto L5;
        final String r13 = r11.b;
    L6:
        Boolean r6 = r0.isQuickRestart();
        Boolean r7 = Boolean.TRUE;
        final boolean r14 = Intrinsics.areEqual(r6, r7);
        String r8 = r0.getNavigateUniqueId();     // Catch: Exception -> L151
        if (r8 != null) goto L12;
        StringBuilder r9 = new StringBuilder("nav_");     // Catch: Exception -> L151
        String r310 = r13;
        r9.append(System.currentTimeMillis());     // Catch: Exception -> L153
        r8 = r9.toString();     // Catch: Exception -> L153
    L13:
        String r12 = r8;
        if (Intrinsics.areEqual(r0.isQuickRestart(), r7) == true) goto L25;
        Object r4 = l.a;     // Catch: Exception -> L153
        Intrinsics.checkNotNullParameter("jsb_start_map_nav", "subTag");     // Catch: Exception -> L153
        long r10 = System.currentTimeMillis() - l.f;     // Catch: Exception -> L153
        if (l.f <= 0) goto L25;
        if (0 <= r10) goto L20;
    L22:
        boolean r15 = false;
    L23:
        if (r15 == false) goto L25;
        int r16 = com.larus.navigation.api.c.a;     // Catch: Exception -> L153
        com.larus.navigation.api.c.e("jsb_start_map_nav", "suspected unflagged route switch: start arrived " + r10 + "ms after a plain stop(\"jsb\") — FE should pass isQuickRestart=true on both stop and start");     // Catch: Exception -> L153
        goto L25
    L20:
        if (r10 >= 3001) goto L22;
        r15 = true;
    L25:
        int r17 = com.larus.navigation.api.c.a;     // Catch: Exception -> L153
        com.larus.navigation.api.c.d("jsb_start_map_nav", "handle: navigateUniqueId[" + r12 + ']');     // Catch: Exception -> L153
        int r3 = com.larus.navigation.api.j.a;     // Catch: Exception -> L153
        com.larus.navigation.api.j.a("flow.startMapNavigation", "uniqueId=" + r12 + ", routePlanType=" + r0.getRoutePlanType());     // Catch: Exception -> L153
        StringBuilder r2 = new StringBuilder("[FE_IN/flow.startMapNavigation] routePlanType=");     // Catch: Exception -> L153
        r2.append(r0.getRoutePlanType());     // Catch: Exception -> L153
        r2.append(" prefer=");     // Catch: Exception -> L153
        r2.append(r0.getPrefer());     // Catch: Exception -> L153
        r2.append(" | hasStartPoint=");     // Catch: Exception -> L153
        if (r0.getStartPoint() == null) goto L28;
        boolean r1 = true;
    L29:
        r2.append(r1);     // Catch: Exception -> L153
        r2.append(" hasEndPoint=");     // Catch: Exception -> L153
        if (r0.getEndPoint() == null) goto L32;
        boolean r18 = true;
    L33:
        r2.append(r18);     // Catch: Exception -> L153
        r2.append(" | hasPoiId=");     // Catch: Exception -> L153
        String r19 = r0.getPoiId();     // Catch: Exception -> L153
        if (r19 != null) goto L36;
    L39:
        boolean r20 = true;
    L40:
        if (r20 == true) goto L42;
        boolean r21 = true;
    L43:
        r2.append(r21);     // Catch: Exception -> L153
        r2.append(" | ridingType=");     // Catch: Exception -> L153
        r2.append(r0.getRidingType());     // Catch: Exception -> L153
        r2.append(" verbalMode=");     // Catch: Exception -> L153
        r2.append(r0.getVerbalMode());     // Catch: Exception -> L153
        r2.append(" navigateUniqueId='");     // Catch: Exception -> L153
        r2.append(r12);     // Catch: Exception -> L153
        r2.append("' botId=");     // Catch: Exception -> L153
        r2.append(r0.getBotId());     // Catch: Exception -> L153
        r2.append(" conversationId=");     // Catch: Exception -> L153
        r2.append(r0.getConversationId());     // Catch: Exception -> L153
        r2.append(" businessId=");     // Catch: Exception -> L153
        r2.append(r0.getBusinessId());     // Catch: Exception -> L153
        r2.append(" isQuickRestart=");     // Catch: Exception -> L153
        r2.append(r0.isQuickRestart());     // Catch: Exception -> L153
        r2.append(" coordType=");     // Catch: Exception -> L153
        r2.append(r0.getCoordType());     // Catch: Exception -> L153
        r2.append(" wayPoints=");     // Catch: Exception -> L153
        JsonArray r22 = r0.getWaypoints();     // Catch: Exception -> L153
        if (r22 == null) goto L46;
        int r23 = r22.size();     // Catch: Exception -> L153
    L47:
        r2.append(r23);     // Catch: Exception -> L153
        com.larus.navigation.api.c.d("nav_protocol_trace", r2.toString());     // Catch: Exception -> L153
        Integer r24 = r0.getRoutePlanType();     // Catch: Exception -> L153
        if (r24 == null) goto L50;
        int r110 = r24.intValue();     // Catch: Exception -> L153
    L51:
        d r25 = r0.getEndPoint();     // Catch: Exception -> L153
        if (r25 != null) goto L56;
        com.larus.navigation.api.c.b("jsb_start_map_nav", "endPoint is null");     // Catch: Exception -> L153
        c("start_missing_end_point", r310);     // Catch: Exception -> L151
        b(r14, r39, "no_end_point");     // Catch: Exception -> L151
        return;
    L56:
        r13 = r310;
        Double r26 = r25.b();     // Catch: Exception -> L151
        if (r26 == null) goto L66;
        double r27 = r26.doubleValue();     // Catch: Exception -> L151
        Double r28 = r25.c();     // Catch: Exception -> L151
        if (r28 == null) goto L66;
        double r29 = r28.doubleValue();     // Catch: Exception -> L151
        Double r30 = r25.a();     // Catch: Exception -> L151
        if (r30 == null) goto L64;
        double r210 = r30.doubleValue();     // Catch: Exception -> L151
    L65:
        com.larus.navigation.api.a r111 = new com.larus.navigation.api.a(r27, r29, r210, 8);     // Catch: Exception -> L151
    L67:
        if (r111 == null) goto L164;
        d r31 = r0.getStartPoint();     // Catch: Exception -> L151
        if (r31 != null) goto L72;
        boolean r32 = false;
    L83:
        com.larus.navigation.api.a r112 = null;
    L84:
        if (r32 == true) goto L165;
        final Ref.ObjectRef r33 = new Ref.ObjectRef();     // Catch: Exception -> L151
        List<com.larus.navigation.api.y> r34 = n.d(r0.getWaypoints(), new i0(r33, this, r13, r14, r39));     // Catch: Exception -> L100
        if (r33.element != null) goto L166;
        Object r35 = l.a;     // Catch: Exception -> L100
        Application r36 = AppHost.a.getApplication();     // Catch: Exception -> L100
        if (r36 != null) goto L95;
    L99:
        boolean r113 = false;
    L103:
        if (r113 == true) goto L105;
        com.larus.navigation.api.c.b("jsb_start_map_nav", "location permission not granted");     // Catch: Exception -> L100
        c("start_no_location_permission", r13);     // Catch: Exception -> L100
        b(r14, r39, "no_location_permission");     // Catch: Exception -> L100
        return;
    L105:
        l.b();     // Catch: Exception -> L100
        com.larus.navigation.api.b r40 = com.larus.navigation.api.h.a;     // Catch: Exception -> L100
        if (com.larus.navigation.api.h.a != null) goto L108;
        com.larus.navigation.api.h.a = new y();     // Catch: Exception -> L100
    L108:
        NavigationServiceDelegate r41 = NavigationServiceDelegate.b;     // Catch: Exception -> L100
        Integer r42 = r0.getPrefer();     // Catch: Exception -> L100
        Integer r211 = r0.getVerbalMode();     // Catch: Exception -> L100
        String r212 = r0.getBotId();     // Catch: Exception -> L100
        String r213 = r0.getConversationId();     // Catch: Exception -> L100
        Boolean r43 = r0.isQuickRestart();     // Catch: Exception -> L100
        if (r43 == null) goto L111;
        boolean r214 = r43.booleanValue();     // Catch: Exception -> L100
    L112:
        Integer r215 = r0.getRidingType();     // Catch: Exception -> L100
        com.larus.navigation.api.x r311 = yv3.c.d(r0.getTraceContext());     // Catch: Exception -> L100
        String r216 = r0.getBusinessId();     // Catch: Exception -> L100
        String r217 = r0.getPoiId();     // Catch: Exception -> L100
        String r218 = r0.getPoiType();     // Catch: Exception -> L100
        Integer r44 = r0.getCoordType();     // Catch: Exception -> L100
        if (r44 == null) goto L115;
        int r219 = r44.intValue();     // Catch: Exception -> L100
    L116:
        Integer r45 = r0.getRotationChangeMinInterval();     // Catch: Exception -> L100
        if (r45 == null) goto L119;
        int r312 = r45.intValue();     // Catch: Exception -> L100
    L120:
        com.larus.navigation.api.w r46 = new com.larus.navigation.api.w(r112, r111, r110, r42, r211, r12, r212, r213, r214, r215, r216, r217, r218, r219, false, r312, r34, r311);     // Catch: Exception -> L100
        rv3.i r47 = l.e(r46);     // Catch: Exception -> L100
        if (r47 == null) goto L133;
        String r48 = r47.f();     // Catch: Exception -> L100
        if (r48 == null) goto L133;
        if (r11 == null) goto L126;
        String r49 = r11.a;     // Catch: Exception -> L100
    L128:
        if (Intrinsics.areEqual(r48, r49) == true) goto L131;
        r48 = null;
    L131:
        if (r48 == null) goto L133;
        String r114 = r13;
    L134:
        if (r13 == null) goto L137;
        if (r114 != null) goto L137;
        c("start_prewarm_route_mismatch", r13);     // Catch: Exception -> L100
    L137:
        com.larus.navigation.api.v r50 = new com.larus.navigation.api.v(r114, 2);     // Catch: Exception -> L100
        final f r51 = new f(r39, r46);     // Catch: Exception -> L100
        if (r41.b() == true) goto L160;
        r51.e = NavigationMultitaskCard.a.f();     // Catch: Exception -> L100
    L160:
    L143:
        e = move-exception;
        NavigationCardSessionState.a r52 = r51.e;     // Catch: Exception -> L100
        if (r52 == null) goto L150;
        NavigationMultitaskCard.a.getClass();     // Catch: Exception -> L100
        NavigationMultitaskCard.j("start_submission_failed", r52);     // Catch: Exception -> L100
    L150:
        throw e;     // Catch: Exception -> L100
    L141:
        if (r51.e == null) goto L145;
        Function0 r53 = new j0(r51);     // Catch: Exception -> L143
        Intrinsics.checkNotNullParameter("realtime_active", "from");     // Catch: Exception -> L143
        Intrinsics.checkNotNullParameter(r53, "ownerProvider");     // Catch: Exception -> L143
        r41.k(new m(r53));     // Catch: Exception -> L143
    L145:
        r41.d(r46, r50, r51);     // Catch: Exception -> L143
    L168:
        return;
    L126:
        r49 = null;
    L133:
        r114 = null;
        goto L134
    L119:
        r312 = 50;
        goto L120
    L115:
        r219 = 3;
        goto L116
    L111:
        r214 = false;
        goto L112
    L95:
        if (ContextCompat.checkSelfPermission(r36, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L97;
    L102:
        r113 = true;
        goto L103
    L97:
        if (ContextCompat.checkSelfPermission(r36, "android.permission.ACCESS_COARSE_LOCATION") != 0) goto L99;
    L166:
        return;
    L100:
        e = e;
    L155:
        int r54 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.b("jsb_start_map_nav", "handle error: type=".concat(e.getClass().getSimpleName()));
        c("start_navigation_exception", r13);
        com.larus.navigation.api.c.b("nav_protocol_trace", "[FE_FAIL/flow.startMapNavigation] type=".concat(e.getClass().getSimpleName()));
        b(r14, r39, "internal_error: " + e.getMessage());
        return;
    L165:
        return;
    L72:
        Double r55 = r31.b();     // Catch: Exception -> L151
        if (r55 == null) goto L82;
        double r220 = r55.doubleValue();     // Catch: Exception -> L151
        Double r56 = r31.c();     // Catch: Exception -> L151
        if (r56 == null) goto L82;
        double r221 = r56.doubleValue();     // Catch: Exception -> L151
        Double r57 = r31.a();     // Catch: Exception -> L151
        if (r57 == null) goto L80;
        double r222 = r57.doubleValue();     // Catch: Exception -> L151
    L81:
        r112 = new com.larus.navigation.api.a(r220, r221, r222, 8);     // Catch: Exception -> L151
        r32 = false;
        goto L84
    L80:
        r222 = 0.0d;
    L82:
        com.larus.navigation.api.c.b("jsb_start_map_nav", "startPoint has null coordinates");     // Catch: Exception -> L151
        c("start_invalid_start_point", r13);     // Catch: Exception -> L151
        b(r14, r39, "invalid_start_point_coordinates");     // Catch: Exception -> L151
        r32 = true;
        goto L83
    L164:
        return;
    L64:
        r210 = 0.0d;
    L66:
        com.larus.navigation.api.c.b("jsb_start_map_nav", "endPoint has null coordinates");     // Catch: Exception -> L151
        c("start_invalid_end_point", r13);     // Catch: Exception -> L151
        b(r14, r39, "invalid_end_point_coordinates");     // Catch: Exception -> L151
        r111 = null;
        goto L67
    L50:
        r110 = 0;
        goto L51
    L46:
        r23 = 0;
        goto L47
    L42:
        r21 = false;
        goto L43
    L36:
        if (StringsKt.isBlank(r19) == true) goto L39;
        r20 = false;
        goto L40
    L32:
        r18 = false;
        goto L33
    L28:
        r1 = false;
    L153:
        e = e;
        r13 = r310;
        goto L155
    L12:
        r310 = r13;
    L151:
        e = e;
        goto L155
    L5:
        r13 = null;
        goto L6
    }

    public final void realHandle(e3.d r3, JsonObject r4, Consumer<JsonObject> r5, final Consumer<AIBridgeMethod.Error> r6) {
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r5, "resolve");
        Intrinsics.checkNotNullParameter(r6, "reject");
        int r0 = com.larus.navigation.api.c.a;
        StringBuilder r1 = new StringBuilder("[FE_RAW/flow.startMapNavigation] paramsIsNull=");
        if (r4 != null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        com.larus.navigation.api.c.d("nav_protocol_trace", r1.toString());
        com.larus.navigation.api.m.a("T3/fe_start_map_nav", "");
        Handler r7 = rv3.n.a;
        final rv3.n.a r8 = rv3.n.e(r3);
        super.realHandle(r3, r4, r5, new h0(r8, r6, this));
        return;
    L5:
        r2 = false;
        goto L6
    }
}
