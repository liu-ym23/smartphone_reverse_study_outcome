package io.ktor.utils.io.core;

import io.ktor.utils.io.pool.DefaultPool;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class m extends DefaultPool<io.ktor.utils.io.core.internal.a> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f492035f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final jsc.a f492036g;

    public m() {
        jsc.b r100 = jsc.b.f500278a;
        Intrinsics.checkNotNullParameter(r100, "allocator");
        super(1000);
        this.f492035f = 4096;
        this.f492036g = r100;
    }

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final io.ktor.utils.io.core.internal.a f() {
        return new io.ktor.utils.io.core.internal.a(this.f492036g.b(this.f492035f), null, this);
    }

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final io.ktor.utils.io.core.internal.a c(io.ktor.utils.io.core.internal.a r100) {
        io.ktor.utils.io.core.internal.a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "instance");
        Intrinsics.checkNotNullParameter(r101, "instance");
        r101.n();
        r101.l();
        return r101;
    }

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final void e(io.ktor.utils.io.core.internal.a r100) {
        io.ktor.utils.io.core.internal.a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "instance");
        this.f492036g.a(r101.f492020a);
        Intrinsics.checkNotNullParameter(r101, "instance");
        if (io.ktor.utils.io.core.internal.a.f492028k.compareAndSet(r101, 0, -1) == false) goto L7;
        r101.g();
        r101.f492032i = null;
        return;
    L7:
        throw new IllegalStateException("Unable to unlink: buffer is in use.");
    }

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final void h(io.ktor.utils.io.core.internal.a r100) {
        io.ktor.utils.io.core.internal.a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "instance");
        Intrinsics.checkNotNullParameter(r101, "instance");
        boolean r102 = false;
        if (r101.f492020a.limit() != this.f492035f) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L42;
        io.ktor.utils.io.core.internal.a r104 = io.ktor.utils.io.core.internal.a.f492030m;
        if (r101 == r104) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L41;
        int r106 = a.f492019g;
        if (r101 == r104) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == false) goto L39;
        if (r101.j() != 0) goto L20;
        boolean r108 = true;
    L21:
        if (r108 == false) goto L37;
        if (r101.i() != null) goto L25;
        boolean r109 = true;
    L26:
        if (r109 == false) goto L35;
        if (r101.f492032i != null) goto L30;
        r102 = true;
    L30:
        if (r102 == false) goto L33;
        return;
    L33:
        throw new IllegalStateException("Recycled instance shouldn't be a view or another buffer.".toString());
    L35:
        throw new IllegalStateException("Recycled instance shouldn't be a part of a chain.".toString());
    L25:
        r109 = false;
        goto L26
    L37:
        throw new IllegalStateException("Unable to clear buffer: it is still in use.".toString());
    L20:
        r108 = false;
        goto L21
    L39:
        throw new IllegalStateException("Empty instance couldn't be recycled".toString());
    L15:
        r107 = false;
        goto L16
    L41:
        throw new IllegalStateException("ChunkBuffer.Empty couldn't be recycled".toString());
    L10:
        r105 = false;
        goto L11
    L42:
        StringBuilder r110 = new StringBuilder("Buffer size mismatch. Expected: ");
        r110.append(this.f492035f);
        r110.append(", actual: ");
        r110.append(r101.f492020a.limit());
        throw new IllegalStateException(r110.toString().toString());
    L5:
        r103 = false;
        goto L6
    }
}
