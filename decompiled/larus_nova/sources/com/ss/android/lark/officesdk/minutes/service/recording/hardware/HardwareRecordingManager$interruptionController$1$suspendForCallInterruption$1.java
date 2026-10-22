package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager$interruptionController$1", f = "HardwareRecordingManager.kt", i = {0}, l = {52}, m = "suspendForCallInterruption", n = {"interruptedPlaybackState"}, s = {"L$0"})
final class HardwareRecordingManager$interruptionController$1$suspendForCallInterruption$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ c this$0;

    public HardwareRecordingManager$interruptionController$1$suspendForCallInterruption$1(c r100, Continuation<? super HardwareRecordingManager$interruptionController$1$suspendForCallInterruption$1> r101) {
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
