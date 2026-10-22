package com.larus.setting.impl;

import com.ss.android.dypay.api.DyPayConstant;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.setting.impl.ManualCacheCleanUiController", f = "ManualCacheCleanUiController.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER}, m = "executeAndReportClean", n = {"operationId", "currentPage", "beforeBytes", DyPayConstant.KEY_START_TIME, "operationId", "currentPage", "result", "beforeBytes", DyPayConstant.KEY_START_TIME}, s = {"L$0", "L$1", "J$0", "J$1", "L$0", "L$1", "L$2", "J$0", "J$1"})
final class ManualCacheCleanUiController$executeAndReportClean$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ManualCacheCleanUiController this$0;

    public ManualCacheCleanUiController$executeAndReportClean$1(ManualCacheCleanUiController r100, Continuation<? super ManualCacheCleanUiController$executeAndReportClean$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ManualCacheCleanUiController.b(this.this$0, 0, null, null, 0, this);
    }
}
