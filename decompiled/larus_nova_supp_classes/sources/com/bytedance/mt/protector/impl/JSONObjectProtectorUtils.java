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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class JSONObjectProtectorUtils {
    public JSONObjectProtectorUtils() {
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static JSONObject createJSONObject(JSONTokener r2) throws JSONException {
        if (c.b() == false) goto L21;
        return new JSONObject(r2);
    L6:
        th = move-exception;
        f r1 = c.a(ProtectorType.JSON, th);
        if (r1 != null) goto L14;
        if (r2 == null) goto L11;
        String r3 = r2.toString();
    L12:
        addSelfData("createJSONObject", th, r3);
        throw th;
    L11:
        r3 = "null JSONTokener";
        goto L12
    L14:
        Object r4 = r1.a;
        if ((r4 instanceof JsonElement) == true) goto L17;
        return null;
    L17:
        return new JSONObject(r4.toString());
    L21:
        return new JSONObject(r2);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static JSONObject createJSONObject(String r2) throws JSONException {
        if (c.b() == false) goto L18;
        return new JSONObject(r2);
    L6:
        th = move-exception;
        f r1 = c.a(ProtectorType.JSON, th);
        if (r1 == null) goto L15;
        Object r3 = r1.a;
        if ((r3 instanceof JsonElement) == true) goto L12;
        return null;
    L12:
        return new JSONObject(r3.toString());
    L15:
        addSelfData("createJSONObject", th, r2);
        throw th;
    L18:
        return new JSONObject(r2);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static boolean getBoolean(JSONObject r1, String r2) throws JSONException {
        if (c.b() == false) goto L13;
        return r1.getBoolean(r2);
    L6:
        th = move-exception;
        f r3 = c.a(ProtectorType.JSON, th);
        if (r3 != null) goto L10;
        throw th;
    L10:
        return ((Boolean) r3.a).booleanValue();
    L13:
        return r1.getBoolean(r2);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static double getDouble(JSONObject r1, String r2) throws JSONException {
        if (c.b() == false) goto L13;
        return r1.getDouble(r2);
    L6:
        th = move-exception;
        f r3 = c.a(ProtectorType.JSON, th);
        if (r3 != null) goto L10;
        throw th;
    L10:
        return ((Double) r3.a).doubleValue();
    L13:
        return r1.getDouble(r2);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static int getInt(JSONObject r1, String r2) throws JSONException {
        if (c.b() == false) goto L13;
        return r1.getInt(r2);
    L6:
        th = move-exception;
        f r3 = c.a(ProtectorType.JSON, th);
        if (r3 != null) goto L10;
        throw th;
    L10:
        return ((Integer) r3.a).intValue();
    L13:
        return r1.getInt(r2);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static JSONArray getJSONArray(JSONObject r1, String r2) throws JSONException {
        if (c.b() == false) goto L17;
        return r1.getJSONArray(r2);
    L6:
        th = move-exception;
        f r3 = c.a(ProtectorType.JSON, th);
        if (r3 == null) goto L15;
        Object r4 = r3.a;
        if ((r4 instanceof JsonElement) == true) goto L12;
        return null;
    L12:
        return new JSONArray(r4.toString());
    L15:
        throw th;
    L17:
        return r1.getJSONArray(r2);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static JSONObject getJSONObject(JSONObject r1, String r2) throws JSONException {
        if (c.b() == false) goto L17;
        return r1.getJSONObject(r2);
    L6:
        th = move-exception;
        f r3 = c.a(ProtectorType.JSON, th);
        if (r3 == null) goto L15;
        Object r4 = r3.a;
        if ((r4 instanceof JsonElement) == true) goto L12;
        return null;
    L12:
        return new JSONObject(r4.toString());
    L15:
        throw th;
    L17:
        return r1.getJSONObject(r2);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static long getLong(JSONObject r1, String r2) throws JSONException {
        if (c.b() == false) goto L13;
        return r1.getLong(r2);
    L6:
        th = move-exception;
        f r3 = c.a(ProtectorType.JSON, th);
        if (r3 != null) goto L10;
        throw th;
    L10:
        return ((Long) r3.a).longValue();
    L13:
        return r1.getLong(r2);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static String getString(JSONObject r1, String r2) throws JSONException {
        if (c.b() == false) goto L13;
        return r1.getString(r2);
    L6:
        th = move-exception;
        f r3 = c.a(ProtectorType.JSON, th);
        if (r3 != null) goto L10;
        throw th;
    L10:
        return (String) r3.a;
    L13:
        return r1.getString(r2);
    }

    private static void addSelfData(String r3, Throwable r4, String r5) {
        String r0 = v27.a.a(r4);     // Catch: Throwable -> L4
        JsonObject r1 = new JsonObject();     // Catch: Throwable -> L4
        r1.addProperty("stackTrace", r0);     // Catch: Throwable -> L4
        r1.addProperty("inputData", r5);     // Catch: Throwable -> L4
        SelfDataManager.e.a(r3, r1, r4);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c.e.a(th);
    }

    private static void addSelfData(String r0, Throwable r1, JsonElement r2) {
        if (r2 == null) goto L4;
        String r3 = r2.toString();
    L5:
        addSelfData(r0, r1, r3);
        return;
    L4:
        r3 = "null-param";
        goto L5
    }
}
