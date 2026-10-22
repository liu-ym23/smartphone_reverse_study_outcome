package com.ss.android.lark.voiceinput.impl.service.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.voiceinput.impl.service.repository.VoiceRepository", f = "VoiceRepository.kt", i = {}, l = {27}, m = "handleSpeechRecognitionResult", n = {}, s = {})
public final class VoiceRepository$handleSpeechRecognitionResult$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VoiceRepository this$0;

    public VoiceRepository$handleSpeechRecognitionResult$1(VoiceRepository r100, Continuation<? super VoiceRepository$handleSpeechRecognitionResult$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, this);
    }
}
