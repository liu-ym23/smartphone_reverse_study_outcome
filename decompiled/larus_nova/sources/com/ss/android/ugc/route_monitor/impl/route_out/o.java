package com.ss.android.ugc.route_monitor.impl.route_out;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ss.android.ugc.route_monitor.ComponentType;
import com.ss.android.ugc.route_monitor.RouteMonitorManager;
import com.ss.android.ugc.route_monitor.api.RouteLazyConfigProxy;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import com.ss.android.ugc.route_monitor.utils.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static l f454729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Deque<s> f454730b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedList<l> f454731c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.ss.android.ugc.route_monitor.utils.j<jhc.d> f454732d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static com.ss.android.ugc.route_monitor.utils.j<jhc.n> f454733e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Deque<f> f454734f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile Runnable f454735g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final o f454736h = null;

    public o() {
    }

    static {
        f454736h = new o();
        f454730b = new LinkedList();
        f454731c = new LinkedList();
        f454732d = new com.ss.android.ugc.route_monitor.utils.j();
        f454734f = new LinkedList();
    }

    public static Activity b() {
        Deque<f> r100 = f454734f;
        if (r100.isEmpty() == false) goto L5;
        return null;
    L5:
        Iterator<f> r101 = r100.iterator();
        if (r101.hasNext() == false) goto L9;
        Activity r102 = r101.next().f454686b.get();
        RouteMonitorManager.f454384g.b().getClass();
        return r102;
    L9:
        f r103 = (f) ((LinkedList) r100).getFirst();
        if (r103 == null) goto L15;
        WeakReference<Activity> r104 = r103.f454686b;
        if (r104 != null) goto L14;
        return null;
    L14:
        return r104.get();
    L15:
        return null;
    }

    public static boolean a(WeakReference r100) {
        if (r100.get() == null) goto L14;
        Activity r101 = (Activity) r100.get();
        if (r101 != null) goto L7;
    L8:
        Activity r102 = (Activity) r100.get();
        if (r102 != null) goto L11;
    L13:
        return true;
    L11:
        if (r102.isDestroyed() != true) goto L13;
        return false;
    L7:
        if (r101.isFinishing() != true) goto L8;
        return false;
    L14:
        return false;
    }

    public static String c(String r100) {
        if (r100 != null) goto L4;
    L11:
        return "back";
    L4:
        if (StringsKt.contains$default(r100, "launcher", false, 2, null) == true) goto L11;
        if (StringsKt.contains$default(r100, "launcher2", false, 2, null) == true) goto L11;
        if (StringsKt.contains$default(r100, "home", false, 2, null) == true) goto L11;
        return "third_app";
    }

    public static void d(l r100) {
        p.f454737c.c("route_out_monitor_result", r100.a());
        mhc.b r101 = com.ss.android.ugc.route_monitor.impl.route_out.control.j.f454635a;
        ControlRule r102 = r100.f454721r;
        if (r102 == null) goto L12;
        List<com.ss.android.ugc.route_monitor.impl.route_out.control.c> r103 = com.ss.android.ugc.route_monitor.impl.route_out.control.j.f454638d;
        monitor-enter(r103);
        com.ss.android.ugc.route_monitor.impl.route_out.control.c r104 = new com.ss.android.ugc.route_monitor.impl.route_out.control.c(r102.getCertId(), false, 6);     // Catch: Throwable -> L9
        ((ArrayList) r103).remove(r104);     // Catch: Throwable -> L9
        monitor-exit(r103);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static void g(Intent r110, ComponentType r111, ControlRule r112, String r113, Intent[] r114) {
        l r100 = new l(null, r110, f454730b, r111, "third_app", r112, r113, r114);
        r100.f454711h = -1;
        r100.f454712i = "activity not match";
        k.l(r100);
        d(r100);
    }

    public static void e(Context r110, Intent r111, ResolveInfo r112, ControlRule r113, String r114, Intent[] r115) {
        if (r110 == null) goto L55;
        if (r111 == null) goto L57;
        Logger r116 = Logger.f454747c;
        r110.toString();
        r111.toString();
        Objects.toString(r112);
        r116.b();
        ActivityInfo r100 = r112.activityInfo;
        if (r100 == null) goto L48;
        ScheduledExecutorService r101 = UgUserBackMonitorManager.f454593a;
        System.currentTimeMillis();
        ComponentType r102 = ComponentType.ACTIVITY;
        ApplicationInfo r103 = ((ComponentInfo) r100).applicationInfo;
        if (r103 == null) goto L11;
        String r104 = r103.packageName;
    L12:
        String r105 = c(r104);
        l r117 = new l(r100, r111, f454730b, r102, r105, r113, r114, r115);
        LinkedList<l> r106 = f454731c;
        monitor-enter(r106);
        com.ss.android.ugc.route_monitor.impl.route_out.control.m.a().getClass();     // Catch: Throwable -> L45
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L45
        monitor-exit(r106);
        Intent r108 = r111.putExtra("___route_out_monitor_session___", r117.f454704a);
        f454736h.getClass();
        if (f454733e != null) goto L27;
        f454733e = new com.ss.android.ugc.route_monitor.utils.j();
        RouteLazyConfigProxy r109 = RouteLazyConfigProxy.f454387b;
        if (r109.isLazy() == false) goto L27;
        com.ss.android.ugc.route_monitor.utils.j<jhc.n> r118 = f454733e;
        if (r118 != null) goto L23;
        Intrinsics.throwNpe();
    L23:
        List<jhc.n> r119 = r109.routeOutExtraInterceptListenerList();
        r118.getClass();
        Iterator<jhc.n> r120 = r119.iterator();
    L25:
        if (r120.hasNext() == false) goto L27;
        r118.a(r120.next());
    L27:
        com.ss.android.ugc.route_monitor.utils.j<jhc.n> r121 = f454733e;
        if (r121 != null) goto L30;
        Intrinsics.throwNpe();
    L30:
        HashMap r122 = new HashMap();
        r121.b(new r(r122));
        r122.toString();
        r108.putExtra("out_extra_obj", GsonProtectorUtils.toJson(new Gson(), r122));
        RouteMonitorManager.f454384g.b().getClass();
        r111.toString();
        r117.toString();
        r116.b();
        f454729a = r117;
        k.l(r117);
        p r123 = p.f454737c;
        String r124 = r117.f454704a;
        JSONObject r125 = r117.a();
        r123.getClass();
        if (TextUtils.isEmpty(r124) == true) goto L34;
        Throwable r126 = new Throwable();
        r123.f454775b.execute(new com.ss.android.ugc.route_monitor.utils.e(r123, r124, r125, r126));
    L34:
        d(r117);
        monitor-enter(r106);
    L42:
        th = move-exception;
        throw th;
    L37:
        if (r106.size() < 10) goto L39;
        r106.removeFirst();     // Catch: Throwable -> L42
    L39:
        r106.addLast(r117);     // Catch: Throwable -> L42
        monitor-exit(r106);
        com.ss.android.ugc.route_monitor.c.a().getClass();
        return;
    L45:
        th = move-exception;
        throw th;
    L11:
        r104 = null;
        goto L12
    L48:
        g(r111, ComponentType.ACTIVITY, r113, r114, r115);
        return;
    L57:
        return;
    }

    public static void f(ComponentInfo r110, Intent r111, ComponentType r112, ControlRule r113, String r114, Intent[] r115) {
        ApplicationInfo r100 = r110.applicationInfo;
        if (r100 == null) goto L5;
        String r101 = r100.packageName;
    L6:
        String r102 = c(r101);
        l r103 = new l(r110, r111, f454730b, r112, r102, r113, r114, r115);
        if (r113.actionIsUserAlertConfirm() == false) goto L9;
        r103.f454711h = -3;
        r103.f454712i = "control rule user deny";
    L10:
        k.l(r103);
        d(r103);
        return;
    L9:
        r103.f454711h = -2;
        r103.f454712i = "control rule intercept";
        goto L10
    L5:
        r101 = null;
        goto L6
    }
}
