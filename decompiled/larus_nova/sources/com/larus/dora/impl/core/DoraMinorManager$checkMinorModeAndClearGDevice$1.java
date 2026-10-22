package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraMinorManager", f = "DoraMinorManager.kt", i = {}, l = {47}, m = "checkMinorModeAndClearGDevice", n = {}, s = {})
public final class DoraMinorManager$checkMinorModeAndClearGDevice$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraMinorManager this$0;

    public DoraMinorManager$checkMinorModeAndClearGDevice$1(DoraMinorManager r100, Continuation<? super DoraMinorManager$checkMinorModeAndClearGDevice$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
