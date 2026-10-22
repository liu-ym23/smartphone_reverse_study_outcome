package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class EnumHashBiMap<K extends Enum<K>, V> extends AbstractBiMap<K, V> {
    private static final long serialVersionUID = 0;
    transient Class<K> keyTypeOrObjectUnderJ2cl;

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

    public EnumHashBiMap(Class<K> r100) {
        super(new EnumMap(r100), new HashMap());
        this.keyTypeOrObjectUnderJ2cl = r100;
    }

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Map<K, ? extends V> r100) {
        EnumHashBiMap<K, V> r101 = create(EnumBiMap.inferKeyTypeOrObjectUnderJ2cl(r100));
        r101.putAll(r100);
        return r101;
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        this.keyTypeOrObjectUnderJ2cl = (Class) r100.readObject();
        setDelegates(new EnumMap(this.keyTypeOrObjectUnderJ2cl), new HashMap());
        j2.b(this, r100, r100.readInt());
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        r100.writeObject(this.keyTypeOrObjectUnderJ2cl);
        j2.e(this, r100);
    }

    @Override // com.google.common.collect.AbstractBiMap
    public /* bridge */ /* synthetic */ Object checkKey(Object r100) {
        return checkKey((Enum) r100);
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

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Class<K> r100) {
        return new EnumHashBiMap(r100);
    }

    public K checkKey(K r100) {
        r100.getClass();
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.m
    @CheckForNull
    public /* bridge */ /* synthetic */ Object forcePut(Object r100, @ParametricNullness Object r101) {
        return forcePut((Enum) r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.k0, java.util.Map
    @CheckForNull
    public /* bridge */ /* synthetic */ Object put(Object r100, @ParametricNullness Object r101) {
        return put((Enum) r100, r101);
    }

    @CheckForNull
    public V forcePut(K r100, @ParametricNullness V r101) {
        return (V) super.forcePut(r100, r101);
    }

    @CheckForNull
    public V put(K r100, @ParametricNullness V r101) {
        return (V) super.put(r100, r101);
    }
}
