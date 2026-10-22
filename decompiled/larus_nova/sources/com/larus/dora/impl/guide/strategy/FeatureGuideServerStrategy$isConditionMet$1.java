package com.larus.dora.impl.guide.strategy;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.strategy.FeatureGuideServerStrategy", f = "FeatureGuideServerStrategy.kt", i = {}, l = {39}, m = "isConditionMet", n = {}, s = {})
public final class FeatureGuideServerStrategy$isConditionMet$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeatureGuideServerStrategy this$0;

    public FeatureGuideServerStrategy$isConditionMet$1(FeatureGuideServerStrategy r100, Continuation<? super FeatureGuideServerStrategy$isConditionMet$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
