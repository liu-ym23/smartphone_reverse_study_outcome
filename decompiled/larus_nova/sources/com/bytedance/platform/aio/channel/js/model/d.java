package com.bytedance.platform.aio.channel.js.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.WritableArray;
import com.lynx.react.bridge.WritableMap;
import java.util.Iterator;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class d {
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object a(JsonElement r100) {
        if ((r100 instanceof JsonObject) == false) goto L10;
        JavaOnlyMap r101 = new JavaOnlyMap();
        JsonObject r102 = (JsonObject) r100;
        Iterator<T> r103 = r102.keySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        String r104 = (String) r103.next();
        r101.put(r104, a(r102.get(r104)));
        goto L6
    L8:
        return r101;
    L10:
        if ((r100 instanceof JsonPrimitive) == false) goto L26;
        JsonPrimitive r105 = (JsonPrimitive) r100;
        if (r105.isBoolean() == false) goto L16;
        return Boolean.valueOf(r105.getAsBoolean());
    L16:
        if (r105.isNumber() == false) goto L20;
        return r105.getAsNumber();
    L20:
        if (r105.isString() == false) goto L24;
        return r105.getAsString();
    L24:
        throw new IllegalStateException("unsupportable type".toString());
    L26:
        if ((r100 instanceof JsonArray) == false) goto L57;
        JavaOnlyArray r106 = new JavaOnlyArray();
        Iterator r107 = ((Iterable) r100).iterator();
    L29:
        if (r107.hasNext() == false) goto L55;
        Object r108 = a((JsonElement) r107.next());
        if ((r108 instanceof JavaOnlyArray) == true) goto L32;
        if ((r108 instanceof JavaOnlyMap) == true) goto L35;
        if ((r108 instanceof String) == true) goto L38;
        if ((r108 instanceof Number) == true) goto L42;
        if ((r108 instanceof Boolean) == false) goto L54;
        r106.pushBoolean(((Boolean) r108).booleanValue());
        goto L29
    L54:
        throw new IllegalStateException("unsupportable type".toString());
    L42:
        if (StringsKt.contains$default(r108.toString(), ".", false, 2, null) == true) goto L43;
        Number r109 = (Number) r108;
        if (r109.longValue() > Integer.MAX_VALUE) goto L49;
        if (r109.longValue() < (-2147483647)) goto L49;
        r106.pushInt(r109.intValue());
    L49:
        r106.pushLong(r109.longValue());
        goto L29
    L43:
        r106.pushDouble(((Number) r108).doubleValue());
        goto L29
    L38:
        r106.pushString((String) r108);
        goto L29
    L35:
        r106.pushMap((WritableMap) r108);
        goto L29
    L32:
        r106.pushArray((WritableArray) r108);
        goto L29
    L55:
        return r106;
    L57:
        if ((r100 instanceof JsonNull) == false) goto L60;
        return null;
    L60:
        throw new IllegalStateException("unsupportable json type".toString());
    }
}
