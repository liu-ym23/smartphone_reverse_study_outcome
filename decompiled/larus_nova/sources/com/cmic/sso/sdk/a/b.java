package com.cmic.sso.sdk.a;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.n;
import com.huawei.hms.framework.common.ContainerUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static b f273285c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.cmic.sso.sdk.a.a f273286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.cmic.sso.sdk.a.a f273287b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f273288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f273289e;

    public interface a {
        void a(com.cmic.sso.sdk.a.a r100);
    }

    private com.cmic.sso.sdk.a.a d() {
        return new com.cmic.sso.sdk.a.a.C3819a().a(d.b(this.f273287b.a())).c(d.a(this.f273287b.c())).b(d.b(this.f273287b.b())).d(d.c(this.f273287b.d())).d(d.a(this.f273287b.h())).e(d.b(this.f273287b.i())).a(d.e(this.f273287b.e())).b(d.d(this.f273287b.f())).c(d.c(this.f273287b.g())).f(d.f(this.f273287b.j())).a(d.a(this.f273287b.k())).b(d.b(this.f273287b.l())).a();
    }

    public void c() {
        k.a r100 = k.b("sso_config_xf");
        r100.c();
        r100.b();
    }

    public com.cmic.sso.sdk.a.a a() {
        return this.f273287b;
    }

    public com.cmic.sso.sdk.a.a b() {
        return this.f273286a;
    }

    private b(boolean r100) {
        this.f273288d = false;
        com.cmic.sso.sdk.a.a r101 = new com.cmic.sso.sdk.a.a.C3819a().a();
        this.f273287b = r101;
        if (r100 == true) goto L5;
        this.f273286a = d();
        return;
    L5:
        this.f273286a = r101;
    }

    private void a(JSONObject r110) {
        k.a r111 = k.b("sso_config_xf");
    L42:
        e = move-exception;
        com.cmic.sso.sdk.e.c.a("UmcConfigHandle", "配置项异常，配置失效");
        e.printStackTrace();
        return;
    L4:
        if (r110.has("client_valid") == false) goto L7;
        r111.a("client_valid", System.currentTimeMillis() + (((CastIntegerProtector.parseInt(JSONObjectProtectorUtils.getString(r110, "client_valid")) * 60) * 60) * 1000));     // Catch: Exception -> L42
    L7:
        if (r110.has("Configlist") == false) goto L40;
        JSONObject r100 = JSONObjectProtectorUtils.getJSONObject(r110, "Configlist");     // Catch: Exception -> L42
        if (r100.has("CHANGE_HOST") == false) goto L26;
        String r101 = JSONObjectProtectorUtils.getString(r100, "CHANGE_HOST");     // Catch: Exception -> L42
        if (r101.contains("M007") == false) goto L17;
        String r102 = a(r101, "M007");     // Catch: Exception -> L42
        if (TextUtils.isEmpty(r102) == true) goto L17;
        r111.a("logHost", r102);     // Catch: Exception -> L42
    L17:
        if (r101.contains("M008") == false) goto L22;
        String r103 = a(r101, "M008");     // Catch: Exception -> L42
        if (TextUtils.isEmpty(r103) == true) goto L22;
        r111.a("https_get_phone_scrip_host", r103);     // Catch: Exception -> L42
    L22:
        if (r101.contains("M009") == false) goto L27;
        String r104 = a(r101, "M009");     // Catch: Exception -> L42
        if (TextUtils.isEmpty(r104) == true) goto L27;
        r111.a("config_host", r104);     // Catch: Exception -> L42
    L27:
        a(r100, "CLOSE_FRIEND_WAPKS", "0", r111);     // Catch: Exception -> L42
        a(r100, "CLOSE_LOGS_VERSION", "0", r111);     // Catch: Exception -> L42
        a(r100, "CLOSE_IPV4_LIST", "0", r111);     // Catch: Exception -> L42
        a(r100, "CLOSE_IPV6_LIST", "0", r111);     // Catch: Exception -> L42
        a(r100, "CLOSE_M008_SDKVERSION_LIST", "0", r111);     // Catch: Exception -> L42
        a(r100, "CLOSE_M008_APPID_LIST", "0", r111);     // Catch: Exception -> L42
        if (r100.has("LOGS_CONTROL") == false) goto L39;
        String[] r105 = JSONObjectProtectorUtils.getString(r100, "LOGS_CONTROL").replace("h", "").split("&");     // Catch: Exception -> L42
        if (r105.length != 2) goto L40;
        if (TextUtils.isEmpty(r105[0]) == true) goto L40;
        if (TextUtils.isEmpty(r105[1]) == true) goto L40;
        int r106 = CastIntegerProtector.parseInt(r105[0]);     // Catch: Exception -> L38
        int r107 = CastIntegerProtector.parseInt(r105[1]);     // Catch: Exception -> L38
        r111.a("maxFailedLogTimes", r106);     // Catch: Exception -> L38
        r111.a("pauseTime", r107);     // Catch: Exception -> L38
    L38:
        com.cmic.sso.sdk.e.c.a("UmcConfigHandle", "解析日志上报限制时间次数异常");     // Catch: Exception -> L42
        goto L40
    L39:
        r111.a("maxFailedLogTimes");     // Catch: Exception -> L42
        r111.a("pauseTime");     // Catch: Exception -> L42
        goto L40
    L26:
        r111.a("logHost");     // Catch: Exception -> L42
        r111.a("https_get_phone_scrip_host");     // Catch: Exception -> L42
        r111.a("config_host");     // Catch: Exception -> L42
    L40:
        r111.b();     // Catch: Exception -> L42
    }

    private void b(com.cmic.sso.sdk.a r100) {
        if (this.f273288d == false) goto L6;
        com.cmic.sso.sdk.e.c.a("UmcConfigHandle", "正在获取配置中...");
        return;
    L6:
        this.f273288d = true;
        com.cmic.sso.sdk.c.c.a.a().a(false, r100, new AnonymousClass1(this));
    }

    public static /* synthetic */ com.cmic.sso.sdk.a.a c(b r100) {
        return r100.f273286a;
    }

    public static b a(boolean r100) {
        if (f273285c != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f273285c != null) goto L9;
        f273285c = new b(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f273285c;
    }

    public static /* synthetic */ a b(b r100) {
        return r100.f273289e;
    }

    public void a(final com.cmic.sso.sdk.a r100) {
        if (d.a() == false) goto L6;
        n.a(new AnonymousClass2(this, r100));
        return;
    }

    public static /* synthetic */ com.cmic.sso.sdk.a.a a(b r100) {
        return r100.d();
    }

    public void a(a r100) {
        this.f273289e = r100;
    }

    private String a(String r100, String r101) {
        String[] r102 = r100.split("&");
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        String r105 = r102[r104];
        if (r105.contains(r101) == true) goto L10;
        r104 = r104 + 1;
    L10:
        if (TextUtils.isEmpty(r105) == false) goto L12;
        return r105;
    L12:
        return r105.substring(r105.lastIndexOf(ContainerUtils.KEY_VALUE_DELIMITER) + 1);
    L8:
        r105 = "";
        goto L10
    }

    public static /* synthetic */ void a(b r100, com.cmic.sso.sdk.a r101) {
        r100.b(r101);
    }

    public static /* synthetic */ void a(b r100, JSONObject r101) {
        r100.a(r101);
    }

    public static /* synthetic */ com.cmic.sso.sdk.a.a a(b r100, com.cmic.sso.sdk.a.a r101) {
        r100.f273286a = r101;
        return r101;
    }

    public static /* synthetic */ boolean a(b r100, boolean r101) {
        r100.f273288d = r101;
        return r101;
    }

    private void a(JSONObject r100, String r101, String r102, k.a r103) {
        if (r100.has(r101) == false) goto L22;
        String r104 = r100.optString(r101, r102);
        if ("CLOSE_FRIEND_WAPKS".equals(r101) == true) goto L12;
        if ("0".equals(r104) == false) goto L9;
    L20:
        r103.a(r101, r100.optString(r101, r102));
        return;
    L9:
        if ("1".equals(r104) == true) goto L20;
        return;
    L12:
        if (TextUtils.isEmpty(r104) == false) goto L14;
        return;
    L14:
        if (r104.contains("CU") == true) goto L20;
        if (r104.contains("CT") == true) goto L20;
        if (r104.contains("CM") == true) goto L20;
        return;
    L22:
        r103.a(r101);
    }
}
