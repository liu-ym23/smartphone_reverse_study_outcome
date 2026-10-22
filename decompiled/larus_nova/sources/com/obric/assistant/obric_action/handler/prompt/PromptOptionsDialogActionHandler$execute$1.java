package com.obric.assistant.obric_action.handler.prompt;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.obric_action.handler.prompt.PromptOptionsDialogActionHandler", f = "PromptDialogActionHandlers.kt", i = {}, l = {217}, m = "execute", n = {}, s = {})
final class PromptOptionsDialogActionHandler$execute$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PromptOptionsDialogActionHandler this$0;

    public PromptOptionsDialogActionHandler$execute$1(PromptOptionsDialogActionHandler r100, Continuation<? super PromptOptionsDialogActionHandler$execute$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, this);
    }
}
