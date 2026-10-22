package com.larus.dora.impl.ota.g2;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.g2.DoraG2OtaTransport", f = "G2OtaRuntime.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {902, 904}, m = "connect", n = {"key", "ownerId", "mode", "linkOwner", "operationId", "key", "ownerId", "mode", "linkOwner", "operationId"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0"})
final class DoraG2OtaTransport$connect$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ i this$0;

    public DoraG2OtaTransport$connect$1(i r100, Continuation<? super DoraG2OtaTransport$connect$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, 0, null, null, this);
    }
}
