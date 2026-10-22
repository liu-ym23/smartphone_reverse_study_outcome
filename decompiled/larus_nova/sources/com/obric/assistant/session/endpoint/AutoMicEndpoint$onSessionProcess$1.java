package com.obric.assistant.session.endpoint;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.session.endpoint.AutoMicEndpoint", f = "AutoMicEndpoint.kt", i = {}, l = {41}, m = "onSessionProcess", n = {}, s = {})
public final class AutoMicEndpoint$onSessionProcess$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AutoMicEndpoint this$0;

    public AutoMicEndpoint$onSessionProcess$1(AutoMicEndpoint r100, Continuation<? super AutoMicEndpoint$onSessionProcess$1> r101) {
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
