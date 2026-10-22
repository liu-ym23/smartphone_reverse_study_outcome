package com.larus.dora.impl.feedback;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u008a@¨\u0006\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$6$2"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.feedback.DoraFeedbackImageGroup$trackAllImagesReadyState$1$1$invokeSuspend$$inlined$combine$1$3", f = "DoraGFeedbackViewModel.kt", i = {}, l = {288}, m = "invokeSuspend", n = {}, s = {})
public final class DoraFeedbackImageGroup$trackAllImagesReadyState$1$1$invokeSuspend$$inlined$combine$1$3 extends SuspendLambda implements Function3<FlowCollector<? super Boolean>, ImageState[], Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public DoraFeedbackImageGroup$trackAllImagesReadyState$1$1$invokeSuspend$$inlined$combine$1$3(Continuation r100) {
        super(3, r100);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Boolean> r100, ImageState[] r101, Continuation<? super Unit> r102) {
        return invoke(r100, r101, r102);
    }

    public final Object invoke(FlowCollector<? super Boolean> r100, ImageState[] r101, Continuation<? super Unit> r102) {
        DoraFeedbackImageGroup$trackAllImagesReadyState$1$1$invokeSuspend$$inlined$combine$1$3 r103 = new DoraFeedbackImageGroup$trackAllImagesReadyState$1$1$invokeSuspend$$inlined$combine$1$3(r102);
        r103.L$0 = r100;
        r103.L$1 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L22:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        FlowCollector r103 = (FlowCollector) this.L$0;
        ImageState[] r104 = (ImageState[]) ((Object[]) this.L$1);
        int r105 = r104.length;
        boolean r106 = false;
        int r107 = 0;
    L9:
        if (r107 >= r105) goto L17;
        if (r104[r107] != ImageState.READY) goto L13;
        boolean r108 = true;
    L14:
        if (r108 == false) goto L18;
        r107 = r107 + 1;
    L18:
        Boolean r109 = Boxing.boxBoolean(r106);
        this.label = 1;
        if (r103.emit(r109, this) != r101) goto L22;
        return r101;
    L13:
        r108 = false;
        goto L14
    L17:
        r106 = true;
        goto L18
    }
}
