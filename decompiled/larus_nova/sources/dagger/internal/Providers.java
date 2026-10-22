package dagger.internal;

/* JADX INFO: loaded from: classes41.dex */
public final class Providers {
    private Providers() {
    }

    public static <T> Provider<T> asDaggerProvider(final javax.inject.Provider<T> r100) {
        Preconditions.checkNotNull(r100);
        return new AnonymousClass1(r100);
    }
}
