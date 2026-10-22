package com.larus.commercecredit.impl.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.commercecredit.impl.model.CommerceCreditRepo", f = "CommerceCreditRepo.kt", i = {0, 0}, l = {119}, m = "requestGroupInfo", n = {"campaignKey", "postActionProcessor"}, s = {"L$0", "L$1"})
final class CommerceCreditRepo$requestGroupInfo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ c this$0;

    public CommerceCreditRepo$requestGroupInfo$1(c r100, Continuation<? super CommerceCreditRepo$requestGroupInfo$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(null, null, this);
    }
}
