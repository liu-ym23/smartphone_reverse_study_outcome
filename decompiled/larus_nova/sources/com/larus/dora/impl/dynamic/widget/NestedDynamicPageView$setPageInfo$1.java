package com.larus.dora.impl.dynamic.widget;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.widget.NestedDynamicPageView", f = "NestedDynamicPageView.kt", i = {}, l = {183}, m = "setPageInfo", n = {}, s = {})
public final class NestedDynamicPageView$setPageInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NestedDynamicPageView this$0;

    public NestedDynamicPageView$setPageInfo$1(NestedDynamicPageView r100, Continuation<? super NestedDynamicPageView$setPageInfo$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, null, this);
    }
}
