package dagger.internal;

/* JADX INFO: loaded from: classes41.dex */
public final class DelegateFactory<T> implements Factory<T> {
    private Provider<T> delegate;

    public DelegateFactory() {
    }

    @Override // javax.inject.Provider
    public T get() {
        Provider<T> r100 = this.delegate;
        if (r100 == null) goto L7;
        return r100.get();
    L7:
        throw new IllegalStateException();
    }

    public Provider<T> getDelegate() {
        return (Provider) Preconditions.checkNotNull(this.delegate);
    }

    public void setDelegatedProvider(javax.inject.Provider<T> r100) {
        setDelegatedProvider(Providers.asDaggerProvider(r100));
    }

    public void setDelegatedProvider(Provider<T> r100) {
        setDelegate(this, r100);
    }

    public static <T> void setDelegate(javax.inject.Provider<T> r100, javax.inject.Provider<T> r101) {
        setDelegateInternal((DelegateFactory) r100, Providers.asDaggerProvider(r101));
    }

    private static <T> void setDelegateInternal(DelegateFactory<T> r100, Provider<T> r101) {
        Preconditions.checkNotNull(r101);
        if (((DelegateFactory) r100).delegate != null) goto L7;
        ((DelegateFactory) r100).delegate = r101;
        return;
    L7:
        throw new IllegalStateException();
    }

    public static <T> void setDelegate(Provider<T> r100, Provider<T> r101) {
        setDelegateInternal((DelegateFactory) r100, r101);
    }
}
