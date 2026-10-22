package com.mammon.samicorenui;

import java.util.HashMap;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum SAMICoreNuiDirectiveType extends Enum<SAMICoreNuiDirectiveType> {
    public static final SAMICoreNuiDirectiveType DIRECTIVE_CANCEL_CURRENT_DIALOG = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_FINISH_TALKING = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_PLAYING_DECISION = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_PLAY_SSML_TTS = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_PLAY_TTS = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_START_ENGINE = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_STOP_ENGINE = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_SYNC_STOP_ENGINE = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_TEST_BOE_ASR = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_TEST_LONG_ASR_START = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_TEST_LONG_ASR_STOP = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_TEST_ONLINE_ASR = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_TEST_SET_AEC_MODEL_PATH = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_TEST_SET_ENABLE_Punctuation = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_TEST_SET_WAKEUP_TEST_AUDIO_FILE = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_TEST_SET_WAKEUP_THRESHOLD = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_TEST_SET_WAKEUP_TTS_THRESHOLD = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_TEST_USE_LOCAL_AUDIO_FILE = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_TEST_WAKEUP = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_TRIGGER_WAKEUP = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_TRIGGER_WAKEUP_FOR_TTS = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_USE_KWS_MODE = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_USE_MODE1 = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_USE_MODE2 = null;
    public static final SAMICoreNuiDirectiveType DIRECTIVE_USE_WAKEUP_MODE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SAMICoreNuiDirectiveType[] f384366a = null;
    public static final HashMap<Integer, SAMICoreNuiDirectiveType> intToEnumMap = null;
    private int value;

    static {
        SAMICoreNuiDirectiveType r100 = new SAMICoreNuiDirectiveType("DIRECTIVE_START_ENGINE", 0, 0);
        DIRECTIVE_START_ENGINE = r100;
        SAMICoreNuiDirectiveType r101 = new SAMICoreNuiDirectiveType("DIRECTIVE_STOP_ENGINE", 1, 1);
        DIRECTIVE_STOP_ENGINE = r101;
        SAMICoreNuiDirectiveType r102 = new SAMICoreNuiDirectiveType("DIRECTIVE_SYNC_STOP_ENGINE", 2, 2);
        DIRECTIVE_SYNC_STOP_ENGINE = r102;
        SAMICoreNuiDirectiveType r103 = new SAMICoreNuiDirectiveType("DIRECTIVE_PLAYING_DECISION", 3, 3);
        DIRECTIVE_PLAYING_DECISION = r103;
        SAMICoreNuiDirectiveType r104 = new SAMICoreNuiDirectiveType("DIRECTIVE_TRIGGER_WAKEUP", 4, 4);
        DIRECTIVE_TRIGGER_WAKEUP = r104;
        SAMICoreNuiDirectiveType r105 = new SAMICoreNuiDirectiveType("DIRECTIVE_CANCEL_CURRENT_DIALOG", 5, 5);
        DIRECTIVE_CANCEL_CURRENT_DIALOG = r105;
        SAMICoreNuiDirectiveType r110 = new SAMICoreNuiDirectiveType("DIRECTIVE_FINISH_TALKING", 6, 6);
        DIRECTIVE_FINISH_TALKING = r110;
        SAMICoreNuiDirectiveType r111 = new SAMICoreNuiDirectiveType("DIRECTIVE_TRIGGER_WAKEUP_FOR_TTS", 7, 7);
        DIRECTIVE_TRIGGER_WAKEUP_FOR_TTS = r111;
        SAMICoreNuiDirectiveType r112 = new SAMICoreNuiDirectiveType("DIRECTIVE_PLAY_TTS", 8, 8);
        DIRECTIVE_PLAY_TTS = r112;
        SAMICoreNuiDirectiveType r113 = new SAMICoreNuiDirectiveType("DIRECTIVE_PLAY_SSML_TTS", 9, 9);
        DIRECTIVE_PLAY_SSML_TTS = r113;
        SAMICoreNuiDirectiveType r114 = new SAMICoreNuiDirectiveType("DIRECTIVE_USE_MODE1", 10, 10);
        DIRECTIVE_USE_MODE1 = r114;
        SAMICoreNuiDirectiveType r115 = new SAMICoreNuiDirectiveType("DIRECTIVE_USE_MODE2", 11, 11);
        DIRECTIVE_USE_MODE2 = r115;
        SAMICoreNuiDirectiveType r106 = new SAMICoreNuiDirectiveType("DIRECTIVE_USE_WAKEUP_MODE", 12, 12);
        DIRECTIVE_USE_WAKEUP_MODE = r106;
        SAMICoreNuiDirectiveType r107 = new SAMICoreNuiDirectiveType("DIRECTIVE_USE_KWS_MODE", 13, 13);
        DIRECTIVE_USE_KWS_MODE = r107;
        SAMICoreNuiDirectiveType r108 = new SAMICoreNuiDirectiveType("DIRECTIVE_TEST_WAKEUP", 14, 14);
        DIRECTIVE_TEST_WAKEUP = r108;
        SAMICoreNuiDirectiveType r109 = new SAMICoreNuiDirectiveType("DIRECTIVE_TEST_USE_LOCAL_AUDIO_FILE", 15, 15);
        DIRECTIVE_TEST_USE_LOCAL_AUDIO_FILE = r109;
        SAMICoreNuiDirectiveType r116 = new SAMICoreNuiDirectiveType("DIRECTIVE_TEST_LONG_ASR_START", 16, 16);
        DIRECTIVE_TEST_LONG_ASR_START = r116;
        SAMICoreNuiDirectiveType r117 = new SAMICoreNuiDirectiveType("DIRECTIVE_TEST_LONG_ASR_STOP", 17, 17);
        DIRECTIVE_TEST_LONG_ASR_STOP = r117;
        SAMICoreNuiDirectiveType r118 = new SAMICoreNuiDirectiveType("DIRECTIVE_TEST_BOE_ASR", 18, 18);
        DIRECTIVE_TEST_BOE_ASR = r118;
        SAMICoreNuiDirectiveType r119 = new SAMICoreNuiDirectiveType("DIRECTIVE_TEST_ONLINE_ASR", 19, 19);
        DIRECTIVE_TEST_ONLINE_ASR = r119;
        SAMICoreNuiDirectiveType r120 = new SAMICoreNuiDirectiveType("DIRECTIVE_TEST_SET_WAKEUP_THRESHOLD", 20, 20);
        DIRECTIVE_TEST_SET_WAKEUP_THRESHOLD = r120;
        SAMICoreNuiDirectiveType r121 = new SAMICoreNuiDirectiveType("DIRECTIVE_TEST_SET_WAKEUP_TTS_THRESHOLD", 21, 21);
        DIRECTIVE_TEST_SET_WAKEUP_TTS_THRESHOLD = r121;
        SAMICoreNuiDirectiveType r122 = new SAMICoreNuiDirectiveType("DIRECTIVE_TEST_SET_AEC_MODEL_PATH", 22, 22);
        DIRECTIVE_TEST_SET_AEC_MODEL_PATH = r122;
        SAMICoreNuiDirectiveType r123 = new SAMICoreNuiDirectiveType("DIRECTIVE_TEST_SET_ENABLE_Punctuation", 23, 23);
        DIRECTIVE_TEST_SET_ENABLE_Punctuation = r123;
        SAMICoreNuiDirectiveType r124 = new SAMICoreNuiDirectiveType("DIRECTIVE_TEST_SET_WAKEUP_TEST_AUDIO_FILE", 24, 24);
        DIRECTIVE_TEST_SET_WAKEUP_TEST_AUDIO_FILE = r124;
        f384366a = new SAMICoreNuiDirectiveType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124};
        intToEnumMap = new HashMap();
        SAMICoreNuiDirectiveType[] r125 = values();
        int r126 = r125.length;
        int r127 = 0;
    L3:
        if (r127 >= r126) goto L5;
        SAMICoreNuiDirectiveType r128 = r125[r127];
        intToEnumMap.put(Integer.valueOf(r128.getValue()), r128);
        r127 = r127 + 1;
        goto L3
    }

    public static SAMICoreNuiDirectiveType[] values() {
        return (SAMICoreNuiDirectiveType[]) f384366a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static SAMICoreNuiDirectiveType fromInt(int r100) {
        return intToEnumMap.get(Integer.valueOf(r100));
    }

    public static SAMICoreNuiDirectiveType valueOf(String r100) {
        return (SAMICoreNuiDirectiveType) a.a(SAMICoreNuiDirectiveType.class, r100);
    }

    public SAMICoreNuiDirectiveType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
