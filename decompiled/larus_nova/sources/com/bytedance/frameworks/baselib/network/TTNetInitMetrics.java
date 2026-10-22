package com.bytedance.frameworks.baselib.network;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class TTNetInitMetrics {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final String f244600c0 = null;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static volatile CopyOnWriteArrayList<a> f244601d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final AtomicBoolean f244602e0 = null;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static volatile TTNetInitMetrics f244603f0;
    public long A;
    public long B;
    public long C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f244604J;
    public long K;
    public String L;
    public long M;
    public long N;
    public long O;
    public long P;
    public long Q;
    public long R;
    public long S;
    public long T;
    public long U;
    public long V;
    public long W;
    public long X;
    public long Y;
    public long Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CronetInitMode f244605a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public long f244606a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f244607b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public long f244608b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f244609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f244610d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f244611e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f244612f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f244613g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f244614h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f244615i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f244616j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f244617k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f244618l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f244619m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f244620n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f244621o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f244622p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f244623q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f244624r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f244625s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f244626t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f244627u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f244628v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f244629w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f244630x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f244631y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f244632z;

    public static final enum CronetInitMode extends Enum<CronetInitMode> {
        public static final CronetInitMode BIZ_HTTPDNS_API = null;
        public static final CronetInitMode COOKIE_INIT_COMPLETE_API = null;
        public static final CronetInitMode DEPRECATED_API = null;
        public static final CronetInitMode FORCE_INIT = null;
        public static final CronetInitMode LAZY_INIT = null;
        public static final CronetInitMode NONE = null;
        public static final CronetInitMode PRE_INIT = null;
        public static final CronetInitMode ZSTD_API = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CronetInitMode[] f244633a = null;
        final int initMode;

        static {
            CronetInitMode r100 = new CronetInitMode(UserProfileEvent.POSITION_NONE, 0, 0);
            NONE = r100;
            CronetInitMode r101 = new CronetInitMode("LAZY_INIT", 1, 1);
            LAZY_INIT = r101;
            CronetInitMode r102 = new CronetInitMode("PRE_INIT", 2, 2);
            PRE_INIT = r102;
            CronetInitMode r103 = new CronetInitMode("FORCE_INIT", 3, 3);
            FORCE_INIT = r103;
            CronetInitMode r104 = new CronetInitMode("DEPRECATED_API", 4, 4);
            DEPRECATED_API = r104;
            CronetInitMode r105 = new CronetInitMode("BIZ_HTTPDNS_API", 5, 5);
            BIZ_HTTPDNS_API = r105;
            CronetInitMode r110 = new CronetInitMode("ZSTD_API", 6, 6);
            ZSTD_API = r110;
            CronetInitMode r111 = new CronetInitMode("COOKIE_INIT_COMPLETE_API", 7, 7);
            COOKIE_INIT_COMPLETE_API = r111;
            f244633a = new CronetInitMode[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static CronetInitMode[] values() {
            return (CronetInitMode[]) f244633a.clone();
        }

        public static CronetInitMode valueOf(String r100) {
            return (CronetInitMode) r27.a.a(CronetInitMode.class, r100);
        }

        public CronetInitMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.initMode = r102;
        }
    }

    /* JADX INFO: loaded from: classes19.dex */
    public interface a {
        void a();
    }

    static {
        f244600c0 = TTNetInitMetrics.class.getSimpleName();
        f244601d0 = new CopyOnWriteArrayList();
        f244602e0 = new AtomicBoolean(false);
    }

    public static TTNetInitMetrics g() {
        if (f244603f0 != null) goto L15;
        monitor-enter(TTNetInitMetrics.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f244603f0 != null) goto L9;
        f244603f0 = new TTNetInitMetrics();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTNetInitMetrics.class);     // Catch: Throwable -> L11
    L15:
        return f244603f0;
    }

    public static boolean h() {
        return f244602e0.get();
    }

    public final JSONObject b() {
        JSONObject r100 = new JSONObject();
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        r100.put("mode", this.f244605a.initMode);     // Catch: JSONException -> L13
        r100.put(LocationMonitorConst.IS_MAIN_PROCESS, this.f244607b);     // Catch: JSONException -> L13
        r100.put("net_thread_priority", this.f244609c);     // Catch: JSONException -> L13
        r101.put("ttnet_start", this.f244610d);     // Catch: JSONException -> L13
        r101.put("ttnet_end", (this.f244610d + this.f244614h) - this.f244611e);     // Catch: JSONException -> L13
        r101.put("engine_start", (this.f244610d + this.f244620n) - this.f244611e);     // Catch: JSONException -> L13
        r101.put("engine_end", (this.f244610d + this.E) - this.f244611e);     // Catch: JSONException -> L13
        r101.put("init_start", (this.f244610d + this.F) - this.f244611e);     // Catch: JSONException -> L13
        r101.put("init_end", (this.f244610d + this.G) - this.f244611e);     // Catch: JSONException -> L13
        r101.put("preconnect_start", this.M);     // Catch: JSONException -> L13
        r102.put("builder_build", d(this.A, this.B));     // Catch: JSONException -> L13
        r102.put("load_cronet", d(this.H, this.I));     // Catch: JSONException -> L13
        r102.put("init_metasec", d(this.f244612f, this.f244613g));     // Catch: JSONException -> L13
        r102.put("init_ttnet", d(this.f244611e, this.f244614h));     // Catch: JSONException -> L13
        r102.put("init_mssdk", d(this.C, this.D));     // Catch: JSONException -> L13
        r102.put("create_engine", d(this.f244620n, this.E));     // Catch: JSONException -> L13
        r102.put("init_thread", d(this.F, this.G));     // Catch: JSONException -> L13
        r102.put("init_total", d(Math.min(this.f244610d, this.f244619m) * 1000000, this.O * 1000000));     // Catch: JSONException -> L13
        r102.put("init_preconnect", d(this.f244610d, this.M));     // Catch: JSONException -> L13
        long r103 = this.N;     // Catch: JSONException -> L13
        long r104 = this.O;     // Catch: JSONException -> L13
        long r105 = -1;
        if (r103 <= r104) goto L6;
        long r106 = -1;
    L7:
        r102.put("network_thread", r106);     // Catch: JSONException -> L13
        long r107 = this.O;     // Catch: JSONException -> L13
        long r108 = this.P;     // Catch: JSONException -> L13
        if (r107 > r108) goto L11;
        r105 = r108 - r107;     // Catch: JSONException -> L13
    L11:
        r102.put("exec_tasks", r105);     // Catch: JSONException -> L13
        r102.put("nqe_init", this.Q);     // Catch: JSONException -> L13
        r102.put("prefs_init", this.R);     // Catch: JSONException -> L13
        r102.put("channel_init", this.S);     // Catch: JSONException -> L13
        r102.put("context_build", this.T);     // Catch: JSONException -> L13
        r102.put(MultiProcessFileUtils.KEY_TNC_CONFIG, this.U);     // Catch: JSONException -> L13
        r102.put("update_appinfo", this.V);     // Catch: JSONException -> L13
        r102.put("netlog_init", this.W);     // Catch: JSONException -> L13
        r102.put("nqe_detect", this.X);     // Catch: JSONException -> L13
        r102.put("preconnect", this.Y);     // Catch: JSONException -> L13
        r102.put("ssl_session", this.Z);     // Catch: JSONException -> L13
        r102.put("ttnet_config", this.f244606a0);     // Catch: JSONException -> L13
        r102.put("install_cert", this.f244608b0);     // Catch: JSONException -> L13
        r100.put("ttnet_timestamp", r101);     // Catch: JSONException -> L13
        r100.put("ttnet_duration", r102);     // Catch: JSONException -> L13
        r100.put(BaseHttpRequestInfo.KEY_ABTEST, this.L);     // Catch: JSONException -> L13
        goto L15
    L6:
        r106 = r104 - r103;     // Catch: JSONException -> L13
    L15:
        if (Logger.debug() == false) goto L17;
        Logger.d(f244600c0, "cronet init metrics json: " + r100.toString());
    L17:
        return r100;
    }

    public TTNetInitMetrics() {
        this.f244605a = CronetInitMode.NONE;
        this.f244607b = true;
        this.f244610d = 0;
        this.f244611e = 0;
        this.f244612f = 0;
        this.f244613g = 0;
        this.f244614h = 0;
        this.f244615i = 0;
        this.f244616j = 0;
        this.f244617k = 0;
        this.f244618l = 0;
        this.f244619m = 0;
        this.f244620n = 0;
        this.f244621o = 0;
        this.f244622p = 0;
        this.f244623q = 0;
        this.f244624r = 0;
        this.f244625s = 0;
        this.f244626t = 0;
        this.f244627u = 0;
        this.f244628v = 0;
        this.f244629w = 0;
        this.f244630x = 0;
        this.f244631y = 0;
        this.f244632z = 0;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.K = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.f244606a0 = 0;
        this.f244608b0 = 0;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public final JSONObject c(long r110) {
        JSONObject r100 = new JSONObject();
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L8
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L8
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L8
        r103.put("mssdk", e(this.C, this.D));     // Catch: Exception -> L8
        r103.put("app_info_subset", e(this.f244623q, this.f244624r));     // Catch: Exception -> L8
        r103.put("thread_config_list", e(this.f244625s, this.f244626t));     // Catch: Exception -> L8
        r103.put("sla_samp_setting", e(this.f244629w, this.f244630x));     // Catch: Exception -> L8
        r103.put("build_ctx_config", e(this.f244631y, this.f244632z));     // Catch: Exception -> L8
        r103.put("init_total", e(Math.min(this.f244610d, this.f244619m) * 1000000, this.O * 1000000));     // Catch: Exception -> L8
        String r104 = "-1";
        if (r110 == (-1)) goto L6;
        r104 = e(r110, this.f244611e);     // Catch: Exception -> L8
    L6:
        r103.put("app_init_time", r104);     // Catch: Exception -> L8
        r102.put("cross_plfm", r103);     // Catch: Exception -> L8
        JSONObject r111 = new JSONObject();     // Catch: Exception -> L8
        r111.put("ttnet_init", e(this.f244611e, this.f244614h));     // Catch: Exception -> L8
        r111.put("init_stack_config", e(this.f244617k, this.f244618l));     // Catch: Exception -> L8
        r111.put("get_stack_config", e(this.f244621o, this.f244622p));     // Catch: Exception -> L8
        r111.put("init_cookie_mgr", e(this.f244615i, this.f244616j));     // Catch: Exception -> L8
        r111.put("pre_init_mssdk", e(this.f244612f, this.f244613g));     // Catch: Exception -> L8
        r111.put("builder_build", e(this.A, this.B));     // Catch: Exception -> L8
        r111.put("create_engine", e(this.f244620n, this.E));     // Catch: Exception -> L8
        r111.put("cronet_init_thread", e(this.F, this.G));     // Catch: Exception -> L8
        r111.put("cronet_load_so", e(this.H, this.I));     // Catch: Exception -> L8
        r111.put("thread_config_callback", e(this.f244627u, this.f244628v));     // Catch: Exception -> L8
        r102.put("android_spec", r111);     // Catch: Exception -> L8
        r101.put("durations_us", r102);     // Catch: Exception -> L8
        r101.put("cronet_init_mode", this.f244605a.initMode);     // Catch: Exception -> L8
        r100.put("ttnet_layer", r101);     // Catch: Exception -> L8
        r100.put("cronet_layer", new JSONObject(this.f244604J));     // Catch: Exception -> L8
        r100.put(BaseHttpRequestInfo.KEY_ABTEST, this.L);     // Catch: Exception -> L8
    L10:
        return r100;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public static long d(long r100, long r101) {
        if (r100 != 0) goto L5;
    L11:
        long r102 = -1;
    L13:
        if (r102 != (-1)) goto L16;
        return -1;
    L16:
        return r102 / 1000;
    L5:
        if (r101 == 0) goto L11;
        if (r100 > r101) goto L11;
        r102 = (r101 - r100) / 1000;
        goto L13
    }

    public static String e(long r100, long r101) {
        long r102 = -1;
        if (r100 == 0) goto L12;
        if (r101 == 0) goto L12;
        if (r100 > r101) goto L12;
        r102 = (r101 - r100) / 1000;
    L12:
        return String.valueOf(r102);
    }

    public static boolean i(Context r100, List r101) {
        HashMap r102 = null;
        Class r103 = a("com.bytedance.mobsec.metasec.ml.MSB");     // Catch: ClassNotFoundException -> L5
    L6:
        if (r103 != null) goto L11;
        r103 = a("com.bytedance.mobsec.metasec.ov.MSB");     // Catch: ClassNotFoundException -> L9
    L11:
        if (r103 != null) goto L14;
        return false;
    L14:
        if (r101 != null) goto L27;
    L18:
        r103.getMethod(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, new Class[]{Context.class, Integer.TYPE, Map.class}).invoke(r103, new Object[]{r100, 1, r102});     // Catch: Throwable -> L20
        return true;
    L20:
        th = move-exception;
        th.printStackTrace();
        return false;
    L27:
        if (r101.size() != 2) goto L18;
        r102 = new HashMap();     // Catch: Throwable -> L20
        r102.put("http_callback", String.valueOf(ListProtector.get(r101, 0)));     // Catch: Throwable -> L20
        r102.put("ws_callback", String.valueOf(ListProtector.get(r101, 1)));     // Catch: Throwable -> L20
    L5:
        r103 = null;
        goto L6
    }

    public final void f(Context r100, List<Long> r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.size() != 2) goto L17;
        boolean r102 = Logger.debug();
        String r103 = f244600c0;
        if (r102 == false) goto L9;
        Logger.d(r103, "http address: " + ListProtector.get(r101, 0) + " ws address: " + ListProtector.get(r101, 1));
    L9:
        this.C = System.nanoTime();
        if (i(r100, r101) == false) goto L12;
    L14:
        this.D = System.nanoTime();
        return;
    L12:
        if (Logger.debug() == false) goto L14;
        Logger.d(r103, "init mssdk failed.");
        goto L14
    }
}
