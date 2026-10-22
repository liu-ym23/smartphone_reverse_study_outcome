package com.larus.live.impl.ttlivesdk.host;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.live.impl.ttlivesdk.host.LiveFlowHostShare", f = "LiveFlowHostShare.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME}, m = "packUrl", n = {"longUrl"}, s = {"L$0"})
public final class LiveFlowHostShare$packUrl$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LiveFlowHostShare this$0;

    public LiveFlowHostShare$packUrl$1(LiveFlowHostShare r100, Continuation<? super LiveFlowHostShare$packUrl$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        LiveFlowHostShare r101 = this.this$0;
        int r102 = LiveFlowHostShare.f355849a;
        return r101.g(null, null, null, false, this);
    }
}
