package com.bytedance.ruler.strategy.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class ConstPoolParser {
    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [T, com.google.gson.JsonElement] */
    public static void a(JsonObject r100) {
        Set<Map.Entry<String, JsonElement>> r101 = r100.entrySet();
        if (r101 == null) goto L41;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L49;
        Map.Entry r103 = (Map.Entry) r102.next();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L39
        String r105 = (String) r103.getKey();     // Catch: Throwable -> L39
        JsonObject r106 = ((JsonElement) r103.getValue()).getAsJsonObject();     // Catch: Throwable -> L39
        JsonElement r107 = r106.get("type");     // Catch: Throwable -> L39
        if (r107 == null) goto L11;
        String r108 = r107.getAsString();     // Catch: Throwable -> L39
    L12:
        final Ref.ObjectRef r109 = new Ref.ObjectRef();     // Catch: Throwable -> L39
        r109.element = r106.get("value");     // Catch: Throwable -> L39
        if (r108 == null) goto L37;
        int r110 = r108.hashCode();     // Catch: Throwable -> L39
        if (r110 == (-891985903)) goto L33;
        if (r110 == 315522569) goto L28;
        if (r110 != 406856875) goto L37;
        if (r108.equals("string_array") == false) goto L37;
        if ((((JsonElement) r109.element) instanceof JsonArray) == false) goto L37;
        ga7.b.a(new ga7.c(r105, new ConstPoolParser$parseConstPool$1$1$1(r109)));     // Catch: Throwable -> L39
        goto L37
    L28:
        if (r108.equals("int_array") == false) goto L37;
        if ((((JsonElement) r109.element) instanceof JsonArray) == false) goto L37;
        ga7.b.a(new ga7.c(r105, new ConstPoolParser$parseConstPool$1$1$3(r109)));     // Catch: Throwable -> L39
        goto L37
    L33:
        if (r108.equals("string") == false) goto L37;
        if ((((JsonElement) r109.element) instanceof JsonPrimitive) == false) goto L37;
        ga7.b.a(new ga7.c(r105, new ConstPoolParser$parseConstPool$1$1$2(r109)));     // Catch: Throwable -> L39
    L37:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L39
        goto L6
    L11:
        r108 = null;
    L39:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    L49:
        return;
    }

    public static void b(JsonObject r100) {
        Set<Map.Entry<String, JsonElement>> r101 = r100.entrySet();
        if (r101 == null) goto L47;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L57;
        Map.Entry r103 = (Map.Entry) r102.next();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L45
        JsonElement r105 = ((JsonElement) r103.getValue()).getAsJsonObject().get("value");     // Catch: Throwable -> L45
        String r106 = ((JsonElement) r103.getValue()).getAsJsonObject().get("type").getAsString();     // Catch: Throwable -> L45
        if (r106 == null) goto L43;
        int r107 = r106.hashCode();     // Catch: Throwable -> L45
        if (r107 == (-891985903)) goto L41;
        if (r107 == 315522569) goto L30;
        if (r107 != 406856875) goto L43;
        if (r106.equals("string_array") == false) goto L43;
        JsonArray r108 = r105.getAsJsonArray();     // Catch: Throwable -> L45
        if (r108.size() <= 32) goto L23;
        Collection r109 = new TreeSet();     // Catch: Throwable -> L45
    L24:
        Iterator<JsonElement> r110 = r108.iterator();     // Catch: Throwable -> L45
    L26:
        if (r110.hasNext() == false) goto L28;
        r109.add(r110.next().getAsString());     // Catch: Throwable -> L45
        goto L26
    L28:
        ga7.b.a(new ga7.a((String) r103.getKey(), r109));     // Catch: Throwable -> L45
        goto L43
    L23:
        r109 = new ArrayList();     // Catch: Throwable -> L45
        goto L24
    L30:
        if (r106.equals("int_array") == false) goto L43;
        JsonArray r111 = r105.getAsJsonArray();     // Catch: Throwable -> L45
        if (r111.size() <= 32) goto L34;
        Collection r112 = new TreeSet();     // Catch: Throwable -> L45
    L35:
        Iterator<JsonElement> r113 = r111.iterator();     // Catch: Throwable -> L45
    L37:
        if (r113.hasNext() == false) goto L39;
        r112.add(Integer.valueOf(r113.next().getAsInt()));     // Catch: Throwable -> L45
        goto L37
    L39:
        ga7.b.a(new ga7.a((String) r103.getKey(), r112));     // Catch: Throwable -> L45
        goto L43
    L34:
        r112 = new ArrayList();     // Catch: Throwable -> L45
        goto L35
    L41:
        if (r106.equals("string") == false) goto L43;
        ga7.b.a(new ga7.a((String) r103.getKey(), r105.getAsString()));     // Catch: Throwable -> L45
    L43:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    L57:
        return;
    }
}
