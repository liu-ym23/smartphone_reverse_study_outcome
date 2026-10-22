package io.ktor.utils.io.core;

import java.nio.ByteBuffer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class u extends io.ktor.utils.io.pool.f<io.ktor.utils.io.core.internal.a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ByteBuffer f492052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<ByteBuffer, Unit> f492053d;

    @Override // io.ktor.utils.io.pool.f
    public final io.ktor.utils.io.core.internal.a c() {
        return g.a(this.f492052c, this);
    }

    @Override // io.ktor.utils.io.pool.f
    public final void b(io.ktor.utils.io.core.internal.a r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        this.f492053d.invoke(this.f492052c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(ByteBuffer r100, Function1<? super ByteBuffer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        Intrinsics.checkNotNullParameter(r101, "release");
        this.f492052c = r100;
        this.f492053d = r101;
    }
}
