package duc;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class l extends CoroutineDispatcher {
    public static final l a = null;

    static {
        a = new l();
    }

    public l() {
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher limitedParallelism(int r2) {
        kotlinx.coroutines.internal.m.a(r2);
        if (r2 < k.d) goto L6;
        return this;
    L6:
        return super.limitedParallelism(r2);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext r3, Runnable r4) {
        b r5 = b.b;
        i r0 = k.h;
        r5.a.b(r4, r0, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatchYield(CoroutineContext r3, Runnable r4) {
        b r5 = b.b;
        i r0 = k.h;
        r5.a.b(r4, r0, true);
    }
}
