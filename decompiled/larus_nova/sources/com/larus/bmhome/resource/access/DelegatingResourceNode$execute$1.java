package com.larus.bmhome.resource.access;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.resource.access.DelegatingResourceNode", f = "ResourceAccessPipeline.kt", i = {0, 0}, l = {229}, m = "execute$suspendImpl", n = {"$this", "handler"}, s = {"L$0", "L$1"})
public final class DelegatingResourceNode$execute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DelegatingResourceNode this$0;

    public DelegatingResourceNode$execute$1(DelegatingResourceNode r100, Continuation<? super DelegatingResourceNode$execute$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return DelegatingResourceNode.a(this.this$0, null, this);
    }
}
