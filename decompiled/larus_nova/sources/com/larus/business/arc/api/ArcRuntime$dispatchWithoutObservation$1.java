package com.larus.business.arc.api;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.arc.api.ArcRuntime", f = "ArcRuntime.kt", i = {0, 0}, l = {108}, m = "dispatchWithoutObservation", n = {"argvJson", PerfLog.PARAM_KEY_CONTEXT_ID}, s = {"L$0", "L$1"})
final class ArcRuntime$dispatchWithoutObservation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ u this$0;

    public ArcRuntime$dispatchWithoutObservation$1(u r100, Continuation<? super ArcRuntime$dispatchWithoutObservation$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        u r101 = this.this$0;
        u r102 = u.f319924a;
        return r101.b(null, this);
    }
}
