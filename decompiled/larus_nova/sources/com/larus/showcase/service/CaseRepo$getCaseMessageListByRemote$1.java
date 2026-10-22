package com.larus.showcase.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.showcase.service.CaseRepo", f = "CaseRepo.kt", i = {0, 0}, l = {108}, m = "getCaseMessageListByRemote", n = {"caseId", "isFromRecommend"}, s = {"L$0", "Z$0"})
public final class CaseRepo$getCaseMessageListByRemote$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CaseRepo this$0;

    public CaseRepo$getCaseMessageListByRemote$1(CaseRepo r100, Continuation<? super CaseRepo$getCaseMessageListByRemote$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, false, this);
    }
}
