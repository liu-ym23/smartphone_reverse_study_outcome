package com.bytedance.rts.foundation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class m {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> a(ArrayList<Object[]> r100) {
        Intrinsics.checkNotNullParameter(r100, "arr");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<Object[]> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Object[] r103 = r102.next();
        r101.put(r103[0], r103[1]);
        goto L4
    L6:
        return r101;
    }

    public static final <K, V> ArrayList<K> c(Map<K, ? extends V> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new ArrayList(r100.keySet());
    }

    public static final <K, V> boolean b(Map<K, ? extends V> r100, K r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.containsKey(r101);
    }

    public static final <K, V> void d(Map<K, ? extends V> r100, Function2<? super V, ? super K, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Iterator<Map.Entry<K, ? extends V>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<K, ? extends V> r103 = r102.next();
        r101.invoke(r103.getValue(), r103.getKey());
        goto L4
    }

    public static final <K, V> boolean delete(Map<K, V> r100, K r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.remove(r101) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void e(Map r100, Object r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.put(r101, r102);
    }
}
