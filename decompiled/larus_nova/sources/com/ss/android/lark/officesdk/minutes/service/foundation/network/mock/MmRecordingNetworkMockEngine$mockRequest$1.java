package com.ss.android.lark.officesdk.minutes.service.foundation.network.mock;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmRecordingNetworkMockEngine", f = "MmRecordingNetworkMockEngine.kt", i = {0, 0, 0}, l = {130}, m = "mockRequest", n = {PerfLog.PARAM_KEY_CONTEXT_ID, "respType", "scenario"}, s = {"L$0", "L$1", "L$2"})
final class MmRecordingNetworkMockEngine$mockRequest$1<R> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ g this$0;

    public MmRecordingNetworkMockEngine$mockRequest$1(g r100, Continuation<? super MmRecordingNetworkMockEngine$mockRequest$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        g r101 = this.this$0;
        g.a r102 = g.f433953h;
        return r101.b(null, this);
    }
}
