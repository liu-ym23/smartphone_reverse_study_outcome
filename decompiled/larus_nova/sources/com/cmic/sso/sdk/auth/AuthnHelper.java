package com.cmic.sso.sdk.auth;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.cmic.sso.sdk.e.e;
import com.cmic.sso.sdk.e.h;
import com.cmic.sso.sdk.e.j;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.m;
import com.cmic.sso.sdk.e.n;
import com.cmic.sso.sdk.e.o;
import com.cmic.sso.sdk.e.q;
import com.cmic.sso.sdk.e.r;
import com.larus.apm.impl.protector.RunnableProtector;
import com.tencent.open.SocialConstants;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AuthnHelper {
    public static final String SDK_VERSION = "quick_login_android_9.5.6.1";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static AuthnHelper f273298c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.cmic.sso.sdk.auth.a f273299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f273300b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f273301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Handler f273302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f273303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.cmic.sso.sdk.c f273304g;

    /* JADX INFO: loaded from: classes22.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AuthnHelper f273334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.cmic.sso.sdk.a f273335b;

        @Override // java.lang.Runnable
        public void run() {
            com_cmic_sso_sdk_auth_AuthnHelper$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_cmic_sso_sdk_auth_AuthnHelper$a__run$___twin___() {
            if (r.a(AuthnHelper.b(this.f273334a)).a() == false) goto L5;
        L7:
            JSONObject r100 = c.a("200023", "登录超时");
        L8:
            this.f273334a.callBackResult(r100.optString("resultCode", "200023"), r100.optString(SocialConstants.PARAM_APP_DESC, "登录超时"), this.f273335b, r100);
            return;
        L5:
            if (this.f273335b.b("doNetworkSwitch", false) == false) goto L7;
            r100 = c.a("102508", "数据网络切换失败");
            goto L8
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_cmic_sso_sdk_auth_AuthnHelper$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_cmic_sso_sdk_auth_AuthnHelper$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(AuthnHelper r100, com.cmic.sso.sdk.a r101) {
            this.f273334a = r100;
            this.f273335b = r101;
        }
    }

    public void delScrip() {
        h.a(true, true);     // Catch: Exception -> L5
        com.cmic.sso.sdk.e.c.b("AuthnHelper", "删除scrip");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    private void a() {
        String r100 = GXTemplateKey.GAIAX_PE + q.b();
        com.cmic.sso.sdk.e.c.b("AuthnHelper", "generate aid = " + r100);
        k.a("AID", r100);
    }

    private AuthnHelper(Context r100) {
        this.f273301d = KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL;
        Context r101 = r100.getApplicationContext();
        this.f273300b = r101;
        this.f273302e = new Handler(r101.getMainLooper());
        this.f273299a = com.cmic.sso.sdk.auth.a.a(r101);
        r.a(r101);
        k.a(r101);
        j.a(r101);
        this.f273304g = new com.cmic.sso.sdk.c();
        n.a(new AnonymousClass1(this));
    }

    private com.cmic.sso.sdk.a a(TokenListener r100) {
        com.cmic.sso.sdk.a r101 = new com.cmic.sso.sdk.a(64);
        String r102 = q.c();
        r101.a(new com.cmic.sso.sdk.d.a());
        r101.a("traceId", r102);
        com.cmic.sso.sdk.e.c.a("traceId", r102);
        if (r100 == null) goto L5;
        e.a(r102, r100);
    L5:
        return r101;
    }

    public static /* synthetic */ Context b(AuthnHelper r100) {
        return r100.f273300b;
    }

    public static /* synthetic */ long c(AuthnHelper r100) {
        return r100.f273301d;
    }

    public static /* synthetic */ com.cmic.sso.sdk.c d(AuthnHelper r100) {
        return r100.f273304g;
    }

    public static /* synthetic */ Handler e(AuthnHelper r100) {
        return r100.f273302e;
    }

    public static AuthnHelper getInstance(Context r100) {
        if (f273298c != null) goto L15;
        monitor-enter(AuthnHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f273298c != null) goto L9;
        f273298c = new AuthnHelper(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(AuthnHelper.class);     // Catch: Throwable -> L11
    L15:
        return f273298c;
    }

    public static void setDebugMode(boolean r100) {
        com.cmic.sso.sdk.e.c.a(r100);
    }

    public JSONObject getNetworkType(Context r100) {
        JSONObject r101 = new JSONObject();
        boolean r102 = m.a(this.f273300b);     // Catch: Exception -> L5
        com.cmic.sso.sdk.b.a.a().a(r100, r102);     // Catch: Exception -> L5
        String r103 = j.a().a(null, r102);     // Catch: Exception -> L5
        int r104 = m.a(r100, r102, new com.cmic.sso.sdk.a(1));     // Catch: Exception -> L5
        r101.put(OnekeyLoginConstants.OPERATOR_TYPE, r103);     // Catch: Exception -> L5
        r101.put("networktype", r104 + "");     // Catch: Exception -> L5
        StringBuilder r105 = new StringBuilder("网络类型: ");     // Catch: Exception -> L5
        r105.append(r104);     // Catch: Exception -> L5
        com.cmic.sso.sdk.e.c.b("AuthnHelper", r105.toString());     // Catch: Exception -> L5
        com.cmic.sso.sdk.e.c.b("AuthnHelper", "运营商类型: " + r103);     // Catch: Exception -> L5
        return r101;
    L5:
        r101.put("errorDes", "发生未知错误");     // Catch: JSONException -> L7
    L9:
        return r101;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public void setOverTime(long r100) {
        this.f273301d = r100;
    }

    public static /* synthetic */ void a(AuthnHelper r100) {
        r100.a();
    }

    private AuthnHelper(Context r100, String r101) {
        this(r100);
        this.f273303f = r101;
    }

    private void a(com.cmic.sso.sdk.a r100, final a r101) {
        this.f273299a.a(r100, new AnonymousClass5(this, r101));
    }

    public static AuthnHelper getInstance(Context r100, String r101) {
        if (f273298c != null) goto L15;
        monitor-enter(AuthnHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f273298c != null) goto L9;
        f273298c = new AuthnHelper(r100, r101);     // Catch: Throwable -> L11
    L9:
        monitor-exit(AuthnHelper.class);     // Catch: Throwable -> L11
    L15:
        return f273298c;
    }

    private void a(final Context r100, final String r101, final com.cmic.sso.sdk.a r102) {
        n.a(new AnonymousClass8(this, r101, r100, r102));
    }

    public void getPhoneInfo(final String r110, final String r111, final TokenListener r112) {
        final com.cmic.sso.sdk.a r100 = a(r112);
        final a r101 = new a(this, r100);
        this.f273302e.postDelayed(r101, this.f273301d);
        final Context r102 = this.f273300b;
        n.a(new AnonymousClass4(this, r102, r100, r100, r110, r111, r112, r101));
    }

    public void loginAuth(final String r110, final String r111, final TokenListener r112) {
        final com.cmic.sso.sdk.a r100 = a(r112);
        final a r101 = new a(this, r100);
        this.f273302e.postDelayed(r101, this.f273301d);
        final Context r102 = this.f273300b;
        n.a(new AnonymousClass2(this, r102, r100, r100, r110, r111, r112, r101));
    }

    public void mobileAuth(final String r110, final String r111, final TokenListener r112) {
        final com.cmic.sso.sdk.a r100 = a(r112);
        final a r101 = new a(this, r100);
        this.f273302e.postDelayed(r101, this.f273301d);
        final Context r102 = this.f273300b;
        n.a(new AnonymousClass3(this, r102, r100, r100, r110, r111, r112, r101));
    }

    public static /* synthetic */ void a(AuthnHelper r100, com.cmic.sso.sdk.a r101, a r102) {
        r100.a(r101, r102);
    }

    public void callBackResult(String r100, String r101, com.cmic.sso.sdk.a r102, JSONObject r103) {
        String r104 = r102.b("traceId");     // Catch: Exception -> L29
        if (e.a(r104) == true) goto L34;
        monitor-enter(this);     // Catch: Exception -> L29
        final TokenListener r105 = e.c(r104);     // Catch: Throwable -> L26
        e.b(r104);     // Catch: Throwable -> L26
        if (r105 != null) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L26
        r102.a("systemEndTime", SystemClock.elapsedRealtime());     // Catch: Exception -> L29
        r102.a("endtime", o.a());     // Catch: Exception -> L29
        int r106 = r102.c("logintype");     // Catch: Exception -> L29
        if (r103 != null) goto L14;
        r103 = c.a(r100, r101);     // Catch: Exception -> L29
    L14:
        if (r106 != 3) goto L16;
        final JSONObject r107 = c.a(r100, r102, r103);     // Catch: Exception -> L29
        this.f273304g.a();     // Catch: Exception -> L29
    L17:
        r107.put("scripExpiresIn", String.valueOf(h.a()));     // Catch: Exception -> L29
        this.f273302e.post(new AnonymousClass6(this, r105, r107));     // Catch: Exception -> L29
        com.cmic.sso.sdk.a.c.a(this.f273300b).a(r102);     // Catch: Exception -> L29
        if (r102.b().j() == true) goto L23;
        if (q.a(r102.b()) == true) goto L23;
        a(this.f273300b, r100, r102);     // Catch: Exception -> L29
    L23:
        if (e.a() == false) goto L35;
        n.a(new AnonymousClass7(this));     // Catch: Exception -> L29
        return;
    L35:
        return;
    L16:
        r107 = c.a(r100, r101, r102, r103);     // Catch: Exception -> L29
    L26:
        th = move-exception;
        throw th;     // Catch: Exception -> L29
    L34:
        return;
    L29:
        e = move-exception;
        e.printStackTrace();
    }

    private synchronized boolean a(com.cmic.sso.sdk.a r100, String r110, String r111, String r112, int r113, TokenListener r114) {
        monitor-enter(this);
        com.cmic.sso.sdk.a.a r101 = com.cmic.sso.sdk.a.c.a(this.f273300b).a();     // Catch: Throwable -> L61
        com.cmic.sso.sdk.e.c.b("AuthnHelper", "umcConfigBean = " + r101.toString());     // Catch: Throwable -> L61
        r100.a(r101);     // Catch: Throwable -> L61
        r100.a("use2048PublicKey", "rsa2048".equals(this.f273303f));     // Catch: Throwable -> L61
        r100.a("systemStartTime", SystemClock.elapsedRealtime());     // Catch: Throwable -> L61
        r100.a("starttime", o.a());     // Catch: Throwable -> L61
        r100.a("loginMethod", r112);     // Catch: Throwable -> L61
        r100.a("appkey", r111);     // Catch: Throwable -> L61
        r100.a("appid", r110);     // Catch: Throwable -> L61
        r100.a("timeOut", String.valueOf(this.f273301d));     // Catch: Throwable -> L61
        boolean r115 = m.a(this.f273300b);     // Catch: Throwable -> L61
        com.cmic.sso.sdk.b.a.a().a(this.f273300b, r115);     // Catch: Throwable -> L61
        String r102 = j.a().b();     // Catch: Throwable -> L61
        String r103 = j.a().a(r115);     // Catch: Throwable -> L61
        String r104 = j.a().a(r103, r115);     // Catch: Throwable -> L61
        r100.a(OnekeyLoginConstants.CU_KEY_OPERATOR, r103);     // Catch: Throwable -> L61
        r100.a(OnekeyLoginConstants.OPERATOR_TYPE, r104);     // Catch: Throwable -> L61
        r100.a("logintype", r113);     // Catch: Throwable -> L61
        com.cmic.sso.sdk.e.c.b("AuthnHelper", "subId = " + r102);     // Catch: Throwable -> L61
        if (TextUtils.isEmpty(r102) == true) goto L8;
        com.cmic.sso.sdk.e.c.a("AuthnHelper", "使用subId作为缓存key = " + r102);     // Catch: Throwable -> L61
        r100.a("scripType", "subid");     // Catch: Throwable -> L61
        r100.a("scripKey", r102);     // Catch: Throwable -> L61
    L10:
        int r116 = m.a(this.f273300b, r115, r100);     // Catch: Throwable -> L61
        r100.a("networktype", r116);     // Catch: Throwable -> L61
        if (r115 == true) goto L15;
        r100.a("authType", String.valueOf(0));     // Catch: Throwable -> L61
        callBackResult("200010", "无法识别sim卡或没有sim卡", r100, null);     // Catch: Throwable -> L61
        monitor-exit(this);
        return false;
    L15:
        if (r114 != null) goto L20;
        callBackResult("102203", "listener不能为空", r100, null);     // Catch: Throwable -> L61
        monitor-exit(this);
        return false;
    L20:
        if (r101.g() == false) goto L24;
        callBackResult("200082", "服务器繁忙，请稍后重试", r100, null);     // Catch: Throwable -> L61
        monitor-exit(this);
        return false;
    L24:
        if (r110 != null) goto L26;
        String r117 = "";
    L28:
        if (TextUtils.isEmpty(r117) == false) goto L32;
        callBackResult("102203", "appId 不能为空", r100, null);     // Catch: Throwable -> L61
        monitor-exit(this);
        return false;
    L32:
        if (r111 != null) goto L34;
        String r118 = "";
    L36:
        if (TextUtils.isEmpty(r118) == false) goto L40;
        callBackResult("102203", "appkey不能为空", r100, null);     // Catch: Throwable -> L61
        monitor-exit(this);
        return false;
    L40:
        if (r116 != 0) goto L45;
        callBackResult("102101", "未检测到网络", r100, null);     // Catch: Throwable -> L61
        monitor-exit(this);
        return false;
    L45:
        if ("2".equals(r104) == false) goto L52;
        if (r101.f() == false) goto L52;
        callBackResult("200082", "服务器繁忙，请稍后重试", r100, null);     // Catch: Throwable -> L61
        monitor-exit(this);
        return false;
    L52:
        if ("3".equals(r104) == true) goto L54;
    L58:
        monitor-exit(this);
        return true;
    L54:
        if (r101.e() == false) goto L58;
        callBackResult("200082", "服务器繁忙，请稍后重试", r100, null);     // Catch: Throwable -> L61
        monitor-exit(this);
        return false;
    L34:
        r118 = r111.trim();     // Catch: Throwable -> L61
        goto L36
    L26:
        r117 = r110.trim();     // Catch: Throwable -> L61
        goto L28
    L8:
        if (TextUtils.isEmpty(r103) == true) goto L10;
        com.cmic.sso.sdk.e.c.a("AuthnHelper", "使用operator作为缓存key = " + r103);     // Catch: Throwable -> L61
        r100.a("scripType", OnekeyLoginConstants.CU_KEY_OPERATOR);     // Catch: Throwable -> L61
        r100.a("scripKey", r103);     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ boolean a(AuthnHelper r100, com.cmic.sso.sdk.a r101, String r102, String r103, String r104, int r105, TokenListener r106) {
        return r100.a(r101, r102, r103, r104, r105, r106);
    }
}
