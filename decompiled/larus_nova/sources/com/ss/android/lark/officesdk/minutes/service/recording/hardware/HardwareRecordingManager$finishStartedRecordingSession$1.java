package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityScene;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 1, 2}, l = {592, 593, 596}, m = "finishStartedRecordingSession", n = {AppbrandHostConstants.SCHEMA_INSPECT.SESSION, AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "stopResult"}, s = {"L$0", "L$0", "L$0"})
final class HardwareRecordingManager$finishStartedRecordingSession$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$finishStartedRecordingSession$1(d r100, Continuation<? super HardwareRecordingManager$finishStartedRecordingSession$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        d r101 = this.this$0;
        r101.getClass();
        int r102 = this.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r102 - Integer.MIN_VALUE;
        HardwareRecordingManager$finishStartedRecordingSession$1 r103 = this;
    L6:
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L18;
        if (r106 == 1) goto L17;
        if (r106 != 2) goto L11;
        e r107 = (e) r103.L$0;
        ResultKt.throwOnFailure(r104);
        a r108 = (a) r104;
        RecordingPriorityScene r109 = RecordingPriorityScene.D3200_RECORDING;
        String r110 = r107.f435553a;
        throw null;
    L11:
        if (r106 != 3) goto L14;
        a r111 = (a) r103.L$0;
        ResultKt.throwOnFailure(r104);
        return r111;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        e r112 = (e) r103.L$0;
        ResultKt.throwOnFailure(r104);
    L22:
        r103.L$0 = r112;
        r103.label = 2;
        throw null;
    L18:
        ResultKt.throwOnFailure(r104);
        r103.L$0 = null;
        r103.label = 1;
        if (r101.q(null, "finishStartedRecordingSession", r103) == r105) goto L24;
        r112 = null;
        goto L22
    L24:
        return r105;
    L5:
        r103 = new HardwareRecordingManager$finishStartedRecordingSession$1(r101, this);
        goto L6
    }
}
