package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import androidx.camera.video.AudioStats;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.VideoRef;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingMapSaveHelper", f = "MmRecordingMapSaveHelper.kt", i = {0, 0, 0, 0, 0, 0}, l = {217, VideoRef.VALUE_VIDEO_REF_CONST_DEPTH}, m = "createAndCaptureMap", n = {"map", PerfLog.PARAM_KEY_CONTEXT_ID, KtvSubElement.CONTAINER, "isDarkMode", "latitude", "longitude"}, s = {"L$0", "L$1", "L$2", "Z$0", "D$0", "D$1"})
public final class MmRecordingMapSaveHelper$createAndCaptureMap$1 extends ContinuationImpl {
    double D$0;
    double D$1;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingMapSaveHelper this$0;

    public MmRecordingMapSaveHelper$createAndCaptureMap$1(MmRecordingMapSaveHelper r100, Continuation<? super MmRecordingMapSaveHelper$createAndCaptureMap$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        MmRecordingMapSaveHelper r100 = this.this$0;
        int r111 = MmRecordingMapSaveHelper.f435009m;
        return r100.e(null, null, null, false, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, this);
    }
}
