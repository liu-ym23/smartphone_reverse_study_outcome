package com.larus.dora.impl.guide;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.DoraBaseGuide", f = "DoraBaseGuide.kt", i = {0, 1, 1, 2, 2, 2, 2}, l = {88, 99, 116}, m = "isGuideConditionMet$suspendImpl", n = {"$this", "$this", "localOk", "$this", "params", "kevaState", "localOk"}, s = {"L$0", "L$0", "Z$0", "L$0", "L$1", "L$2", "Z$0"})
public final class DoraBaseGuide$isGuideConditionMet$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraBaseGuide this$0;

    public DoraBaseGuide$isGuideConditionMet$1(DoraBaseGuide r100, Continuation<? super DoraBaseGuide$isGuideConditionMet$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return DoraBaseGuide.n(this.this$0, this);
    }
}
