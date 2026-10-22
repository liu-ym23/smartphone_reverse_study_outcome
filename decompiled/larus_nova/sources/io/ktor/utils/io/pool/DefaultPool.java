package io.ktor.utils.io.pool;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes41.dex */
public abstract class DefaultPool<T> implements e<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicLongFieldUpdater<DefaultPool<?>> f492128e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f492129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f492130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReferenceArray<T> f492131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f492132d;
    private volatile long top;

    public static final class a {
    }

    public T c(T r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        return r100;
    }

    public void e(T r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
    }

    public abstract T f();

    public void h(T r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
    }

    static {
        f492128e = AtomicLongFieldUpdater.newUpdater(DefaultPool.class, DefaultPool$Companion$Top$1.INSTANCE.getName());
    }

    public final T g() {
    L2:
        long r100 = this.top;
        int r101 = 0;
        if (r100 == 0) goto L12;
        long r102 = ((r100 >> 32) & BodyPartID.bodyIdMax) + 1;
        int r103 = (int) (BodyPartID.bodyIdMax & r100);
        if (r103 == 0) goto L12;
        long r104 = (r102 << 32) | ((long) this.f492132d[r103]);
        if (f492128e.compareAndSet(this, r100, r104) == false) goto L2;
        r101 = r103;
    L12:
        if (r101 != 0) goto L15;
        return null;
    L15:
        return this.f492131c.getAndSet(r101, null);
    }

    @Override // io.ktor.utils.io.pool.e
    public final T Q5() {
        T r100 = g();
        if (r100 == null) goto L7;
        T r101 = c(r100);
        if (r101 == null) goto L7;
        return r101;
    L7:
        return f();
    }

    public final void d() {
    L2:
        T r100 = g();
        if (r100 == null) goto L4;
        e(r100);
        goto L2
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        d();
    }

    public DefaultPool(int r100) {
        boolean r101 = false;
        if (r100 <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L16;
        if (r100 > 536870911) goto L10;
        r101 = true;
    L10:
        if (r101 == false) goto L14;
        int r103 = Integer.highestOneBit((r100 * 4) - 1) * 2;
        this.f492129a = r103;
        this.f492130b = Integer.numberOfLeadingZeros(r103) + 1;
        int r104 = r103 + 1;
        this.f492131c = new AtomicReferenceArray(r104);
        this.f492132d = new int[r104];
        return;
    L14:
        throw new IllegalArgumentException(("capacity should be less or equal to 536870911 but it is " + r100).toString());
    L16:
        throw new IllegalArgumentException(("capacity should be positive but it is " + r100).toString());
    L5:
        r102 = false;
        goto L6
    }

    public static final /* synthetic */ long a(DefaultPool r100) {
        return r100.top;
    }

    @Override // io.ktor.utils.io.pool.e
    public final void Rl(T r110) {
        Intrinsics.checkNotNullParameter(r110, "instance");
        h(r110);
        boolean r100 = true;
        int r101 = ((System.identityHashCode(r110) * (-1640531527)) >>> this.f492130b) + 1;
        boolean r102 = false;
        int r103 = 0;
    L4:
        if (r103 >= 8) goto L25;
        AtomicReferenceArray<T> r104 = this.f492131c;
    L7:
        if (r104.compareAndSet(r101, null, r110) == true) goto L8;
        if (r104.get(r101) == null) goto L7;
        boolean r105 = false;
    L12:
        if (r105 == true) goto L13;
        r101 = r101 - 1;
        if (r101 != 0) goto L24;
        r101 = this.f492129a;
    L24:
        r103 = r103 + 1;
        goto L4
    L13:
        if (r101 <= 0) goto L15;
        r102 = true;
    L15:
        if (r102 == false) goto L20;
    L16:
        long r106 = this.top;
        long r107 = ((r106 >> 32) & BodyPartID.bodyIdMax) + 1;
        long r108 = r101 | (r107 << 32);
        this.f492132d[r101] = (int) (BodyPartID.bodyIdMax & r106);
        if (f492128e.compareAndSet(this, r106, r108) == false) goto L16;
    L26:
        if (r100 == true) goto L38;
        e(r110);
        return;
    L38:
        return;
    L20:
        throw new IllegalArgumentException("index should be positive".toString());
    L8:
        r105 = true;
        goto L12
    L25:
        r100 = false;
        goto L26
    }

    public static final /* synthetic */ void b(DefaultPool r100, long r101) {
        r100.top = r101;
    }
}
