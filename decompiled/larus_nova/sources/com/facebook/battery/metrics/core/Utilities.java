package com.facebook.battery.metrics.core;

import android.util.SparseArray;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: loaded from: classes22.dex */
public abstract class Utilities {
    public Utilities() {
    }

    public static void checkNotNull(Object r100, String r101) {
        if (r100 == null) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r101);
    }

    public static <K, V> boolean simpleArrayMapEquals(SimpleArrayMap<K, V> r100, SimpleArrayMap<K, V> r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        int r102 = r100.size();
        if (r102 == r101.size()) goto L8;
        return false;
    L8:
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L20;
        K r104 = r100.keyAt(r103);
        V r105 = r100.valueAt(r103);
        V r106 = r101.get(r104);
        if (r105 != null) goto L17;
        if (r106 != null) goto L15;
        if (r101.containsKey(r104) == false) goto L15;
    L19:
        r103 = r103 + 1;
    L15:
        return false;
    L17:
        if (r105.equals(r106) == true) goto L19;
        return false;
    L20:
        return true;
    }

    public static <V> boolean sparseArrayEquals(SparseArray<V> r100, SparseArray<V> r101) {
        if (r100 != r101) goto L6;
        return true;
    L6:
        if (r100 == null) goto L20;
        if (r101 == null) goto L20;
        if (r100.size() == r101.size()) goto L12;
        return false;
    L12:
        int r102 = 0;
    L14:
        if (r102 >= r100.size()) goto L19;
        int r103 = r100.keyAt(r102);
        if (r100.get(r103).equals(r101.get(r103)) == false) goto L17;
        r102 = r102 + 1;
        goto L14
    L17:
        return false;
    L19:
        return true;
    L20:
        return false;
    }
}
