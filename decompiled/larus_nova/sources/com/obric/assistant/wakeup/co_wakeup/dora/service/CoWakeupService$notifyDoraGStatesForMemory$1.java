package com.obric.assistant.wakeup.co_wakeup.dora.service;

import com.ss.ttm.player.MediaPlayer;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService", f = "CoWakeupService.kt", i = {0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIEW_WIDTH}, m = "notifyDoraGStatesForMemory", n = {"connect", "wear", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2"})
public final class CoWakeupService$notifyDoraGStatesForMemory$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoWakeupService this$0;

    public CoWakeupService$notifyDoraGStatesForMemory$1(CoWakeupService r100, Continuation<? super CoWakeupService$notifyDoraGStatesForMemory$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        CoWakeupService r101 = this.this$0;
        Set<String> r102 = CoWakeupService.f394450r;
        return r101.m(null, null, this);
    }
}
