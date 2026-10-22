package com.bytedance.timon_monitor_impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final <K, V> JSONObject a(Map<K, ? extends V> r100) {
        JSONObject r101 = new JSONObject();
        Iterator<Map.Entry<K, ? extends V>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L65;
        Map.Entry<K, ? extends V> r103 = r102.next();
        K r104 = r103.getKey();
        if ((r104 instanceof String) == true) goto L8;
        r104 = (K) null;
    L8:
        String r105 = r104;
        if (r105 != null) goto L12;
        r105 = "null";
    L12:
        Object r106 = r103.getValue();
        if (r106 != null) goto L15;
    L63:
        r106 = JSONObject.NULL;
    L64:
        r101.put(r105, r106);
        goto L4
    L15:
        if (Intrinsics.areEqual(r106, JSONObject.NULL) == true) goto L63;
        if ((r106 instanceof JSONArray) == true) goto L64;
        if ((r106 instanceof JSONObject) == true) goto L64;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L60
        if ((r106 instanceof Collection) == false) goto L27;
        JSONArray r108 = new JSONArray((Collection) r106);     // Catch: Throwable -> L60
    L25:
        r106 = r108;
        goto L64
    L27:
        if (r106.getClass().isArray() == false) goto L30;
        r108 = new JSONArray(r106);     // Catch: Throwable -> L60
        goto L25
    L30:
        if ((r106 instanceof Map) == false) goto L33;
        r106 = a((Map) r106);     // Catch: Throwable -> L60
        goto L64
    L33:
        if ((r106 instanceof Boolean) == true) goto L64;
        if ((r106 instanceof Byte) == true) goto L64;
        if ((r106 instanceof Character) == true) goto L64;
        if ((r106 instanceof Double) == true) goto L64;
        if ((r106 instanceof Float) == true) goto L64;
        if ((r106 instanceof Integer) == true) goto L64;
        if ((r106 instanceof Long) == true) goto L64;
        if ((r106 instanceof Short) == true) goto L64;
        if ((r106 instanceof String) == true) goto L64;
        Package r109 = r106.getClass().getPackage();     // Catch: Throwable -> L60
        if (r109 == null) goto L58;
        String r110 = r109.getName();     // Catch: Throwable -> L60
        if (r110 == null) goto L58;
        if (StringsKt.startsWith$default(r110, "java.", false, 2, null) != true) goto L58;
        r106 = r106.toString();     // Catch: Throwable -> L60
    L58:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L60
    L62:
        r106 = JSONObject.NULL;
    L60:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L62
    L65:
        return r101;
    }
}
