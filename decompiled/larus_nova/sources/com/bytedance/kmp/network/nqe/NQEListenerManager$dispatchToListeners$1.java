package com.bytedance.kmp.network.nqe;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.nqe.NQEListenerManager", f = "NQEListenerManager.kt", i = {0, 0}, l = {185}, m = "dispatchToListeners", n = {"action", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
final class NQEListenerManager$dispatchToListeners$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NQEListenerManager this$0;

    public NQEListenerManager$dispatchToListeners$1(NQEListenerManager r100, Continuation<? super NQEListenerManager$dispatchToListeners$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return NQEListenerManager.b(this.this$0, null, this);
    }
}
