package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import androidx.camera.video.AudioStats;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingMapSaveHelper", f = "MmRecordingMapSaveHelper.kt", i = {0, 0}, l = {199}, m = "generateSnapshotForMode", n = {"map", "isDarkMode"}, s = {"L$0", "Z$0"})
final class MmRecordingMapSaveHelper$generateSnapshotForMode$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingMapSaveHelper this$0;

    public MmRecordingMapSaveHelper$generateSnapshotForMode$1(MmRecordingMapSaveHelper r100, Continuation<? super MmRecordingMapSaveHelper$generateSnapshotForMode$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        return MmRecordingMapSaveHelper.a(this.this$0, null, null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, false, this);
    }
}
