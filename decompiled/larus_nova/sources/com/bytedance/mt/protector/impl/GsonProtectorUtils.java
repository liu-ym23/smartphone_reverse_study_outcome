package com.bytedance.mt.protector.impl;

import com.bytedance.mt.protector.ProtectorType;
import com.bytedance.mt.protector.SelfDataManager;
import com.bytedance.mt.protector.c;
import com.bytedance.mt.protector.f;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.Reader;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public class GsonProtectorUtils {
    public GsonProtectorUtils() {
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static Gson createGson() {
        if (c.b() == false) goto L18;
        return new Gson();
    L6:
        th = move-exception;
        f r100 = c.a(ProtectorType.JSON, th);
        if (r100 != null) goto L10;
        addSelfData("createGson", th, "Gson<init>");
        throw th;
    L10:
        if ((r100.f265674a instanceof JsonElement) == true) goto L12;
        return null;
    L12:
        return new Gson();
    L18:
        return new Gson();
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static JsonElement parse(JsonParser r100, String r101) {
        if (c.b() == false) goto L18;
        return r100.parse(r101);
    L6:
        th = move-exception;
        f r102 = c.a(ProtectorType.JSON, th);
        if (r102 == null) goto L15;
        Object r103 = r102.f265674a;
        if ((r103 instanceof String) == true) goto L12;
        return null;
    L12:
        return r100.parse((String) r103);
    L15:
        addSelfData("parse", th, r101);
        throw th;
    L18:
        return r100.parse(r101);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static String toJson(Gson r100, JsonElement r101) {
        if (c.b() == false) goto L13;
        return r100.toJson(r101);
    L6:
        th = move-exception;
        f r102 = c.a(ProtectorType.JSON, th);
        if (r102 != null) goto L10;
        throw th;
    L10:
        return (String) r102.f265674a;
    L13:
        return r100.toJson(r101);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static JsonElement toJsonTree(Gson r100, Object r101) {
        if (c.b() == false) goto L13;
        return r100.toJsonTree(r101);
    L6:
        th = move-exception;
        if (c.a(ProtectorType.JSON, th) == null) goto L11;
        return null;
    L11:
        throw th;
    L13:
        return r100.toJsonTree(r101);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static String toJson(Gson r100, Object r101) {
        if (c.b() == false) goto L13;
        return r100.toJson(r101);
    L6:
        th = move-exception;
        f r102 = c.a(ProtectorType.JSON, th);
        if (r102 != null) goto L10;
        throw th;
    L10:
        return (String) r102.f265674a;
    L13:
        return r100.toJson(r101);
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

    @ProtectorMethod(exceptions = {Exception.class})
    public static <T> T fromJson(Gson r100, JsonReader r101, Type r102) {
        if (c.b() == false) goto L18;
        return (T) r100.fromJson(r101, r102);
    L6:
        th = move-exception;
        f r103 = c.a(ProtectorType.JSON, th);
        if (r103 == null) goto L15;
        Object r104 = r103.f265674a;
        if ((r104 instanceof JsonElement) == true) goto L12;
        return null;
    L12:
        return (T) r100.fromJson((JsonElement) r104, r102);
    L15:
        addSelfData("fromJson", th, "unsupport JsonReader");
        throw th;
    L18:
        return (T) r100.fromJson(r101, r102);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static String toJson(Gson r100, Object r101, Type r102) {
        if (c.b() == false) goto L13;
        return r100.toJson(r101, r102);
    L6:
        th = move-exception;
        f r103 = c.a(ProtectorType.JSON, th);
        if (r103 != null) goto L10;
        throw th;
    L10:
        return (String) r103.f265674a;
    L13:
        return r100.toJson(r101, r102);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static JsonElement toJsonTree(Gson r100, Object r101, Type r102) {
        if (c.b() == false) goto L13;
        return r100.toJsonTree(r101, r102);
    L6:
        th = move-exception;
        if (c.a(ProtectorType.JSON, th) == null) goto L11;
        return null;
    L11:
        throw th;
    L13:
        return r100.toJsonTree(r101, r102);
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

    @ProtectorMethod(exceptions = {Exception.class})
    public static <T> T fromJson(Gson r100, Reader r101, Class<T> r102) {
        if (c.b() == false) goto L18;
        return (T) r100.fromJson(r101, r102);
    L6:
        th = move-exception;
        f r103 = c.a(ProtectorType.JSON, th);
        if (r103 == null) goto L15;
        Object r104 = r103.f265674a;
        if ((r104 instanceof JsonElement) == true) goto L12;
        return null;
    L12:
        return (T) r100.fromJson((JsonElement) r104, r102);
    L15:
        addSelfData("fromJson", th, "unsupport Reader");
        throw th;
    L18:
        return (T) r100.fromJson(r101, r102);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static void toJson(Gson r100, JsonElement r101, Appendable r102) {
        if (c.b() == true) goto L13;
        r100.toJson(r101, r102);
        return;
    L13:
        r100.toJson(r101, r102);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        if (c.a(ProtectorType.JSON, th) == null) goto L10;
        return;
    L10:
        throw th;
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static <T> T fromJson(Gson r100, Reader r101, Type r102) {
        if (c.b() == false) goto L18;
        return (T) r100.fromJson(r101, r102);
    L6:
        th = move-exception;
        f r103 = c.a(ProtectorType.JSON, th);
        if (r103 == null) goto L15;
        Object r104 = r103.f265674a;
        if ((r104 instanceof JsonElement) == true) goto L12;
        return null;
    L12:
        return (T) r100.fromJson((JsonElement) r104, r102);
    L15:
        addSelfData("fromJson", th, "unsupport Reader");
        throw th;
    L18:
        return (T) r100.fromJson(r101, r102);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static void toJson(Gson r100, Object r101, Appendable r102) {
        if (c.b() == true) goto L13;
        r100.toJson(r101, r102);
        return;
    L13:
        r100.toJson(r101, r102);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        if (c.a(ProtectorType.JSON, th) == null) goto L10;
        return;
    L10:
        throw th;
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static <T> T fromJson(Gson r100, JsonElement r101, Class<T> r102) {
        if (c.b() == false) goto L18;
        return (T) r100.fromJson(r101, r102);
    L6:
        th = move-exception;
        f r103 = c.a(ProtectorType.JSON, th);
        if (r103 == null) goto L15;
        Object r104 = r103.f265674a;
        if ((r104 instanceof JsonElement) == true) goto L12;
        return null;
    L12:
        return (T) r100.fromJson((JsonElement) r104, r102);
    L15:
        addSelfData("fromJson", th, r101);
        throw th;
    L18:
        return (T) r100.fromJson(r101, r102);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static <T> T fromJson(Gson r100, JsonElement r101, Type r102) {
        if (c.b() == false) goto L18;
        return (T) r100.fromJson(r101, r102);
    L6:
        th = move-exception;
        f r103 = c.a(ProtectorType.JSON, th);
        if (r103 == null) goto L15;
        Object r104 = r103.f265674a;
        if ((r104 instanceof JsonElement) == true) goto L12;
        return null;
    L12:
        return (T) r100.fromJson((JsonElement) r104, r102);
    L15:
        addSelfData("fromJson", th, r101);
        throw th;
    L18:
        return (T) r100.fromJson(r101, r102);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static <T> T fromJson(Gson r100, String r101, Class<T> r102) {
        if (c.b() == false) goto L18;
        return (T) r100.fromJson(r101, r102);
    L6:
        th = move-exception;
        f r103 = c.a(ProtectorType.JSON, th);
        if (r103 == null) goto L15;
        Object r104 = r103.f265674a;
        if ((r104 instanceof JsonElement) == true) goto L12;
        return null;
    L12:
        return (T) r100.fromJson((JsonElement) r104, r102);
    L15:
        addSelfData("fromJson", th, r101);
        throw th;
    L18:
        return (T) r100.fromJson(r101, r102);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static <T> T fromJson(Gson r100, String r101, Type r102) {
        if (c.b() == false) goto L18;
        return (T) r100.fromJson(r101, r102);
    L6:
        th = move-exception;
        f r103 = c.a(ProtectorType.JSON, th);
        if (r103 == null) goto L15;
        Object r104 = r103.f265674a;
        if ((r104 instanceof JsonElement) == true) goto L12;
        return null;
    L12:
        return (T) r100.fromJson((JsonElement) r104, r102);
    L15:
        addSelfData("fromJson", th, r101);
        throw th;
    L18:
        return (T) r100.fromJson(r101, r102);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static void toJson(Gson r100, Object r101, Type r102, JsonWriter r103) {
        if (c.b() == true) goto L13;
        r100.toJson(r101, r102, r103);
        return;
    L13:
        r100.toJson(r101, r102, r103);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        if (c.a(ProtectorType.JSON, th) == null) goto L10;
        return;
    L10:
        throw th;
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static void toJson(Gson r100, Object r101, Type r102, Appendable r103) {
        if (c.b() == true) goto L13;
        r100.toJson(r101, r102, r103);
        return;
    L13:
        r100.toJson(r101, r102, r103);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        if (c.a(ProtectorType.JSON, th) == null) goto L10;
        return;
    L10:
        throw th;
    }
}
