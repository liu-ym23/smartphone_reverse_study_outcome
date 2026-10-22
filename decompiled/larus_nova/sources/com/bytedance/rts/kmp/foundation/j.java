package com.bytedance.rts.kmp.foundation;

import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class j {
    @RTSHiddenFromObjC
    public static final <K, V> boolean a(Map<K, V> r100, K r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.remove(r101) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @RTSHiddenFromObjC
    public static final <K, V> void b(Map<K, ? extends V> r100, Function2<? super V, ? super K, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Iterator<Map.Entry<K, ? extends V>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<K, ? extends V> r103 = r102.next();
        r101.invoke(r103.getValue(), r103.getKey());
        goto L4
    }

    @RTSHiddenFromObjC
    public static final <K, V> V c(Map<K, ? extends V> r100, K r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.get(r101);
    }

    @RTSHiddenFromObjC
    public static final <K, V> boolean d(Map<K, ? extends V> r100, K r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.containsKey(r101);
    }

    @RTSHiddenFromObjC
    public static final <K, V> boolean delete(Map<K, V> r100, K r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return a(r100, r101);
    }

    @RTSHiddenFromObjC
    public static final void e(Map r100, Object r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.put(r101, r102);
    }
}
