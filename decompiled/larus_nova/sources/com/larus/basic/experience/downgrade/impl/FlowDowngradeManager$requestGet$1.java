package com.larus.basic.experience.downgrade.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.basic.experience.downgrade.impl.FlowDowngradeManager", f = "FlowDowngradeManager.kt", i = {1}, l = {199, 200}, m = "requestGet", n = {"result"}, s = {"L$0"})
public final class FlowDowngradeManager$requestGet$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowDowngradeManager this$0;

    public FlowDowngradeManager$requestGet$1(FlowDowngradeManager r100, Continuation<? super FlowDowngradeManager$requestGet$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, null, null, null, null, false, null, null, null, this);
    }
}
