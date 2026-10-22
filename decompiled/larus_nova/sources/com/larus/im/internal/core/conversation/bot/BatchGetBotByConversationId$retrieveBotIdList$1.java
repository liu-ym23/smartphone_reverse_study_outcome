package com.larus.im.internal.core.conversation.bot;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.conversation.bot.BatchGetBotByConversationId", f = "BatchGetBotByConversationId.kt", i = {0, 0, 0, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE}, m = "retrieveBotIdList", n = {"convId", "existBot", "needFetchBotId", "fetchInfo"}, s = {"L$0", "L$1", "L$2", "L$0"})
public final class BatchGetBotByConversationId$retrieveBotIdList$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BatchGetBotByConversationId this$0;

    public BatchGetBotByConversationId$retrieveBotIdList$1(BatchGetBotByConversationId r100, Continuation<? super BatchGetBotByConversationId$retrieveBotIdList$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, null, this);
    }
}
