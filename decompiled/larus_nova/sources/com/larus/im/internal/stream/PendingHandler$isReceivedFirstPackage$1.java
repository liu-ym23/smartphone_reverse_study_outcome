package com.larus.im.internal.stream;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.stream.PendingHandler", f = "PendingHandler.kt", i = {}, l = {218}, m = "isReceivedFirstPackage", n = {}, s = {})
public final class PendingHandler$isReceivedFirstPackage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PendingHandler this$0;

    public PendingHandler$isReceivedFirstPackage$1(PendingHandler r100, Continuation<? super PendingHandler$isReceivedFirstPackage$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        PendingHandler r101 = this.this$0;
        PendingHandler r102 = PendingHandler.f350084a;
        return r101.e(null, null, this);
    }
}
