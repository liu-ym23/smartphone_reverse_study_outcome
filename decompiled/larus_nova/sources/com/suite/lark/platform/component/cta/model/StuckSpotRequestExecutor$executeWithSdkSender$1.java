package com.suite.lark.platform.component.cta.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.suite.lark.platform.component.cta.model.StuckSpotRequestExecutor", f = "StuckSpotRequestExecutor.kt", i = {}, l = {70}, m = "executeWithSdkSender", n = {}, s = {})
public final class StuckSpotRequestExecutor$executeWithSdkSender$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StuckSpotRequestExecutor this$0;

    public StuckSpotRequestExecutor$executeWithSdkSender$1(StuckSpotRequestExecutor r100, Continuation<? super StuckSpotRequestExecutor$executeWithSdkSender$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, null, null, this);
    }
}
