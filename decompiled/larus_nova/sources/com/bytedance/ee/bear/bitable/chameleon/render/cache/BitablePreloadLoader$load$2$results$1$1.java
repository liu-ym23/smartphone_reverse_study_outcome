package com.bytedance.ee.bear.bitable.chameleon.render.cache;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ee/bear/bitable/chameleon/render/cache/BitableCacheLoadResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.bitable.chameleon.render.cache.BitablePreloadLoader$load$2$results$1$1", f = "BitablePreloadLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BitablePreloadLoader$load$2$results$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super d>, Object> {
    final /* synthetic */ e $loader;
    final /* synthetic */ f $request;
    int label;

    public BitablePreloadLoader$load$2$results$1$1(e r100, f r101, Continuation<? super BitablePreloadLoader$load$2$results$1$1> r102) {
        this.$loader = r100;
        this.$request = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new BitablePreloadLoader$load$2$results$1$1(this.$loader, this.$request, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super d> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super d> r101) {
        return ((BitablePreloadLoader$load$2$results$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r100);
        long r101 = System.currentTimeMillis();
        d r102 = this.$loader.a(this.$request);     // Catch: Throwable -> L7 CancellationException -> L10
        tt5.a.h("BitablePreloadLoader", "cache loader finished, scene=" + this.$request.f209709b + ", loader=" + this.$loader.getClass().getSimpleName() + ", cost=" + (System.currentTimeMillis() - r101));     // Catch: Throwable -> L7 CancellationException -> L10
    L16:
        return r102;
    L10:
        e = move-exception;
        throw e;
    L7:
        th = move-exception;
        tt5.a.l("BitablePreloadLoader", "cache loader failed, scene=" + this.$request.f209709b + ", loader=" + this.$loader.getClass().getSimpleName(), th);
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
