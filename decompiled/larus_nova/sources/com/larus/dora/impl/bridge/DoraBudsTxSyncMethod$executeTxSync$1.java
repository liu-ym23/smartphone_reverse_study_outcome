package com.larus.dora.impl.bridge;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.bridge.DoraBudsTxSyncMethod", f = "DoraBudsTxSyncMethod.kt", i = {}, l = {116}, m = "executeTxSync", n = {}, s = {})
final class DoraBudsTxSyncMethod$executeTxSync$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraBudsTxSyncMethod this$0;

    public DoraBudsTxSyncMethod$executeTxSync$1(DoraBudsTxSyncMethod r100, Continuation<? super DoraBudsTxSyncMethod$executeTxSync$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return DoraBudsTxSyncMethod.a(this.this$0, 0, 0, 0, null, this);
    }
}
