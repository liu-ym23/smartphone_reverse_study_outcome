package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.m1;

/* JADX INFO: loaded from: classes.dex */
public abstract class y<S extends y<S>> extends e<S> implements m1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f504983d = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f504984c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    static {
        f504983d = AtomicIntegerFieldUpdater.newUpdater(y.class, "cleanedAndPointers$volatile");
    }

    public abstract int g();

    public abstract void h(int r100, CoroutineContext r101);

    @Override // kotlinx.coroutines.internal.e
    public final boolean d() {
        if (f504983d.get(this) == g()) goto L5;
        return false;
    L5:
        if (c() != null) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == true) goto L12;
        return true;
    L12:
        return false;
    L7:
        r100 = false;
        goto L8
    }

    public final boolean f() {
        if (f504983d.addAndGet(this, -65536) == g()) goto L5;
        return false;
    L5:
        if (c() != null) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == true) goto L12;
        return true;
    L12:
        return false;
    L7:
        r100 = false;
        goto L8
    }

    public final void i() {
        if (f504983d.incrementAndGet(this) != g()) goto L6;
        e();
        return;
    }

    public final boolean j() {
        AtomicIntegerFieldUpdater r100 = f504983d;
    L3:
        int r101 = r100.get(this);
        if (r101 == g()) goto L6;
    L12:
        boolean r102 = true;
    L13:
        if (r102 == false) goto L14;
        if (r100.compareAndSet(this, r101, 65536 + r101) == false) goto L3;
        return true;
    L14:
        return false;
    L6:
        if (c() != null) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L12;
        r102 = false;
        goto L13
    L8:
        r103 = false;
        goto L9
    }

    public y(long r100, S r101, int r102) {
        super(r101);
        this.f504984c = r100;
        this.cleanedAndPointers$volatile = r102 << 16;
    }
}
