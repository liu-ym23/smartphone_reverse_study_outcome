package com.bytedance.flow_audio.impl.business.asr;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.flow_audio.impl.business.asr.FlowAsrAudioUplinkController", f = "FlowAsrAudioUplinkController.kt", i = {}, l = {97}, m = "flush", n = {}, s = {})
public final class FlowAsrAudioUplinkController$flush$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowAsrAudioUplinkController this$0;

    public FlowAsrAudioUplinkController$flush$1(FlowAsrAudioUplinkController r100, Continuation<? super FlowAsrAudioUplinkController$flush$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(this);
    }
}
