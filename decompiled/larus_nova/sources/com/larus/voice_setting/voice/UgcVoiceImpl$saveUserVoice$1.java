package com.larus.voice_setting.voice;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.UgcVoiceImpl", f = "UgcVoiceLoader.kt", i = {}, l = {92}, m = "saveUserVoice", n = {}, s = {})
final class UgcVoiceImpl$saveUserVoice$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ v1 this$0;

    public UgcVoiceImpl$saveUserVoice$1(v1 r100, Continuation<? super UgcVoiceImpl$saveUserVoice$1> r101) {
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
