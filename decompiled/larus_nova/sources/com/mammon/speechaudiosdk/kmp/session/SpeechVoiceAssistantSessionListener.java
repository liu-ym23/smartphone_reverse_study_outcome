package com.mammon.speechaudiosdk.kmp.session;

import com.mammon.speechaudiosdk.kmp.param.SpeechAudioNetConnectionEventParam;
import com.mammon.speechaudiosdk.kmp.param.va.SpeechVoiceAssistantSessionDownlinkEventParam;
import com.mammon.speechaudiosdk.kmp.type.SpeechAudioTransportType;
import com.mammon.speechaudiosdk.kmp.type.va.SpeechVoiceAssistantSessionDownlinkEventType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/session/SpeechVoiceAssistantSessionListener;", "", "onDownlinkEvent", "", "type", "Lcom/mammon/speechaudiosdk/kmp/type/va/SpeechVoiceAssistantSessionDownlinkEventType;", "data", "Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionDownlinkEventParam;", "onNetConnectionStateChangedEvent", "Lcom/mammon/speechaudiosdk/kmp/type/SpeechAudioTransportType;", "Lcom/mammon/speechaudiosdk/kmp/param/SpeechAudioNetConnectionEventParam;", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface SpeechVoiceAssistantSessionListener {
    void onDownlinkEvent(SpeechVoiceAssistantSessionDownlinkEventType r100, SpeechVoiceAssistantSessionDownlinkEventParam r101);

    void onNetConnectionStateChangedEvent(SpeechAudioTransportType r100, SpeechAudioNetConnectionEventParam r101);
}
