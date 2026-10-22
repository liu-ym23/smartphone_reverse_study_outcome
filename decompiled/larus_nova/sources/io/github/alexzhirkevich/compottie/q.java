package io.github.alexzhirkevich.compottie;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes41.dex */
public final class q implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0<LottieComposition> f491608a;

    public q() {
        this.f491608a = new c0(0);
    }

    @Override // io.github.alexzhirkevich.compottie.o
    public final Object a(Object r100, Function1<? super Continuation<? super LottieComposition>, ? extends Object> r101, Continuation<? super LottieComposition> r102) {
        if (r100 == null) goto L4;
        c0<LottieComposition> r103 = this.f491608a;
        return r103.f490736c.a(r100, new LruMap$getOrPutSuspend$2(r103, r100, r101, null), r102);
    L4:
        return r101.invoke(r102);
    }
}
