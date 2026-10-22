package com.larus.im.internal.audio.session.v2;

import com.mammon.speechaudiosdk.session.param.SpeechVoiceAssistantLoudnessParam;
import com.mammon.speechaudiosdk.session.task.SpeechRealtimeCallTask;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class SAMICoreInterceptorProvider$initialize$succeed$1$3 extends AdaptedFunctionReference implements Function0<Boolean> {
    public SAMICoreInterceptorProvider$initialize$succeed$1$3(Object r100) {
        super(0, r100, r0.class, "setLoudnessParam", "setLoudnessParam(Ljava/lang/String;)Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        r0 r100 = (r0) this.receiver;
        int r101 = r0.f347452l;
        ve9.p r102 = ve9.j.h(r100.f347453a);
        SpeechVoiceAssistantLoudnessParam r103 = new SpeechVoiceAssistantLoudnessParam();
        r103.deviceAiData = r102.f554516h;
        r103.audioDumpPath = r102.f554519k;
        r103.loudNormAlgoType = r102.f554518j;
        r103.metaData = r102.f554515g;
        SpeechRealtimeCallTask r104 = r100.f347459g;
        if (r104 != null) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == true) goto L11;
        r100.f347455c.b("SAMICoreInterceptorProvider", "[setLoudnessParam] Task set loudness parameter failed.");
    L11:
        return Boolean.valueOf(r105);
    L5:
        if (r104.setLocalParam(301, r103) != 0) goto L7;
        r105 = true;
        goto L8
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
