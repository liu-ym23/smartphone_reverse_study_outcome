package com.obric.assistant.session.endpoint;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.session.endpoint.LostModeEndpoint", f = "LostModeEndpoint.kt", i = {0}, l = {23}, m = "onSessionProcess", n = {"args"}, s = {"L$0"})
public final class LostModeEndpoint$onSessionProcess$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LostModeEndpoint this$0;

    public LostModeEndpoint$onSessionProcess$1(LostModeEndpoint r100, Continuation<? super LostModeEndpoint$onSessionProcess$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, this);
    }
}
