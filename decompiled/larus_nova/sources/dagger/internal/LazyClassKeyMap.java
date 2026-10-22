package dagger.internal;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes41.dex */
public final class LazyClassKeyMap<V> implements Map<Class<?>, V> {
    private final Map<String, V> delegate;

    public static class MapFactory<V> implements Factory<Map<Class<?>, V>> {
        Factory<Map<String, V>> delegate;

        @Override // javax.inject.Provider
        public Map<Class<?>, V> get() {
            return LazyClassKeyMap.of(this.delegate.get());
        }

        @Override // javax.inject.Provider
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        private MapFactory(Factory<Map<String, V>> r100) {
            this.delegate = r100;
        }

        public static <V> MapFactory<V> of(Factory<Map<String, V>> r100) {
            return new MapFactory(r100);
        }
    }

    public static class MapProviderFactory<V> implements Factory<Map<Class<?>, Provider<V>>> {
        Factory<Map<String, Provider<V>>> delegate;

        @Override // javax.inject.Provider
        public Map<Class<?>, Provider<V>> get() {
            return LazyClassKeyMap.of(this.delegate.get());
        }

        @Override // javax.inject.Provider
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        private MapProviderFactory(Factory<Map<String, Provider<V>>> r100) {
            this.delegate = r100;
        }

        public static <V> MapProviderFactory<V> of(Factory<Map<String, Provider<V>>> r100) {
            return new MapProviderFactory(r100);
        }
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Dagger map bindings are immutable");
    }

    @Override // java.util.Map
    public Set<Map.Entry<Class<?>, V>> entrySet() {
        throw new UnsupportedOperationException("Maps created with @LazyClassKey do not support usage of entrySet(). Consider @ClassKey instead.");
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // java.util.Map
    public Set<Class<?>> keySet() {
        throw new UnsupportedOperationException("Maps created with @LazyClassKey do not support usage of keySet(). Consider @ClassKey instead.");
    }

    @Override // java.util.Map
    public int size() {
        return this.delegate.size();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return this.delegate.values();
    }

    private LazyClassKeyMap(Map<String, V> r100) {
        this.delegate = r100;
    }

    public static <V> Map<Class<?>, V> of(Map<String, V> r100) {
        return new LazyClassKeyMap(r100);
    }

    @Override // java.util.Map
    public boolean containsKey(Object r100) {
        if ((r100 instanceof Class) == false) goto L7;
        return this.delegate.containsKey(((Class) r100).getName());
    L7:
        throw new IllegalArgumentException("Key must be a class");
    }

    @Override // java.util.Map
    public boolean containsValue(Object r100) {
        return this.delegate.containsValue(r100);
    }

    @Override // java.util.Map
    public V get(Object r100) {
        if ((r100 instanceof Class) == false) goto L7;
        return this.delegate.get(((Class) r100).getName());
    L7:
        throw new IllegalArgumentException("Key must be a class");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Class<?>, ? extends V> r100) {
        throw new UnsupportedOperationException("Dagger map bindings are immutable");
    }

    @Override // java.util.Map
    public V remove(Object r100) {
        throw new UnsupportedOperationException("Dagger map bindings are immutable");
    }

    /* JADX INFO: renamed from: put, reason: avoid collision after fix types in other method */
    public V put2(Class<?> r100, V r101) {
        throw new UnsupportedOperationException("Dagger map bindings are immutable");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(Class<?> r100, Object r101) {
        return put2(r100, r101);
    }
}
