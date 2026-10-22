package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.helper;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.helper.MmSummaryNetReconnectHelper", f = "MmSummaryNetReconnectHelper.kt", i = {}, l = {43}, m = "doFetch", n = {}, s = {})
public final class MmSummaryNetReconnectHelper$doFetch$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmSummaryNetReconnectHelper this$0;

    public MmSummaryNetReconnectHelper$doFetch$1(MmSummaryNetReconnectHelper r100, Continuation<? super MmSummaryNetReconnectHelper$doFetch$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(this);
    }
}
