package com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk;

import android.util.SparseArray;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b?\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@¨\u0006A"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/audiosdk/LiveWrappedSAMICoreDataType;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "SAMICoreDataType_Float", "SAMICoreDataType_Int", "SAMICoreDataType_String", "SAMICoreDataType_Null", "SAMICoreDataType_AudioBuffer", "SAMICoreDataType_Data_Uri_Parameter", "SAMICoreDataType_ContextPrepareParameter", "SAMICoreDataType_ResourceParameter", "SAMICoreDataType_ParameterEvent", "SAMICoreDataType_ProcessorParameter", "SAMICoreDataType_FeatureSet", "SAMICoreDataType_ExtractorParameter", "SAMICoreDataType_ModelBin", "SAMICoreDataType_AecInput", "SAMICoreDataType_TTSCallBack", "SAMICoreDataType_EngineCreateParameter", "SAMICoreDataType_ExecutorCreateParameter", "SAMICoreDataType_TimeAlign", "SAMICoreDataType_LoudNorm", "SAMICoreDataType_LoudNorm2", "SAMICoreDataType_KWS", "SAMICoreDataType_KWS_SA_REAULT", "SAMICoreDataType_TTS_Result", "SAMICoreDataType_ASR_Result", "SAMICoreDataType_AudioBin", "SAMICoreDataType_BeatTracking_Result", "SAMICoreDataType_MusicSourceSeparate_Result", "SAMICoreDataType_MusicTagging_Result", "SAMICoreDataType_Chorus_Result", "SAMICoreDataType_MusicRetarget_Result", "SAMICoreDataType_Midi_Result", "SAMICoreDataType_Token_Result", "SAMICoreDataType_SpeechDisfluency_Result", "SAMICoreDataType_VoiceFilterParam", "SAMICoreDataType_ServerHttpResponse", "SAMICoreDataType_Http_Common_Response", "SAMICoreDataType_WebSocket_Server_Event", "SAMICoreDataType_WebSocket_Connection_Event", "SAMICoreDataType_WebSocket_Asr", "SAMICoreDataType_WebSocket_Tts", "SAMICoreDataType_WebSocket_Vc", "SAMICoreDataType_WebSocket_Vc_Speaker", "SAMICoreDataType_WebSocket_KeepAliveParam", "SAMICoreDataType_WebSocket_Asr_Context_Param", "SAMICoreDataType_WebSocket_Tts_Context_Param", "SAMICoreDataType_Voice_Assistant_Property_Param", "SAMICoreDataType_Voice_Assistant_Audio_data", "SAMICoreDataType_Voice_Assistant_Aec_Context_Param", "SAMICoreDataType_Voice_Assistant_Text_data", "SAMICoreDataType_Voice_Assistant_Trace_Span_Param", "SAMICoreDataType_Voice_Assistant_LoudnessStrategy_Param", "SAMICoreDataType_PostProcess_LoudnessStrategy_Param", "SAMICoreDataType_Voice_Assistant_Mem_Upload_Param", "SAMICoreDataType_WebSocket_BidirectionalTTS_Param", "SAMICoreDataType_Voice_Assistant_Info_Upload_Param", "SAMICore_DataType_TimeStretcher_ScaleInfo", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedSAMICoreDataType extends Enum<LiveWrappedSAMICoreDataType> {
    public static final a Companion = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_ASR_Result = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_AecInput = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_AudioBin = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_AudioBuffer = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_BeatTracking_Result = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Chorus_Result = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_ContextPrepareParameter = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Data_Uri_Parameter = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_EngineCreateParameter = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_ExecutorCreateParameter = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_ExtractorParameter = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_FeatureSet = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Float = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Http_Common_Response = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Int = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_KWS = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_KWS_SA_REAULT = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_LoudNorm = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_LoudNorm2 = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Midi_Result = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_ModelBin = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_MusicRetarget_Result = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_MusicSourceSeparate_Result = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_MusicTagging_Result = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Null = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_ParameterEvent = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_PostProcess_LoudnessStrategy_Param = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_ProcessorParameter = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_ResourceParameter = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_ServerHttpResponse = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_SpeechDisfluency_Result = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_String = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_TTSCallBack = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_TTS_Result = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_TimeAlign = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Token_Result = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_VoiceFilterParam = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Voice_Assistant_Aec_Context_Param = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Voice_Assistant_Audio_data = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Voice_Assistant_Info_Upload_Param = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Voice_Assistant_LoudnessStrategy_Param = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Voice_Assistant_Mem_Upload_Param = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Voice_Assistant_Property_Param = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Voice_Assistant_Text_data = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_Voice_Assistant_Trace_Span_Param = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_WebSocket_Asr = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_WebSocket_Asr_Context_Param = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_WebSocket_BidirectionalTTS_Param = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_WebSocket_Connection_Event = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_WebSocket_KeepAliveParam = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_WebSocket_Server_Event = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_WebSocket_Tts = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_WebSocket_Tts_Context_Param = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_WebSocket_Vc = null;
    public static final LiveWrappedSAMICoreDataType SAMICoreDataType_WebSocket_Vc_Speaker = null;
    public static final LiveWrappedSAMICoreDataType SAMICore_DataType_TimeStretcher_ScaleInfo = null;
    public static final /* synthetic */ LiveWrappedSAMICoreDataType[] a = null;
    public static final SparseArray<LiveWrappedSAMICoreDataType> b = null;
    private final int value;

    public static LiveWrappedSAMICoreDataType valueOf(String r1) {
        return (LiveWrappedSAMICoreDataType) r27.a.a(LiveWrappedSAMICoreDataType.class, r1);
    }

    public static LiveWrappedSAMICoreDataType[] values() {
        return (LiveWrappedSAMICoreDataType[]) a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk.LiveWrappedSAMICoreDataType$a] */
    static {
        int r3 = 0;
        LiveWrappedSAMICoreDataType r1 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Float", 0, 0);
        SAMICoreDataType_Float = r1;
        LiveWrappedSAMICoreDataType r2 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Int", 1, 1);
        SAMICoreDataType_Int = r2;
        LiveWrappedSAMICoreDataType r4 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_String", 2, 2);
        SAMICoreDataType_String = r4;
        LiveWrappedSAMICoreDataType r5 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Null", 3, 5);
        SAMICoreDataType_Null = r5;
        LiveWrappedSAMICoreDataType r6 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_AudioBuffer", 4, 50);
        SAMICoreDataType_AudioBuffer = r6;
        LiveWrappedSAMICoreDataType r7 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Data_Uri_Parameter", 5, 52);
        SAMICoreDataType_Data_Uri_Parameter = r7;
        LiveWrappedSAMICoreDataType r8 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_ContextPrepareParameter", 6, 100);
        SAMICoreDataType_ContextPrepareParameter = r8;
        LiveWrappedSAMICoreDataType r9 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_ResourceParameter", 7, 101);
        SAMICoreDataType_ResourceParameter = r9;
        LiveWrappedSAMICoreDataType r10 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_ParameterEvent", 8, 102);
        SAMICoreDataType_ParameterEvent = r10;
        LiveWrappedSAMICoreDataType r11 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_ProcessorParameter", 9, 150);
        SAMICoreDataType_ProcessorParameter = r11;
        LiveWrappedSAMICoreDataType r12 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_FeatureSet", 10, 250);
        SAMICoreDataType_FeatureSet = r12;
        LiveWrappedSAMICoreDataType r13 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_ExtractorParameter", 11, 251);
        SAMICoreDataType_ExtractorParameter = r13;
        LiveWrappedSAMICoreDataType r14 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_ModelBin", 12, MonitorLevel.WARN);
        SAMICoreDataType_ModelBin = r14;
        LiveWrappedSAMICoreDataType r15 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_AecInput", 13, 350);
        SAMICoreDataType_AecInput = r15;
        LiveWrappedSAMICoreDataType r16 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_TTSCallBack", 14, MonitorLevel.ERROR);
        SAMICoreDataType_TTSCallBack = r16;
        LiveWrappedSAMICoreDataType r17 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_EngineCreateParameter", 15, 401);
        SAMICoreDataType_EngineCreateParameter = r17;
        LiveWrappedSAMICoreDataType r18 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_ExecutorCreateParameter", 16, 402);
        SAMICoreDataType_ExecutorCreateParameter = r18;
        LiveWrappedSAMICoreDataType r19 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_TimeAlign", 17, 450);
        SAMICoreDataType_TimeAlign = r19;
        LiveWrappedSAMICoreDataType r20 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_LoudNorm", 18, 451);
        SAMICoreDataType_LoudNorm = r20;
        LiveWrappedSAMICoreDataType r21 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_LoudNorm2", 19, 452);
        SAMICoreDataType_LoudNorm2 = r21;
        LiveWrappedSAMICoreDataType r22 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_KWS", 20, 455);
        SAMICoreDataType_KWS = r22;
        LiveWrappedSAMICoreDataType r23 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_KWS_SA_REAULT", 21, 456);
        SAMICoreDataType_KWS_SA_REAULT = r23;
        LiveWrappedSAMICoreDataType r24 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_TTS_Result", 22, MonitorLevel.FATAL);
        SAMICoreDataType_TTS_Result = r24;
        LiveWrappedSAMICoreDataType r25 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_ASR_Result", 23, 503);
        SAMICoreDataType_ASR_Result = r25;
        LiveWrappedSAMICoreDataType r26 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_AudioBin", 24, 504);
        SAMICoreDataType_AudioBin = r26;
        LiveWrappedSAMICoreDataType r27 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_BeatTracking_Result", 25, 505);
        SAMICoreDataType_BeatTracking_Result = r27;
        LiveWrappedSAMICoreDataType r28 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_MusicSourceSeparate_Result", 26, 506);
        SAMICoreDataType_MusicSourceSeparate_Result = r28;
        LiveWrappedSAMICoreDataType r29 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_MusicTagging_Result", 27, 507);
        SAMICoreDataType_MusicTagging_Result = r29;
        LiveWrappedSAMICoreDataType r30 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Chorus_Result", 28, 508);
        SAMICoreDataType_Chorus_Result = r30;
        LiveWrappedSAMICoreDataType r31 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_MusicRetarget_Result", 29, 509);
        SAMICoreDataType_MusicRetarget_Result = r31;
        LiveWrappedSAMICoreDataType r32 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Midi_Result", 30, 510);
        SAMICoreDataType_Midi_Result = r32;
        LiveWrappedSAMICoreDataType r33 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Token_Result", 31, 511);
        SAMICoreDataType_Token_Result = r33;
        LiveWrappedSAMICoreDataType r34 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_SpeechDisfluency_Result", 32, DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE);
        SAMICoreDataType_SpeechDisfluency_Result = r34;
        LiveWrappedSAMICoreDataType r35 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_VoiceFilterParam", 33, 513);
        SAMICoreDataType_VoiceFilterParam = r35;
        LiveWrappedSAMICoreDataType r36 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_ServerHttpResponse", 34, 514);
        SAMICoreDataType_ServerHttpResponse = r36;
        LiveWrappedSAMICoreDataType r37 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Http_Common_Response", 35, 517);
        SAMICoreDataType_Http_Common_Response = r37;
        LiveWrappedSAMICoreDataType r38 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_WebSocket_Server_Event", 36, 600);
        SAMICoreDataType_WebSocket_Server_Event = r38;
        LiveWrappedSAMICoreDataType r39 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_WebSocket_Connection_Event", 37, 601);
        SAMICoreDataType_WebSocket_Connection_Event = r39;
        LiveWrappedSAMICoreDataType r40 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_WebSocket_Asr", 38, 602);
        SAMICoreDataType_WebSocket_Asr = r40;
        LiveWrappedSAMICoreDataType r41 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_WebSocket_Tts", 39, 603);
        SAMICoreDataType_WebSocket_Tts = r41;
        LiveWrappedSAMICoreDataType r42 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_WebSocket_Vc", 40, 604);
        SAMICoreDataType_WebSocket_Vc = r42;
        LiveWrappedSAMICoreDataType r43 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_WebSocket_Vc_Speaker", 41, 605);
        SAMICoreDataType_WebSocket_Vc_Speaker = r43;
        LiveWrappedSAMICoreDataType r44 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_WebSocket_KeepAliveParam", 42, 606);
        SAMICoreDataType_WebSocket_KeepAliveParam = r44;
        LiveWrappedSAMICoreDataType r45 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_WebSocket_Asr_Context_Param", 43, 650);
        SAMICoreDataType_WebSocket_Asr_Context_Param = r45;
        LiveWrappedSAMICoreDataType r46 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_WebSocket_Tts_Context_Param", 44, 651);
        SAMICoreDataType_WebSocket_Tts_Context_Param = r46;
        LiveWrappedSAMICoreDataType r47 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Voice_Assistant_Property_Param", 45, 652);
        SAMICoreDataType_Voice_Assistant_Property_Param = r47;
        LiveWrappedSAMICoreDataType r48 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Voice_Assistant_Audio_data", 46, 653);
        SAMICoreDataType_Voice_Assistant_Audio_data = r48;
        LiveWrappedSAMICoreDataType r49 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Voice_Assistant_Aec_Context_Param", 47, 654);
        SAMICoreDataType_Voice_Assistant_Aec_Context_Param = r49;
        LiveWrappedSAMICoreDataType r50 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Voice_Assistant_Text_data", 48, 655);
        SAMICoreDataType_Voice_Assistant_Text_data = r50;
        LiveWrappedSAMICoreDataType r51 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Voice_Assistant_Trace_Span_Param", 49, 656);
        SAMICoreDataType_Voice_Assistant_Trace_Span_Param = r51;
        LiveWrappedSAMICoreDataType r52 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Voice_Assistant_LoudnessStrategy_Param", 50, 657);
        SAMICoreDataType_Voice_Assistant_LoudnessStrategy_Param = r52;
        LiveWrappedSAMICoreDataType r53 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_PostProcess_LoudnessStrategy_Param", 51, 657);
        SAMICoreDataType_PostProcess_LoudnessStrategy_Param = r53;
        LiveWrappedSAMICoreDataType r54 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Voice_Assistant_Mem_Upload_Param", 52, 680);
        SAMICoreDataType_Voice_Assistant_Mem_Upload_Param = r54;
        LiveWrappedSAMICoreDataType r55 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_WebSocket_BidirectionalTTS_Param", 53, 681);
        SAMICoreDataType_WebSocket_BidirectionalTTS_Param = r55;
        LiveWrappedSAMICoreDataType r56 = new LiveWrappedSAMICoreDataType("SAMICoreDataType_Voice_Assistant_Info_Upload_Param", 54, 682);
        SAMICoreDataType_Voice_Assistant_Info_Upload_Param = r56;
        LiveWrappedSAMICoreDataType r57 = new LiveWrappedSAMICoreDataType("SAMICore_DataType_TimeStretcher_ScaleInfo", 55, 800);
        SAMICore_DataType_TimeStretcher_ScaleInfo = r57;
        a = new LiveWrappedSAMICoreDataType[]{r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57};
        Companion = new a();
        b = new SparseArray();
        LiveWrappedSAMICoreDataType[] r0 = values();
        int r58 = r0.length;
    L3:
        if (r3 >= r58) goto L5;
        LiveWrappedSAMICoreDataType r59 = r0[r3];
        b.put(r59.value, r59);
        r3 = r3 + 1;
        goto L3
    }

    public static final /* synthetic */ SparseArray access$getIntToEnumMap$cp() {
        return b;
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedSAMICoreDataType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
