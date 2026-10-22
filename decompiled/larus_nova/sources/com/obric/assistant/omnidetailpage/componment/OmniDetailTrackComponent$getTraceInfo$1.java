package com.obric.assistant.omnidetailpage.componment;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.componment.OmniDetailTrackComponent", f = "OmniDetailTrackComponent.kt", i = {1, 1, 1, 1}, l = {93, 103}, m = "getTraceInfo", n = {"message", "instructionId", "referenceMessageId", "type"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class OmniDetailTrackComponent$getTraceInfo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OmniDetailTrackComponent this$0;

    public OmniDetailTrackComponent$getTraceInfo$1(OmniDetailTrackComponent r100, Continuation<? super OmniDetailTrackComponent$getTraceInfo$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return OmniDetailTrackComponent.F2(this.this$0, this);
    }
}
