package g1;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.apm.lite.CrashType;
import com.apm.lite.ICrashCallback;
import com.apm.lite.Npth;
import com.apm.lite.k.g;
import com.apm.lite.k.h;
import com.apm.lite.k.k;
import com.apm.lite.k.n;
import com.apm.lite.k.p;
import com.apm.lite.k.u;
import com.apm.lite.nativecrash.NativeImpl;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.sva.sdk.controller.Global;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r1.i;
import r1.l;
import s1.f;

/* JADX INFO: loaded from: classes39.dex */
public final class a {
    public Pattern A;
    public PolarisFileWrapper B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f479529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f479530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f479531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f479532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f479533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f479534f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONObject f479535g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f479536h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f479537i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f479538j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f479539k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public JSONArray f479540l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public JSONObject f479541m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f479542n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f479543o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public JSONArray f479544p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public JSONArray f479545q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public JSONObject f479546r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f479547s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Object f479548t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile boolean f479549u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f479550v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f479551w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final RunnableC5976a f479552x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f479553y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public List<Pattern> f479554z;

    /* JADX INFO: renamed from: g1.a$a, reason: collision with other inner class name */
    public class RunnableC5976a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f479555a;

        public RunnableC5976a(a r100) {
            this.f479555a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f479555a.g();     // Catch: Throwable -> L4
            return;
        L4:
            com.apm.lite.c.a();     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L10;
            return;
        L10:
            throw th;
        }
    }

    public a(Context r100) {
        this.f479532d = -1;
        this.f479533e = true;
        this.f479536h = "unknown";
        this.f479537i = "unknown";
        this.f479538j = "unknown";
        this.f479539k = "npth_inner_default";
        this.f479542n = 0;
        this.f479543o = -1;
        this.f479548t = new Object();
        this.f479550v = -1;
        this.f479551w = 0;
        this.f479552x = new RunnableC5976a(this);
        this.f479553y = 0;
        this.f479554z = null;
        this.A = null;
        this.B = null;
        this.f479530b = r100;
    }

    public static String a(float r100) {
        if (r100 > 0.0f) goto L7;
        return "0%";
    L7:
        if (r100 > 0.1f) goto L11;
        return "0% - 10%";
    L11:
        if (r100 > 0.3f) goto L15;
        return "10% - 30%";
    L15:
        if (r100 > 0.6f) goto L19;
        return "30% - 60%";
    L19:
        if (r100 > 0.9f) goto L22;
        return "60% - 90%";
    L22:
        return "90% - 100%";
    }

    public final JSONObject b(String r100, JSONArray r101) {
        JSONObject r102 = new JSONObject();
        JSONArray r103 = k.b(r101);
        if (r103.length() == r101.length()) goto L9;
        this.f479542n++;
    L9:
        r102.put("thread_name", r100);     // Catch: JSONException -> L7
        r102.put("thread_stack", r103);     // Catch: JSONException -> L7
        return r102;
    L7:
        return null;
    }

    public final void e(JSONArray r110) {
        if (r110 != null) goto L5;
        return;
    L5:
        this.f479534f = null;
        this.f479541m = null;
        this.f479542n = 0;
        JSONArray r100 = new JSONArray();
        JSONArray r101 = new JSONArray();
        JSONArray r102 = new JSONArray();
        this.f479536h = "unknown";
        this.f479537i = "unknown";
        this.f479538j = "unknown";
        int[] r103 = {0, 0, 0};
        String r111 = null;
        int r104 = 0;
        boolean r105 = false;
    L7:
        if (r104 >= r110.length()) goto L108;
        String r112 = r110.optString(r104);
        if (TextUtils.isEmpty(r112) == true) goto L11;
        if (r105 == false) goto L99;
        if (r105 != true) goto L106;
        if (r112.contains(" prio=") == false) goto L95;
        if (r102.length() <= 0) goto L119;
        if (TextUtils.isEmpty(r111) == true) goto L119;
        if (this.f479534f == null) goto L59;
    L61:
        r100.put(b(r111, r102));
    L115:
        if (PullConfiguration.PROCESS_NAME_MAIN.equals(r111) == true) goto L68;
        r111 = r111.substring(0, r111.indexOf(40)).trim();     // Catch: Throwable -> L66
    L68:
        if (f(r111) == true) goto L119;
        int[] r113 = h(r102);     // Catch: Throwable -> L71 IllegalArgumentException -> L72
    L74:
        if (r113 == null) goto L119;
        int r114 = r113[0];
        if (r114 <= r103[0]) goto L79;
        r103[0] = r114;
        this.f479536h = r111;
    L79:
        int r115 = r113[1];
        if (r115 <= r103[1]) goto L82;
        r103[1] = r115;
        this.f479537i = r111;
    L82:
        int r116 = r113[2];
        if (r116 <= r103[2]) goto L119;
        r103[2] = r116;
        this.f479538j = r111;
        goto L119
    L72:
        com.apm.lite.c.a();
    L73:
        r113 = null;
        goto L74
    L59:
        if (PullConfiguration.PROCESS_NAME_MAIN.equals(r111) == false) goto L61;
        this.f479534f = j(r102);
    L119:
        r111 = r112.substring(1, r112.indexOf(34, 1));     // Catch: Throwable -> L90
        if (PullConfiguration.PROCESS_NAME_MAIN.equals(r111) == true) goto L92;
        r111 = r111 + "  (" + r112.substring(r112.indexOf(34, 2) + 1) + " )";     // Catch: Throwable -> L90
    L92:
        if (r102.length() <= 0) goto L97;
        r102 = new JSONArray();
    L97:
        r102.put(r112);
        goto L106
    L95:
        if (TextUtils.isEmpty(r111) == false) goto L97;
    L105:
        r101.put(r112);
    L106:
        r104 = r104 + 1;
        goto L7
    L99:
        if (r112.startsWith("DALVIK THREADS") == false) goto L101;
    L104:
        r105 = true;
        goto L105
    L101:
        if (r112.startsWith("suspend") == true) goto L104;
        if (r112.startsWith("\"") == false) goto L105;
    L11:
        if (r102.length() <= 0) goto L44;
        if (TextUtils.isEmpty(r111) == true) goto L44;
        if (this.f479534f == null) goto L17;
    L19:
        r100.put(b(r111, r102));
    L121:
        if (PullConfiguration.PROCESS_NAME_MAIN.equals(r111) == true) goto L26;
        r111 = r111.substring(0, r111.indexOf(40)).trim();     // Catch: Throwable -> L24
    L26:
        if (f(r111) == true) goto L44;
        int[] r106 = h(r102);     // Catch: Throwable -> L29 IllegalArgumentException -> L30
    L32:
        if (r106 == null) goto L44;
        int r117 = r106[0];
        if (r117 <= r103[0]) goto L37;
        r103[0] = r117;
        this.f479536h = r111;
    L37:
        int r118 = r106[1];
        if (r118 <= r103[1]) goto L40;
        r103[1] = r118;
        this.f479537i = r111;
    L40:
        int r107 = r106[2];
        if (r107 <= r103[2]) goto L44;
        r103[2] = r107;
        this.f479538j = r111;
        goto L44
    L30:
        com.apm.lite.c.a();
    L31:
        r106 = null;
        goto L32
    L17:
        if (PullConfiguration.PROCESS_NAME_MAIN.equals(r111) == false) goto L19;
        this.f479534f = j(r102);
    L44:
        if (r102.length() <= 0) goto L46;
        r102 = new JSONArray();
    L46:
        r111 = null;
        goto L106
    L108:
        if (r100.length() <= 0) goto L132;
        this.f479540l = r101;
        JSONObject r108 = new JSONObject();     // Catch: JSONException -> L112
        this.f479541m = r108;     // Catch: JSONException -> L112
        r108.put("thread_all_count", r100.length());     // Catch: JSONException -> L112
        this.f479541m.put("thread_stacks", r100);     // Catch: JSONException -> L112
        return;
    L112:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public final int[] h(JSONArray r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.length()) goto L32;
        String r102 = r100.optString(r101);
        if (r102 != null) goto L8;
    L10:
        int r103 = -1;
    L11:
        if (r103 > 0) goto L13;
        r101 = r101 + 1;
        goto L4
    L13:
        if (this.A != null) goto L15;
        this.A = PatternProtector.compile("[^0-9]+");
    L15:
        String[] r104 = this.A.split(r102.substring(r103));
        if (r104 != null) goto L18;
        return null;
    L18:
        if (r104.length >= 2) goto L27;
        return null;
    L27:
        int r105 = Integer.decode(r104[1]).intValue();     // Catch: Throwable -> L22
        int r106 = Integer.decode(r104[2]).intValue();     // Catch: Throwable -> L22
        return new int[]{r105, r106, r105 + r106};
    L23:
        throw new IllegalArgumentException("Err stack line: ".concat(r102));
    L8:
        if (r102.isEmpty() == true) goto L10;
        r103 = r102.indexOf("utm=");
        goto L11
    L32:
        return null;
    }

    public final JSONObject j(JSONArray r100) {
        JSONObject r101 = new JSONObject();
        JSONArray r102 = k.b(r100);
        if (r102.length() == r100.length()) goto L13;
        this.f479542n++;
    L13:
        r101.put("thread_number", 1);     // Catch: JSONException -> L11
        StringBuilder r103 = new StringBuilder();     // Catch: JSONException -> L11
        int r104 = 0;
    L7:
        if (r104 >= r102.length()) goto L9;
        r103.append(JSONArrayProtectorUtils.getString(r102, r104));     // Catch: JSONException -> L11
        r103.append('\n');     // Catch: JSONException -> L11
        r104 = r104 + 1;     // Catch: JSONException -> L11
        goto L7
    L9:
        r101.put("mainStackFromTrace", r103.toString());     // Catch: JSONException -> L11
        return r101;
    L11:
        return null;
    }

    public final File k() {
        if (this.B != null) goto L6;
        this.B = new PolarisFileWrapper(this.f479530b.getFilesDir(), "has_anr_signal_" + com.apm.lite.k.a.i().replaceAll(":", "_"));
    L6:
        return this.B;
    }

    public final void g() {
        SystemClock.uptimeMillis();
        if (this.f479549u == false) goto L5;
        this.f479549u = false;
        i();
    L5:
        Context r100 = this.f479530b;
        if ((SystemClock.uptimeMillis() - d.f479562a) >= 5000) goto L206;
    L33:
        String r101 = null;
    L34:
        long r102 = System.currentTimeMillis();
        String r103 = "normal";
        TextUtils.isEmpty(r101);
        if (TextUtils.isEmpty(r101) == true) goto L52;
        Object r110 = this.f479548t;
        monitor-enter(r110);
        monitor-exit(r110);     // Catch: Throwable -> L49
        if (this.f479534f == null) goto L45;
        if ((System.currentTimeMillis() - this.f479532d) > 20000) goto L45;
        r103 = "trace_last";
    L48:
        JSONObject r104 = this.f479534f;
        String r105 = this.f479536h;
        String r106 = this.f479537i;
        String r107 = this.f479538j;
        JSONArray r108 = this.f479540l;
        JSONArray r111 = this.f479545q;
        JSONArray r112 = this.f479544p;
        JSONObject r113 = this.f479546r;
        JSONObject r114 = this.f479535g;
        boolean r115 = this.f479547s;
        long r109 = this.f479543o;
        this.f479534f = null;
        this.f479540l = null;
        this.f479544p = null;
        this.f479535g = null;
        this.f479545q = null;
        this.f479536h = "unknown";
        this.f479537i = "unknown";
        this.f479538j = "unknown";
        this.f479542n = 0;
        JSONArray r116 = r108;
        JSONObject r117 = r104;
        JSONObject r118 = r114;
        JSONObject r119 = r113;
        JSONArray r120 = r112;
        boolean r121 = r115;
        JSONArray r122 = r111;
        String r123 = r107;
        String r124 = r106;
        String r125 = r105;
        String r126 = r103;
        long r127 = r109;
    L54:
        if (TextUtils.isEmpty(r101) == true) goto L56;
        if (r117 != null) goto L87;
        if (r120 == null) goto L208;
    L84:
        r117 = d.b();     // Catch: Throwable -> L86
        goto L87
    L208:
        JSONArray r128 = new JSONArray();     // Catch: Throwable -> L86
        JSONArray r129 = new JSONArray();     // Catch: Throwable -> L82
        JSONObject r130 = new JSONObject();     // Catch: Throwable -> L80
        JSONObject r131 = new JSONObject();     // Catch: Throwable -> L78
        com.apm.lite.k.a.c(this.f479530b, r131);     // Catch: Throwable -> L77
        r119 = r131;
        r118 = r130;
        r120 = r129;
        r122 = r128;
    L77:
        r119 = r131;
    L79:
        r118 = r130;
    L81:
        r120 = r129;
    L83:
        r122 = r128;
    L87:
        JSONObject r132 = r118;
        if (r117 != null) goto L90;
        return;
    L90:
        if (r117.length() <= 0) goto L232;
        r117.put("pid", Process.myPid());     // Catch: Throwable -> L182
        r117.put("package", this.f479530b.getPackageName());     // Catch: Throwable -> L182
        r117.put("is_remote_process", 0);     // Catch: Throwable -> L182
        String r133 = r123;
        r117.put("is_new_stack", 10);     // Catch: Throwable -> L182
        JSONObject r134 = new JSONObject();     // Catch: Throwable -> L182
        k1.a r135 = new k1.a(r134);     // Catch: Throwable -> L182
        String r136 = r124;
        String r210 = r125;
        r135.b("data", r117.toString());     // Catch: Throwable -> L182
        JSONObject r211 = r117;
        r135.b("is_anr", 1);     // Catch: Throwable -> L182
        r135.b("anrType", r126);     // Catch: Throwable -> L182
        r135.b("history_message", r122);     // Catch: Throwable -> L182
        r135.b("current_message", r132);     // Catch: Throwable -> L182
        r135.b("pending_messages", r120);     // Catch: Throwable -> L182
        r135.b("anr_time", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L182
        r135.b("crash_time", Long.valueOf(r127));     // Catch: Throwable -> L182
        k1.a.m(r134, r119);     // Catch: Throwable -> L182
        r135.b("anr_info", r101);     // Catch: Throwable -> L182
        if (r116 == null) goto L94;
        r135.b("dump_trace", r116);     // Catch: Throwable -> L182
    L94:
        JSONObject r137 = this.f479541m;     // Catch: Throwable -> L182
        if (r137 != null) goto L97;
    L100:
        JSONObject r138 = u.l(null);     // Catch: Throwable -> L182
    L101:
        r135.b("all_thread_stacks", r138);     // Catch: Throwable -> L182
        f r139 = f.b();     // Catch: Throwable -> L182
        CrashType r140 = CrashType.ANR;     // Catch: Throwable -> L182
        if (r140 != null) goto L104;
        r139.getClass();     // Catch: Throwable -> L182
    L107:
        r135.b(LocationMonitorConst.IS_BACKGROUND, Boolean.valueOf(r121));     // Catch: Throwable -> L182
        r135.b("logcat", i.b(com.apm.lite.e.f()));     // Catch: Throwable -> L182
        r135.b("has_dump", "true");     // Catch: Throwable -> L182
        r135.b("crash_uuid", com.apm.lite.e.a(r127, r140, false, false));     // Catch: Throwable -> L182
        r135.b("jiffy", 0L);     // Catch: Throwable -> L182
        JSONObject r141 = r135.f501330a.optJSONObject("filters");     // Catch: Throwable -> L182
        if (r141 == null) goto L216;
    L113:
        r141.put("anrType", r126);     // Catch: Throwable -> L184
        r141.put("max_utm_thread", r210);     // Catch: Throwable -> L184
        r141.put("max_stm_thread", r136);     // Catch: Throwable -> L184
        r141.put("max_utm_stm_thread", r133);     // Catch: Throwable -> L184
        r141.put("max_utm_thread_version", this.f479539k);     // Catch: Throwable -> L184
        long r142 = r127 - com.apm.lite.e.f29911c;     // Catch: Throwable -> L184
        if (r142 >= 30000) goto L117;
        String r143 = "0 - 30s";
    L135:
        r141.put("crash_length", r143);     // Catch: Throwable -> L184
        r141.put("disable_looper_monitor", String.valueOf(r1.a.e()));     // Catch: Throwable -> L184
        r141.put("sdk_version", "0.0.2");     // Catch: Throwable -> L184
        r141.put("has_logcat", String.valueOf(r135.k()));     // Catch: Throwable -> L184
        long r144 = new q1.d.b(new PolarisFileWrapper(n.b(com.apm.lite.e.f29909a, com.apm.lite.e.f()), "meminfo.txt")).a();     // Catch: Throwable -> L184
        if (NativeImpl.is64BitRuntime() == false) goto L139;
        long r145 = Long.MAX_VALUE;
    L143:
        if (r144 <= r145) goto L145;
        boolean r146 = true;
    L146:
        r141.put("memory_leak", String.valueOf(r146));     // Catch: Throwable -> L184
        r141.put("fd_leak", String.valueOf(k1.a.o(com.apm.lite.e.f())));     // Catch: Throwable -> L184
        r141.put("threads_leak", String.valueOf(k1.a.p(com.apm.lite.e.f())));     // Catch: Throwable -> L184
        r141.put("is_64_devices", String.valueOf(k1.c.e()));     // Catch: Throwable -> L184
        r141.put("is_64_runtime", String.valueOf(NativeImpl.is64BitRuntime()));     // Catch: Throwable -> L184
        r141.put("is_x86_devices", String.valueOf(k1.c.g()));     // Catch: Throwable -> L184
        r141.put("has_meminfo_file", String.valueOf(new PolarisFileWrapper(n.b(com.apm.lite.e.f29909a, com.apm.lite.e.f()), "meminfo.txt").exists()));     // Catch: Throwable -> L184
        if (q1.c.j() == false) goto L149;
        String r147 = "true";
    L150:
        r141.put("is_root", r147);     // Catch: Throwable -> L184
        if (this.f479549u == true) goto L153;
        boolean r148 = true;
    L154:
        r141.put("anr_normal_trace", String.valueOf(r148));     // Catch: Throwable -> L184
        r141.put("anr_no_run", String.valueOf(true));     // Catch: Throwable -> L184
        if (Npth.hasCrash() == false) goto L157;
        String r149 = "true";
    L158:
        r141.put("crash_after_crash", r149);     // Catch: Throwable -> L184
        r141.put("from_file", String.valueOf(d.f479563b));     // Catch: Throwable -> L184
        r141.put("has_dump", "true");     // Catch: Throwable -> L184
        r141.put("from_kill", String.valueOf(false));     // Catch: Throwable -> L184
        r141.put("last_resume_activity", String.valueOf(s1.c.c().f540091j));     // Catch: Throwable -> L184
        int r150 = this.f479542n;     // Catch: Throwable -> L184
        if (r150 <= 0) goto L212;
        r141.put("may_have_stack_overflow", String.valueOf(r150));     // Catch: Throwable -> L184
    L212:
        c(r101, r141);     // Catch: Throwable -> L163
    L163:
        com.apm.lite.c.a();     // Catch: Throwable -> L184
    L164:
        f1.a r151 = f1.a.a();     // Catch: Throwable -> L182
        CrashType r152 = CrashType.LAUNCH;     // Catch: Throwable -> L182
        com.apm.lite.e.e();     // Catch: Throwable -> L182
        r151.getClass();     // Catch: Throwable -> L182
        if (g.c().length() <= 1024) goto L204;
        r135.c("has_system_traces", "true");     // Catch: Throwable -> L185
    L204:
        JSONArray r153 = q1.d.a(new PolarisFileWrapper(n.b(com.apm.lite.e.f29909a, com.apm.lite.e.f()), "pthreads.txt"), new PolarisFileWrapper(n.b(com.apm.lite.e.f29909a, com.apm.lite.e.f()), "rountines.txt"));     // Catch: Throwable -> L186
        r141.put("leak_threads_count", String.valueOf(r153.length()));     // Catch: Throwable -> L186
        if (r153.length() <= 0) goto L171;
        h.f(new PolarisFileWrapper(n.b(com.apm.lite.e.f29909a, com.apm.lite.e.f()), "leakd_threads.txt"), r153);     // Catch: Throwable -> L186
    L171:
        k1.b.d(r135.f501330a, k1.b.a(r211.optString("mainStackFromTrace")), new b(this, r127));     // Catch: Throwable -> L182
        Iterator r154 = ((CopyOnWriteArrayList) l.f535571e.f535551d).iterator();     // Catch: Throwable -> L182
    L172:
        if (r154.hasNext() == false) goto L233;
        ((ICrashCallback) r154.next()).onCrash(CrashType.ANR, r101, null);     // Catch: Throwable -> L187
    L180:
        com.apm.lite.c.a();     // Catch: Throwable -> L182
        goto L172
    L233:
        return;
    L157:
        r149 = "false";
        goto L158
    L153:
        r148 = false;
        goto L154
    L149:
        r147 = "false";
        goto L150
    L145:
        r146 = false;
        goto L146
    L139:
        if (k1.c.e() == false) goto L141;
        r145 = 3891200;
        goto L143
    L141:
        r145 = 2867200;
        goto L143
    L117:
        if (r142 >= 60000) goto L120;
        r143 = "30s - 1min";
        goto L135
    L120:
        if (r142 >= 120000) goto L123;
        r143 = "1min - 2min";
        goto L135
    L123:
        if (r142 >= 300000) goto L126;
        r143 = "2min - 5min";
        goto L135
    L126:
        if (r142 >= 600000) goto L129;
        r143 = "5min - 10min";
        goto L135
    L129:
        if (r142 >= 1800000) goto L132;
        r143 = "10min - 30min";
        goto L135
    L132:
        if (r142 >= 3600000) goto L134;
        r143 = "30min - 1h";
        goto L135
    L134:
        r143 = "1h - ";
        goto L135
    L216:
        JSONObject r155 = new JSONObject();     // Catch: Throwable -> L184
        r135.b("filters", r155);     // Catch: Throwable -> L112
        r141 = r155;
    L112:
        r141 = r155;
        goto L164
    L104:
        s1.d r156 = r139.a(r140);     // Catch: Throwable -> L182
        if (r156 == null) goto L107;
        r135 = r156.c(r135, null, false);     // Catch: Throwable -> L182
        goto L107
    L97:
        if (r137.length() == 0) goto L100;
        r138 = this.f479541m;     // Catch: Throwable -> L182
    L182:
        com.apm.lite.c.a();
        return;
    L232:
        return;
    L56:
        if (this.f479534f == null) goto L62;
        if ((System.currentTimeMillis() - this.f479532d) <= 20000) goto L62;
        this.f479534f = null;
        this.f479540l = null;
        this.f479544p = null;
        this.f479535g = null;
        this.f479545q = null;
        this.f479536h = "unknown";
        this.f479537i = "unknown";
        this.f479538j = "unknown";
        this.f479542n = 0;
        return;
    L62:
        if (this.f479534f != null) goto L64;
        return;
    L64:
        if ((System.currentTimeMillis() - this.f479532d) > 2000) goto L66;
        return;
    L66:
        if (NativeImpl.isResendSigQuit() == false) goto L230;
        h.k(k());
        return;
    L230:
        return;
    L45:
        if (this.f479549u == false) goto L47;
        this.f479549u = false;
        r103 = "trace_after";
    L47:
        i();
    L49:
        th = move-exception;
        throw th;
    L52:
        r116 = null;
        r122 = null;
        r120 = null;
        r119 = null;
        r118 = null;
        r123 = "unknown";
        r121 = false;
        r124 = "unknown";
        r125 = "unknown";
        r126 = "normal";
        r127 = r102;
        r117 = null;
        goto L54
    L206:
        ActivityManager r157 = (ActivityManager) r100.getSystemService("activity");     // Catch: Throwable -> L32
        if (r157 == null) goto L21;
        int r158 = Process.myPid();     // Catch: Throwable -> L32
        List<ActivityManager.ProcessErrorStateInfo> r159 = r157.getProcessesInErrorState();     // Catch: Throwable -> L32
        if (r159 == null) goto L21;
        Iterator<ActivityManager.ProcessErrorStateInfo> r160 = r159.iterator();     // Catch: Throwable -> L32
    L15:
        if (r160.hasNext() == false) goto L21;
        ActivityManager.ProcessErrorStateInfo r161 = r160.next();     // Catch: Throwable -> L32
        if (r161.pid != r158) goto L15;
        if (r161.condition != 2) goto L15;
    L22:
        if (r161 == null) goto L33;
        if (Process.myPid() != r161.pid) goto L33;
        ActivityManager.ProcessErrorStateInfo r162 = d.f479564c;     // Catch: Throwable -> L32
        if (r162 != null) goto L28;
    L30:
        d.f479564c = r161;     // Catch: Throwable -> L32
        d.f479562a = SystemClock.uptimeMillis();     // Catch: Throwable -> L32
        d.f479563b = false;     // Catch: Throwable -> L32
        r101 = d.a(r161);     // Catch: Throwable -> L32
    L28:
        if (d.c(r162, r161) == false) goto L30;
    L21:
        r161 = null;
        goto L22
    }

    public final void i() {
        if (this.f479551w == this.f479550v) goto L44;
        this.f479543o = System.currentTimeMillis();     // Catch: Throwable -> L38
        this.f479545q = new JSONArray();     // Catch: Throwable -> L38
        this.f479544p = new JSONArray();     // Catch: Throwable -> L38
        this.f479535g = new JSONObject();     // Catch: Throwable -> L38
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L38
        this.f479546r = r100;     // Catch: Throwable -> L38
        com.apm.lite.k.a.c(this.f479530b, r100);     // Catch: Throwable -> L38
        boolean r101 = !com.apm.lite.k.a.f(this.f479530b);     // Catch: Throwable -> L38
        if (r101 == false) goto L9;
        s1.c r102 = s1.c.c();     // Catch: Throwable -> L38
        r102.getClass();     // Catch: Throwable -> L38
        if ((SystemClock.uptimeMillis() - r102.f540098q) > 2000) goto L9;
        r101 = false;
    L9:
        this.f479547s = r101;     // Catch: Throwable -> L38
        if (Npth.hasCrash() == true) goto L12;
        boolean r103 = true;
    L13:
        this.f479533e = r103;     // Catch: Throwable -> L38
        goto L40
    L12:
        r103 = false;
    L40:
        this.f479532d = this.f479543o;     // Catch: Throwable -> L22
        String r104 = "anr_" + com.apm.lite.e.e();     // Catch: Throwable -> L22
        PolarisFileWrapper r105 = new PolarisFileWrapper(new PolarisFileWrapper(new PolarisFileWrapper(n.g(this.f479530b), "apmlite/CrashCommonLog"), r104), "trace_" + com.apm.lite.k.a.i().replace(':', '_') + Global.SUFFIX_TXT_FILE);     // Catch: Throwable -> L22
        r105.getParentFile().mkdirs();     // Catch: Throwable -> L22
        h.h(r105, com.apm.lite.k.b.a().format(new Date(System.currentTimeMillis())) + "\n", false);     // Catch: Throwable -> L22
        r1.n.c("anr_trace", r104);     // Catch: Throwable -> L22
        NativeImpl.doDumpAllThread(r105.getAbsolutePath());     // Catch: Throwable -> L22
        JSONArray r106 = h.l(r105.getAbsolutePath());     // Catch: Throwable -> L17 IOException -> L39
        this.f479540l = r106;     // Catch: Throwable -> L17 IOException -> L39
        e(r106);     // Catch: Throwable -> L17 IOException -> L39
    L17:
        com.apm.lite.c.a();     // Catch: Throwable -> L22
    L19:
        if (this.f479534f != null) goto L23;
        this.f479534f = d.b();     // Catch: Throwable -> L22
    L23:
        g.b();
    L33:
        long r107 = this.f479550v;
        this.f479551w = r107;
        this.f479550v = -1;
        if (r107 != (-1)) goto L50;
        this.f479551w = -2;
        return;
    L50:
        return;
    L22:
        com.apm.lite.c.a();
        goto L23
    L44:
        this.f479532d = this.f479543o;     // Catch: Throwable -> L32
        String r108 = "anr_" + com.apm.lite.e.e();     // Catch: Throwable -> L32
        PolarisFileWrapper r109 = new PolarisFileWrapper(new PolarisFileWrapper(new PolarisFileWrapper(n.g(this.f479530b), "apmlite/CrashCommonLog"), r108), "trace" + com.apm.lite.k.a.i().replace(':', '_') + Global.SUFFIX_TXT_FILE);     // Catch: Throwable -> L32
        r109.getParentFile().mkdirs();     // Catch: Throwable -> L32
        h.h(r109, com.apm.lite.k.b.a().format(new Date(System.currentTimeMillis())) + "\n", false);     // Catch: Throwable -> L32
        r1.n.c("anr_trace", r108);     // Catch: Throwable -> L32
        NativeImpl.doDumpAllThread(r109.getAbsolutePath());     // Catch: Throwable -> L32
        JSONArray r110 = h.l(r109.getAbsolutePath());     // Catch: Throwable -> L27 IOException -> L37
        this.f479540l = r110;     // Catch: Throwable -> L27 IOException -> L37
        e(r110);     // Catch: Throwable -> L27 IOException -> L37
    L27:
        com.apm.lite.c.a();     // Catch: Throwable -> L32
    L29:
        if (this.f479534f != null) goto L33;
        this.f479534f = d.b();     // Catch: Throwable -> L32
    L32:
        com.apm.lite.c.a();
        goto L33
    }

    public final boolean f(String r100) {
        if (this.f479554z != null) goto L17;
        String[] r101 = {"custom_event_settings", "npth_simple_setting", "max_utm_thread_ignore"};
        JSONObject r102 = k.f(r1.a.b(), r101);
        if (r102 != null) goto L7;
        JSONArray r103 = null;
    L8:
        if (r103 == null) goto L15;
        this.f479554z = new LinkedList();
        this.f479539k = r103.optString(0);
        int r104 = 1;
    L11:
        if (r104 >= r103.length()) goto L15;
        ((LinkedList) this.f479554z).add(PatternProtector.compile(r103.optString(r104)));     // Catch: Throwable -> L24
    L13:
        r104 = r104 + 1;
    L15:
        if (this.f479554z != null) goto L17;
        LinkedList r105 = new LinkedList();
        this.f479554z = r105;
        r105.add(PatternProtector.compile("^main$"));
        ((LinkedList) this.f479554z).add(PatternProtector.compile("^default_npth_thread$"));
        ((LinkedList) this.f479554z).add(PatternProtector.compile("^RenderThread$"));
        ((LinkedList) this.f479554z).add(PatternProtector.compile("^Jit thread pool worker thread.*$"));
        goto L17
    L7:
        r103 = r102.optJSONArray(r101[2]);
        p.b("normal get configArray: " + r101[2] + " : " + r103);
    L17:
        Iterator<Pattern> r106 = this.f479554z.iterator();
    L19:
        if (r106.hasNext() == false) goto L23;
        if (r106.next().matcher(r100).matches() == false) goto L19;
        return true;
    L23:
        return false;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 11741. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final void c(java.lang.String r31, org.json.JSONObject r32) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0010: NEW_ARRAY (r4v0 ?? I:float[]) = (3 int) A[DECLARE_VAR] (LINE:33554448) type: float[] in method: g1.a.c(java.lang.String, org.json.JSONObject):void, file: classes39.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 1174
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.a.c(java.lang.String, org.json.JSONObject):void");
    }

    public static void d(HashMap<String, Float> r110, JSONObject r111, String r112) {
        String r113 = "npth_anr_".concat(r112);
        if (r110.isEmpty() == false) goto L5;
        String r114 = r113 + "_total";
        String r115 = "not found";
    L38:
        r111.put(r114, r115);
        return;
    L5:
        Iterator<Map.Entry<String, Float>> r116 = r110.entrySet().iterator();
        float r100 = 0.0f;
        float r101 = 0.0f;
        float r102 = 0.0f;
        float r103 = 0.0f;
        float r104 = 0.0f;
    L7:
        if (r116.hasNext() == false) goto L23;
        Map.Entry<String, Float> r105 = r116.next();
        String r106 = r105.getKey();
        if (r106.endsWith("user") == true) goto L10;
        if (r106.endsWith("kernel") == true) goto L13;
        if (r106.endsWith("iowait") == true) goto L16;
        if (r106.endsWith("irq") == true) goto L19;
        if (r106.endsWith("softirq") == false) goto L7;
        r104 = r104 + r105.getValue().floatValue();
        goto L7
    L19:
        r103 = r103 + r105.getValue().floatValue();
        goto L7
    L16:
        r102 = r102 + r105.getValue().floatValue();
        goto L7
    L13:
        r101 = r101 + r105.getValue().floatValue();
        goto L7
    L10:
        r100 = r100 + r105.getValue().floatValue();
        goto L7
    L23:
        float r107 = (((r100 + r101) + r102) + r103) + r104;
        r111.put(r113 + "_total", a(r107 / 100.0f));
        String r117 = r113 + "_kernel_user_ratio";
        String r108 = "100%";
        if (r107 <= 0.0f) goto L27;
        String r109 = a(r101 / r107);
    L30:
        r111.put(r117, r109);
        r114 = r113 + "_iowait_user_ratio";
        if (r107 <= 0.0f) goto L34;
        r115 = a(r102 / r107);
        goto L38
    L34:
        if (r102 > 0.0f) goto L37;
        r108 = "0%";
    L37:
        r115 = r108;
        goto L38
    L27:
        if (r101 <= 0.0f) goto L29;
        r109 = "100%";
        goto L30
    L29:
        r109 = "0%";
        goto L30
    }
}
