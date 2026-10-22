package com.obric.assistant.session.lifecycle;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.session.lifecycle.WakeupSoundPlayer", f = "BaseSessionLifecycleImpl.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME}, m = "playWakeupSound", n = {}, s = {})
public final class WakeupSoundPlayer$playWakeupSound$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WakeupSoundPlayer this$0;

    public WakeupSoundPlayer$playWakeupSound$1(WakeupSoundPlayer r100, Continuation<? super WakeupSoundPlayer$playWakeupSound$1> r101) {
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
