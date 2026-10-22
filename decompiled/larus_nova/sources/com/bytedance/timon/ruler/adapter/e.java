package com.bytedance.timon.ruler.adapter;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes22.dex */
public final class e {
    public static final void a(JsonArray r100, Function1<? super JsonObject, Unit> r101) {
        monitor-enter(r100);
        Iterator<JsonElement> r102 = r100.iterator();     // Catch: Throwable -> L15
    L5:
        if (r102.hasNext() == false) goto L12;
        JsonElement r103 = r102.next();     // Catch: Throwable -> L15
        if (r103.isJsonObject() == true) goto L8;
        if (r103.isJsonArray() == false) goto L5;
        a(r103.getAsJsonArray(), r101);     // Catch: Throwable -> L15
        goto L5
    L8:
        b(r103.getAsJsonObject(), r101);     // Catch: Throwable -> L15
        goto L5
    L12:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r100);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public static final void b(JsonObject r100, Function1<? super JsonObject, Unit> r101) {
        monitor-enter(r100);
        Iterator<T> r102 = r100.entrySet().iterator();     // Catch: Throwable -> L24
        boolean r103 = false;
    L5:
        if (r102.hasNext() == false) goto L19;
        Map.Entry r104 = (Map.Entry) r102.next();     // Catch: Throwable -> L24
        if (((String) r104.getKey()).equals("cel") == false) goto L14;
        if (((JsonElement) r104.getValue()).isJsonPrimitive() == false) goto L14;
        if (((JsonElement) r104.getValue()).getAsJsonPrimitive().isString() == false) goto L14;
        r103 = true;
    L14:
        if (((JsonElement) r104.getValue()).isJsonObject() == true) goto L15;
        if (((JsonElement) r104.getValue()).isJsonArray() == false) goto L5;
        a(((JsonElement) r104.getValue()).getAsJsonArray(), r101);     // Catch: Throwable -> L24
        goto L5
    L15:
        b(((JsonElement) r104.getValue()).getAsJsonObject(), r101);     // Catch: Throwable -> L24
        goto L5
    L19:
        if (r103 == false) goto L21;
        r101.invoke(r100);     // Catch: Throwable -> L24
    L21:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r100);
        return;
    L24:
        th = move-exception;
        throw th;
    }
}
