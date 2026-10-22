package com.ss.android.ugc.route_monitor.utils;

import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.android.ugc.route_monitor.RouteMonitorManager;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f454774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f454775b;

    public boolean a(JSONObject r100) {
        return true;
    }

    public i() {
        this.f454774a = new JSONObject();
        this.f454775b = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("BasicRouteMonitorDataReporter"));
    }

    public void e(Throwable r110) {
        monitor-enter(this);
        String r100 = this.f454774a.toString();     // Catch: Throwable -> L13
        if (r100 != null) goto L6;
    L9:
        boolean r101 = true;
    L10:
        if (r101 == true) goto L25;
        int r102 = l.f454777a;     // Catch: Throwable -> L13
        Intrinsics.throwUninitializedPropertyAccessException("localDataSaveFile");     // Catch: Throwable -> L13
        l.a(r100);     // Catch: Throwable -> L13
    L25:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(this);
        return;
    L6:
        if (r100.length() == 0) goto L9;
        r101 = false;
    L13:
        th = move-exception;
        ihc.f r103 = com.ss.android.ugc.route_monitor.c.a();     // Catch: Throwable -> L28
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L28
        r104.put(CrashHianalyticsData.EXCEPTION_NAME, th.getClass().getName());     // Catch: Throwable -> L28
        String r105 = th.getMessage();     // Catch: Throwable -> L28
        if (r105 != null) goto L18;
        r105 = "";
    L18:
        r104.put("exception_msg", r105);     // Catch: Throwable -> L28
        StackTraceElement[] r106 = r110.getStackTrace();     // Catch: Throwable -> L28
        if (r106 == null) goto L23;
        String r112 = ArraysKt.joinToString$default(r106, "\n", null, null, 0, null, null, 62, null);     // Catch: Throwable -> L28
        if (r112 == null) goto L23;
    L24:
        r104.put("calling_stack", r112);     // Catch: Throwable -> L28
        r103.i();     // Catch: Throwable -> L28
    L23:
        r112 = "";
    L28:
        th = move-exception;
        throw th;
    }

    private final void b(String r100, JSONObject r101) {
        Logger r102 = Logger.f454747c;
        r101.toString();
        r102.b();
        if (a(r101) == false) goto L25;
        boolean r103 = true;
        if (r101.optString("appid", "").length() != 0) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        RouteMonitorManager.f454384g.b().a();
        r101.put("appid", -1);
    L12:
        if (r101.optString("device_id", "").length() != 0) goto L14;
        boolean r105 = true;
    L15:
        if (r105 == false) goto L18;
        RouteMonitorManager.f454384g.b().d();
        r101.put("device_id", "");
    L18:
        if (r101.optString("sdk_version", "").length() == 0) goto L21;
        r103 = false;
    L21:
        if (r103 == false) goto L23;
        r101.put("sdk_version", "1.7.0-alpha.483");
    L23:
        com.ss.android.ugc.route_monitor.c.a().i();
        return;
    L14:
        r105 = false;
        goto L15
    L8:
        r104 = false;
        goto L9
    }

    public final void c(String r100, JSONObject r101) {
        b(r100, r101);
    }

    public final void d(String r100, String r101, JSONObject r102) {
        b(r101, r102);
        if (TextUtils.isEmpty(r100) == true) goto L7;
        Throwable r103 = new Throwable();
        this.f454775b.execute(new g(this, r100, r103));
        return;
    }
}
