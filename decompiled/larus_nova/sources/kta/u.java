package kta;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.crash.general.HardwareInfo;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f506137a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static eta.b f506138b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f506139c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f506140d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f506141e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f506142f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f506143g = "2.15.0";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f506144h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile JSONObject f506145i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f506146j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f506147k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f506148l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Object f506149m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static lta.e f506150n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static j f506151o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f506152p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static String f506153q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static volatile boolean f506154r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static volatile boolean f506155s;

    static {
        f506144h = new ConcurrentHashMap();
        f506149m = new Object();
        f506152p = false;
        f506155s = true;
    }

    public static int e() {
        if (f506140d > 0) goto L8;
        eta.b r100 = f506138b;
        if (r100 == null) goto L8;
        f506140d = r100.getVersionCode();
    L8:
        return f506140d;
    }

    public static void b(JSONObject r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if ((!f506152p) == true) goto L13;
        r100.remove("sim_serial_number");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static String c(Context r100) {
        if (TextUtils.isEmpty(f506137a) == false) goto L5;
        eta.b r101 = f506138b;
        if (r101 != null) goto L9;
        Bundle r102 = r100.getPackageManager().getApplicationInfo(r100.getPackageName(), 128).metaData;     // Catch: Throwable -> L14
        if (r102 == null) goto L20;
        f506137a = r102.getString("UMENG_CHANNEL");     // Catch: Throwable -> L14
        return null;
    L20:
        return null;
    L14:
        th = move-exception;
        th.printStackTrace();
        return null;
    L9:
        return r101.getTweakedChannel();
    L5:
        return f506137a;
    }

    public static void f(Throwable r100) {
        eta.b r101 = f506138b;
        if (r101 != null) goto L5;
        return;
    L5:
        j r102 = f506151o;
        r101.getContext();
        if (r102 == null) goto L18;
        String r103 = Log.getStackTraceString(r100);
        if (StringUtils.isEmpty(r103) == true) goto L19;
        JSONObject r104 = new JSONObject();
        r104.put("stack", r103);     // Catch: JSONException -> L12
    L14:
        AppLogNewUtils.onEventV3("device_register", r104);
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L19:
        return;
    }

    public static void a(JSONObject r100, JSONObject r101) {
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L10;
        String r103 = r102.next();
        r101.put(r103, r100.opt(r103));     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    }

    public static void g(Context r100, JSONObject r101) {
        if (StringUtils.isEmpty(f506146j) == false) goto L20;
        if (r100 == null) goto L20;
        PackageInfo r102 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 64);     // Catch: Exception -> L18
        if (r102 == null) goto L16;
        Signature[] r103 = r102.signatures;     // Catch: Exception -> L18
        if (r103 == null) goto L16;
        if (r103.length < 1) goto L16;
        Signature r104 = r103[0];     // Catch: Exception -> L18
        if (r104 != null) goto L15;
        String r105 = f506146j;     // Catch: Exception -> L18
    L21:
        if (r105 == null) goto L30;
        r101.put("sig_hash", r105);     // Catch: JSONException -> L24
        return;
    L24:
        e = move-exception;
        e.printStackTrace();
        return;
    L30:
        return;
    L15:
        f506146j = DigestUtils.md5Hex(r104.toByteArray());     // Catch: Exception -> L18
    L16:
        r105 = f506146j;     // Catch: Exception -> L18
    L18:
        e = move-exception;
        ita.j.c("RegistrationHeaderHelperfailed to inst package sianature: ", e);
    L20:
        r105 = f506146j;
        goto L21
    }

    public static boolean d(Context r110, JSONObject r111, boolean r112) {
        HashMap r100 = new HashMap();
        Object r101 = f506149m;
        monitor-enter(r101);
    L280:
        th = move-exception;
        throw th;
    L5:
        if (f506145i != null) goto L7;
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L280
        boolean r102 = jta.g.f500372f;
        JSONObject r103 = new JSONObject();
        boolean r104 = false;
        String r105 = r110.getPackageName();     // Catch: Exception -> L277
        Bundle r106 = r110.getPackageManager().getApplicationInfo(r105, 128).metaData;     // Catch: Exception -> L30
        String r107 = f506137a;     // Catch: Exception -> L30
        if (r107 == null) goto L20;
        if (r107.length() <= 0) goto L20;
        r100.put("channel", f506137a);     // Catch: Exception -> L30
    L25:
        if (r106 == null) goto L33;
        if (TextUtils.isEmpty("UMENG_APPKEY") == true) goto L33;
        r100.put("appkey", r106.getString("UMENG_APPKEY"));     // Catch: Exception -> L30
    L33:
        if (TextUtils.isEmpty(null) == true) goto L35;
        r100.put("package", null);     // Catch: Exception -> L277
        Bundle r108 = new Bundle();     // Catch: Exception -> L277
        r108.putString("real_package_name", r110.getPackageName());     // Catch: Exception -> L277
        jta.g.f500376j.s(r108);     // Catch: Exception -> L277
    L36:
        eta.b r109 = f506138b;     // Catch: Exception -> L277
        if (r109 == null) goto L40;
        f506139c = r109.getVersion();     // Catch: Exception -> L277
    L40:
        if (StringUtils.isEmpty(null) == true) goto L42;
        f506139c = null;     // Catch: Exception -> L277
    L42:
        r100.put("app_version", f506139c);     // Catch: Exception -> L277
        eta.b r113 = f506138b;     // Catch: Exception -> L277
        if (r113 == null) goto L45;
        f506140d = r113.getVersionCode();     // Catch: Exception -> L277
    L45:
        ApplicationInfo r114 = r110.getPackageManager().getPackageInfo(r105, 0).applicationInfo;     // Catch: Exception -> L277
        if (r114 == null) goto L50;
        int r115 = r114.labelRes;     // Catch: Exception -> L277
        if (r115 <= 0) goto L50;
        r103.put(IGoogleService.ResponseKey.DISPLAY_NAME, r110.getString(r115));     // Catch: Exception -> L277
    L50:
        eta.b r116 = f506138b;     // Catch: Exception -> L277
        if (r116 == null) goto L62;
        int r117 = r116.getUpdateVersionCode();     // Catch: Exception -> L277
        if (r117 <= 0) goto L55;
        r103.put("update_version_code", r117);     // Catch: Exception -> L277
    L55:
        int r118 = f506138b.getManifestVersionCode();     // Catch: Exception -> L277
        if (r118 <= 0) goto L58;
        r103.put("manifest_version_code", r118);     // Catch: Exception -> L277
    L58:
        jta.g r119 = jta.g.f500367a;     // Catch: Exception -> L277
        if (TextUtils.isEmpty("") == true) goto L61;
        r103.put("app_version_minor", "");     // Catch: Exception -> L277
        goto L62
    L61:
        r103.put("app_version_minor", "");     // Catch: Exception -> L277
    L62:
        String[] r120 = {"channel", "appkey", "package", "app_version"};
    L83:
        e = move-exception;
        f(e);
    L308:
        Resources r121 = r110.getResources();     // Catch: Exception -> L97
        DisplayMetrics r122 = WindowDisplayMetricsOverride.apply(r121, r121.getDisplayMetrics());     // Catch: Exception -> L97
        int r123 = r122.densityDpi;     // Catch: Exception -> L97
        r103.put(HardwareInfo.KEY_HW_DENSITY_DPI, r123);     // Catch: Exception -> L97
        if (r123 != 120) goto L88;
        String r124 = "ldpi";
    L95:
        r103.put(HardwareInfo.KEY_HW_DISPLAY_DENSITY, r124);     // Catch: Exception -> L97
        r103.put("resolution", r122.heightPixels + "x" + r122.widthPixels);     // Catch: Exception -> L97
    L99:
        SharedPreferences r125 = r110.getSharedPreferences(b.f506097a, 0);
        String r126 = r110.getResources().getConfiguration().locale.getLanguage();     // Catch: Exception -> L113
        if (StringUtils.isEmpty(r126) == true) goto L103;
        r103.put("language", r126);     // Catch: Exception -> L113
    L103:
        float r127 = (TimeZone.getDefault().getRawOffset() * 1.0f) / 3600000.0f;     // Catch: Exception -> L113
        if (r127 >= (-12.0f)) goto L107;
        r127 = -12.0f;
    L107:
        if (r127 <= 12.0f) goto L109;
        r127 = 12.0f;
    L109:
        r103.put("timezone", r127);     // Catch: Exception -> L113
        String r128 = NetworkUtils.getNetworkAccessType(r110);     // Catch: Exception -> L113
        if (r128 == null) goto L286;
        r103.put("access", r128);     // Catch: Exception -> L113
    L286:
        ConcurrentHashMap<String, Object> r129 = f506144h;     // Catch: Exception -> L126
        if (r129.isEmpty() == true) goto L124;
        Iterator<Map.Entry<String, Object>> r130 = r129.entrySet().iterator();     // Catch: Exception -> L126
    L119:
        if (r130.hasNext() == false) goto L124;
        Map.Entry<String, Object> r131 = r130.next();     // Catch: Exception -> L126
        if (r131 == null) goto L119;
        r103.put(r131.getKey(), r131.getValue());     // Catch: Exception -> L126
    L124:
        r103.put("not_request_sender", 0);     // Catch: Exception -> L126
    L301:
        pta.c.a r132 = pta.c.f530684a;     // Catch: Exception -> L141
        if (jta.g.f500371e == false) goto L131;
        jta.g r133 = jta.g.f500367a;     // Catch: Exception -> L141
    L131:
        String r134 = ((TelephonyManager) r110.getSystemService("phone")).getNetworkOperatorName();     // Catch: Exception -> L141
        if (jta.g.f500371e == false) goto L134;
        jta.g r135 = jta.g.f500367a;     // Catch: Exception -> L141
    L134:
        String r136 = ((TelephonyManager) r110.getSystemService("phone")).getNetworkOperator();     // Catch: Exception -> L141
        if (StringUtils.isEmpty(r134) == true) goto L138;
        r103.put(Constants.OperatorKey.KEY_CARRIER, r134);     // Catch: Exception -> L141
    L138:
        if (StringUtils.isEmpty(r136) == true) goto L143;
        r103.put("mcc_mnc", r136);     // Catch: Exception -> L141
    L143:
        StringBuilder r137 = new StringBuilder();
    L175:
        th = move-exception;
        f(th);
    L312:
        String r138 = pta.d.d();     // Catch: Throwable -> L181
        if (StringUtils.isEmpty(r138) == true) goto L299;
        r103.put("rom_version", r138);     // Catch: Throwable -> L181
    L299:
        String r139 = pta.a.a(r110);     // Catch: Throwable -> L187
        if (StringUtils.isEmpty(r139) == true) goto L189;
        r103.put("cdid", r139);     // Catch: Throwable -> L187
    L189:
        g(r110, r103);
        String r140 = r125.getString(EffectConfiguration.KEY_APP_LANGUAGE, null);
        String r141 = r125.getString("app_region", null);
        if (r112 == true) goto L194;
        if (r102 == true) goto L194;
        jta.g.g(r110);     // Catch: Throwable -> L206
    L206:
        th = move-exception;
        f(th);
    L208:
        String r142 = r125.getString("app_track", "");
        f506148l = r142;
    L213:
        th = move-exception;
        f(th);
        th.printStackTrace();
    L215:
        lta.e r143 = f506150n;
        if (r143 == null) goto L237;
        String r144 = r143.c();     // Catch: Exception -> L234
        if (StringUtils.isEmpty(r144) == true) goto L220;
        r103.put("device_id", r144);     // Catch: Exception -> L234
    L220:
        if (r112 == true) goto L224;
        String r145 = f506150n.e();     // Catch: Exception -> L234
        if (StringUtils.isEmpty(r145) == true) goto L224;
        r103.put("openudid", r145);     // Catch: Exception -> L234
    L224:
        String r146 = f506150n.f510740k;     // Catch: Exception -> L234
        if (StringUtils.isEmpty(r146) == true) goto L227;
        r103.put("install_id", r146);     // Catch: Exception -> L234
    L227:
        String r147 = ((jta.a) f506150n.f510734e).b();     // Catch: Exception -> L234
        if (StringUtils.isEmpty(r147) == true) goto L230;
        r103.put("clientudid", r147);     // Catch: Exception -> L234
    L230:
        String r148 = f506150n.d();     // Catch: Exception -> L234
        if (StringUtils.isEmpty(r148) == true) goto L237;
        r103.put("klink_egdi", r148);     // Catch: Exception -> L234
    L234:
        e = move-exception;
        f(e);
        e.printStackTrace();
    L237:
        if (jta.g.g(r110) == true) goto L297;
    L292:
        pta.c.a r149 = pta.c.f530684a;     // Catch: Throwable -> L259
        String r150 = Locale.getDefault().getCountry();     // Catch: Throwable -> L259
        if (StringUtils.isEmpty(r150) == true) goto L249;
        r103.put(EffectConfiguration.KEY_REGION, r150);     // Catch: Throwable -> L259
    L249:
        String r151 = Calendar.getInstance().getTimeZone().getID();     // Catch: Throwable -> L259
        if (StringUtils.isEmpty(r151) == true) goto L252;
        r103.put("tz_name", r151);     // Catch: Throwable -> L259
    L252:
        r103.put("tz_offset", Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000);     // Catch: Throwable -> L259
        if (jta.g.f500371e == false) goto L255;
        jta.g r152 = jta.g.f500367a;     // Catch: Throwable -> L259
    L255:
        String r153 = ((TelephonyManager) r110.getSystemService("phone")).getSimCountryIso();     // Catch: Throwable -> L259
        if (StringUtils.isEmpty(r153) == true) goto L261;
        r103.put("sim_region", r153);     // Catch: Throwable -> L259
    L261:
        if (r112 == true) goto L264;
        f.d(r110, f506150n, r103, !f506152p, r102);
    L264:
        if (TextUtils.isEmpty(f506153q) == false) goto L288;
    L269:
        Object r154 = f506149m;
        monitor-enter(r154);
        f506145i = r103;     // Catch: Throwable -> L274
        f506154r = r112;     // Catch: Throwable -> L274
        a(r103, r111);     // Catch: Throwable -> L274
        monitor-exit(r154);     // Catch: Throwable -> L274
        return true;
    L274:
        th = move-exception;
        throw th;
    L288:
        r103.put("old_did", f506153q);     // Catch: JSONException -> L267
    L267:
        e = move-exception;
        e.printStackTrace();
    L259:
        th = move-exception;
        f(th);
        goto L261
    L297:
    L244:
        e = move-exception;
        e.printStackTrace();
        goto L292
    L239:
        if (pta.b.a(jta.g.d()) == false) goto L241;
    L242:
        r103.put("new_user_mode", 1);     // Catch: JSONException -> L244
        goto L292
    L241:
        if (pta.b.a(jta.g.e()) == false) goto L292;
    L210:
        if (StringUtils.isEmpty(r142) == true) goto L215;
        r103.put("app_track", new JSONObject(f506148l));     // Catch: Throwable -> L213
    L194:
        if (StringUtils.isEmpty(null) == true) goto L196;
        throw null;     // Catch: Throwable -> L206
    L196:
        if (StringUtils.isEmpty(r140) == true) goto L199;
        r103.put(EffectConfiguration.KEY_APP_LANGUAGE, r140);     // Catch: Throwable -> L206
    L199:
        if (StringUtils.isEmpty(null) == true) goto L201;
        throw null;     // Catch: Throwable -> L206
    L201:
        if (StringUtils.isEmpty(r141) == true) goto L203;
        r103.put("app_region", r141);     // Catch: Throwable -> L206
    L203:
        r125.edit();     // Catch: Throwable -> L206
    L187:
        th = move-exception;
        f(th);
        th.printStackTrace();
    L181:
        th = move-exception;
        f(th);
        th.printStackTrace();
        goto L299
    L145:
        if (ita.k.j() == false) goto L148;
        r137.append("MIUI-");     // Catch: Throwable -> L175
    L171:
        r137.append(Build.VERSION.INCREMENTAL);     // Catch: Throwable -> L175
        if (r137.length() <= 0) goto L312;
        r103.put("rom", r137.toString());     // Catch: Throwable -> L175
        goto L312
    L148:
        if (ita.k.f() == false) goto L150;
        r137.append("FLYME-");     // Catch: Throwable -> L175
        goto L171
    L150:
        String r155 = ita.k.d();     // Catch: Throwable -> L175
        pta.d.a r156 = pta.d.f530685a;     // Catch: Throwable -> L175
        if (TextUtils.isEmpty(r155) == false) goto L153;
        String r157 = ita.k.d();     // Catch: Throwable -> L175
    L155:
        if (TextUtils.isEmpty(r157) == true) goto L162;
        if (r157.toLowerCase().contains("emotionui") == false) goto L159;
    L165:
        r104 = true;
    L166:
        if (r104 == false) goto L169;
        r137.append("EMUI-");     // Catch: Throwable -> L175
    L169:
        if (TextUtils.isEmpty(r155) == true) goto L171;
        r137.append(r155);     // Catch: Throwable -> L175
        r137.append("-");     // Catch: Throwable -> L175
        goto L171
    L159:
        if (r157.toLowerCase().contains("magicui") == true) goto L165;
    L162:
        if (pta.d.j() == true) goto L165;
        if (pta.d.i() == false) goto L166;
    L153:
        r157 = r155;
    L141:
        e = move-exception;
        f(e);
        e.printStackTrace();
    L126:
        e = move-exception;
        f(e);
        e.printStackTrace();
    L113:
        e = move-exception;
        f(e);
        e.printStackTrace();
        goto L286
    L88:
        if (r123 != 240) goto L90;
        r124 = "hdpi";
        goto L95
    L90:
        if (r123 == 320) goto L92;
        r124 = "mdpi";
        goto L95
    L92:
        r124 = "xhdpi";
    L97:
        e = move-exception;
        f(e);
        goto L99
    L64:
        if (f506141e != 0) goto L68;
        eta.b r158 = f506138b;     // Catch: Exception -> L83
        if (r158 == null) goto L68;
        f506141e = r158.getAid();     // Catch: Exception -> L83
    L68:
        r103.put("aid", f506141e);     // Catch: Exception -> L83
        int r159 = 0;
    L70:
        if (r159 >= 4) goto L78;
        String r160 = r120[r159];     // Catch: Exception -> L83
        String r161 = (String) r100.get(r160);     // Catch: Exception -> L83
        if (StringUtils.isEmpty(r161) == false) goto L76;
        ita.j.g("RegistrationHeaderHelper init fail empty field: " + r160, null);     // Catch: Exception -> L83
        if ("appkey".equals(r160) == true) goto L77;
        return false;
    L77:
        r159 = r159 + 1;     // Catch: Exception -> L83
        goto L70
    L76:
        r103.put(r160, r161);     // Catch: Exception -> L83
        goto L77
    L78:
        r103.put("version_code", f506140d);     // Catch: Exception -> L83
        r103.put("sdk_version", f506143g);     // Catch: Exception -> L83
        r103.put("sdk_target_version", 29);     // Catch: Exception -> L83
        r103.put("git_hash", "f023337");     // Catch: Exception -> L83
        r103.put("os", "Android");     // Catch: Exception -> L83
        r103.put("os_version", Build.VERSION.RELEASE);     // Catch: Exception -> L83
        r103.put("os_api", Build.VERSION.SDK_INT);     // Catch: Exception -> L83
        r103.put("device_model", Build.MODEL);     // Catch: Exception -> L83
        r103.put("device_brand", Build.BRAND);     // Catch: Exception -> L83
        r103.put("device_manufacturer", Build.MANUFACTURER);     // Catch: Exception -> L83
        r103.put(HardwareInfo.KEY_HW_CPU_ABI, Build.CPU_ABI);     // Catch: Exception -> L83
        String r162 = f506142f;     // Catch: Exception -> L83
        if (r162 != null) goto L81;
        r162 = "";
    L81:
        r103.put("release_build", r162);     // Catch: Exception -> L83
        goto L308
    L35:
        r100.put("package", r110.getPackageName());     // Catch: Exception -> L277
    L20:
        if (r106 == null) goto L25;
        if (TextUtils.isEmpty("UMENG_CHANNEL") == true) goto L25;
        r100.put("channel", r106.getString("UMENG_CHANNEL"));     // Catch: Exception -> L30
    L30:
        e = move-exception;
        f(e);     // Catch: Exception -> L277
        e.printStackTrace();     // Catch: Exception -> L277
    L277:
        e = move-exception;
        ita.j.c("RegistrationHeaderHelper init exception: ", e);
        f(e);
        return false;
    L7:
        if (f506154r != r112) goto L11;
        a(f506145i, r111);     // Catch: Throwable -> L280
        monitor-exit(r101);     // Catch: Throwable -> L280
        return true;
    }
}
