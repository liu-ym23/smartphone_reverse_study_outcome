package com.obric.assistant.feedback;

import com.obric.assistant.feedback.voc.VocApiKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.feedback.ObricFeedbackService$reportToVoc$1", f = "ObricFeedbackService.kt", i = {}, l = {248}, m = "invokeSuspend", n = {}, s = {})
final class ObricFeedbackService$reportToVoc$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IObricFeedbackService.c $param;
    int label;

    public ObricFeedbackService$reportToVoc$1(IObricFeedbackService.c r100, Continuation<? super ObricFeedbackService$reportToVoc$1> r101) {
        this.$param = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ObricFeedbackService$reportToVoc$1(this.$param, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ObricFeedbackService$reportToVoc$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        IObricFeedbackService.c r111 = this.$param;
        String r102 = r111.f389215b;
        if (r102 != null) goto L11;
        r102 = "";
    L11:
        String r103 = r102;
        List<String> r112 = r111.f389216c;
        if (r112 == null) goto L15;
        String r113 = CollectionsKt.joinToString$default(r112, ",", null, null, 0, null, null, 62, null);
        if (r113 == null) goto L15;
    L16:
        this.label = 1;
        if (VocApiKt.a(r103, r113, 1, "{\"is_private_video\":1}", "{\"os\":\"android\"}", this) != r100) goto L20;
        return r100;
    L15:
        r113 = "[]";
        goto L16
    }
}
