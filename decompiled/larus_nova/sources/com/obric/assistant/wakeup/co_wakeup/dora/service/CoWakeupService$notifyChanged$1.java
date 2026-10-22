package com.obric.assistant.wakeup.co_wakeup.dora.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService", f = "CoWakeupService.kt", i = {0, 0, 0}, l = {151, 152}, m = "notifyChanged", n = {"currentSwitch", "currentConnect", "currentWearState"}, s = {"L$0", "L$1", "L$2"})
final class CoWakeupService$notifyChanged$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoWakeupService this$0;

    public CoWakeupService$notifyChanged$1(CoWakeupService r100, Continuation<? super CoWakeupService$notifyChanged$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return CoWakeupService.h(this.this$0, this);
    }
}
