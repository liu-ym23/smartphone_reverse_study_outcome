package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "result", "Lkotlin/Result;", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmCreateAudioResponse;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareHistoryRecordingStateHandler$onStateChanged$1$uploadIdentity$3", f = "MmSoftwareHistoryRecordingStateHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmSoftwareHistoryRecordingStateHandler$onStateChanged$1$uploadIdentity$3 extends SuspendLambda implements Function2<Result<? extends MmCreateAudioResponse>, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public MmSoftwareHistoryRecordingStateHandler$onStateChanged$1$uploadIdentity$3(Continuation<? super MmSoftwareHistoryRecordingStateHandler$onStateChanged$1$uploadIdentity$3> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MmSoftwareHistoryRecordingStateHandler$onStateChanged$1$uploadIdentity$3 r102 = new MmSoftwareHistoryRecordingStateHandler$onStateChanged$1$uploadIdentity$3(r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Result<? extends MmCreateAudioResponse> r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Result<MmCreateAudioResponse> r100, Continuation<? super Boolean> r101) {
        return ((MmSoftwareHistoryRecordingStateHandler$onStateChanged$1$uploadIdentity$3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r100);
        Result r101 = (Result) this.L$0;
        Throwable r102 = null;
        if (r101 == null) goto L12;
        Object r103 = r101.m9458unboximpl();
        if (Result.m9455isFailureimpl(r103) == false) goto L9;
        r103 = null;
    L9:
        MmCreateAudioResponse r104 = (MmCreateAudioResponse) r103;
        if (r104 == null) goto L12;
        String r105 = r104.getObjectToken();
    L13:
        boolean r106 = true;
        if (r105 != null) goto L16;
    L21:
        boolean r107 = false;
    L22:
        if (r107 == true) goto L29;
        if (r101 == null) goto L25;
        r102 = Result.m9452exceptionOrNullimpl(r101.m9458unboximpl());
    L25:
        if (r102 != null) goto L29;
        r106 = false;
    L29:
        return Boxing.boxBoolean(r106);
    L16:
        if (r105.length() <= 0) goto L18;
        boolean r108 = true;
    L19:
        if (r108 != true) goto L21;
        r107 = true;
        goto L22
    L18:
        r108 = false;
    L12:
        r105 = null;
        goto L13
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
