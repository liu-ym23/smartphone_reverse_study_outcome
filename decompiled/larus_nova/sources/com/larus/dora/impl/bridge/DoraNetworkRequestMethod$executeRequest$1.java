package com.larus.dora.impl.bridge;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.bridge.DoraNetworkRequestMethod", f = "DoraNetworkRequestMethod.kt", i = {}, l = {109, 127}, m = "executeRequest", n = {}, s = {})
final class DoraNetworkRequestMethod$executeRequest$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ r this$0;

    public DoraNetworkRequestMethod$executeRequest$1(r r100, Continuation<? super DoraNetworkRequestMethod$executeRequest$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return r.a(this.this$0, null, null, null, null, false, null, this);
    }
}
