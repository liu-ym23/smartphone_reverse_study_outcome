package com.bytedance.rts.foundation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> a(ArrayList<Object[]> r4) {
        Intrinsics.checkNotNullParameter(r4, "arr");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Object[]> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Object[] r1 = r5.next();
        r0.put(r1[0], r1[1]);
        goto L4
    L6:
        return r0;
    }

    public static final <K, V> ArrayList<K> c(Map<K, ? extends V> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new ArrayList(r1.keySet());
    }

    public static final <K, V> boolean b(Map<K, ? extends V> r1, K r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.containsKey(r2);
    }

    public static final <K, V> void d(Map<K, ? extends V> r2, Function2<? super V, ? super K, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Iterator<Map.Entry<K, ? extends V>> r4 = r2.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry<K, ? extends V> r0 = r4.next();
        r3.invoke(r0.getValue(), r0.getKey());
        goto L4
    }

    public static final <K, V> boolean delete(Map<K, V> r1, K r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.remove(r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void e(Map r1, Object r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.put(r2, r3);
    }
}
