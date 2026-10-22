package com.mammon.speechaudiosdk.kmp.session;

import com.mammon.speechaudiosdk.kmp.param.SpeechAudioLoudnessStrategyParam;
import com.mammon.speechaudiosdk.kmp.param.va.SpeechVoiceAssistantSessionAsrContextParam;
import com.mammon.speechaudiosdk.kmp.param.va.SpeechVoiceAssistantSessionAudioParam;
import com.mammon.speechaudiosdk.kmp.param.va.SpeechVoiceAssistantSessionContextParam;
import com.mammon.speechaudiosdk.kmp.param.va.SpeechVoiceAssistantSessionTtsContextParam;
import com.mammon.speechaudiosdk.kmp.type.va.SpeechVoiceAssistantSessionUplinkEventType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u001a\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH&¨\u0006\u001b"}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/session/SpeechVoiceAssistantSession;", "", "init", "", "sessionContextParam", "Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionContextParam;", "start", "stop", "release", "setAsrContextParam", "asrParam", "Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionAsrContextParam;", "setAsrCompressParam", "compressBitRate", "setTtsContextParam", "ttsParam", "Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionTtsContextParam;", "sendUplinkEvent", "event", "Lcom/mammon/speechaudiosdk/kmp/type/va/SpeechVoiceAssistantSessionUplinkEventType;", "eventParam", "sendUplinkAudio", "audioParam", "Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionAudioParam;", "setLoudnessStrategyParameter", "loudnessStrategyParam", "Lcom/mammon/speechaudiosdk/kmp/param/SpeechAudioLoudnessStrategyParam;", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface SpeechVoiceAssistantSession {
    int init(SpeechVoiceAssistantSessionContextParam r100);

    int release();

    int sendUplinkAudio(SpeechVoiceAssistantSessionAudioParam r100);

    int sendUplinkEvent(SpeechVoiceAssistantSessionUplinkEventType r100, Object r101);

    int setAsrCompressParam(int r100);

    int setAsrContextParam(SpeechVoiceAssistantSessionAsrContextParam r100);

    int setLoudnessStrategyParameter(SpeechAudioLoudnessStrategyParam r100);

    int setTtsContextParam(SpeechVoiceAssistantSessionTtsContextParam r100);

    int start();

    int stop();
}
