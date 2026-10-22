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

/* JADX INFO: loaded from: classes10.dex */
public final class g {
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object a(JsonElement r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        if ((r100 instanceof JsonObject) == false) goto L9;
        Map<String, JsonElement> r101 = n((JsonObject) r100);
        LinkedHashMap r102 = new LinkedHashMap(MapsKt.mapCapacity(r101.size()));
        Iterator r103 = ((LinkedHashMap) r101).entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L37;
        Map.Entry r104 = (Map.Entry) r103.next();
        r102.put(r104.getKey(), a((JsonElement) r104.getValue()));
        goto L6
    L37:
        return r102;
    L9:
        if ((r100 instanceof JsonArray) == false) goto L15;
        Iterable r105 = (Iterable) r100;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L12:
        if (r107.hasNext() == false) goto L38;
        r106.add(a((JsonElement) r107.next()));
        goto L12
    L38:
        return r106;
    L15:
        if ((r100 instanceof JsonPrimitive) == false) goto L31;
        JsonPrimitive r108 = (JsonPrimitive) r100;
        if (r108.isBoolean() == false) goto L20;
        return Boolean.valueOf(r108.getAsBoolean());
    L20:
        if (r108.isString() == false) goto L23;
        return r108.getAsString();
    L23:
        if (r108.isNumber() == false) goto L29;
        String r109 = r108.getAsNumber().toString();
        Integer r110 = StringsKt.toIntOrNull(r109);
        if (r110 == null) goto L27;
        return r110;
    L27:
        return Double.valueOf(CastDoubleProtector.parseDouble(r109));
    L29:
        throw new IllegalArgumentException("input is not json object");
    L31:
        throw new IllegalArgumentException("input is not json object");
    }

    public static final Object h(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_NEGATIVE, "key");
        int r101 = f.f267579a;
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_NEGATIVE, "key");
        Object r102 = r100.get(com.bytedance.android.ec.core.event.a.VALUE_NEGATIVE);     // Catch: Exception -> L7
        if ((r102 instanceof JsonElement) == false) goto L11;
        return b((JsonElement) r102, 0);
    L11:
        return r102;
    L7:
        return null;
    }

    public static final Map<String, JsonElement> n(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<Map.Entry<String, JsonElement>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<String, JsonElement> r103 = r102.next();
        r101.put(r103.getKey(), r103.getValue());
        goto L4
    L6:
        return r101;
    }

    public static final Object b(JsonElement r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonElem");
        if (r101 != 0) goto L14;
        if ((r100 instanceof JsonPrimitive) == false) goto L12;
        JsonPrimitive r102 = (JsonPrimitive) r100;
        if (r102.isBoolean() == false) goto L10;
        return Boolean.valueOf(r102.getAsBoolean());
    L10:
        throw new IllegalArgumentException("");
    L12:
        throw new IllegalArgumentException("");
    L14:
        if (r100.isJsonArray() == false) goto L22;
        JsonArray r103 = r100.getAsJsonArray();
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<JsonElement> r105 = r103.iterator();
    L17:
        if (r105.hasNext() == false) goto L20;
        r104.add(b(r105.next(), r101 - 1));
        goto L17
    L20:
        return r104;
    L22:
        throw new IllegalArgumentException("");
    }

    public static final Object c(JsonElement r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonElem");
        if (r101 != 0) goto L14;
        if ((r100 instanceof JsonPrimitive) == false) goto L12;
        JsonPrimitive r102 = (JsonPrimitive) r100;
        if (r102.isNumber() == false) goto L10;
        return Double.valueOf(r102.getAsDouble());
    L10:
        throw new IllegalArgumentException("");
    L12:
        throw new IllegalArgumentException("");
    L14:
        if (r100.isJsonArray() == false) goto L22;
        JsonArray r103 = r100.getAsJsonArray();
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<JsonElement> r105 = r103.iterator();
    L17:
        if (r105.hasNext() == false) goto L20;
        r104.add(c(r105.next(), r101 - 1));
        goto L17
    L20:
        return r104;
    L22:
        throw new IllegalArgumentException("");
    }

    public static final Object d(JsonElement r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonElem");
        if (r101 != 0) goto L14;
        if ((r100 instanceof JsonPrimitive) == false) goto L12;
        JsonPrimitive r102 = (JsonPrimitive) r100;
        if (r102.isNumber() == false) goto L10;
        return Integer.valueOf(r102.getAsInt());
    L10:
        throw new IllegalArgumentException("");
    L12:
        throw new IllegalArgumentException("");
    L14:
        if (r100.isJsonArray() == false) goto L22;
        JsonArray r103 = r100.getAsJsonArray();
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<JsonElement> r105 = r103.iterator();
    L17:
        if (r105.hasNext() == false) goto L20;
        r104.add(d(r105.next(), r101 - 1));
        goto L17
    L20:
        return r104;
    L22:
        throw new IllegalArgumentException("");
    }

    public static final Object e(JsonElement r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonElem");
        if (r101 != 0) goto L10;
        if (r100.isJsonArray() == true) goto L8;
        return n(r100.getAsJsonObject());
    L8:
        throw new IllegalArgumentException("");
    L10:
        if (r100.isJsonArray() == false) goto L18;
        JsonArray r102 = r100.getAsJsonArray();
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<JsonElement> r104 = r102.iterator();
    L13:
        if (r104.hasNext() == false) goto L16;
        r103.add(e(r104.next(), r101 - 1));
        goto L13
    L16:
        return r103;
    L18:
        throw new IllegalArgumentException("");
    }

    public static final Object f(JsonElement r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonElem");
        if (r101 != 0) goto L14;
        if ((r100 instanceof JsonPrimitive) == false) goto L12;
        JsonPrimitive r102 = (JsonPrimitive) r100;
        if (r102.isNumber() == false) goto L10;
        return Long.valueOf(r102.getAsLong());
    L10:
        throw new IllegalArgumentException("");
    L12:
        throw new IllegalArgumentException("");
    L14:
        if (r100.isJsonArray() == false) goto L22;
        JsonArray r103 = r100.getAsJsonArray();
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<JsonElement> r105 = r103.iterator();
    L17:
        if (r105.hasNext() == false) goto L20;
        r104.add(f(r105.next(), r101 - 1));
        goto L17
    L20:
        return r104;
    L22:
        throw new IllegalArgumentException("");
    }

    public static final Object g(JsonElement r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonElem");
        if (r101 != 0) goto L14;
        if ((r100 instanceof JsonPrimitive) == false) goto L12;
        JsonPrimitive r102 = (JsonPrimitive) r100;
        if (r102.isString() == false) goto L10;
        return r102.getAsString();
    L10:
        throw new IllegalArgumentException("");
    L12:
        throw new IllegalArgumentException("");
    L14:
        if (r100.isJsonArray() == false) goto L22;
        JsonArray r103 = r100.getAsJsonArray();
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<JsonElement> r105 = r103.iterator();
    L17:
        if (r105.hasNext() == false) goto L20;
        r104.add(g(r105.next(), r101 - 1));
        goto L17
    L20:
        return r104;
    L22:
        throw new IllegalArgumentException("");
    }

    public static final Object i(Map r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        int r102 = f.f267579a;
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r103 = r100.get(r101);     // Catch: Exception -> L7
        if ((r103 instanceof JsonElement) == false) goto L11;
        return c((JsonElement) r103, 0);
    L11:
        return r103;
    L7:
        return null;
    }

    public static final Object j(Map r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        int r102 = f.f267579a;
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r103 = r100.get(r101);     // Catch: Exception -> L7
        if ((r103 instanceof JsonElement) == false) goto L11;
        return d((JsonElement) r103, 0);
    L11:
        return r103;
    L7:
        return null;
    }

    public static final Object l(Map r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        int r102 = f.f267579a;
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r103 = r100.get(r101);     // Catch: Exception -> L7
        if ((r103 instanceof JsonElement) == false) goto L11;
        return f((JsonElement) r103, 0);
    L11:
        return r103;
    L7:
        return null;
    }

    public static final Object m(Map r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        int r102 = f.f267579a;
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r103 = r100.get(r101);     // Catch: Exception -> L7
        if ((r103 instanceof JsonElement) == false) goto L11;
        return g((JsonElement) r103, 0);
    L11:
        return r103;
    L7:
        return null;
    }

    public static final Object k(Map<String, ? extends Object> r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        int r103 = f.f267579a;
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r104 = r100.get(r101);     // Catch: Exception -> L7
        if ((r104 instanceof JsonElement) == false) goto L11;
        return e((JsonElement) r104, r102);
    L11:
        return r104;
    L7:
        return null;
    }
}
