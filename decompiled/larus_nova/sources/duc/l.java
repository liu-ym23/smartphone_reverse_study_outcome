package duc;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes.dex */
public final class l extends CoroutineDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f470078a = null;

    static {
        f470078a = new l();
    }

    public l() {
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher limitedParallelism(int r100) {
        kotlinx.coroutines.internal.m.a(r100);
        if (r100 < k.f470073d) goto L6;
        return this;
    L6:
        return super.limitedParallelism(r100);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext r100, Runnable r101) {
        b r102 = b.f470063b;
        i r103 = k.f470077h;
        r102.f470065a.b(r101, r103, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatchYield(CoroutineContext r100, Runnable r101) {
        b r102 = b.f470063b;
        i r103 = k.f470077h;
        r102.f470065a.b(r101, r103, true);
    }
}
