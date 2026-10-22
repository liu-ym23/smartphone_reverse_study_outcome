package com.ss.android.lark.officesdk.minutes.ui.record.recording.language;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "isBilingual", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.language.MmRecordingTranslateLanguageView$onAttachedToWindow$1$2", f = "MmRecordingTranslateLanguageView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingTranslateLanguageView$onAttachedToWindow$1$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ MmRecordingTranslateLanguageView this$0;

    public MmRecordingTranslateLanguageView$onAttachedToWindow$1$2(MmRecordingTranslateLanguageView r100, Continuation<? super MmRecordingTranslateLanguageView$onAttachedToWindow$1$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MmRecordingTranslateLanguageView$onAttachedToWindow$1$2 r102 = new MmRecordingTranslateLanguageView$onAttachedToWindow$1$2(this.this$0, r101);
        r102.Z$0 = ((Boolean) r100).booleanValue();
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean r100, Continuation<? super Unit> r101) {
        return invoke(r100.booleanValue(), r101);
    }

    public final Object invoke(boolean r100, Continuation<? super Unit> r101) {
        return ((MmRecordingTranslateLanguageView$onAttachedToWindow$1$2) create(Boolean.valueOf(r100), r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        boolean r101 = this.Z$0;
        this.this$0.f436385e.S5(r101);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
