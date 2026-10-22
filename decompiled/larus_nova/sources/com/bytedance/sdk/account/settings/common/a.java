package com.bytedance.sdk.account.settings.common;

import android.text.TextUtils;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.sdk.account.impl.z;
import com.bytedance.sdk.account.utils.m;
import com.bytedance.sdk.account.utils.n;
import com.ss.android.account.k;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.json.JSONArray;
import org.json.JSONObject;
import wqa.f;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static boolean A;
    public static boolean B;
    public static long C;
    public static long D;
    public static boolean E;
    public static boolean F;
    public static long G;
    public static boolean H;
    public static mc7.a I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static boolean f269373J;
    public static int K;
    public static int L;
    public static boolean M;
    public static String N;
    public static boolean O;
    public static boolean P;
    public static boolean Q;
    public static String R;
    public static boolean S;
    public static int T;
    public static boolean U;
    public static boolean V;
    public static boolean W;
    public static boolean X;
    public static boolean Y;
    public static boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JSONObject f269374a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static boolean f269375a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static JSONObject f269376b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static long f269377b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f269378c = null;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static int f269379c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f269380d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final m f269381e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final m f269382f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final m f269383g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final m f269384h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final m f269385i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final m f269386j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final m f269387k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final m f269388l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final m f269389m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f269390n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static boolean f269391o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f269392p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static boolean f269393q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f269394r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f269395s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f269396t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f269397u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f269398v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static boolean f269399w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f269400x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static int f269401y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static boolean f269402z;

    static {
        f269378c = new m(null, null, true);
        f269380d = new m(null, null, false);
        f269381e = new m(null, null, true);
        f269382f = new m(null, null, true);
        f269383g = new m(null, null, false);
        f269384h = new m(null, null, true);
        f269385i = new m(null, null, true);
        f269386j = new m(null, null, false);
        f269387k = new m(null, null, true);
        f269388l = new m(null, null, true);
        f269389m = new m(null, null, true);
        f269390n = false;
        f269391o = false;
        f269392p = false;
        f269393q = false;
        f269394r = false;
        f269395s = false;
        f269396t = true;
        f269397u = false;
        f269398v = false;
        f269399w = true;
        f269400x = false;
        f269401y = 1;
        f269402z = false;
        A = false;
        B = false;
        C = 1800;
        D = 86400;
        E = true;
        F = true;
        G = 5000;
        H = true;
        mc7.a.f513237h.getClass();
        I = new mc7.a(false, new LinkedHashSet(), new LinkedHashSet(), false, new LinkedHashSet(), "", false);
        f269373J = true;
        K = 0;
        L = 60000;
        M = false;
        N = null;
        O = true;
        P = false;
        Q = false;
        R = "--,.";
        S = false;
        T = 1;
        U = false;
        V = false;
        W = true;
        X = true;
        Y = true;
        Z = false;
        f269375a0 = true;
        f269377b0 = 0;
        f269379c0 = 0;
    }

    public static JSONObject b() {
        f r100 = k.f406318b;
        if (r100 != null) goto L5;
        return null;
    L5:
        JSONObject r101 = z.a(r100.getApplicationContext()).getAccountSettingsConfig();
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.optJSONObject("common_config");
    }

    public static void a() {
        JSONObject r100 = b();
        if (f269374a == r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L67;
        f269374a = r100;
        tb7.a.a("CommonConfigManager", "common config settings = " + f269374a);
        JSONObject r102 = f269374a;
        if (r102 == null) goto L56;
        f269390n = r102.optBoolean("enable_passport_full_path_track", false);
        f269391o = f269374a.optBoolean("enable_net_request_monitor", false);
        f269378c.c(f269374a.optJSONArray("net_request_monitor_path"));
        f269380d.c(f269374a.optJSONArray("net_request_monitor_path_prefix"));
        f269381e.c(f269374a.optJSONArray("net_request_monitor_path_exclude"));
        f269392p = f269374a.optBoolean("enable_request_retry_interceptor", false);
        f269382f.c(f269374a.optJSONArray("request_retry_interceptor_path"));
        f269383g.c(f269374a.optJSONArray("request_retry_interceptor_path_prefix"));
        f269384h.c(f269374a.optJSONArray("request_retry_interceptor_path_exclude"));
        f269393q = f269374a.optBoolean("enable_request_retry_monitor", false);
        f269385i.c(f269374a.optJSONArray("request_retry_monitor_path"));
        f269386j.c(f269374a.optJSONArray("request_retry_monitor_path_prefix"));
        f269387k.c(f269374a.optJSONArray("request_retry_monitor_path_exclude"));
        f269394r = f269374a.optBoolean("user_mix_enable_same_token_check", false);
        f269395s = f269374a.optBoolean("user_mix_enable_info_reveal", false);
        f269396t = f269374a.optBoolean("user_mix_enable_reveal_condition_filter", true);
        f269397u = f269374a.optBoolean("user_mix_enable_stat_sync_reveal", false);
        f269398v = f269374a.optBoolean("bd_account_uid_str_replace", false);
        f269388l.c(f269374a.optJSONArray("user_mix_stat_sync_reveal_paths"));
        f269399w = f269374a.optBoolean("enable_group_one_login_opt", true);
        f269400x = f269374a.optBoolean("enable_group_one_login_pre_get_token", false);
        f269401y = f269374a.optInt("common_request_parse_user_info_decision", 1);
        f269402z = f269374a.optBoolean("enable_header_sessionid", false);
        A = f269374a.optBoolean("enable_third_party_bind_csrf_opt", false);
        JSONObject r103 = f269374a.optJSONObject("request_use_cellular_config");
        mc7.a.C6800a r110 = mc7.a.f513237h;
        if (r103 != null) goto L12;
        r110.getClass();
        mc7.a r104 = new mc7.a(false, new LinkedHashSet(), new LinkedHashSet(), false, new LinkedHashSet(), "", false);
    L55:
        I = r104;
        f269376b = f269374a.optJSONObject("error_code_transfer");
        H = f269374a.optBoolean("enable_account_badger", true);
        f269373J = f269374a.optBoolean("enable_xaccount_inject_network_service", true);
        K = f269374a.optInt("device_transfer_logout_strategy", 0);
        L = f269374a.optInt("token_beat_wait_init_timeout", 60000);
        M = f269374a.optBoolean("header_mix_monitor", false);
        N = f269374a.optString("header_mix_monitor_match_template", null);
        O = f269374a.optBoolean("enable_ticket_guard_network_delegate", true);
        P = f269374a.optBoolean("enable_supplement_header_backup", false);
        Q = f269374a.optBoolean("header_mix_monitor_token", false);
        R = f269374a.optString("header_mix_monitor_token_match_rule", "--,.");
        T = f269374a.optInt("save_platform_info_opt", 1);
        U = f269374a.optBoolean("token_standardize_enable_encryption", false);
        V = f269374a.optBoolean("token_standardize_close_plain_text", false);
        f269374a.optLong("token_validity_period", 432000);
        B = f269374a.optBoolean("enable_identity_token", false);
        C = f269374a.optLong("identity_token_refresh_interval", 1800);
        D = f269374a.optLong("identity_token_expire_time", 86400);
        S = f269374a.optBoolean("enable_twice_verify_remove_header", false);
        Y = f269374a.optBoolean("identity_token_enable_foreground_check", true);
        f269389m.c(f269374a.optJSONArray("expect_identity_token_paths"));
        E = f269374a.optBoolean("identity_token_enable_boot_refresh", true);
        F = f269374a.optBoolean("identity_token_get_force_tag_on_cache_preload", true);
        G = f269374a.optLong("identity_token_foreground_check_min_interval_from_app_start_ms", 5000);
        W = f269374a.optBoolean("enable_account_interceptor_light_mode", true);
        X = f269374a.optBoolean("enable_account_interceptor_log_optimize", true);
        Z = f269374a.optBoolean("enable_interceptor_merge_save_opt", false);
        f269375a0 = f269374a.optBoolean("enable_twice_verify_life_cycle_observer_opt", true);
        f269377b0 = f269374a.optLong("delay_check_token_sp_timeout", 0);
        f269379c0 = f269374a.optInt("auth_token_provider_write_opt", 0);
        return;
    L12:
        r110.getClass();
        boolean r111 = r103.optBoolean("enable", false);
        LinkedHashSet r112 = new LinkedHashSet();
        JSONArray r113 = r103.optJSONArray(Constants.OperatorKey.KEY_CARRIER);
        if (r113 != null) goto L15;
    L22:
        LinkedHashSet r105 = new LinkedHashSet();
        JSONArray r106 = r103.optJSONArray("path");
        if (r106 != null) goto L25;
    L32:
        r105.add("/passport/auth/one_login/");
        r105.add("/passport/auth/one_login_only/");
        r105.add("/passport/auth/validate_mobile_login/");
        r105.add("/passport/mobile/bind_login/");
        r105.add("/passport/auth/one_login_with_mask_mobile/");
        r105.add("/passport/complex_env/one_login/");
        if (r111 == true) goto L35;
    L37:
        boolean r114 = false;
    L38:
        LinkedHashSet r107 = new LinkedHashSet();
        JSONArray r108 = r103.optJSONArray("ipv4_opt_carrier");
        if (r108 != null) goto L41;
    L48:
        String r210 = r103.optString("ipv4_host", "");
        if (r111 == true) goto L51;
    L53:
        boolean r211 = false;
    L54:
        r104 = new mc7.a(r111, r112, r105, r114, r107, r210, r211);
        goto L55
    L51:
        if (r103.optBoolean("enable_alternative_net_opt", false) == false) goto L53;
        r211 = true;
        goto L54
    L41:
        if (r108.length() <= 0) goto L48;
        int r109 = r108.length();
        int r115 = 0;
    L43:
        if (r115 >= r109) goto L48;
        String r116 = r108.optString(r115);
        if (n.a(r116) == false) goto L47;
        r107.add(r116);
    L47:
        r115 = r115 + 1;
        goto L43
    L35:
        if (r103.optBoolean("enable_ipv4_opt", false) == false) goto L37;
        r114 = true;
        goto L38
    L25:
        if (r106.length() <= 0) goto L32;
        int r117 = r106.length();
        int r118 = 0;
    L27:
        if (r118 >= r117) goto L32;
        String r119 = r106.optString(r118);
        if (n.a(r119) == false) goto L31;
        r105.add(r119);
    L31:
        r118 = r118 + 1;
        goto L27
    L15:
        if (r113.length() <= 0) goto L22;
        int r120 = r113.length();
        int r121 = 0;
    L17:
        if (r121 >= r120) goto L22;
        String r122 = r113.optString(r121);
        if (n.a(r122) == false) goto L21;
        r112.add(r122);
    L21:
        r121 = r121 + 1;
        goto L17
    L56:
        f269390n = false;
        f269391o = false;
        f269378c.c(null);
        f269380d.c(null);
        f269381e.c(null);
        f269392p = false;
        f269382f.c(null);
        f269383g.c(null);
        f269384h.c(null);
        f269393q = false;
        f269385i.c(null);
        f269386j.c(null);
        f269387k.c(null);
        f269394r = false;
        f269395s = false;
        f269396t = true;
        f269397u = false;
        f269398v = false;
        f269388l.c(null);
        f269399w = true;
        f269400x = false;
        f269401y = 1;
        f269402z = false;
        A = false;
        mc7.a.f513237h.getClass();
        I = new mc7.a(false, new LinkedHashSet(), new LinkedHashSet(), false, new LinkedHashSet(), "", false);
        H = true;
        f269376b = null;
        f269373J = true;
        K = 0;
        L = 60000;
        M = false;
        N = null;
        O = true;
        P = false;
        Q = false;
        R = "--,.";
        T = 1;
        U = false;
        V = false;
        B = false;
        C = 1800;
        D = 86400;
        S = false;
        Y = true;
        f269389m.c(null);
        E = true;
        F = true;
        G = 5000;
        W = true;
        X = true;
        Z = false;
        f269375a0 = true;
        f269377b0 = 0;
        f269379c0 = 0;
        return;
    L67:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static boolean c(String r100, m r101, m r102, m r103) {
        if (r103 == null) goto L8;
        if (r103.f269551c.contains(r100) == false) goto L8;
        return false;
    L8:
        if (r101 != null) goto L10;
    L12:
        if (r102 == null) goto L21;
        Iterator<String> r104 = r102.f269551c.iterator();
    L15:
        if (r104.hasNext() == false) goto L21;
        String r105 = r104.next();
        if (TextUtils.isEmpty(r100) == true) goto L15;
        if (r100.startsWith(r105) == false) goto L15;
        return true;
    L21:
        return false;
    L10:
        if (r101.f269551c.contains(r100) == false) goto L12;
        return true;
    }
}
