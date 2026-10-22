package com.larus.suggest.impl.repo;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.suggest.impl.repo.NexPulseRepo", f = "NexPulseRepo.kt", i = {}, l = {40}, m = "getNexPulse", n = {}, s = {})
final class NexPulseRepo$getNexPulse$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public NexPulseRepo$getNexPulse$1(a r100, Continuation<? super NexPulseRepo$getNexPulse$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, 0, null, null, null, false, this);
    }
}
