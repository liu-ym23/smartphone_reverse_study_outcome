package com.mammon.samicorenui;

import com.obric.capabilitykit.entity.app.EntityType;
import com.ss.ttm.player.MediaPlayer;
import java.util.HashMap;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum SAMICoreNuiParameterType extends Enum<SAMICoreNuiParameterType> {
    public static final SAMICoreNuiParameterType AEC_BIT_DEPTH = null;
    public static final SAMICoreNuiParameterType AEC_CHANNEL = null;
    public static final SAMICoreNuiParameterType AEC_DEBUG = null;
    public static final SAMICoreNuiParameterType AEC_ENABLE = null;
    public static final SAMICoreNuiParameterType AEC_MODEL = null;
    public static final SAMICoreNuiParameterType AEC_SAMPLE_RATE = null;
    public static final SAMICoreNuiParameterType ASR_ONLINE_BIT_DEPTH = null;
    public static final SAMICoreNuiParameterType ASR_ONLINE_CHANNEL = null;
    public static final SAMICoreNuiParameterType ASR_ONLINE_DEBUG = null;
    public static final SAMICoreNuiParameterType ASR_ONLINE_ENABLE = null;
    public static final SAMICoreNuiParameterType ASR_ONLINE_ENABLE_PUNCTUATION = null;
    public static final SAMICoreNuiParameterType ASR_ONLINE_EOS_SILENCE_TIMEOUT = null;
    public static final SAMICoreNuiParameterType ASR_ONLINE_LANG = null;
    public static final SAMICoreNuiParameterType ASR_ONLINE_SAMPLE_RATE = null;
    public static final SAMICoreNuiParameterType ASR_ONLINE_SOS_SILENCE_TIMEOUT = null;
    public static final SAMICoreNuiParameterType AUDIO_MIC_AUDIO_SOURCE = null;
    public static final SAMICoreNuiParameterType AUDIO_MIC_BIT_DEPTH = null;
    public static final SAMICoreNuiParameterType AUDIO_MIC_CHANNEL = null;
    public static final SAMICoreNuiParameterType AUDIO_MIC_DEBUG = null;
    public static final SAMICoreNuiParameterType AUDIO_MIC_ENABLE = null;
    public static final SAMICoreNuiParameterType AUDIO_MIC_SAMPLE_RATE = null;
    public static final SAMICoreNuiParameterType AUDIO_PLAYER_BIT_DEPTH = null;
    public static final SAMICoreNuiParameterType AUDIO_PLAYER_CHANNEL = null;
    public static final SAMICoreNuiParameterType AUDIO_PLAYER_DEBUG = null;
    public static final SAMICoreNuiParameterType AUDIO_PLAYER_ENABLE = null;
    public static final SAMICoreNuiParameterType AUDIO_PLAYER_SAMPLE_RATE = null;
    public static final SAMICoreNuiParameterType AUDIO_PLAYER_STREAM = null;
    public static final SAMICoreNuiParameterType COMMON_APPKEY = null;
    public static final SAMICoreNuiParameterType COMMON_DEBUG_PATH = null;
    public static final SAMICoreNuiParameterType COMMON_LOG_LEVEL = null;
    public static final SAMICoreNuiParameterType COMMON_TOKEN = null;
    public static final SAMICoreNuiParameterType COMMON_URL = null;
    public static final SAMICoreNuiParameterType DENOISE_DEBUG = null;
    public static final SAMICoreNuiParameterType DENOISE_ENABLE = null;
    public static final SAMICoreNuiParameterType DEVICE_TYPE = null;
    public static final SAMICoreNuiParameterType KWS_BIT_DEPTH = null;
    public static final SAMICoreNuiParameterType KWS_CHANNEL = null;
    public static final SAMICoreNuiParameterType KWS_DEBUG = null;
    public static final SAMICoreNuiParameterType KWS_ENABLE = null;
    public static final SAMICoreNuiParameterType KWS_KEY_WORDS = null;
    public static final SAMICoreNuiParameterType KWS_MODEL = null;
    public static final SAMICoreNuiParameterType KWS_MODEL_TYPE = null;
    public static final SAMICoreNuiParameterType KWS_SAMPLE_RATE = null;
    public static final SAMICoreNuiParameterType KWS_THRESHOLD = null;
    public static final SAMICoreNuiParameterType KWS_WAKEUP_MODE = null;
    public static final SAMICoreNuiParameterType NLU_DEBUG = null;
    public static final SAMICoreNuiParameterType NLU_ENABLE = null;
    public static final SAMICoreNuiParameterType TTS_ONLINE_DEBUG = null;
    public static final SAMICoreNuiParameterType TTS_ONLINE_ENABLE = null;
    public static final SAMICoreNuiParameterType TTS_ONLINE_FORMAT = null;
    public static final SAMICoreNuiParameterType TTS_ONLINE_PITCH_RATE = null;
    public static final SAMICoreNuiParameterType TTS_ONLINE_SAMPLE_RATE = null;
    public static final SAMICoreNuiParameterType TTS_ONLINE_SPEAKER = null;
    public static final SAMICoreNuiParameterType TTS_ONLINE_SPEECH_RATE = null;
    public static final SAMICoreNuiParameterType VAD_DEBUG = null;
    public static final SAMICoreNuiParameterType VAD_ENABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SAMICoreNuiParameterType[] f384368a = null;
    public static final HashMap<Integer, SAMICoreNuiParameterType> intToEnumMap = null;
    private int value;

    static {
        SAMICoreNuiParameterType r100 = new SAMICoreNuiParameterType("DEVICE_TYPE", 0, 0);
        DEVICE_TYPE = r100;
        SAMICoreNuiParameterType r101 = new SAMICoreNuiParameterType("COMMON_LOG_LEVEL", 1, 10000);
        COMMON_LOG_LEVEL = r101;
        SAMICoreNuiParameterType r102 = new SAMICoreNuiParameterType("COMMON_DEBUG_PATH", 2, 10001);
        COMMON_DEBUG_PATH = r102;
        SAMICoreNuiParameterType r103 = new SAMICoreNuiParameterType("COMMON_URL", 3, 10002);
        COMMON_URL = r103;
        SAMICoreNuiParameterType r104 = new SAMICoreNuiParameterType("COMMON_APPKEY", 4, 10003);
        COMMON_APPKEY = r104;
        SAMICoreNuiParameterType r105 = new SAMICoreNuiParameterType("COMMON_TOKEN", 5, 10004);
        COMMON_TOKEN = r105;
        SAMICoreNuiParameterType r110 = new SAMICoreNuiParameterType("AUDIO_MIC_ENABLE", 6, 10100);
        AUDIO_MIC_ENABLE = r110;
        SAMICoreNuiParameterType r111 = new SAMICoreNuiParameterType("AUDIO_MIC_AUDIO_SOURCE", 7, 10101);
        AUDIO_MIC_AUDIO_SOURCE = r111;
        SAMICoreNuiParameterType r112 = new SAMICoreNuiParameterType("AUDIO_MIC_SAMPLE_RATE", 8, 10102);
        AUDIO_MIC_SAMPLE_RATE = r112;
        SAMICoreNuiParameterType r113 = new SAMICoreNuiParameterType("AUDIO_MIC_CHANNEL", 9, 10103);
        AUDIO_MIC_CHANNEL = r113;
        SAMICoreNuiParameterType r114 = new SAMICoreNuiParameterType("AUDIO_MIC_BIT_DEPTH", 10, 10104);
        AUDIO_MIC_BIT_DEPTH = r114;
        SAMICoreNuiParameterType r106 = new SAMICoreNuiParameterType("AUDIO_MIC_DEBUG", 11, 10105);
        AUDIO_MIC_DEBUG = r106;
        SAMICoreNuiParameterType r107 = new SAMICoreNuiParameterType("AUDIO_PLAYER_ENABLE", 12, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_OUTLET_DB_LIST_STR);
        AUDIO_PLAYER_ENABLE = r107;
        SAMICoreNuiParameterType r108 = new SAMICoreNuiParameterType("AUDIO_PLAYER_STREAM", 13, 10201);
        AUDIO_PLAYER_STREAM = r108;
        SAMICoreNuiParameterType r109 = new SAMICoreNuiParameterType("AUDIO_PLAYER_SAMPLE_RATE", 14, 10202);
        AUDIO_PLAYER_SAMPLE_RATE = r109;
        SAMICoreNuiParameterType r115 = new SAMICoreNuiParameterType("AUDIO_PLAYER_CHANNEL", 15, 10203);
        AUDIO_PLAYER_CHANNEL = r115;
        SAMICoreNuiParameterType r116 = new SAMICoreNuiParameterType("AUDIO_PLAYER_BIT_DEPTH", 16, 10204);
        AUDIO_PLAYER_BIT_DEPTH = r116;
        SAMICoreNuiParameterType r117 = new SAMICoreNuiParameterType("AUDIO_PLAYER_DEBUG", 17, 10205);
        AUDIO_PLAYER_DEBUG = r117;
        SAMICoreNuiParameterType r118 = new SAMICoreNuiParameterType("DENOISE_ENABLE", 18, 10300);
        DENOISE_ENABLE = r118;
        SAMICoreNuiParameterType r119 = new SAMICoreNuiParameterType("DENOISE_DEBUG", 19, EntityType.MEMORY_EVENT_SCHEDULE);
        DENOISE_DEBUG = r119;
        SAMICoreNuiParameterType r120 = new SAMICoreNuiParameterType("VAD_ENABLE", 20, 10400);
        VAD_ENABLE = r120;
        SAMICoreNuiParameterType r121 = new SAMICoreNuiParameterType("VAD_DEBUG", 21, 10401);
        VAD_DEBUG = r121;
        SAMICoreNuiParameterType r122 = new SAMICoreNuiParameterType("AEC_ENABLE", 22, 10500);
        AEC_ENABLE = r122;
        SAMICoreNuiParameterType r123 = new SAMICoreNuiParameterType("AEC_MODEL", 23, 10501);
        AEC_MODEL = r123;
        SAMICoreNuiParameterType r124 = new SAMICoreNuiParameterType("AEC_SAMPLE_RATE", 24, 10502);
        AEC_SAMPLE_RATE = r124;
        SAMICoreNuiParameterType r125 = new SAMICoreNuiParameterType("AEC_CHANNEL", 25, 10503);
        AEC_CHANNEL = r125;
        SAMICoreNuiParameterType r126 = new SAMICoreNuiParameterType("AEC_BIT_DEPTH", 26, 10504);
        AEC_BIT_DEPTH = r126;
        SAMICoreNuiParameterType r127 = new SAMICoreNuiParameterType("AEC_DEBUG", 27, 10505);
        AEC_DEBUG = r127;
        SAMICoreNuiParameterType r128 = new SAMICoreNuiParameterType("KWS_ENABLE", 28, 10600);
        KWS_ENABLE = r128;
        SAMICoreNuiParameterType r129 = new SAMICoreNuiParameterType("KWS_WAKEUP_MODE", 29, 10601);
        KWS_WAKEUP_MODE = r129;
        SAMICoreNuiParameterType r130 = new SAMICoreNuiParameterType("KWS_MODEL", 30, 10602);
        KWS_MODEL = r130;
        SAMICoreNuiParameterType r131 = new SAMICoreNuiParameterType("KWS_MODEL_TYPE", 31, 10603);
        KWS_MODEL_TYPE = r131;
        SAMICoreNuiParameterType r132 = new SAMICoreNuiParameterType("KWS_KEY_WORDS", 32, 10604);
        KWS_KEY_WORDS = r132;
        SAMICoreNuiParameterType r133 = new SAMICoreNuiParameterType("KWS_SAMPLE_RATE", 33, 10605);
        KWS_SAMPLE_RATE = r133;
        SAMICoreNuiParameterType r134 = new SAMICoreNuiParameterType("KWS_CHANNEL", 34, 10606);
        KWS_CHANNEL = r134;
        SAMICoreNuiParameterType r135 = new SAMICoreNuiParameterType("KWS_BIT_DEPTH", 35, 10607);
        KWS_BIT_DEPTH = r135;
        SAMICoreNuiParameterType r136 = new SAMICoreNuiParameterType("KWS_THRESHOLD", 36, 10608);
        KWS_THRESHOLD = r136;
        SAMICoreNuiParameterType r137 = new SAMICoreNuiParameterType("KWS_DEBUG", 37, 10609);
        KWS_DEBUG = r137;
        SAMICoreNuiParameterType r138 = new SAMICoreNuiParameterType("ASR_ONLINE_ENABLE", 38, 10700);
        ASR_ONLINE_ENABLE = r138;
        SAMICoreNuiParameterType r139 = new SAMICoreNuiParameterType("ASR_ONLINE_SAMPLE_RATE", 39, 10701);
        ASR_ONLINE_SAMPLE_RATE = r139;
        SAMICoreNuiParameterType r140 = new SAMICoreNuiParameterType("ASR_ONLINE_CHANNEL", 40, 10702);
        ASR_ONLINE_CHANNEL = r140;
        SAMICoreNuiParameterType r141 = new SAMICoreNuiParameterType("ASR_ONLINE_BIT_DEPTH", 41, 10703);
        ASR_ONLINE_BIT_DEPTH = r141;
        SAMICoreNuiParameterType r142 = new SAMICoreNuiParameterType("ASR_ONLINE_SOS_SILENCE_TIMEOUT", 42, 10704);
        ASR_ONLINE_SOS_SILENCE_TIMEOUT = r142;
        SAMICoreNuiParameterType r143 = new SAMICoreNuiParameterType("ASR_ONLINE_EOS_SILENCE_TIMEOUT", 43, 10705);
        ASR_ONLINE_EOS_SILENCE_TIMEOUT = r143;
        SAMICoreNuiParameterType r144 = new SAMICoreNuiParameterType("ASR_ONLINE_ENABLE_PUNCTUATION", 44, 10706);
        ASR_ONLINE_ENABLE_PUNCTUATION = r144;
        SAMICoreNuiParameterType r145 = new SAMICoreNuiParameterType("ASR_ONLINE_LANG", 45, 10707);
        ASR_ONLINE_LANG = r145;
        SAMICoreNuiParameterType r146 = new SAMICoreNuiParameterType("ASR_ONLINE_DEBUG", 46, 10708);
        ASR_ONLINE_DEBUG = r146;
        SAMICoreNuiParameterType r147 = new SAMICoreNuiParameterType("TTS_ONLINE_ENABLE", 47, 10800);
        TTS_ONLINE_ENABLE = r147;
        SAMICoreNuiParameterType r148 = new SAMICoreNuiParameterType("TTS_ONLINE_SPEAKER", 48, 10801);
        TTS_ONLINE_SPEAKER = r148;
        SAMICoreNuiParameterType r149 = new SAMICoreNuiParameterType("TTS_ONLINE_SAMPLE_RATE", 49, 10802);
        TTS_ONLINE_SAMPLE_RATE = r149;
        SAMICoreNuiParameterType r150 = new SAMICoreNuiParameterType("TTS_ONLINE_FORMAT", 50, 10803);
        TTS_ONLINE_FORMAT = r150;
        SAMICoreNuiParameterType r151 = new SAMICoreNuiParameterType("TTS_ONLINE_SPEECH_RATE", 51, 10804);
        TTS_ONLINE_SPEECH_RATE = r151;
        SAMICoreNuiParameterType r152 = new SAMICoreNuiParameterType("TTS_ONLINE_PITCH_RATE", 52, 10805);
        TTS_ONLINE_PITCH_RATE = r152;
        SAMICoreNuiParameterType r153 = new SAMICoreNuiParameterType("TTS_ONLINE_DEBUG", 53, 10806);
        TTS_ONLINE_DEBUG = r153;
        SAMICoreNuiParameterType r154 = new SAMICoreNuiParameterType("NLU_ENABLE", 54, 10900);
        NLU_ENABLE = r154;
        SAMICoreNuiParameterType r155 = new SAMICoreNuiParameterType("NLU_DEBUG", 55, 10901);
        NLU_DEBUG = r155;
        f384368a = new SAMICoreNuiParameterType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155};
        intToEnumMap = new HashMap();
        SAMICoreNuiParameterType[] r156 = values();
        int r157 = r156.length;
        int r158 = 0;
    L3:
        if (r158 >= r157) goto L5;
        SAMICoreNuiParameterType r159 = r156[r158];
        intToEnumMap.put(Integer.valueOf(r159.getValue()), r159);
        r158 = r158 + 1;
        goto L3
    }

    public static SAMICoreNuiParameterType[] values() {
        return (SAMICoreNuiParameterType[]) f384368a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static SAMICoreNuiParameterType fromInt(int r100) {
        return intToEnumMap.get(Integer.valueOf(r100));
    }

    public static SAMICoreNuiParameterType valueOf(String r100) {
        return (SAMICoreNuiParameterType) a.a(SAMICoreNuiParameterType.class, r100);
    }

    public SAMICoreNuiParameterType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
