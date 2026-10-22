package com.larus.office.plugins.preview;

import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.plugins.preview.OfficeDrivePreviewChatSessionAbility", f = "OfficeDrivePreviewChatSessionAbility.kt", i = {0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_POST_PREPARE, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER}, m = "resolveConversationWithCache", n = {PerfLog.PARAM_KEY_CONTEXT_ID, "cacheResourceId", "userId"}, s = {"L$0", "L$1", "L$2"})
public final class OfficeDrivePreviewChatSessionAbility$resolveConversationWithCache$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfficeDrivePreviewChatSessionAbility this$0;

    public OfficeDrivePreviewChatSessionAbility$resolveConversationWithCache$1(OfficeDrivePreviewChatSessionAbility r100, Continuation<? super OfficeDrivePreviewChatSessionAbility$resolveConversationWithCache$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        OfficeDrivePreviewChatSessionAbility r101 = this.this$0;
        int r102 = OfficeDrivePreviewChatSessionAbility.f363146g;
        return r101.f(null, null, this);
    }
}
