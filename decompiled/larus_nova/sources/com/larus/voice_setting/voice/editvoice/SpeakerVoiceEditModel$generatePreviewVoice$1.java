package com.larus.voice_setting.voice.editvoice;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.editvoice.SpeakerVoiceEditModel", f = "SpeakerVoiceEditModel.kt", i = {}, l = {784}, m = "generatePreviewVoice", n = {}, s = {})
final class SpeakerVoiceEditModel$generatePreviewVoice$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SpeakerVoiceEditModel this$0;

    public SpeakerVoiceEditModel$generatePreviewVoice$1(SpeakerVoiceEditModel r100, Continuation<? super SpeakerVoiceEditModel$generatePreviewVoice$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return SpeakerVoiceEditModel.a(this.this$0, null, this);
    }
}
