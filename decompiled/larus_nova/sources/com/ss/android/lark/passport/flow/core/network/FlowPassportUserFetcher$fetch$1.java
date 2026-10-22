package com.ss.android.lark.passport.flow.core.network;

import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.passport.flow.core.network.FlowPassportUserFetcher", f = "FlowPassportUserFetcher.kt", i = {0, 0, 0}, l = {26}, m = "fetch-gIAlu-s", n = {"httpCode", "logId", DyPayConstant.KEY_START_TIME}, s = {"L$0", "L$1", "J$0"})
final class FlowPassportUserFetcher$fetch$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public FlowPassportUserFetcher$fetch$1(d r100, Continuation<? super FlowPassportUserFetcher$fetch$1> r101) {
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
