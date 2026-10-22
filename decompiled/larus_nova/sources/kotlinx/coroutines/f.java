package kotlinx.coroutines;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes6.dex */
public final class f implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Future<?> f504739a;

    public final String toString() {
        return "CancelFutureOnCancel[" + this.f504739a + ']';
    }

    public f(Future<?> r100) {
        this.f504739a = r100;
    }

    @Override // kotlinx.coroutines.h
    public final void a(Throwable r100) {
        if (r100 == null) goto L5;
        this.f504739a.cancel(false);
        return;
    }
}
