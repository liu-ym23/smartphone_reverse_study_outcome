package com.larus.voicecall.impl.component.denoise;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.denoise.DenoiseNetUtil", f = "DenoiseNetUtil.kt", i = {}, l = {22}, m = "reportDenoiseStatus", n = {}, s = {})
public final class DenoiseNetUtil$reportDenoiseStatus$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DenoiseNetUtil this$0;

    public DenoiseNetUtil$reportDenoiseStatus$1(DenoiseNetUtil r100, Continuation<? super DenoiseNetUtil$reportDenoiseStatus$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
