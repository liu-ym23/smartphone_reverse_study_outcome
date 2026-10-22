package fh4;

import android.content.Context;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.dumper.o;
import com.bytedance.crash.dumper.p;
import com.bytedance.crash.i0;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.m0;
import com.bytedance.crash.util.u;
import com.optimize.statistics.FrescoMonitorConst;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static int f477023p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f477024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StackTraceElement[] f477025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f477026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f477027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f477028e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f477029f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f477030g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f477031h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f477032i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, String> f477033j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f477034k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f477035l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f477036m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final JSONObject f477037n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f477038o;

    public final String c() {
        String r100 = this.f477030g;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Throwable r101 = this.f477024a;
        if (r101 == null) goto L8;
        String r102 = u.a(r101);
    L19:
        this.f477030g = r102;
        return r102;
    L8:
        StackTraceElement[] r103 = this.f477025b;
        int r104 = this.f477035l;
        if (r103 != null) goto L11;
    L18:
        r102 = null;
        goto L19
    L11:
        if (r103.length <= 0) goto L18;
        StringBuilder r105 = new StringBuilder();
    L15:
        if (r104 >= r103.length) goto L17;
        StackTraceElement r106 = r103[r104];
        int r107 = u.f203420a;
        String r108 = r106.getClassName();
        r105.append("  at ");
        r105.append(r108);
        r105.append(".");
        r105.append(r106.getMethodName());
        r105.append("(");
        r105.append(r106.getFileName());
        r105.append(":");
        r105.append(r106.getLineNumber());
        r105.append(")\n");
        r104 = r104 + 1;
        goto L15
    L17:
        r102 = r105.toString();
        goto L19
    }

    public final String d() {
        String r100 = this.f477032i;
        if (r100 == null) goto L5;
        return r100;
    L5:
        String r101 = this.f477031h;
        if (r101 == null) goto L8;
        this.f477032i = com.bytedance.crash.util.d.a(r101);
    L10:
        return this.f477032i;
    L8:
        this.f477032i = com.bytedance.crash.util.d.a(c());
        goto L10
    }

    public final String toString() {
        return "EnsureReportData{throwable=" + this.f477024a + ", traceElements=" + Arrays.toString(this.f477025b) + ", stackDepth=" + this.f477035l + ", message='" + this.f477026c + "', isCore=" + this.f477034k + ", data=" + this.f477033j + ", threadName='" + this.f477027d + "', exceptionType='" + this.f477028e + "', logType='" + this.f477029f + "', javaStack='" + this.f477030g + "', nativeStack='" + this.f477031h + "', eventTime=" + this.f477036m + ", md5='" + this.f477032i + "', totalData=" + this.f477037n + '}';
    }

    static {
        f477023p = Process.myPid();
    }

    public final JSONObject e(com.bytedance.crash.monitor.f r100) {
        if (m0.f203237s == true) goto L5;
        m0 r101 = r100.f203291c;
        r101.getClass();
        Map<String, String> r102 = i0.f203227a;
        if (NativeBridge.H() == true) goto L9;
    L11:
        Map<String, String> r103 = r101.f203238a;
    L12:
        Map<String, String> r104 = i0.f203227a;
        if (r104 == null) goto L16;
        HashMap r105 = new HashMap();
        r105.putAll(r103);
        r105.putAll(r104);
        r103 = r105;
    L16:
        return f(r100, r103);
    L9:
        if (r101.f203254q == false) goto L11;
        r103 = NativeBridge.z();
        goto L12
    L5:
        return f(r100, null);
    }

    public final void a(JSONObject r100, com.bytedance.crash.monitor.f r101) {
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L17
        Map<String, String> r103 = this.f477033j;     // Catch: Throwable -> L17
        if (r103 == null) goto L8;
        Iterator<Map.Entry<String, String>> r104 = r103.entrySet().iterator();     // Catch: Throwable -> L17
    L6:
        if (r104.hasNext() == false) goto L8;
        Map.Entry<String, String> r105 = r104.next();     // Catch: Throwable -> L17
        r102.put(r105.getKey(), r105.getValue());     // Catch: Throwable -> L17
    L8:
        if (r101 == null) goto L14;
        Iterator r106 = ((HashMap) r101.f203291c.e(CrashType.ENSURE)).entrySet().iterator();     // Catch: Throwable -> L17
    L11:
        if (r106.hasNext() == false) goto L14;
        Map.Entry r107 = (Map.Entry) r106.next();     // Catch: Throwable -> L17
        r102.put((String) r107.getKey(), r107.getValue());     // Catch: Throwable -> L17
    L14:
        if (com.bytedance.crash.util.j.g(r102) == true) goto L22;
        r100.put("custom", r102);     // Catch: Throwable -> L17
        return;
    L22:
        return;
    }

    public final JSONObject f(com.bytedance.crash.monitor.f r110, Map<String, String> r111) {
        JSONObject r100 = this.f477037n;
        if (r100 != null) goto L40;
        JSONObject r101 = new JSONObject();
        r101.put("event_type", this.f477038o);     // Catch: Throwable -> L38
        r101.put("crash_time", this.f477036m);     // Catch: Throwable -> L38
        if (TextUtils.isEmpty(this.f477029f) == false) goto L13;
        String r102 = "core_exception_monitor";
    L14:
        r101.put(FrescoMonitorConst.LOG_TYPE, r102);     // Catch: Throwable -> L38
        r101.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L38
        r101.put("crash_md5", d());     // Catch: Throwable -> L38
        r101.put("message", this.f477026c);     // Catch: Throwable -> L38
        r101.put("crash_thread_name", this.f477027d);     // Catch: Throwable -> L38
        r101.put("process_name", com.bytedance.crash.util.b.c());     // Catch: Throwable -> L38
        r101.put("app_start_time", com.bytedance.crash.i.b());     // Catch: Throwable -> L38
        int r103 = 1;
        r101.put("exception_type", 1);     // Catch: Throwable -> L38
        r101.put("pid", f477023p);     // Catch: Throwable -> L38
        if (this.f477031h == null) goto L20;
        r101.put("class_ref", "Native");     // Catch: Throwable -> L38
        r101.put(com.alipay.sdk.m.p.e.f25671s, "Native");     // Catch: Throwable -> L38
        r101.put("is_core", 1);     // Catch: Throwable -> L38
        r101.put("line_num", -1);     // Catch: Throwable -> L38
        r101.put("ensure_type", "EnsureNotReachHere");     // Catch: Throwable -> L38
        com.bytedance.crash.util.k r104 = com.bytedance.crash.util.k.a();     // Catch: Throwable -> L38
        String r105 = this.f477031h;     // Catch: Throwable -> L38
        r104.getClass();     // Catch: Throwable -> L38
        r101.put("crash_lib_uuid", com.bytedance.crash.util.k.b(r105));     // Catch: Throwable -> L38
        r101.put("stack", this.f477031h);     // Catch: Throwable -> L38
        r101.put("has_dump", "true");     // Catch: Throwable -> L38
        String r106 = this.f477030g;     // Catch: Throwable -> L38
        if (r106 == null) goto L30;
        r101.put("java_data", r106);     // Catch: Throwable -> L38
    L30:
        String r107 = com.bytedance.crash.i.f203218h;     // Catch: Throwable -> L38
        if (r107 == null) goto L33;
        r101.put("business", r107);     // Catch: Throwable -> L38
    L33:
        a(r101, r110);     // Catch: Throwable -> L38
        b(r101, r110, r111);     // Catch: Throwable -> L38
        o.b(r101);     // Catch: Throwable -> L38
        r101.put(LocationMonitorConst.IS_BACKGROUND, bi4.a.e());     // Catch: Throwable -> L38
        bi4.a.h(r101);     // Catch: Throwable -> L38
        bi4.a.i(r101);     // Catch: Throwable -> L38
        yh4.a r112 = r110.f203300l;
        if (r112 == null) goto L37;
        com.bytedance.crash.dumper.j r113 = (com.bytedance.crash.dumper.j) r112;
        com.bytedance.crash.util.j.d(r101, r113.c(CrashType.ENSURE));
        goto L37
    L20:
        StackTraceElement[] r108 = this.f477025b;     // Catch: Throwable -> L38
        if (r108 != null) goto L23;
        r108 = this.f477024a.getStackTrace();     // Catch: Throwable -> L38
    L23:
        StackTraceElement r109 = r108[this.f477035l];     // Catch: Throwable -> L38
        r101.put("class_ref", r109.getClassName());     // Catch: Throwable -> L38
        r101.put(com.alipay.sdk.m.p.e.f25671s, r109.getMethodName());     // Catch: Throwable -> L38
        r101.put("line_num", r109.getLineNumber());     // Catch: Throwable -> L38
        r101.put("stack", c());     // Catch: Throwable -> L38
        if (this.f477034k == true) goto L27;
        r103 = 0;
    L27:
        r101.put("is_core", r103);     // Catch: Throwable -> L38
        if (TextUtils.isEmpty(this.f477028e) == true) goto L30;
        r101.put("ensure_type", this.f477028e);     // Catch: Throwable -> L38
        goto L30
    L13:
        r102 = this.f477029f;     // Catch: Throwable -> L38
    L37:
        return r101;
    L40:
        if (r100.has("crash_md5") == true) goto L8;
        this.f477037n.put("crash_md5", d());     // Catch: Throwable -> L39
    L8:
        return this.f477037n;
    }

    public final void b(JSONObject r100, com.bytedance.crash.monitor.f r101, Map<String, String> r102) {
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L38
        Context r104 = com.bytedance.crash.i.getContext();     // Catch: Throwable -> L38
        long r105 = 0;
        if (r104 != null) goto L39;
    L7:
        r103.put("storage_free_range", p.a(r105));     // Catch: Throwable -> L38
        r103.put("alog_inited", wg4.a.a());     // Catch: Throwable -> L38
        r100.put("filters", r103);     // Catch: Throwable -> L38
        if (this.f477031h == null) goto L10;
        r103.put("has_dump", "true");     // Catch: Throwable -> L38
    L10:
        if (r101 != null) goto L13;
        return;
    L13:
        if (this.f477031h == null) goto L24;
        Map<String, String> r106 = this.f477033j;     // Catch: Throwable -> L38
        if (r106 == null) goto L24;
        Iterator<Map.Entry<String, String>> r107 = r106.entrySet().iterator();     // Catch: Throwable -> L38
    L18:
        if (r107.hasNext() == false) goto L24;
        Map.Entry<String, String> r108 = r107.next();     // Catch: Throwable -> L38
        if (TextUtils.isEmpty(r108.getKey()) == true) goto L18;
        if (r108.getValue() == null) goto L18;
        r103.put(r108.getKey(), r108.getValue());     // Catch: Throwable -> L38
    L24:
        if (r102 != null) goto L26;
        return;
    L26:
        if (r102.size() <= 0) goto L57;
        Iterator<Map.Entry<String, String>> r109 = r102.entrySet().iterator();     // Catch: Throwable -> L38
    L28:
        if (r109.hasNext() == false) goto L59;
        Map.Entry<String, String> r110 = r109.next();     // Catch: Throwable -> L38
        if (TextUtils.isEmpty(r110.getKey()) == true) goto L28;
        if (r110.getValue() == null) goto L28;
        r103.put(r110.getKey(), r110.getValue());     // Catch: Throwable -> L38
        goto L28
    L59:
        return;
    L57:
        return;
    L39:
        r105 = new StatFs(r104.getFilesDir().getPath()).getFreeBytes();     // Catch: Throwable -> L37
    }

    public g(String r100, String r101, String r102, JSONObject r103, String r104) {
        this.f477037n = r103;
        this.f477029f = r100;
        this.f477030g = r101;
        this.f477031h = r102;
        this.f477038o = r104;
        this.f477026c = r103.optString("message");
    }

    public g(String r100, String r101, String r102, Map r103, String r104, String r105, int r106) {
        this.f477030g = r100;
        if (r101 != null) goto L5;
    L17:
        this.f477031h = r101;
        this.f477026c = r102;
        this.f477027d = r104;
        this.f477029f = r105;
        this.f477033j = r103;
        this.f477036m = System.currentTimeMillis();
        this.f477038o = "native_exception";
        f477023p = r106;
        return;
    L5:
        if (r101.startsWith("Signal") == true) goto L17;
        StringBuilder r107 = new StringBuilder();
        if (r102 != null) goto L10;
        r107.append("Signal 111(NATIVE_EXCEPTION)\n");     // Catch: Throwable -> L19
    L15:
        r107.append(r101);     // Catch: Throwable -> L19
        goto L16
    L10:
        r107.append("Signal 111(");     // Catch: Throwable -> L19
        if (r102.length() <= 30) goto L13;
        r107.append(r102.substring(0, 30));     // Catch: Throwable -> L19
    L14:
        r107.append(")\n");     // Catch: Throwable -> L19
        goto L15
    L13:
        r107.append(r102);     // Catch: Throwable -> L19
    L16:
        r101 = r107.toString();
        goto L17
    }

    public g(Throwable r100, StackTraceElement[] r101, int r102, String r103, Map r104, String r105, String r106) {
        this.f477024a = r100;
        this.f477025b = r101;
        this.f477035l = r102;
        this.f477026c = r103;
        this.f477034k = true;
        this.f477033j = r104;
        this.f477027d = r105;
        this.f477028e = "EnsureNotReachHere";
        this.f477029f = r106;
        this.f477036m = System.currentTimeMillis();
        this.f477038o = com.bytedance.android.ec.core.event.a.KEY_EXCEPTION;
    }
}
