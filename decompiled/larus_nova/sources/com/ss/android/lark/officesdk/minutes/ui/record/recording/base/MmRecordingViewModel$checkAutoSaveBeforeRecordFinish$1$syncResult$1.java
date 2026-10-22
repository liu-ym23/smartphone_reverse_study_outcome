package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmUpdateAudioStatusResponse;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmUpdateAudioStatusResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$checkAutoSaveBeforeRecordFinish$1$syncResult$1", f = "MmRecordingViewModel.kt", i = {}, l = {1439}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingViewModel$checkAutoSaveBeforeRecordFinish$1$syncResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends MmUpdateAudioStatusResponse>>, Object> {
    final /* synthetic */ Deferred<Result<MmUpdateAudioStatusResponse>> $syncJob;
    int label;

    public MmRecordingViewModel$checkAutoSaveBeforeRecordFinish$1$syncResult$1(Deferred<Result<MmUpdateAudioStatusResponse>> r100, Continuation<? super MmRecordingViewModel$checkAutoSaveBeforeRecordFinish$1$syncResult$1> r101) {
        this.$syncJob = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MmRecordingViewModel$checkAutoSaveBeforeRecordFinish$1$syncResult$1(this.$syncJob, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Result<? extends MmUpdateAudioStatusResponse>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Result<MmUpdateAudioStatusResponse>> r101) {
        return ((MmRecordingViewModel$checkAutoSaveBeforeRecordFinish$1$syncResult$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        Deferred<Result<MmUpdateAudioStatusResponse>> r103 = this.$syncJob;
        this.label = 1;
        r100 = r103.await(this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
