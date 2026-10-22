package com.larus.im.internal.core.conversation.group;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.conversation.group.LoadLocalConversationsProcessor$QueryUnPinState", f = "LoadLocalConversationsProcessor.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_QUERY, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300}, m = "queryLogic", n = {}, s = {})
public final class LoadLocalConversationsProcessor$QueryUnPinState$queryLogic$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoadLocalConversationsProcessor.QueryUnPinState this$0;

    public LoadLocalConversationsProcessor$QueryUnPinState$queryLogic$1(LoadLocalConversationsProcessor.QueryUnPinState r100, Continuation<? super LoadLocalConversationsProcessor$QueryUnPinState$queryLogic$1> r101) {
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
