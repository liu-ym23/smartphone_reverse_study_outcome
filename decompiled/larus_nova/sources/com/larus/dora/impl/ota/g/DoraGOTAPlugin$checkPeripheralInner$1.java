package com.larus.dora.impl.ota.g;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.g.DoraGOTAPlugin", f = "DoraGOTAPlugin.kt", i = {}, l = {64}, m = "checkPeripheralInner-jLovISM", n = {}, s = {})
final class DoraGOTAPlugin$checkPeripheralInner$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraGOTAPlugin this$0;

    public DoraGOTAPlugin$checkPeripheralInner$1(DoraGOTAPlugin r100, Continuation<? super DoraGOTAPlugin$checkPeripheralInner$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        DoraGOTAPlugin r100 = this.this$0;
        int r111 = DoraGOTAPlugin.f337516c;
        Object r101 = r100.f(null, 0, null, null, 0, 0, null, null, 0, null, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
