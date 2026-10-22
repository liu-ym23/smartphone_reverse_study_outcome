package com.bytedance.ies.argus.aspect.eventCenter;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0000\"\n\b\u0001\u0010\u0003*\u0004\u0018\u00010\u0002*\u00020\u0004H\u008a@"}, d2 = {"Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "PARAMS", "Lcom/bytedance/ies/argus/strategy/a;", "REWRITE_PAYLOAD", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.ies.argus.aspect.eventCenter.BaseEventCenter$VerifyHandler$setAsyncReportAwaitTask$task$1", f = "BaseEventCenter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BaseEventCenter$VerifyHandler$setAsyncReportAwaitTask$task$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $block;
    int label;

    public BaseEventCenter$VerifyHandler$setAsyncReportAwaitTask$task$1(Function0<Unit> r100, Continuation<? super BaseEventCenter$VerifyHandler$setAsyncReportAwaitTask$task$1> r101) {
        this.$block = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new BaseEventCenter$VerifyHandler$setAsyncReportAwaitTask$task$1(this.$block, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((BaseEventCenter$VerifyHandler$setAsyncReportAwaitTask$task$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        this.$block.invoke();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invokeSuspend$$forInline(Object r100) {
        this.$block.invoke();
        return Unit.INSTANCE;
    }
}
