package com.larus.office.plugins.preview;

import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.plugins.preview.OfficeDrivePreviewChatSessionAbility", f = "OfficeDrivePreviewChatSessionAbility.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSIONS, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MIN_RECEIVED_BEFORE_ACK_DECIMATION, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PAD_HELLO}, m = "createLocalConversation", n = {PerfLog.PARAM_KEY_CONTEXT_ID, "cacheResourceId", "cacheOnPromotion", PerfLog.PARAM_KEY_CONTEXT_ID, "cacheResourceId", "botId", "cacheOnPromotion", "cacheResourceId", "botId", "botModel", "cacheOnPromotion"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0"})
public final class OfficeDrivePreviewChatSessionAbility$createLocalConversation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfficeDrivePreviewChatSessionAbility this$0;

    public OfficeDrivePreviewChatSessionAbility$createLocalConversation$1(OfficeDrivePreviewChatSessionAbility r100, Continuation<? super OfficeDrivePreviewChatSessionAbility$createLocalConversation$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        OfficeDrivePreviewChatSessionAbility r101 = this.this$0;
        int r102 = OfficeDrivePreviewChatSessionAbility.f363146g;
        return r101.a(null, null, false, this);
    }
}
