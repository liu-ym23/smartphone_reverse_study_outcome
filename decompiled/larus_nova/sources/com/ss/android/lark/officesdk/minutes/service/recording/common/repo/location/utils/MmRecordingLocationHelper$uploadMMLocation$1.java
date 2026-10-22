package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import androidx.camera.video.AudioStats;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingLocationHelper", f = "MmRecordingLocationHelper.kt", i = {}, l = {115}, m = "uploadMMLocation-bMdYcbs", n = {}, s = {})
public final class MmRecordingLocationHelper$uploadMMLocation$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingLocationHelper this$0;

    public MmRecordingLocationHelper$uploadMMLocation$1(MmRecordingLocationHelper r100, Continuation<? super MmRecordingLocationHelper$uploadMMLocation$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        Object r111 = this.this$0.a(null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, null, null, false, this);
        if (r111 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r111;
    L6:
        return Result.m9448boximpl(r111);
    }
}
