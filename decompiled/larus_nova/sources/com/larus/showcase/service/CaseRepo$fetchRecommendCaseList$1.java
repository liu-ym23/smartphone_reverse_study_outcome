package com.larus.showcase.service;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.showcase.service.CaseRepo", f = "CaseRepo.kt", i = {1, 2, 3, 3, 4}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, MediaPlayer.MEDIA_PLAYER_OPTION_PREPARE_CACHE_MS, MediaPlayer.MEDIA_PLAYER_OPTION_DANGER_BUFFER_THRESHOLD, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL}, m = "fetchRecommendCaseList", n = {"cacheList", "cacheList", "cacheList", "caseList", "caseList"}, s = {"L$0", "L$0", "L$0", "L$1", "L$0"})
public final class CaseRepo$fetchRecommendCaseList$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CaseRepo this$0;

    public CaseRepo$fetchRecommendCaseList$1(CaseRepo r100, Continuation<? super CaseRepo$fetchRecommendCaseList$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(this);
    }
}
