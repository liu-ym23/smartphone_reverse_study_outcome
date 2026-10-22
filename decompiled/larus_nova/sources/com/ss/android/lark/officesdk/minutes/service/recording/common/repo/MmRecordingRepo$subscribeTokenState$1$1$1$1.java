package com.ss.android.lark.officesdk.minutes.service.recording.common.repo;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import ovb.b;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/data/MmRecordingData;", "data"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo$subscribeTokenState$1$1$1$1", f = "MmRecordingRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingRepo$subscribeTokenState$1$1$1$1 extends SuspendLambda implements Function2<b, Continuation<? super b>, Object> {
    final /* synthetic */ MmCreateAudioResponse $it;
    /* synthetic */ Object L$0;
    int label;

    public MmRecordingRepo$subscribeTokenState$1$1$1$1(MmCreateAudioResponse r100, Continuation<? super MmRecordingRepo$subscribeTokenState$1$1$1$1> r101) {
        this.$it = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MmRecordingRepo$subscribeTokenState$1$1$1$1 r102 = new MmRecordingRepo$subscribeTokenState$1$1$1$1(this.$it, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(b r100, Continuation<? super b> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(b r100, Continuation<? super b> r101) {
        return ((MmRecordingRepo$subscribeTokenState$1$1$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r110);
        return b.a((b) this.L$0, null, 0, null, this.$it.getObjectToken(), null, null, false, 247);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
