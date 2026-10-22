package com.obric.assistant.chat.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.impl.ObricChatSPIServiceImpl", f = "ObricChatSPIServiceImpl.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {69, 78, 81, 82}, m = "ensureContextSafe", n = {"cvsId", "canRetry", "cvsId", "clearContextInKeyguardService", "canRetry", "cvsId", "clearContextInKeyguardService"}, s = {"L$0", "Z$0", "L$0", "L$1", "Z$0", "L$0", "L$1"})
public final class ObricChatSPIServiceImpl$ensureContextSafe$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricChatSPIServiceImpl this$0;

    public ObricChatSPIServiceImpl$ensureContextSafe$1(ObricChatSPIServiceImpl r100, Continuation<? super ObricChatSPIServiceImpl$ensureContextSafe$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.n(null, false, null, this);
    }
}
