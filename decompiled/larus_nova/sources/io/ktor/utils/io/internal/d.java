package io.ktor.utils.io.internal;

import io.ktor.utils.io.q;
import java.nio.ByteBuffer;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class d implements q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f492073b;

    public d(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "cause");
        this.f492073b = r100;
    }

    @Override // io.ktor.utils.io.p
    public final void a(int r100) {
        throw this.f492073b;
    }

    @Override // io.ktor.utils.io.p
    public final ByteBuffer b(int r100, int r101) {
        throw this.f492073b;
    }

    @Override // io.ktor.utils.io.q
    public final Object f(int r100, Continuation<? super Boolean> r101) {
        throw this.f492073b;
    }
}
