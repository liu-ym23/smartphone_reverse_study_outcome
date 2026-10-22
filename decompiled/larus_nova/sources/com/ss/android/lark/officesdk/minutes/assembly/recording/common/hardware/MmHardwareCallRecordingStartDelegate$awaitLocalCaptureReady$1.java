package com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware.MmHardwareCallRecordingStartDelegate", f = "MmHardwareCallRecordingStartDelegate.kt", i = {}, l = {212}, m = "awaitLocalCaptureReady", n = {}, s = {})
public final class MmHardwareCallRecordingStartDelegate$awaitLocalCaptureReady$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmHardwareCallRecordingStartDelegate this$0;

    public MmHardwareCallRecordingStartDelegate$awaitLocalCaptureReady$1(MmHardwareCallRecordingStartDelegate r100, Continuation<? super MmHardwareCallRecordingStartDelegate$awaitLocalCaptureReady$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        MmHardwareCallRecordingStartDelegate r101 = this.this$0;
        int r102 = MmHardwareCallRecordingStartDelegate.f433653g;
        return r101.a(null, this);
    }
}
