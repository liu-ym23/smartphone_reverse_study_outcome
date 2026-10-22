package com.ss.android.lark.conditional.access.auth.v2.service;

import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.conditional.access.auth.v2.service.PolicyValidateService", f = "PolicyValidateService.kt", i = {0, 0, 0, 0, 0, 0, 1, 1}, l = {80, 120}, m = "policyValidateWithCoroutine", n = {"policyModelList", "updateInfo", "traceId", "validateParam", "validateUid", DyPayConstant.KEY_START_TIME, "traceId", "resultMap"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1"})
public final class PolicyValidateService$policyValidateWithCoroutine$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PolicyValidateService this$0;

    public PolicyValidateService$policyValidateWithCoroutine$1(PolicyValidateService r100, Continuation<? super PolicyValidateService$policyValidateWithCoroutine$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, null, this);
    }
}
