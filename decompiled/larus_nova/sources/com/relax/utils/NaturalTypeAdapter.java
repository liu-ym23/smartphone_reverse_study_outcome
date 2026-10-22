package com.relax.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class NaturalTypeAdapter implements JsonDeserializer<LinkedHashMap<String, Object>> {
    public NaturalTypeAdapter() {
    }

    public final Object a(JsonElement r100) {
        if (r100.isJsonNull() == false) goto L6;
        return null;
    L6:
        if (r100.isJsonPrimitive() == false) goto L25;
        JsonPrimitive r101 = r100.getAsJsonPrimitive();
        if (r101.isBoolean() == false) goto L12;
        return Boolean.valueOf(r101.getAsBoolean());
    L12:
        if (r101.isString() == false) goto L16;
        return r101.getAsString();
    L16:
        if (r101.isNumber() == false) goto L25;
        BigDecimal r102 = r101.getAsBigDecimal();
        if (r102.scale() != 0) goto L23;
        return Integer.valueOf(r102.intValueExact());
    L39:
        return Long.valueOf(r102.longValueExact());
    L23:
        return Double.valueOf(r102.doubleValue());
    L25:
        if (r100.isJsonArray() == false) goto L32;
        JsonArray r103 = r100.getAsJsonArray();
        Object[] r104 = new Object[r103.size()];
        int r105 = 0;
    L28:
        if (r105 >= r103.size()) goto L30;
        r104[r105] = a(r103.get(r105));
        r105 = r105 + 1;
        goto L28
    L30:
        return r104;
    L32:
        if (r100.isJsonObject() == true) goto L34;
        return null;
    L34:
        return b(r100.getAsJsonObject());
    }

    public final LinkedHashMap<String, Object> b(JsonObject r100) {
        LinkedHashMap<String, Object> r101 = new LinkedHashMap();
        Iterator<Map.Entry<String, JsonElement>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<String, JsonElement> r103 = r102.next();
        r101.put(r103.getKey(), a(r103.getValue()));
        goto L4
    L6:
        return r101;
    }

    @Override // com.google.gson.JsonDeserializer
    public final LinkedHashMap<String, Object> deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) throws JsonParseException {
        return b(r100.getAsJsonObject());
    }
}
