package com.larus.avlink.aiproactive.repo;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.aiproactive.repo.AiProactiveTaskRepository", f = "AiProactiveTaskRepository.kt", i = {}, l = {100, 102}, m = "parseUserAonTaskDraft-gIAlu-s", n = {}, s = {})
public final class AiProactiveTaskRepository$parseUserAonTaskDraft$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AiProactiveTaskRepository this$0;

    public AiProactiveTaskRepository$parseUserAonTaskDraft$1(AiProactiveTaskRepository r100, Continuation<? super AiProactiveTaskRepository$parseUserAonTaskDraft$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = this.this$0.g(null, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
