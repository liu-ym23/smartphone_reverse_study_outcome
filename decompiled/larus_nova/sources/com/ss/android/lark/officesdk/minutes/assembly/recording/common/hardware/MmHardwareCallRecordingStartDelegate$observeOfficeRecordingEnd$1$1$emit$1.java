package com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware.MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1$1", f = "MmHardwareCallRecordingStartDelegate.kt", i = {0}, l = {200}, m = "emit", n = {"endReason"}, s = {"L$0"})
final class MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1.a<Object> this$0;

    public MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1$1$emit$1(MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1.a<Object> r100, Continuation<? super MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1$1$emit$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
