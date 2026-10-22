package com.mammon.samicorenui;

import java.util.HashMap;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum SAMICoreNuiMessageType extends Enum<SAMICoreNuiMessageType> {
    public static final SAMICoreNuiMessageType MESSAGE_TYPE_ASR_BEGIN = null;
    public static final SAMICoreNuiMessageType MESSAGE_TYPE_ASR_FINAL_RESULT = null;
    public static final SAMICoreNuiMessageType MESSAGE_TYPE_ASR_PARTIAL_RESULT = null;
    public static final SAMICoreNuiMessageType MESSAGE_TYPE_NLP_RESULT = null;
    public static final SAMICoreNuiMessageType MESSAGE_TYPE_TTS_AUDIO_DATA = null;
    public static final SAMICoreNuiMessageType MESSAGE_TYPE_TTS_BEGIN = null;
    public static final SAMICoreNuiMessageType MESSAGE_TYPE_TTS_END = null;
    public static final SAMICoreNuiMessageType MESSAGE_TYPE_WAKEUP_RESULT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SAMICoreNuiMessageType[] f384367a = null;
    public static final HashMap<Integer, SAMICoreNuiMessageType> intToEnumMap = null;
    private int value;

    static {
        int r100 = 0;
        SAMICoreNuiMessageType r101 = new SAMICoreNuiMessageType("MESSAGE_TYPE_WAKEUP_RESULT", 0, 0);
        MESSAGE_TYPE_WAKEUP_RESULT = r101;
        SAMICoreNuiMessageType r102 = new SAMICoreNuiMessageType("MESSAGE_TYPE_ASR_BEGIN", 1, 1);
        MESSAGE_TYPE_ASR_BEGIN = r102;
        SAMICoreNuiMessageType r103 = new SAMICoreNuiMessageType("MESSAGE_TYPE_ASR_PARTIAL_RESULT", 2, 2);
        MESSAGE_TYPE_ASR_PARTIAL_RESULT = r103;
        SAMICoreNuiMessageType r104 = new SAMICoreNuiMessageType("MESSAGE_TYPE_ASR_FINAL_RESULT", 3, 3);
        MESSAGE_TYPE_ASR_FINAL_RESULT = r104;
        SAMICoreNuiMessageType r105 = new SAMICoreNuiMessageType("MESSAGE_TYPE_TTS_BEGIN", 4, 4);
        MESSAGE_TYPE_TTS_BEGIN = r105;
        SAMICoreNuiMessageType r106 = new SAMICoreNuiMessageType("MESSAGE_TYPE_TTS_AUDIO_DATA", 5, 5);
        MESSAGE_TYPE_TTS_AUDIO_DATA = r106;
        SAMICoreNuiMessageType r110 = new SAMICoreNuiMessageType("MESSAGE_TYPE_TTS_END", 6, 6);
        MESSAGE_TYPE_TTS_END = r110;
        SAMICoreNuiMessageType r111 = new SAMICoreNuiMessageType("MESSAGE_TYPE_NLP_RESULT", 7, 7);
        MESSAGE_TYPE_NLP_RESULT = r111;
        f384367a = new SAMICoreNuiMessageType[]{r101, r102, r103, r104, r105, r106, r110, r111};
        intToEnumMap = new HashMap();
        SAMICoreNuiMessageType[] r107 = values();
        int r108 = r107.length;
    L3:
        if (r100 >= r108) goto L5;
        SAMICoreNuiMessageType r109 = r107[r100];
        intToEnumMap.put(Integer.valueOf(r109.getValue()), r109);
        r100 = r100 + 1;
        goto L3
    }

    public static SAMICoreNuiMessageType[] values() {
        return (SAMICoreNuiMessageType[]) f384367a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static SAMICoreNuiMessageType fromInt(int r100) {
        return intToEnumMap.get(Integer.valueOf(r100));
    }

    public static SAMICoreNuiMessageType valueOf(String r100) {
        return (SAMICoreNuiMessageType) a.a(SAMICoreNuiMessageType.class, r100);
    }

    public SAMICoreNuiMessageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
