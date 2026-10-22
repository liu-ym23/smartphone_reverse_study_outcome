package kotlinx.coroutines;

import kotlin.collections.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public abstract class q0 extends CoroutineDispatcher {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f505003d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f505004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f505005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayDeque<i0<?>> f505006c;

    public void shutdown() {
    }

    public final boolean l() {
        if (this.f505004a < 4294967296L) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean n() {
        ArrayDeque<i0<?>> r100 = this.f505006c;
        if (r100 != null) goto L5;
        return false;
    L5:
        i0<?> r101 = r100.removeFirstOrNull();
        if (r101 != null) goto L8;
        return false;
    L8:
        r101.run();
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

    public final void d(boolean r100) {
        long r101 = this.f505004a;
        if (r100 == false) goto L5;
        long r102 = 4294967296L;
    L6:
        long r103 = r101 - r102;
        this.f505004a = r103;
        if (r103 <= 0) goto L10;
        return;
    L10:
        if (this.f505005b == false) goto L13;
        shutdown();
        return;
    L13:
        return;
    L5:
        r102 = 1;
        goto L6
    }

    public final void h(i0<?> r100) {
        ArrayDeque<i0<?>> r101 = this.f505006c;
        if (r101 != null) goto L5;
        r101 = new ArrayDeque();
        this.f505006c = r101;
    L5:
        r101.addLast(r100);
    }

    public final void i(boolean r100) {
        long r101 = this.f505004a;
        if (r100 == false) goto L5;
        long r102 = 4294967296L;
    L6:
        this.f505004a = r101 + r102;
        if (r100 == true) goto L10;
        this.f505005b = true;
        return;
    L10:
        return;
    L5:
        r102 = 1;
        goto L6
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher limitedParallelism(int r100) {
        kotlinx.coroutines.internal.m.a(r100);
        return this;
    }
}
