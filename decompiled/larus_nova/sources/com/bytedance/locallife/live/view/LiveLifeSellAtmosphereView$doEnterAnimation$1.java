package com.bytedance.locallife.live.view;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.locallife.live.view.LiveLifeSellAtmosphereView", f = "LiveLifeSellAtmosphereView.kt", i = {0, 0, 1, 1, 4, 4}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_GET_CACHE_TIMESTAMP, MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE, MediaPlayer.MEDIA_PLAYER_OPTION_DANGER_BUFFER_THRESHOLD, MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_BUFFER_LIMIT, 308, 312}, m = "doEnterAnimation", n = {"this", "atmosphereUiData", "this", "atmosphereUiData", "this", "atmosphereUiData"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
public final class LiveLifeSellAtmosphereView$doEnterAnimation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LiveLifeSellAtmosphereView this$0;

    public LiveLifeSellAtmosphereView$doEnterAnimation$1(LiveLifeSellAtmosphereView r100, Continuation<? super LiveLifeSellAtmosphereView$doEnterAnimation$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        LiveLifeSellAtmosphereView r101 = this.this$0;
        int r102 = LiveLifeSellAtmosphereView.f260779w;
        return r101.c(null, this);
    }
}
