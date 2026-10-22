package kotlinx.coroutines;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes42.dex */
public final class y1 implements z0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f505160d = null;
    private volatile /* synthetic */ int _state$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Job f505161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Thread f505162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m0 f505163c;

    static {
        f505160d = AtomicIntegerFieldUpdater.newUpdater(y1.class, "_state$volatile");
    }

    public final void b() {
        AtomicIntegerFieldUpdater r100 = f505160d;
    L3:
        int r101 = r100.get(this);
        if (r101 != 0) goto L6;
        if (f505160d.compareAndSet(this, r101, 1) == false) goto L3;
        m0 r102 = this.f505163c;
        if (r102 == null) goto L26;
        r102.dispose();
        return;
    L26:
        return;
    L6:
        if (r101 == 2) goto L3;
        if (r101 != 3) goto L11;
        Thread.interrupted();
        return;
    L11:
        c(r101);
        throw null;
    }

    public y1(Job r100) {
        this.f505161a = r100;
        this.f505162b = ThreadMethodProxy.currentThread();
    }

    public static void c(int r100) {
        throw new IllegalStateException(("Illegal state " + r100).toString());
    }

    @Override // kotlinx.coroutines.z0
    public final void a(Throwable r100) {
        AtomicIntegerFieldUpdater r101 = f505160d;
    L3:
        int r102 = r101.get(this);
        if (r102 != 0) goto L6;
        AtomicIntegerFieldUpdater r103 = f505160d;
        if (r103.compareAndSet(this, r102, 2) == false) goto L3;
        this.f505162b.interrupt();
        r103.set(this, 3);
        return;
    L6:
        if (r102 == 1) goto L12;
        if (r102 == 2) goto L20;
        if (r102 == 3) goto L21;
        c(r102);
        throw null;
    L21:
        return;
    L20:
        return;
    }
}
