package com.ss.android.lark.officesdk.minutes.ui.record.recording.aiinterpretation;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/aiinterpretation/MmAIInterpretationLanguage;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.aiinterpretation.MmAIInterpretationView$onAttachedToWindow$1$6", f = "MmAIInterpretationView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmAIInterpretationView$onAttachedToWindow$1$6 extends SuspendLambda implements Function2<g, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmAIInterpretationView this$0;

    public MmAIInterpretationView$onAttachedToWindow$1$6(MmAIInterpretationView r100, Continuation<? super MmAIInterpretationView$onAttachedToWindow$1$6> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MmAIInterpretationView$onAttachedToWindow$1$6 r102 = new MmAIInterpretationView$onAttachedToWindow$1$6(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(g r100, Continuation<? super Unit> r101) {
        return ((MmAIInterpretationView$onAttachedToWindow$1$6) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(g r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        g r101 = (g) this.L$0;
        MmAIInterpretationView r102 = this.this$0;
        r102.f435934i = r101;
        if (MmAIInterpretationView.b(r102) == true) goto L7;
        MmAIInterpretationView.a(this.this$0);
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
