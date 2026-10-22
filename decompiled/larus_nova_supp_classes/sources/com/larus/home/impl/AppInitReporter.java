package com.larus.home.impl;

import android.app.Application;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.launch.DefaultLaunchMode;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.main.HomeServiceV2;
import com.larus.home.impl.utils.e;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ns3.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class AppInitReporter {
    public static final AppInitReporter a = null;
    public static volatile Long b;
    public static volatile long c;
    public static volatile long d;
    public static volatile long e;
    public static volatile long f;
    public static volatile long g;
    public static volatile long h;
    public static volatile long i;
    public static volatile Long j;
    public static volatile boolean k;
    public static volatile boolean l;
    public static volatile boolean m;
    public static volatile boolean n;
    public static volatile boolean o;
    public static volatile boolean p;
    public static volatile boolean q;
    public static volatile boolean r;

    public AppInitReporter() {
    }

    static {
        a = new AppInitReporter();
        h = -1;
        i = -1;
    }

    public static boolean a(String r1) {
        Object r2 = d.a(r1).first;
        if (r2 != DefaultLaunchMode.CLOD_LAUNCH) goto L5;
    L8:
        return true;
    L5:
        if (r2 == DefaultLaunchMode.UNKNOWN_LAUNCH) goto L8;
        return false;
    }

    public static void b(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "jsonParams");
        if (b != null) goto L6;
        return;
    L6:
        if (o == false) goto L8;
        return;
    L8:
        o = true;
        Application r5 = AppHost.a.getApplication();
        JSONObject r0 = new JSONObject();
        r0.put("real_app_init_time", b);
        r0.put(ReportType.PRIVACY_SHOW.getScene(), System.currentTimeMillis());
        Unit r1 = Unit.INSTANCE;
        e.a(r5, r0.toString());
    }

    public static void c(ReportType r9, JSONObject r10) {
        long r0 = System.currentTimeMillis();
        Long r2 = j;
        if (r2 == null) goto L5;
        long r5 = r2.longValue();
    L6:
        int r3 = a.a[r9.ordinal()];
        if (r3 != 1) goto L9;
        long r1 = r0 - r5;
        r10.put("fst_frame_dur", r1);
        r10.put("duration", r1);
        if (h >= 0) goto L30;
        h = r1;
    L30:
        r10.put("real_launch_mode", d.a(HomeServiceV2.a.a()).first);
        r10.put("stage", r9.getScene());
        FLogger.a.i("AppInitReporter", "ReportType: " + r9 + ", duration=" + r10.optLong("duration", 0) + ", Current report param: " + r10);
        ApmAgent.addPerfTag(r9.getScene(), String.valueOf(r9.getStep()));
        o.a.reportEvent("direct_first_frame", r10);
        return;
    L9:
        if (r3 != 2) goto L11;
        long r4 = r0 - r5;
        r10.put("fst_feed_dur", r4);
        r10.put("duration", r4);
        if (i >= 0) goto L30;
        i = r4;
        goto L30
    L11:
        if (r3 == 3) goto L30;
        if (r3 != 4) goto L15;
        Long r6 = b;
        if (r6 == null) goto L22;
        long r7 = r6.longValue();
    L23:
        r10.put("duration", r0 - r7);
        goto L30
    L22:
        r7 = 0;
        goto L23
    L15:
        if (r3 != 5) goto L18;
        r10.put("duration", r0 - r5);
        goto L30
    L18:
        throw new NoWhenBranchMatchedException();
    L5:
        r5 = 0;
        goto L6
    }
}
