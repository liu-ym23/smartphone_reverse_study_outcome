package vb4;

import android.content.Context;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdturing.BdTuringConfig;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f554014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f554015b;

    public static String a() {
        com.bytedance.bdturing.setting.e r100 = com.bytedance.bdturing.setting.e.f202077a;
        String r101 = com.bytedance.bdturing.setting.e.f("agreement_url");
        if (TextUtils.isEmpty(r101) == false) goto L6;
        r101 = "";
    L6:
        StringBuilder r102 = new StringBuilder(r101);
        r102.append("?os_type=0");
        tb4.b.a(null, r102);
        return r102.toString();
    }

    public static String b() {
        com.bytedance.bdturing.setting.e r100 = com.bytedance.bdturing.setting.e.f202077a;
        String r101 = com.bytedance.bdturing.setting.e.f("help_url");
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        StringBuilder r102 = new StringBuilder(r101);
        r102.append("?os_type=0");
        tb4.b.a(null, r102);
        return r102.toString();
    }

    public static String c() {
        com.bytedance.bdturing.setting.e r100 = com.bytedance.bdturing.setting.e.f202077a;
        String r101 = com.bytedance.bdturing.setting.e.d("auth");
        StringBuilder r102 = new StringBuilder();
        if (TextUtils.isEmpty(r101) == true) goto L11;
        if (r101.startsWith("https://") == true) goto L7;
        r102.append("https://");
    L7:
        r102.append(r101);
        if (r101.endsWith(HTTP.URL_DEFAULT) == true) goto L11;
        r102.append(HTTP.URL_DEFAULT);
    L11:
        return r102.toString();
    }

    public static boolean d() {
        Boolean r100 = f554014a;
        if (r100 != null) goto L5;
        boolean r101 = false;
        BdTuringConfig r102 = qb4.b.c.f532315a.f532302a;     // Catch: Exception -> L24
        if (r102 != null) goto L10;
    L26:
        Boolean r103 = Boolean.valueOf(r101);
        f554014a = r103;
        return r103.booleanValue();
    L10:
        if (r102.getApplicationContext() == null) goto L26;
        Context r104 = r102.getApplicationContext();     // Catch: Exception -> L24
        String r105 = "";
        if (r104 != null) goto L15;
    L20:
        r101 = !"1".equals(r105);     // Catch: Exception -> L24
        if (r101 == false) goto L26;
        hc4.e.a(r102.getApplicationContext(), "app_lunch_state");     // Catch: Exception -> L24
        goto L26
    L15:
        if (TextUtils.isEmpty("turing_live_detect_cfg") == true) goto L20;
        if (TextUtils.isEmpty("app_lunch_state") == true) goto L20;
        r105 = r104.getSharedPreferences("turing_live_detect_cfg", 0).getString("app_lunch_state", "");     // Catch: Exception -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L26
    L5:
        return r100.booleanValue();
    }

    public static boolean e() {
        com.bytedance.bdturing.setting.e r100 = com.bytedance.bdturing.setting.e.f202077a;
        String r101 = com.bytedance.bdturing.setting.e.f("cancellable");
        if (TextUtils.isEmpty(r101) == false) goto L7;
        r101 = "1";
    L7:
        return "1".equals(r101);
    }

    public static String f(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        String r101 = com.bytedance.bdturing.setting.e.f(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (TextUtils.isEmpty(r101) == false) goto L16;
    L11:
        JSONObject r102 = null;
    L12:
        if (r102 != null) goto L14;
        return null;
    L14:
        return r102.optString(r100, "").toLowerCase();
    L16:
        r102 = new JSONObject(r101);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }
}
