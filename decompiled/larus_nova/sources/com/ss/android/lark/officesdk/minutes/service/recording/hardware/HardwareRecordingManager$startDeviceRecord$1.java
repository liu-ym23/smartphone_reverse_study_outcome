package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 3, 4, 5, 5, 5, 6, 6}, l = {513, 518, 522, 533, 543, MediaPlayer.MEDIA_PLAYER_OPTION_SAMPLE_RATE, 562}, m = "startDeviceRecord", n = {"adapter", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "initialPlaybackState", "restoreLegacyRecordingOnFailure", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "initialPlaybackState", "recordingSession", "isMuted", "initialPlaybackState", "recordingSession", "recordingSession", "recordingSession", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "result", "restoreLegacyRecordingOnFailure", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "result"}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$0", "L$0", "L$0", "L$1", "Z$0", "L$0", "L$1"})
final class HardwareRecordingManager$startDeviceRecord$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$startDeviceRecord$1(d r100, Continuation<? super HardwareRecordingManager$startDeviceRecord$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.o(null, this);
    }
}
