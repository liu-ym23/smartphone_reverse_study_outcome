package com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk;

import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b \b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/audiosdk/LiveWrappedSAMICoreIdentify;", "", "", "value", "I", "getValue", "()I", "SAMICoreIdentify_EngineExecutor_KWS", "SAMICoreIdentify_EngineExecutor_AudioMetrics", "SAMICoreIdentify_EngineExecutor_Common", "SAMICoreIdentify_EngineExecutor_MultiLevel_Wakeup", "SAMICoreIdentify_Non_Streaming_Wakeup", "SAMICoreIdentify_Non_Streaming_Wakeup_With_Uploader", "SAMICoreIdentify_EngineExecutor_CE_ASR_SYNC", "SAMICoreIdentify_EngineExecutor_CE_ASR_ASYNC", "SAMICoreIdentify_EngineExecutor_CE_VAD", "SAMICoreIdentify_TTS_Online", "SAMICoreIdentify_MultiSpeakerEmbedding_Online", "SAMICoreIdentify_Streaming_ASR_Online", "SAMICoreIdentify_Streaming_TTS_Online", "SAMICoreIdentify_Streaming_Playing_TTS_Online", "SAMICoreIdentify_Streaming_ASR_Async_Online", "SAMICoreIdentify_Streaming_VC_Online", "SAMICoreIdentify_Bidirectional_TTS_Online", "SAMICoreIdentify_Voice_Assistant_Online", "SAMICoreIdentify_Voice_Assistant_TimeStretcher", "SAMICoreIdentify_Voice_Assistant_TimeStretcher_Finer", "SAMICoreIdentify_Voice_Assistant_Online_V2", "SAMICoreIdentify_RealtimeCall_Aec", "SAMICoreIdentify_Offline_Full_Duplex", "SAMICoreIdentify_Streaming_ASR_Online_V2", "SAMICoreIdentify_Audio_Encode", "SAMICoreIdentify_AISTunnel", "SAMICoreIdentify_AISAbility", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedSAMICoreIdentify extends Enum<LiveWrappedSAMICoreIdentify> {
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_AISAbility = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_AISTunnel = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Audio_Encode = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Bidirectional_TTS_Online = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_EngineExecutor_AudioMetrics = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_EngineExecutor_CE_ASR_ASYNC = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_EngineExecutor_CE_ASR_SYNC = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_EngineExecutor_CE_VAD = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_EngineExecutor_Common = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_EngineExecutor_KWS = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_EngineExecutor_MultiLevel_Wakeup = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_MultiSpeakerEmbedding_Online = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Non_Streaming_Wakeup = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Non_Streaming_Wakeup_With_Uploader = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Offline_Full_Duplex = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_RealtimeCall_Aec = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Streaming_ASR_Async_Online = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Streaming_ASR_Online = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Streaming_ASR_Online_V2 = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Streaming_Playing_TTS_Online = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Streaming_TTS_Online = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Streaming_VC_Online = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_TTS_Online = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Voice_Assistant_Online = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Voice_Assistant_Online_V2 = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Voice_Assistant_TimeStretcher = null;
    public static final LiveWrappedSAMICoreIdentify SAMICoreIdentify_Voice_Assistant_TimeStretcher_Finer = null;
    public static final /* synthetic */ LiveWrappedSAMICoreIdentify[] a = null;
    private final int value;

    public static LiveWrappedSAMICoreIdentify valueOf(String r1) {
        return (LiveWrappedSAMICoreIdentify) a.a(LiveWrappedSAMICoreIdentify.class, r1);
    }

    public static LiveWrappedSAMICoreIdentify[] values() {
        return (LiveWrappedSAMICoreIdentify[]) a.clone();
    }

    static {
        LiveWrappedSAMICoreIdentify r1 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_EngineExecutor_KWS", 0, 507);
        SAMICoreIdentify_EngineExecutor_KWS = r1;
        LiveWrappedSAMICoreIdentify r2 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_EngineExecutor_AudioMetrics", 1, 508);
        SAMICoreIdentify_EngineExecutor_AudioMetrics = r2;
        LiveWrappedSAMICoreIdentify r3 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_EngineExecutor_Common", 2, DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE);
        SAMICoreIdentify_EngineExecutor_Common = r3;
        LiveWrappedSAMICoreIdentify r4 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_EngineExecutor_MultiLevel_Wakeup", 3, 515);
        SAMICoreIdentify_EngineExecutor_MultiLevel_Wakeup = r4;
        LiveWrappedSAMICoreIdentify r5 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Non_Streaming_Wakeup", 4, 517);
        SAMICoreIdentify_Non_Streaming_Wakeup = r5;
        LiveWrappedSAMICoreIdentify r6 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Non_Streaming_Wakeup_With_Uploader", 5, 518);
        SAMICoreIdentify_Non_Streaming_Wakeup_With_Uploader = r6;
        LiveWrappedSAMICoreIdentify r7 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_EngineExecutor_CE_ASR_SYNC", 6, 555);
        SAMICoreIdentify_EngineExecutor_CE_ASR_SYNC = r7;
        LiveWrappedSAMICoreIdentify r8 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_EngineExecutor_CE_ASR_ASYNC", 7, 556);
        SAMICoreIdentify_EngineExecutor_CE_ASR_ASYNC = r8;
        LiveWrappedSAMICoreIdentify r9 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_EngineExecutor_CE_VAD", 8, 557);
        SAMICoreIdentify_EngineExecutor_CE_VAD = r9;
        LiveWrappedSAMICoreIdentify r10 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_TTS_Online", 9, 601);
        SAMICoreIdentify_TTS_Online = r10;
        LiveWrappedSAMICoreIdentify r11 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_MultiSpeakerEmbedding_Online", 10, 615);
        SAMICoreIdentify_MultiSpeakerEmbedding_Online = r11;
        LiveWrappedSAMICoreIdentify r12 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Streaming_ASR_Online", 11, 650);
        SAMICoreIdentify_Streaming_ASR_Online = r12;
        LiveWrappedSAMICoreIdentify r13 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Streaming_TTS_Online", 12, 651);
        SAMICoreIdentify_Streaming_TTS_Online = r13;
        LiveWrappedSAMICoreIdentify r14 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Streaming_Playing_TTS_Online", 13, 652);
        SAMICoreIdentify_Streaming_Playing_TTS_Online = r14;
        LiveWrappedSAMICoreIdentify r15 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Streaming_ASR_Async_Online", 14, 653);
        SAMICoreIdentify_Streaming_ASR_Async_Online = r15;
        LiveWrappedSAMICoreIdentify r16 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Streaming_VC_Online", 15, 654);
        SAMICoreIdentify_Streaming_VC_Online = r16;
        LiveWrappedSAMICoreIdentify r17 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Bidirectional_TTS_Online", 16, 655);
        SAMICoreIdentify_Bidirectional_TTS_Online = r17;
        LiveWrappedSAMICoreIdentify r18 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Voice_Assistant_Online", 17, 656);
        SAMICoreIdentify_Voice_Assistant_Online = r18;
        LiveWrappedSAMICoreIdentify r19 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Voice_Assistant_TimeStretcher", 18, 657);
        SAMICoreIdentify_Voice_Assistant_TimeStretcher = r19;
        LiveWrappedSAMICoreIdentify r20 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Voice_Assistant_TimeStretcher_Finer", 19, 658);
        SAMICoreIdentify_Voice_Assistant_TimeStretcher_Finer = r20;
        LiveWrappedSAMICoreIdentify r21 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Voice_Assistant_Online_V2", 20, 659);
        SAMICoreIdentify_Voice_Assistant_Online_V2 = r21;
        LiveWrappedSAMICoreIdentify r22 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_RealtimeCall_Aec", 21, 660);
        SAMICoreIdentify_RealtimeCall_Aec = r22;
        LiveWrappedSAMICoreIdentify r23 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Offline_Full_Duplex", 22, 661);
        SAMICoreIdentify_Offline_Full_Duplex = r23;
        LiveWrappedSAMICoreIdentify r24 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Streaming_ASR_Online_V2", 23, 670);
        SAMICoreIdentify_Streaming_ASR_Online_V2 = r24;
        LiveWrappedSAMICoreIdentify r25 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_Audio_Encode", 24, 800);
        SAMICoreIdentify_Audio_Encode = r25;
        LiveWrappedSAMICoreIdentify r26 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_AISTunnel", 25, 9100);
        SAMICoreIdentify_AISTunnel = r26;
        LiveWrappedSAMICoreIdentify r27 = new LiveWrappedSAMICoreIdentify("SAMICoreIdentify_AISAbility", 26, 9101);
        SAMICoreIdentify_AISAbility = r27;
        a = new LiveWrappedSAMICoreIdentify[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27};
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedSAMICoreIdentify(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
