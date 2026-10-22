package com.larus.avlink.e.model.session_memory;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.e.model.session_memory.SessionMemoryMode", f = "SessionMemoryMode.kt", i = {0}, l = {112}, m = "reportSessionMemory", n = {"request"}, s = {"L$0"})
final class SessionMemoryMode$reportSessionMemory$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SessionMemoryMode this$0;

    public SessionMemoryMode$reportSessionMemory$1(SessionMemoryMode r100, Continuation<? super SessionMemoryMode$reportSessionMemory$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return SessionMemoryMode.a(this.this$0, this);
    }
}
