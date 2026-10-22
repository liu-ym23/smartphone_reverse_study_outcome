package com.bytedance.rts.kmp.foundation;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.rts.kmp.foundation.RTSMessageLooper$postMacroTask$1", f = "Timer.kt", i = {}, l = {84, 90}, m = "invokeSuspend", n = {}, s = {})
final class RTSMessageLooper$postMacroTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ o $task;
    int label;
    final /* synthetic */ k this$0;

    public RTSMessageLooper$postMacroTask$1(k r100, o r101, Continuation<? super RTSMessageLooper$postMacroTask$1> r102) {
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new RTSMessageLooper$postMacroTask$1(null, null, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RTSMessageLooper$postMacroTask$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 != 0) goto L5;
        ResultKt.throwOnFailure(r100);
        throw null;
    L5:
        if (r101 != 1) goto L7;
    L10:
        ResultKt.throwOnFailure(r100);
        throw null;
    L7:
        if (r101 == 2) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
