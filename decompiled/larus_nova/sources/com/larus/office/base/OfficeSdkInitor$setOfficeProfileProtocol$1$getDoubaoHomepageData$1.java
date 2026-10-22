package com.larus.office.base;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.base.OfficeSdkInitor$setOfficeProfileProtocol$1", f = "OfficeSdkInitor.kt", i = {}, l = {1432}, m = "getDoubaoHomepageData", n = {}, s = {})
public final class OfficeSdkInitor$setOfficeProfileProtocol$1$getDoubaoHomepageData$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfficeSdkInitor$setOfficeProfileProtocol$1 this$0;

    public OfficeSdkInitor$setOfficeProfileProtocol$1$getDoubaoHomepageData$1(OfficeSdkInitor$setOfficeProfileProtocol$1 r100, Continuation<? super OfficeSdkInitor$setOfficeProfileProtocol$1$getDoubaoHomepageData$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.C(null, this);
    }
}
