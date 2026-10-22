package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class CollectionsKt {
    private static final int capacity(int r100) {
        if (r100 >= 3) goto L6;
        return 3;
    L6:
        return (r100 + (r100 / 3)) + 1;
    }

    public static final <T> List<T> compact(ArrayList<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.size();
        if (r101 == 0) goto L9;
        if (r101 == 1) goto L11;
        r100.trimToSize();
        return r100;
    L11:
        return kotlin.collections.CollectionsKt.listOf(kotlin.collections.CollectionsKt.first(r100));
    L9:
        return kotlin.collections.CollectionsKt.emptyList();
    }

    public static final <K> Map<K, Integer> mapToIndex(Iterable<? extends K> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<? extends K> r102 = r100.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L6;
        int r104 = r103 + 1;
        r101.put(r102.next(), Integer.valueOf(r103));
        r103 = r104;
        goto L4
    L6:
        return r101;
    }

    public static final <K, V> HashMap<K, V> newHashMapWithExpectedSize(int r100) {
        return new HashMap(capacity(r100));
    }

    public static final <E> HashSet<E> newHashSetWithExpectedSize(int r100) {
        return new HashSet(capacity(r100));
    }

    public static final <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int r100) {
        return new LinkedHashSet(capacity(r100));
    }

    public static final <T> void addIfNotNull(Collection<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == null) goto L6;
        r100.add(r101);
        return;
    }
}
