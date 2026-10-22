package io.ktor.utils.io.pool;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class c extends DefaultPool<ByteBuffer> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f492135f;

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final ByteBuffer f() {
        ByteBuffer r100 = ByteBuffer.allocateDirect(this.f492135f);
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final ByteBuffer c(ByteBuffer r100) {
        ByteBuffer r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "instance");
        r101.clear();
        r101.order(ByteOrder.BIG_ENDIAN);
        return r101;
    }

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final void h(ByteBuffer r100) {
        ByteBuffer r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "instance");
        if (r101.capacity() != this.f492135f) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L14;
        if (r101.isDirect() == false) goto L12;
        return;
    L12:
        throw new IllegalStateException("Check failed.".toString());
    L14:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r102 = false;
        goto L7
    }

    public c(int r100, int r101) {
        super(r100);
        this.f492135f = r101;
    }
}
