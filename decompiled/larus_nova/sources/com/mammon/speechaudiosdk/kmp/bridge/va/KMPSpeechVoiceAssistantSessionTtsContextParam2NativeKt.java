package com.mammon.speechaudiosdk.kmp.bridge.va;

import com.mammon.audiosdk.structures.SAMICoreTtsContextCreateParameter;
import com.mammon.speechaudiosdk.kmp.param.va.SpeechVoiceAssistantSessionTtsContextParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toNative", "Lcom/mammon/audiosdk/structures/SAMICoreTtsContextCreateParameter;", "Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionTtsContextParam;", "speech_audiosdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class KMPSpeechVoiceAssistantSessionTtsContextParam2NativeKt {
    public static final SAMICoreTtsContextCreateParameter toNative(SpeechVoiceAssistantSessionTtsContextParam r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        SAMICoreTtsContextCreateParameter r101 = new SAMICoreTtsContextCreateParameter();
        r101.format = r100.getAudioConfig().getFormat();
        r101.sampleRate = r100.getAudioConfig().getSampleRate();
        r101.bitRate = r100.getAudioConfig().getBitRate();
        r101.enableNetTransportCompress = r100.getAudioConfig().getEnableNetTransportCompress();
        r101.speaker = r100.getSpeaker();
        r101.extra = r100.getExtra();
        r101.internal = r100.getInternalParam();
        return r101;
    }
}
