package com.larus.utils.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import ouc.a0;
import ouc.d0;
import ouc.g0;
import ouc.k;

/* JADX INFO: loaded from: classes4.dex */
public final class f {
    static {
    }

    public static ouc.i a(JsonElement r100) {
        if (r100 == null) goto L31;
        if (r100.isJsonNull() == true) goto L31;
        if (r100.isJsonObject() == false) goto L15;
        Set<Map.Entry<String, JsonElement>> r101 = r100.getAsJsonObject().entrySet();
        LinkedHashMap r102 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r101, 10)), 16));
        Iterator<T> r103 = r101.iterator();
    L10:
        if (r103.hasNext() == false) goto L13;
        Map.Entry r104 = (Map.Entry) r103.next();
        Intrinsics.checkNotNull(r104);
        Pair r105 = TuplesKt.to((String) r104.getKey(), a((JsonElement) r104.getValue()));
        r102.put(r105.getFirst(), r105.getSecond());
        goto L10
    L13:
        return new d0(r102);
    L15:
        if (r100.isJsonArray() == false) goto L22;
        JsonArray r106 = r100.getAsJsonArray();
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<JsonElement> r108 = r106.iterator();
    L18:
        if (r108.hasNext() == false) goto L21;
        r107.add(a(r108.next()));
        goto L18
    L21:
        return new ouc.b(r107);
    L22:
        JsonPrimitive r109 = r100.getAsJsonPrimitive();
        if (r109.isBoolean() == false) goto L26;
        return k.a(Boolean.valueOf(r109.getAsBoolean()));
    L26:
        if (r109.isNumber() == false) goto L29;
        return k.b(r109.getAsNumber());
    L29:
        return k.c(r109.getAsString());
    L31:
        return a0.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static JsonElement b(ouc.i r100) {
        if (r100 == 0) goto L32;
        if (Intrinsics.areEqual(r100, a0.INSTANCE) == true) goto L32;
        if ((r100 instanceof d0) == false) goto L13;
        JsonObject r101 = new JsonObject();
        Iterator r102 = ((Map) r100).entrySet().iterator();
    L10:
        if (r102.hasNext() == false) goto L40;
        Map.Entry r103 = (Map.Entry) r102.next();
        r101.add((String) r103.getKey(), b((ouc.i) r103.getValue()));
        goto L10
    L40:
        return r101;
    L13:
        if ((r100 instanceof ouc.b) == false) goto L19;
        JsonArray r104 = new JsonArray();
        Iterator r105 = ((Iterable) r100).iterator();
    L16:
        if (r105.hasNext() == false) goto L41;
        r104.add(b((ouc.i) r105.next()));
        goto L16
    L41:
        return r104;
    L19:
        if ((r100 instanceof g0) == false) goto L39;
        g0 r106 = (g0) r100;
        if (r106.c() == false) goto L24;
        return new JsonPrimitive(r106.a());
    L24:
        if (k.f(r106) == null) goto L26;
        Boolean r107 = k.f(r106);
        Intrinsics.checkNotNull(r107);
        return new JsonPrimitive(r107);
    L26:
        BigDecimal r108 = StringsKt.toBigDecimalOrNull(r106.a());
        if (r108 == null) goto L38;
        return new JsonPrimitive(r108);
    L38:
        return new JsonPrimitive(r106.a());
    L39:
        return new JsonPrimitive(r100.toString());
    L32:
        return JsonNull.INSTANCE;
    }
}
