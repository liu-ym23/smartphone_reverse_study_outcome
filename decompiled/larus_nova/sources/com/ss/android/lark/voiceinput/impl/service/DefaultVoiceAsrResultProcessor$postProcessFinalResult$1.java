package com.ss.android.lark.voiceinput.impl.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.voiceinput.impl.service.DefaultVoiceAsrResultProcessor", f = "DefaultVoiceAsrResultProcessor.kt", i = {0}, l = {31}, m = "postProcessFinalResult", n = {"result"}, s = {"L$0"})
public final class DefaultVoiceAsrResultProcessor$postProcessFinalResult$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultVoiceAsrResultProcessor this$0;

    public DefaultVoiceAsrResultProcessor$postProcessFinalResult$1(DefaultVoiceAsrResultProcessor r100, Continuation<? super DefaultVoiceAsrResultProcessor$postProcessFinalResult$1> r101) {
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
