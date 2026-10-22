package io.ktor.utils.io;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes41.dex */
public final class h implements s, u, CoroutineScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f492057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f492058b;

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f492058b.getCoroutineContext();
    }

    @Override // io.ktor.utils.io.s
    public final ByteReadChannel getChannel() {
        return this.f492057a;
    }

    @Override // io.ktor.utils.io.u
    public final b zl() {
        return this.f492057a;
    }

    public h(CoroutineScope r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r101, "channel");
        this.f492057a = r101;
        this.f492058b = r100;
    }
}
