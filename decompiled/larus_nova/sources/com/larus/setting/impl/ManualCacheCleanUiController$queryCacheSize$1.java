package com.larus.setting.impl;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.setting.impl.ManualCacheCleanUiController", f = "ManualCacheCleanUiController.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_TFO_FALL_BACK_TIME}, m = "queryCacheSize", n = {"uiTimeoutMs"}, s = {"J$0"})
public final class ManualCacheCleanUiController$queryCacheSize$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ManualCacheCleanUiController this$0;

    public ManualCacheCleanUiController$queryCacheSize$1(ManualCacheCleanUiController r100, Continuation<? super ManualCacheCleanUiController$queryCacheSize$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        ManualCacheCleanUiController r101 = this.this$0;
        ManualCacheCleanUiController r102 = ManualCacheCleanUiController.f367966a;
        return r101.e(this);
    }
}
