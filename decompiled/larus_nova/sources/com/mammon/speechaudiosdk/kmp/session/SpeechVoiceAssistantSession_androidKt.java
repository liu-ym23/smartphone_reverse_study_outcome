package com.mammon.speechaudiosdk.kmp.session;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"createSpeechVoiceAssistantSession", "Lcom/mammon/speechaudiosdk/kmp/session/SpeechVoiceAssistantSession;", "listener", "Lcom/mammon/speechaudiosdk/kmp/session/SpeechVoiceAssistantSessionListener;", "speech_audiosdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SpeechVoiceAssistantSession_androidKt {
    public static final SpeechVoiceAssistantSession createSpeechVoiceAssistantSession(SpeechVoiceAssistantSessionListener r100) {
        return new AndroidSpeechVoiceAssistantSessionImpl(r100);
    }

    public static /* synthetic */ SpeechVoiceAssistantSession createSpeechVoiceAssistantSession$default(SpeechVoiceAssistantSessionListener r100, int r101, Object r102) {
        if ((r101 & 1) == 0) goto L6;
        r100 = null;
    L6:
        return createSpeechVoiceAssistantSession(r100);
    }
}
