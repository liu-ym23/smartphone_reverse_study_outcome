package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes5.dex */
public final class b1 extends d1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f504631f = null;
    private volatile /* synthetic */ int _invoked$volatile;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final z0 f504632e;

    static {
        f504631f = AtomicIntegerFieldUpdater.newUpdater(b1.class, "_invoked$volatile");
    }

    public b1(z0 r100) {
        this.f504632e = r100;
    }

    @Override // kotlinx.coroutines.z0
    public final void a(Throwable r100) {
        if (f504631f.compareAndSet(this, 0, 1) == false) goto L6;
        this.f504632e.a(r100);
        return;
    }
}
