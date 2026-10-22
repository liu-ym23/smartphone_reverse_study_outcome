package duc;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class e extends ExecutorCoroutineDispatcher {
    public final CoroutineScheduler a;

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public final Executor d() {
        return this.a;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext r3, Runnable r4) {
        CoroutineScheduler r5 = this.a;
        AtomicLongFieldUpdater r0 = CoroutineScheduler.h;
        r5.b(r4, k.g, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatchYield(CoroutineContext r3, Runnable r4) {
        CoroutineScheduler r5 = this.a;
        AtomicLongFieldUpdater r0 = CoroutineScheduler.h;
        r5.b(r4, k.g, true);
    }

    public e(int r8, int r9, long r10, String r12) {
        this.a = new CoroutineScheduler(r8, r9, r10, r12);
    }
}
