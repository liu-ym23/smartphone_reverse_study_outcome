package dagger.internal;

import dagger.Lazy;

/* JADX INFO: loaded from: classes41.dex */
public final class InstanceFactory<T> implements Factory<T>, Lazy<T> {
    private static final InstanceFactory<Object> NULL_INSTANCE_FACTORY = null;
    private final T instance;

    static {
        NULL_INSTANCE_FACTORY = new InstanceFactory(null);
    }

    private static <T> InstanceFactory<T> nullInstanceFactory() {
        return (InstanceFactory<T>) NULL_INSTANCE_FACTORY;
    }

    @Override // javax.inject.Provider
    public T get() {
        return this.instance;
    }

    private InstanceFactory(T r100) {
        this.instance = r100;
    }

    public static <T> Factory<T> create(T r100) {
        return new InstanceFactory(Preconditions.checkNotNull(r100, "instance cannot be null"));
    }

    public static <T> Factory<T> createNullable(T r100) {
        if (r100 != null) goto L5;
        return nullInstanceFactory();
    L5:
        return new InstanceFactory(r100);
    }
}
