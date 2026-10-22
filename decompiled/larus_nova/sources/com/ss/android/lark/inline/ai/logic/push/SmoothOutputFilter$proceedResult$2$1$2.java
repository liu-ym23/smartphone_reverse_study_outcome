package com.ss.android.lark.inline.ai.logic.push;

import com.bytedance.lark.pb.space.doc.v1.InlineAITaskStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.inline.ai.logic.push.SmoothOutputFilter$proceedResult$2$1$2", f = "SmoothOutputFilter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SmoothOutputFilter$proceedResult$2$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ InlineAITaskStatus $printData;
    int label;
    final /* synthetic */ SmoothOutputFilter this$0;

    public SmoothOutputFilter$proceedResult$2$1$2(SmoothOutputFilter r100, InlineAITaskStatus r101, Continuation<? super SmoothOutputFilter$proceedResult$2$1$2> r102) {
        this.this$0 = r100;
        this.$printData = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SmoothOutputFilter$proceedResult$2$1$2(this.this$0, this.$printData, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SmoothOutputFilter$proceedResult$2$1$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        SmoothOutputFilter r101 = this.this$0;
        InlineAITaskStatus r102 = this.$printData;
        Intrinsics.checkNotNull(r102);
        r101.b(r102, false);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
