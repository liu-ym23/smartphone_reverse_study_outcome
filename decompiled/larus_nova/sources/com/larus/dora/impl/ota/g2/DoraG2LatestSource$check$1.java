package com.larus.dora.impl.ota.g2;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.g2.DoraG2LatestSource", f = "G2OtaRuntime.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_LIVE_FRAME_RENDER_TIME}, m = "check", n = {"effect"}, s = {"L$0"})
public final class DoraG2LatestSource$check$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraG2LatestSource this$0;

    public DoraG2LatestSource$check$1(DoraG2LatestSource r100, Continuation<? super DoraG2LatestSource$check$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
