package com.obric.audio.enroll.recorder;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.recorder.VoicePrintEnrollRecordingsMgr", f = "VoicePrintEnrollRecordingsMgr.kt", i = {}, l = {179, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY}, m = "stopRecording", n = {}, s = {})
public final class VoicePrintEnrollRecordingsMgr$stopRecording$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VoicePrintEnrollRecordingsMgr this$0;

    public VoicePrintEnrollRecordingsMgr$stopRecording$1(VoicePrintEnrollRecordingsMgr r100, Continuation<? super VoicePrintEnrollRecordingsMgr$stopRecording$1> r101) {
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
