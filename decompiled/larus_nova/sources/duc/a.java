package duc;

import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.d0;

/* JADX INFO: loaded from: classes.dex */
public final class a extends ExecutorCoroutineDispatcher implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f470061a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineDispatcher f470062b = null;

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public final Executor d() {
        return this;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return "Dispatchers.IO";
    }

    static {
        f470061a = new a();
        f470062b = l.f470078a.limitedParallelism(c0.b("kotlinx.coroutines.io.parallelism", RangesKt.coerceAtLeast(64, d0.f504940a), 0, 0, 12));
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    public a() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        dispatch(EmptyCoroutineContext.INSTANCE, r100);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher limitedParallelism(int r100) {
        return l.f470078a.limitedParallelism(r100);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext r100, Runnable r101) {
        f470062b.dispatch(r100, r101);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatchYield(CoroutineContext r100, Runnable r101) {
        f470062b.dispatchYield(r100, r101);
    }
}
