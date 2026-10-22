package com.bytedance.applog.priority.original;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.bytedance.applog.priority.original.CommonKt$runOnIOThread$1$1", f = "Common.kt", i = {}, l = {371}, m = "invokeSuspend", n = {}, s = {})
final class CommonKt$runOnIOThread$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    final /* synthetic */ CoroutineScope $it;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public CommonKt$runOnIOThread$1$1(Function1<? super Continuation<? super Unit>, ? extends Object> r100, CoroutineScope r101, Continuation<? super CommonKt$runOnIOThread$1$1> r102) {
        this.$block = r100;
        this.$it = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CommonKt$runOnIOThread$1$1(this.$block, this.$it, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CommonKt$runOnIOThread$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L11;
        if (r102 != 1) goto L10;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L7
    L23:
    L15:
        CoroutineScopeKt.cancel$default(this.$it, null, 1, null);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r100);
        Function1<Continuation<? super Unit>, Object> r103 = this.$block;     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        if (r103.invoke(this) != r101) goto L23;
        return r101;
    L7:
        th = move-exception;
        com.bytedance.applog.log.n.w().q("Background task failed: " + th.getMessage(), th, new Object[0]);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CoroutineScopeKt.cancel$default(this.$it, null, 1, null);
        throw th;
    }
}
