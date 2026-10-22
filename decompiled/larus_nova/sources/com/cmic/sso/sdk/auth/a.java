package com.cmic.sso.sdk.auth;

import android.content.Context;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.cmic.sso.sdk.e.d;
import com.cmic.sso.sdk.e.e;
import com.cmic.sso.sdk.e.h;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.l;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f273336c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.cmic.sso.sdk.c.c.a f273337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f273338b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f273339d;

    private a(Context r100) {
        this.f273339d = new Object();
        this.f273338b = r100.getApplicationContext();
        this.f273337a = com.cmic.sso.sdk.c.c.a.a();
    }

    private boolean a(com.cmic.sso.sdk.a r110) {
        Object r100 = this.f273339d;
        monitor-enter(r100);
        boolean r101 = h.a(r110);     // Catch: Throwable -> L23
        if (r101 == false) goto L17;
        String r102 = k.b(OnekeyLoginConstants.CM_KEY_PRE_PHONE_SCRIP, "");     // Catch: Throwable -> L23
        String r103 = k.b("operatorTypeName", "");     // Catch: Throwable -> L23
        String r104 = k.b(OnekeyLoginConstants.CU_KEY_OPERATOR, "");     // Catch: Throwable -> L23
        r110.a(OnekeyLoginConstants.CM_KEY_PRE_PHONE_SCRIP, r102);     // Catch: Throwable -> L23
        r110.a("operatorTypeName", r103);     // Catch: Throwable -> L23
        r110.a(OnekeyLoginConstants.CU_KEY_OPERATOR, r104);     // Catch: Throwable -> L23
        if (3 == r110.c("logintype")) goto L17;
        String r105 = h.a(this.f273338b);     // Catch: Throwable -> L23
        StringBuilder r106 = new StringBuilder("解密phoneScript ");     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r105) == true) goto L11;
        boolean r107 = true;
    L12:
        r106.append(r107);     // Catch: Throwable -> L23
        com.cmic.sso.sdk.e.c.b("AuthnBusiness", r106.toString());     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r105) == true) goto L15;
        r110.a("phonescrip", r105);     // Catch: Throwable -> L23
    L16:
        h.a(true, false);     // Catch: Throwable -> L23
        goto L17
    L15:
        r101 = false;
        goto L16
    L11:
        r107 = false;
    L17:
        r110.a("isCacheScrip", r101);     // Catch: Throwable -> L23
        com.cmic.sso.sdk.e.c.b("AuthnBusiness", "isCachePhoneScrip = " + r101);     // Catch: Throwable -> L23
        monitor-exit(r100);     // Catch: Throwable -> L23
        if (r110.c("networktype") != 2) goto L22;
        return r101;
    L22:
        return true;
    L23:
        th = move-exception;
        throw th;
    }

    private void b(com.cmic.sso.sdk.a r100) {
        String r101 = this.f273338b.getPackageName();
        String r102 = d.a(l.a(this.f273338b, r101));
        r100.a("apppackage", r101);
        r100.a("appsign", r102);
    }

    private void c(com.cmic.sso.sdk.a r100) {
        byte[] r101 = new byte[0];
        if (r100.b("use2048PublicKey", false) == false) goto L5;
        com.cmic.sso.sdk.e.c.a("AuthnBusiness", "使用2048公钥对应的对称秘钥生成方式");
        r101 = com.cmic.sso.sdk.e.a.a();
    L10:
        byte[] r102 = com.cmic.sso.sdk.e.a.a();
        r100.a(com.cmic.sso.sdk.b.a.f273344a, r101);
        r100.a(com.cmic.sso.sdk.b.a.f273345b, r102);
        r100.a("authType", "3");
        return;
    L5:
        com.cmic.sso.sdk.e.c.a("AuthnBusiness", "使用1024公钥对应的对称秘钥生成方式");
        r101 = UUID.randomUUID().toString().substring(0, 16).getBytes(XML.CHARSET_UTF8);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public static a a(Context r100) {
        if (f273336c != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f273336c != null) goto L9;
        f273336c = new a(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f273336c;
    }

    private void b(final com.cmic.sso.sdk.a r100, final b r101) {
        com.cmic.sso.sdk.e.c.b("AuthnBusiness", "getScripAndToken start");
        boolean r102 = r100.b("isGotScrip", false);
        com.cmic.sso.sdk.e.c.b("AuthnBusiness", "isGotScrip = " + r102);
        if (r102 == true) goto L17;
        b(r100);
        if (r100.b("isCacheScrip", false) == true) goto L12;
        c(r100);
        if (r100.c("networktype") != 3) goto L12;
        if (r100.c("logintype") == 3) goto L12;
        r100.a("isRisk", true);
    L12:
        if (r100.c("logintype") != 1) goto L15;
        r100.a("userCapaid", "200");
        goto L17
    L15:
        if (r100.c("logintype") != 0) goto L17;
        r100.a("userCapaid", "50");
    L17:
        this.f273337a.a(r100, new AnonymousClass1(this, r100, r101));
    }

    public void a(com.cmic.sso.sdk.a r100, b r101) {
        if (e.a(r100.b("traceId")) == false) goto L5;
        return;
    L5:
        com.cmic.sso.sdk.e.c.b("AuthnBusiness", "LoginCheck method start");
        if (a(r100) == false) goto L15;
        com.cmic.sso.sdk.e.c.b("AuthnBusiness", "LoginCheck method start");
        int r102 = r100.c("logintype");
        if (r100.b("isCacheScrip", false) == false) goto L14;
        String r103 = r100.b(OnekeyLoginConstants.CM_KEY_PRE_PHONE_SCRIP, "");
        if (r102 != 3) goto L12;
        r101.a("103000", "true", r100, c.a(r103));
        return;
    L12:
        b(r100, r101);
        return;
    L14:
        b(r100, r101);
        return;
    L15:
        r101.a("102103", "无数据网络", r100, null);
    }

    private void a(com.cmic.sso.sdk.a r210, b r211, String r212, String r213, JSONObject r214) {
        if ("103000".equals(r212) == false) goto L54;
        String r110 = r214.optString("resultdata");
        if (TextUtils.isEmpty(r110) == false) goto L7;
        String r100 = r214.toString();
    L62:
        JSONObject r111 = new JSONObject(r100);     // Catch: JSONException -> L35
        String r112 = r111.optString("phonescrip");     // Catch: JSONException -> L32
        String r113 = r111.optString(OnekeyLoginConstants.CM_KEY_PRE_PHONE_SCRIP);     // Catch: JSONException -> L30
        String r114 = r111.optString("openId");     // Catch: JSONException -> L27
    L24:
        e = e;
        String r115 = r112;
        String r116 = null;
    L26:
        String r117 = null;
    L29:
        JSONException r118 = e;
        String r101 = r113;
        r111 = r111;
    L37:
        r118.printStackTrace();
        r111 = r111;
        String r102 = r114;
        r113 = r101;
    L38:
        String r103 = r115;
        com.cmic.sso.sdk.e.c.b("AuthnBusiness", "securityPhone  = " + r113);
        r210.a("openId", r102);
        r210.a("phonescrip", r103);
        r210.a(OnekeyLoginConstants.CM_KEY_PRE_PHONE_SCRIP, r113);
        r210.a(OnekeyLoginConstants.OPERATOR_TYPE, r117);
        r210.a("operatorTypeName", r116);
        if (r111 != null) goto L41;
        com.cmic.sso.sdk.e.c.a("AuthnBusiness", "返回103000，但是数据解析出错");
        r211.a(String.valueOf(102223), "数据解析异常", r210, c.a(String.valueOf(102223), "数据解析异常"));
        return;
    L41:
        if (r210.b("isRisk", false) == true) goto L45;
        h.a(this.f273338b, r103, CastLongProtector.parseLong(r111.optString("scripExpiresIn", "0")), r210.b("scripKey", ""), r210.b("scripType", ""));
    L45:
        if (r210.c("logintype") != 3) goto L48;
        r211.a(r212, "true", r210, c.a(r113));
        return;
    L48:
        if (r210.b("isRisk", false) == false) goto L50;
        r210.a("isRisk", false);
        r210.a("isGotScrip", true);
        b(r210, r211);
        return;
    L50:
        r211.a(r212, r213, r210, r111);
        return;
    L13:
        if (TextUtils.isEmpty(r114) == false) goto L15;
        r114 = r111.optString("pcid");     // Catch: JSONException -> L24
    L15:
        r116 = r111.optString("operatorTypeName");     // Catch: JSONException -> L24
        r115 = r112;
        r117 = r111.optString(OnekeyLoginConstants.OPERATOR_TYPE);     // Catch: JSONException -> L22
        k.a(OnekeyLoginConstants.CM_KEY_PRE_PHONE_SCRIP, r113);     // Catch: JSONException -> L20
        k.a(OnekeyLoginConstants.OPERATOR_TYPE, r117);     // Catch: JSONException -> L20
        k.a("operatorTypeName", r116);     // Catch: JSONException -> L20
        r102 = r114;
    L20:
        e = e;
    L22:
        e = e;
    L27:
        e = e;
        r115 = r112;
        r116 = null;
        r117 = null;
        r114 = null;
    L30:
        e = e;
        r115 = r112;
        r116 = null;
        r117 = null;
        r114 = null;
    L34:
        r118 = e;
        r101 = null;
    L32:
        e = e;
        r116 = null;
        r117 = null;
        r114 = null;
        r115 = null;
    L35:
        e = move-exception;
        r118 = e;
        r101 = null;
        r111 = null;
        r116 = null;
        r117 = null;
        r114 = null;
        r115 = null;
        goto L37
    L7:
        r100 = com.cmic.sso.sdk.e.a.b(r210.a(com.cmic.sso.sdk.b.a.f273344a), r110, r210.a(com.cmic.sso.sdk.b.a.f273345b));
        goto L62
    L54:
        if (r210.c("logintype") != 3) goto L56;
        r211.a(r212, "true", r210, c.b(r212, r213));
        return;
    L56:
        r211.a(r212, r213, r210, r214);
    }

    public static /* synthetic */ void a(a r100, com.cmic.sso.sdk.a r101, b r102, String r103, String r104, JSONObject r105) {
        r100.a(r101, r102, r103, r104, r105);
    }
}
