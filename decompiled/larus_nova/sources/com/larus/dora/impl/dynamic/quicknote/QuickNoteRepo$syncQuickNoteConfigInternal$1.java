package com.larus.dora.impl.dynamic.quicknote;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.quicknote.QuickNoteRepo", f = "QuickNoteRepo.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4}, l = {190, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 199, 202, 207}, m = "syncQuickNoteConfigInternal", n = {"config", "onSuccess", "onFail", "onFinally", "device", "syncGestureSettings", "config", "onSuccess", "onFinally", "device", "syncGestureSettings", "config", "onSuccess", "onFinally", "device", "syncGestureSettings", "config", "onSuccess", "onFinally", "device", "syncGestureSettings", "onSuccess", "onFinally"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1"})
public final class QuickNoteRepo$syncQuickNoteConfigInternal$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QuickNoteRepo this$0;

    public QuickNoteRepo$syncQuickNoteConfigInternal$1(QuickNoteRepo r100, Continuation<? super QuickNoteRepo$syncQuickNoteConfigInternal$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        QuickNoteRepo r101 = this.this$0;
        QuickNoteRepo r102 = QuickNoteRepo.f335241a;
        return r101.m(null, false, null, null, null, this);
    }
}
