package com.bytedance.applet.aibridge.navigation;

import com.bytedance.applet.aibridge.permission.PermissionEnum;
import com.bytedance.applet.task.NavigationCardSessionState;
import com.bytedance.applet.task.NavigationMultitaskCard;
import com.google.gson.JsonObject;
import com.larus.navigation.api.NavigationService;
import com.larus.platform.api.f2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class c implements com.larus.navigation.api.i {
    public final com.larus.navigation.api.w a;
    public final String b;
    public final AtomicBoolean c;
    public final rv3.i d;
    public volatile NavigationCardSessionState.a e;

    public abstract void l(String r1);

    public abstract void m(String r1);

    public final NavigationCardSessionState.a i(String r4) {
        NavigationCardSessionState.a r0 = this.e;
        if (r0 == null) goto L14;
        String r2 = r0.b;
        if (r2 != null) goto L7;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == false) goto L14;
        return r0;
    L7:
        if (Intrinsics.areEqual(r2, r4) == true) goto L10;
        r5 = false;
    L14:
        return null;
    }

    public final List<rv3.l> k(JSONObject r19) {
        JSONArray r1 = r19.optJSONArray("routes");
        if (r1 != null) goto L5;
    L40:
        int r2 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d(this.b, "onNavigationRouteChange: routeInfo has no usable routes, keep cached waypoints");
        return null;
    L5:
        if (r1.length() == 0) goto L40;
        int r3 = 0;
        JSONObject r4 = r1.optJSONObject(0);
        if (r4 != null) goto L12;
        int r5 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d(this.b, "onNavigationRouteChange: routeInfo routes[0] is not object, keep cached waypoints");
        return null;
    L12:
        if (r4.has("waypoints") == true) goto L15;
        int r6 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d(this.b, "onNavigationRouteChange: routeInfo has no routes[0].waypoints, keep cached waypoints");
        return null;
    L15:
        JSONArray r7 = r4.optJSONArray("waypoints");
        if (r7 != null) goto L19;
        int r8 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d(this.b, "onNavigationRouteChange: routeInfo routes[0].waypoints is not array, keep cached waypoints");
        return null;
    L19:
        int r9 = r7.length();
        ArrayList r10 = new ArrayList(r9);
    L20:
        if (r3 >= r9) goto L33;
        JSONObject r11 = r7.optJSONObject(r3);
        if (r11 == null) goto L31;
        double r12 = r11.optDouble("latitude", Double.NaN);
        double r13 = r11.optDouble("longitude", Double.NaN);
        if (n.a(r12, r13) == true) goto L26;
        int r14 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.b(this.b, "onNavigationRouteChange: routes[0].waypoints[" + r3 + "] invalid coordinate ");
        rv3.l r15 = null;
    L30:
        if (r15 == null) goto L31;
    L32:
        r10.add(r15);
        r3 = r3 + 1;
        goto L20
    L26:
        String r16 = o(r11, "poiName");
        if (r16 != null) goto L29;
        r16 = o(r11, "name");
    L29:
        r15 = new rv3.l(r12, r13, r16, o(r11, "poiId"), o(r11, "poiType"));
    L31:
        int r17 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.b(this.b, "onNavigationRouteChange: skip invalid routes[0].waypoints[" + r3 + ']');
        r15 = null;
        goto L32
    L33:
        List<rv3.l> r18 = CollectionsKt.filterNotNull(r10);
        if (r7.length() > 0) goto L36;
    L39:
        return r18;
    L36:
        if (r18.isEmpty() == false) goto L39;
        int r20 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.b(this.b, "onNavigationRouteChange: routeInfo waypoints all invalid, keep cached waypoints");
        return null;
    }

    public c(com.larus.navigation.api.w r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "subTag");
        this.a = r2;
        this.b = r3;
        this.c = new AtomicBoolean(false);
        Object r4 = l.a;
        this.d = l.e(r2);
    }

    public static String o(JSONObject r1, String r2) {
        if (r1.has(r2) == true) goto L5;
    L10:
        return null;
    L5:
        if (r1.isNull(r2) == true) goto L10;
        String r3 = r1.optString(r2);
        if (Intrinsics.areEqual(r3, "null") == true) goto L10;
        return r3;
    }

    public final void d(String r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "navigationId");
        int r1 = g.a;
        Intrinsics.checkNotNullParameter(r3, "navigationId");
        JsonObject r2 = new JsonObject();
        r2.addProperty("navigationId", r3);
        r2.addProperty("degree", Float.valueOf(r4));
        Unit r5 = Unit.INSTANCE;
        g.a("flow.onDeviceRotationChange", r2);
    }

    public final void e(String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "navigationId");
        NavigationCardSessionState.a r0 = this.e;
        if (r0 != null) goto L5;
        NavigationCardSessionState.a r2 = null;
    L11:
        if (r0 == null) goto L14;
        if (r2 != null) goto L14;
        int r1 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d(this.b, "onNavigationStart: skip canceled/superseded card update");
    L14:
        this.e = r2;
        int r3 = 0;
        if (this.c.compareAndSet(false, true) == false) goto L40;
        m(r9);
        if (this.a == null) goto L35;
        Object r4 = l.a;
        rv3.i r5 = this.d;
        if (r5 == null) goto L31;
        Object r6 = l.a;
        monitor-enter(r6);
        l.b r7 = l.d;     // Catch: Throwable -> L32
        if (r7 == null) goto L26;
        rv3.i r8 = r7.a;     // Catch: Throwable -> L32
    L27:
        if (r8 != r5) goto L29;
        l.d = null;     // Catch: Throwable -> L32
    L29:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L32
        monitor-exit(r6);
        goto L31
    L26:
        r8 = null;
    L32:
        th = move-exception;
        throw th;
    L31:
        String r12 = l.a(this.a, r9, this.d);
    L36:
        int r13 = com.larus.navigation.api.c.a;
        String r14 = this.b;
        StringBuilder r15 = new StringBuilder("onNavigationStart: first start, detailUrlLen=");
        if (r12 == null) goto L39;
        r3 = r12.length();
    L39:
        r15.append(r3);
        com.larus.navigation.api.c.d(r14, r15.toString());
    L41:
        int r16 = g.a;
        Intrinsics.checkNotNullParameter(r9, "navigationId");
        JsonObject r17 = new JsonObject();
        r17.addProperty("navigationId", r9);
        r17.addProperty("enableTts", Boolean.valueOf(r10));
        Unit r18 = Unit.INSTANCE;
        g.a("flow.onNavigationStart", r17);
        if (r2 == null) goto L47;
        NavigationMultitaskCard r19 = NavigationMultitaskCard.a;
        NavigationMultitaskCard.b r110 = new NavigationMultitaskCard.b("导航中", "正在规划路线", null, null);
        r19.getClass();
        NavigationMultitaskCard.o(r2, r110, true);
        return;
    L47:
        return;
    L35:
        int r20 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.b(this.b, "onNavigationStart: navParam is null, cannot build detail URL");
        r12 = null;
        goto L36
    L40:
        int r21 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d(this.b, "onNavigationStart: subsequent start, keeping original detailPageData");
        goto L41
    L5:
        if (Intrinsics.areEqual(r0.b, r9) == false) goto L9;
        NavigationMultitaskCard.a.getClass();
        Intrinsics.checkNotNullParameter(r0, "owner");
        if (NavigationMultitaskCard.e.a(r0) == false) goto L9;
        r2 = r0;
    L9:
        NavigationMultitaskCard.a.getClass();
        r2 = NavigationMultitaskCard.b(r0, r9);
        goto L11
    }

    public final void f(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "navigationId");
        Intrinsics.checkNotNullParameter(r5, "infoJson");
        CoroutineScope r2 = NavigationAgentReporter.a;
        Intrinsics.checkNotNullParameter(r4, "navigationId");
        Intrinsics.checkNotNullParameter(r5, "infoJson");
        if (f2.a.o() == false) goto L10;
        int r0 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("nav_agent_report", "trip_end: navId=" + r4 + " len=" + r5.length());
        JSONObject r6 = NavigationAgentReporter.b("end_navigation", r5);
        if (r6 == null) goto L11;
        NavigationAgentReporter.c("end_navigation", r6);
        return;
    L11:
        return;
    }

    public final void g(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "navigationId");
        Intrinsics.checkNotNullParameter(r5, "infoJson");
        CoroutineScope r2 = NavigationAgentReporter.a;
        Intrinsics.checkNotNullParameter(r4, "navigationId");
        Intrinsics.checkNotNullParameter(r5, "infoJson");
        if (f2.a.o() == false) goto L10;
        int r0 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("nav_agent_report", "trip_start: navId=" + r4 + " len=" + r5.length());
        JSONObject r6 = NavigationAgentReporter.b("start_navigation", r5);
        if (r6 == null) goto L11;
        NavigationAgentReporter.c("start_navigation", r6);
        return;
    L11:
        return;
    }

    public final void h(String r13, JSONObject r14) {
        Intrinsics.checkNotNullParameter(r13, "navigationId");
        Intrinsics.checkNotNullParameter(r14, "guidanceJson");
        JSONObject r2 = r14.optJSONObject("bindRoutePoint");
        String r3 = null;
        if (r2 == null) goto L9;
        double r8 = r2.optDouble("latitude", Double.NaN);
        double r10 = r2.optDouble("longitude", Double.NaN);
        if (Double.isNaN(r8) == true) goto L9;
        if (Double.isNaN(r10) == true) goto L9;
        Pair<Double, Double> r4 = TuplesKt.to(Double.valueOf(r8), Double.valueOf(r10));
    L17:
        if (r4 == null) goto L19;
        Object r5 = l.a;
        l.g = r4;
    L19:
        String r6 = r14.optString("verbalInstructions");
        Intrinsics.checkNotNull(r6);
        boolean r7 = false;
        if (r6.length() <= 0) goto L22;
        boolean r9 = true;
    L23:
        if (r9 == false) goto L25;
        r3 = r6;
    L25:
        if (r3 == null) goto L37;
        CoroutineScope r11 = NavigationAgentReporter.a;
        Intrinsics.checkNotNullParameter(r13, "navigationId");
        Intrinsics.checkNotNullParameter(r3, "text");
        if (f2.a.o() == false) goto L37;
        String r12 = StringsKt.trim(r3).toString();
        if (r12.length() != 0) goto L32;
        r7 = true;
    L32:
        if (r7 == true) goto L37;
        if (StringsKt.equals(r12, "null", true) == true) goto L37;
        int r15 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("nav_agent_report", "voice_text: navId=" + r13 + " textLen=" + r3.length());
        JSONObject r16 = new JSONObject().put("text", r3).put("occurred_at", System.currentTimeMillis());
        Intrinsics.checkNotNull(r16);
        NavigationAgentReporter.c("maneuver_point", r16);
    L37:
        int r17 = g.a;
        Intrinsics.checkNotNullParameter(r14, "guidanceJson");
        g.a("flow.onNavigationGuidance", h.a(r14));
        return;
    L22:
        r9 = false;
    L9:
        JSONObject r18 = r14.optJSONObject("realLocation");
        if (r18 == null) goto L16;
        double r19 = r18.optDouble("latitude", Double.NaN);
        double r20 = r18.optDouble("longitude", Double.NaN);
        if (Double.isNaN(r19) == true) goto L16;
        if (Double.isNaN(r20) == true) goto L16;
        r4 = TuplesKt.to(Double.valueOf(r19), Double.valueOf(r20));
    L16:
        r4 = null;
        goto L17
    }

    public final void j(String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r4, "navigationId");
        Intrinsics.checkNotNullParameter(r5, "notificationJson");
        int r2 = g.a;
        Intrinsics.checkNotNullParameter(r4, "navigationId");
        Intrinsics.checkNotNullParameter(r5, "notificationJson");
        JsonObject r1 = new JsonObject();
        r1.addProperty("navigationId", r4);
        r1.add(PermissionEnum.NOTIFICATION, h.a(r5));
        Unit r6 = Unit.INSTANCE;
        g.a("flow.onNavigationNotification", r1);
    }

    public final boolean n(String r5, String r6) {
        NavigationService r0 = (NavigationService) ServiceManager.get().getService(NavigationService.class);
        if (r0 == null) goto L5;
        String r1 = r0.c();
    L7:
        if (Intrinsics.areEqual(r5, r1) == false) goto L10;
        return true;
    L10:
        int r2 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d(this.b, "onNavigationRouteChange/waypoint-update: drop stale callback stage=" + r6 + " navId=" + r5 + " activeNavId=" + r1);
        return false;
    L5:
        r1 = null;
        goto L7
    }

    public final void a(String r6, int r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "navigationId");
        if (this.c.compareAndSet(false, true) == false) goto L11;
        NavigationCardSessionState.a r1 = i(r6);
        if (r1 == null) goto L7;
        NavigationMultitaskCard.a.getClass();
        NavigationMultitaskCard.j("start_error_" + r7, r1);
    L7:
        if (r8 != null) goto L9;
        String r2 = "error_" + r7;
    L10:
        l(r2);
        goto L11
    L9:
        r2 = r8;
    L11:
        int r3 = g.a;
        Intrinsics.checkNotNullParameter(r6, "navigationId");
        JsonObject r4 = new JsonObject();
        r4.addProperty("navigationId", r6);
        r4.addProperty("errorCode", Integer.valueOf(r7));
        r4.addProperty("errorMessage", r8);
        Unit r9 = Unit.INSTANCE;
        g.a("flow.onNavigationError", r4);
    }

    public final void b(String r17, int r18, JSONObject r19) {
        Intrinsics.checkNotNullParameter(r17, "navigationId");
        Intrinsics.checkNotNullParameter(r19, "routeInfoJson");
        if (r18 == 2050) goto L5;
    L7:
        boolean r8 = true;
        int r9 = 0;
        if (r18 != 2048) goto L38;
        Object r10 = l.a;
        final Pair<Double, Double> r11 = l.g;
        l.a r12 = l.c;
        if (r12 == null) goto L12;
        rv3.i r13 = r12.b;
    L13:
        if (r11 == null) goto L35;
        if (r13 == null) goto L35;
        final List<rv3.l> r14 = k(r19);
        rv3.i r15 = l.g(r17, new a(r11, r14));
        if (r15 == null) goto L34;
        int r16 = com.larus.navigation.api.c.a;
        String r110 = this.b;
        StringBuilder r111 = new StringBuilder("onNavigationRouteChange/yaw: detailPageData updated startPoint + waypoints hadStartPoint=");
        if (r13.g() == null) goto L20;
        boolean r7 = true;
    L21:
        r111.append(r7);
        r111.append(" oldCount=");
        List<rv3.l> r20 = r13.h();
        if (r20 == null) goto L24;
        int r21 = r20.size();
    L25:
        r111.append(r21);
        r111.append(" newCount=");
        List<rv3.l> r22 = r15.h();
        if (r22 == null) goto L28;
        int r23 = r22.size();
    L29:
        r111.append(r23);
        r111.append(" waypointsUpdated=");
        if (r14 == null) goto L32;
        boolean r24 = true;
    L33:
        r111.append(r24);
        com.larus.navigation.api.c.d(r110, r111.toString());
        goto L38
    L32:
        r24 = false;
        goto L33
    L28:
        r23 = 0;
        goto L29
    L24:
        r21 = 0;
        goto L25
    L20:
        r7 = false;
        goto L21
    L34:
        int r25 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d(this.b, "onNavigationRouteChange/yaw: skip cache update for non-owner navId=".concat(r17));
    L35:
        if (r11 != null) goto L37;
        int r26 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d(this.b, "onNavigationRouteChange/initial-routing: skip startPoint update (no guidance yet)");
        goto L38
    L37:
        int r27 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.b(this.b, "onNavigationRouteChange/yaw: state-machine-error detailPageData=null, cannot update startPoint (hasLastKnownLocation=true)");
        goto L38
    L12:
        r13 = null;
    L38:
        if (r18 != 2050) goto L63;
        Object r28 = l.a;
        l.a r29 = l.c;
        if (r29 == null) goto L42;
        rv3.i r30 = r29.b;
    L43:
        final List<rv3.l> r112 = k(r19);
        if (r30 == null) goto L54;
        if (r112 == null) goto L54;
        if (l.g(r17, new b(r112)) == null) goto L52;
        int r31 = com.larus.navigation.api.c.a;
        String r32 = this.b;
        StringBuilder r113 = new StringBuilder("onNavigationRouteChange/waypoint-update: detailPageData waypoints updated oldCount=");
        List<rv3.l> r33 = r30.h();
        if (r33 == null) goto L51;
        r9 = r33.size();
    L51:
        r113.append(r9);
        r113.append(" newCount=");
        r113.append(r112.size());
        com.larus.navigation.api.c.d(r32, r113.toString());
        goto L63
    L52:
        int r2 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d(this.b, "onNavigationRouteChange/waypoint-update: drop callback for non-owner navId=".concat(r17));
        return;
    L54:
        int r114 = com.larus.navigation.api.c.a;
        String r115 = this.b;
        StringBuilder r116 = new StringBuilder("onNavigationRouteChange/waypoint-update: keep cached waypoints hasPageData=");
        if (r30 == null) goto L57;
        boolean r34 = true;
    L58:
        r116.append(r34);
        r116.append(" hasUpdatedWaypoints=");
        if (r112 != null) goto L62;
        r8 = false;
    L62:
        r116.append(r8);
        com.larus.navigation.api.c.d(r115, r116.toString());
        goto L63
    L57:
        r34 = false;
        goto L58
    L42:
        r30 = null;
    L63:
        if (r18 == 2050) goto L65;
    L67:
        int r6 = g.a;
        Intrinsics.checkNotNullParameter(r17, "navigationId");
        Intrinsics.checkNotNullParameter(r19, "routeInfoJson");
        JsonObject r5 = new JsonObject();
        r5.addProperty("navigationId", r17);
        r5.addProperty("reason", Integer.valueOf(r18));
        r5.add("routeInfo", h.a(r19));
        com.larus.navigation.api.c.d("js_event", "publishEvent: flow.onNavigationRouteChange");
        com.larus.navigation.api.c.a("nav_protocol_trace", "[H5_EVENT/flow.onNavigationRouteChange] navigationId=" + r17 + " reason=" + r18 + " fieldCount=" + r5.entrySet().size());
        Lazy r1 = l3.d.a;
        l3.d.c(new l3.a("flow.onNavigationRouteChange", r5, 4));
        int r3 = com.larus.navigation.api.j.a;
        String r4 = r19.toString();
        Intrinsics.checkNotNullParameter("flow.onNavigationRouteChange", "eventName");
        Intrinsics.checkNotNullParameter(r4, "params");
        return;
    L65:
        if (n(r17, "before_publish") == true) goto L67;
        return;
    L5:
        if (n(r17, "before_cache") == true) goto L7;
    }

    public final void c(String r8, int r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "navigationId");
        int r0 = com.larus.navigation.api.c.a;
        String r1 = this.b;
        StringBuilder r2 = new StringBuilder("onNavigationStop: reason=");
        r2.append(r9);
        r2.append(" descLen=");
        boolean r3 = false;
        if (r10 == null) goto L5;
        int r4 = r10.length();
    L6:
        r2.append(r4);
        r2.append(" navId=");
        r2.append(r8);
        r2.append(" thread=");
        r2.append(ThreadMethodProxy.currentThread().getName());
        com.larus.navigation.api.c.d(r1, r2.toString());
        if (this.c.compareAndSet(false, true) == false) goto L15;
        if (r10 != null) goto L10;
        String r5 = "error_" + r9;
    L11:
        com.larus.navigation.api.c.e(this.b, "onNavigationStop before start result: completing JSB failure reasonCode=" + r9);
        NavigationCardSessionState.a r6 = i(r8);
        if (r6 == null) goto L14;
        NavigationMultitaskCard.a.getClass();
        NavigationMultitaskCard.j("stop_before_start", r6);
    L14:
        l(r5);
        goto L15
    L10:
        r5 = r10;
    L15:
        Object r7 = l.a;
        l.a r11 = l.c;
        if (r11 == null) goto L18;
        rv3.i r12 = r11.b;
    L19:
        if (r12 == null) goto L21;
        boolean r13 = true;
    L22:
        boolean r14 = Intrinsics.areEqual(r10, "jsb_quick_restart");
        Intrinsics.checkNotNullParameter(r8, "navigationId");
        Object r15 = l.a;
        monitor-enter(r15);
        l.a r16 = l.c;     // Catch: Throwable -> L43
        if (r16 != null) goto L28;
    L31:
        r3 = true;
    L32:
        monitor-exit(r15);
        com.larus.navigation.api.c.d(this.b, "cleanupAfterStop: clear detailPageData hadData=" + r13 + " canCleanup=" + r3 + " navId=" + r8 + " quickRestart=" + r14);
        if (r3 == false) goto L41;
        l.e = null;
        l.g = null;
        NavigationCardSessionState.a r17 = i(r8);
        if (r17 == null) goto L41;
        if (r14 == false) goto L40;
        NavigationMultitaskCard.a.l(r17);
        goto L41
    L40:
        NavigationMultitaskCard.a.getClass();
        NavigationMultitaskCard.j("navigation_stopped", r17);
    L41:
        int r18 = g.a;
        Intrinsics.checkNotNullParameter(r8, "navigationId");
        JsonObject r19 = new JsonObject();
        r19.addProperty("navigationId", r8);
        r19.addProperty("reasonCode", Integer.valueOf(r9));
        r19.addProperty("reasonDesc", r10);
        Unit r20 = Unit.INSTANCE;
        g.a("flow.onNavigationStop", r19);
        return;
    L28:
        if (Intrinsics.areEqual(r16.a, r8) == false) goto L32;
        l.c = null;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        throw th;
    L21:
        r13 = false;
        goto L22
    L18:
        r12 = null;
        goto L19
    L5:
        r4 = 0;
        goto L6
    }
}
