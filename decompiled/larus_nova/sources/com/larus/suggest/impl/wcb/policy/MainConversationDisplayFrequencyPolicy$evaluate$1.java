package com.larus.suggest.impl.wcb.policy;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.suggest.impl.wcb.policy.MainConversationDisplayFrequencyPolicy", f = "WcbDisplayFrequencyPolicy.kt", i = {0, 0, 1, 1, 1}, l = {54, 142}, m = "evaluate", n = {"snapshot", PerfLog.PARAM_KEY_CONTEXT_ID, PerfLog.PARAM_KEY_CONTEXT_ID, "request", "controlInterval"}, s = {"L$0", "L$1", "L$0", "L$1", "J$0"})
public final class MainConversationDisplayFrequencyPolicy$evaluate$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MainConversationDisplayFrequencyPolicy this$0;

    public MainConversationDisplayFrequencyPolicy$evaluate$1(MainConversationDisplayFrequencyPolicy r100, Continuation<? super MainConversationDisplayFrequencyPolicy$evaluate$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
