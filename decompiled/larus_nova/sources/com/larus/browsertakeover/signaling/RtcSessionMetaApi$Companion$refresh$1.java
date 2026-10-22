package com.larus.browsertakeover.signaling;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.browsertakeover.signaling.RtcSessionMetaApi$Companion", f = "RtcSessionMetaApi.kt", i = {0}, l = {26}, m = "refresh", n = {"sessionId"}, s = {"L$0"})
public final class RtcSessionMetaApi$Companion$refresh$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RtcSessionMetaApi.Companion this$0;

    public RtcSessionMetaApi$Companion$refresh$1(RtcSessionMetaApi.Companion r100, Continuation<? super RtcSessionMetaApi$Companion$refresh$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
