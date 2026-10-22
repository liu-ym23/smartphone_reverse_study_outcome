package com.larus.dora.o.impl.memory;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.o.impl.memory.OMemoryRepo", f = "OMemoryRepo.kt", i = {}, l = {72}, m = "addProfile", n = {}, s = {})
public final class OMemoryRepo$addProfile$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OMemoryRepo this$0;

    public OMemoryRepo$addProfile$1(OMemoryRepo r100, Continuation<? super OMemoryRepo$addProfile$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, 0, null, this);
    }
}
