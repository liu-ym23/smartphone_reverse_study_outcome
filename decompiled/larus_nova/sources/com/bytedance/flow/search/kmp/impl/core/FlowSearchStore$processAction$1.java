package com.bytedance.flow.search.kmp.impl.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.flow.search.kmp.impl.core.FlowSearchStore", f = "FlowSearchStore.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {77, 98}, m = "processAction", n = {"action", "actionScopeId", "current", "middlewareName", "updateCount", "version", "action", "actionScopeId", "current", "middlewareName", "updateCount", "version"}, s = {"L$0", "L$1", "L$2", "L$4", "L$5", "J$0", "L$0", "L$1", "L$2", "L$4", "L$5", "J$0"})
final class FlowSearchStore$processAction$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowSearchStore this$0;

    public FlowSearchStore$processAction$1(FlowSearchStore r100, Continuation<? super FlowSearchStore$processAction$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return FlowSearchStore.a(this.this$0, null, 0, this);
    }
}
