package com.bytedance.rts.kmp.foundation;

import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j {
    @RTSHiddenFromObjC
    public static final <K, V> boolean a(Map<K, V> r1, K r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.remove(r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @RTSHiddenFromObjC
    public static final <K, V> void b(Map<K, ? extends V> r2, Function2<? super V, ? super K, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Iterator<Map.Entry<K, ? extends V>> r4 = r2.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry<K, ? extends V> r0 = r4.next();
        r3.invoke(r0.getValue(), r0.getKey());
        goto L4
    }

    @RTSHiddenFromObjC
    public static final <K, V> V c(Map<K, ? extends V> r1, K r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.get(r2);
    }

    @RTSHiddenFromObjC
    public static final <K, V> boolean d(Map<K, ? extends V> r1, K r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.containsKey(r2);
    }

    @RTSHiddenFromObjC
    public static final <K, V> boolean delete(Map<K, V> r1, K r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return a(r1, r2);
    }

    @RTSHiddenFromObjC
    public static final void e(Map r1, Object r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.put(r2, r3);
    }
}
