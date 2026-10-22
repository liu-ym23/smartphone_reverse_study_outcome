package com.enroll.audio.enroll.recorder;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.enroll.audio.enroll.recorder.VoicePrintEnrollRecordingsMgr$BluetoothScoController", f = "VoicePrintEnrollRecordingsMgr.kt", i = {0, 0, 1, 1, 2, 2}, l = {348, 352, 353}, m = "startAndWaitConnected", n = {"am", "startUptime", "am", "startUptime", "am", "startUptime"}, s = {"L$0", "J$0", "L$0", "J$0", "L$0", "J$0"})
public final class VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VoicePrintEnrollRecordingsMgr.BluetoothScoController this$0;

    public VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$1(VoicePrintEnrollRecordingsMgr.BluetoothScoController r100, Continuation<? super VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(this);
    }
}
