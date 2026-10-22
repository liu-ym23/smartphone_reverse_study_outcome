package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class EnumBiMap<K extends Enum<K>, V extends Enum<V>> extends AbstractBiMap<K, V> {
    private static final long serialVersionUID = 0;
    transient Class<K> keyTypeOrObjectUnderJ2cl;
    transient Class<V> valueTypeOrObjectUnderJ2cl;

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.k0, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.m
    public /* bridge */ /* synthetic */ m inverse() {
        return super.inverse();
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.k0, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.k0, java.util.Map
    public /* bridge */ /* synthetic */ Set values() {
        return super.values();
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.k0, java.util.Map
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public Class<K> keyType() {
        return this.keyTypeOrObjectUnderJ2cl;
    }

    public Class<V> valueType() {
        return this.valueTypeOrObjectUnderJ2cl;
    }

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Map<K, V> r100) {
        Class r101 = inferKeyTypeOrObjectUnderJ2cl(r100);
        if ((r100 instanceof EnumBiMap) == false) goto L5;
        Class<V> r102 = ((EnumBiMap) r100).valueTypeOrObjectUnderJ2cl;
    L6:
        EnumBiMap<K, V> r103 = create(r101, r102);
        r103.putAll(r100);
        return r103;
    L5:
        com.google.common.base.m.b(!r100.isEmpty());
        r102 = r100.values().iterator().next().getDeclaringClass();
        goto L6
    }

    public static <K extends Enum<K>> Class<K> inferKeyTypeOrObjectUnderJ2cl(Map<K, ?> r100) {
        if ((r100 instanceof EnumBiMap) == false) goto L7;
        return ((EnumBiMap) r100).keyTypeOrObjectUnderJ2cl;
    L7:
        if ((r100 instanceof EnumHashBiMap) == true) goto L9;
        com.google.common.base.m.b(!r100.isEmpty());
        return r100.keySet().iterator().next().getDeclaringClass();
    L9:
        return ((EnumHashBiMap) r100).keyTypeOrObjectUnderJ2cl;
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        this.keyTypeOrObjectUnderJ2cl = (Class) r100.readObject();
        this.valueTypeOrObjectUnderJ2cl = (Class) r100.readObject();
        setDelegates(new EnumMap(this.keyTypeOrObjectUnderJ2cl), new EnumMap(this.valueTypeOrObjectUnderJ2cl));
        j2.b(this, r100, r100.readInt());
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        r100.writeObject(this.keyTypeOrObjectUnderJ2cl);
        r100.writeObject(this.valueTypeOrObjectUnderJ2cl);
        j2.e(this, r100);
    }

    @Override // com.google.common.collect.AbstractBiMap
    public /* bridge */ /* synthetic */ Object checkKey(Object r100) {
        return checkKey((Enum) r100);
    }

    @Override // com.google.common.collect.AbstractBiMap
    public /* bridge */ /* synthetic */ Object checkValue(Object r100) {
        return checkValue((Enum) r100);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.k0, java.util.Map
    public /* bridge */ /* synthetic */ boolean containsValue(@CheckForNull Object r100) {
        return super.containsValue(r100);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.k0, java.util.Map
    public /* bridge */ /* synthetic */ void putAll(Map r100) {
        super.putAll(r100);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.k0, java.util.Map
    @CheckForNull
    public /* bridge */ /* synthetic */ Object remove(@CheckForNull Object r100) {
        return super.remove(r100);
    }

    public K checkKey(K r100) {
        r100.getClass();
        return r100;
    }

    public V checkValue(V r100) {
        r100.getClass();
        return r100;
    }

    public EnumBiMap(Class<K> r100, Class<V> r101) {
        super(new EnumMap(r100), new EnumMap(r101));
        this.keyTypeOrObjectUnderJ2cl = r100;
        this.valueTypeOrObjectUnderJ2cl = r101;
    }

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Class<K> r100, Class<V> r101) {
        return new EnumBiMap(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.m
    @CheckForNull
    public /* bridge */ /* synthetic */ Object forcePut(@ParametricNullness Object r100, @ParametricNullness Object r101) {
        return super.forcePut(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.k0, java.util.Map
    @CheckForNull
    public /* bridge */ /* synthetic */ Object put(@ParametricNullness Object r100, @ParametricNullness Object r101) {
        return super.put(r100, r101);
    }
}
