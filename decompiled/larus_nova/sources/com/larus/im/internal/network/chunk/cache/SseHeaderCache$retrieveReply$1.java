package com.larus.im.internal.network.chunk.cache;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.network.chunk.cache.SseHeaderCache", f = "SseHeaderCache.kt", i = {0, 0, 0, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME}, m = "retrieveReply", n = {"key", "questionID", "conversationID", "key", "replies"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
public final class SseHeaderCache$retrieveReply$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SseHeaderCache this$0;

    public SseHeaderCache$retrieveReply$1(SseHeaderCache r100, Continuation<? super SseHeaderCache$retrieveReply$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(null, this);
    }
}
