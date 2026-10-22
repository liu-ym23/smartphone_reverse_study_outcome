package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public static final Map<Type, JsonDeserializer<?>> a = null;
    public static final Gson b = null;

    static {
        Map<Type, JsonDeserializer<?>> r0 = MapsKt.mapOf(new Pair[]{TuplesKt.to(n0.class, new GsonDeserializer.WrapperJsonDeserializer()), TuplesKt.to(q0.class, new GsonDeserializer.WrapperJsonDeserializer()), TuplesKt.to(o0.class, new GsonDeserializer.WrapperJsonDeserializer())});
        a = r0;
        GsonBuilder r1 = new GsonBuilder();
        Iterator<T> r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Map.Entry r3 = (Map.Entry) r2.next();
        r1.registerTypeAdapter((Type) r3.getKey(), (JsonDeserializer) r3.getValue());
        goto L4
    L6:
        b = r1.create();
    }

    public static final <T> T a(JsonElement r1, Class<T> r2) {
        Intrinsics.checkNotNullParameter(r1, "json");
        Intrinsics.checkNotNullParameter(r2, "classOfT");
        return (T) GsonProtectorUtils.fromJson(b, r1, r2);
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    }
}
