package com.mammon.speechaudiosdk.kmp.bridge;

import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantLoudnessStrategyParameter;
import com.mammon.speechaudiosdk.kmp.param.SpeechAudioLoudnessStrategyParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toNative", "Lcom/mammon/audiosdk/structures/SAMICoreVoiceAssistantLoudnessStrategyParameter;", "Lcom/mammon/speechaudiosdk/kmp/param/SpeechAudioLoudnessStrategyParam;", "speech_audiosdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class KMPSpeechAudioLoudnessStratergyParam2NativeKt {
    public static final SAMICoreVoiceAssistantLoudnessStrategyParameter toNative(SpeechAudioLoudnessStrategyParam r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        SAMICoreVoiceAssistantLoudnessStrategyParameter r101 = new SAMICoreVoiceAssistantLoudnessStrategyParameter();
        r101.metaData = r100.getMetaData();
        r101.deviceAiData = r100.getDeviceAiData();
        r101.loudNormAlgoType = r100.getLoudNormAlgoType();
        r101.audioDumpPath = r100.getAudioDumpPath();
        return r101;
    }
}
