package com.larus.commercemembership.impl.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.commercemembership.impl.model.CommerceMembershipRepo", f = "CommerceMembershipRepo.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {128, 141}, m = "requestUserEntitlement", n = {"scene", "from", "postActionProcessor", "scene", "from", "result", "entitlement"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
final class CommerceMembershipRepo$requestUserEntitlement$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ c this$0;

    public CommerceMembershipRepo$requestUserEntitlement$1(c r100, Continuation<? super CommerceMembershipRepo$requestUserEntitlement$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, null, this);
    }
}
