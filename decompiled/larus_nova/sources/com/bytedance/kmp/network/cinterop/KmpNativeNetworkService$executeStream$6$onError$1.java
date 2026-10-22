package com.bytedance.kmp.network.cinterop;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.cinterop.KmpNativeNetworkService$executeStream$6", f = "KmpNativeNetworkService.kt", i = {1, 2}, l = {213, 349, 349}, m = LynxVideoManagerLite.EVENT_ON_ERROR, n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
final class KmpNativeNetworkService$executeStream$6$onError$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ e this$0;

    public KmpNativeNetworkService$executeStream$6$onError$1(e r100, Continuation<? super KmpNativeNetworkService$executeStream$6$onError$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
