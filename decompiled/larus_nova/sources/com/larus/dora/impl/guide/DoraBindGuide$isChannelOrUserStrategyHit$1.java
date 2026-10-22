package com.larus.dora.impl.guide;

import com.ss.ttvideoengine.model.VideoRef;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.DoraBindGuide", f = "DoraBindGuide.kt", i = {}, l = {221, 229, VideoRef.VALUE_VIDEO_REF_CONST_DEPTH}, m = "isChannelOrUserStrategyHit", n = {}, s = {})
public final class DoraBindGuide$isChannelOrUserStrategyHit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraBindGuide this$0;

    public DoraBindGuide$isChannelOrUserStrategyHit$1(DoraBindGuide r100, Continuation<? super DoraBindGuide$isChannelOrUserStrategyHit$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        DoraBindGuide r101 = this.this$0;
        int r102 = DoraBindGuide.f335873p;
        return r101.k(this);
    }
}
