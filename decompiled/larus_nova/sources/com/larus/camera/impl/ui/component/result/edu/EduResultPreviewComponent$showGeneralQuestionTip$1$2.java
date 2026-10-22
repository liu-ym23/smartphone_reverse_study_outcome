package com.larus.camera.impl.ui.component.result.edu;

import com.larus.camera.impl.databinding.LarusLayoutViewEduPreviewComponentBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.edu.EduResultPreviewComponent$showGeneralQuestionTip$1$2", f = "EduResultPreviewComponent.kt", i = {}, l = {326}, m = "invokeSuspend", n = {}, s = {})
final class EduResultPreviewComponent$showGeneralQuestionTip$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LarusLayoutViewEduPreviewComponentBinding $this_apply;
    int label;

    public EduResultPreviewComponent$showGeneralQuestionTip$1$2(LarusLayoutViewEduPreviewComponentBinding r100, Continuation<? super EduResultPreviewComponent$showGeneralQuestionTip$1$2> r101) {
        this.$this_apply = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new EduResultPreviewComponent$showGeneralQuestionTip$1$2(this.$this_apply, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((EduResultPreviewComponent$showGeneralQuestionTip$1$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        this.$this_apply.f321524g.setVisibility(8);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        this.$this_apply.f321524g.setVisibility(0);
        this.label = 1;
        if (DelayKt.delay(5000, this) != r101) goto L11;
        return r101;
    }
}
