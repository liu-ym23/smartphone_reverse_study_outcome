package com.bytedance.flow_audio.impl.business.tts;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.flow_audio.impl.business.tts.FlowAudioAsyncWaitGroup", f = "FlowAudioAsyncWaitGroup.kt", i = {0, 0}, l = {21}, m = "wait", n = {PickerReporterConstants.KEY.TARGET, "sum"}, s = {"I$0", "I$1"})
public final class FlowAudioAsyncWaitGroup$wait$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowAudioAsyncWaitGroup this$0;

    public FlowAudioAsyncWaitGroup$wait$1(FlowAudioAsyncWaitGroup r100, Continuation<? super FlowAudioAsyncWaitGroup$wait$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
