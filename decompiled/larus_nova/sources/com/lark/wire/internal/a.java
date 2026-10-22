package com.lark.wire.internal;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {
    public static final void a(List<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        int r101 = r100.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        if (ListProtector.get(r100, r102) == null) goto L8;
        r102 = r102 + 1;
        goto L3
    L8:
        throw new NullPointerException("Element at index " + r102 + " is null");
    }

    public static final void e(Object... r100) {
        Intrinsics.checkNotNullParameter(r100, "args");
        StringBuilder r101 = new StringBuilder();
        int r102 = ProgressionUtilKt.getProgressionLastElement(0, r100.length - 1, 2);
        String r103 = "";
        if (r102 < 0) goto L17;
        int r104 = 0;
    L6:
        if (r100[r104] == null) goto L8;
    L14:
        if (r104 == r102) goto L17;
        r104 = r104 + 2;
        goto L6
    L8:
        if (r101.length() <= 0) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L13;
        r103 = "s";
    L13:
        r101.append("\n  ");
        r101.append(r100[r104 + 1]);
        goto L14
    L10:
        r105 = false;
    L17:
        throw new IllegalStateException("Required field" + r103 + " not set:" + r101.toString());
    }

    public static final <T> List<T> c(String r100, List<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "list");
        if ((r101 instanceof MutableOnWriteList) == false) goto L6;
        r101 = (List<T>) ((MutableOnWriteList) r101).getMutableList$wire_runtime();
    L6:
        if (r101 != CollectionsKt.emptyList()) goto L8;
        return (List<T>) r101;
    L8:
        if ((r101 instanceof ImmutableList) == true) goto L17;
        ImmutableList r102 = new ImmutableList(r101);
        if ((!r102.contains(null)) == false) goto L14;
        return r102;
    L14:
        throw new IllegalArgumentException(r100.concat(".contains(null)").toString());
    L17:
        return (List<T>) r101;
    }

    public static final <K, V> Map<K, V> d(String r100, Map<K, ? extends V> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "map");
        if (r101.isEmpty() == true) goto L15;
        LinkedHashMap r102 = new LinkedHashMap(r101);
        Set<K> r103 = r102.keySet();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.collections.Collection<K of com.lark.wire.internal.Internal__InternalKt.immutableCopyOf?>");
        if ((!r103.contains(null)) == false) goto L14;
        Collection<V> r104 = r102.values();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.collections.Collection<V of com.lark.wire.internal.Internal__InternalKt.immutableCopyOf?>");
        if ((!r104.contains(null)) == false) goto L12;
        return Collections.unmodifiableMap(r102);
    L12:
        throw new IllegalArgumentException(r100.concat(".containsValue(null)").toString());
    L14:
        throw new IllegalArgumentException(r100.concat(".containsKey(null)").toString());
    L15:
        return MapsKt.emptyMap();
    }

    public static final int b(Object r100, Object r101, Object r102, Object r103, Object... r104) {
        Intrinsics.checkNotNullParameter(r104, "rest");
        int r105 = 0;
        if (r100 == null) goto L5;
        int r106 = 1;
    L6:
        if (r101 == null) goto L8;
        r106 = r106 + 1;
    L8:
        if (r102 == null) goto L10;
        r106 = r106 + 1;
    L10:
        if (r103 == null) goto L12;
        r106 = r106 + 1;
    L12:
        int r107 = r104.length;
    L13:
        if (r105 >= r107) goto L18;
        if (r104[r105] == null) goto L17;
        r106 = r106 + 1;
    L17:
        r105 = r105 + 1;
        goto L13
    L18:
        return r106;
    L5:
        r106 = 0;
        goto L6
    }
}
