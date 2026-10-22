package com.bytedance.applet.aibridge.navigation;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.google.gson.JsonArray;
import com.larus.navigation.api.NavigationService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/navigation/UpdateMapNavigationWaypointsMethod;", "Lcom/bytedance/applet/aibridge/navigation/AbsUpdateMapNavigationWaypointsIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/navigation/AbsUpdateMapNavigationWaypointsIDL$UpdateMapNavigationWaypointsParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/navigation/AbsUpdateMapNavigationWaypointsIDL$UpdateMapNavigationWaypointsResult;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateMapNavigationWaypointsMethod extends AbsUpdateMapNavigationWaypointsIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public UpdateMapNavigationWaypointsMethod() {
    }

    public final void handle(e3.d r13, ParamModel r14, f3.h r15) {
        AbsUpdateMapNavigationWaypointsIDL.a r16 = (AbsUpdateMapNavigationWaypointsIDL.a) r14;
        Intrinsics.checkNotNullParameter(r13, "bridgeContext");
        Intrinsics.checkNotNullParameter(r16, "params");
        Intrinsics.checkNotNullParameter(r15, "callback");
        String r7 = r16.getNavigationId();     // Catch: Exception -> L52
        boolean r8 = true;
        if (r7 != null) goto L7;
    L9:
        r7 = null;
    L10:
        String r9 = "invalid_navigation_id";
        if (r7 != null) goto L13;
        f3.h.a.a(r15, "invalid_navigation_id", null, null, 14);     // Catch: Exception -> L52
        return;
    L13:
        JsonArray r17 = r16.getWaypoints();     // Catch: Exception -> L52
        if (r17 != null) goto L16;
        f3.h.a.a(r15, "missing_way_points", null, null, 14);     // Catch: Exception -> L52
        return;
    L16:
        final Ref.ObjectRef r10 = new Ref.ObjectRef();     // Catch: Exception -> L52
        List<com.larus.navigation.api.y> r18 = n.d(r17, new n0(r10));     // Catch: Exception -> L52
        if (r18 != null) goto L22;
        String r19 = (String) r10.element;     // Catch: Exception -> L52
        if (r19 != null) goto L21;
        r19 = "invalid_way_point_coordinates";
    L21:
        f3.h.a.a(r15, r19, null, null, 14);     // Catch: Exception -> L52
        return;
    L22:
        int r11 = ((ArrayList) r18).size();     // Catch: Exception -> L52
        int r12 = com.larus.navigation.api.c.a;     // Catch: Exception -> L52
        com.larus.navigation.api.c.d("jsb_update_nav_waypoints", "handle: navigationId=" + r7 + " waypointCount=" + r11);     // Catch: Exception -> L52
        int r5 = com.larus.navigation.api.j.a;     // Catch: Exception -> L52
        com.larus.navigation.api.j.a("flow.updateMapNavigationWaypoints", "navigationId=" + r7 + " waypointCount=" + r11);     // Catch: Exception -> L52
        NavigationService r4 = (NavigationService) ServiceManager.get().getService(NavigationService.class);     // Catch: Exception -> L52
        if (r4 != null) goto L25;
        com.larus.navigation.api.c.b("jsb_update_nav_waypoints", "NavigationService not available");     // Catch: Exception -> L52
        f3.h.a.a(r15, "no_service", null, null, 14);     // Catch: Exception -> L52
        return;
    L25:
        com.larus.navigation.api.r r110 = r4.f(r7, r18);     // Catch: Exception -> L52
        int r6 = r110.b;     // Catch: Exception -> L52
        if (r6 == 0) goto L35;
        if (r6 != 1) goto L29;
    L34:
        r9 = "sdk_internal_error";
    L44:
        if (r9 == null) goto L46;
        com.larus.navigation.api.c.b("jsb_update_nav_waypoints", "updateWaypoints rejected: code=" + r110.b + " errorId=" + r9);     // Catch: Exception -> L52
        f3.h.a.a(r15, r9, null, null, 14);     // Catch: Exception -> L52
        return;
    L46:
        String r111 = r110.a;     // Catch: Exception -> L52
        if (r111 != null) goto L50;
        r111 = "";
    L50:
        com.larus.navigation.api.c.d("jsb_update_nav_waypoints", "updateWaypoints accepted: routeUpdateId=" + r111 + " waypointCount=" + r11);     // Catch: Exception -> L52
        Intrinsics.checkNotNullParameter(AbsUpdateMapNavigationWaypointsIDL.b.class, "<this>");     // Catch: Exception -> L52
        AbsUpdateMapNavigationWaypointsIDL.b r0 = k3.c.a(AbsUpdateMapNavigationWaypointsIDL.b.class);     // Catch: Exception -> L52
        r0.setRouteUpdateId(r111);     // Catch: Exception -> L52
        r15.b(r0, "");     // Catch: Exception -> L52
        return;
    L29:
        if (r6 != 2) goto L31;
        r9 = "navigation_status_not_running";
        goto L44
    L31:
        if (r6 == 3) goto L44;
    L35:
        String r20 = r110.a;     // Catch: Exception -> L52
        if (r20 != null) goto L38;
    L41:
        if (r8 == false) goto L43;
        r9 = "empty_route_update_id";
        goto L44
    L43:
        r9 = null;
        goto L44
    L38:
        if (StringsKt.isBlank(r20) == true) goto L41;
        r8 = false;
        goto L41
    L7:
        if ((!StringsKt.isBlank(r7)) == false) goto L9;
    L52:
        e = move-exception;
        int r1 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.c("jsb_update_nav_waypoints", "handle error [" + e.getClass().getSimpleName() + "]: " + e.getMessage(), e);
        StringBuilder r2 = new StringBuilder("internal_error: ");
        r2.append(e.getMessage());
        f3.h.a.a(r15, r2.toString(), null, null, 14);
    }
}
