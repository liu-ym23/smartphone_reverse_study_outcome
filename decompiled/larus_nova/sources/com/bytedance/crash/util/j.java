package com.bytedance.crash.util;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static boolean g(JSONObject r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.length() == 0) goto L7;
        return false;
    }

    public static void a(JSONObject r100, Object... r101) {
        if (r100 != null) goto L4;
    L13:
        p.c("Err use of addKVs!!!!!");
        return;
    L4:
        if ((r101.length % 2) != 0) goto L13;
        if (r101.length == 0) goto L13;
        int r102 = 0;
    L10:
        if (r102 >= r101.length) goto L12;
        h(r100, String.valueOf(r101[r102]), r101[r102 + 1]);
        r102 = r102 + 2;
        goto L10
    }

    public static void d(JSONObject r100, JSONObject r101) {
        if (r100 == null) goto L32;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.length() <= 0) goto L57;
        Iterator<String> r102 = r101.keys();     // Catch: JSONException -> L33
    L8:
        if (r102.hasNext() == false) goto L59;
        String r103 = r102.next();     // Catch: JSONException -> L33
        Object r104 = r100.opt(r103);     // Catch: JSONException -> L33
        if (r104 == null) goto L12;
        if ((r104 instanceof JSONObject) == true) goto L15;
        if ((r104 instanceof JSONArray) == true) goto L18;
        r100.put(r103, r101.opt(r103));     // Catch: JSONException -> L33
        goto L8
    L18:
        JSONArray r105 = r101.optJSONArray(r103);     // Catch: JSONException -> L33
        if (r105 == null) goto L8;
        JSONArray r106 = (JSONArray) r104;     // Catch: JSONException -> L33
        int r107 = 0;
        if (r106.length() != 1) goto L28;
        if ((r106.opt(0) instanceof JSONObject) == false) goto L28;
        if ((r105.opt(0) instanceof JSONObject) == false) goto L28;
        d(JSONArrayProtectorUtils.getJSONObject(r106, 0), JSONArrayProtectorUtils.getJSONObject(r105, 0));     // Catch: JSONException -> L33
    L28:
        if (r107 >= r105.length()) goto L8;
        r106.put(r105.get(r107));     // Catch: JSONException -> L33
        r107 = r107 + 1;     // Catch: JSONException -> L33
        goto L28
    L15:
        d(JSONObjectProtectorUtils.getJSONObject(r100, r103), JSONObjectProtectorUtils.getJSONObject(r101, r103));     // Catch: JSONException -> L33
        goto L8
    L12:
        r100.put(r103, r101.opt(r103));     // Catch: JSONException -> L33
        goto L8
    L59:
        return;
    L58:
        return;
    L57:
        return;
    }

    public static JSONObject e(JSONObject r100, String r101) {
        if (r100 != null) goto L4;
    L11:
        return r100;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        JSONObject r102 = r100.optJSONObject(r101);
        if (r102 != null) goto L10;
        r102 = new JSONObject();
        r100.put(r101, r102);     // Catch: JSONException -> L12
    L10:
        return r102;
    }

    public static JSONObject f(JSONObject r100, String... r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r102 = 0;
    L7:
        if (r102 >= (r101.length - 1)) goto L13;
        r100 = r100.optJSONObject(r101[r102]);
        if (r100 == null) goto L10;
        r102 = r102 + 1;
        goto L7
    L10:
        p.e("err get json: not found node:" + r101[r102]);
        return null;
    L13:
        return r100;
    }

    public static void i(JSONObject r100, Map<? extends String, ?> r101) {
        if (r100 == null) goto L10;
        if (r101 == null) goto L16;
        Iterator<Map.Entry<? extends String, ?>> r102 = r101.entrySet().iterator();     // Catch: Throwable -> L11
    L7:
        if (r102.hasNext() == false) goto L18;
        Map.Entry<? extends String, ?> r103 = r102.next();     // Catch: Throwable -> L11
        r100.put(r103.getKey(), r103.getValue());     // Catch: Throwable -> L11
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public static void b(JSONObject r100, String r101, Object r102) {
        if (r102 == null) goto L8;
        r100.put(r101, String.valueOf(r102));     // Catch: JSONException -> L5
        return;
    L9:
        return;
    }

    public static void c(JSONObject r100, String r101, String r102) {
        if (r102 == null) goto L8;
        r100.put(r101, r102);     // Catch: JSONException -> L5
        return;
    L9:
        return;
    }

    public static JSONObject h(JSONObject r100, String r101, Object r102) {
        if (r100 == null) goto L8;
        if (r102 == null) goto L8;
        if (TextUtils.isEmpty(r101) == true) goto L8;
        r100.put(r101, r102);     // Catch: JSONException -> L9
    L8:
        return r100;
    }
}
