package com.obric.assistant.obric_action;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.obric_action.ObricActionServiceImpl", f = "ObricActionServiceImpl.kt", i = {0}, l = {109}, m = "dispatchInternal", n = {"actionSpec"}, s = {"L$0"})
final class ObricActionServiceImpl$dispatchInternal$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricActionServiceImpl this$0;

    public ObricActionServiceImpl$dispatchInternal$1(ObricActionServiceImpl r100, Continuation<? super ObricActionServiceImpl$dispatchInternal$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ObricActionServiceImpl.f(this.this$0, null, null, null, this);
    }
}
