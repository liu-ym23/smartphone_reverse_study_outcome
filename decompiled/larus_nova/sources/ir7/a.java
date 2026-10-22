package ir7;

import android.text.TextUtils;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a {
    public static com.bytedance.webx.seclink.setting.a a(String r110) {
        com.bytedance.webx.seclink.setting.a r100 = new com.bytedance.webx.seclink.setting.a();
        JSONObject r101 = new JSONObject(r110);     // Catch: Exception -> L68
        JSONObject r111 = r101.optJSONObject("config");     // Catch: Exception -> L68
        if (r111 != null) goto L76;
    L28:
        JSONObject r112 = r101.optJSONObject("global");     // Catch: Exception -> L68
        if (r112 != null) goto L74;
    L44:
        JSONObject r113 = r101.optJSONObject(InvRouter.SCENES);     // Catch: Exception -> L68
        if (r113 != null) goto L72;
    L70:
        return r100;
    L72:
        Iterator<String> r102 = r113.keys();     // Catch: Exception -> L65
        HashMap r103 = new HashMap();     // Catch: Exception -> L65
    L48:
        if (r102.hasNext() == false) goto L63;
        String r104 = r102.next();     // Catch: Exception -> L65
        if (TextUtils.isEmpty(r104) == true) goto L48;
        JSONObject r114 = r113.optJSONObject(r104);     // Catch: Exception -> L65
        if (r114 == null) goto L48;
        com.bytedance.webx.seclink.setting.a.c r115 = new com.bytedance.webx.seclink.setting.a.c();     // Catch: Exception -> L65
        r115.f272621a = r104;     // Catch: Exception -> L65
        r115.f272624d = r114.optBoolean("use_verify_mode_v2", true);     // Catch: Exception -> L65
        r115.f272622b = r114.optBoolean("enable", true);     // Catch: Exception -> L65
        r115.f272623c = r114.optBoolean("async_mode", true);     // Catch: Exception -> L65
        JSONArray r116 = r114.optJSONArray("scheme");     // Catch: Exception -> L65
        if (r116 != null) goto L56;
    L62:
        r103.put(r104, r115);     // Catch: Exception -> L65
        goto L48
    L56:
        if (r116.length() <= 0) goto L62;
        HashSet r117 = new HashSet();     // Catch: Exception -> L65
        int r118 = 0;
    L59:
        if (r118 >= r116.length()) goto L61;
        r117.add(r116.optString(r118));     // Catch: Exception -> L65
        r118 = r118 + 1;     // Catch: Exception -> L65
        goto L59
    L61:
        r115.f272625e = r117;     // Catch: Exception -> L65
        goto L62
    L63:
        r100.f272606b = r103;     // Catch: Exception -> L65
    L65:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L68
        goto L70
    L74:
        com.bytedance.webx.seclink.setting.a.b r105 = new com.bytedance.webx.seclink.setting.a.b();     // Catch: Exception -> L42
        r105.f272617a = r112.optBoolean("enable", true);     // Catch: Exception -> L42
        r105.f272618b = r112.optBoolean("async_mode", true);     // Catch: Exception -> L42
        r105.f272619c = r112.optBoolean("use_verify_mode_v2", true);     // Catch: Exception -> L42
        JSONArray r119 = r112.optJSONArray("scheme");     // Catch: Exception -> L42
        if (r119 != null) goto L34;
    L40:
        r100.f272607c = r105;     // Catch: Exception -> L42
    L34:
        if (r119.length() <= 0) goto L40;
        HashSet r106 = new HashSet();     // Catch: Exception -> L42
        int r120 = 0;
    L37:
        if (r120 >= r119.length()) goto L39;
        r106.add(r119.optString(r120));     // Catch: Exception -> L42
        r120 = r120 + 1;     // Catch: Exception -> L42
        goto L37
    L39:
        r105.f272620d = r106;     // Catch: Exception -> L42
    L42:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L68
        goto L44
    L76:
        com.bytedance.webx.seclink.setting.a.C3815a r107 = new com.bytedance.webx.seclink.setting.a.C3815a();     // Catch: Exception -> L26
        r111.optLong("period", 8600);     // Catch: Exception -> L26
        r107.f272608a = r111.optBoolean("use_cache", true);     // Catch: Exception -> L26
        r107.f272609b = r111.optString("seclink_settings_version", "");     // Catch: Exception -> L26
        r107.f272610c = r111.optInt("error_overwhelming_count", 50);     // Catch: Exception -> L26
        r107.f272611d = r111.optLong("error_overwhelming_duration", 1800);     // Catch: Exception -> L26
        r107.f272612e = r111.optLong("safe_duration_after_overwhelming", 1800);     // Catch: Exception -> L26
        r107.f272614g = r111.optDouble("sync_check_time_limit", 1.0d);     // Catch: Exception -> L26
        r107.f272613f = r111.optBoolean("custom_settings_biz_first", true);     // Catch: Exception -> L26
        JSONArray r108 = r111.optJSONArray("settings_url_array");     // Catch: Exception -> L26
        if (r108 != null) goto L9;
    L15:
        JSONArray r121 = r111.optJSONArray("verify_host_array");     // Catch: Exception -> L26
        if (r121 != null) goto L18;
    L24:
        r100.f272605a = r107;     // Catch: Exception -> L26
    L18:
        if (r121.length() <= 0) goto L24;
        ArrayList r109 = new ArrayList();     // Catch: Exception -> L26
        int r122 = 0;
    L21:
        if (r122 >= r121.length()) goto L23;
        r109.add(r121.optString(r122));     // Catch: Exception -> L26
        r122 = r122 + 1;     // Catch: Exception -> L26
        goto L21
    L23:
        r107.f272616i = r109;     // Catch: Exception -> L26
        goto L24
    L9:
        if (r108.length() <= 0) goto L15;
        ArrayList r123 = new ArrayList();     // Catch: Exception -> L26
        int r124 = 0;
    L12:
        if (r124 >= r108.length()) goto L14;
        r123.add(r108.optString(r124));     // Catch: Exception -> L26
        r124 = r124 + 1;     // Catch: Exception -> L26
        goto L12
    L14:
        r107.f272615h = r123;     // Catch: Exception -> L26
    L26:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L68
    L68:
        e = move-exception;
        e.printStackTrace();
        goto L70
    }
}
