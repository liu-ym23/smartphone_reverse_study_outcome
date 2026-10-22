package com.ss.android.lark.officesdk.minutes.ui.record.recording.language;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "language", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/language/MmSubtitleLanguage;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.language.MmRecordingLanguageChooseView$onAttachedToWindow$1$4", f = "MmRecordingLanguageChooseView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingLanguageChooseView$onAttachedToWindow$1$4 extends SuspendLambda implements Function2<h, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingLanguageChooseView this$0;

    public MmRecordingLanguageChooseView$onAttachedToWindow$1$4(MmRecordingLanguageChooseView r100, Continuation<? super MmRecordingLanguageChooseView$onAttachedToWindow$1$4> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MmRecordingLanguageChooseView$onAttachedToWindow$1$4 r102 = new MmRecordingLanguageChooseView$onAttachedToWindow$1$4(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(h r100, Continuation<? super Unit> r101) {
        return ((MmRecordingLanguageChooseView$onAttachedToWindow$1$4) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(h r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        h r101 = (h) this.L$0;
        this.this$0.f436368g.setIconDesc(r101.f435305b);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
