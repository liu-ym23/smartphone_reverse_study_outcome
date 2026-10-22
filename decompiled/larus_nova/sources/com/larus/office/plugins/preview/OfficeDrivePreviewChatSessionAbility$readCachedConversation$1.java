package com.larus.office.plugins.preview;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.plugins.preview.OfficeDrivePreviewChatSessionAbility", f = "OfficeDrivePreviewChatSessionAbility.kt", i = {0, 0, 1, 1, 1, 3, 3, 3, 3}, l = {300, MediaPlayer.MEDIA_PLAYER_OPTION_TFO_FALL_BACK_TIME, 320, 328, 330}, m = "readCachedConversation", n = {"userId", "cacheResourceId", "userId", "cacheResourceId", "cachedConversationId", "userId", "cacheResourceId", "cachedConversationId", "remoteConversation"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
public final class OfficeDrivePreviewChatSessionAbility$readCachedConversation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfficeDrivePreviewChatSessionAbility this$0;

    public OfficeDrivePreviewChatSessionAbility$readCachedConversation$1(OfficeDrivePreviewChatSessionAbility r100, Continuation<? super OfficeDrivePreviewChatSessionAbility$readCachedConversation$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        OfficeDrivePreviewChatSessionAbility r101 = this.this$0;
        int r102 = OfficeDrivePreviewChatSessionAbility.f363146g;
        return r101.d(null, null, this);
    }
}
