package com.larus.suggest.impl.wcb.render;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.suggest.impl.wcb.render.ImSdkWcbRenderer$Transaction", f = "ImSdkWcbRenderer.kt", i = {0}, l = {48}, m = ChameleonOpenTracker.Stage.RENDER, n = {"plan"}, s = {"L$0"})
public final class ImSdkWcbRenderer$Transaction$render$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImSdkWcbRenderer.Transaction this$0;

    public ImSdkWcbRenderer$Transaction$render$1(ImSdkWcbRenderer.Transaction r100, Continuation<? super ImSdkWcbRenderer$Transaction$render$1> r101) {
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
