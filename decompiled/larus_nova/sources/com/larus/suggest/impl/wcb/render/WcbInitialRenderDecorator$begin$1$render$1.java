package com.larus.suggest.impl.wcb.render;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.suggest.impl.wcb.render.WcbInitialRenderDecorator$begin$1", f = "WcbInitialRenderDecorator.kt", i = {}, l = {18}, m = ChameleonOpenTracker.Stage.RENDER, n = {}, s = {})
public final class WcbInitialRenderDecorator$begin$1$render$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WcbInitialRenderDecorator$begin$1 this$0;

    public WcbInitialRenderDecorator$begin$1$render$1(WcbInitialRenderDecorator$begin$1 r100, Continuation<? super WcbInitialRenderDecorator$begin$1$render$1> r101) {
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
