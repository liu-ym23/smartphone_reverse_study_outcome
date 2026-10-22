package com.larus.dora.impl.device.settings.gesture.wakeup;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupRepository", f = "GestureWakeupRepository.kt", i = {}, l = {270, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME, 274, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, 280, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER, MediaPlayer.MEDIA_PLAYER_OPTION_FRC_LEVEL, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 290}, m = "updateQuickNoteWake", n = {}, s = {})
public final class GestureWakeupRepository$updateQuickNoteWake$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GestureWakeupRepository this$0;

    public GestureWakeupRepository$updateQuickNoteWake$1(GestureWakeupRepository r100, Continuation<? super GestureWakeupRepository$updateQuickNoteWake$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        GestureWakeupRepository r101 = this.this$0;
        GestureWakeupRepository r102 = GestureWakeupRepository.f334505a;
        return r101.l(0, null, this);
    }
}
