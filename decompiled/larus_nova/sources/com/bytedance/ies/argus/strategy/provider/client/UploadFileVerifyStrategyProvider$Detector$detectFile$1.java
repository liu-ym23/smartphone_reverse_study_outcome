package com.bytedance.ies.argus.strategy.provider.client;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.ies.argus.strategy.provider.client.UploadFileVerifyStrategyProvider$Detector", f = "UploadFileVerifyStrategyProvider.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME}, m = "detectFile", n = {}, s = {})
public final class UploadFileVerifyStrategyProvider$Detector$detectFile$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UploadFileVerifyStrategyProvider.Detector this$0;

    public UploadFileVerifyStrategyProvider$Detector$detectFile$1(UploadFileVerifyStrategyProvider.Detector r100, Continuation<? super UploadFileVerifyStrategyProvider$Detector$detectFile$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
