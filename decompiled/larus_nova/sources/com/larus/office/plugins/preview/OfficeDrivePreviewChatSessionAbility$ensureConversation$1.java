package com.larus.office.plugins.preview;

import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.plugins.preview.OfficeDrivePreviewChatSessionAbility", f = "OfficeDrivePreviewChatSessionAbility.kt", i = {0, 0, 1, 2, 2, 2, 3, 3}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DOWNLOAD_BYTES, 111, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 134}, m = "ensureConversation", n = {"requestedSourceConversationId", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", PerfLog.PARAM_KEY_CONTEXT_ID, "cacheResourceId", "$this$withLock_u24default$iv", "cacheResourceId", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$0", "L$1", "L$2", "L$0", "L$1"})
public final class OfficeDrivePreviewChatSessionAbility$ensureConversation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfficeDrivePreviewChatSessionAbility this$0;

    public OfficeDrivePreviewChatSessionAbility$ensureConversation$1(OfficeDrivePreviewChatSessionAbility r100, Continuation<? super OfficeDrivePreviewChatSessionAbility$ensureConversation$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
