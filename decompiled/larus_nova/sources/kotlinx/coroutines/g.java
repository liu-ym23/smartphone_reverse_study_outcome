package kotlinx.coroutines;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes6.dex */
public final class g extends f1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Future<?> f504911e;

    public g(Future<?> r100) {
        this.f504911e = r100;
    }

    @Override // kotlinx.coroutines.z0
    public final void a(Throwable r100) {
        if (r100 == null) goto L5;
        this.f504911e.cancel(false);
        return;
    }
}
