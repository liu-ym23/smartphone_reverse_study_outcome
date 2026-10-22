package com.larus.bmhome.chat.component.bottom.voice.service;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.voice.service.VoiceMixInputManager$TextStreamWrapper", f = "VoiceMixInputManager.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPEN_TIMEOUT}, m = "startUpdateTextStream", n = {}, s = {})
public final class VoiceMixInputManager$TextStreamWrapper$startUpdateTextStream$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VoiceMixInputManager.TextStreamWrapper this$0;

    public VoiceMixInputManager$TextStreamWrapper$startUpdateTextStream$1(VoiceMixInputManager.TextStreamWrapper r100, Continuation<? super VoiceMixInputManager$TextStreamWrapper$startUpdateTextStream$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(this);
    }
}
