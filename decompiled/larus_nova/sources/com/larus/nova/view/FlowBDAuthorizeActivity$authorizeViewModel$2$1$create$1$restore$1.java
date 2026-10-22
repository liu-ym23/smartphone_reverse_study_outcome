package com.larus.nova.view;

import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.nova.view.FlowBDAuthorizeActivity$authorizeViewModel$2$1$create$1", f = "FlowBDAuthorizeActivity.kt", i = {}, l = {127, 130}, m = SVGRenderEngine.RESTORE, n = {}, s = {})
final class FlowBDAuthorizeActivity$authorizeViewModel$2$1$create$1$restore$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowBDAuthorizeActivity$authorizeViewModel$2$1.a this$0;

    public FlowBDAuthorizeActivity$authorizeViewModel$2$1$create$1$restore$1(FlowBDAuthorizeActivity$authorizeViewModel$2$1.a r100, Continuation<? super FlowBDAuthorizeActivity$authorizeViewModel$2$1$create$1$restore$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(this);
    }
}
