package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.m1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class y<S extends y<S>> extends e<S> implements m1 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater d = null;
    public final long c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    static {
        d = AtomicIntegerFieldUpdater.newUpdater(y.class, "cleanedAndPointers$volatile");
    }

    public abstract int g();

    public abstract void h(int r1, CoroutineContext r2);

    @Override // kotlinx.coroutines.internal.e
    public final boolean d() {
        if (d.get(this) == g()) goto L5;
        return false;
    L5:
        if (c() != null) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L12;
        return true;
    L12:
        return false;
    L7:
        r0 = false;
        goto L8
    }

    public final boolean f() {
        if (d.addAndGet(this, -65536) == g()) goto L5;
        return false;
    L5:
        if (c() != null) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L12;
        return true;
    L12:
        return false;
    L7:
        r0 = false;
        goto L8
    }

    public final void i() {
        if (d.incrementAndGet(this) != g()) goto L6;
        e();
        return;
    }

    public final boolean j() {
        AtomicIntegerFieldUpdater r0 = d;
    L3:
        int r1 = r0.get(this);
        if (r1 == g()) goto L6;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == false) goto L14;
        if (r0.compareAndSet(this, r1, 65536 + r1) == false) goto L3;
        return true;
    L14:
        return false;
    L6:
        if (c() != null) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L12;
        r2 = false;
        goto L13
    L8:
        r3 = false;
        goto L9
    }

    public y(long r1, S r3, int r4) {
        super(r3);
        this.c = r1;
        this.cleanedAndPointers$volatile = r4 << 16;
    }
}
