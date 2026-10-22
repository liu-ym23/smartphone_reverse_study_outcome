package xu3;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static boolean c(JSONObject r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.length() == 0) goto L7;
        return false;
    }

    public static JSONObject h(JSONObject r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Iterator<String> r101 = r100.keys();
        if (r101 != null) goto L41;
        return null;
    L41:
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L37
    L9:
        if (r101.hasNext() == false) goto L36;
        String r103 = r101.next();     // Catch: Exception -> L37
        Object r104 = r100.opt(r103);     // Catch: Exception -> L37
        if ((r104 instanceof JSONObject) == true) goto L13;
        if ((r104 instanceof JSONArray) == true) goto L29;
        r102.put(r103, r104);     // Catch: Exception -> L37
        goto L9
    L29:
        JSONArray r105 = (JSONArray) r104;     // Catch: Exception -> L37
        JSONArray r106 = new JSONArray();     // Catch: Exception -> L37
        int r107 = 0;
    L31:
        if (r107 >= r105.length()) goto L33;
        r106.put(r105.get(r107));     // Catch: Exception -> L37
        r107 = r107 + 1;     // Catch: Exception -> L37
        goto L31
    L33:
        r102.put(r103, r106);     // Catch: Exception -> L37
        goto L9
    L13:
        JSONObject r108 = (JSONObject) r104;     // Catch: Exception -> L37
        if (r108 != null) goto L16;
    L15:
        r108 = null;
    L25:
        if (r108 == null) goto L9;
        r102.put(r103, r108);     // Catch: Exception -> L37
        goto L9
    L16:
        Iterator<String> r109 = r108.keys();     // Catch: Exception -> L37
        if (r109 == null) goto L15;
        JSONObject r110 = new JSONObject();     // Catch: Exception -> L38
    L21:
        if (r109.hasNext() == false) goto L24;
        String r111 = r109.next();     // Catch: Exception -> L38
        r110.put(r111, r108.opt(r111));     // Catch: Exception -> L38
    L24:
        r108 = r110;
        goto L25
    L36:
        return r102;
    L37:
        return r100;
    }

    public static JSONObject a(JSONObject r100, JSONObject r101) throws JSONException {
        if (r100 == null) goto L15;
        if (r101 == null) goto L15;
        Iterator<String> r102 = r101.keys();
        if (r102 != null) goto L10;
        return null;
    L10:
        if (r102.hasNext() == false) goto L14;
        String r103 = r102.next();
        if (r101.isNull(r103) == true) goto L10;
        r100.put(r103, r101.opt(r103));
        goto L10
    L14:
        return r100;
    L15:
        return null;
    }

    public static void b(JSONObject r100, JSONObject r101) throws JSONException {
        Iterator<String> r102 = r101.keys();
    L4:
        if (r102.hasNext() == false) goto L17;
        String[] r103 = r102.next().split("#");
        int r104 = 0;
        JSONObject r105 = r100;
    L7:
        if (r104 >= (r103.length - 1)) goto L15;
        if (r105.has(r103[r104]) == false) goto L14;
        if (r105.get(r103[r104]).getClass().equals(JSONObject.class) == false) goto L14;
        r105 = JSONObjectProtectorUtils.getJSONObject(r105, r103[r104]);
        r104 = r104 + 1;
    L14:
        r105 = null;
    L15:
        if (r105 == null) goto L4;
        r105.remove(r103[r103.length - 1]);
        goto L4
    }

    public static void d(JSONObject r100, JSONObject r101) throws JSONException {
        Iterator<String> r102 = r101.keys();
    L4:
        if (r102.hasNext() == false) goto L15;
        String r103 = r102.next();
        String[] r104 = r103.split("#");
        int r105 = 0;
        JSONObject r106 = r100;
    L7:
        if (r105 >= (r104.length - 1)) goto L14;
        if (r106.has(r104[r105]) == true) goto L11;
    L12:
        r106.put(r104[r105], new JSONObject());
    L13:
        r106 = JSONObjectProtectorUtils.getJSONObject(r106, r104[r105]);
        r105 = r105 + 1;
        goto L7
    L11:
        if (r106.get(r104[r105]).getClass().equals(JSONObject.class) == true) goto L13;
    L14:
        r106.put(r104[r104.length - 1], r101.get(r103));
        goto L4
    }

    public static int e(JSONObject r100, String r101) {
    L8:
        e = move-exception;
        av3.b.c("JsonUtils", "removeInt", e);
        return 0;
    L4:
        if (r100.has(r101) == true) goto L6;
        return 0;
    L6:
        int r102 = JSONObjectProtectorUtils.getInt(r100, r101);     // Catch: Exception -> L8
        r100.remove(r101);     // Catch: Exception -> L8
        return r102;
    }

    public static long f(JSONObject r100, String r101) {
    L8:
        e = move-exception;
        av3.b.c("JsonUtils", "removeLong", e);
        return 0;
    L4:
        if (r100.has(r101) == true) goto L6;
        return 0;
    L6:
        long r102 = JSONObjectProtectorUtils.getLong(r100, r101);     // Catch: Exception -> L8
        r100.remove(r101);     // Catch: Exception -> L8
        return r102;
    }

    public static String g(JSONObject r100, String r101) {
    L8:
        e = move-exception;
        av3.b.c("JsonUtils", "removeString", e);
        return null;
    L4:
        if (r100.has(r101) == true) goto L6;
        return null;
    L6:
        String r102 = JSONObjectProtectorUtils.getString(r100, r101);     // Catch: Exception -> L8
        r100.remove(r101);     // Catch: Exception -> L8
        return r102;
    }
}
