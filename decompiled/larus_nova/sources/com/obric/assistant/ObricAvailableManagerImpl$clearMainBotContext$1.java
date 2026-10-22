package com.obric.assistant;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.ObricAvailableManagerImpl", f = "ObricAvailableManagerImpl.kt", i = {}, l = {165, 169}, m = "clearMainBotContext", n = {}, s = {})
final class ObricAvailableManagerImpl$clearMainBotContext$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricAvailableManagerImpl this$0;

    public ObricAvailableManagerImpl$clearMainBotContext$1(ObricAvailableManagerImpl r100, Continuation<? super ObricAvailableManagerImpl$clearMainBotContext$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ObricAvailableManagerImpl.c(this.this$0, this);
    }
}
