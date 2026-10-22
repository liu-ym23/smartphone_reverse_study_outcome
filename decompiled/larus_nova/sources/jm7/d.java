package jm7;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.ug.sdk.luckydog.task.AppActivateHelper;
import il7.o;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import ok7.i;
import org.json.JSONException;
import org.json.JSONObject;
import rk7.m;

/* JADX INFO: loaded from: classes3.dex */
@XBridgeMethod(name = "luckydogOptimizeActivation", owner = "maochangtong")
public final class d extends ok7.a {

    /* JADX INFO: loaded from: classes22.dex */
    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return "luckydogOptimizeActivation";
    }

    public d() {
    }

    public static ConcurrentHashMap f(String r100) {
        ConcurrentHashMap r101 = new ConcurrentHashMap();
        Uri r102 = UriProtector.parse(r100);     // Catch: Exception -> L45
        String r103 = "";
        if (r102 == null) goto L9;
        String r104 = UriProtector.getQueryParameter(r102, "luckydog_activity_id");     // Catch: Exception -> L45
        if (r104 == null) goto L9;
    L10:
        r101.put("luckydog_activity_id", r104);     // Catch: Exception -> L45
        if (r102 == null) goto L16;
        String r105 = UriProtector.getQueryParameter(r102, "luckydog_task_id");     // Catch: Exception -> L45
        if (r105 == null) goto L16;
    L17:
        r101.put("luckydog_task_id", r105);     // Catch: Exception -> L45
        boolean r106 = false;
        if (r102 == null) goto L23;
        Object r107 = UriProtector.getQueryParameter(r102, "luckydog_cross_ack_time");     // Catch: Exception -> L45
        if (r107 == null) goto L23;
    L24:
        r101.put("luckydog_cross_ack_time", r107.toString());     // Catch: Exception -> L45
        if (r102 == null) goto L30;
        Object r108 = UriProtector.getQueryParameter(r102, "luckydog_cross_reack_install");     // Catch: Exception -> L45
        if (r108 == null) goto L30;
    L31:
        r101.put("luckydog_cross_reack_install", r108.toString());     // Catch: Exception -> L45
        if (r102 == null) goto L37;
        String r109 = UriProtector.getQueryParameter(r102, "luckydog_from_aid");     // Catch: Exception -> L45
        if (r109 == null) goto L37;
        r103 = r109;
    L37:
        r101.put("luckydog_from_aid", r103);     // Catch: Exception -> L45
        CharSequence r110 = (CharSequence) r101.get("luckydog_from_aid");     // Catch: Exception -> L45
        if (r110 != null) goto L40;
    L41:
        r106 = true;
    L42:
        if (r106 == false) goto L47;
        Application r111 = m.f538347a;     // Catch: Exception -> L45
        r101.put("luckydog_from_aid", String.valueOf(m.f()));     // Catch: Exception -> L45
    L47:
        return r101;
    L40:
        if (r110.length() != 0) goto L42;
    L30:
        r108 = 0;     // Catch: Exception -> L45
    L23:
        r107 = 0;     // Catch: Exception -> L45
    L16:
        r105 = "";
    L9:
        r104 = "";
    L45:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("LuckydogOptimizeActivation", "getFromUrl e = " + e);
        goto L47
    }

    @Override // ok7.a
    public final void e(XReadableMap r110, i r210) {
        LinkedHashMap r100 = new LinkedHashMap();     // Catch: Exception -> L40
        String r101 = s.f(r110, "url", "");     // Catch: Exception -> L40
        String r102 = s.f(r110, "install_state", "");     // Catch: Exception -> L40
        int r111 = s.d(r110, "optimize_type", 0);     // Catch: Exception -> L40
        String r112 = s.f(r110, "pattern_token", "");     // Catch: Exception -> L40
        String r113 = s.f(r110, "to_aid", "");     // Catch: Exception -> L40
        String r114 = s.f(r110, "write_clipboard_toast", "");     // Catch: Exception -> L40
        XReadableMap r103 = s.e(r110, "log_extra");     // Catch: Exception -> L40
        String r104 = UriProtector.getQueryParameter(UriProtector.parse(r101), "luckydog_cross_token");     // Catch: Exception -> L40
        if (r104 == null) goto L6;
        String r115 = r104;
    L7:
        if (r103 == null) goto L11;
        String r105 = r103.getString("luckydog_target_app_version_code");     // Catch: Exception -> L40
        if (r105 == null) goto L11;
    L12:
        String r106 = r115;
        g(r101, r102, r111, r112, r113, r105);     // Catch: Exception -> L40
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckydogOptimizeActivation", "luckydogOptimizeActivation onCall, url: " + r101 + ",  patternToken: " + r112 + ", optimizeType: " + r111 + ", installStatus: " + r102);     // Catch: Exception -> L40
        if (r111 == 2) goto L18;
        if (r111 == 3) goto L18;
        onSuccess(r210, r100, "no need for anything");     // Catch: Exception -> L40
        return;
    L18:
        if (Intrinsics.areEqual(r102, "installed") == false) goto L23;
        AppActivateHelper.d(r113);     // Catch: Exception -> L40
        if (r111 != 3) goto L38;
        m.c(m.f538361o.e());     // Catch: Exception -> L40
    L38:
        onSuccess(r210, r100, "success");     // Catch: Exception -> L40
        return;
    L23:
        if (TextUtils.isEmpty(r106) == true) goto L25;
        AppActivateHelper.c(r113, r106);     // Catch: Exception -> L40
    L25:
        if (r111 != 3) goto L38;
        if (TextUtils.isEmpty(r112) == true) goto L38;
        m r107 = m.f538361o;     // Catch: Exception -> L40
        ik7.c r108 = m.f538353g;     // Catch: Exception -> L40
        if (r108 == null) goto L33;
        bn7.c r109 = ((dn7.c) r108).f469366a;     // Catch: Exception -> L40
        if (r109 == null) goto L33;
        boolean r116 = r109.d(r112, false);     // Catch: Exception -> L40
    L34:
        if (r116 == false) goto L38;
        if (TextUtils.isEmpty(r114) == true) goto L38;
        o.a(r107.e(), r114);     // Catch: Exception -> L40
    L33:
        r116 = false;
    L11:
        r105 = "";
        goto L12
    L6:
        r115 = "";
    L40:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("LuckydogOptimizeActivation", e.getLocalizedMessage());
        XCoreBridgeMethod.onFailure$default(this, r210, 0, "exception caught " + e.getLocalizedMessage(), null, 8, null);
    }

    public static void g(String r100, String r101, int r110, String r111, String r112, String r113) {
        JSONObject r102 = new JSONObject();
        ConcurrentHashMap r103 = f(r100);     // Catch: JSONException -> L5
        r102.put("url", r100);     // Catch: JSONException -> L5
        r102.put("install_state", r101);     // Catch: JSONException -> L5
        r102.put("optimize_type", r110);     // Catch: JSONException -> L5
        r102.put("pattern_token", r111);     // Catch: JSONException -> L5
        r102.put("luckydog_to_aid", r112);     // Catch: JSONException -> L5
        r102.put("luckydog_target_app_version_code", r113);     // Catch: JSONException -> L5
        r102.put("luckydog_activity_id", r103.get("luckydog_activity_id"));     // Catch: JSONException -> L5
        r102.put("luckydog_task_id", r103.get("luckydog_task_id"));     // Catch: JSONException -> L5
        r102.put("luckydog_cross_ack_time", r103.get("luckydog_cross_ack_time"));     // Catch: JSONException -> L5
        r102.put("luckydog_cross_reack_install", r103.get("luckydog_cross_reack_install"));     // Catch: JSONException -> L5
        r102.put("luckydog_from_aid", r103.get("luckydog_from_aid"));     // Catch: JSONException -> L5
        com.bytedance.ug.sdk.luckydog.api.log.b.a("luckydog_optimize_activation", r102);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("LuckydogOptimizeActivation", e.getLocalizedMessage());
    }
}
