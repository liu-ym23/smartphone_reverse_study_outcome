package com.larus.dora.impl.nl.notification_rule.data;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.nl.notification_rule.data.DoraNotificationRuleRepo", f = "DoraNotificationRuleRepo.kt", i = {}, l = {76}, m = "batchDeleteRules-gIAlu-s", n = {}, s = {})
public final class DoraNotificationRuleRepo$batchDeleteRules$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraNotificationRuleRepo this$0;

    public DoraNotificationRuleRepo$batchDeleteRules$1(DoraNotificationRuleRepo r100, Continuation<? super DoraNotificationRuleRepo$batchDeleteRules$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = this.this$0.a(null, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
