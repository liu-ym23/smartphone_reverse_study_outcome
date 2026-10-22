package com.larus.suggest.impl.wcb.request;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.suggest.impl.wcb.request.WcbNetworkRequester", f = "WcbNetworkRequester.kt", i = {0}, l = {80}, m = "fetch", n = {"snapshot"}, s = {"L$0"})
final class WcbNetworkRequester$fetch$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b this$0;

    public WcbNetworkRequester$fetch$1(b r100, Continuation<? super WcbNetworkRequester$fetch$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return b.a(this.this$0, null, 0, this);
    }
}
