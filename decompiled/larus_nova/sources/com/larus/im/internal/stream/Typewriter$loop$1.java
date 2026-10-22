package com.larus.im.internal.stream;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.stream.Typewriter", f = "Typewriter.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS}, m = "loop", n = {"messageId", "containerId", "serverConfig", "containerDelayTimeMap", "isSmoothMode", "defaultDelayTime", "time", "keepPendingDecisionForNextChunk", "realDelay"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "D$0", "D$1", "I$0", "J$0"})
final class Typewriter$loop$1 extends ContinuationImpl {
    double D$0;
    double D$1;
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Typewriter this$0;

    public Typewriter$loop$1(Typewriter r100, Continuation<? super Typewriter$loop$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return Typewriter.a(this.this$0, this);
    }
}
