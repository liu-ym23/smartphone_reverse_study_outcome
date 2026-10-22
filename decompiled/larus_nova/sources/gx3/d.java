package gx3;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.applog.log.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static void a(c r110, JSONArray r210) {
        JSONArray r100 = r210;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r210.length() <= 0) goto L149;
        r110.f483097c = r100;
        int r101 = 0;
    L113:
        if (r101 >= r210.length()) goto L150;
        JSONObject r102 = r100.optJSONObject(r101);     // Catch: Throwable -> L110
        if (r102 == null) goto L109;
        int r103 = r102.optInt("sampling_rate");     // Catch: Throwable -> L110
        if (r103 >= 10000) goto L109;
        int r104 = r102.optInt("sampling_method");     // Catch: Throwable -> L110
        HashSet r105 = new HashSet();     // Catch: Throwable -> L110
        JSONArray r106 = r102.optJSONArray("events");     // Catch: Throwable -> L110
        if (r106 != null) goto L17;
    L25:
        HashMap r107 = new HashMap();     // Catch: Throwable -> L110
        JSONObject r108 = r102.optJSONObject("param_keys");     // Catch: Throwable -> L110
        if (r108 == null) goto L57;
        Iterator<String> r111 = r108.keys();     // Catch: Throwable -> L110
    L29:
        if (r111.hasNext() == false) goto L57;
        String r112 = r111.next();     // Catch: Throwable -> L110
        if (TextUtils.isEmpty(r112) == true) goto L29;
        JSONArray r113 = r108.optJSONArray(r112);     // Catch: Throwable -> L110
        if (r113 != null) goto L36;
    L55:
        JSONObject r114 = r108;
    L56:
        r108 = r114;
        goto L29
    L36:
        if (r113.length() <= 0) goto L55;
        ArrayList r115 = new ArrayList();     // Catch: Throwable -> L110
        int r116 = 0;
    L39:
        if (r116 >= r113.length()) goto L54;
        JSONArray r117 = r113.optJSONArray(r116);     // Catch: Throwable -> L110
        if (r117 == null) goto L53;
        if (r117.length() <= 0) goto L53;
        HashSet r109 = new HashSet();     // Catch: Throwable -> L110
        int r118 = 0;
    L46:
        if (r118 >= r117.length()) goto L51;
        String r119 = r117.optString(r118);     // Catch: Throwable -> L110
        if (TextUtils.isEmpty(r119) == true) goto L50;
        r109.add(r119);     // Catch: Throwable -> L110
    L50:
        r118 = r118 + 1;     // Catch: Throwable -> L110
        goto L46
    L51:
        r115.add(r109);     // Catch: Throwable -> L110
    L53:
        r116 = r116 + 1;     // Catch: Throwable -> L110
        r108 = r108;
        goto L39
    L54:
        r114 = r108;
        r107.put(r112, r115);     // Catch: Throwable -> L110
    L57:
        HashMap r120 = new HashMap();     // Catch: Throwable -> L110
        JSONObject r121 = r102.optJSONObject("param_key_values");     // Catch: Throwable -> L110
        if (r121 == null) goto L91;
        Iterator<String> r122 = r121.keys();     // Catch: Throwable -> L110
    L61:
        if (r122.hasNext() == false) goto L91;
        String r123 = r122.next();     // Catch: Throwable -> L110
        if (TextUtils.isEmpty(r123) == true) goto L61;
        JSONArray r124 = r121.optJSONArray(r123);     // Catch: Throwable -> L110
        if (r124 != null) goto L68;
    L88:
        JSONObject r125 = r121;
        Iterator<String> r126 = r122;
    L89:
        r122 = r126;
        r121 = r125;
        goto L61
    L68:
        if (r124.length() <= 0) goto L88;
        ArrayList r127 = new ArrayList();     // Catch: Throwable -> L110
        int r128 = 0;
    L71:
        if (r128 >= r124.length()) goto L87;
        JSONObject r129 = r124.optJSONObject(r128);     // Catch: Throwable -> L110
        if (r129 == null) goto L85;
        HashMap r130 = new HashMap();     // Catch: Throwable -> L110
        Iterator<String> r131 = r129.keys();     // Catch: Throwable -> L110
    L76:
        if (r131.hasNext() == false) goto L84;
        JSONObject r132 = r121;
        String r133 = r131.next();     // Catch: Throwable -> L110
        if (TextUtils.isEmpty(r133) == true) goto L82;
        Iterator<String> r134 = r122;
        Object r135 = r129.opt(r133);     // Catch: Throwable -> L110
        if (r135 == null) goto L83;
        r130.put(r133, r135);     // Catch: Throwable -> L110
    L83:
        r122 = r134;
        r121 = r132;
        goto L76
    L82:
        r134 = r122;
        goto L83
    L84:
        JSONObject r136 = r121;
        Iterator<String> r137 = r122;
        r127.add(r130);     // Catch: Throwable -> L110
    L86:
        r128 = r128 + 1;     // Catch: Throwable -> L110
        r122 = r137;
        r121 = r136;
        goto L71
    L85:
        r136 = r121;
        r137 = r122;
        goto L86
    L87:
        r125 = r121;
        r126 = r122;
        r120.put(r123, r127);     // Catch: Throwable -> L110
    L91:
        if (r104 != 1) goto L93;
        a r138 = new g(r103, r105, r107, r120);     // Catch: Throwable -> L110
    L106:
        a r139 = r138;
    L107:
        if (r139 == null) goto L109;
        ((ArrayList) r110.f483099e).add(r139);     // Catch: Throwable -> L110
        goto L109
    L93:
        if (r104 != 2) goto L95;
        r138 = new e(r103, r105, r107, r120);     // Catch: Throwable -> L110
        goto L106
    L95:
        if (r104 != 3) goto L97;
        r138 = new f(r103, r105, r107, r120);     // Catch: Throwable -> L110
        goto L106
    L97:
        if (r104 != 4) goto L99;
        r138 = new h(r103, r105, r107, r120);     // Catch: Throwable -> L110
        goto L106
    L99:
        if (r104 == 6) goto L101;
        r139 = null;
        goto L107
    L101:
        r138 = new i(r103, r105, r107, r120);     // Catch: Throwable -> L110
        goto L106
    L17:
        if (r106.length() <= 0) goto L25;
        int r140 = 0;
    L20:
        if (r140 >= r106.length()) goto L25;
        String r141 = r106.optString(r140);     // Catch: Throwable -> L110
        if (TextUtils.isEmpty(r141) == true) goto L24;
        r105.add(r141);     // Catch: Throwable -> L110
    L24:
        r140 = r140 + 1;     // Catch: Throwable -> L110
    L109:
        r101 = r101 + 1;
        r100 = r210;
        goto L113
    L150:
        return;
    L110:
        th = move-exception;
        n.w().o(12, "loadSamplingMapFromJsonArray error", th, new Object[0]);
        return;
    }

    public static c c(Context r100, String r101) {
        c r102 = new c();
        if (TextUtils.isEmpty(r101) == false) goto L5;
        r101 = "sampling_list";
    L5:
        SharedPreferences r103 = r100.getSharedPreferences(r101, 0);
        r102.f483095a = r103.getInt("version", 0);
        r102.f483096b = r103.getInt("capability", 0);
        String r104 = r103.getString("config_ids", null);
        if (TextUtils.isEmpty(r104) == false) goto L18;
    L11:
        String r105 = r103.getString("samplings", null);
        if (TextUtils.isEmpty(r105) == false) goto L20;
    L17:
        return r102;
    L20:
        a(r102, new JSONArray(r105));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        n.w().o(12, "parseEventSamplingFromLocal sampling config", th, new Object[0]);
        goto L17
    L18:
        r102.f483098d = new JSONArray(r104);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        n.w().o(12, "parseEventSamplingFromLocal config ids error", th, new Object[0]);
        goto L11
    }

    public static c b(Context r100, String r101, JSONObject r102, c r103) {
        if (r102 != null) goto L20;
        return r103;
    L20:
        c r104 = new c();     // Catch: Throwable -> L17
        r104.f483095a = r102.optInt("event_sampling_version", 0);     // Catch: Throwable -> L17
        r104.f483096b = r102.optInt("capability", 0);     // Catch: Throwable -> L17
        r104.f483098d = r102.optJSONArray("config_ids");     // Catch: Throwable -> L17
        JSONArray r105 = r102.optJSONArray("samplings");     // Catch: Throwable -> L17
        a(r104, r105);     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r101) == false) goto L9;
        r101 = "sampling_list";
    L9:
        SharedPreferences.Editor r106 = r100.getSharedPreferences(r101, 0).edit();     // Catch: Throwable -> L17
        r106.putInt("capability", r104.f483096b);     // Catch: Throwable -> L17
        r106.putInt("version", r104.f483095a);     // Catch: Throwable -> L17
        if (r105 == null) goto L12;
        r106.putString("samplings", r105.toString());     // Catch: Throwable -> L17
    L12:
        JSONArray r107 = r104.f483098d;     // Catch: Throwable -> L17
        if (r107 == null) goto L15;
        r106.putString("config_ids", r107.toString());     // Catch: Throwable -> L17
    L15:
        r106.apply();     // Catch: Throwable -> L17
        return r104;
    L17:
        th = move-exception;
        n.w().o(12, "parseEventSamplingFromServer", th, new Object[0]);
        return r103;
    }
}
