package com.google.protobuf;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes23.dex */
public final class MapFieldLite<K, V> extends LinkedHashMap<K, V> {
    private static final MapFieldLite EMPTY_MAP_FIELD = null;
    private boolean isMutable;

    public void makeImmutable() {
        this.isMutable = false;
    }

    static {
        MapFieldLite r100 = new MapFieldLite();
        EMPTY_MAP_FIELD = r100;
        r100.makeImmutable();
    }

    private MapFieldLite() {
        this.isMutable = true;
    }

    private void ensureMutable() {
        if (isMutable() == false) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        ensureMutable();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (isEmpty() == false) goto L6;
        return Collections.emptySet();
    L6:
        return super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return calculateHashCodeForMap(this);
    }

    public MapFieldLite<K, V> mutableCopy() {
        if (isEmpty() == false) goto L6;
        return new MapFieldLite();
    L6:
        return new MapFieldLite(this);
    }

    public static <K, V> MapFieldLite<K, V> emptyMapField() {
        return EMPTY_MAP_FIELD;
    }

    public boolean isMutable() {
        return this.isMutable;
    }

    private MapFieldLite(Map<K, V> r100) {
        super(r100);
        this.isMutable = true;
    }

    public static <K, V> int calculateHashCodeForMap(Map<K, V> r100) {
        Iterator<Map.Entry<K, V>> r101 = r100.entrySet().iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<K, V> r103 = r101.next();
        int r104 = calculateHashCodeForObject(r103.getKey());
        r102 = r102 + (calculateHashCodeForObject(r103.getValue()) ^ r104);
        goto L4
    L6:
        return r102;
    }

    private static int calculateHashCodeForObject(Object r100) {
        if ((r100 instanceof byte[]) == false) goto L7;
        return Internal.hashCode((byte[]) r100);
    L7:
        if ((r100 instanceof Internal.EnumLite) == true) goto L11;
        return r100.hashCode();
    L11:
        throw new UnsupportedOperationException();
    }

    private static void checkForNullKeysAndValues(Map<?, ?> r100) {
        Iterator<?> r101 = r100.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Object r102 = r101.next();
        Internal.checkNotNull(r102);
        Internal.checkNotNull(r100.get(r102));
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> Map<K, V> copy(Map<K, V> r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<Map.Entry<K, V>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<K, V> r103 = r102.next();
        r101.put(r103.getKey(), copy(r103.getValue()));
        goto L4
    L6:
        return r101;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object r100) {
        if ((r100 instanceof Map) == true) goto L5;
    L7:
        return false;
    L5:
        if (equals(this, (Map) r100) == false) goto L7;
        return true;
    }

    public void mergeFrom(MapFieldLite<K, V> r100) {
        ensureMutable();
        if (r100.isEmpty() == true) goto L6;
        putAll(r100);
        return;
    }

    public V put(Map.Entry<K, V> r100) {
        return put(r100.getKey(), r100.getValue());
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r100) {
        ensureMutable();
        checkForNullKeysAndValues(r100);
        super.putAll(r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V remove(Object r100) {
        ensureMutable();
        return (V) super.remove(r100);
    }

    private static Object copy(Object r100) {
        if ((r100 instanceof byte[]) == false) goto L6;
        byte[] r101 = (byte[]) r100;
        return Arrays.copyOf(r101, r101.length);
    L6:
        return r100;
    }

    public static <K, V> boolean equals(Map<K, V> r100, Map<K, V> r101) {
        if (r100 != r101) goto L6;
        return true;
    L6:
        if (r100.size() == r101.size()) goto L8;
        return false;
    L8:
        Iterator<Map.Entry<K, V>> r102 = r100.entrySet().iterator();
    L10:
        if (r102.hasNext() == false) goto L17;
        Map.Entry<K, V> r103 = r102.next();
        if (r101.containsKey(r103.getKey()) == false) goto L13;
        if (equals(r103.getValue(), r101.get(r103.getKey())) == true) goto L10;
        return false;
    L13:
        return false;
    L17:
        return true;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V put(K r100, V r101) {
        ensureMutable();
        Internal.checkNotNull(r100);
        Internal.checkNotNull(r101);
        return (V) super.put(r100, r101);
    }

    private static boolean equals(Object r100, Object r101) {
        if ((r100 instanceof byte[]) == false) goto L9;
        if ((r101 instanceof byte[]) == false) goto L9;
        return Arrays.equals((byte[]) r100, (byte[]) r101);
    L9:
        return r100.equals(r101);
    }
}
