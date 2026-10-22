package dagger.internal;

import dagger.Lazy;

/* JADX INFO: loaded from: classes41.dex */
public final class ProviderOfLazy<T> implements Provider<Lazy<T>> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<T> provider;

    @Override // javax.inject.Provider
    public Lazy<T> get() {
        return DoubleCheck.lazy(this.provider);
    }

    static {
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    private ProviderOfLazy(Provider<T> r100) {
        this.provider = r100;
    }

    public static <T> Provider<Lazy<T>> create(Provider<T> r100) {
        return new ProviderOfLazy((Provider) Preconditions.checkNotNull(r100));
    }

    public static <T> Provider<Lazy<T>> create(javax.inject.Provider<T> r100) {
        return create(Providers.asDaggerProvider(r100));
    }
}
