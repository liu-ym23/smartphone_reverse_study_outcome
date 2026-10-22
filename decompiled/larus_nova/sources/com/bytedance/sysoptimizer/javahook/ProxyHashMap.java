package com.bytedance.sysoptimizer.javahook;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX INFO: loaded from: classes22.dex */
public class ProxyHashMap<K, V> extends HashMap<K, V> {
    private static final String TAG = "ProxyHashMap";

    @Override // java.util.HashMap, java.util.AbstractMap
    public Object clone() {
        return super.clone();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        return super.keySet();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public int size() {
        return super.size();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        return super.values();
    }

    public ProxyHashMap() {
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        super.clear();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r100) {
        return super.containsKey(r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object r100) {
        return super.containsValue(r100);
    }

    @Override // java.util.HashMap, java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> r100) {
        super.forEach(r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V get(Object r100) {
        return (V) super.get(r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r100) {
        super.putAll(r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V remove(Object r100) {
        return (V) super.remove(r100);
    }

    @Override // java.util.HashMap, java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> r100) {
        super.replaceAll(r100);
    }

    @Override // java.util.HashMap, java.util.Map
    public V compute(K r100, BiFunction<? super K, ? super V, ? extends V> r101) {
        return (V) super.compute(r100, r101);
    }

    @Override // java.util.HashMap, java.util.Map
    public V computeIfAbsent(K r100, Function<? super K, ? extends V> r101) {
        return (V) super.computeIfAbsent(r100, r101);
    }

    @Override // java.util.HashMap, java.util.Map
    public V computeIfPresent(K r100, BiFunction<? super K, ? super V, ? extends V> r101) {
        return (V) super.computeIfPresent(r100, r101);
    }

    @Override // java.util.HashMap, java.util.Map
    public V getOrDefault(Object r100, V r101) {
        return (V) super.getOrDefault(r100, r101);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V put(K r100, V r101) {
        Objects.toString(r100);
        Objects.toString(r101);
        return (V) super.put(r100, r101);
    }

    @Override // java.util.HashMap, java.util.Map
    public V putIfAbsent(K r100, V r101) {
        return (V) super.putIfAbsent(r100, r101);
    }

    @Override // java.util.HashMap, java.util.Map
    public boolean remove(Object r100, Object r101) {
        return super.remove(r100, r101);
    }

    @Override // java.util.HashMap, java.util.Map
    public V replace(K r100, V r101) {
        return (V) super.replace(r100, r101);
    }

    @Override // java.util.HashMap, java.util.Map
    public V merge(K r100, V r101, BiFunction<? super V, ? super V, ? extends V> r102) {
        return (V) super.merge(r100, r101, r102);
    }

    @Override // java.util.HashMap, java.util.Map
    public boolean replace(K r100, V r101, V r102) {
        return super.replace(r100, r101, r102);
    }
}
