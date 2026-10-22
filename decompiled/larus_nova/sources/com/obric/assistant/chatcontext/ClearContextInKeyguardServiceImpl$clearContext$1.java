package com.obric.assistant.chatcontext;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chatcontext.ClearContextInKeyguardServiceImpl", f = "ClearContextInKeyguardServiceImpl.kt", i = {}, l = {144}, m = "clearContext", n = {}, s = {})
public final class ClearContextInKeyguardServiceImpl$clearContext$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ClearContextInKeyguardServiceImpl this$0;

    public ClearContextInKeyguardServiceImpl$clearContext$1(ClearContextInKeyguardServiceImpl r100, Continuation<? super ClearContextInKeyguardServiceImpl$clearContext$1> r101) {
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
