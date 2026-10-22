package kotlinx.coroutines;

import java.util.concurrent.Executor;
import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: loaded from: classes42.dex */
public final class k0 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineDispatcher f504991a;

    public final String toString() {
        return this.f504991a.toString();
    }

    public k0(CoroutineDispatcher r100) {
        this.f504991a = r100;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        CoroutineDispatcher r101 = this.f504991a;
        EmptyCoroutineContext r102 = EmptyCoroutineContext.INSTANCE;
        if (r101.isDispatchNeeded(r102) == false) goto L5;
        this.f504991a.dispatch(r102, r100);
        return;
    L5:
        r100.run();
    }
}
