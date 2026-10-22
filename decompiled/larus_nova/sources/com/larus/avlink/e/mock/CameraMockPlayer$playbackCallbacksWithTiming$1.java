package com.larus.avlink.e.mock;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.e.mock.CameraMockPlayer", f = "CameraMockPlayer.kt", i = {0, 0, 1, 1, 1}, l = {384, MediaPlayer.MEDIA_PLAYER_OPTION_HURRY_MILLISECOND}, m = "playbackCallbacksWithTiming", n = {"callbacks", "callback", "callbacks", "timing", "callback"}, s = {"L$0", "L$2", "L$0", "L$1", "L$3"})
final class CameraMockPlayer$playbackCallbacksWithTiming$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ f this$0;

    public CameraMockPlayer$playbackCallbacksWithTiming$1(f r100, Continuation<? super CameraMockPlayer$playbackCallbacksWithTiming$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return f.b(this.this$0, null, null, this);
    }
}
