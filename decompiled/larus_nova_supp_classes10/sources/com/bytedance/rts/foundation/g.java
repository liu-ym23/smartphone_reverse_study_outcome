package com.bytedance.rts.foundation;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g {
    public static final Object a(JsonElement r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        if ((r3 instanceof JsonObject) == false) goto L9;
        Map<String, JsonElement> r4 = n((JsonObject) r3);
        LinkedHashMap r0 = new LinkedHashMap(MapsKt.mapCapacity(r4.size()));
        Iterator r5 = ((LinkedHashMap) r4).entrySet().iterator();
    L6:
        if (r5.hasNext() == false) goto L37;
        Map.Entry r1 = (Map.Entry) r5.next();
        r0.put(r1.getKey(), a((JsonElement) r1.getValue()));
        goto L6
    L37:
        return r0;
    L9:
        if ((r3 instanceof JsonArray) == false) goto L15;
        Iterable r6 = (Iterable) r3;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r7 = r6.iterator();
    L12:
        if (r7.hasNext() == false) goto L38;
        r2.add(a((JsonElement) r7.next()));
        goto L12
    L38:
        return r2;
    L15:
        if ((r3 instanceof JsonPrimitive) == false) goto L31;
        JsonPrimitive r8 = (JsonPrimitive) r3;
        if (r8.isBoolean() == false) goto L20;
        return Boolean.valueOf(r8.getAsBoolean());
    L20:
        if (r8.isString() == false) goto L23;
        return r8.getAsString();
    L23:
        if (r8.isNumber() == false) goto L29;
        String r9 = r8.getAsNumber().toString();
        Integer r10 = StringsKt.toIntOrNull(r9);
        if (r10 == null) goto L27;
        return r10;
    L27:
        return Double.valueOf(CastDoubleProtector.parseDouble(r9));
    L29:
        throw new IllegalArgumentException("input is not json object");
    L31:
        throw new IllegalArgumentException("input is not json object");
    }

    public static final Object h(Map r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter("negative", "key");
        int r2 = f.a;
        Intrinsics.checkNotNullParameter(r3, "json");
        Intrinsics.checkNotNullParameter("negative", "key");
        Object r4 = r3.get("negative");     // Catch: Exception -> L7
        if ((r4 instanceof JsonElement) == false) goto L11;
        return b((JsonElement) r4, 0);
    L11:
        return r4;
    L7:
        return null;
    }

    public static final Map<String, JsonElement> n(JsonObject r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r4.next();
        r0.put((String) r1.getKey(), (JsonElement) r1.getValue());
        goto L4
    L6:
        return r0;
    }

    public static final Object b(JsonElement r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "jsonElem");
        if (r4 != 0) goto L14;
        if ((r3 instanceof JsonPrimitive) == false) goto L12;
        JsonPrimitive r5 = (JsonPrimitive) r3;
        if (r5.isBoolean() == false) goto L10;
        return Boolean.valueOf(r5.getAsBoolean());
    L10:
        throw new IllegalArgumentException("");
    L12:
        throw new IllegalArgumentException("");
    L14:
        if (r3.isJsonArray() == false) goto L22;
        JsonArray r6 = r3.getAsJsonArray();
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r7 = r6.iterator();
    L17:
        if (r7.hasNext() == false) goto L20;
        r0.add(b((JsonElement) r7.next(), r4 - 1));
        goto L17
    L20:
        return r0;
    L22:
        throw new IllegalArgumentException("");
    }

    public static final Object c(JsonElement r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "jsonElem");
        if (r4 != 0) goto L14;
        if ((r3 instanceof JsonPrimitive) == false) goto L12;
        JsonPrimitive r5 = (JsonPrimitive) r3;
        if (r5.isNumber() == false) goto L10;
        return Double.valueOf(r5.getAsDouble());
    L10:
        throw new IllegalArgumentException("");
    L12:
        throw new IllegalArgumentException("");
    L14:
        if (r3.isJsonArray() == false) goto L22;
        JsonArray r6 = r3.getAsJsonArray();
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r7 = r6.iterator();
    L17:
        if (r7.hasNext() == false) goto L20;
        r0.add(c((JsonElement) r7.next(), r4 - 1));
        goto L17
    L20:
        return r0;
    L22:
        throw new IllegalArgumentException("");
    }

    public static final Object d(JsonElement r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "jsonElem");
        if (r4 != 0) goto L14;
        if ((r3 instanceof JsonPrimitive) == false) goto L12;
        JsonPrimitive r5 = (JsonPrimitive) r3;
        if (r5.isNumber() == false) goto L10;
        return Integer.valueOf(r5.getAsInt());
    L10:
        throw new IllegalArgumentException("");
    L12:
        throw new IllegalArgumentException("");
    L14:
        if (r3.isJsonArray() == false) goto L22;
        JsonArray r6 = r3.getAsJsonArray();
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r7 = r6.iterator();
    L17:
        if (r7.hasNext() == false) goto L20;
        r0.add(d((JsonElement) r7.next(), r4 - 1));
        goto L17
    L20:
        return r0;
    L22:
        throw new IllegalArgumentException("");
    }

    public static final Object e(JsonElement r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "jsonElem");
        if (r4 != 0) goto L10;
        if (r3.isJsonArray() == true) goto L8;
        return n(r3.getAsJsonObject());
    L8:
        throw new IllegalArgumentException("");
    L10:
        if (r3.isJsonArray() == false) goto L18;
        JsonArray r5 = r3.getAsJsonArray();
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L16;
        r0.add(e((JsonElement) r6.next(), r4 - 1));
        goto L13
    L16:
        return r0;
    L18:
        throw new IllegalArgumentException("");
    }

    public static final Object f(JsonElement r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "jsonElem");
        if (r4 != 0) goto L14;
        if ((r3 instanceof JsonPrimitive) == false) goto L12;
        JsonPrimitive r5 = (JsonPrimitive) r3;
        if (r5.isNumber() == false) goto L10;
        return Long.valueOf(r5.getAsLong());
    L10:
        throw new IllegalArgumentException("");
    L12:
        throw new IllegalArgumentException("");
    L14:
        if (r3.isJsonArray() == false) goto L22;
        JsonArray r6 = r3.getAsJsonArray();
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r7 = r6.iterator();
    L17:
        if (r7.hasNext() == false) goto L20;
        r0.add(f((JsonElement) r7.next(), r4 - 1));
        goto L17
    L20:
        return r0;
    L22:
        throw new IllegalArgumentException("");
    }

    public static final Object g(JsonElement r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "jsonElem");
        if (r4 != 0) goto L14;
        if ((r3 instanceof JsonPrimitive) == false) goto L12;
        JsonPrimitive r5 = (JsonPrimitive) r3;
        if (r5.isString() == false) goto L10;
        return r5.getAsString();
    L10:
        throw new IllegalArgumentException("");
    L12:
        throw new IllegalArgumentException("");
    L14:
        if (r3.isJsonArray() == false) goto L22;
        JsonArray r6 = r3.getAsJsonArray();
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r7 = r6.iterator();
    L17:
        if (r7.hasNext() == false) goto L20;
        r0.add(g((JsonElement) r7.next(), r4 - 1));
        goto L17
    L20:
        return r0;
    L22:
        throw new IllegalArgumentException("");
    }

    public static final Object i(Map r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "key");
        int r1 = f.a;
        Intrinsics.checkNotNullParameter(r2, "json");
        Intrinsics.checkNotNullParameter(r3, "key");
        Object r4 = r2.get(r3);     // Catch: Exception -> L7
        if ((r4 instanceof JsonElement) == false) goto L11;
        return c((JsonElement) r4, 0);
    L11:
        return r4;
    L7:
        return null;
    }

    public static final Object j(Map r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "key");
        int r1 = f.a;
        Intrinsics.checkNotNullParameter(r2, "json");
        Intrinsics.checkNotNullParameter(r3, "key");
        Object r4 = r2.get(r3);     // Catch: Exception -> L7
        if ((r4 instanceof JsonElement) == false) goto L11;
        return d((JsonElement) r4, 0);
    L11:
        return r4;
    L7:
        return null;
    }

    public static final Object l(Map r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "key");
        int r1 = f.a;
        Intrinsics.checkNotNullParameter(r2, "json");
        Intrinsics.checkNotNullParameter(r3, "key");
        Object r4 = r2.get(r3);     // Catch: Exception -> L7
        if ((r4 instanceof JsonElement) == false) goto L11;
        return f((JsonElement) r4, 0);
    L11:
        return r4;
    L7:
        return null;
    }

    public static final Object m(Map r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "key");
        int r1 = f.a;
        Intrinsics.checkNotNullParameter(r2, "json");
        Intrinsics.checkNotNullParameter(r3, "key");
        Object r4 = r2.get(r3);     // Catch: Exception -> L7
        if ((r4 instanceof JsonElement) == false) goto L11;
        return g((JsonElement) r4, 0);
    L11:
        return r4;
    L7:
        return null;
    }

    public static final Object k(Map<String, ? extends Object> r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "key");
        int r1 = f.a;
        Intrinsics.checkNotNullParameter(r2, "json");
        Intrinsics.checkNotNullParameter(r3, "key");
        Object r5 = r2.get(r3);     // Catch: Exception -> L7
        if ((r5 instanceof JsonElement) == false) goto L11;
        return e((JsonElement) r5, r4);
    L11:
        return r5;
    L7:
        return null;
    }
}
