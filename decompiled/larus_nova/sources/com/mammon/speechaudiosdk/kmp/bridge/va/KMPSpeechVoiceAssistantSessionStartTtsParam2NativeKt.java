package com.mammon.speechaudiosdk.kmp.bridge.va;

import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantPropertyParameter;
import com.mammon.speechaudiosdk.kmp.param.va.SpeechVoiceAssistantSessionStartTtsParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toNative", "Lcom/mammon/audiosdk/structures/SAMICoreVoiceAssistantPropertyParameter;", "Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionStartTtsParam;", "speech_audiosdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class KMPSpeechVoiceAssistantSessionStartTtsParam2NativeKt {
    public static final SAMICoreVoiceAssistantPropertyParameter toNative(SpeechVoiceAssistantSessionStartTtsParam r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        SAMICoreVoiceAssistantPropertyParameter r101 = new SAMICoreVoiceAssistantPropertyParameter();
        r101.chat = r100.getChat();
        return r101;
    }
}
