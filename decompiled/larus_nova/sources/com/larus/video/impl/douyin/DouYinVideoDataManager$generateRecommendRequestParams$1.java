package com.larus.video.impl.douyin;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.video.impl.douyin.DouYinVideoDataManager", f = "DouYinVideoDataManager.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSIONS}, m = "generateRecommendRequestParams", n = {}, s = {})
public final class DouYinVideoDataManager$generateRecommendRequestParams$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DouYinVideoDataManager this$0;

    public DouYinVideoDataManager$generateRecommendRequestParams$1(DouYinVideoDataManager r100, Continuation<? super DouYinVideoDataManager$generateRecommendRequestParams$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
