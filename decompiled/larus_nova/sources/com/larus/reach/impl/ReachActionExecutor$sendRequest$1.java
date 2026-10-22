package com.larus.reach.impl;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.reach.impl.ReachActionExecutor", f = "ReachActionExecutor.kt", i = {0, 0, 0}, l = {84, 98}, m = "sendRequest", n = {PerfLog.PARAM_KEY_CONTEXT_ID, "request", "click"}, s = {"L$0", "L$1", "L$2"})
final class ReachActionExecutor$sendRequest$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public ReachActionExecutor$sendRequest$1(a r100, Continuation<? super ReachActionExecutor$sendRequest$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return a.a(this.this$0, null, null, null, null, this);
    }
}
