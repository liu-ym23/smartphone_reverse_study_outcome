package dagger.internal;

import dagger.Lazy;

/* JADX INFO: loaded from: classes41.dex */
public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = null;
    private volatile Object instance;
    private volatile Provider<T> provider;

    private synchronized Object getSynchronized() {
        monitor-enter(this);
        Object r100 = this.instance;     // Catch: Throwable -> L8
        if (r100 != UNINITIALIZED) goto L6;
        r100 = this.provider.get();     // Catch: Throwable -> L8
        this.instance = reentrantCheck(this.instance, r100);     // Catch: Throwable -> L8
        this.provider = null;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r100;
    L8:
        th = move-exception;
        throw th;
    }

    static {
        UNINITIALIZED = new Object();
    }

    @Override // javax.inject.Provider
    public T get() {
        T r100 = (T) this.instance;
        if (r100 == UNINITIALIZED) goto L5;
        return r100;
    L5:
        return (T) getSynchronized();
    }

    private DoubleCheck(Provider<T> r100) {
        this.instance = UNINITIALIZED;
        this.provider = r100;
    }

    public static <T> Lazy<T> lazy(Provider<T> r100) {
        if ((r100 instanceof Lazy) == false) goto L7;
        return (Lazy) r100;
    L7:
        return new DoubleCheck((Provider) Preconditions.checkNotNull(r100));
    }

    public static <T> Provider<T> provider(Provider<T> r100) {
        Preconditions.checkNotNull(r100);
        if ((r100 instanceof DoubleCheck) == false) goto L6;
        return r100;
    L6:
        return new DoubleCheck(r100);
    }

    public static <P extends javax.inject.Provider<T>, T> Lazy<T> lazy(P r100) {
        return lazy(Providers.asDaggerProvider(r100));
    }

    public static <P extends javax.inject.Provider<T>, T> javax.inject.Provider<T> provider(P r100) {
        return provider(Providers.asDaggerProvider(r100));
    }

    private static Object reentrantCheck(Object r100, Object r101) {
        if (r100 == UNINITIALIZED) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L11;
        if (r100 == r101) goto L11;
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + r100 + " & " + r101 + ". This is likely due to a circular dependency.");
    L11:
        return r101;
    L5:
        r102 = false;
        goto L6
    }
}
