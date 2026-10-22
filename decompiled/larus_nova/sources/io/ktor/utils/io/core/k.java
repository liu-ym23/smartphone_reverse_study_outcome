package io.ktor.utils.io.core;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class k extends n {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final k f492034h = null;

    public static final class a {
    }

    public k() {
        throw null;
    }

    @Override // io.ktor.utils.io.core.n
    public final void a() {
    }

    @Override // io.ktor.utils.io.core.n
    public final io.ktor.utils.io.core.internal.a f() {
        return null;
    }

    @Override // io.ktor.utils.io.core.n
    public final void g(ByteBuffer r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
    }

    static {
        f492034h = new k(io.ktor.utils.io.core.internal.a.f492030m, 0, io.ktor.utils.io.core.internal.a.f492029l);
    }

    public final String toString() {
        return "ByteReadPacket[" + hashCode() + ']';
    }

    public final k v() {
        io.ktor.utils.io.core.internal.a r100 = j();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        io.ktor.utils.io.core.internal.a r101 = r100.h();
        io.ktor.utils.io.core.internal.a r102 = r100.i();
        if (r102 == null) goto L9;
        io.ktor.utils.io.core.internal.a r103 = r101;
    L6:
        io.ktor.utils.io.core.internal.a r104 = r102.h();
        r103.m(r104);
        r102 = r102.i();
        if (r102 == null) goto L9;
        r103 = r104;
    L9:
        return new k(r101, k(), this.f492037a);
    }

    public k(io.ktor.utils.io.core.internal.a r100, long r101, io.ktor.utils.io.pool.e<io.ktor.utils.io.core.internal.a> r102) {
        Intrinsics.checkNotNullParameter(r100, "head");
        Intrinsics.checkNotNullParameter(r102, "pool");
        super(r100, r101, r102);
        if (this.f492043g == true) goto L6;
        this.f492043g = true;
        return;
    }
}
