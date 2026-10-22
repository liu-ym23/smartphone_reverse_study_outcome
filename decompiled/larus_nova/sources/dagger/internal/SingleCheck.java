package dagger.internal;

/* JADX INFO: loaded from: classes41.dex */
public final class SingleCheck<T> implements Provider<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = null;
    private volatile Object instance;
    private volatile Provider<T> provider;

    static {
        UNINITIALIZED = new Object();
    }

    @Override // javax.inject.Provider
    public T get() {
        T r100 = (T) this.instance;
        if (r100 != UNINITIALIZED) goto L9;
        Provider<T> r101 = this.provider;
        if (r101 == null) goto L10;
        T r102 = r101.get();
        this.instance = r102;
        this.provider = null;
        return r102;
    L10:
        return (T) this.instance;
    L9:
        return r100;
    }

    private SingleCheck(Provider<T> r100) {
        this.instance = UNINITIALIZED;
        this.provider = r100;
    }

    public static <T> Provider<T> provider(Provider<T> r100) {
        if ((r100 instanceof SingleCheck) == false) goto L5;
    L9:
        return r100;
    L5:
        if ((r100 instanceof DoubleCheck) == true) goto L9;
        return new SingleCheck((Provider) Preconditions.checkNotNull(r100));
    }

    public static <P extends javax.inject.Provider<T>, T> javax.inject.Provider<T> provider(P r100) {
        return provider(Providers.asDaggerProvider(r100));
    }
}
