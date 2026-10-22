package vta;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.dypay.utils.j;
import com.ss.android.dypay.utils.k;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SharedPreferences f557260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, b> f557261b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f557262c;

    static {
        f557261b = new LinkedHashMap();
        f557262c = true;
    }

    public static String d(String r100, String r101) {
        SharedPreferences r102 = a();
        if (r102 == null) goto L8;
        String r103 = r102.getString(r100 + r101 + "sdk_conf_info", "");
        if (r103 != null) goto L7;
        return "";
    L7:
        return r103;
    L8:
        return "";
    }

    public static SharedPreferences a() {
        if (f557260a != null) goto L12;
        WeakReference<Context> r100 = com.ss.android.dypay.base.e.f408447a;
        SharedPreferences r101 = null;
        if (r100 == null) goto L7;
        Context r102 = r100.get();
    L8:
        if (r102 == null) goto L10;
        r101 = r102.getSharedPreferences("dy_pay_settings", 0);
    L10:
        f557260a = r101;
        goto L12
    L7:
        r102 = null;
    L12:
        return f557260a;
    }

    public static b b(String r100, String r101) {
        String r102 = r100 + r101;
        b r103 = (b) ((LinkedHashMap) f557261b).get(r102);
        if (r103 != null) goto L15;
        String r104 = d(r100, r101);
        if (r104.length() != 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L17;
    L12:
        b r106 = null;
    L13:
        f557261b.put(r102, r106);
        return r106;
    L17:
        r106 = b.a.a(new JSONObject(r104));     // Catch: JSONException -> L16
    L7:
        r105 = false;
        goto L8
    L15:
        return r103;
    }

    public static void c(Context r100, e r110, boolean r111, com.ss.android.dypay.activity.f.e.C4734e r112) {
        String r101 = "";
        if (r111 == false) goto L16;
        SharedPreferences r113 = a();
        long r102 = 0;
        if (r113 == null) goto L7;
        r102 = r113.getLong(r110.f557264b + r110.f557265c + "last_update_time", 0);
    L7:
        b r114 = b(r110.f557264b, r110.f557265c);
        if (r114 == null) goto L10;
        int r115 = r114.f557250c;
    L12:
        if ((System.currentTimeMillis() - r102) >= (((long) r115) * 1000)) goto L16;
        if (r112 == null) goto L101;
        Unit r103 = (Unit) r112.invoke(Boolean.TRUE);
        return;
    L101:
        return;
    L10:
        r115 = AnnouncementViewModel.HOUR_DURATION;
    L16:
        long r104 = System.currentTimeMillis() / ((long) 1000);
        String r116 = com.ss.android.dypay.utils.c.a(r110.f557264b + r104 + "salt_dyposdk@bytedance.com");
        JSONObject r105 = new JSONObject();
        String r106 = com.ss.android.dypay.base.b.f408436a;
        JSONObject r107 = new JSONObject();
        Context r108 = null;
        r107.put("platform", "android");     // Catch: JSONException -> L58
        boolean r109 = k.f408504a;     // Catch: JSONException -> L58
        String r117 = Build.MODEL;     // Catch: JSONException -> L58
        if (r117 != null) goto L23;
        r117 = "";
    L23:
        r107.put("device_type", r117);     // Catch: JSONException -> L58
        r107.put("os_version", String.valueOf(Build.VERSION.SDK_INT));     // Catch: JSONException -> L58
        String r118 = Build.BRAND;     // Catch: JSONException -> L58
        if (r118 != null) goto L31;
        r118 = "";
    L31:
        r107.put("brand", r118);     // Catch: JSONException -> L58
        r107.put("resolution", k.b(r100).x + " x " + k.b(r100).y);     // Catch: JSONException -> L58
        r107.put("device_id", com.ss.android.dypay.base.b.a());     // Catch: JSONException -> L58
        if (k.f() == false) goto L51;
        String r119 = k.f408506c;     // Catch: JSONException -> L58
        if (r119 != null) goto L42;
    L47:
        String r120 = null;
    L48:
        if (r120 != null) goto L84;
    L83:
        r120 = "";
    L84:
        r107.put("rom_os_version", r120);     // Catch: JSONException -> L58
        r107.put("rom_version", j.b());     // Catch: JSONException -> L58
        goto L87
    L42:
        if (StringsKt.startsWith(r119, "MagicOS_", true) == true) goto L45;
        r119 = null;
    L45:
        if (r119 == null) goto L47;
        r120 = r119.substring(8);     // Catch: JSONException -> L58
        goto L48
    L51:
        if (k.c(AppConstants.CHANNEL_OPPO) == false) goto L53;
    L61:
        String r121 = k.d("ro.build.version.opporom");     // Catch: JSONException -> L58
        if (r121 != null) goto L65;
        r121 = "";
    L65:
        k.f408507d = r121;     // Catch: JSONException -> L58
        if (TextUtils.isEmpty(r121) == false) goto L72;
        String r122 = k.d("ro.build.version.oplusrom");     // Catch: JSONException -> L58
        if (r122 != null) goto L71;
        r122 = "";
    L71:
        k.f408507d = r122;     // Catch: JSONException -> L58
    L72:
        String r123 = k.f408507d;     // Catch: JSONException -> L58
        if (r123 != null) goto L75;
    L80:
        r120 = null;
    L81:
        if (r120 == null) goto L83;
    L75:
        if (StringsKt.startsWith(r123, "V", true) == true) goto L78;
        r123 = null;
    L78:
        if (r123 == null) goto L80;
        r120 = r123.substring(1);     // Catch: JSONException -> L58
        goto L81
    L53:
        if (k.e("oneplus") == false) goto L55;
    L59:
        boolean r124 = true;
    L60:
        if (r124 == false) goto L83;
    L55:
        if (k.c("oneplus") == true) goto L59;
        r124 = false;
    L87:
        r105.put("device_info", r107);
        r105.put("merchant_id", r110.f557264b);
        r105.put("app_id", r110.f557265c);
        WeakReference<Context> r125 = com.ss.android.dypay.base.e.f408447a;
        if (r125 == null) goto L90;
        r108 = r125.get();
    L90:
        if (r108 == null) goto L94;
        String r126 = r108.getPackageName();
        if (r126 == null) goto L94;
        r101 = r126;
    L94:
        r105.put("package_name", r101);
        r105.put("sdk_version", "1.0.0.lite");
        r105.put("timestamp", String.valueOf(r104));
        r105.put("sign", r116);
        r105.put(DyPayConstant.K_PAY_INFO_PARAM_PREPAYID, r110.f557266d);
        String r127 = r110.f557263a;
        if (r127 == null) goto L97;
        r105.put("scene", r127);
    L97:
        ThreadMethodProxy.start(new PthreadThreadV2(new uta.b("https://cashier.douyinpay.com/bytepay/cashdesk_conf/v1/open_sdk_conf_query", r105.toString(), new c(r110, r112, System.currentTimeMillis())), "ypay/base/j/c"));
    }
}
