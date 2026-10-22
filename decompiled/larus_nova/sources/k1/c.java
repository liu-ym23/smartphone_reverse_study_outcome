package k1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.apm.lite.e;
import com.apm.lite.k.p;
import com.apm.lite.k.s;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.general.AppInfo;
import com.bytedance.crash.general.HardwareInfo;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;
import r1.o;

/* JADX INFO: loaded from: classes39.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f501333b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f501334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f501335d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f501336e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f501337a;

    static {
        f501333b = new String[]{"version_code", "manifest_version_code", "aid", "update_version_code"};
        f501334c = null;
        f501335d = -1;
        f501336e = -1;
    }

    public c() {
        this.f501337a = new JSONObject();
    }

    public static boolean e() {
        if (f501335d != (-1)) goto L6;
        f501335d = m().contains(BDLocationException.ERROR_RESTRICTED_MODE_ON) ? 1 : 0;
    L6:
        if (f501335d == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean g() {
        if (f501336e != (-1)) goto L6;
        f501336e = m().contains(BDLocationException.ERROR_DEVICE_LOCATION_DISABLE) ? 1 : 0;
    L6:
        if (f501336e == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean k(JSONObject r100) {
        if (r100 != null) goto L4;
    L15:
        return true;
    L4:
        if (r100.length() == 0) goto L15;
        if (r100.opt("app_version") != null) goto L10;
        if (r100.opt("version_name") == null) goto L15;
    L10:
        if (r100.opt("version_code") == null) goto L15;
        if (r100.opt("update_version_code") == null) goto L15;
        return false;
    }

    public static String m() {
        if (f501334c != null) goto L21;
        StringBuilder r100 = new StringBuilder();     // Catch: Exception -> L19
        if (Build.SUPPORTED_ABIS.length <= 0) goto L13;
        int r101 = 0;
    L7:
        String[] r102 = Build.SUPPORTED_ABIS;     // Catch: Exception -> L19
        if (r101 >= r102.length) goto L15;
        r100.append(r102[r101]);     // Catch: Exception -> L19
        if (r101 == (r102.length - 1)) goto L12;
        r100.append(", ");     // Catch: Exception -> L19
    L12:
        r101 = r101 + 1;     // Catch: Exception -> L19
    L15:
        if (TextUtils.isEmpty(r100.toString()) == false) goto L17;
        f501334c = "unknown";     // Catch: Exception -> L19
    L17:
        f501334c = r100.toString();     // Catch: Exception -> L19
        goto L21
    L13:
        r100 = new StringBuilder(Build.CPU_ABI);     // Catch: Exception -> L19
    L19:
        p.c();
        f501334c = "unknown";
    L21:
        return f501334c;
    }

    public final JSONObject c(Map<String, Object> r110) {
        if (r110 == null) goto L5;
        Iterator<Map.Entry<String, Object>> r100 = r110.entrySet().iterator();     // Catch: Throwable -> L34
    L8:
        if (r100.hasNext() == false) goto L12;
        Map.Entry<String, Object> r101 = r100.next();     // Catch: Throwable -> L34
        if (this.f501337a.has(r101.getKey()) == true) goto L8;
        this.f501337a.put(r101.getKey(), r101.getValue());     // Catch: Throwable -> L34
        goto L8
    L12:
        String[] r102 = f501333b;     // Catch: Throwable -> L34
        int r103 = r102.length;     // Catch: Throwable -> L34
        int r104 = 0;
    L13:
        if (r104 >= r103) goto L21;
        String r105 = r102[r104];     // Catch: Throwable -> L34
        if (r110.containsKey(r105) == false) goto L19;
        int r106 = CastIntegerProtector.parseInt(String.valueOf(r110.get(r105)));     // Catch: Throwable -> L18
        this.f501337a.put(r105, r106);     // Catch: Throwable -> L18
    L18:
        this.f501337a.put(r105, r110.get(r105));     // Catch: Throwable -> L34
    L19:
        r104 = r104 + 1;     // Catch: Throwable -> L34
        goto L13
    L21:
        if (r110.containsKey("version_code") == false) goto L26;
        if (r110.containsKey("manifest_version_code") == true) goto L26;
        int r107 = CastIntegerProtector.parseInt(String.valueOf(r110.get("version_code")));     // Catch: Throwable -> L33
        this.f501337a.put("manifest_version_code", r107);     // Catch: Throwable -> L33
    L26:
        if (r110.containsKey(WsConstants.KEY_INSTALL_ID) == false) goto L29;
        this.f501337a.put("udid", r110.get(WsConstants.KEY_INSTALL_ID));     // Catch: Throwable -> L34
        this.f501337a.remove(WsConstants.KEY_INSTALL_ID);     // Catch: Throwable -> L34
    L29:
        if (r110.containsKey("version_name") == false) goto L32;
        this.f501337a.put("app_version", r110.get("version_name"));     // Catch: Throwable -> L34
        this.f501337a.remove("version_name");     // Catch: Throwable -> L34
        goto L32
    L5:
        return this.f501337a;
    L32:
        return this.f501337a;
    }

    public final void h(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<String> r101 = r100.keys();
    L6:
        if (r101.hasNext() == false) goto L12;
        String r102 = r101.next();
        this.f501337a.put(r102, r100.opt(r102));     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    public final void i() {
        c(e.b().b());
    }

    public final void j() {
        this.f501337a.put("device_id", e.d().a());     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static c a() {
        c r100 = new c();
        JSONObject r101 = r100.f501337a;
        r101.put("sdk_version", 290);     // Catch: Exception -> L5
        r101.put(AppInfo.KEY_NPTH_VERSION_NAME, "0.0.2");     // Catch: Exception -> L5
    L4:
        return r100;
    }

    public final void l() {
        r1.d r100 = e.b();     // Catch: JSONException -> L11
        r100.getClass();     // Catch: JSONException -> L11
        long r101 = r100.f535555b.getUserId();     // Catch: Throwable -> L6
    L8:
        if (r101 <= 0) goto L18;
        this.f501337a.put("user_id", r101);     // Catch: JSONException -> L11
        return;
    L18:
        return;
    L6:
        r101 = 0;
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    public static c b(long r100) {
        o r101 = o.b();
        if (r100 != 0) goto L5;
        r100 = System.currentTimeMillis();
    L5:
        JSONObject r102 = r101.a(r100);
        if (r102 != null) goto L8;
    L11:
        Context r103 = e.f29909a;
        c r104 = a();
        r104.i();
        r104.f501337a.put("errHeader", 1);     // Catch: Throwable -> L15
    L13:
        f(r104);
        r104.h(r102);
        return r104;
    L8:
        if (r102.length() == 0) goto L11;
        Context r105 = e.f29909a;
        r104 = new c();
        goto L13
    }

    public static void d(c r100) {
        JSONObject r101 = r100.f501337a;
        r101.put("access", com.apm.lite.k.o.a(e.f29909a));     // Catch: JSONException -> L5
    L19:
        TelephonyManager r102 = (TelephonyManager) e.f29909a.getSystemService("phone");     // Catch: Exception -> L16
        if (r102 == null) goto L23;
        String r103 = r102.getNetworkOperatorName();     // Catch: Exception -> L16
        if (TextUtils.isEmpty(r103) == true) goto L12;
        r101.put(Constants.OperatorKey.KEY_CARRIER, r103);     // Catch: Exception -> L16
    L12:
        String r104 = r102.getNetworkOperator();     // Catch: Exception -> L16
        if (TextUtils.isEmpty(r104) == true) goto L24;
        r101.put("mcc_mnc", r104);     // Catch: Exception -> L16
        return;
    L24:
        return;
    L23:
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public static void f(c r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        JSONObject r101 = r100.f501337a;
        if (r101 == null) goto L90;
        StringBuilder r102 = new StringBuilder();
        if (com.apm.lite.k.e.e() == false) goto L12;
        String r103 = "MIUI-";
    L26:
        r102.append(r103);     // Catch: Throwable -> L78
    L27:
        r102.append(Build.VERSION.INCREMENTAL);     // Catch: Throwable -> L78
        if (r102.length() <= 0) goto L30;
        r101.put("rom", r102.toString());     // Catch: Throwable -> L78
    L30:
        r101.put("rom_version", s.a());     // Catch: Throwable -> L78
        goto L87
    L12:
        if (Build.DISPLAY.contains("Flyme") == false) goto L14;
    L17:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L20;
        r103 = "FLYME-";
        goto L26
    L20:
        String r105 = com.apm.lite.k.e.b();     // Catch: Throwable -> L78
        if (com.apm.lite.k.e.c(r105) == false) goto L24;
        r102.append("EMUI-");     // Catch: Throwable -> L78
    L24:
        if (TextUtils.isEmpty(r105) == true) goto L27;
        r102.append(r105);     // Catch: Throwable -> L78
        r103 = "-";
        goto L26
    L14:
        if (Build.USER.equals("flyme") == true) goto L17;
        r104 = false;
    L87:
        Resources r106 = e.f29909a.getResources();     // Catch: Exception -> L79
        DisplayMetrics r107 = WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics());     // Catch: Exception -> L79
        int r108 = r107.densityDpi;     // Catch: Exception -> L79
        if (r108 != 120) goto L34;
        String r109 = "ldpi";
    L41:
        r101.put(HardwareInfo.KEY_HW_DENSITY_DPI, r108);     // Catch: Exception -> L79
        r101.put(HardwareInfo.KEY_HW_DISPLAY_DENSITY, r109);     // Catch: Exception -> L79
        r101.put("resolution", r107.heightPixels + "x" + r107.widthPixels);     // Catch: Exception -> L79
        goto L83
    L34:
        if (r108 != 240) goto L36;
        r109 = "hdpi";
        goto L41
    L36:
        if (r108 == 320) goto L38;
        r109 = "mdpi";
        goto L41
    L38:
        r109 = "xhdpi";
    L83:
        String r110 = e.f29909a.getResources().getConfiguration().locale.getLanguage();     // Catch: Exception -> L80
        if (TextUtils.isEmpty(r110) == true) goto L45;
        r101.put("language", r110);     // Catch: Exception -> L80
    L45:
        String r111 = Locale.getDefault().getCountry();     // Catch: Exception -> L80
        if (TextUtils.isEmpty(r111) == true) goto L48;
        r101.put(EffectConfiguration.KEY_REGION, r111);     // Catch: Exception -> L80
    L48:
        int r112 = TimeZone.getDefault().getRawOffset() / BaseConstants.Time.HOUR;     // Catch: Exception -> L80
        if (r112 >= (-12)) goto L52;
        r112 = -12;
    L52:
        if (r112 <= 12) goto L54;
        r112 = 12;
    L54:
        r101.put("timezone", r112);     // Catch: Exception -> L80
    L85:
        r101.put("os", "Android");     // Catch: Throwable -> L75
        r101.put("device_id", e.d().a());     // Catch: Throwable -> L75
        String r113 = Build.VERSION.RELEASE;     // Catch: Throwable -> L75
        if (r113.contains(".") == true) goto L59;
        r113 = r113.concat(".0");     // Catch: Throwable -> L75
    L59:
        r101.put("os_version", r113);     // Catch: Throwable -> L75
        r101.put("os_api", Build.VERSION.SDK_INT);     // Catch: Throwable -> L75
        String r114 = Build.MODEL;     // Catch: Throwable -> L75
        String r115 = Build.BRAND;     // Catch: Throwable -> L75
        if (r114 != null) goto L62;
        r114 = r115;
    L66:
        r101.put("device_model", r114);     // Catch: Throwable -> L75
        r101.put("device_brand", r115);     // Catch: Throwable -> L75
        r101.put("device_manufacturer", Build.MANUFACTURER);     // Catch: Throwable -> L75
        r101.put(HardwareInfo.KEY_HW_CPU_ABI, m());     // Catch: Throwable -> L75
        Context r116 = e.f29909a;     // Catch: Throwable -> L75
        String r117 = r116.getPackageName();     // Catch: Throwable -> L75
        r101.put("package", r117);     // Catch: Throwable -> L75
        PackageInfo r118 = r116.getPackageManager().getPackageInfo(r117, 0);     // Catch: Throwable -> L75
        ApplicationInfo r119 = r118.applicationInfo;     // Catch: Throwable -> L75
        if (r119 == null) goto L89;
        int r120 = r119.labelRes;     // Catch: Throwable -> L75
        if (r120 <= 0) goto L72;
        CharSequence r121 = r116.getString(r120);     // Catch: Throwable -> L75
    L73:
        r101.put(IGoogleService.ResponseKey.DISPLAY_NAME, r121);     // Catch: Throwable -> L75
        return;
    L72:
        r121 = r116.getPackageManager().getApplicationLabel(r118.applicationInfo);     // Catch: Throwable -> L75
        goto L73
    L89:
        return;
    L62:
        if (r115 == null) goto L66;
        if (r114.contains(r115) == true) goto L66;
        r114 = r115 + ' ' + r114;     // Catch: Throwable -> L75
    L75:
        th = move-exception;
        th.printStackTrace();
        return;
    }
}
