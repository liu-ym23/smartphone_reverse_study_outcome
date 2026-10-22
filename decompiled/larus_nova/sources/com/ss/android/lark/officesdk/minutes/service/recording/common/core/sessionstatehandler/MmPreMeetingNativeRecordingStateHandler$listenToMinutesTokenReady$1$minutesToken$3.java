package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmPreMeetingNativeRecordingStateHandler$listenToMinutesTokenReady$1$minutesToken$3", f = "MmPreMeetingNativeRecordingStateHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmPreMeetingNativeRecordingStateHandler$listenToMinutesTokenReady$1$minutesToken$3 extends SuspendLambda implements Function2<String, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public MmPreMeetingNativeRecordingStateHandler$listenToMinutesTokenReady$1$minutesToken$3(Continuation<? super MmPreMeetingNativeRecordingStateHandler$listenToMinutesTokenReady$1$minutesToken$3> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MmPreMeetingNativeRecordingStateHandler$listenToMinutesTokenReady$1$minutesToken$3 r102 = new MmPreMeetingNativeRecordingStateHandler$listenToMinutesTokenReady$1$minutesToken$3(r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(String r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(String r100, Continuation<? super Boolean> r101) {
        return ((MmPreMeetingNativeRecordingStateHandler$listenToMinutesTokenReady$1$minutesToken$3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        if (((String) this.L$0).length() <= 0) goto L7;
        boolean r101 = true;
    L9:
        return Boxing.boxBoolean(r101);
    L7:
        r101 = false;
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
