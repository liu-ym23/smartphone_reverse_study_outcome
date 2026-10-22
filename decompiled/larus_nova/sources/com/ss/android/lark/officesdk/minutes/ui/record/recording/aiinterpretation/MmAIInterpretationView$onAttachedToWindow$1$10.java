package com.ss.android.lark.officesdk.minutes.ui.record.recording.aiinterpretation;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.aiinterpretation.MmAIInterpretationView$onAttachedToWindow$1$10", f = "MmAIInterpretationView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmAIInterpretationView$onAttachedToWindow$1$10 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ MmAIInterpretationView this$0;

    public MmAIInterpretationView$onAttachedToWindow$1$10(MmAIInterpretationView r100, Continuation<? super MmAIInterpretationView$onAttachedToWindow$1$10> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MmAIInterpretationView$onAttachedToWindow$1$10 r102 = new MmAIInterpretationView$onAttachedToWindow$1$10(this.this$0, r101);
        r102.Z$0 = ((Boolean) r100).booleanValue();
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean r100, Continuation<? super Unit> r101) {
        return invoke(r100.booleanValue(), r101);
    }

    public final Object invoke(boolean r100, Continuation<? super Unit> r101) {
        return ((MmAIInterpretationView$onAttachedToWindow$1$10) create(Boolean.valueOf(r100), r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r100);
        boolean r101 = this.Z$0;
        MmAIInterpretationView r102 = this.this$0;
        if (r102.f435937l == false) goto L8;
        if (r101 == false) goto L8;
        r102.f435938m = true;
    L8:
        r102.f435936k = r101;
        if (MmAIInterpretationView.b(r102) == true) goto L11;
        MmAIInterpretationView r103 = this.this$0;
        if (r103.f435937l == true) goto L15;
    L20:
        MmAIInterpretationView.a(this.this$0);
        return Unit.INSTANCE;
    L15:
        if (r103.f435938m == false) goto L20;
        if (r101 == true) goto L20;
        if (r103.e() == false) goto L20;
        this.this$0.c();
        goto L20
    L11:
        return Unit.INSTANCE;
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
