package com.larus.dora.impl.bridge;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.bridge.DoraBudsTxSyncMethod", f = "DoraBudsTxSyncMethod.kt", i = {0, 1, 1}, l = {153, 168}, m = "executeVolumeAdaptation", n = {"deviceKey", "deviceKey", "nextState"}, s = {"L$0", "L$0", "I$0"})
public final class DoraBudsTxSyncMethod$executeVolumeAdaptation$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraBudsTxSyncMethod this$0;

    public DoraBudsTxSyncMethod$executeVolumeAdaptation$1(DoraBudsTxSyncMethod r100, Continuation<? super DoraBudsTxSyncMethod$executeVolumeAdaptation$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        DoraBudsTxSyncMethod r101 = this.this$0;
        IntRange r102 = DoraBudsTxSyncMethod.f332052b;
        return r101.c(null, this);
    }
}
