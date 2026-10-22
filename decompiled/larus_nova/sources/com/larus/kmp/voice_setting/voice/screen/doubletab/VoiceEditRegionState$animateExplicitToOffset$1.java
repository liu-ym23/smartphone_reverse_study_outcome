package com.larus.kmp.voice_setting.voice.screen.doubletab;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.kmp.voice_setting.voice.screen.doubletab.VoiceEditRegionState", f = "DoubleTabChromeState.kt", i = {0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ROTATION}, m = "animateExplicitToOffset", n = {"onAppBarCollapsedChanged", "collapsed", "targetOffset"}, s = {"L$0", "Z$0", "F$0"})
public final class VoiceEditRegionState$animateExplicitToOffset$1 extends ContinuationImpl {
    float F$0;
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VoiceEditRegionState this$0;

    public VoiceEditRegionState$animateExplicitToOffset$1(VoiceEditRegionState r100, Continuation<? super VoiceEditRegionState$animateExplicitToOffset$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(false, 0.0f, null, this);
    }
}
