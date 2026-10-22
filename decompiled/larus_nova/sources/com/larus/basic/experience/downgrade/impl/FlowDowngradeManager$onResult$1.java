package com.larus.basic.experience.downgrade.impl;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.basic.experience.downgrade.impl.FlowDowngradeManager", f = "FlowDowngradeManager.kt", i = {0, 0}, l = {273}, m = "onResult", n = {"result", PerfLog.PARAM_KEY_CONTEXT_ID}, s = {"L$0", "L$1"})
public final class FlowDowngradeManager$onResult$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowDowngradeManager this$0;

    public FlowDowngradeManager$onResult$1(FlowDowngradeManager r100, Continuation<? super FlowDowngradeManager$onResult$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        FlowDowngradeManager r101 = this.this$0;
        FlowDowngradeManager r102 = FlowDowngradeManager.f294834a;
        return r101.e(null, null, this);
    }
}
