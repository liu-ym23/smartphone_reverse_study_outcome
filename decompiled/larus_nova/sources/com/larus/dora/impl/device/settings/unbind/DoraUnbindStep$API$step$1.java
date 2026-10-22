package com.larus.dora.impl.device.settings.unbind;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.unbind.DoraUnbindStep$API", f = "DoraUnbindViewModel.kt", i = {}, l = {54}, m = "step", n = {}, s = {})
public final class DoraUnbindStep$API$step$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraUnbindStep.API this$0;

    public DoraUnbindStep$API$step$1(DoraUnbindStep.API r100, Continuation<? super DoraUnbindStep$API$step$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.step(null, this);
    }
}
