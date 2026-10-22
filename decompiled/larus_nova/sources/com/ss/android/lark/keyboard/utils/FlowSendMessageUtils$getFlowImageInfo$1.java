package com.ss.android.lark.keyboard.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.keyboard.utils.FlowSendMessageUtils", f = "FlowSendMessageUtils.kt", i = {0}, l = {154}, m = "getFlowImageInfo", n = {"filePath"}, s = {"L$0"})
public final class FlowSendMessageUtils$getFlowImageInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowSendMessageUtils this$0;

    public FlowSendMessageUtils$getFlowImageInfo$1(FlowSendMessageUtils r100, Continuation<? super FlowSendMessageUtils$getFlowImageInfo$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        FlowSendMessageUtils r101 = this.this$0;
        FlowSendMessageUtils r102 = FlowSendMessageUtils.f430952a;
        return r101.a(null, this);
    }
}
