package kotlinx.coroutines;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes42.dex */
public final class l0 implements m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Future<?> f504993a;

    @Override // kotlinx.coroutines.m0
    public final void dispose() {
        this.f504993a.cancel(false);
    }

    public final String toString() {
        return "DisposableFutureHandle[" + this.f504993a + ']';
    }

    public l0(Future<?> r100) {
        this.f504993a = r100;
    }
}
