package duc;

import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b extends e {
    public static final b b = null;

    static {
        b = new b();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return "Dispatchers.Default";
    }

    public b() {
        super(k.c, k.d, k.e, k.a);
    }

    @Override // duc.e, kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    public final void h() {
        super.close();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher limitedParallelism(int r2) {
        kotlinx.coroutines.internal.m.a(r2);
        if (r2 < k.c) goto L6;
        return this;
    L6:
        return super.limitedParallelism(r2);
    }
}
