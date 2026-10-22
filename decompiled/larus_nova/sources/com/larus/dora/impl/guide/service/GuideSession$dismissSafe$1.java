package com.larus.dora.impl.guide.service;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.service.GuideSession", f = "DoraGuideServiceImpl.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AE_SRC_PEAK}, m = "dismissSafe", n = {}, s = {})
final class GuideSession$dismissSafe$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GuideSession this$0;

    public GuideSession$dismissSafe$1(GuideSession r100, Continuation<? super GuideSession$dismissSafe$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return GuideSession.a(this.this$0, null, this);
    }
}
