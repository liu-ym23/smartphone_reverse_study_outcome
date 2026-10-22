package com.ss.android.lark.chat.api.service.impl;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.api.service.impl.PrivateDescriptionService", f = "PrivateDescriptionService.kt", i = {0, 0}, l = {44}, m = "pullPrivateDescriptions-BWLJW6A", n = {"source", "validUserIds"}, s = {"L$0", "L$1"})
public final class PrivateDescriptionService$pullPrivateDescriptions$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PrivateDescriptionService this$0;

    public PrivateDescriptionService$pullPrivateDescriptions$1(PrivateDescriptionService r100, Continuation<? super PrivateDescriptionService$pullPrivateDescriptions$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = this.this$0.S0(null, null, null, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
