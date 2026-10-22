package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmPreMeetingNativeRecordingStateHandler", f = "MmPreMeetingNativeRecordingStateHandler.kt", i = {1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_ABR_SWITCH_PREV_AUDIO_BUFFER}, m = "copyRecordingDirToMeetingIdIfNeeded", n = {"sessionKey", "meetingId"}, s = {"L$0", "L$1"})
final class MmPreMeetingNativeRecordingStateHandler$copyRecordingDirToMeetingIdIfNeeded$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmPreMeetingNativeRecordingStateHandler this$0;

    public MmPreMeetingNativeRecordingStateHandler$copyRecordingDirToMeetingIdIfNeeded$1(MmPreMeetingNativeRecordingStateHandler r100, Continuation<? super MmPreMeetingNativeRecordingStateHandler$copyRecordingDirToMeetingIdIfNeeded$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MmPreMeetingNativeRecordingStateHandler.d(this.this$0, this);
    }
}
