package com.larus.dora.impl.ota.check;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.check.DoraOTACheckRepository", f = "DoraOTACheckRepository.kt", i = {}, l = {30}, m = "checkUpdate-LiYkppA", n = {}, s = {})
public final class DoraOTACheckRepository$checkUpdate$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraOTACheckRepository this$0;

    public DoraOTACheckRepository$checkUpdate$1(DoraOTACheckRepository r100, Continuation<? super DoraOTACheckRepository$checkUpdate$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        Object r111 = this.this$0.b(null, null, null, null, null, null, null, null, false, this);
        if (r111 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r111;
    L6:
        return Result.m9448boximpl(r111);
    }
}
