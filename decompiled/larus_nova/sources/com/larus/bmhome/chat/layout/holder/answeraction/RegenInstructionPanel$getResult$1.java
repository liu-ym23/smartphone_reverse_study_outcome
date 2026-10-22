package com.larus.bmhome.chat.layout.holder.answeraction;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.answeraction.RegenInstructionPanel", f = "RegenInstructionPanel.kt", i = {}, l = {101}, m = "getResult", n = {}, s = {})
public final class RegenInstructionPanel$getResult$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RegenInstructionPanel this$0;

    public RegenInstructionPanel$getResult$1(RegenInstructionPanel r100, Continuation<? super RegenInstructionPanel$getResult$1> r101) {
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
