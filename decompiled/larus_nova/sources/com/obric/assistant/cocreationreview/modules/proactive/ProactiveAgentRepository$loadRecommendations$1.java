package com.obric.assistant.cocreationreview.modules.proactive;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.cocreationreview.modules.proactive.ProactiveAgentRepository", f = "ProactiveAgentProvider.kt", i = {1, 1, 1, 1, 2, 2, 2, 2}, l = {480, TTVideoEngineInterface.PLAYER_OPTION_SEGMENT_FORMAT_FLAG, TTVideoEngineInterface.PLAYER_OPTION_PREPARE_CACHE_MS}, m = "loadRecommendations", n = {"snapshot", "request", "todayKey", "recommendations", "snapshot", "request", "todayKey", "recommendations"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
final class ProactiveAgentRepository$loadRecommendations$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProactiveAgentRepository this$0;

    public ProactiveAgentRepository$loadRecommendations$1(ProactiveAgentRepository r100, Continuation<? super ProactiveAgentRepository$loadRecommendations$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ProactiveAgentRepository.a(this.this$0, null, null, null, false, this);
    }
}
