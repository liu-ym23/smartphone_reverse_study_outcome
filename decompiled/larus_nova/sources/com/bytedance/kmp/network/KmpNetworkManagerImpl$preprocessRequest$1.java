package com.bytedance.kmp.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.KmpNetworkManagerImpl", f = "KmpNetworkManagerImpl.kt", i = {0, 1}, l = {305, 330}, m = "preprocessRequest", n = {"request", "processedRequestBuilder"}, s = {"L$0", "L$0"})
public final class KmpNetworkManagerImpl$preprocessRequest$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KmpNetworkManagerImpl this$0;

    public KmpNetworkManagerImpl$preprocessRequest$1(KmpNetworkManagerImpl r100, Continuation<? super KmpNetworkManagerImpl$preprocessRequest$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
