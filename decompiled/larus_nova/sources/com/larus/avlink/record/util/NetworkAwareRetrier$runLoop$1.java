package com.larus.avlink.record.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.record.util.NetworkAwareRetrier", f = "NetworkAwareRetrier.kt", i = {0, 0, 1, 1, 1}, l = {157, 180}, m = "runLoop", n = {"$this$runLoop", "index", "$this$runLoop", "index", "delayMs"}, s = {"L$0", "I$0", "L$0", "I$0", "J$0"})
final class NetworkAwareRetrier$runLoop$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkAwareRetrier this$0;

    public NetworkAwareRetrier$runLoop$1(NetworkAwareRetrier r100, Continuation<? super NetworkAwareRetrier$runLoop$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return NetworkAwareRetrier.a(this.this$0, null, this);
    }
}
