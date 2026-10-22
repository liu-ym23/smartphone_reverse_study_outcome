package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {184, 198, 210}, m = "requestStartRecordingLocked", n = {"request", "hardwareDeviceId", "restoreLegacyRecordingOnFailure", "request", "adapter", "sceneInstanceId", "initialPlaybackState", "restoreLegacyRecordingOnFailure", "timestampSeconds"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "J$0"})
final class HardwareRecordingManager$requestStartRecordingLocked$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$requestStartRecordingLocked$1(d r100, Continuation<? super HardwareRecordingManager$requestStartRecordingLocked$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m(null, false, this);
    }
}
