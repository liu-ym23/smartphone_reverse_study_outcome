package com.larus.voice_setting.voice.editvoice;

import com.hihonor.honorid.core.data.UserInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.editvoice.SpeakerVoiceEditModel", f = "SpeakerVoiceEditModel.kt", i = {0, 0, 0, 0}, l = {545}, m = "createPreviewVoice", n = {"list", UserInfo.LANGUAGECODE, "pitchF64", "rateF64"}, s = {"L$0", "L$1", "F$0", "F$1"})
public final class SpeakerVoiceEditModel$createPreviewVoice$1 extends ContinuationImpl {
    float F$0;
    float F$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SpeakerVoiceEditModel this$0;

    public SpeakerVoiceEditModel$createPreviewVoice$1(SpeakerVoiceEditModel r100, Continuation<? super SpeakerVoiceEditModel$createPreviewVoice$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        SpeakerVoiceEditModel r101 = this.this$0;
        int r102 = SpeakerVoiceEditModel.P;
        return r101.d(null, 0.0f, 0.0f, null, this);
    }
}
