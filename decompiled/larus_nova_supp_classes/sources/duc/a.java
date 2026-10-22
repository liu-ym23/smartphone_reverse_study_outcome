package duc;

import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a extends ExecutorCoroutineDispatcher implements Executor {
    public static final a a = null;
    public static final CoroutineDispatcher b = null;

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public final Executor d() {
        return this;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return "Dispatchers.IO";
    }

    static {
        a = new a();
        b = l.a.limitedParallelism(c0.b("kotlinx.coroutines.io.parallelism", RangesKt.coerceAtLeast(64, d0.a), 0, 0, 12));
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    public a() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r2) {
        dispatch(EmptyCoroutineContext.INSTANCE, r2);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher limitedParallelism(int r2) {
        return l.a.limitedParallelism(r2);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext r2, Runnable r3) {
        b.dispatch(r2, r3);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatchYield(CoroutineContext r2, Runnable r3) {
        b.dispatchYield(r2, r3);
    }
}
