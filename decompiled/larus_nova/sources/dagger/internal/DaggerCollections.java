package dagger.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class DaggerCollections {
    private static final int MAX_POWER_OF_TWO = 1073741824;

    private DaggerCollections() {
    }

    private static int calculateInitialCapacity(int r100) {
        if (r100 >= 3) goto L7;
        return r100 + 1;
    L7:
        if (r100 < 1073741824) goto L9;
        return Integer.MAX_VALUE;
    L9:
        return (int) ((r100 / 0.75f) + 1.0f);
    }

    public static <T> boolean hasDuplicates(List<T> r100) {
        if (r100.size() >= 2) goto L5;
        return false;
    L5:
        HashSet r101 = new HashSet(r100);
        if (r100.size() == r101.size()) goto L9;
        return true;
    L9:
        return false;
    }

    public static <T> HashSet<T> newHashSetWithExpectedSize(int r100) {
        return new HashSet(calculateInitialCapacity(r100));
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMapWithExpectedSize(int r100) {
        return new LinkedHashMap(calculateInitialCapacity(r100));
    }

    public static <T> List<T> presizedList(int r100) {
        if (r100 != 0) goto L6;
        return Collections.emptyList();
    L6:
        return new ArrayList(r100);
    }
}
