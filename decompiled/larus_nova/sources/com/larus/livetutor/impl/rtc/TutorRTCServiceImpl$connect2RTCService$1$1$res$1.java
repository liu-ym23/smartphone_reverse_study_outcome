package com.larus.livetutor.impl.rtc;

import com.larus.livetutor.api.idl.StartCallRequest;
import com.larus.livetutor.api.idl.StartCallResponse;
import com.larus.livetutor.impl.repository.LiveTutorApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/livetutor/api/idl/StartCallResponse;", "Lcom/larus/livetutor/impl/repository/LiveTutorApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.livetutor.impl.rtc.TutorRTCServiceImpl$connect2RTCService$1$1$res$1", f = "TutorRTCServiceImpl.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
public final class TutorRTCServiceImpl$connect2RTCService$1$1$res$1 extends SuspendLambda implements Function2<LiveTutorApi, Continuation<? super StartCallResponse>, Object> {
    final /* synthetic */ StartCallRequest $startCallRequest;
    private /* synthetic */ Object L$0;
    int label;

    public TutorRTCServiceImpl$connect2RTCService$1$1$res$1(StartCallRequest r100, Continuation<? super TutorRTCServiceImpl$connect2RTCService$1$1$res$1> r101) {
        this.$startCallRequest = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        TutorRTCServiceImpl$connect2RTCService$1$1$res$1 r102 = new TutorRTCServiceImpl$connect2RTCService$1$1$res$1(this.$startCallRequest, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(LiveTutorApi r100, Continuation<? super StartCallResponse> r101) {
        return ((TutorRTCServiceImpl$connect2RTCService$1$1$res$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(LiveTutorApi r100, Continuation<? super StartCallResponse> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        LiveTutorApi r103 = (LiveTutorApi) this.L$0;
        StartCallRequest r104 = this.$startCallRequest;
        this.label = 1;
        r100 = r103.startRealtimeCallSync(r104, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
