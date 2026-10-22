package dagger.internal;

import dagger.Lazy;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public final class MapProviderFactory<K, V> extends AbstractMapFactory<K, V, Provider<V>> implements Lazy<Map<K, Provider<V>>> {

    /* JADX INFO: renamed from: dagger.internal.MapProviderFactory$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, Provider<V>> {
        public MapProviderFactory<K, V> build() {
            return new MapProviderFactory(this.map, null);
        }

        private Builder(int r100) {
            super(r100);
        }

        public Builder<K, V> putAll(final javax.inject.Provider<Map<K, javax.inject.Provider<V>>> r100) {
            return putAll(new AnonymousClass1(this, r100));
        }

        @Override // dagger.internal.AbstractMapFactory.Builder
        public /* bridge */ /* synthetic */ AbstractMapFactory.Builder putAll(Provider r100) {
            return putAll(r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dagger.internal.AbstractMapFactory.Builder
        public Builder<K, V> putAll(Provider<Map<K, Provider<V>>> r100) {
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

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    @Override // javax.inject.Provider
    public Map<K, Provider<V>> get() {
        return contributingMap();
    }

    private MapProviderFactory(Map<K, Provider<V>> r100) {
        super(r100);
    }

    public static <K, V> Builder<K, V> builder(int r100) {
        return new Builder(r100, null);
    }

    public /* synthetic */ MapProviderFactory(Map r100, AnonymousClass1 r101) {
        this(r100);
    }
}
