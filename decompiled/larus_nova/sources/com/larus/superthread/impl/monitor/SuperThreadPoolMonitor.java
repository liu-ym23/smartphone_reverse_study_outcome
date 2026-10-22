package com.larus.superthread.impl.monitor;

import android.app.Activity;
import android.os.SystemClock;
import com.bytedance.apm.ApmAgent;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.executor.Instrumentation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class SuperThreadPoolMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f370124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f370125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Instrumentation f370126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile long f370127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f370128e = null;

    public SuperThreadPoolMonitor() {
    }

    static {
        f370127d = 60;
        f370128e = LazyKt.lazy(new f());
    }

    public static void b() {
        if (com.bytedance.apm.d.k() == true) goto L5;
        return;
    L5:
        Instrumentation r100 = f370126c;
        if (r100 == null) goto L9;
        px9.a.a("start monitor");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SuperThreadPoolMonitor$startMonitor$1$1(r100, null), 3, null);
        return;
    }

    public static final void a(Instrumentation r110, long r111) {
        JSONObject r100 = new JSONObject();
        int r101 = r110.getThreadSize();     // Catch: Throwable -> L15
        int r102 = r110.getReleaseSize();     // Catch: Throwable -> L15
        int r103 = r110.getWaiterSize();     // Catch: Throwable -> L15
        int r104 = r110.getPendingSize();     // Catch: Throwable -> L15
        r100.put("release_count", r102 - f370125b);     // Catch: Throwable -> L15
        f370125b = r102;     // Catch: Throwable -> L15
        r100.put("alive_count", r101);     // Catch: Throwable -> L15
        r100.put("idle_count", r103);     // Catch: Throwable -> L15
        r100.put("pending_count", r104);     // Catch: Throwable -> L15
        r100.put("launch_time", SystemClock.uptimeMillis() - f370124a);     // Catch: Throwable -> L15
        AppHost.Companion r105 = AppHost.f326268a;     // Catch: Throwable -> L15
        if (r105.a().isAppBackground() == false) goto L6;
        String r106 = "background";
    L10:
        long r107 = -1;
        if (Intrinsics.areEqual(r106, null) == false) goto L13;
        r107 = SystemClock.uptimeMillis() - (-1);     // Catch: Throwable -> L15
    L13:
        r100.put("cur_page_resume_time", r107);     // Catch: Throwable -> L15
        r100.put("cur_page", r106);     // Catch: Throwable -> L15
        ((d) f370128e.getValue()).getClass();     // Catch: Throwable -> L15
        d.a(r100);     // Catch: Throwable -> L15
    L18:
        if (AppHost.f326268a.isTestChannel() == false) goto L20;
        int r108 = px9.a.f530958a;
        String r109 = "dev_thread_running_monitor -> " + r100;
        Intrinsics.checkNotNullParameter(r109, "msg");
        FLogger.f375446a.w("FlowSuperThreadLogger", r109);
    L20:
        IApplog.f287053a.reportEvent("dev_thread_running_monitor", r100);
        ApmAgent.monitorEvent("dev_thread_running_monitor", r100, null, null);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SuperThreadPoolMonitor$scheduleNext$1(r111, r110, null), 3, null);
        return;
    L6:
        Activity r112 = r105.a().getCurrentActivity();     // Catch: Throwable -> L15
        if (r112 == null) goto L9;
        r106 = r112.getClass().getName();     // Catch: Throwable -> L15
        goto L10
    L9:
        r106 = null;
    L15:
        th = move-exception;
        int r113 = px9.a.f530958a;
        String r114 = "reportThreadPoolInfo error, " + th.getMessage();
        Intrinsics.checkNotNullParameter(r114, "msg");
        FLogger.f375446a.e("FlowSuperThreadLogger", r114, th);
        goto L18
    }
}
