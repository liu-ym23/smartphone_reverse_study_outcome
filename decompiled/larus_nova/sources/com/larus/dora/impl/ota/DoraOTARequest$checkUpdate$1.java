package com.larus.dora.impl.ota;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.DoraOTARequest", f = "DoraOTARequest.kt", i = {}, l = {57}, m = "checkUpdate-tZkwj4A", n = {}, s = {})
public final class DoraOTARequest$checkUpdate$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraOTARequest this$0;

    public DoraOTARequest$checkUpdate$1(DoraOTARequest r100, Continuation<? super DoraOTARequest$checkUpdate$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        Object r111 = this.this$0.a(null, null, null, null, null, null, null, null, this);
        if (r111 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r111;
    L6:
        return Result.m9448boximpl(r111);
    }
}
