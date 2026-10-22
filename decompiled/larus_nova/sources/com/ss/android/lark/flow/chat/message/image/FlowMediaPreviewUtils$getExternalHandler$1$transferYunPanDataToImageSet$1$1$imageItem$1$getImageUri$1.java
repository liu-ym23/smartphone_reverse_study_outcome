package com.ss.android.lark.flow.chat.message.image;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.image.FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1", f = "FlowMediaPreviewUtils.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_POST_STALL_500, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSION_TIME_MS, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_ACK_DELAY}, m = "getImageUri", n = {}, s = {})
public final class FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1$getImageUri$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1 this$0;

    public FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1$getImageUri$1(FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1 r100, Continuation<? super FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1$getImageUri$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, false, this);
    }
}
