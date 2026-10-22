package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.BuildConfig;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static p f464336a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static a f1124a;

    public interface a {
        void a();
    }

    public static void a() {
        a r100 = f1124a;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static synchronized p m9409a(Context r110) {
        monitor-enter(q.class);
        p r100 = f464336a;     // Catch: Throwable -> L33
        if (r100 == null) goto L8;
        monitor-exit(q.class);
        return r100;
    L8:
        SharedPreferences r101 = r110.getSharedPreferences("mipush_account", 0);     // Catch: Throwable -> L33
        String r102 = r101.getString(ST.UUID_DEVICE, null);     // Catch: Throwable -> L33
        String r103 = r101.getString("token", null);     // Catch: Throwable -> L33
        String r104 = r101.getString(AppConstants.API_HOST_SI_PREFIX, null);     // Catch: Throwable -> L33
        String r105 = r101.getString("app_id", null);     // Catch: Throwable -> L33
        String r106 = r101.getString("app_token", null);     // Catch: Throwable -> L33
        String r111 = r101.getString("package_name", null);     // Catch: Throwable -> L33
        String r107 = r101.getString("device_id", null);     // Catch: Throwable -> L33
        int r112 = r101.getInt("env_type", 1);     // Catch: Throwable -> L33
        if (TextUtils.isEmpty(r107) == true) goto L14;
        if (com.xiaomi.push.i.a(r107) == false) goto L14;
        r107 = com.xiaomi.push.i.g(r110);     // Catch: Throwable -> L33
        r101.edit().putString("device_id", r107).commit();     // Catch: Throwable -> L33
    L14:
        if (TextUtils.isEmpty(r102) == false) goto L16;
    L31:
        monitor-exit(q.class);
        return null;
    L16:
        if (TextUtils.isEmpty(r103) == true) goto L31;
        if (TextUtils.isEmpty(r104) == true) goto L31;
        String r108 = com.xiaomi.push.i.g(r110);     // Catch: Throwable -> L33
        if ("com.xiaomi.xmsf".equals(r110.getPackageName()) == false) goto L22;
    L28:
        p r113 = new p(r102, r103, r104, r105, r106, r111, r112);     // Catch: Throwable -> L33
        f464336a = r113;     // Catch: Throwable -> L33
        monitor-exit(q.class);
        return r113;
    L22:
        if (TextUtils.isEmpty(r108) == true) goto L28;
        if (TextUtils.isEmpty(r107) == true) goto L28;
        if (r107.equals(r108) == true) goto L28;
        com.xiaomi.channel.commonutils.logger.b.m8718a("read_phone_state permission changes.");     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m9410a(Context r100) {
        p r101 = m9409a(r100);
        if (r101 != null) goto L5;
    L9:
        return null;
    L5:
        if (TextUtils.isEmpty(r101.f1123a) == true) goto L9;
        String[] r102 = r101.f1123a.split("@");
        if (r102.length <= 0) goto L9;
        return r102[0];
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m9411a(Context r100) {
        r100.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        f464336a = null;
        a();
    }

    private static int a(Context r100) {
        return r100.getSharedPreferences("mipush_account", 0).getInt("enc_req_fail_count", 0);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m9412a(Context r100) {
        return r100.getPackageName().equals("com.xiaomi.xmsf");
    }

    public static void a(a r100) {
        f1124a = r100;
    }

    public static void a(Context r100, p r101) {
        SharedPreferences.Editor r102 = r100.getSharedPreferences("mipush_account", 0).edit();
        r102.putString(ST.UUID_DEVICE, r101.f1123a);
        r102.putString(AppConstants.API_HOST_SI_PREFIX, r101.f464332c);
        r102.putString("token", r101.f464331b);
        r102.putString("app_id", r101.f464333d);
        r102.putString("package_name", r101.f464335f);
        r102.putString("app_token", r101.f464334e);
        r102.putString("device_id", com.xiaomi.push.i.g(r100));
        r102.putInt("env_type", r101.f464330a);
        r102.commit();
        a();
    }

    private static String a(Context r100, boolean r101) {
        String r102 = b.a(r100).a();
        if (r101 == false) goto L5;
        String r103 = "/pass/v2/register/encrypt";
    L7:
        if (com.xiaomi.push.w.b() == false) goto L11;
        return "http://10.38.162.35:9085".concat(r103);
    L11:
        if (com.xiaomi.push.m.f464124a.name().equals(r102) == true) goto L13;
        return null;
    L13:
        return "https://cn.register.xmpush.xiaomi.com".concat(r103);
    L5:
        r103 = "/pass/v2/register";
        goto L7
    }

    private static void a(Context r100, int r101) {
        SharedPreferences.Editor r102 = r100.getSharedPreferences("mipush_account", 0).edit();
        r102.putInt("enc_req_fail_count", r101);
        r102.commit();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v15, types: [java.lang.StringBuilder] */
    public static synchronized p a(Context r110, String r111, String r112, String r210) {
        monitor-enter(q.class);
        TreeMap r100 = new TreeMap();     // Catch: Throwable -> L111
        r100.put("devid", com.xiaomi.push.i.a(r110, false));     // Catch: Throwable -> L111
        p r101 = f464336a;     // Catch: Throwable -> L111
        if (r101 != null) goto L7;
    L11:
        ?? r102 = 0;
    L12:
        com.xiaomi.push.am.a(r110).a(r100);     // Catch: Throwable -> L111
        if (m9412a(r110) == false) goto L15;
        String r113 = "1000271";
    L17:
        if (m9412a(r110) == false) goto L19;
        String r114 = "420100086271";
    L21:
        if (m9412a(r110) == false) goto L23;
        String r115 = "com.xiaomi.xmsf";
    L24:
        r100.put("appid", r113);     // Catch: Throwable -> L111
        r100.put("apptoken", r114);     // Catch: Throwable -> L111
        PackageInfo r103 = r110.getPackageManager().getPackageInfo(r115, 16384);     // Catch: Exception -> L27 Throwable -> L111
    L30:
        if (r103 == null) goto L32;
        String r104 = String.valueOf(r103.versionCode);     // Catch: Throwable -> L111
    L33:
        r100.put("appversion", r104);     // Catch: Throwable -> L111
        r100.put("sdkversion", Integer.toString(BuildConfig.VERSION_CODE));     // Catch: Throwable -> L111
        r100.put("packagename", r115);     // Catch: Throwable -> L111
        r100.put(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, Build.MODEL);     // Catch: Throwable -> L111
        r100.put("board", Build.BOARD);     // Catch: Throwable -> L111
        if (com.xiaomi.push.j.m9300d() == true) goto L46;
        String r105 = "";
        String r106 = com.xiaomi.push.i.c(r110);     // Catch: Throwable -> L111
        if (TextUtils.isEmpty(r106) == true) goto L38;
        r105 = "" + com.xiaomi.push.ba.a(r106);     // Catch: Throwable -> L111
    L38:
        String r107 = com.xiaomi.push.i.e(r110);     // Catch: Throwable -> L111
        if (TextUtils.isEmpty(r105) == true) goto L44;
        if (TextUtils.isEmpty(r107) == true) goto L44;
        r105 = r105 + "," + r107;     // Catch: Throwable -> L111
    L44:
        if (TextUtils.isEmpty(r105) == true) goto L46;
        r100.put(Constants.EXTRA_KEY_IMEI_MD5, r105);     // Catch: Throwable -> L111
    L46:
        r100.put("os", Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL);     // Catch: Throwable -> L111
        int r108 = com.xiaomi.push.i.a();     // Catch: Throwable -> L111
        if (r108 < 0) goto L49;
        r100.put(DocViewModel.EXTRA_SPACE_ID, Integer.toString(r108));     // Catch: Throwable -> L111
    L49:
        r100.put("brand", Build.BRAND + "");     // Catch: Throwable -> L111
        r100.put("ram", com.xiaomi.push.i.m9282a());     // Catch: Throwable -> L111
        r100.put("rom", com.xiaomi.push.i.m9287b());     // Catch: Throwable -> L111
        JSONObject r109 = new JSONObject();     // Catch: Throwable -> L111
        Iterator r116 = r100.entrySet().iterator();     // Catch: Throwable -> L111
    L51:
        if (r116.hasNext() == false) goto L57;
        Map.Entry r117 = (Map.Entry) r116.next();     // Catch: Throwable -> L111
        r109.put((String) r117.getKey(), r117.getValue());     // Catch: JSONException -> L55 Throwable -> L111
    L55:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("failed to add data in json format: k=" + ((String) r117.getKey()) + ",v=" + ((String) r117.getValue()) + ". " + e);     // Catch: Throwable -> L111
        goto L51
    L57:
        String r118 = av.a(r109.toString());     // Catch: Throwable -> L111
        TreeMap r119 = new TreeMap();     // Catch: Throwable -> L111
        r119.put("requestData", r118);     // Catch: Throwable -> L111
        r119.put("keyPairVer", "1");     // Catch: Throwable -> L111
        if (a(r110) < 2) goto L60;
    L63:
        boolean r120 = false;
    L64:
        String r121 = a(r110, r120);     // Catch: Throwable -> L111
        if (TextUtils.isEmpty(r121) == false) goto L68;
        monitor-exit(q.class);
        return null;
    L68:
        if (r120 == false) goto L120;
        r100 = r119;
    L120:
        com.xiaomi.push.ar r122 = com.xiaomi.push.at.a(r110, r121, r100);     // Catch: IOException -> L72 Throwable -> L111
    L75:
        if (r122 != null) goto L77;
    L103:
        ?? r123 = r120;
    L104:
        if (r123 != 0) goto L106;
    L108:
        com.xiaomi.channel.commonutils.logger.b.m8718a("fail to register push account. meet error.");     // Catch: Throwable -> L111
        monitor-exit(q.class);
        return null;
    L106:
        if (com.xiaomi.push.at.b(r110) == false) goto L108;
        a(r110, a(r110) + 1);     // Catch: Throwable -> L111
        goto L108
    L77:
        if (r122.f463150a != 200) goto L103;
        String r124 = r122.a();     // Catch: Throwable -> L111
        if (TextUtils.isEmpty(r124) == true) goto L103;
        JSONObject r125 = new JSONObject(r124);     // Catch: Throwable -> L97 JSONException -> L100
        if (JSONObjectProtectorUtils.getInt(r125, "code") != 0) goto L90;
        JSONObject r126 = JSONObjectProtectorUtils.getJSONObject(r125, "data");     // Catch: Throwable -> L97 JSONException -> L100
        String r127 = JSONObjectProtectorUtils.getString(r126, "ssecurity");     // Catch: Throwable -> L97 JSONException -> L100
        String r128 = JSONObjectProtectorUtils.getString(r126, "token");     // Catch: Throwable -> L97 JSONException -> L100
        String r129 = JSONObjectProtectorUtils.getString(r126, "userId");     // Catch: Throwable -> L97 JSONException -> L100
        boolean r130 = TextUtils.isEmpty(r102);     // Catch: Throwable -> L97 JSONException -> L100
        ?? r131 = r102;
        if (r130 == false) goto L85;
        r131 = com.alipay.sdk.m.s.a.f25763u + com.xiaomi.push.ba.a(6);     // Catch: Throwable -> L97 JSONException -> L100
    L85:
    L87:
        p r132 = new p(r129 + "@xiaomi.com/" + r131, r128, r127, r113, r114, r115, com.xiaomi.push.w.a());     // Catch: Throwable -> L93 JSONException -> L95
        a(r110, r132);     // Catch: Throwable -> L93 JSONException -> L95
        f464336a = r132;     // Catch: Throwable -> L93 JSONException -> L95
        a(r110, 0);     // Catch: Throwable -> L93 JSONException -> L95
        com.xiaomi.channel.commonutils.logger.b.m8718a("device registration is successful. " + r129);     // Catch: Throwable -> L93 JSONException -> L95
        monitor-exit(q.class);
        return r132;
    L90:
        r123 = r120;
        t.a(r110, JSONObjectProtectorUtils.getInt(r125, "code"), r125.optString("description"));     // Catch: Throwable -> L93 JSONException -> L95
        com.xiaomi.channel.commonutils.logger.b.m8718a("device registration resp: " + r124);     // Catch: Throwable -> L93 JSONException -> L95
    L95:
        e = e;
    L102:
        com.xiaomi.channel.commonutils.logger.b.d("failed to parse respone json data. " + e);     // Catch: Throwable -> L111
        r123 = r102;
    L93:
        th = th;
    L99:
        com.xiaomi.channel.commonutils.logger.b.d("unknow throwable. " + th);     // Catch: Throwable -> L111
        r123 = r102;
    L100:
        e = e;
        r102 = r120;
    L97:
        th = th;
        r102 = r120;
        goto L99
    L72:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("device registration request failed. " + e);     // Catch: Throwable -> L111
        r122 = null;
        goto L75
    L60:
        if (TextUtils.isEmpty(r118) == true) goto L63;
        com.xiaomi.channel.commonutils.logger.b.m8718a("r.data = " + r118);     // Catch: Throwable -> L111
        r120 = true;
        goto L64
    L32:
        r104 = "0";
    L27:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);     // Catch: Throwable -> L111
        r103 = null;
        goto L30
    L23:
        r115 = r111;
        goto L24
    L19:
        r114 = r210;
        goto L21
    L15:
        r113 = r112;
        goto L17
    L7:
        if (TextUtils.isEmpty(r101.f1123a) == true) goto L11;
        r100.put(ST.UUID_DEVICE, f464336a.f1123a);     // Catch: Throwable -> L111
        int r133 = f464336a.f1123a.lastIndexOf(HTTP.URL_DEFAULT);     // Catch: Throwable -> L111
        if (r133 == (-1)) goto L11;
        r102 = f464336a.f1123a.substring(r133 + 1);     // Catch: Throwable -> L111
    L111:
        th = move-exception;
        throw th;
    }
}
