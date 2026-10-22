package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class ImmutableMap<K, V> extends HashMap<K, V> {
    public static <K, V> Map<K, V> of() {
        return Collections.unmodifiableMap(new HashMap());
    }

    private ImmutableMap(Map<? extends K, ? extends V> r100) {
        super(r100);
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> r100) {
        return new ImmutableMap(r100);
    }

    public static <K, V> Map<K, V> of(K r100, V r101) {
        HashMap r102 = new HashMap(1);
        r102.put(r100, r101);
        return Collections.unmodifiableMap(r102);
    }

    public static <K, V> Map<K, V> of(K r100, V r101, K r102, V r103) {
        HashMap r104 = new HashMap(2);
        r104.put(r100, r101);
        r104.put(r102, r103);
        return Collections.unmodifiableMap(r104);
    }

    public static <K, V> Map<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105) {
        HashMap r106 = new HashMap(3);
        r106.put(r100, r101);
        r106.put(r102, r103);
        r106.put(r104, r105);
        return Collections.unmodifiableMap(r106);
    }

    public static <K, V> Map<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105, K r106, V r107) {
        HashMap r108 = new HashMap(4);
        r108.put(r100, r101);
        r108.put(r102, r103);
        r108.put(r104, r105);
        r108.put(r106, r107);
        return Collections.unmodifiableMap(r108);
    }

    public static <K, V> Map<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105, K r106, V r107, K r110, V r111) {
        HashMap r108 = new HashMap(5);
        r108.put(r100, r101);
        r108.put(r102, r103);
        r108.put(r104, r105);
        r108.put(r106, r107);
        r108.put(r110, r111);
        return Collections.unmodifiableMap(r108);
    }

    public static <K, V> Map<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105, K r106, V r107, K r110, V r111, K r112, V r113) {
        HashMap r108 = new HashMap(6);
        r108.put(r100, r101);
        r108.put(r102, r103);
        r108.put(r104, r105);
        r108.put(r106, r107);
        r108.put(r110, r111);
        r108.put(r112, r113);
        return Collections.unmodifiableMap(r108);
    }
}
