package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.h0;
import kotlinx.coroutines.r0;

/* JADX INFO: loaded from: classes5.dex */
public class g0<T extends h0 & Comparable<? super T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f504949b = null;
    private volatile /* synthetic */ int _size$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T[] f504950a;

    static {
        f504949b = AtomicIntegerFieldUpdater.newUpdater(g0.class, "_size$volatile");
    }

    public g0() {
    }

    public final T c() {
        monitor-enter(this);
        T[] r100 = this.f504950a;     // Catch: Throwable -> L7
        if (r100 == null) goto L9;
        T r101 = r100[0];     // Catch: Throwable -> L7
    L10:
        monitor-exit(this);
        return r101;
    L9:
        r101 = null;
    L7:
        th = move-exception;
        throw th;
    }

    public final int b() {
        return f504949b.get(this);
    }

    public final void a(r0.c r100) {
        r100.c((r0.d) this);
        T[] r101 = this.f504950a;
        if (r101 != null) goto L6;
        r101 = (T[]) new h0[4];
        this.f504950a = r101;
    L8:
        int r102 = b();
        AtomicIntegerFieldUpdater r103 = f504949b;
        r103.set(this, r102 + 1);
        r101[r102] = r100;
        r100.f505016b = r102;
        f(r102);
        return;
    L6:
        if (b() < r101.length) goto L8;
        r101 = (T[]) ((h0[]) Arrays.copyOf(r101, b() * 2));
        this.f504950a = r101;
        goto L8
    }

    public final void d(h0 r100) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (r100.a() == null) goto L7;
        e(r100.getIndex());     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
    }

    public final T e(int r100) {
        T[] r101 = this.f504950a;
        Intrinsics.checkNotNull(r101);
        f504949b.set(this, b() - 1);
        if (r100 >= b()) goto L21;
        g(r100, b());
        int r102 = (r100 - 1) / 2;
        if (r100 <= 0) goto L9;
        T r103 = r101[r100];
        Intrinsics.checkNotNull(r103);
        T r104 = r101[r102];
        Intrinsics.checkNotNull(r104);
        if (((Comparable) r103).compareTo(r104) >= 0) goto L9;
        g(r100, r102);
        f(r102);
    L9:
        int r105 = (r100 * 2) + 1;
        if (r105 >= b()) goto L21;
        T[] r106 = this.f504950a;
        Intrinsics.checkNotNull(r106);
        int r107 = r105 + 1;
        if (r107 >= b()) goto L17;
        T r108 = r106[r107];
        Intrinsics.checkNotNull(r108);
        T r109 = r106[r105];
        Intrinsics.checkNotNull(r109);
        if (((Comparable) r108).compareTo(r109) >= 0) goto L17;
        r105 = r107;
    L17:
        T r110 = r106[r100];
        Intrinsics.checkNotNull(r110);
        T r111 = r106[r105];
        Intrinsics.checkNotNull(r111);
        if (((Comparable) r110).compareTo(r111) <= 0) goto L21;
        g(r100, r105);
        r100 = r105;
    L21:
        T r112 = r101[b()];
        Intrinsics.checkNotNull(r112);
        r112.c(null);
        r112.setIndex(-1);
        r101[b()] = null;
        return r112;
    }

    public final void f(int r100) {
    L2:
        if (r100 <= 0) goto L3;
        T[] r101 = this.f504950a;
        Intrinsics.checkNotNull(r101);
        int r102 = (r100 - 1) / 2;
        T r103 = r101[r102];
        Intrinsics.checkNotNull(r103);
        T r104 = r101[r100];
        Intrinsics.checkNotNull(r104);
        if (((Comparable) r103).compareTo(r104) <= 0) goto L6;
        g(r100, r102);
        r100 = r102;
        goto L2
    L6:
        return;
    }

    public final void g(int r100, int r101) {
        T[] r102 = this.f504950a;
        Intrinsics.checkNotNull(r102);
        T r103 = r102[r101];
        Intrinsics.checkNotNull(r103);
        T r104 = r102[r100];
        Intrinsics.checkNotNull(r104);
        r102[r100] = r103;
        r102[r101] = r104;
        r103.setIndex(r100);
        r104.setIndex(r101);
    }
}
