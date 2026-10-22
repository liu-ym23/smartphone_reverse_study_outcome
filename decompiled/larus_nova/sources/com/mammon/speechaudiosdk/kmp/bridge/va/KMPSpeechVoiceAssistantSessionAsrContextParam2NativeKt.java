package com.mammon.speechaudiosdk.kmp.bridge.va;

import com.mammon.audiosdk.enums.SAMICoreTokenType;
import com.mammon.audiosdk.structures.SAMICoreAsrContextCreateParameter;
import com.mammon.speechaudiosdk.kmp.param.va.SpeechVoiceAssistantSessionAsrContextParam;
import com.mammon.speechaudiosdk.kmp.type.SpeechAudioTokenType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toNative", "Lcom/mammon/audiosdk/structures/SAMICoreAsrContextCreateParameter;", "Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionAsrContextParam;", "speech_audiosdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class KMPSpeechVoiceAssistantSessionAsrContextParam2NativeKt {
    public static final SAMICoreAsrContextCreateParameter toNative(SpeechVoiceAssistantSessionAsrContextParam r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        SAMICoreAsrContextCreateParameter r101 = new SAMICoreAsrContextCreateParameter();
        r101.url = r100.getUrl();
        r101.appKey = r100.getAppKey();
        r101.header = r100.getHeader();
        r101.taskId = r100.getTaskId();
        r101.sessionId = r100.getSessionId();
        SpeechAudioTokenType r102 = r100.getTokenType();
        int[] r103 = null;
        if (r102 == null) goto L5;
        SAMICoreTokenType r104 = SAMICoreTokenType.fromInt(r102.getValue());
    L6:
        r101.tokenType = r104;
        r101.token = r100.getToken();
        r101.format = r100.getAudioConfig().getFormat();
        r101.sampleRate = r100.getAudioConfig().getSampleRate();
        r101.channel = r100.getAudioConfig().getChannel();
        r101.connect_timeout = r100.getConnectTimeout();
        r101.language = r100.getLanguage();
        r101.extra = r100.getExtra();
        r101.model = r100.getModel();
        r101.sos_silence_timeout = r100.getSosSilenceTimeout();
        r101.eos_silence_timeout = r100.getEosSilenceTimeout();
        r101.sentence_max_time = r100.getSentenceMaxTime();
        r101.enable_punctuation = r100.getEnablePunctuation();
        r101.enable_speaker_diarization = r100.getEnableSpeakerDiarization();
        r101.timestamp = r100.getTimestamp();
        r101.enable_audio_cache = r100.getEnableAudioCache();
        r101.audio_cache_size = r100.getAudioCacheSize();
        r101.enable_remove_first_audio_data = r100.getEnableRemoveFirstAudioData();
        r101.enable_net_transport_compress = r100.getAudioConfig().getEnableNetTransportCompress() ? 1 : 0;
        r101.business_info = r100.getBusinessInfo();
        r101.enable_speech_rejection = r100.getEnableSpeechRejection();
        r101.audio_src = r100.getAudioSrc();
        r101.retry_mode = r100.getRetryMode();
        r101.retry_count = r100.getRetryCount();
        List<Integer> r105 = r100.getRetryIntervalTimeMs();
        if (r105 == null) goto L9;
        r103 = CollectionsKt.toIntArray(r105);
    L9:
        r101.retry_interval_time_ms = r103;
        r101.max_buffer_count = r100.getMaxBufferCount();
        r101.finish_wait_timeout = r100.getFinishWaitTimeout();
        return r101;
    L5:
        r104 = null;
        goto L6
    }
}
