package com.google.crypto.tink.shaded.protobuf;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes23.dex */
public final class MapFieldLite<K, V> extends LinkedHashMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MapFieldLite<?, ?> f275828a = null;
    private boolean isMutable;

    public void makeImmutable() {
        this.isMutable = false;
    }

    static {
        MapFieldLite<?, ?> r100 = new MapFieldLite();
        f275828a = r100;
        r100.makeImmutable();
    }

    private MapFieldLite() {
        this.isMutable = true;
    }

    public final void b() {
        if (isMutable() == false) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        b();
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
        return (MapFieldLite<K, V>) f275828a;
    }

    public boolean isMutable() {
        return this.isMutable;
    }

    public MapFieldLite(Map<K, V> r100) {
        super(r100);
        this.isMutable = true;
    }

    public static int a(Object r100) {
        if ((r100 instanceof byte[]) == false) goto L12;
        byte[] r101 = (byte[]) r100;
        Charset r102 = e.f275885a;
        int r103 = r101.length;
        int r104 = r103;
        int r105 = 0;
    L6:
        if (r105 >= (0 + r103)) goto L8;
        r104 = (r104 * 31) + r101[r105];
        r105 = r105 + 1;
        goto L6
    L8:
        if (r104 != 0) goto L18;
        return 1;
    L18:
        return r104;
    L12:
        if ((r100 instanceof e.a) == true) goto L16;
        return r100.hashCode();
    L16:
        throw new UnsupportedOperationException();
    }

    public static <K, V> int calculateHashCodeForMap(Map<K, V> r100) {
        Iterator<Map.Entry<K, V>> r101 = r100.entrySet().iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<K, V> r103 = r101.next();
        int r104 = a(r103.getKey());
        r102 = r102 + (a(r103.getValue()) ^ r104);
        goto L4
    L6:
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> Map<K, V> copy(Map<K, V> r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<Map.Entry<K, V>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Map.Entry<K, V> r103 = r102.next();
        K r104 = r103.getKey();
        V r105 = r103.getValue();
        if ((r105 instanceof byte[]) == false) goto L8;
        byte[] r106 = (byte[]) r105;
        r105 = (V) Arrays.copyOf(r106, r106.length);
    L8:
        r101.put(r104, r105);
        goto L4
    L9:
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
        b();
        if (r100.isEmpty() == true) goto L6;
        putAll(r100);
        return;
    }

    public V put(Map.Entry<K, V> r100) {
        return put(r100.getKey(), r100.getValue());
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r100) {
        b();
        Iterator<? extends K> r101 = r100.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        K r102 = r101.next();
        Charset r103 = e.f275885a;
        r102.getClass();
        r100.get(r102).getClass();
        goto L4
    L6:
        super.putAll(r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V remove(Object r100) {
        b();
        return (V) super.remove(r100);
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
        if (r102.hasNext() == false) goto L22;
        Map.Entry<K, V> r103 = r102.next();
        if (r101.containsKey(r103.getKey()) == false) goto L13;
        V r104 = r103.getValue();
        V r105 = r101.get(r103.getKey());
        if ((r104 instanceof byte[]) == true) goto L17;
    L19:
        boolean r106 = r104.equals(r105);
    L20:
        if (r106 == true) goto L10;
        return false;
    L17:
        if ((r105 instanceof byte[]) == false) goto L19;
        r106 = Arrays.equals((byte[]) r104, (byte[]) r105);
        goto L20
    L13:
        return false;
    L22:
        return true;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V put(K r100, V r101) {
        b();
        Charset r102 = e.f275885a;
        r100.getClass();
        r101.getClass();
        return (V) super.put(r100, r101);
    }
}
