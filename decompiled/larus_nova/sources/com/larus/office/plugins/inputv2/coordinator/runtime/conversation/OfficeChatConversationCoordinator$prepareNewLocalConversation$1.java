package com.larus.office.plugins.inputv2.coordinator.runtime.conversation;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.plugins.inputv2.coordinator.runtime.conversation.OfficeChatConversationCoordinator", f = "OfficeChatConversationCoordinator.kt", i = {0, 0, 1, 1, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_ACK_DELAY, 408}, m = "prepareNewLocalConversation", n = {"generation", "trackPromotion", "info", "params", "generation", "trackPromotion"}, s = {"J$0", "Z$0", "L$0", "L$1", "J$0", "Z$0"})
public final class OfficeChatConversationCoordinator$prepareNewLocalConversation$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfficeChatConversationCoordinator this$0;

    public OfficeChatConversationCoordinator$prepareNewLocalConversation$1(OfficeChatConversationCoordinator r100, Continuation<? super OfficeChatConversationCoordinator$prepareNewLocalConversation$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        OfficeChatConversationCoordinator r101 = this.this$0;
        int r102 = OfficeChatConversationCoordinator.f362812m;
        return r101.g(null, 0, false, this);
    }
}
