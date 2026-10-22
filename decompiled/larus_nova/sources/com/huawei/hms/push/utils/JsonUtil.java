package com.huawei.hms.push.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class JsonUtil {
    private JsonUtil() {
    }

    public static JSONArray getIntJsonArray(int[] r100) {
        JSONArray r101 = new JSONArray();
        if (r100 != null) goto L5;
    L10:
        return r101;
    L5:
        if (r100.length == 0) goto L10;
        int r102 = r100.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L10;
        r101.put(r100[r103]);
        r103 = r103 + 1;
        goto L8
    }

    public static JSONArray getLongJsonArray(long[] r100) {
        JSONArray r101 = new JSONArray();
        if (r100 != null) goto L5;
    L10:
        return r101;
    L5:
        if (r100.length == 0) goto L10;
        int r102 = r100.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L10;
        r101.put(r100[r103]);
        r103 = r103 + 1;
        goto L8
    }

    public static JSONArray getStringJsonArray(String[] r100) {
        JSONArray r101 = new JSONArray();
        if (r100 != null) goto L5;
    L10:
        return r101;
    L5:
        if (r100.length == 0) goto L10;
        int r102 = r100.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L10;
        r101.put(r100[r103]);
        r103 = r103 + 1;
        goto L8
    }

    public static int getInt(JSONObject r100, String r101, int r102) {
        if (r100 == null) goto L11;
    L7:
        HMSLog.w("JsonUtil", "JSONException: get " + r101 + " error.");
        return r102;
    L4:
        if (r100.has(r101) == false) goto L12;
        return JSONObjectProtectorUtils.getInt(r100, r101);
    L12:
        return r102;
    L11:
        return r102;
    }

    public static int[] getIntArray(JSONObject r100, String r101, int[] r102) {
        int[] r103 = null;
        if (r100 != null) goto L16;
    L12:
        if (r103 != null) goto L15;
        return r102;
    L15:
        return r103;
    L16:
    L11:
        HMSLog.w("JsonUtil", "JSONException: get " + r101 + " error.");
        goto L12
    L5:
        if (r100.has(r101) == false) goto L12;
        JSONArray r104 = JSONObjectProtectorUtils.getJSONArray(r100, r101);     // Catch: JSONException -> L11
        r103 = new int[r104.length()];     // Catch: JSONException -> L11
        int r105 = 0;
    L8:
        if (r105 >= r104.length()) goto L12;
        r103[r105] = ((Integer) r104.get(r105)).intValue();     // Catch: JSONException -> L11
        r105 = r105 + 1;
        goto L8
    }

    public static long[] getLongArray(JSONObject r100, String r101, long[] r102) {
        long[] r103 = null;
        if (r100 != null) goto L16;
    L12:
        if (r103 != null) goto L15;
        return r102;
    L15:
        return r103;
    L16:
    L11:
        HMSLog.w("JsonUtil", "JSONException: get " + r101 + " error.");
        goto L12
    L5:
        if (r100.has(r101) == false) goto L12;
        JSONArray r104 = JSONObjectProtectorUtils.getJSONArray(r100, r101);     // Catch: JSONException -> L11
        r103 = new long[r104.length()];     // Catch: JSONException -> L11
        int r105 = 0;
    L8:
        if (r105 >= r104.length()) goto L12;
        r103[r105] = JSONArrayProtectorUtils.getLong(r104, r105);     // Catch: JSONException -> L11
        r105 = r105 + 1;
        goto L8
    }

    public static String getString(JSONObject r100, String r101, String r102) {
        if (r100 == null) goto L13;
    L9:
        HMSLog.w("JsonUtil", "JSONException: get " + r101 + " error.");
        return r102;
    L4:
        if (r100.has(r101) == true) goto L6;
        return r102;
    L6:
        if (r100.get(r101) == null) goto L15;
        return String.valueOf(r100.get(r101));
    L15:
        return r102;
    L13:
        return r102;
    }

    public static String[] getStringArray(JSONObject r100, String r101, String[] r102) {
        String[] r103 = null;
        if (r100 != null) goto L13;
    L12:
        return r103;
    L13:
    L11:
        HMSLog.w("JsonUtil", "JSONException: get " + r101 + " error.");
        goto L12
    L5:
        if (r100.has(r101) == false) goto L12;
        JSONArray r104 = JSONObjectProtectorUtils.getJSONArray(r100, r101);     // Catch: JSONException -> L11
        r103 = new String[r104.length()];     // Catch: JSONException -> L11
        int r105 = 0;
    L8:
        if (r105 >= r104.length()) goto L12;
        r103[r105] = (String) r104.get(r105);     // Catch: JSONException -> L11
        r105 = r105 + 1;
        goto L8
    }

    public static void transferJsonObjectToBundle(JSONObject r100, Bundle r101, HashMap<String, Object> r102) {
        Iterator<Map.Entry<String, Object>> r103 = r102.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry<String, Object> r104 = r103.next();
        a(r100, r104.getKey(), r104.getValue(), r101);
        goto L4
    }

    private static void a(JSONObject r100, String r101, Object r102, Bundle r103) {
        if (r102 != null) goto L6;
        HMSLog.w("JsonUtil", "transfer jsonObject to bundle failed, defaultValue is null.");
        return;
    L6:
        String[] r104 = null;
        String r105 = null;
        int[] r106 = null;
        long[] r107 = null;
        if ((r102 instanceof String) == false) goto L14;
        String r108 = (String) r102;
        if (TextUtils.isEmpty(r108) == true) goto L12;
        r105 = r108;
    L12:
        r103.putString(r101, getString(r100, r101, r105));
        return;
    L14:
        if ((r102 instanceof Integer) == false) goto L17;
        r103.putInt(r101, getInt(r100, r101, ((Integer) r102).intValue()));
        return;
    L17:
        if ((r102 instanceof int[]) == false) goto L24;
        int[] r109 = (int[]) r102;
        if (r109.length == 0) goto L22;
        r106 = r109;
    L22:
        r103.putIntArray(r101, getIntArray(r100, r101, r106));
        return;
    L24:
        if ((r102 instanceof long[]) == false) goto L31;
        long[] r110 = (long[]) r102;
        if (r110.length == 0) goto L29;
        r107 = r110;
    L29:
        r103.putLongArray(r101, getLongArray(r100, r101, r107));
        return;
    L31:
        if ((r102 instanceof String[]) == false) goto L37;
        String[] r111 = (String[]) r102;
        if (r111.length == 0) goto L36;
        r104 = r111;
    L36:
        r103.putStringArray(r101, getStringArray(r100, r101, r104));
        return;
    L37:
        HMSLog.w("JsonUtil", "transfer jsonObject to bundle failed, invalid data type.");
    }
}
