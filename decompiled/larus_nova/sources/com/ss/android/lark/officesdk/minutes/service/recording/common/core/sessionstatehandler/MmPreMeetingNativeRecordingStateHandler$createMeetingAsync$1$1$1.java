package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.ttvideoengine.DataLoaderHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/data/MmRecordingData;", "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmPreMeetingNativeRecordingStateHandler$createMeetingAsync$1$1$1", f = "MmPreMeetingNativeRecordingStateHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmPreMeetingNativeRecordingStateHandler$createMeetingAsync$1$1$1 extends SuspendLambda implements Function2<ovb.b, Continuation<? super ovb.b>, Object> {
    final /* synthetic */ String $meetingId;
    final /* synthetic */ long $meetingStartTime;
    final /* synthetic */ String $recordingId;
    /* synthetic */ Object L$0;
    int label;

    public MmPreMeetingNativeRecordingStateHandler$createMeetingAsync$1$1$1(String r100, String r101, long r102, Continuation<? super MmPreMeetingNativeRecordingStateHandler$createMeetingAsync$1$1$1> r103) {
        this.$meetingId = r100;
        this.$recordingId = r101;
        this.$meetingStartTime = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MmPreMeetingNativeRecordingStateHandler$createMeetingAsync$1$1$1 r102 = new MmPreMeetingNativeRecordingStateHandler$createMeetingAsync$1$1$1(this.$meetingId, this.$recordingId, this.$meetingStartTime, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ovb.b r100, Continuation<? super ovb.b> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ovb.b r100, Continuation<? super ovb.b> r101) {
        return ((MmPreMeetingNativeRecordingStateHandler$createMeetingAsync$1$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r110);
        ovb.b r100 = (ovb.b) this.L$0;
        String r101 = this.$meetingId;
        Intrinsics.checkNotNull(r101);
        MmRecordingCommonParam r102 = r100.f526987f;
        String r103 = this.$meetingId;
        Intrinsics.checkNotNull(r103);
        String r104 = this.$recordingId;
        if (r104.length() != 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L10;
        r104 = r100.f526988g;
    L10:
        MmRecordingCommonParam r106 = MmRecordingCommonParam.copy$default(r102, null, r104, false, null, r103, null, null, null, null, null, null, DataLoaderHelper.DATALOADER_KEY_STRING_PRECISE_PRELOAD_CONFIG, null);
        return ovb.b.a(r100, r101, this.$meetingStartTime, this.$recordingId, null, r106, null, true, 88);
    L7:
        r105 = false;
        goto L8
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
