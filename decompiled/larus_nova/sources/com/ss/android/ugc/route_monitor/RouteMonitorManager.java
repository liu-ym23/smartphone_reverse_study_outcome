package com.ss.android.ugc.route_monitor;

import android.app.Application;
import android.os.SystemClock;
import com.ss.android.ugc.route_monitor.impl.route_in.config.RouteInMonitorConfigManager;
import com.ss.android.ugc.route_monitor.utils.q;
import ihc.f;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes40.dex */
public final class RouteMonitorManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f454378a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q f454379b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q f454380c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f454381d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final q f454382e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final q f454383f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final RouteMonitorManager f454384g = null;

    static {
        f454378a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(RouteMonitorManager.class), "app", "getApp$route_monitor_release()Landroid/app/Application;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(RouteMonitorManager.class), "hostInfo", "getHostInfo()Lcom/ss/android/ugc/route_monitor/api/IHostAbility;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(RouteMonitorManager.class), "routeInMonitor", "getRouteInMonitor()Lcom/ss/android/ugc/route_monitor/impl/route_in/RouteInMonitor;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(RouteMonitorManager.class), "processName", "getProcessName()Ljava/lang/String;"))};
        f454384g = new RouteMonitorManager();
        new AtomicBoolean();
        SystemClock.uptimeMillis();
        f454379b = new q(RouteMonitorManager$app$2.INSTANCE);
        f454380c = new q(RouteMonitorManager$hostInfo$2.INSTANCE);
        f454381d = LazyKt.lazy(RouteMonitorManager$isMainProcess$2.INSTANCE);
        f454382e = new q(RouteMonitorManager$routeInMonitor$2.INSTANCE);
        f454383f = new q(RouteMonitorManager$processName$2.INSTANCE);
    }

    public final Application a() {
        return (Application) f454379b.getValue(this, f454378a[0]);
    }

    public final f b() {
        return (f) f454380c.getValue(this, f454378a[1]);
    }

    public RouteMonitorManager() {
        List<jhc.f> r100 = com.ss.android.ugc.route_monitor.impl.launch_info.a.f454452a;
        KProperty[] r101 = RouteInMonitorConfigManager.f454511a;
    }

    public final boolean c(String r100) {
        return b().b().contains(r100);
    }
}
