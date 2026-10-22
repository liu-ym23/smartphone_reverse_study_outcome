package com.larus.larkfeed.impl.voice.view;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.larkfeed.impl.voice.view.FlowVoiceView", f = "FlowVoiceView.kt", i = {}, l = {176}, m = "observeRecordState", n = {}, s = {})
final class FlowVoiceView$observeRecordState$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowVoiceView this$0;

    public FlowVoiceView$observeRecordState$1(FlowVoiceView r100, Continuation<? super FlowVoiceView$observeRecordState$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return FlowVoiceView.f9(this.this$0, null, this);
    }
}
