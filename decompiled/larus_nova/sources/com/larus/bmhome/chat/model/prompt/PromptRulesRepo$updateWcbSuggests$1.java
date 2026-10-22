package com.larus.bmhome.chat.model.prompt;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.model.prompt.PromptRulesRepo", f = "PromptRulesRepo.kt", i = {}, l = {57}, m = "updateWcbSuggests", n = {}, s = {})
public final class PromptRulesRepo$updateWcbSuggests$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PromptRulesRepo this$0;

    public PromptRulesRepo$updateWcbSuggests$1(PromptRulesRepo r100, Continuation<? super PromptRulesRepo$updateWcbSuggests$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, null, this);
    }
}
