package com.bytedance.navigation.kmp;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import b37.j;
import c37.g;
import com.byted.cast.common.auth.AuthConstants;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.navigation.kmp.capability.location_status.LocationSwitchMonitor$start$1;
import com.bytedance.navigation.kmp.handler.projection.ProjectionUploadManager;
import com.bytedance.navigation.kmp.handler.tracker.h;
import com.bytedance.navigation.kmp.handler.tracker.k;
import com.bytedance.navigation.kmp.listener.n;
import com.ss.ttvideoengine.DataLoaderHelper;
import d37.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes21.dex */
public final class BDNavigationApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BDNavigationApi f265675a = null;

    static {
        f265675a = new BDNavigationApi();
    }

    public BDNavigationApi() {
    }

    public static j b() {
        Lazy<NavigationController> r100 = NavigationController.f265676q0;
        NavigationController r101 = NavigationController.a.a();
        if (r101.f265694i == true) goto L6;
        return new j(2101, null);
    L6:
        if (r101.f265688f == false) goto L20;
        d37.j r102 = r101.f265686e;     // Catch: Exception -> L14
        if (r102 == null) goto L11;
        String r103 = r102.v();     // Catch: Exception -> L14
    L12:
        return NavigationController.r(r103);
    L11:
        r103 = null;
    L14:
        e = move-exception;
        i r104 = i.f466749a;
        i.e("requestNavigationSnapshot: engine call failed", e);
        return new j(3101, null);
    L20:
        return new j(DataLoaderHelper.DATALOADER_KEY_INT_DEV_DISK_SIZE_MB, null);
    }

    public static b37.b d(final String r110, List r111) {
        Intrinsics.checkNotNullParameter(r110, "navigationId");
        Intrinsics.checkNotNullParameter(r111, "wayPoints");
        i r100 = i.f466749a;
        i.g("updateWaypoints: navigationId=".concat(r110));
        Lazy<NavigationController> r101 = NavigationController.f265676q0;
        final NavigationController r102 = NavigationController.a.a();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r110, "requestNavigationId");
        Intrinsics.checkNotNullParameter(r111, "wayPoints");
        final NavigationController.d r103 = new NavigationController.d(NavigationController.l(r110), NavigationController.l(r110));
        List<c37.d> r112 = CollectionsKt.toList(r111);     // Catch: Exception -> L56
        NavigationController.s(r103.f265727a, r112);
        NavigationController.s(r103.f265728b, r112);
        if (StringsKt.isBlank(r110) == false) goto L7;
        b37.b r113 = new b37.b(null, 3, "invalid_navigation_id");
        NavigationController.u(r103.f265727a, r113);
        return r113;
    L7:
        i.g("updateWaypoints: waypointCount=" + r112.size());
        Object r104 = r102.L;
        monitor-enter(r104);
    L53:
        th = move-exception;
        throw th;
    L10:
        if (r102.f265688f == true) goto L12;
    L21:
        i.g("updateWaypoints rejected: navigation session is not running, requestNavigationId=".concat(r110));     // Catch: Throwable -> L53
        String r105 = "";
        b37.b r106 = new b37.b(null, 2, "navigation session is not running");     // Catch: Throwable -> L53
    L22:
        String r107 = null;
        d37.j r114 = null;
        int r108 = 0;
        int r115 = 0;
    L23:
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L53
        monitor-exit(r104);
        if (r106 == null) goto L27;
        NavigationController.u(r103.f265727a, r106);
        return r106;
    L27:
        Intrinsics.checkNotNull(r114);
        if (r112.size() >= r115) goto L31;
        int r117 = 1;
    L34:
        Iterator r109 = CollectionsKt.listOf(new h[]{r103.f265727a, r103.f265728b}).iterator();
    L36:
        if (r109.hasNext() == false) goto L43;
        h r118 = (h) r109.next();
        r118.d(AuthConstants.PARAM_KEY_LICENSE_BUSINESS_ID, r105);
        r118.d("transport_type", Integer.valueOf(r108));
        if (r107 != null) goto L40;
        String r119 = "";
    L41:
        r118.d("route_id", r119);
        r118.d("is_change_way_point", Integer.valueOf(r117));
        goto L36
    L40:
        r119 = r107;
        goto L41
    L43:
        if (r114.p() == true) goto L61;
        b37.b r120 = new b37.b(null, 2, "navigation engine status is not running");
        NavigationController.u(r103.f265727a, r120);
        return r120;
    L61:
        final d37.j r121 = r114;
        final int r122 = r117;
        b37.b r123 = r114.a(r112, new c(r102, r103, r110, r121, r122), new d(r102, r103));     // Catch: Exception -> L47
    L52:
        NavigationController.u(r103.f265727a, r123);
        return r123;
    L47:
        e = move-exception;
        i r124 = i.f466749a;
        i.e("updateWaypoints failed synchronously", e);
        String r125 = e.getMessage();
        if (r125 != null) goto L51;
        r125 = "waypoint update failed";
    L51:
        r123 = new b37.b(null, 1, r125);
        goto L52
    L31:
        if (r112.size() <= r115) goto L33;
        r117 = 2;
        goto L34
    L33:
        r117 = 0;
        goto L34
    L12:
        if (r102.f265686e == null) goto L21;
        if (Intrinsics.areEqual(r110, r102.f265708p) == true) goto L17;
        i.g("updateWaypoints rejected: navigationId does not match active session, requestNavigationId=".concat(r110));     // Catch: Throwable -> L53
        r105 = "";
        r106 = new b37.b(null, 3, "invalid_navigation_id");     // Catch: Throwable -> L53
        goto L22
    L17:
        d37.j r126 = r102.f265686e;     // Catch: Throwable -> L53
        String r127 = r102.f265713t;     // Catch: Throwable -> L53
        if (r127 != null) goto L20;
        r127 = "";
    L20:
        r108 = r102.f265712s;     // Catch: Throwable -> L53
        r107 = r102.f265703m0;     // Catch: Throwable -> L53
        r115 = RangesKt.coerceAtLeast(r102.f265717x - r102.f265719z, 0);     // Catch: Throwable -> L53
        r114 = r126;
        r105 = r127;
        r106 = null;
    L56:
        e = move-exception;
        i r128 = i.f466749a;
        i.e("updateWaypoints failed to snapshot request", e);
        b37.b r129 = new b37.b(null, 1, "failed_to_snapshot_waypoints");
        NavigationController.u(r103.f265727a, r129);
        return r129;
    }

    public final Object a(c37.e r100, Continuation<? super Boolean> r101) {
        if ((r101 instanceof BDNavigationApi$init$1) == false) goto L7;
        BDNavigationApi$init$1 r102 = (BDNavigationApi$init$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L18:
        return Boxing.boxBoolean(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        Lazy<NavigationController> r107 = NavigationController.f265676q0;
        NavigationController r108 = NavigationController.a.a();
        r102.label = 1;
        if (r108.n(r100, r102) != r105) goto L18;
        return r105;
    L7:
        r102 = new BDNavigationApi$init$1(this, r101);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r3v16, types: [com.bytedance.navigation.kmp.capability.location_status.LocationSwitchMonitor$start$1] */
    public static String c(g r110, com.larus.navigation.impl.h r111, e37.j r112) {
        Lazy<NavigationController> r100 = NavigationController.f265676q0;
        NavigationController r101 = NavigationController.a.a();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r110, "params");
        com.bytedance.navigation.kmp.handler.tracker.g r102 = r101.M;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r110, "params");
        String r103 = null;
        if (r112 != null) goto L216;
    L9:
        k r113 = null;
    L11:
        if (r110.f22341p != null) goto L22;
        b37.d r104 = d37.k.f466751a;
        long r105 = d37.k.f466752b;
        if (r105 == 0) goto L18;
        int r106 = w27.g.f558041a;
        long r107 = System.currentTimeMillis() - r105;
        if (r107 <= 10000) goto L19;
        i r108 = i.f466749a;
        i.g("PrewarmManager.consumeRecent: cache stale, age=" + r107 + "ms");
        goto L18
    L19:
        b37.d r109 = d37.k.f466751a;
    L20:
        if (r109 == null) goto L23;
        i r114 = i.f466749a;
        i.g("startNavigation: auto-injecting prewarm seed acc=" + r109.f17215d + ", type=" + r109.f17219h);
        d37.k.f466751a = null;
        d37.k.f466752b = 0;
        i.g("PrewarmManager.handoffToNavigation: cache cleared, stream kept for nav");
        r110 = g.a(r110, r109);
    L23:
        Lazy<NavigationController> r115 = NavigationController.f265676q0;
        NavigationController r116 = NavigationController.a.a();
        r116.getClass();
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "listener");
        Object r117 = r116.L;
        monitor-enter(r117);
        boolean r118 = true;
        if (r116.f265702m == false) goto L28;
    L197:
        i r119 = i.f466749a;     // Catch: Throwable -> L205
        i.g("startNavigation rejected: previous session is waiting for finished");     // Catch: Throwable -> L205
        r116.t(r113, 104, "previous navigation is waiting for finished");     // Catch: Throwable -> L205
        monitor-exit(r117);
    L199:
        i r120 = i.f466749a;
        int r121 = r110.f22332g;
        if (r110.f22341p != null) goto L203;
        r118 = false;
    L203:
        i.g("startNavigation: navigatingId=" + r103 + ", routePlanType=" + r121 + ", hasInitialLocation=" + r118);
        StringBuilder r122 = new StringBuilder("startNavigation: route=");
        r122.append(r110);
        r122.append(", navigatingId=");
        r122.append(r103);
        i.a(r122.toString());
        return r103;
    L28:
        if (r116.f265700l != null) goto L197;
    L33:
        e = move-exception;
        String r123 = e.getMessage();     // Catch: Throwable -> L205
        if (r123 != null) goto L163;
        r123 = "startNavigation failed";
    L163:
        r116.t(r113, 103, r123);     // Catch: Throwable -> L205
        i r124 = i.f466749a;     // Catch: Throwable -> L205
        i.e("startNavigation: startNavigation failed", e);     // Catch: Throwable -> L205
        r116.A(r116.f265708p, 103, "startNavigation failed", null);     // Catch: Throwable -> L205
        h r125 = r116.P;     // Catch: Throwable -> L205
        if (r125 == null) goto L166;
        r125.d("is_success", "0");     // Catch: Throwable -> L205
    L166:
        h r126 = r116.P;     // Catch: Throwable -> L205
        if (r126 == null) goto L172;
        String r127 = e.getMessage();     // Catch: Throwable -> L205
        if (r127 != null) goto L171;
        r127 = "startNavigation failed";
    L171:
        r126.d("error_message", r127);     // Catch: Throwable -> L205
    L172:
        h r128 = r116.P;     // Catch: Throwable -> L205
        if (r128 == null) goto L175;
        r128.d("navigation_id", r116.f265708p);     // Catch: Throwable -> L205
    L175:
        h r129 = r116.P;     // Catch: Throwable -> L205
        if (r129 == null) goto L181;
        String r130 = r116.f265713t;     // Catch: Throwable -> L205
        if (r130 != null) goto L180;
        r130 = "";
    L180:
        r129.d(AuthConstants.PARAM_KEY_LICENSE_BUSINESS_ID, r130);     // Catch: Throwable -> L205
    L181:
        h r131 = r116.P;     // Catch: Throwable -> L205
        if (r131 == null) goto L184;
        r131.d("error_code", IInteractGameMonitorService.FAILURE_CODE_LINK_MIC_MUTEX);     // Catch: Throwable -> L205
    L184:
        h r132 = r116.P;     // Catch: Throwable -> L205
        if (r132 == null) goto L187;
        r132.d("transport_type", Integer.valueOf(r116.f265712s));     // Catch: Throwable -> L205
    L187:
        h r133 = r116.P;     // Catch: Throwable -> L205
        if (r133 == null) goto L190;
        r133.b();     // Catch: Throwable -> L205
    L190:
        h r134 = r116.P;     // Catch: Throwable -> L205
        if (r134 == null) goto L193;
        r134.h();     // Catch: Throwable -> L205
    L193:
        r116.P = null;     // Catch: Throwable -> L205
    L194:
        r103 = r116.f265708p;     // Catch: Throwable -> L205
        monitor-exit(r117);
        goto L199
    L31:
        if (r116.f265711r != null) goto L35;
        r116.f265711r = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default(null, 1, null)).plus(new f(CoroutineExceptionHandler.Key)));     // Catch: Exception -> L33 Throwable -> L205
    L35:
        h r135 = new h();     // Catch: Exception -> L33 Throwable -> L205
        r116.P = r135;     // Catch: Exception -> L33 Throwable -> L205
        r135.a();     // Catch: Exception -> L33 Throwable -> L205
        r116.f265698k = new n(r111);     // Catch: Exception -> L33 Throwable -> L205
        r116.f265712s = r110.f22332g;     // Catch: Exception -> L33 Throwable -> L205
        r116.f265713t = r110.f22337l;     // Catch: Exception -> L33 Throwable -> L205
        r116.f265714u = r110.f22326a + "," + r110.f22327b;     // Catch: Exception -> L33 Throwable -> L205
        r116.f265715v = r110.f22329d + "," + r110.f22330e;     // Catch: Exception -> L33 Throwable -> L205
        if (r116.f265688f == false) goto L67;
        i r136 = i.f466749a;     // Catch: Exception -> L33 Throwable -> L205
        i.g("startNavigation, navigation already started");     // Catch: Exception -> L33 Throwable -> L205
        r116.t(r113, 104, "navigation already started");     // Catch: Exception -> L33 Throwable -> L205
        r116.A("", 104, "navigation already started", null);     // Catch: Exception -> L33 Throwable -> L205
        h r137 = r116.P;     // Catch: Exception -> L33 Throwable -> L205
        if (r137 == null) goto L40;
        r137.d("navigation_id", r116.f265708p);     // Catch: Exception -> L33 Throwable -> L205
    L40:
        h r138 = r116.P;     // Catch: Exception -> L33 Throwable -> L205
        if (r138 == null) goto L46;
        String r139 = r116.f265713t;     // Catch: Exception -> L33 Throwable -> L205
        if (r139 != null) goto L45;
        r139 = "";
    L45:
        r138.d(AuthConstants.PARAM_KEY_LICENSE_BUSINESS_ID, r139);     // Catch: Exception -> L33 Throwable -> L205
    L46:
        h r140 = r116.P;     // Catch: Exception -> L33 Throwable -> L205
        if (r140 == null) goto L49;
        r140.d("is_success", "0");     // Catch: Exception -> L33 Throwable -> L205
    L49:
        h r141 = r116.P;     // Catch: Exception -> L33 Throwable -> L205
        if (r141 == null) goto L52;
        r141.d("error_message", "navigation already started");     // Catch: Exception -> L33 Throwable -> L205
    L52:
        h r142 = r116.P;     // Catch: Exception -> L33 Throwable -> L205
        if (r142 == null) goto L55;
        r142.d("error_code", "104");     // Catch: Exception -> L33 Throwable -> L205
    L55:
        h r143 = r116.P;     // Catch: Exception -> L33 Throwable -> L205
        if (r143 == null) goto L58;
        r143.d("transport_type", Integer.valueOf(r116.f265712s));     // Catch: Exception -> L33 Throwable -> L205
    L58:
        h r144 = r116.P;     // Catch: Exception -> L33 Throwable -> L205
        if (r144 == null) goto L61;
        r144.b();     // Catch: Exception -> L33 Throwable -> L205
    L61:
        h r145 = r116.P;     // Catch: Exception -> L33 Throwable -> L205
        if (r145 == null) goto L64;
        r145.h();     // Catch: Exception -> L33 Throwable -> L205
    L64:
        r116.P = null;     // Catch: Exception -> L33 Throwable -> L205
        r103 = "";
        monitor-exit(r117);
        goto L199
    L67:
        r116.q(r110.f22342q);     // Catch: Exception -> L33 Throwable -> L205
        r116.f265688f = true;     // Catch: Exception -> L33 Throwable -> L205
        if (r116.f265694i == true) goto L99;
        i r146 = i.f466749a;     // Catch: Exception -> L33 Throwable -> L205
        i.c("startNavigation: navigation is not initialized");     // Catch: Exception -> L33 Throwable -> L205
        r116.t(r113, 101, "navigation is not initialized");     // Catch: Exception -> L33 Throwable -> L205
        r116.A("", 101, "navigation is not initialized", null);     // Catch: Exception -> L33 Throwable -> L205
        h r147 = r116.P;     // Catch: Exception -> L33 Throwable -> L205
        if (r147 == null) goto L72;
        r147.d("is_success", Boolean.FALSE);     // Catch: Exception -> L33 Throwable -> L205
    L72:
        h r148 = r116.P;     // Catch: Exception -> L33 Throwable -> L205
        if (r148 == null) goto L75;
        r148.d("error_message", "navigation is not initialized");     // Catch: Exception -> L33 Throwable -> L205
    L75:
        h r149 = r116.P;     // Catch: Exception -> L33 Throwable -> L205
        if (r149 == null) goto L78;
        r149.d("error_code", "101");     // Catch: Exception -> L33 Throwable -> L205
    L78:
        h r150 = r116.P;     // Catch: Exception -> L33 Throwable -> L205
        if (r150 == null) goto L81;
        r150.d("navigation_id", r116.f265708p);     // Catch: Exception -> L33 Throwable -> L205
    L81:
        h r151 = r116.P;     // Catch: Exception -> L33 Throwable -> L205
        if (r151 == null) goto L87;
        String r152 = r116.f265713t;     // Catch: Exception -> L33 Throwable -> L205
        if (r152 != null) goto L86;
        r152 = "";
    L86:
        r151.d(AuthConstants.PARAM_KEY_LICENSE_BUSINESS_ID, r152);     // Catch: Exception -> L33 Throwable -> L205
    L87:
        h r153 = r116.P;     // Catch: Exception -> L33 Throwable -> L205
        if (r153 == null) goto L90;
        r153.d("transport_type", Integer.valueOf(r116.f265712s));     // Catch: Exception -> L33 Throwable -> L205
    L90:
        h r154 = r116.P;     // Catch: Exception -> L33 Throwable -> L205
        if (r154 == null) goto L93;
        r154.b();     // Catch: Exception -> L33 Throwable -> L205
    L93:
        h r155 = r116.P;     // Catch: Exception -> L33 Throwable -> L205
        if (r155 == null) goto L96;
        r155.h();     // Catch: Exception -> L33 Throwable -> L205
    L96:
        r116.P = null;     // Catch: Exception -> L33 Throwable -> L205
        r103 = "";
        monitor-exit(r117);
        goto L199
    L99:
        r116.f265710q++;     // Catch: Exception -> L33 Throwable -> L205
        String r156 = UUID.randomUUID().toString() + ":" + r116.f265710q;     // Catch: Exception -> L33 Throwable -> L205
        r116.f265708p = r156;     // Catch: Exception -> L33 Throwable -> L205
        r116.M.b(r113, r156);     // Catch: Exception -> L33 Throwable -> L205
        ((ArrayList) r116.f265705n0).clear();     // Catch: Exception -> L33 Throwable -> L205
        r116.f265703m0 = null;     // Catch: Exception -> L33 Throwable -> L205
        ProjectionUploadManager.f265836a.getClass();     // Catch: Exception -> L33 Throwable -> L205
        ProjectionUploadManager.i();     // Catch: Exception -> L33 Throwable -> L205
        r116.p();     // Catch: Exception -> L33 Throwable -> L205
        if (r110.f22340o == false) goto L102;
        r116.y(r110);     // Catch: Exception -> L33 Throwable -> L205
    L103:
        r116.v();     // Catch: Exception -> L33 Throwable -> L205
        r116.x(r110);     // Catch: Exception -> L33 Throwable -> L205
        d37.g r157 = new d37.g();     // Catch: Exception -> L33 Throwable -> L205
        r116.f265682c = r157;     // Catch: Exception -> L33 Throwable -> L205
        e r158 = new e(r116);     // Catch: Exception -> L33 Throwable -> L205
        Intrinsics.checkNotNullParameter(r158, "listener");     // Catch: Exception -> L33 Throwable -> L205
        final x27.a r159 = r157.f466747a;     // Catch: Exception -> L33 Throwable -> L205
        if (r159 == null) goto L121;
        Intrinsics.checkNotNullParameter(r158, "listener");     // Catch: Exception -> L33 Throwable -> L205
        r159.f562256e = r158;     // Catch: Exception -> L33 Throwable -> L205
        if (r159.f562253b == false) goto L108;
        i.g("[LocationSwitchMonitor] start(): already started.");     // Catch: Exception -> L33 Throwable -> L205
        r159.c(r159.d());     // Catch: Exception -> L33 Throwable -> L205
        goto L121
    L108:
        IntentFilter r160 = new IntentFilter();     // Catch: Exception -> L33 Throwable -> L205
        r160.addAction("android.location.MODE_CHANGED");     // Catch: Exception -> L33 Throwable -> L205
        r160.addAction("android.location.PROVIDERS_CHANGED");     // Catch: Exception -> L33 Throwable -> L205
        ?? r161 = new LocationSwitchMonitor$start$1(r159);     // Catch: Exception -> L33 Throwable -> L205
        r159.f562252a = r161;     // Catch: Exception -> L33 Throwable -> L205
    L119:
        th = move-exception;
        i.e("[LocationSwitchMonitor] start() registerReceiver failed.", th);     // Catch: Exception -> L33 Throwable -> L205
        r159.e();     // Catch: Exception -> L33 Throwable -> L205
        goto L121
    L110:
        if (Build.VERSION.SDK_INT < 33) goto L114;
        Context r162 = r159.f562255d;     // Catch: Throwable -> L119
        if (r162 == null) goto L117;
        x27.a.a(r162, r161, r160);     // Catch: Throwable -> L119
    L117:
        r159.f562253b = true;     // Catch: Throwable -> L119
        r159.c(r159.d());     // Catch: Throwable -> L119
        goto L121
    L114:
        Context r163 = r159.f562255d;     // Catch: Throwable -> L119
        if (r163 == null) goto L117;
        x27.a.b(r163, r161, r160);     // Catch: Throwable -> L119
    L121:
        if (r113 == null) goto L123;
        e37.j r164 = r113.getContext();     // Catch: Exception -> L33 Throwable -> L205
    L124:
        r116.w(r110, r164);     // Catch: Exception -> L33 Throwable -> L205
        h r165 = r116.P;     // Catch: Exception -> L33 Throwable -> L205
        if (r165 == null) goto L127;
        r165.d("is_success", "1");     // Catch: Exception -> L33 Throwable -> L205
    L127:
        h r166 = r116.P;     // Catch: Exception -> L33 Throwable -> L205
        if (r166 == null) goto L130;
        r166.d("navigation_id", r116.f265708p);     // Catch: Exception -> L33 Throwable -> L205
    L130:
        h r167 = r116.P;     // Catch: Exception -> L33 Throwable -> L205
        if (r167 == null) goto L136;
        String r168 = r116.f265713t;     // Catch: Exception -> L33 Throwable -> L205
        if (r168 != null) goto L135;
        r168 = "";
    L135:
        r167.d(AuthConstants.PARAM_KEY_LICENSE_BUSINESS_ID, r168);     // Catch: Exception -> L33 Throwable -> L205
    L136:
        h r169 = r116.P;     // Catch: Exception -> L33 Throwable -> L205
        if (r169 == null) goto L139;
        r169.d("transport_type", Integer.valueOf(r116.f265712s));     // Catch: Exception -> L33 Throwable -> L205
    L139:
        h r170 = r116.P;     // Catch: Exception -> L33 Throwable -> L205
        if (r170 == null) goto L142;
        r170.b();     // Catch: Exception -> L33 Throwable -> L205
    L142:
        h r171 = r116.P;     // Catch: Exception -> L33 Throwable -> L205
        if (r171 == null) goto L145;
        r171.h();     // Catch: Exception -> L33 Throwable -> L205
    L145:
        r116.P = null;     // Catch: Exception -> L33 Throwable -> L205
        com.bytedance.navigation.kmp.handler.tracker.g r172 = r116.M;     // Catch: Exception -> L33 Throwable -> L205
        r172.getClass();     // Catch: Exception -> L33 Throwable -> L205
        Intrinsics.checkNotNullParameter(r156, "navigationId");     // Catch: Exception -> L33 Throwable -> L205
        if (r113 == null) goto L194;
        if (StringsKt.isBlank(r156) == true) goto L194;
        com.bytedance.navigation.kmp.handler.tracker.g.b r173 = r172.d(r113, r156, true, null, null);     // Catch: Throwable -> L157
        r172.f265911b.invoke(r173.getContext(), r173.f265916b);     // Catch: Throwable -> L154
    L208:
        goto L194
    L154:
        th = move-exception;
        com.bytedance.navigation.kmp.handler.tracker.g.g(r173.f265916b.f17270a, th);     // Catch: Throwable -> L157
    L157:
        th = move-exception;
        com.bytedance.navigation.kmp.handler.tracker.g.g("trace_dispatch", th);     // Catch: Exception -> L33 Throwable -> L205
        goto L194
    L123:
        r164 = null;
        goto L124
    L102:
        i r174 = i.f466749a;     // Catch: Exception -> L33 Throwable -> L205
        i.g("foreground service disabled by params");     // Catch: Exception -> L33 Throwable -> L205
    L205:
        th = move-exception;
        throw th;
    L18:
        r109 = null;
        goto L20
    L22:
        i r175 = i.f466749a;
        i.g("startNavigation: caller-supplied initialLocation present, skipping prewarm cache");
        goto L23
    L216:
        r113 = new k(r112, r102.e(), com.bytedance.navigation.kmp.handler.tracker.j.a(r110));     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        com.bytedance.navigation.kmp.handler.tracker.g.g("lbs_client_navi_navigation_start", th);
        goto L9
    }
}
