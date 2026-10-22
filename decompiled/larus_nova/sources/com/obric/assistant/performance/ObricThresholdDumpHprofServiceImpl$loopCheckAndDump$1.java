package com.obric.assistant.performance;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.performance.ObricThresholdDumpHprofServiceImpl", f = "ObricThresholdDumpHprofServiceImpl.kt", i = {0, 0}, l = {59}, m = "loopCheckAndDump", n = {"intervalMs", "threshold"}, s = {"J$0", "I$0"})
final class ObricThresholdDumpHprofServiceImpl$loopCheckAndDump$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricThresholdDumpHprofServiceImpl this$0;

    public ObricThresholdDumpHprofServiceImpl$loopCheckAndDump$1(ObricThresholdDumpHprofServiceImpl r100, Continuation<? super ObricThresholdDumpHprofServiceImpl$loopCheckAndDump$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ObricThresholdDumpHprofServiceImpl.a(this.this$0, null, this);
    }
}
