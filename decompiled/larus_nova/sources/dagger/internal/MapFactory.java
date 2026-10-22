package dagger.internal;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public final class MapFactory<K, V> extends AbstractMapFactory<K, V, V> {
    private static final Provider<Map<Object, Object>> EMPTY = null;

    /* JADX INFO: renamed from: dagger.internal.MapFactory$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, V> {
        public MapFactory<K, V> build() {
            return new MapFactory(this.map, null);
        }

        private Builder(int r100) {
            super(r100);
        }

        public Builder<K, V> putAll(javax.inject.Provider<Map<K, V>> r100) {
            return putAll(Providers.asDaggerProvider(r100));
        }

        @Override // dagger.internal.AbstractMapFactory.Builder
        public /* bridge */ /* synthetic */ AbstractMapFactory.Builder putAll(Provider r100) {
            return putAll(r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dagger.internal.AbstractMapFactory.Builder
        public Builder<K, V> putAll(Provider<Map<K, V>> r100) {
            super.putAll(r100);
            return this;
        }

        public /* synthetic */ Builder(int r100, AnonymousClass1 r101) {
            this(r100);
        }

        public Builder<K, V> put(K r100, javax.inject.Provider<V> r101) {
            return put(r100, Providers.asDaggerProvider(r101));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dagger.internal.AbstractMapFactory.Builder
        public /* bridge */ /* synthetic */ AbstractMapFactory.Builder put(Object r100, Provider r101) {
            return put(r100, r101);
        }

        @Override // dagger.internal.AbstractMapFactory.Builder
        public Builder<K, V> put(K r100, Provider<V> r101) {
            super.put(r100, r101);
            return this;
        }
    }

    static {
        EMPTY = InstanceFactory.create(Collections.emptyMap());
    }

    @Override // javax.inject.Provider
    public Map<K, V> get() {
        LinkedHashMap r100 = DaggerCollections.newLinkedHashMapWithExpectedSize(contributingMap().size());
        Iterator<Map.Entry<K, Provider<V>>> r101 = contributingMap().entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        Map.Entry<K, Provider<V>> r102 = r101.next();
        r100.put(r102.getKey(), r102.getValue().get());
        goto L4
    L7:
        return Collections.unmodifiableMap(r100);
    }

    public static <K, V> Provider<Map<K, V>> emptyMapProvider() {
        return (Provider<Map<K, V>>) EMPTY;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    private MapFactory(Map<K, Provider<V>> r100) {
        super(r100);
    }

    public static <K, V> Builder<K, V> builder(int r100) {
        return new Builder(r100, null);
    }

    public /* synthetic */ MapFactory(Map r100, AnonymousClass1 r101) {
        this(r100);
    }
}
