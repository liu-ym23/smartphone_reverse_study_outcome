package com.tencent.connect.auth;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.open.web.security.JniInterface;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class QQToken {
    public static final int AUTH_QQ = 2;
    public static final int AUTH_QZONE = 3;
    public static final int AUTH_WEB = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static SharedPreferences f461440g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f461441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f461442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f461443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f461444d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f461445e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.tencent.open.utils.a f461446f;

    private static synchronized SharedPreferences a() {
        monitor-enter(QQToken.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f461440g != null) goto L7;
        f461440g = g.a().getSharedPreferences("token_info_file", 0);     // Catch: Throwable -> L10
    L7:
        SharedPreferences r100 = f461440g;     // Catch: Throwable -> L10
        monitor-exit(QQToken.class);
        return r100;
    }

    public String getOpenIdWithCache() {
        String r100 = getOpenId();
    L14:
        e = move-exception;
        SLog.i("QQToken", "getLocalOpenIdByAppId " + e.toString());
    L16:
        return r100;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L12;
        JSONObject r101 = loadSession(this.f461441a);     // Catch: Exception -> L14
        if (r101 == null) goto L11;
        r100 = JSONObjectProtectorUtils.getString(r101, "openid");     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r100) == true) goto L11;
        setOpenId(r100);     // Catch: Exception -> L14
    L11:
        SLog.i("QQToken", "getOpenId from Session openId = " + r100 + " appId = " + this.f461441a);     // Catch: Exception -> L14
        goto L16
    L12:
        SLog.i("QQToken", "getOpenId from field openId = " + r100 + " appId = " + this.f461441a);     // Catch: Exception -> L14
        goto L16
    }

    public boolean isSessionValid() {
        if (this.f461442b != null) goto L5;
    L7:
        return false;
    L5:
        if (System.currentTimeMillis() >= this.f461445e) goto L7;
        return true;
    }

    public String getAccessToken() {
        return this.f461442b;
    }

    public String getAppId() {
        return this.f461441a;
    }

    public int getAuthSource() {
        return this.f461444d;
    }

    public long getExpireTimeInSecond() {
        return this.f461445e;
    }

    public String getOpenId() {
        return this.f461443c;
    }

    public QQToken(String r100) {
        this.f461444d = 1;
        this.f461445e = -1;
        this.f461441a = r100;
    }

    private static String a(String r100) {
        return Base64.encodeToString(m.j(r100), 2) + "_aes_google";
    }

    private static String b(String r100) {
        return Base64.encodeToString(m.j(r100), 2);
    }

    private static String c(String r100) {
        return Base64.encodeToString(m.j(r100), 2) + "_spkey";
    }

    public JSONObject loadSession(String r100) {
    L7:
        e = move-exception;
        SLog.i("QQToken", "login loadSession" + e.toString());
        return null;
    L3:
        if (this.f461446f != null) goto L5;
        this.f461446f = new com.tencent.open.utils.a(g.a());     // Catch: Exception -> L7
    L5:
        return a(r100, this.f461446f);
    }

    public void removeSession(String r100) {
        SharedPreferences.Editor r101 = a().edit();
        r101.remove(c(r100));
        r101.remove(c(r100));
        r101.remove(a(r100));
        r101.apply();
        SLog.i("QQToken", "removeSession sucess");
    }

    public boolean saveSession(JSONObject r100) {
    L7:
        e = move-exception;
        SLog.i("QQToken", "login saveSession" + e.toString());
        return false;
    L3:
        if (this.f461446f != null) goto L5;
        this.f461446f = new com.tencent.open.utils.a(g.a());     // Catch: Exception -> L7
    L5:
        return a(this.f461441a, r100, this.f461446f);
    }

    public void setAppId(String r100) {
        this.f461441a = r100;
    }

    public void setAuthSource(int r100) {
        this.f461444d = r100;
    }

    public void setOpenId(String r100) {
        this.f461443c = r100;
        com.tencent.open.b.b.a().a(r100);
    }

    private static synchronized JSONObject a(String r100, com.tencent.open.utils.a r101) {
        monitor-enter(QQToken.class);
    L69:
        th = move-exception;
        throw th;
    L5:
        if (g.a() != null) goto L9;
        SLog.i("QQToken", "loadJsonPreference context null");     // Catch: Throwable -> L69
        monitor-exit(QQToken.class);
        return null;
    L9:
        if (r100 != null) goto L13;
        SLog.i("QQToken", "loadJsonPreference prefKey is null");     // Catch: Throwable -> L69
        monitor-exit(QQToken.class);
        return null;
    L13:
        String r102 = a().getString(a(r100), "");     // Catch: Throwable -> L69
        if (TextUtils.isEmpty(r102) == true) goto L16;
        String r103 = r101.b(r102);     // Catch: Throwable -> L69
    L72:
        JSONObject r104 = new JSONObject(r103);     // Catch: Exception -> L65 Throwable -> L69
        SLog.i("QQToken", "loadJsonPreference sucess");     // Catch: Throwable -> L69
        monitor-exit(QQToken.class);
        return r104;
    L65:
        e = move-exception;
        SLog.i("QQToken", "loadJsonPreference decode " + e.toString());     // Catch: Throwable -> L69
        return null;
    L16:
        if (JniInterface.isJniOk == true) goto L19;
        k.a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 5);     // Catch: Throwable -> L69
        JniInterface.loadSo();     // Catch: Throwable -> L69
    L19:
        if (JniInterface.isJniOk == true) goto L23;
        SLog.i("QQToken", "loadJsonPreference jni load fail SECURE_LIB_VERSION=5");     // Catch: Throwable -> L69
        monitor-exit(QQToken.class);
        return null;
    L23:
        String r105 = c(r100);     // Catch: Throwable -> L69
        String r106 = a().getString(r105, "");     // Catch: Throwable -> L69
        if (TextUtils.isEmpty(r106) == false) goto L78;
        String r107 = b(r100);     // Catch: Throwable -> L69
        String r108 = a().getString(r107, "");     // Catch: Throwable -> L69
        if (TextUtils.isEmpty(r108) == false) goto L75;
        SLog.i("QQToken", "loadJsonPreference oldDesValue null");     // Catch: Throwable -> L69
        monitor-exit(QQToken.class);
        return null;
    L75:
        r103 = JniInterface.d1(r108);     // Catch: Throwable -> L39 Exception -> L41
        if (TextUtils.isEmpty(r103) == false) goto L36;
        SLog.i("QQToken", "loadJsonPreference decodeResult d1 empty");     // Catch: Throwable -> L39 Exception -> L41
        a().edit().remove(r107).apply();     // Catch: Throwable -> L69
        monitor-exit(QQToken.class);
        return null;
    L36:
        a(r100, new JSONObject(r103), r101);     // Catch: Throwable -> L39 Exception -> L41
        a().edit().remove(r107).apply();     // Catch: Throwable -> L69
    L41:
        e = move-exception;
        SLog.e("QQToken", "Catch Exception", e);     // Catch: Throwable -> L39
        a().edit().remove(r107).apply();     // Catch: Throwable -> L69
        return null;
    L39:
        th = move-exception;
        a().edit().remove(r107).apply();     // Catch: Throwable -> L69
        throw th;     // Catch: Throwable -> L69
    L78:
        r103 = JniInterface.d2(r106);     // Catch: Throwable -> L51 Exception -> L53
        a(r100, new JSONObject(r103), r101);     // Catch: Throwable -> L51 Exception -> L53
        a().edit().remove(r105).apply();     // Catch: Throwable -> L69
        goto L72
    L53:
        e = move-exception;
        SLog.e("QQToken", "Catch Exception", e);     // Catch: Throwable -> L51
        a().edit().remove(r105).apply();     // Catch: Throwable -> L69
        return null;
    L51:
        th = move-exception;
        a().edit().remove(r105).apply();     // Catch: Throwable -> L69
        throw th;     // Catch: Throwable -> L69
    }

    public void setAccessToken(String r100, String r101) throws NumberFormatException {
        this.f461442b = r100;
        this.f461445e = 0;
        if (r101 == null) goto L6;
        this.f461445e = System.currentTimeMillis() + (CastLongProtector.parseLong(r101) * 1000);
        return;
    }

    private static synchronized boolean a(String r110, JSONObject r111, com.tencent.open.utils.a r112) {
        monitor-enter(QQToken.class);
    L36:
        th = move-exception;
        throw th;
    L5:
        if (g.a() != null) goto L9;
        SLog.i("QQToken", "saveJsonPreference context null");     // Catch: Throwable -> L36
        monitor-exit(QQToken.class);
        return false;
    L9:
        if (r110 == null) goto L33;
        if (r111 == null) goto L33;
        String r100 = JSONObjectProtectorUtils.getString(r111, "expires_in");     // Catch: Exception -> L29 Throwable -> L36
        if (TextUtils.isEmpty(r100) == true) goto L26;
        r111.put("expires_time", System.currentTimeMillis() + (CastLongProtector.parseLong(r100) * 1000));     // Catch: Exception -> L29 Throwable -> L36
        String r113 = a(r110);     // Catch: Throwable -> L36
        String r114 = r112.a(r111.toString());     // Catch: Throwable -> L36
        if (r113.length() <= 6) goto L23;
        if (r114 == null) goto L23;
        a().edit().putString(r113, r114).commit();     // Catch: Throwable -> L36
        SLog.i("QQToken", "saveJsonPreference sucess");     // Catch: Throwable -> L36
        monitor-exit(QQToken.class);
        return true;
    L23:
        SLog.i("QQToken", "saveJsonPreference keyEncode or josnEncode null");     // Catch: Throwable -> L36
        monitor-exit(QQToken.class);
        return false;
    L26:
        SLog.i("QQToken", "expires is null");     // Catch: Exception -> L29 Throwable -> L36
        monitor-exit(QQToken.class);
        return false;
    L29:
        e = move-exception;
        SLog.e("QQToken", "saveJsonPreference exception:" + e.toString());     // Catch: Throwable -> L36
        return false;
    L33:
        SLog.i("QQToken", "saveJsonPreference prefKey or jsonObject null");     // Catch: Throwable -> L36
        monitor-exit(QQToken.class);
        return false;
    }
}
