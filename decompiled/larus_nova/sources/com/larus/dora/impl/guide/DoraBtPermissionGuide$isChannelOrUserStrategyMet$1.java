package com.larus.dora.impl.guide;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.DoraBtPermissionGuide", f = "DoraBtPermissionGuide.kt", i = {}, l = {160, 168, 175}, m = "isChannelOrUserStrategyMet", n = {}, s = {})
public final class DoraBtPermissionGuide$isChannelOrUserStrategyMet$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraBtPermissionGuide this$0;

    public DoraBtPermissionGuide$isChannelOrUserStrategyMet$1(DoraBtPermissionGuide r100, Continuation<? super DoraBtPermissionGuide$isChannelOrUserStrategyMet$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        DoraBtPermissionGuide r101 = this.this$0;
        int r102 = DoraBtPermissionGuide.f335898k;
        return r101.g(this);
    }
}
