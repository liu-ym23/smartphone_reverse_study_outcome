package com.larus.avlink;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.DoraWakeupResponseManager", f = "DoraWakeupResponseManager.kt", i = {}, l = {307}, m = "runCancelTimeout", n = {}, s = {})
final class DoraWakeupResponseManager$runCancelTimeout$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraWakeupResponseManager this$0;

    public DoraWakeupResponseManager$runCancelTimeout$1(DoraWakeupResponseManager r100, Continuation<? super DoraWakeupResponseManager$runCancelTimeout$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return DoraWakeupResponseManager.a(this.this$0, this);
    }
}
