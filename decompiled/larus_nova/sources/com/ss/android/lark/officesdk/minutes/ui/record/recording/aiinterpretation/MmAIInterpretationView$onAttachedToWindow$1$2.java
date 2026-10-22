package com.ss.android.lark.officesdk.minutes.ui.record.recording.aiinterpretation;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/aiinterpretation/MmAIInterpretationLanguage;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.aiinterpretation.MmAIInterpretationView$onAttachedToWindow$1$2", f = "MmAIInterpretationView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmAIInterpretationView$onAttachedToWindow$1$2 extends SuspendLambda implements Function2<List<? extends g>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmAIInterpretationView this$0;

    public MmAIInterpretationView$onAttachedToWindow$1$2(MmAIInterpretationView r100, Continuation<? super MmAIInterpretationView$onAttachedToWindow$1$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MmAIInterpretationView$onAttachedToWindow$1$2 r102 = new MmAIInterpretationView$onAttachedToWindow$1$2(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(List<? extends g> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<g> r100, Continuation<? super Unit> r101) {
        return ((MmAIInterpretationView$onAttachedToWindow$1$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        List<g> r101 = (List) this.L$0;
        MmAIInterpretationView r102 = this.this$0;
        r102.f435932g = r101;
        MmAIInterpretationView.a(r102);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
