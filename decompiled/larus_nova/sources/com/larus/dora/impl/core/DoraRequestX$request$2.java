package com.larus.dora.impl.core;

import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraRequestX", f = "DoraRequestX.kt", i = {0, 0, 0}, l = {154}, m = "request", n = {"requestEvent", "requestId", DyPayConstant.KEY_START_TIME}, s = {"L$0", "I$0", "J$0"})
final class DoraRequestX$request$2 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ s0 this$0;

    public DoraRequestX$request$2(s0 r100, Continuation<? super DoraRequestX$request$2> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, 0, this);
    }
}
