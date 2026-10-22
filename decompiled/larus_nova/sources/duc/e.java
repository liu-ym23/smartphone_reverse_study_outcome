package duc;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

/* JADX INFO: loaded from: classes.dex */
public class e extends ExecutorCoroutineDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScheduler f470065a;

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f470065a.close();
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public final Executor d() {
        return this.f470065a;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext r100, Runnable r101) {
        CoroutineScheduler r102 = this.f470065a;
        AtomicLongFieldUpdater r103 = CoroutineScheduler.f505060h;
        r102.b(r101, k.f470076g, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatchYield(CoroutineContext r100, Runnable r101) {
        CoroutineScheduler r102 = this.f470065a;
        AtomicLongFieldUpdater r103 = CoroutineScheduler.f505060h;
        r102.b(r101, k.f470076g, true);
    }

    public e(int r100, int r101, long r110, String r111) {
        this.f470065a = new CoroutineScheduler(r100, r101, r110, r111);
    }
}
