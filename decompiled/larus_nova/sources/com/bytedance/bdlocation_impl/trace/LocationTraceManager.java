package com.bytedance.bdlocation_impl.trace;

import android.os.SystemClock;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.permission.PermissionManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class LocationTraceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.bdlocation_impl.trace.a f199946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, a> f199947b;

    public static final enum Level extends Enum<Level> {
        public static final Level ERROR = null;
        public static final Level INFO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Level[] f199948a = null;

        static {
            Level r100 = new Level("INFO", 0);
            INFO = r100;
            Level r101 = new Level("ERROR", 1);
            ERROR = r101;
            f199948a = new Level[]{r100, r101};
        }

        public static Level[] values() {
            return (Level[]) f199948a.clone();
        }

        public static Level valueOf(String r100) {
            return (Level) r27.a.a(Level.class, r100);
        }

        public Level(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f199949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f199950b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f199951c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f199952d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f199953e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f199954f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f199955g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f199956h;

        public a(d r100, LocationOption r101, long r102) {
            this.f199949a = r100;
            this.f199950b = r101.getBusinessId();
            this.f199951c = r101.getUploadSource();
            this.f199952d = r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LocationTraceManager f199957a = null;

        static {
            f199957a = new LocationTraceManager();
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f199958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f199959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f199960c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f199961d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f199962e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f199963f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f199964g;

        public c(d r100, LocationOption r101, long r102) {
            this.f199958a = r100;
            this.f199959b = r101.getUploadSource();
            this.f199960c = r101.getLocationTimeOutMs();
            this.f199961d = r101.getMaxCacheTime();
            this.f199962e = r102;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f199965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f199966b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f199967c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f199968d;

        public d(String r100, String r101, String r102, String r103) {
            this.f199965a = r100;
            this.f199966b = r101;
            this.f199967c = r102;
            this.f199968d = r103;
        }
    }

    public static Map d() {
        HashMap r100 = new HashMap();
        r100.put(LocationMonitorConst.PERMISSION_STATUS, Integer.valueOf(PermissionManager.checkLocationPermissions(BDLocationConfig.getContext())));
        r100.put(LocationMonitorConst.IS_BACKGROUND, Boolean.valueOf(LocationUtil.isBackground()));
        String r101 = h(BDLocationConfig.getSdkVersion());
        if (r101 != null) goto L8;
        r101 = h(BuildConfig.BDLOCATION_VERSION);
        if (r101 != null) goto L8;
        r101 = "unknown";
    L8:
        r100.put(LocationMonitorConst.LOCATION_SDK_VERSION, r101);
        return r100;
    }

    public LocationTraceManager() {
        this.f199946a = new com.bytedance.bdlocation_impl.trace.a();
        this.f199947b = new HashMap();
    }

    public static String e(BDLocationException r100) {
        if (r100 != null) goto L5;
        return "unknown location error";
    L5:
        String r101 = h(r100.getDetailMessage());
        if (r101 == null) goto L8;
        return r101;
    L8:
        String r102 = h(r100.getMessage());
        if (r102 != null) goto L12;
        return "unknown location error";
    L12:
        return r102;
    }

    public static String h(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = r100.trim();
        if (r101.isEmpty() == false) goto L9;
        return null;
    L9:
        return r101;
    }

    public static d i(LocationOption r100) {
        if (r100 != null) goto L5;
    L19:
        return null;
    L5:
        if (h(r100.getTraceContext()) != null) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L19;
        JSONObject r102 = new JSONObject(r100.getTraceContext());     // Catch: JSONException -> L18
        String r103 = s(r102, "traceName");     // Catch: JSONException -> L18
        String r104 = s(r102, "traceId");     // Catch: JSONException -> L18
        if (r103 == null) goto L16;
        if (r104 == null) goto L16;
        return new d(r103, r104, s(r102, "pageId"), s(r102, "widgetInstanceId"));
    L16:
        Logger.w("BDLbsTrace", "trace context ignored: traceName or traceId missing");     // Catch: JSONException -> L18
        return null;
    L18:
        Logger.w("BDLbsTrace", "trace context ignored: invalid JSON");
        goto L19
    L7:
        r101 = false;
        goto L8
    }

    public final boolean g(a r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (r100.f199956h == true) goto L8;
        Map<String, a> r101 = this.f199947b;
        HashMap r102 = (HashMap) r101;
        if (r102.get(r100.f199950b) != r100) goto L8;
        return true;
    }

    public final void k(a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.f199953e == true) goto L9;
        r100.f199953e = true;
        Map r101 = d();
        HashMap r102 = (HashMap) r101;
        r102.put(LocationMonitorConst.IDENTIFIER, r100.f199950b);
        r102.put("upload_source", r100.f199951c);
        com.bytedance.bdlocation_impl.trace.a r103 = this.f199946a;
        d r104 = r100.f199949a;
        Level r105 = Level.INFO;
        r103.getClass();
        com.bytedance.bdlocation_impl.trace.a.a(r104, LocationMonitorConst.EVENT_LBS_CONTINUOUS_LOCATE_START, r105, null, r101);
        return;
    }

    public final void l(a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.f199956h == true) goto L9;
        k(r100);
        r100.f199956h = true;
        HashMap r101 = new HashMap();
        r101.put(LocationMonitorConst.IDENTIFIER, r100.f199950b);
        com.bytedance.bdlocation_impl.trace.a r102 = this.f199946a;
        d r103 = r100.f199949a;
        Level r104 = Level.INFO;
        long r105 = r100.f199952d;
        Long r106 = Long.valueOf(SystemClock.elapsedRealtime() - r105);
        r102.getClass();
        com.bytedance.bdlocation_impl.trace.a.a(r103, LocationMonitorConst.EVENT_LBS_CONTINUOUS_LOCATE_STOP, r104, r106, r101);
        return;
    }

    public final void o(c r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.f199963f == true) goto L9;
        r100.f199963f = true;
        Map r101 = d();
        HashMap r102 = (HashMap) r101;
        r102.put("upload_source", r100.f199959b);
        r102.put(LocationMonitorConst.TIMEOUT_MS, Long.valueOf(r100.f199960c));
        r102.put(LocationMonitorConst.MAX_CACHE_TIME_MS, Long.valueOf(r100.f199961d));
        com.bytedance.bdlocation_impl.trace.a r103 = this.f199946a;
        d r104 = r100.f199958a;
        Level r105 = Level.INFO;
        r103.getClass();
        com.bytedance.bdlocation_impl.trace.a.a(r104, LocationMonitorConst.EVENT_LBS_SINGLE_LOCATE_START, r105, null, r101);
        return;
    }

    public final synchronized a q(LocationOption r100) {
        monitor-enter(this);
        if (r100 != null) goto L23;
    L21:
        monitor-exit(this);
        return null;
    L23:
    L18:
        th = move-exception;
        throw th;
    L6:
        if (h(r100.getBusinessId()) != null) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == true) goto L21;
        String r102 = r100.getBusinessId();     // Catch: Throwable -> L18
        l((a) ((HashMap) this.f199947b).remove(r102));     // Catch: Throwable -> L18
        d r103 = i(r100);     // Catch: Throwable -> L18
        if (r103 != null) goto L15;
        monitor-exit(this);
        return null;
    L15:
        a r104 = new a(r103, r100, SystemClock.elapsedRealtime());     // Catch: Throwable -> L18
        ((HashMap) this.f199947b).put(r102, r104);     // Catch: Throwable -> L18
        monitor-exit(this);
        return r104;
    L8:
        r101 = false;
        goto L9
    }

    public final synchronized void r(String r100) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (h(r100) != null) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L12;
        l((a) ((HashMap) this.f199947b).remove(r100));     // Catch: Throwable -> L10
    L12:
        monitor-exit(this);
        return;
    L6:
        r101 = false;
        goto L7
    }

    public static String s(JSONObject r100, String r101) {
        Object r102 = r100.opt(r101);
        if ((r102 instanceof String) == false) goto L10;
        String r103 = (String) r102;
        if (h(r103) != null) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L10;
        return r103;
    L7:
        r104 = false;
    L10:
        return null;
    }

    public final synchronized void a(a r100, LocationOption r101) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (g(r100) == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        r100.f199951c = r101.getUploadSource();     // Catch: Throwable -> L10
        k(r100);     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public final synchronized void b(c r100, LocationOption r101) {
        monitor-enter(this);
        if (r100 != null) goto L15;
    L13:
        monitor-exit(this);
        return;
    L15:
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r100.f199964g == true) goto L13;
        r100.f199959b = r101.getUploadSource();     // Catch: Throwable -> L10
        o(r100);     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public final synchronized void f(a r100, BDLocationException r101) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (g(r100) == false) goto L6;
        j(r100, r101);     // Catch: Throwable -> L8
        Map<String, a> r102 = this.f199947b;     // Catch: Throwable -> L8
        HashMap r103 = (HashMap) r102;     // Catch: Throwable -> L8
        r103.remove(r100.f199950b);     // Catch: Throwable -> L8
        l(r100);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public final void j(a r100, BDLocationException r110) {
        k(r100);
        long r101 = SystemClock.elapsedRealtime();
        boolean r102 = !r100.f199955g;
        if (r110 != null) goto L5;
    L11:
        String r103 = "24";
    L12:
        Map r104 = c(r100, false, r103, r102);
        ((HashMap) r104).put("error_msg", e(r110));
        com.bytedance.bdlocation_impl.trace.a r111 = this.f199946a;
        d r105 = r100.f199949a;
        Level r106 = Level.ERROR;
        if (r100.f199955g == false) goto L15;
        long r107 = r100.f199954f;
    L16:
        Long r108 = Long.valueOf(r101 - r107);
        r111.getClass();
        com.bytedance.bdlocation_impl.trace.a.a(r105, LocationMonitorConst.EVENT_LBS_CONTINUOUS_LOCATE_UPDATE, r106, r108, r104);
        r100.f199955g = true;
        r100.f199954f = r101;
        return;
    L15:
        r107 = r100.f199952d;
        goto L16
    L5:
        if (h(r110.getCode()) != null) goto L7;
        boolean r109 = true;
    L8:
        if (r109 == true) goto L11;
        r103 = r110.getCode();
        goto L12
    L7:
        r109 = false;
        goto L8
    }

    public final synchronized void m(a r110, BDLocation r111) {
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L4:
        if (g(r110) == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        if (r111 != null) goto L11;
        j(r110, new BDLocationException("location is null", "unknown", "26"));     // Catch: Throwable -> L28
        monitor-exit(this);
        return;
    L11:
        k(r110);     // Catch: Throwable -> L28
        long r100 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L28
        if (r110.f199955g == true) goto L14;
        boolean r101 = true;
    L15:
        Map r102 = c(r110, true, "200", r101);     // Catch: Throwable -> L28
        HashMap r103 = (HashMap) r102;     // Catch: Throwable -> L28
        r103.put(LocationMonitorConst.IS_MOCK, Boolean.valueOf(r111.isMock()));     // Catch: Throwable -> L28
        String r104 = h(r111.getLocationSDKName());     // Catch: Throwable -> L28
        if (r104 != null) goto L21;
        r104 = h("unknown");     // Catch: Throwable -> L28
        if (r104 != null) goto L21;
        r104 = "unknown";
    L21:
        r103.put(LocationMonitorConst.LOCATION_SOURCE, r104);     // Catch: Throwable -> L28
        r103.put(LocationMonitorConst.LOCATION_TIMESTAMP, Long.valueOf(r111.getLocationMs()));     // Catch: Throwable -> L28
        com.bytedance.bdlocation_impl.trace.a r112 = this.f199946a;     // Catch: Throwable -> L28
        d r105 = r110.f199949a;     // Catch: Throwable -> L28
        Level r106 = Level.INFO;     // Catch: Throwable -> L28
        if (r110.f199955g == false) goto L24;
        long r107 = r110.f199954f;     // Catch: Throwable -> L28
    L25:
        Long r108 = Long.valueOf(r100 - r107);     // Catch: Throwable -> L28
        r112.getClass();     // Catch: Throwable -> L28
        com.bytedance.bdlocation_impl.trace.a.a(r105, LocationMonitorConst.EVENT_LBS_CONTINUOUS_LOCATE_UPDATE, r106, r108, r102);     // Catch: Throwable -> L28
        r110.f199955g = true;     // Catch: Throwable -> L28
        r110.f199954f = r100;     // Catch: Throwable -> L28
        monitor-exit(this);
        return;
    L24:
        r107 = r110.f199952d;     // Catch: Throwable -> L28
        goto L25
    L14:
        r101 = false;
        goto L15
    }

    public final synchronized void n(c r100, BDLocationException r110) {
        monitor-enter(this);
        if (r100 != null) goto L25;
    L23:
        monitor-exit(this);
        return;
    L25:
    L20:
        th = move-exception;
        throw th;
    L5:
        if (r100.f199964g == true) goto L23;
        o(r100);     // Catch: Throwable -> L20
        boolean r101 = true;
        r100.f199964g = true;     // Catch: Throwable -> L20
        if (r110 != null) goto L10;
    L16:
        String r102 = "24";
    L17:
        Map r103 = d();     // Catch: Throwable -> L20
        HashMap r104 = (HashMap) r103;     // Catch: Throwable -> L20
        r104.put("upload_source", r100.f199959b);     // Catch: Throwable -> L20
        r104.put("is_success", Boolean.FALSE);     // Catch: Throwable -> L20
        r104.put(LocationMonitorConst.IS_TIMEOUT, Boolean.valueOf("0".equals(r102)));     // Catch: Throwable -> L20
        r104.put("error_code", r102);     // Catch: Throwable -> L20
        r104.put("error_msg", e(r110));     // Catch: Throwable -> L20
        com.bytedance.bdlocation_impl.trace.a r111 = this.f199946a;     // Catch: Throwable -> L20
        d r105 = r100.f199958a;     // Catch: Throwable -> L20
        Level r106 = Level.ERROR;     // Catch: Throwable -> L20
        long r107 = r100.f199962e;     // Catch: Throwable -> L20
        Long r108 = Long.valueOf(SystemClock.elapsedRealtime() - r107);     // Catch: Throwable -> L20
        r111.getClass();     // Catch: Throwable -> L20
        com.bytedance.bdlocation_impl.trace.a.a(r105, LocationMonitorConst.EVENT_LBS_SINGLE_LOCATE_END, r106, r108, r103);     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L10:
        if (h(r110.getCode()) == null) goto L13;
        r101 = false;
    L13:
        if (r101 == true) goto L16;
        r102 = r110.getCode();     // Catch: Throwable -> L20
        goto L17
    }

    public final synchronized void p(c r100, BDLocation r110) {
        monitor-enter(this);
        if (r100 != null) goto L25;
    L23:
        monitor-exit(this);
        return;
    L25:
    L20:
        th = move-exception;
        throw th;
    L5:
        if (r100.f199964g == true) goto L23;
        if (r110 != null) goto L11;
        n(r100, new BDLocationException("location is null", "unknown", "26"));     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L11:
        o(r100);     // Catch: Throwable -> L20
        r100.f199964g = true;     // Catch: Throwable -> L20
        Map r101 = d();     // Catch: Throwable -> L20
        HashMap r102 = (HashMap) r101;     // Catch: Throwable -> L20
        r102.put("upload_source", r100.f199959b);     // Catch: Throwable -> L20
        r102.put("is_success", Boolean.TRUE);     // Catch: Throwable -> L20
        r102.put(LocationMonitorConst.IS_TIMEOUT, Boolean.FALSE);     // Catch: Throwable -> L20
        r102.put("error_code", "200");     // Catch: Throwable -> L20
        r102.put(LocationMonitorConst.IS_CACHE, Boolean.valueOf(r110.isCache()));     // Catch: Throwable -> L20
        r102.put(LocationMonitorConst.IS_MOCK, Boolean.valueOf(r110.isMock()));     // Catch: Throwable -> L20
        String r103 = h(r110.getLocationSDKName());     // Catch: Throwable -> L20
        if (r103 != null) goto L17;
        r103 = h("unknown");     // Catch: Throwable -> L20
        if (r103 != null) goto L17;
        r103 = "unknown";
    L17:
        r102.put(LocationMonitorConst.LOCATION_SOURCE, r103);     // Catch: Throwable -> L20
        r102.put(LocationMonitorConst.LOCATION_TIMESTAMP, Long.valueOf(r110.getLocationMs()));     // Catch: Throwable -> L20
        com.bytedance.bdlocation_impl.trace.a r111 = this.f199946a;     // Catch: Throwable -> L20
        d r104 = r100.f199958a;     // Catch: Throwable -> L20
        Level r105 = Level.INFO;     // Catch: Throwable -> L20
        long r106 = r100.f199962e;     // Catch: Throwable -> L20
        Long r107 = Long.valueOf(SystemClock.elapsedRealtime() - r106);     // Catch: Throwable -> L20
        r111.getClass();     // Catch: Throwable -> L20
        com.bytedance.bdlocation_impl.trace.a.a(r104, LocationMonitorConst.EVENT_LBS_SINGLE_LOCATE_END, r105, r107, r101);     // Catch: Throwable -> L20
        monitor-exit(this);
    }

    public static Map c(a r100, boolean r101, String r102, boolean r103) {
        Map r104 = d();
        HashMap r105 = (HashMap) r104;
        r105.put(LocationMonitorConst.IDENTIFIER, r100.f199950b);
        r105.put("upload_source", r100.f199951c);
        r105.put("is_success", Boolean.valueOf(r101));
        r105.put("error_code", r102);
        r105.put(LocationMonitorConst.IS_FIRST_LOCATION, Boolean.valueOf(r103));
        return r104;
    }
}
