package io.github.alexzhirkevich.compottie;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "io.github.alexzhirkevich.compottie.LottieCompositionResultImpl", f = "LottieCompositionResult.kt", i = {0, 0}, l = {135}, m = "complete$compottie_release", n = {"composition", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
public final class LottieCompositionResultImpl$complete$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LottieCompositionResultImpl this$0;

    public LottieCompositionResultImpl$complete$1(LottieCompositionResultImpl r100, Continuation<? super LottieCompositionResultImpl$complete$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, this);
    }
}
