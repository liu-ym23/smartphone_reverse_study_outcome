package com.bytedance.mt.protector.impl;

import com.bytedance.mt.protector.ProtectorType;
import com.bytedance.mt.protector.SelfDataManager;
import com.bytedance.mt.protector.c;
import com.bytedance.mt.protector.f;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes.dex */
public class JSONObjectProtectorUtils {
    public JSONObjectProtectorUtils() {
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static JSONObject createJSONObject(JSONTokener r100) throws JSONException {
        if (c.b() == false) goto L21;
        return new JSONObject(r100);
    L6:
        th = move-exception;
        f r101 = c.a(ProtectorType.JSON, th);
        if (r101 != null) goto L14;
        if (r100 == null) goto L11;
        String r102 = r100.toString();
    L12:
        addSelfData("createJSONObject", th, r102);
        throw th;
    L11:
        r102 = "null JSONTokener";
        goto L12
    L14:
        Object r103 = r101.f265674a;
        if ((r103 instanceof JsonElement) == true) goto L17;
        return null;
    L17:
        return new JSONObject(r103.toString());
    L21:
        return new JSONObject(r100);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static JSONObject createJSONObject(String r100) throws JSONException {
        if (c.b() == false) goto L18;
        return new JSONObject(r100);
    L6:
        th = move-exception;
        f r101 = c.a(ProtectorType.JSON, th);
        if (r101 == null) goto L15;
        Object r102 = r101.f265674a;
        if ((r102 instanceof JsonElement) == true) goto L12;
        return null;
    L12:
        return new JSONObject(r102.toString());
    L15:
        addSelfData("createJSONObject", th, r100);
        throw th;
    L18:
        return new JSONObject(r100);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static boolean getBoolean(JSONObject r100, String r101) throws JSONException {
        if (c.b() == false) goto L13;
        return r100.getBoolean(r101);
    L6:
        th = move-exception;
        f r102 = c.a(ProtectorType.JSON, th);
        if (r102 != null) goto L10;
        throw th;
    L10:
        return ((Boolean) r102.f265674a).booleanValue();
    L13:
        return r100.getBoolean(r101);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static double getDouble(JSONObject r100, String r101) throws JSONException {
        if (c.b() == false) goto L13;
        return r100.getDouble(r101);
    L6:
        th = move-exception;
        f r102 = c.a(ProtectorType.JSON, th);
        if (r102 != null) goto L10;
        throw th;
    L10:
        return ((Double) r102.f265674a).doubleValue();
    L13:
        return r100.getDouble(r101);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static int getInt(JSONObject r100, String r101) throws JSONException {
        if (c.b() == false) goto L13;
        return r100.getInt(r101);
    L6:
        th = move-exception;
        f r102 = c.a(ProtectorType.JSON, th);
        if (r102 != null) goto L10;
        throw th;
    L10:
        return ((Integer) r102.f265674a).intValue();
    L13:
        return r100.getInt(r101);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static JSONArray getJSONArray(JSONObject r100, String r101) throws JSONException {
        if (c.b() == false) goto L17;
        return r100.getJSONArray(r101);
    L6:
        th = move-exception;
        f r102 = c.a(ProtectorType.JSON, th);
        if (r102 == null) goto L15;
        Object r103 = r102.f265674a;
        if ((r103 instanceof JsonElement) == true) goto L12;
        return null;
    L12:
        return new JSONArray(r103.toString());
    L15:
        throw th;
    L17:
        return r100.getJSONArray(r101);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static JSONObject getJSONObject(JSONObject r100, String r101) throws JSONException {
        if (c.b() == false) goto L17;
        return r100.getJSONObject(r101);
    L6:
        th = move-exception;
        f r102 = c.a(ProtectorType.JSON, th);
        if (r102 == null) goto L15;
        Object r103 = r102.f265674a;
        if ((r103 instanceof JsonElement) == true) goto L12;
        return null;
    L12:
        return new JSONObject(r103.toString());
    L15:
        throw th;
    L17:
        return r100.getJSONObject(r101);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static long getLong(JSONObject r100, String r101) throws JSONException {
        if (c.b() == false) goto L13;
        return r100.getLong(r101);
    L6:
        th = move-exception;
        f r102 = c.a(ProtectorType.JSON, th);
        if (r102 != null) goto L10;
        throw th;
    L10:
        return ((Long) r102.f265674a).longValue();
    L13:
        return r100.getLong(r101);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static String getString(JSONObject r100, String r101) throws JSONException {
        if (c.b() == false) goto L13;
        return r100.getString(r101);
    L6:
        th = move-exception;
        f r102 = c.a(ProtectorType.JSON, th);
        if (r102 != null) goto L10;
        throw th;
    L10:
        return (String) r102.f265674a;
    L13:
        return r100.getString(r101);
    }

    private static void addSelfData(String r100, Throwable r101, String r102) {
        String r103 = v27.a.a(r101);     // Catch: Throwable -> L4
        JsonObject r104 = new JsonObject();     // Catch: Throwable -> L4
        r104.addProperty("stackTrace", r103);     // Catch: Throwable -> L4
        r104.addProperty("inputData", r102);     // Catch: Throwable -> L4
        SelfDataManager.f265657e.a(r100, r104, r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c.f265673e.a(th);
    }

    private static void addSelfData(String r100, Throwable r101, JsonElement r102) {
        if (r102 == null) goto L4;
        String r103 = r102.toString();
    L5:
        addSelfData(r100, r101, r103);
        return;
    L4:
        r103 = "null-param";
        goto L5
    }
}
