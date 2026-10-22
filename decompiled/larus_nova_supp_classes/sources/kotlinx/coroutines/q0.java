package kotlinx.coroutines;

import kotlin.collections.ArrayDeque;
import kotlinx.coroutines.internal.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class q0 extends CoroutineDispatcher {
    public static final /* synthetic */ int d = 0;
    public long a;
    public boolean b;
    public ArrayDeque<i0<?>> c;

    public void shutdown() {
    }

    public final boolean l() {
        if (this.a < 4294967296L) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean n() {
        ArrayDeque<i0<?>> r0 = this.c;
        if (r0 != null) goto L5;
        return false;
    L5:
        i0 r1 = (i0) r0.removeFirstOrNull();
        if (r1 != null) goto L8;
        return false;
    L8:
        r1.run();
        return true;
    }

    public long m() {
        if (n() == true) goto L6;
        return Long.MAX_VALUE;
    L6:
        return 0;
    }

    public q0() {
    }

    public final void d(boolean r5) {
        long r0 = this.a;
        if (r5 == false) goto L5;
        long r2 = 4294967296L;
    L6:
        long r1 = r0 - r2;
        this.a = r1;
        if (r1 <= 0) goto L10;
        return;
    L10:
        if (this.b == false) goto L13;
        shutdown();
        return;
    L13:
        return;
    L5:
        r2 = 1;
        goto L6
    }

    public final void h(i0<?> r2) {
        ArrayDeque<i0<?>> r0 = this.c;
        if (r0 != null) goto L5;
        r0 = new ArrayDeque();
        this.c = r0;
    L5:
        r0.addLast(r2);
    }

    public final void i(boolean r5) {
        long r0 = this.a;
        if (r5 == false) goto L5;
        long r2 = 4294967296L;
    L6:
        this.a = r0 + r2;
        if (r5 == true) goto L10;
        this.b = true;
        return;
    L10:
        return;
    L5:
        r2 = 1;
        goto L6
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher limitedParallelism(int r1) {
        m.a(r1);
        return this;
    }
}
