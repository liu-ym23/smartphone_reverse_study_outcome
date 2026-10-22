package com.larus.dora.impl.ota.g2;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.g2.AndroidG2OtaRuntime", f = "G2OtaRuntime.kt", i = {0, 0, 1, 1}, l = {505, 519}, m = "connect", n = {"effect", "emit", "effect", "emit"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class AndroidG2OtaRuntime$connect$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidG2OtaRuntime this$0;

    public AndroidG2OtaRuntime$connect$1(AndroidG2OtaRuntime r100, Continuation<? super AndroidG2OtaRuntime$connect$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        AndroidG2OtaRuntime r101 = this.this$0;
        String r102 = AndroidG2OtaRuntime.TAG;
        return r101.i(null, null, this);
    }
}
