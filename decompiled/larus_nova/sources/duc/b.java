package duc;

import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes.dex */
public final class b extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f470063b = null;

    static {
        f470063b = new b();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return "Dispatchers.Default";
    }

    public b() {
        super(k.f470072c, k.f470073d, k.f470074e, k.f470070a);
    }

    @Override // duc.e, kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    public final void h() {
        super.close();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher limitedParallelism(int r100) {
        kotlinx.coroutines.internal.m.a(r100);
        if (r100 < k.f470072c) goto L6;
        return this;
    L6:
        return super.limitedParallelism(r100);
    }
}
