package r1;

import android.text.TextUtils;
import com.apm.lite.runtime.ConfigManager;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JSONObject f535565a;

    static {
        f535565a = new JSONObject();
    }

    public static boolean a(ConfigManager.b r100) {
        JSONObject r101 = f535565a;
        if (r101 != null) goto L5;
        return false;
    L5:
        JSONObject r102 = r101.optJSONObject("java_crash_ignore");
        if (r102 != null) goto L9;
        return false;
    L9:
        if (b(r102.optJSONArray("disable"), r100) == false) goto L12;
        return false;
    L12:
        return b(r102.optJSONArray("enable"), r100);
    }

    public static boolean b(JSONArray r100, f r101) {
        if (com.apm.lite.k.k.c(r100) == false) goto L5;
        return false;
    L5:
        int r102 = 0;
    L7:
        if (r102 >= r100.length()) goto L16;
        JSONObject r103 = r100.optJSONObject(r102);
        if (r103 != null) goto L12;
        com.apm.lite.c.a();
        new IllegalArgumentException("err config: " + r100);
    L15:
        r102 = r102 + 1;
        goto L7
    L12:
        if (d(r103, r101) == false) goto L15;
        return true;
    L16:
        return false;
    }

    public static boolean c(JSONObject r100, Object r101) {
        JSONArray r102 = r100.optJSONArray("values");
        if (r102.length() != 0) goto L5;
        return false;
    L5:
        String r103 = r100.optString("op");
        String r104 = String.valueOf(r101);
        if (r103.equals(ContainerUtils.KEY_VALUE_DELIMITER) == false) goto L10;
        return r104.equals(String.valueOf(r102.opt(0)));
    L10:
        if (r103.equals("in") == false) goto L19;
        int r105 = 0;
    L13:
        if (r105 >= r102.length()) goto L19;
        if (String.valueOf(r102.opt(r105)).equals(r104) == true) goto L16;
        r105 = r105 + 1;
        goto L13
    L16:
        return true;
    L19:
        return false;
    }

    public static boolean d(JSONObject r100, f r101) {
        Iterator<String> r102 = r100.keys();
        boolean r103 = false;
    L4:
        if (r102.hasNext() == false) goto L21;
        String r104 = r102.next();
        if (TextUtils.isEmpty(r104) == true) goto L4;
        if (r104.startsWith("header_") == false) goto L14;
        if (c(r100.optJSONObject(r104), r101.b(r104.substring(7))) == false) goto L17;
    L20:
        r103 = true;
    L17:
        com.apm.lite.k.p.a("not match ".concat(r104));
        return false;
    L14:
        if (r104.startsWith("java_") == true) goto L16;
        com.apm.lite.k.p.a("no rules match ".concat(r104));
        goto L20
    L16:
        if (c(r100.optJSONObject(r104), r101.a(r104.substring(5))) == true) goto L20;
    L21:
        return r103;
    }

    public static JSONObject e(JSONObject r110) {
        Iterator<String> r100 = r110.keys();
        f r101 = new f();
        JSONObject r102 = new JSONObject();
    L4:
        if (r100.hasNext() == false) goto L34;
        String r103 = r100.next();
        if ("configType".equals(r103) == true) goto L4;
        JSONObject r104 = r110.optJSONObject(r103);
        if (r104 == null) goto L10;
        if (b(r104.optJSONArray("disable"), r101) == true) goto L13;
        JSONArray r105 = r104.optJSONArray("enable");
        JSONArray r106 = new JSONArray();
        if (com.apm.lite.k.k.c(r105) == true) goto L28;
        int r107 = 0;
    L19:
        if (r107 >= r105.length()) goto L28;
        JSONObject r108 = r105.optJSONObject(r107);
        if (r108 != null) goto L24;
        com.apm.lite.c.a();
        new IllegalArgumentException("err config: " + r105);
    L26:
        r107 = r107 + 1;
        goto L19
    L24:
        if (d(r108, r101) == false) goto L26;
        r106.put(r108);
    L28:
        if (com.apm.lite.k.k.c(r106) == true) goto L29;
        r102.put(r103, new JSONObject().put("enable", r106));     // Catch: JSONException -> L33
        goto L4
    L29:
        StringBuilder r109 = new StringBuilder("not match ");
    L30:
        r109.append(r103);
        com.apm.lite.k.p.a(r109.toString());
        goto L4
    L13:
        r109 = new StringBuilder("match diable ");
        goto L30
    L10:
        com.apm.lite.c.a();
        new IllegalArgumentException("err config with key: " + r103);
        goto L4
    L34:
        return r102;
    }
}
