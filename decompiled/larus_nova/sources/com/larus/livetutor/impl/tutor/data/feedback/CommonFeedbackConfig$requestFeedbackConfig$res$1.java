package com.larus.livetutor.impl.tutor.data.feedback;

import com.larus.livetutor.api.idl.GetCommonFeedbackConfRequest;
import com.larus.livetutor.api.idl.GetCommonFeedbackConfResponse;
import com.larus.livetutor.impl.repository.LiveTutorApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/livetutor/api/idl/GetCommonFeedbackConfResponse;", "Lcom/larus/livetutor/impl/repository/LiveTutorApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.livetutor.impl.tutor.data.feedback.CommonFeedbackConfig$requestFeedbackConfig$res$1", f = "CommonFeedbackConfig.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
public final class CommonFeedbackConfig$requestFeedbackConfig$res$1 extends SuspendLambda implements Function2<LiveTutorApi, Continuation<? super GetCommonFeedbackConfResponse>, Object> {
    final /* synthetic */ long $tutorId;
    private /* synthetic */ Object L$0;
    int label;

    public CommonFeedbackConfig$requestFeedbackConfig$res$1(long r100, Continuation<? super CommonFeedbackConfig$requestFeedbackConfig$res$1> r101) {
        this.$tutorId = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CommonFeedbackConfig$requestFeedbackConfig$res$1 r102 = new CommonFeedbackConfig$requestFeedbackConfig$res$1(this.$tutorId, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(LiveTutorApi r100, Continuation<? super GetCommonFeedbackConfResponse> r101) {
        return ((CommonFeedbackConfig$requestFeedbackConfig$res$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(LiveTutorApi r100, Continuation<? super GetCommonFeedbackConfResponse> r101) {
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
        GetCommonFeedbackConfRequest r104 = new GetCommonFeedbackConfRequest(Boxing.boxLong(this.$tutorId));
        this.label = 1;
        r100 = r103.getCommonFeedbackConfSync(r104, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
