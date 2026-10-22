package com.bytedance.bdlocation_impl.trace;

import android.os.SystemClock;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.permission.PermissionManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LocationTraceManager {
    public final com.bytedance.bdlocation_impl.trace.a a;
    public final Map<String, a> b;

    public static final enum Level extends Enum<Level> {
        public static final Level ERROR = null;
        public static final Level INFO = null;
        public static final /* synthetic */ Level[] a = null;

        static {
            Level r0 = new Level("INFO", 0);
            INFO = r0;
            Level r1 = new Level("ERROR", 1);
            ERROR = r1;
            a = new Level[]{r0, r1};
        }

        public static Level[] values() {
            return (Level[]) a.clone();
        }

        public static Level valueOf(String r1) {
            return (Level) r27.a.a(Level.class, r1);
        }

        public Level(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final d a;
        public final String b;
        public String c;
        public final long d;
        public boolean e;
        public long f;
        public boolean g;
        public boolean h;

        public a(d r1, LocationOption r2, long r3) {
            this.a = r1;
            this.b = r2.getBusinessId();
            this.c = r2.getUploadSource();
            this.d = r3;
        }
    }

    public static final class b {
        public static final LocationTraceManager a = null;

        static {
            a = new LocationTraceManager();
        }
    }

    public static final class c {
        public final d a;
        public String b;
        public final long c;
        public final long d;
        public final long e;
        public boolean f;
        public boolean g;

        public c(d r3, LocationOption r4, long r5) {
            this.a = r3;
            this.b = r4.getUploadSource();
            this.c = r4.getLocationTimeOutMs();
            this.d = r4.getMaxCacheTime();
            this.e = r5;
        }
    }

    public static final class d {
        public final String a;
        public final String b;
        public final String c;
        public final String d;

        public d(String r1, String r2, String r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static Map d() {
        HashMap r0 = new HashMap();
        r0.put(LocationMonitorConst.PERMISSION_STATUS, Integer.valueOf(PermissionManager.checkLocationPermissions(BDLocationConfig.getContext())));
        r0.put(LocationMonitorConst.IS_BACKGROUND, Boolean.valueOf(LocationUtil.isBackground()));
        String r1 = h(BDLocationConfig.getSdkVersion());
        if (r1 != null) goto L8;
        r1 = h("2.17.6-rc.81");
        if (r1 != null) goto L8;
        r1 = LocationInfoConst.UNKNOWN_SERVER_LOCATE_METHOD;
    L8:
        r0.put(LocationMonitorConst.LOCATION_SDK_VERSION, r1);
        return r0;
    }

    public LocationTraceManager() {
        this.a = new com.bytedance.bdlocation_impl.trace.a();
        this.b = new HashMap();
    }

    public static String e(BDLocationException r2) {
        if (r2 != null) goto L5;
        return "unknown location error";
    L5:
        String r1 = h(r2.getDetailMessage());
        if (r1 == null) goto L8;
        return r1;
    L8:
        String r3 = h(r2.getMessage());
        if (r3 != null) goto L12;
        return "unknown location error";
    L12:
        return r3;
    }

    public static String h(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        String r3 = r2.trim();
        if (r3.isEmpty() == false) goto L9;
        return null;
    L9:
        return r3;
    }

    public static d i(LocationOption r7) {
        if (r7 != null) goto L5;
    L19:
        return null;
    L5:
        if (h(r7.getTraceContext()) != null) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L19;
        JSONObject r3 = new JSONObject(r7.getTraceContext());     // Catch: JSONException -> L18
        String r8 = s(r3, "traceName");     // Catch: JSONException -> L18
        String r4 = s(r3, "traceId");     // Catch: JSONException -> L18
        if (r8 == null) goto L16;
        if (r4 == null) goto L16;
        return new d(r8, r4, s(r3, "pageId"), s(r3, "widgetInstanceId"));
    L16:
        Logger.w("BDLbsTrace", "trace context ignored: traceName or traceId missing");     // Catch: JSONException -> L18
        return null;
    L18:
        Logger.w("BDLbsTrace", "trace context ignored: invalid JSON");
        goto L19
    L7:
        r2 = false;
        goto L8
    }

    public final boolean g(a r3) {
        if (r3 != null) goto L4;
    L8:
        return false;
    L4:
        if (r3.h == true) goto L8;
        Map<String, a> r0 = this.b;
        HashMap r1 = (HashMap) r0;
        if (r1.get(r3.b) != r3) goto L8;
        return true;
    }

    public final void k(a r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.e == true) goto L9;
        r5.e = true;
        Map r0 = d();
        HashMap r2 = (HashMap) r0;
        r2.put(LocationMonitorConst.IDENTIFIER, r5.b);
        r2.put("upload_source", r5.c);
        com.bytedance.bdlocation_impl.trace.a r1 = this.a;
        d r6 = r5.a;
        Level r3 = Level.INFO;
        r1.getClass();
        com.bytedance.bdlocation_impl.trace.a.a(r6, LocationMonitorConst.EVENT_LBS_CONTINUOUS_LOCATE_START, r3, null, r0);
        return;
    }

    public final void l(a r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        if (r9.h == true) goto L9;
        k(r9);
        r9.h = true;
        HashMap r0 = new HashMap();
        r0.put(LocationMonitorConst.IDENTIFIER, r9.b);
        com.bytedance.bdlocation_impl.trace.a r1 = this.a;
        d r2 = r9.a;
        Level r3 = Level.INFO;
        long r4 = r9.d;
        Long r10 = Long.valueOf(SystemClock.elapsedRealtime() - r4);
        r1.getClass();
        com.bytedance.bdlocation_impl.trace.a.a(r2, LocationMonitorConst.EVENT_LBS_CONTINUOUS_LOCATE_STOP, r3, r10, r0);
        return;
    }

    public final void o(c r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.f == true) goto L9;
        r6.f = true;
        Map r0 = d();
        HashMap r2 = (HashMap) r0;
        r2.put("upload_source", r6.b);
        r2.put(LocationMonitorConst.TIMEOUT_MS, Long.valueOf(r6.c));
        r2.put(LocationMonitorConst.MAX_CACHE_TIME_MS, Long.valueOf(r6.d));
        com.bytedance.bdlocation_impl.trace.a r1 = this.a;
        d r7 = r6.a;
        Level r3 = Level.INFO;
        r1.getClass();
        com.bytedance.bdlocation_impl.trace.a.a(r7, LocationMonitorConst.EVENT_LBS_SINGLE_LOCATE_START, r3, null, r0);
        return;
    }

    public final synchronized a q(LocationOption r6) {
        monitor-enter(this);
        if (r6 != null) goto L23;
    L21:
        monitor-exit(this);
        return null;
    L23:
    L18:
        th = move-exception;
        throw th;
    L6:
        if (h(r6.getBusinessId()) != null) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L21;
        String r2 = r6.getBusinessId();     // Catch: Throwable -> L18
        l((a) ((HashMap) this.b).remove(r2));     // Catch: Throwable -> L18
        d r3 = i(r6);     // Catch: Throwable -> L18
        if (r3 != null) goto L15;
        monitor-exit(this);
        return null;
    L15:
        a r0 = new a(r3, r6, SystemClock.elapsedRealtime());     // Catch: Throwable -> L18
        ((HashMap) this.b).put(r2, r0);     // Catch: Throwable -> L18
        monitor-exit(this);
        return r0;
    L8:
        r1 = false;
        goto L9
    }

    public final synchronized void r(String r2) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (h(r2) != null) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L12;
        l((a) ((HashMap) this.b).remove(r2));     // Catch: Throwable -> L10
    L12:
        monitor-exit(this);
        return;
    L6:
        r0 = false;
        goto L7
    }

    public static String s(JSONObject r0, String r1) {
        Object r2 = r0.opt(r1);
        if ((r2 instanceof String) == false) goto L10;
        String r3 = (String) r2;
        if (h(r3) != null) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L10;
        return r3;
    L7:
        r4 = false;
    L10:
        return null;
    }

    public final synchronized void a(a r2, LocationOption r3) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (g(r2) == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        r2.c = r3.getUploadSource();     // Catch: Throwable -> L10
        k(r2);     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public final synchronized void b(c r2, LocationOption r3) {
        monitor-enter(this);
        if (r2 != null) goto L15;
    L13:
        monitor-exit(this);
        return;
    L15:
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r2.g == true) goto L13;
        r2.b = r3.getUploadSource();     // Catch: Throwable -> L10
        o(r2);     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public final synchronized void f(a r2, BDLocationException r3) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (g(r2) == false) goto L6;
        j(r2, r3);     // Catch: Throwable -> L8
        Map<String, a> r4 = this.b;     // Catch: Throwable -> L8
        HashMap r5 = (HashMap) r4;     // Catch: Throwable -> L8
        r5.remove(r2.b);     // Catch: Throwable -> L8
        l(r2);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public final void j(a r9, BDLocationException r10) {
        k(r9);
        long r0 = SystemClock.elapsedRealtime();
        boolean r2 = !r9.g;
        if (r10 != null) goto L5;
    L11:
        String r5 = BDLocationException.ERROR_UNKNOWN;
    L12:
        Map r3 = c(r9, false, r5, r2);
        ((HashMap) r3).put(LocationMonitorConst.ERROR_MSG, e(r10));
        com.bytedance.bdlocation_impl.trace.a r11 = this.a;
        d r4 = r9.a;
        Level r6 = Level.ERROR;
        if (r9.g == false) goto L15;
        long r7 = r9.f;
    L16:
        Long r8 = Long.valueOf(r0 - r7);
        r11.getClass();
        com.bytedance.bdlocation_impl.trace.a.a(r4, LocationMonitorConst.EVENT_LBS_CONTINUOUS_LOCATE_UPDATE, r6, r8, r3);
        r9.g = true;
        r9.f = r0;
        return;
    L15:
        r7 = r9.d;
        goto L16
    L5:
        if (h(r10.getCode()) != null) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == true) goto L11;
        r5 = r10.getCode();
        goto L12
    L7:
        r12 = false;
        goto L8
    }

    public final synchronized void m(a r10, BDLocation r11) {
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L4:
        if (g(r10) == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        if (r11 != null) goto L11;
        j(r10, new BDLocationException("location is null", LocationInfoConst.UNKNOWN_SERVER_LOCATE_METHOD, BDLocationException.ERROR_LOCATION_IS_NULL));     // Catch: Throwable -> L28
        monitor-exit(this);
        return;
    L11:
        k(r10);     // Catch: Throwable -> L28
        long r0 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L28
        if (r10.g == true) goto L14;
        boolean r2 = true;
    L15:
        Map r3 = c(r10, true, BDLocationException.SUCCESS, r2);     // Catch: Throwable -> L28
        HashMap r6 = (HashMap) r3;     // Catch: Throwable -> L28
        r6.put(LocationMonitorConst.IS_MOCK, Boolean.valueOf(r11.isMock()));     // Catch: Throwable -> L28
        String r5 = h(r11.getLocationSDKName());     // Catch: Throwable -> L28
        if (r5 != null) goto L21;
        r5 = h(LocationInfoConst.UNKNOWN_SERVER_LOCATE_METHOD);     // Catch: Throwable -> L28
        if (r5 != null) goto L21;
        r5 = LocationInfoConst.UNKNOWN_SERVER_LOCATE_METHOD;
    L21:
        r6.put(LocationMonitorConst.LOCATION_SOURCE, r5);     // Catch: Throwable -> L28
        r6.put(LocationMonitorConst.LOCATION_TIMESTAMP, Long.valueOf(r11.getLocationMs()));     // Catch: Throwable -> L28
        com.bytedance.bdlocation_impl.trace.a r12 = this.a;     // Catch: Throwable -> L28
        d r4 = r10.a;     // Catch: Throwable -> L28
        Level r7 = Level.INFO;     // Catch: Throwable -> L28
        if (r10.g == false) goto L24;
        long r8 = r10.f;     // Catch: Throwable -> L28
    L25:
        Long r9 = Long.valueOf(r0 - r8);     // Catch: Throwable -> L28
        r12.getClass();     // Catch: Throwable -> L28
        com.bytedance.bdlocation_impl.trace.a.a(r4, LocationMonitorConst.EVENT_LBS_CONTINUOUS_LOCATE_UPDATE, r7, r9, r3);     // Catch: Throwable -> L28
        r10.g = true;     // Catch: Throwable -> L28
        r10.f = r0;     // Catch: Throwable -> L28
        monitor-exit(this);
        return;
    L24:
        r8 = r10.d;     // Catch: Throwable -> L28
        goto L25
    L14:
        r2 = false;
        goto L15
    }

    public final synchronized void n(c r9, BDLocationException r10) {
        monitor-enter(this);
        if (r9 != null) goto L25;
    L23:
        monitor-exit(this);
        return;
    L25:
    L20:
        th = move-exception;
        throw th;
    L5:
        if (r9.g == true) goto L23;
        o(r9);     // Catch: Throwable -> L20
        boolean r0 = true;
        r9.g = true;     // Catch: Throwable -> L20
        if (r10 != null) goto L10;
    L16:
        String r1 = BDLocationException.ERROR_UNKNOWN;
    L17:
        Map r2 = d();     // Catch: Throwable -> L20
        HashMap r4 = (HashMap) r2;     // Catch: Throwable -> L20
        r4.put("upload_source", r9.b);     // Catch: Throwable -> L20
        r4.put(LocationMonitorConst.IS_SUCCESS, Boolean.FALSE);     // Catch: Throwable -> L20
        r4.put(LocationMonitorConst.IS_TIMEOUT, Boolean.valueOf(BDLocationException.ERROR_TIMEOUT.equals(r1)));     // Catch: Throwable -> L20
        r4.put(LocationMonitorConst.ERROR_CODE, r1);     // Catch: Throwable -> L20
        r4.put(LocationMonitorConst.ERROR_MSG, e(r10));     // Catch: Throwable -> L20
        com.bytedance.bdlocation_impl.trace.a r11 = this.a;     // Catch: Throwable -> L20
        d r3 = r9.a;     // Catch: Throwable -> L20
        Level r5 = Level.ERROR;     // Catch: Throwable -> L20
        long r6 = r9.e;     // Catch: Throwable -> L20
        Long r12 = Long.valueOf(SystemClock.elapsedRealtime() - r6);     // Catch: Throwable -> L20
        r11.getClass();     // Catch: Throwable -> L20
        com.bytedance.bdlocation_impl.trace.a.a(r3, LocationMonitorConst.EVENT_LBS_SINGLE_LOCATE_END, r5, r12, r2);     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L10:
        if (h(r10.getCode()) == null) goto L13;
        r0 = false;
    L13:
        if (r0 == true) goto L16;
        r1 = r10.getCode();     // Catch: Throwable -> L20
        goto L17
    }

    public final synchronized void p(c r9, BDLocation r10) {
        monitor-enter(this);
        if (r9 != null) goto L25;
    L23:
        monitor-exit(this);
        return;
    L25:
    L20:
        th = move-exception;
        throw th;
    L5:
        if (r9.g == true) goto L23;
        if (r10 != null) goto L11;
        n(r9, new BDLocationException("location is null", LocationInfoConst.UNKNOWN_SERVER_LOCATE_METHOD, BDLocationException.ERROR_LOCATION_IS_NULL));     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L11:
        o(r9);     // Catch: Throwable -> L20
        r9.g = true;     // Catch: Throwable -> L20
        Map r0 = d();     // Catch: Throwable -> L20
        HashMap r3 = (HashMap) r0;     // Catch: Throwable -> L20
        r3.put("upload_source", r9.b);     // Catch: Throwable -> L20
        r3.put(LocationMonitorConst.IS_SUCCESS, Boolean.TRUE);     // Catch: Throwable -> L20
        r3.put(LocationMonitorConst.IS_TIMEOUT, Boolean.FALSE);     // Catch: Throwable -> L20
        r3.put(LocationMonitorConst.ERROR_CODE, BDLocationException.SUCCESS);     // Catch: Throwable -> L20
        r3.put(LocationMonitorConst.IS_CACHE, Boolean.valueOf(r10.isCache()));     // Catch: Throwable -> L20
        r3.put(LocationMonitorConst.IS_MOCK, Boolean.valueOf(r10.isMock()));     // Catch: Throwable -> L20
        String r2 = h(r10.getLocationSDKName());     // Catch: Throwable -> L20
        if (r2 != null) goto L17;
        r2 = h(LocationInfoConst.UNKNOWN_SERVER_LOCATE_METHOD);     // Catch: Throwable -> L20
        if (r2 != null) goto L17;
        r2 = LocationInfoConst.UNKNOWN_SERVER_LOCATE_METHOD;
    L17:
        r3.put(LocationMonitorConst.LOCATION_SOURCE, r2);     // Catch: Throwable -> L20
        r3.put(LocationMonitorConst.LOCATION_TIMESTAMP, Long.valueOf(r10.getLocationMs()));     // Catch: Throwable -> L20
        com.bytedance.bdlocation_impl.trace.a r11 = this.a;     // Catch: Throwable -> L20
        d r1 = r9.a;     // Catch: Throwable -> L20
        Level r4 = Level.INFO;     // Catch: Throwable -> L20
        long r5 = r9.e;     // Catch: Throwable -> L20
        Long r12 = Long.valueOf(SystemClock.elapsedRealtime() - r5);     // Catch: Throwable -> L20
        r11.getClass();     // Catch: Throwable -> L20
        com.bytedance.bdlocation_impl.trace.a.a(r1, LocationMonitorConst.EVENT_LBS_SINGLE_LOCATE_END, r4, r12, r0);     // Catch: Throwable -> L20
        monitor-exit(this);
    }

    public static Map c(a r4, boolean r5, String r6, boolean r7) {
        Map r0 = d();
        HashMap r2 = (HashMap) r0;
        r2.put(LocationMonitorConst.IDENTIFIER, r4.b);
        r2.put("upload_source", r4.c);
        r2.put(LocationMonitorConst.IS_SUCCESS, Boolean.valueOf(r5));
        r2.put(LocationMonitorConst.ERROR_CODE, r6);
        r2.put(LocationMonitorConst.IS_FIRST_LOCATION, Boolean.valueOf(r7));
        return r0;
    }
}
