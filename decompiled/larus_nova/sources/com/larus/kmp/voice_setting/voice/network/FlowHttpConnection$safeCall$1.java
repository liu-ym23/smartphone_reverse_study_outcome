package com.larus.kmp.voice_setting.voice.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.kmp.voice_setting.voice.network.FlowHttpConnection", f = "VoiceNetworkModels.kt", i = {}, l = {53}, m = "safeCall", n = {}, s = {})
public final class FlowHttpConnection$safeCall$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowHttpConnection this$0;

    public FlowHttpConnection$safeCall$1(FlowHttpConnection r100, Continuation<? super FlowHttpConnection$safeCall$1> r101) {
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
