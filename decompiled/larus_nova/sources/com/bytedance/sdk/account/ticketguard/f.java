package com.bytedance.sdk.account.ticketguard;

import com.bytedance.sdk.account.impl.z;
import com.bytedance.sdk.account.time.RealTimeManager;
import com.bytedance.sdk.account.utils.i;
import com.bytedance.sdk.account.utils.m;
import com.ss.android.account.k;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static final m A = null;
    public static final m B = null;
    public static final m C = null;
    public static final m D = null;
    public static final m E = null;
    public static final m F = null;
    public static final m G = null;
    public static boolean H;
    public static final m I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final m f269444J = null;
    public static final m K = null;
    public static final m L = null;
    public static final m M = null;
    public static final m N = null;
    public static final m O = null;
    public static final m P = null;
    public static final m Q = null;
    public static boolean R;
    public static boolean S;
    public static final g T = null;
    public static volatile g U;
    public static final com.bytedance.sdk.account.time.c V = null;
    public static final m W = null;
    public static final m X = null;
    public static final m Y = null;
    public static final m Z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JSONObject f269445a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final a f269446a0 = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f269447b = null;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static boolean f269448b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f269449c = null;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static long f269450c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f269451d = null;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static long f269452d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final m f269453e = null;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final m f269454e0 = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final m f269455f = null;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final m f269456f0 = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f269457g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final m f269458g0 = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile boolean f269459h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final m f269460h0 = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile boolean f269461i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static boolean f269462i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f269463j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static boolean f269464j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f269465k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f269466l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile boolean f269467m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static int f269468n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static boolean f269469o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f269470p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static long f269471q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f269472r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static long f269473s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static long f269474t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f269475u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f269476v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static long f269477w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f269478x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static boolean f269479y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static boolean f269480z;

    public static class a extends i<Boolean> {
        @Override // com.bytedance.sdk.account.utils.i
        public final Boolean b() {
            f.a();
            JSONObject r100 = f.f269445a;
            if (r100 == null) goto L6;
            return Boolean.valueOf(r100.optBoolean("enable_sec_ts_pre_request", false));
        L6:
            return Boolean.FALSE;
        }

        public a() {
        }
    }

    static {
        f269447b = new m(new HashSet(), null, true);
        f269449c = new m(new HashSet(Arrays.asList(new String[]{"/passport/"})), null, false);
        f269451d = new m(new HashSet(), null, true);
        f269453e = new m(new HashSet(), null, false);
        f269455f = new m(new HashSet(Arrays.asList(new String[]{"/passport/"})), null, false);
        f269457g = "<default>";
        f269459h = false;
        f269461i = f269459h;
        f269463j = false;
        f269465k = false;
        f269466l = false;
        f269467m = false;
        f269468n = 1000;
        f269469o = false;
        f269470p = true;
        f269471q = 540;
        f269472r = true;
        f269473s = -1;
        f269474t = 30;
        f269475u = false;
        f269476v = true;
        f269477w = 1800;
        f269478x = false;
        f269479y = false;
        f269480z = true;
        HashSet r100 = new HashSet(Arrays.asList(new String[]{"/passport/account/info/v2/", "/passport/token/beat/v2/"}));
        A = new m(r100, null, true);
        B = new m(null, null, false);
        C = new m(null, null, true);
        D = new m(null, null, false);
        E = new m(null, null, true);
        F = new m(null, null, true);
        G = new m(null, null, false);
        H = false;
        I = new m(r100, null, true);
        f269444J = new m(null, null, false);
        K = new m(null, null, true);
        L = new m(null, null, false);
        M = new m(r100, null, true);
        N = new m(null, null, false);
        O = new m(null, null, true);
        P = new m(null, null, false);
        Q = new m(new HashSet(Arrays.asList(new String[]{"/passport/token/beat/v2/"})), null, true);
        R = false;
        S = false;
        g r101 = new g();
        T = r101;
        U = r101;
        V = new com.bytedance.sdk.account.time.c();
        W = new m(r100, null, true);
        X = new m(null, null, false);
        Y = new m(null, null, true);
        Z = new m(null, null, false);
        f269446a0 = new a();
        f269448b0 = false;
        f269450c0 = 600;
        f269452d0 = 86400;
        f269454e0 = new m(null, null, true);
        f269456f0 = new m(null, null, false);
        f269458g0 = new m(null, null, true);
        f269460h0 = new m(null, null, false);
        f269462i0 = false;
        f269464j0 = false;
    }

    /* JADX WARN: Type inference failed for: r5v68, types: [com.bytedance.sdk.account.ticketguard.TokenInitOptConfig$Companion$parseFromJson$1] */
    public static boolean a() {
        wqa.f r100 = k.f406318b;
        if (r100 == null) goto L8;
        JSONObject r101 = ((z) z.a(r100.getApplicationContext())).getAccountSettingsConfig();
        if (r101 == null) goto L8;
        JSONObject r102 = r101.optJSONObject("token_guard_config");
    L10:
        if (f269445a == r102) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L59;
        f269445a = r102;
        tb7.a.a("TokenGuardSettingManage", "settings=" + f269445a);
        JSONObject r104 = f269445a;
        boolean r110 = r103;
        if (r104 == null) goto L57;
        f269457g = r104.optString("config_version", "<no version>");
        A.c(f269445a.optJSONArray("token_guard_paths"));
        B.c(f269445a.optJSONArray("token_guard_path_prefix"));
        C.c(f269445a.optJSONArray("exclude_token_guard_paths"));
        D.c(f269445a.optJSONArray("exclude_token_guard_path_prefix"));
        f269461i = f269445a.optBoolean("enable_token_guard", f269459h);
        E.c(f269445a.optJSONArray("exclude_get_token_domains"));
        F.c(f269445a.optJSONArray("exclude_get_token_paths"));
        G.c(f269445a.optJSONArray("exclude_get_token_prefix"));
        f269463j = f269445a.optBoolean("enable_full_path_track", false);
        f269465k = f269445a.optBoolean("enable_token_launch", false);
        f269466l = f269445a.optBoolean("enable_waiting_init", false);
        f269468n = f269445a.optInt("waiting_timeout", 1000);
        f269467m = f269445a.optBoolean("enable_temp_fallback_config", false);
        H = f269445a.optBoolean("use_tee_ree_config", false);
        I.c(f269445a.optJSONArray("tee_token_guard_paths"));
        f269444J.c(f269445a.optJSONArray("tee_token_guard_path_prefix"));
        K.c(f269445a.optJSONArray("tee_exclude_token_guard_paths"));
        L.c(f269445a.optJSONArray("tee_exclude_token_guard_path_prefix"));
        M.c(f269445a.optJSONArray("ree_token_guard_paths"));
        N.c(f269445a.optJSONArray("ree_token_guard_path_prefix"));
        O.c(f269445a.optJSONArray("ree_exclude_token_guard_paths"));
        P.c(f269445a.optJSONArray("ree_exclude_token_guard_path_prefix"));
        R = f269445a.optBoolean("enable_symmetric_encryption", false);
        W.c(f269445a.optJSONArray("symmetric_encryption_path"));
        X.c(f269445a.optJSONArray("symmetric_encryption_prefix_path"));
        Y.c(f269445a.optJSONArray("symmetric_encryption_exclude_path"));
        Z.c(f269445a.optJSONArray("symmetric_encryption_exclude_prefix_path"));
        S = f269445a.optBoolean("ree_hmac_use_standardized_algorithm", false);
        f269469o = f269445a.optBoolean("token_guard_get_time_with_hibernate_detection", false);
        f269470p = f269445a.optBoolean("enable_ts_sign_compensate_fix", true);
        final JSONObject r105 = f269445a.optJSONObject("token_guard_init_opt_config");
        g r106 = T;
        if (r105 == null) goto L56;
        ?? r107 = new TokenInitOptConfig$Companion$parseFromJson$1(r105);
        boolean r111 = r107.invoke("enable", true);
        if (r111 == true) goto L22;
    L24:
        boolean r112 = false;
    L25:
        if (r111 == true) goto L27;
    L29:
        boolean r210 = false;
    L30:
        if (r111 == true) goto L32;
    L34:
        boolean r211 = false;
    L35:
        if (r111 == true) goto L37;
    L39:
        boolean r212 = false;
    L40:
        if (r111 == true) goto L42;
    L44:
        boolean r213 = false;
    L45:
        if (r111 == true) goto L47;
    L49:
        boolean r214 = false;
    L50:
        if (r111 == true) goto L52;
    L54:
        boolean r215 = false;
    L55:
        r106 = new g(r111, r112, r210, r211, r212, r213, r214, r215);
        goto L56
    L52:
        if (r107.invoke("enable_hmac_cache", true) == false) goto L54;
        r215 = true;
        goto L55
    L47:
        if (r107.invoke("enable_new_init_callback", true) == false) goto L49;
        r214 = true;
        goto L50
    L42:
        if (r107.invoke("enable_ticket_init_refactor", true) == false) goto L44;
        r213 = true;
        goto L45
    L37:
        if (r107.invoke("enable_tee_ree_parallel", true) == false) goto L39;
        r212 = true;
        goto L40
    L32:
        if (r107.invoke("enable_pre_init_in_account_init", true) == false) goto L34;
        r211 = true;
        goto L35
    L27:
        if (r107.invoke("enable_high_thread_priority", true) == false) goto L29;
        r210 = true;
        goto L30
    L22:
        if (r107.invoke("enable_service_pre_init", true) == false) goto L24;
        r112 = true;
    L56:
        U = r106;
        f269475u = f269445a.optBoolean("enable_attest_sign", false);
        f269447b.c(f269445a.optJSONArray("attest_sign_path"));
        f269449c.c(f269445a.optJSONArray("attest_sign_path_prefix"));
        f269451d.c(f269445a.optJSONArray("attest_sign_exclude_path"));
        f269453e.c(f269445a.optJSONArray("attest_sign_exclude_path_prefix"));
        f269477w = f269445a.optLong("sec_time_refresh_window", 1800);
        f269471q = f269445a.optLong("attest_sign_min_refresh_interval", 540);
        f269472r = f269445a.optBoolean("enable_sec_time_timestamp", true);
        f269473s = f269445a.optLong("token_guard_get_time_periodic_execute_interval_seconds", -1);
        f269474t = f269445a.optLong("sec_time_request_min_interval", 30);
        f269455f.c(f269445a.optJSONArray("enable_tee_pub_key_header_path_prefix"));
        f269476v = f269445a.optBoolean("enable_attest_ts_sign_check_on_sec_ts_update", true);
        f269448b0 = f269445a.optBoolean("enable_tee_static_sign", false);
        f269450c0 = f269445a.optLong("static_sign_refresh_threshold_seconds", 600);
        f269452d0 = f269445a.optLong("static_sign_expire_time_seconds", 86400);
        f269454e0.c(f269445a.optJSONArray("tee_static_sign_paths"));
        f269456f0.c(f269445a.optJSONArray("tee_static_sign_path_prefix"));
        f269460h0.c(f269445a.optJSONArray("tee_static_sign_exclude_path_prefix"));
        f269458g0.c(f269445a.optJSONArray("tee_static_sign_exclude_paths"));
        f269462i0 = f269445a.optBoolean("tee_static_sign_feed_ready_opt", false);
        f269464j0 = f269445a.optBoolean("get_sec_ts_feed_ready_opt", false);
        f269445a.optBoolean("tee_static_sign_add_before_feed_ready", true);
        Q.c(f269445a.optJSONArray("request_tracking_paths"));
        f269478x = f269445a.optBoolean("request_tracking_ignore_anomalies", false);
        f269479y = f269445a.optBoolean("response_tracking_ignore_anomalies", false);
        f269480z = f269445a.optBoolean("enable_request_tracking", true);
        e(f269445a.optJSONObject("real_time_manager_config"));
        return r110;
    L57:
        f269457g = "<default>";
        A.c(null);
        B.c(null);
        C.c(null);
        D.c(null);
        f269461i = f269459h;
        E.c(null);
        F.c(null);
        G.c(null);
        f269463j = false;
        f269465k = false;
        f269466l = false;
        f269468n = 1000;
        f269467m = false;
        H = false;
        I.c(null);
        f269444J.c(null);
        K.c(null);
        L.c(null);
        M.c(null);
        N.c(null);
        O.c(null);
        P.c(null);
        R = false;
        W.c(null);
        X.c(null);
        Y.c(null);
        Z.c(null);
        S = false;
        f269469o = false;
        f269470p = true;
        U = T;
        f269475u = false;
        f269447b.c(null);
        f269449c.c(null);
        f269451d.c(null);
        f269453e.c(null);
        f269477w = 1800;
        f269471q = 540;
        f269472r = true;
        f269473s = -1;
        f269474t = 30;
        f269455f.c(null);
        f269476v = true;
        f269448b0 = false;
        f269450c0 = 600;
        f269452d0 = 86400;
        f269454e0.c(null);
        f269456f0.c(null);
        f269460h0.c(null);
        f269458g0.c(null);
        f269462i0 = false;
        f269464j0 = false;
        Q.c(null);
        f269478x = false;
        f269479y = false;
        f269480z = true;
        e(null);
        return r110;
    L59:
        return r103;
    L12:
        r103 = false;
    L8:
        r102 = null;
        goto L10
    }

    public static int b(String r100) {
        a();
        if (H == false) goto L9;
        boolean r101 = d(r100, I, f269444J, K, L);
        if (d(r100, M, N, O, P) == false) goto L7;
        boolean r102 = true;
    L12:
        if (r101 == false) goto L16;
        if (r102 == false) goto L16;
        return 3;
    L16:
        if (r101 == false) goto L18;
        return 1;
    L18:
        if (r102 == false) goto L21;
        return 2;
    L21:
        return 0;
    L7:
        r102 = false;
        goto L12
    L9:
        if (d(r100, A, B, C, D) == false) goto L11;
        r102 = true;
        r101 = true;
        goto L12
    L11:
        r102 = false;
        r101 = false;
        goto L12
    }

    public static boolean c(String r100) {
        a();
        if (f269448b0 == true) goto L7;
        return false;
    L7:
        return d(r100, f269454e0, f269456f0, f269458g0, f269460h0);
    }

    public static void e(JSONObject r100) {
        if (r100 != null) goto L4;
        com.bytedance.sdk.account.time.c r101 = V;
    L5:
        RealTimeManager r102 = RealTimeManager.c();
        tb7.a.d("RealTimeManager", "updateConfig, config description: " + r101.f269510a);
        r102.f269496e = r101;
        return;
    L4:
        r101 = com.bytedance.sdk.account.time.c.a(r100, V);
        goto L5
    }

    public static boolean d(String r100, m r101, m r102, m r103, m r104) {
        if (r103.f269551c.contains(r100) == false) goto L5;
        return false;
    L5:
        Iterator<String> r105 = r104.f269551c.iterator();
    L7:
        if (r105.hasNext() == false) goto L12;
        if (r100.startsWith(r105.next()) == false) goto L7;
        return false;
    L12:
        if (r101.f269551c.contains(r100) == false) goto L14;
        return true;
    L14:
        Iterator<String> r106 = r102.f269551c.iterator();
    L16:
        if (r106.hasNext() == false) goto L20;
        if (r100.startsWith(r106.next()) == false) goto L16;
        return true;
    L20:
        return false;
    }
}
