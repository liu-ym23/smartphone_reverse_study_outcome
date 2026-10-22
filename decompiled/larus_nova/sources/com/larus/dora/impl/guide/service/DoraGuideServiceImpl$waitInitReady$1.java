package com.larus.dora.impl.guide.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.service.DoraGuideServiceImpl", f = "DoraGuideServiceImpl.kt", i = {}, l = {290}, m = "waitInitReady", n = {}, s = {})
public final class DoraGuideServiceImpl$waitInitReady$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraGuideServiceImpl this$0;

    public DoraGuideServiceImpl$waitInitReady$1(DoraGuideServiceImpl r100, Continuation<? super DoraGuideServiceImpl$waitInitReady$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(0, 0, this);
    }
}
