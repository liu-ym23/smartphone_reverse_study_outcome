package com.google.android.gms.common.util;

import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes23.dex */
public final class CollectionUtils {
    private CollectionUtils() {
    }

    public static <T> List<T> listOf() {
        return Collections.emptyList();
    }

    public static boolean isEmpty(Collection<?> r100) {
        if (r100 != null) goto L6;
        return true;
    L6:
        return r100.isEmpty();
    }

    public static <T> List<T> listOf(T... r100) {
        int r101 = r100.length;
        if (r101 == 0) goto L11;
        if (r101 == 1) goto L9;
        return Collections.unmodifiableList(Arrays.asList(r100));
    L9:
        return Collections.singletonList(r100[0]);
    L11:
        return Collections.emptyList();
    }

    public static <T> Set<T> mutableSetOfWithSize(int r100) {
        if (r100 != 0) goto L5;
        return new ArraySet();
    L5:
        return zzb(r100, true);
    }

    public static <T> Set<T> setOf(T... r100) {
        int r101 = r100.length;
        if (r101 == 0) goto L23;
        if (r101 == 1) goto L21;
        if (r101 != 2) goto L9;
        T r102 = r100[0];
        T r103 = r100[1];
        Set r104 = zzb(2, false);
        r104.add(r102);
        r104.add(r103);
        return Collections.unmodifiableSet(r104);
    L9:
        if (r101 == 3) goto L17;
        if (r101 == 4) goto L14;
        Set r105 = zzb(r101, false);
        Collections.addAll(r105, r100);
        return Collections.unmodifiableSet(r105);
    L14:
        T r106 = r100[0];
        T r107 = r100[1];
        T r108 = r100[2];
        T r109 = r100[3];
        Set r110 = zzb(4, false);
        r110.add(r106);
        r110.add(r107);
        r110.add(r108);
        r110.add(r109);
        return Collections.unmodifiableSet(r110);
    L17:
        return setOf(r100[0], r100[1], r100[2]);
    L21:
        return Collections.singleton(r100[0]);
    L23:
        return Collections.emptySet();
    }

    public static <T> List<T> listOf(T r100) {
        return Collections.singletonList(r100);
    }

    public static <K, V> Map<K, V> mapOfKeyValueArrays(K[] r100, V[] r101) {
        int r102 = r100.length;
        int r103 = r101.length;
        if (r102 != r103) goto L18;
        if (r102 == 0) goto L16;
        int r104 = 0;
        if (r102 == 1) goto L14;
        Map r105 = zza(r102, false);
    L9:
        if (r104 >= r100.length) goto L12;
        r105.put(r100[r104], r101[r104]);
        r104 = r104 + 1;
        goto L9
    L12:
        return Collections.unmodifiableMap(r105);
    L14:
        return Collections.singletonMap(r100[0], r101[0]);
    L16:
        return Collections.emptyMap();
    L18:
        throw new IllegalArgumentException("Key and values array lengths not equal: " + r102 + " != " + r103);
    }

    private static Map zza(int r100, boolean r101) {
        if (r100 > 256) goto L6;
        return new ArrayMap(r100);
    L6:
        return new HashMap(r100, 1.0f);
    }

    private static Set zzb(int r100, boolean r101) {
        if (true == r101) goto L5;
        int r102 = 256;
    L6:
        if (r100 <= r102) goto L13;
        if (true == r101) goto L10;
        float r103 = 1.0f;
    L12:
        return new HashSet(r100, r103);
    L10:
        r103 = 0.75f;
        goto L12
    L13:
        return new ArraySet(r100);
    L5:
        r102 = 128;
        goto L6
    }

    public static <T> Set<T> setOf(T r100, T r101, T r102) {
        Set r103 = zzb(3, false);
        r103.add(r100);
        r103.add(r101);
        r103.add(r102);
        return Collections.unmodifiableSet(r103);
    }

    public static <K, V> Map<K, V> mapOf(K r100, V r101, K r102, V r103, K r104, V r105) {
        Map r106 = zza(3, false);
        r106.put(r100, r101);
        r106.put(r102, r103);
        r106.put(r104, r105);
        return Collections.unmodifiableMap(r106);
    }

    public static <K, V> Map<K, V> mapOf(K r100, V r101, K r102, V r103, K r104, V r105, K r106, V r107, K r110, V r111, K r112, V r113) {
        Map r108 = zza(6, false);
        r108.put(r100, r101);
        r108.put(r102, r103);
        r108.put(r104, r105);
        r108.put(r106, r107);
        r108.put(r110, r111);
        r108.put(r112, r113);
        return Collections.unmodifiableMap(r108);
    }
}
