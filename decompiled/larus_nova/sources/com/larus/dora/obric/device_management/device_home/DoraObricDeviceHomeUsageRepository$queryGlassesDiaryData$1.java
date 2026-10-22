package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeUsageRepository", f = "DoraObricDeviceHomeUsageRepository.kt", i = {}, l = {66}, m = "queryGlassesDiaryData-0E7RQCE", n = {}, s = {})
public final class DoraObricDeviceHomeUsageRepository$queryGlassesDiaryData$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraObricDeviceHomeUsageRepository this$0;

    public DoraObricDeviceHomeUsageRepository$queryGlassesDiaryData$1(DoraObricDeviceHomeUsageRepository r100, Continuation<? super DoraObricDeviceHomeUsageRepository$queryGlassesDiaryData$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = this.this$0.c(null, false, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
