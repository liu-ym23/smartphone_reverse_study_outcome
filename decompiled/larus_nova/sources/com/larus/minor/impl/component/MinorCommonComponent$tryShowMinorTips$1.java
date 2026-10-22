package com.larus.minor.impl.component;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.minor.impl.component.MinorCommonComponent", f = "MinorCommonComponent.kt", i = {}, l = {125}, m = "tryShowMinorTips", n = {}, s = {})
final class MinorCommonComponent$tryShowMinorTips$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MinorCommonComponent this$0;

    public MinorCommonComponent$tryShowMinorTips$1(MinorCommonComponent r100, Continuation<? super MinorCommonComponent$tryShowMinorTips$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MinorCommonComponent.L2(this.this$0, this);
    }
}
