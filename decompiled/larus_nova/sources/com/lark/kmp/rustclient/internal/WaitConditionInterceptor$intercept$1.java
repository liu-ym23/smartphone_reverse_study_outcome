package com.lark.kmp.rustclient.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.lark.kmp.rustclient.internal.WaitConditionInterceptor", f = "WaitConditionInterceptor.kt", i = {0, 0}, l = {47, 50}, m = "intercept$suspendImpl", n = {"$this", "chain"}, s = {"L$0", "L$1"})
public final class WaitConditionInterceptor$intercept$1<Resp> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WaitConditionInterceptor this$0;

    public WaitConditionInterceptor$intercept$1(WaitConditionInterceptor r100, Continuation<? super WaitConditionInterceptor$intercept$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return WaitConditionInterceptor.d(this.this$0, null, this);
    }
}
