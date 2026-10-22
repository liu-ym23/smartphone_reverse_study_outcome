package com.obric.aiagent.product.platform.impl.pocketmode;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.product.platform.impl.pocketmode.CommonPocketModeDetector", f = "CommonPocketModeDetector.kt", i = {}, l = {189}, m = "awaitCheckPassed$suspendImpl", n = {}, s = {})
public final class CommonPocketModeDetector$awaitCheckPassed$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommonPocketModeDetector this$0;

    public CommonPocketModeDetector$awaitCheckPassed$1(CommonPocketModeDetector r100, Continuation<? super CommonPocketModeDetector$awaitCheckPassed$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return CommonPocketModeDetector.a(this.this$0, this);
    }
}
