package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.main.side_bar.view.group.datasource.im.ImProjectSource", f = "ImProjectSource.kt", i = {0, 0, 1, 1}, l = {TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPTIMIZE_SEEK_CLK, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPTIMIZE_SEEK_CLK}, m = "loadMoreConversations", n = {"state", "normalizedPageSize", "state", "page"}, s = {"L$0", "I$0", "L$0", "L$1"})
public final class ImProjectSource$loadMoreConversations$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImProjectSource this$0;

    public ImProjectSource$loadMoreConversations$1(ImProjectSource r100, Continuation<? super ImProjectSource$loadMoreConversations$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.n(null, this);
    }
}
