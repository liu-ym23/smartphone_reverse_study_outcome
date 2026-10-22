package com.larus.larkfeed.impl.voice.service.record;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.larkfeed.impl.voice.service.record.FlowVoiceRecord", f = "FlowVoiceRecord.kt", i = {0}, l = {255}, m = "performCancel-IoAF18A", n = {"previousState"}, s = {"L$0"})
public final class FlowVoiceRecord$performCancel$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowVoiceRecord this$0;

    public FlowVoiceRecord$performCancel$1(FlowVoiceRecord r100, Continuation<? super FlowVoiceRecord$performCancel$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        FlowVoiceRecord r101 = this.this$0;
        int r102 = FlowVoiceRecord.f355666l;
        Object r103 = r101.g(this);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Result.m9448boximpl(r103);
    }
}
