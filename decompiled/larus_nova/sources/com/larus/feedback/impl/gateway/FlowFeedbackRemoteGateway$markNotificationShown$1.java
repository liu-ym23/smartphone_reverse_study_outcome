package com.larus.feedback.impl.gateway;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import q99.j;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.feedback.impl.gateway.FlowFeedbackRemoteGateway$markNotificationShown$1", f = "FlowFeedbackRemoteGateway.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
public final class FlowFeedbackRemoteGateway$markNotificationShown$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ j $request;
    int label;

    public FlowFeedbackRemoteGateway$markNotificationShown$1(j r100, Continuation<? super FlowFeedbackRemoteGateway$markNotificationShown$1> r101) {
        this.$request = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new FlowFeedbackRemoteGateway$markNotificationShown$1(this.$request, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((FlowFeedbackRemoteGateway$markNotificationShown$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        dm9.a r103 = (dm9.a) r100;
        if ((r103 instanceof dm9.a.C5690a) == false) goto L15;
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("markPopupShown failed code=");
        dm9.a.C5690a r106 = (dm9.a.C5690a) r103;
        r105.append(r106.f469228a);
        r105.append(" msg=");
        r105.append(r106.f469229b);
        r104.e("FlowFeedbackGateway", r105.toString());
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        FLogger.f375446a.i("FlowFeedbackGateway", "markNotificationShown feedbackId=" + this.$request.a() + " scene=" + this.$request.b());
        FlowFeedbackHttpApi.a r107 = FlowFeedbackHttpApi.f343077a;
        FlowFeedbackRemoteGateway$markNotificationShown$1$result$1 r108 = new FlowFeedbackRemoteGateway$markNotificationShown$1$result$1(this.$request, null);
        this.label = 1;
        r107.getClass();
        r100 = FlowFeedbackHttpApi.a.a(r108, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
