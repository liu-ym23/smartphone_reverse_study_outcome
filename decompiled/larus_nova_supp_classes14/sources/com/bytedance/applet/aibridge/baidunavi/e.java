package com.bytedance.applet.aibridge.baidunavi;

import com.bytedance.applet.debugger.DebuggerSessionViewModel;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.h1;
import com.larus.platform.api.p1;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocationResult;
import com.larus.platform.service.g0;
import com.larus.platform.service.m;
import com.larus.utils.logger.FLogger;
import hq9.z2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public static final Lazy a = null;
    public static String b;
    public static String c;
    public static GeoLocationInfo d;
    public static Float e;
    public static Job f;
    public static volatile boolean g;
    public static volatile Long h;
    public static volatile boolean i;
    public static int j;
    public static final Lazy k = null;
    public static final Lazy l = null;
    public static a m;

    public interface a {
        void a(GeoLocationInfo r1);

        void onFailed(int r1);
    }

    public static final class b implements z2 {
        public final Lazy a;
        public Long b;

        public b() {
            this.a = LazyKt.lazy(new f());
        }

        public final void a(LocationResult r9, GeoLocationInfo r10) {
            Intrinsics.checkNotNullParameter(r9, "code");
            Intrinsics.checkNotNullParameter(r10, "location");
            this.b = null;
            int r0 = e.j + 1;
            e.j = r0;
            if (r0 > 3) goto L9;
            long r1 = System.currentTimeMillis() - r10.getGpsTime();
            if (r1 < 30000) goto L9;
            FLogger.a.i("bd_loc_reporter", "[onLocationChanged],num:" + e.j + ",code:" + r9 + ",data aborted due to past time:" + r1);
            return;
        L9:
            if (e.i == true) goto L15;
            Long r2 = e.h;
            if (r2 == null) goto L15;
            if ((System.currentTimeMillis() - r2.longValue()) <= DebuggerSessionViewModel.MODE_SWITCH_TIMEOUT_MS) goto L15;
            FLogger.a.i("bd_loc_reporter", "trigger stopLocationOnly due to time out");
            e.c();
        L15:
            FLogger.a.i("bd_loc_reporter", "[onLocationChanged],num:" + e.j + ",code:" + r9);
            a r11 = e.m;
            if (r11 == null) goto L19;
            r11.a(r10);
        L19:
            if (e.b != null) goto L22;
            return;
        L22:
            if (e.c != null) goto L25;
            return;
        L25:
            if (Intrinsics.areEqual(e.d, r10) == true) goto L28;
            e.d = r10;
            return;
        }

        public final synchronized void onError(String r6, String r7) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r6, "code");     // Catch: Throwable -> L17
            Intrinsics.checkNotNullParameter(r7, "msg");     // Catch: Throwable -> L17
            FLogger r2 = FLogger.a;     // Catch: Throwable -> L17
            r2.i("bd_loc_reporter", "[onLocationError]:[" + r6 + "][" + r7 + ']');     // Catch: Throwable -> L17
            a r8 = e.m;     // Catch: Throwable -> L17
            if (r8 == null) goto L7;
            r8.onFailed(1);     // Catch: Throwable -> L17
        L7:
            Long r9 = this.b;     // Catch: Throwable -> L17
            if (r9 != null) goto L10;
            this.b = Long.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L17
        L15:
            monitor-exit(this);
            return;
        L10:
            long r3 = System.currentTimeMillis() - r9.longValue();     // Catch: Throwable -> L17
            if (r3 < ((Number) this.a.getValue()).longValue()) goto L15;
            this.b = null;     // Catch: Throwable -> L17
            r2.i("bd_loc_reporter", "[onLocationError]duration[" + r3 + "]timeout callback triggered");     // Catch: Throwable -> L17
            a r10 = e.m;     // Catch: Throwable -> L17
            if (r10 == null) goto L15;
            r10.onFailed(0);     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            throw th;
        }
    }

    public static final class c extends h.a {
        public c() {
        }

        @Override // com.bytedance.applet.aibridge.baidunavi.h.a
        public final void a(float r5) {
            if (e.b != null) goto L6;
            return;
        L6:
            if (e.c != null) goto L9;
            return;
        L9:
            if (r5 <= 180.0f) goto L11;
            r5 = r5 - 360;
        L11:
            Float r0 = e.e;
            if (r0 != null) goto L14;
        L15:
            FLogger.a.i("bd_loc_reporter", "[onDirChanged]: [" + r0 + "] -> [" + r5 + ']');
            e.e = Float.valueOf(r5);
            return;
        L14:
            if (Math.abs(r0.floatValue() - r5) > 1.0f) goto L15;
        }
    }

    static {
        a = LazyKt.lazy(new com.bytedance.applet.aibridge.baidunavi.b());
        k = LazyKt.lazy(new com.bytedance.applet.aibridge.baidunavi.c());
        l = LazyKt.lazy(new d());
    }

    public static long a() {
        return ((Number) a.getValue()).longValue();
    }

    public static void c() {
        if (g == true) goto L7;
        FLogger.a.i("bd_loc_reporter", "stopLocationOnly but locating not started");
        return;
    L7:
        if (i == false) goto L10;
        FLogger.a.i("bd_loc_reporter", "stopLocationOnly but fully location started");
        return;
    L10:
        g = false;
        m r0 = m.a;
        p1 r1 = m.i();
        if (r1 == null) goto L13;
        r1.f("stop_locating_only");
    L13:
        com.larus.platform.service.g.a.d();
        h = null;
        m = null;
        FLogger.a.i("bd_loc_reporter", "stopLocationOnly done");
    }

    public static void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        g = false;
        h = null;
        m = null;
        i = false;
        FLogger.a.i("bd_loc_reporter", "stopLocation[" + r4 + "],curSessionId[" + b + "];curRouteId[" + c + ']');
        b = null;
        c = null;
        Job r5 = f;
        if (r5 == null) goto L5;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L5:
        f = null;
        m r6 = m.a;
        p1 r7 = m.i();
        if (r7 == null) goto L8;
        r7.f("navi_stop");
    L8:
        com.larus.platform.service.g.a.d();
        int r8 = h.a;
        h.b(AppHost.a.getApplication(), (h.a) l.getValue());
        h1 r9 = g0.a.d();
        if (r9 == null) goto L12;
        r9.b();
        return;
    }
}
