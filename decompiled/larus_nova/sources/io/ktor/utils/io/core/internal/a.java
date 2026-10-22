package io.ktor.utils.io.core.internal;

import io.ktor.utils.io.pool.e;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Deprecated(message = "\n    We're migrating to the new kotlinx-io library.\n    This declaration is deprecated and will be removed in Ktor 4.0.0\n    If you have any problems with migration, please contact us in \n    https://youtrack.jetbrains.com/issue/KTOR-6030/Migrate-to-new-kotlinx.io-library\n    ")
public final class a extends io.ktor.utils.io.core.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f492027j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f492028k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final C6313a f492029l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f492030m = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e<a> f492031h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f492032i;
    private volatile /* synthetic */ Object nextRef;
    private volatile /* synthetic */ int refCount;

    /* JADX INFO: renamed from: io.ktor.utils.io.core.internal.a$a, reason: collision with other inner class name */
    public static final class C6313a implements e<a> {
        public C6313a() {
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }

        @Override // io.ktor.utils.io.pool.e
        public final a Q5() {
            return a.f492030m;
        }

        @Override // io.ktor.utils.io.pool.e
        public final void Rl(a r100) {
            a r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "instance");
            if (r101 != a.f492030m) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L9;
            return;
        L9:
            throw new IllegalArgumentException("Only ChunkBuffer.Empty instance could be recycled.".toString());
        L5:
            r102 = false;
            goto L6
        }
    }

    public static final class b {
    }

    public a() {
        throw null;
    }

    static {
        C6313a r100 = new C6313a();
        f492029l = r100;
        f492030m = new a(jsc.c.f500279b, null, r100);
        f492027j = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "nextRef");
        f492028k = AtomicIntegerFieldUpdater.newUpdater(a.class, "refCount");
    }

    public final a g() {
        return (a) f492027j.getAndSet(this, null);
    }

    public final a h() {
        a r100 = this.f492032i;
        if (r100 != null) goto L5;
        r100 = this;
    L5:
        int r101 = r100.refCount;
        if (r101 <= 0) goto L12;
        AtomicIntegerFieldUpdater r102 = f492028k;
        if (r102.compareAndSet(r100, r101, r101 + 1) == false) goto L5;
        a r103 = new a(this.f492020a, r100, this.f492031h);
        Intrinsics.checkNotNullParameter(r103, "copy");
        r103.f492024e = this.f492024e;
        r103.f492023d = this.f492023d;
        r103.f492021b = this.f492021b;
        r103.f492022c = this.f492022c;
        return r103;
    L12:
        throw new IllegalStateException("Unable to acquire chunk: it is already released.");
    }

    public final a i() {
        return (a) this.nextRef;
    }

    public final void l() {
        if (this.f492032i != null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L10;
        d(0);
        int r101 = this.f492025f;
        this.f492024e = r101;
        f(r101 - this.f492023d);
        this.nextRef = null;
        return;
    L10:
        throw new IllegalArgumentException("Unable to reset buffer with origin".toString());
    L5:
        r100 = false;
        goto L6
    }

    public final void n() {
    L2:
        int r100 = this.refCount;
        if (r100 < 0) goto L11;
        if (r100 > 0) goto L9;
        if (f492028k.compareAndSet(this, r100, 1) == false) goto L2;
        return;
    L9:
        throw new IllegalStateException("This instance is already in use but somehow appeared in the pool.");
    L11:
        throw new IllegalStateException("This instance is already disposed and couldn't be borrowed.");
    }

    public final int j() {
        return this.refCount;
    }

    public final void k(e<a> r100) {
        Intrinsics.checkNotNullParameter(r100, "pool");
    L3:
        int r101 = this.refCount;
        if (r101 <= 0) goto L26;
        int r102 = r101 - 1;
        AtomicIntegerFieldUpdater r103 = f492028k;
        if (r103.compareAndSet(this, r101, r102) == false) goto L3;
        if (r102 != 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L30;
        a r105 = this.f492032i;
        if (r105 != null) goto L15;
        e<a> r106 = this.f492031h;
        if (r106 == null) goto L23;
        r100 = r106;
    L23:
        r100.Rl(this);
        return;
    L15:
        if (r103.compareAndSet(this, 0, -1) == false) goto L18;
        g();
        this.f492032i = null;
        r105.k(r100);
        return;
    L18:
        throw new IllegalStateException("Unable to unlink: buffer is in use.");
    L30:
        return;
    L10:
        r104 = false;
        goto L11
    L26:
        throw new IllegalStateException("Unable to release: it is already released.");
    }

    public final void m(a r100) {
        if (r100 != null) goto L4;
        g();
        return;
    L4:
        AtomicReferenceFieldUpdater r101 = f492027j;
    L6:
        if (r101.compareAndSet(this, null, r100) == true) goto L7;
        if (r101.get(this) == null) goto L6;
        boolean r102 = false;
    L11:
        if (r102 == false) goto L14;
        return;
    L14:
        throw new IllegalStateException("This chunk has already a next chunk.");
    L7:
        r102 = true;
        goto L11
    }

    public a(ByteBuffer r100, a r101, e r102) {
        Intrinsics.checkNotNullParameter(r100, "memory");
        super(r100);
        this.f492031h = r102;
        if (r101 == this) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L10;
        this.nextRef = null;
        this.refCount = 1;
        this.f492032i = r101;
        return;
    L10:
        throw new IllegalArgumentException("A chunk couldn't be a view of itself.".toString());
    L5:
        r103 = false;
        goto L6
    }
}
