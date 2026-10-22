package com.larus.voice_setting.voice;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.UgcVoiceLoader", f = "UgcVoiceLoader.kt", i = {}, l = {982}, m = "queryBestMatchVoiceList", n = {}, s = {})
final class UgcVoiceLoader$queryBestMatchVoiceList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UgcVoiceLoader this$0;

    public UgcVoiceLoader$queryBestMatchVoiceList$1(UgcVoiceLoader r100, Continuation<? super UgcVoiceLoader$queryBestMatchVoiceList$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return UgcVoiceLoader.c(this.this$0, null, 0, this);
    }
}
