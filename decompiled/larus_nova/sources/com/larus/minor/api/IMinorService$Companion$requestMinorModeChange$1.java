package com.larus.minor.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.minor.api.IMinorService$Companion", f = "IMinorService.kt", i = {}, l = {73}, m = "requestMinorModeChange", n = {}, s = {})
final class IMinorService$Companion$requestMinorModeChange$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IMinorService.Companion this$0;

    public IMinorService$Companion$requestMinorModeChange$1(IMinorService.Companion r100, Continuation<? super IMinorService$Companion$requestMinorModeChange$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.n(this);
    }
}
