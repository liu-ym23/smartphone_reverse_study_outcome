package com.obric.assistant.onelogin;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.onelogin.ObricOneLoginActivity", f = "ObricOneLoginActivity.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_READ_MODE}, m = "awaitForSettingsReady", n = {}, s = {})
final class ObricOneLoginActivity$awaitForSettingsReady$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricOneLoginActivity this$0;

    public ObricOneLoginActivity$awaitForSettingsReady$1(ObricOneLoginActivity r100, Continuation<? super ObricOneLoginActivity$awaitForSettingsReady$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ObricOneLoginActivity.N1(this.this$0, this);
    }
}
