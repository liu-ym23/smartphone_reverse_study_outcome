package com.obric.assistant.special_input.instruction;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.instruction.PanelInstructionLoader", f = "PanelInstructionLoader.kt", i = {0}, l = {73}, m = "getRefreshedPanelItems", n = {"config"}, s = {"L$0"})
public final class PanelInstructionLoader$getRefreshedPanelItems$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PanelInstructionLoader this$0;

    public PanelInstructionLoader$getRefreshedPanelItems$1(PanelInstructionLoader r100, Continuation<? super PanelInstructionLoader$getRefreshedPanelItems$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(this);
    }
}
