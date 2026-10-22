package com.bytedance.locallife.live.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LinkedTreeMap;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public class MapDeserializerDoubleAsIntFix implements JsonDeserializer<Map<String, Object>> {
    public MapDeserializerDoubleAsIntFix() {
    }

    public final Object a(JsonElement r100) {
        if (r100.isJsonArray() == false) goto L10;
        ArrayList r101 = new ArrayList();
        Iterator<JsonElement> r102 = r100.getAsJsonArray().iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        r101.add(a(r102.next()));
        goto L6
    L8:
        return r101;
    L10:
        if (r100.isJsonObject() == false) goto L17;
        LinkedTreeMap r103 = new LinkedTreeMap();
        Iterator<Map.Entry<String, JsonElement>> r104 = r100.getAsJsonObject().entrySet().iterator();
    L13:
        if (r104.hasNext() == false) goto L15;
        Map.Entry<String, JsonElement> r105 = r104.next();
        r103.put(r105.getKey(), a(r105.getValue()));
        goto L13
    L15:
        return r103;
    L17:
        if (r100.isJsonPrimitive() == false) goto L34;
        JsonPrimitive r106 = r100.getAsJsonPrimitive();
        if (r106.isBoolean() == false) goto L23;
        return Boolean.valueOf(r106.getAsBoolean());
    L23:
        if (r106.isString() == false) goto L27;
        return r106.getAsString();
    L27:
        if (r106.isNumber() == false) goto L38;
        Number r107 = r106.getAsNumber();
        if (Math.ceil(r107.doubleValue()) != r107.longValue()) goto L33;
        return Long.valueOf(r107.longValue());
    L33:
        return Double.valueOf(r107.doubleValue());
    L38:
        return null;
    L34:
        return null;
    }

    @Override // com.google.gson.JsonDeserializer
    public final Map<String, Object> deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) throws JsonParseException {
        return (Map) a(r100);
    }
}
