package com.larus.contextwindow.impl.routing;

import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.contextwindow.impl.routing.ContextWindowColdStartResolver", f = "ContextWindowColdStartDataSource.kt", i = {}, l = {24}, m = JSEventListener.ACTION_RESOLVE, n = {}, s = {})
public final class ContextWindowColdStartResolver$resolve$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ContextWindowColdStartResolver this$0;

    public ContextWindowColdStartResolver$resolve$1(ContextWindowColdStartResolver r100, Continuation<? super ContextWindowColdStartResolver$resolve$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
