package com.larus.kmp.voice_setting.voice.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.kmp.voice_setting.voice.service.UgcVoiceImpl", f = "UgcVoiceServiceImpl.kt", i = {}, l = {30}, m = "saveUserVoice", n = {}, s = {})
public final class UgcVoiceImpl$saveUserVoice$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UgcVoiceImpl this$0;

    public UgcVoiceImpl$saveUserVoice$1(UgcVoiceImpl r100, Continuation<? super UgcVoiceImpl$saveUserVoice$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.y2(null, null, null, null, this);
    }
}
