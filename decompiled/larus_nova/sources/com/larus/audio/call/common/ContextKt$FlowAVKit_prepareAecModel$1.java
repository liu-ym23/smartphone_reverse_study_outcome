package com.larus.audio.call.common;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.audio.call.common.ContextKt", f = "Context.kt", i = {}, l = {29}, m = "FlowAVKit_prepareAecModel", n = {}, s = {})
public final class ContextKt$FlowAVKit_prepareAecModel$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public ContextKt$FlowAVKit_prepareAecModel$1(Continuation<? super ContextKt$FlowAVKit_prepareAecModel$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ContextKt.a(null, this);
    }
}
