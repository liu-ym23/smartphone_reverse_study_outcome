package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmCreateAudioResponse;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService$syncRecordingStatus$idForStatus$2", f = "MmRecordingStatesSyncService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingStatesSyncService$syncRecordingStatus$idForStatus$2 extends SuspendLambda implements Function2<MmCreateAudioResponse, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public MmRecordingStatesSyncService$syncRecordingStatus$idForStatus$2(Continuation<? super MmRecordingStatesSyncService$syncRecordingStatus$idForStatus$2> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MmRecordingStatesSyncService$syncRecordingStatus$idForStatus$2 r102 = new MmRecordingStatesSyncService$syncRecordingStatus$idForStatus$2(r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(MmCreateAudioResponse r100, Continuation<? super Boolean> r101) {
        return ((MmRecordingStatesSyncService$syncRecordingStatus$idForStatus$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(MmCreateAudioResponse r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r100);
        MmCreateAudioResponse r101 = (MmCreateAudioResponse) this.L$0;
        boolean r102 = false;
        if (r101 == null) goto L15;
        String r103 = r101.getObjectToken();
        if (r103 == null) goto L15;
        if (r103.length() <= 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 != true) goto L15;
        r102 = true;
        goto L15
    L11:
        r104 = false;
    L15:
        return Boxing.boxBoolean(r102);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
