package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum SubtitleErrorCode extends Enum<SubtitleErrorCode> {
    private static final /* synthetic */ SubtitleErrorCode[] $VALUES = null;
    public static final SubtitleErrorCode SUBTITLE_ERROR_CODE_ALREADY_ON = null;
    public static final SubtitleErrorCode SUBTITLE_ERROR_CODE_ASR_CONNECTION_ERROR = null;
    public static final SubtitleErrorCode SUBTITLE_ERROR_CODE_ASR_SERVICE_ERROR = null;
    public static final SubtitleErrorCode SUBTITLE_ERROR_CODE_BEFORE_JOIN_ROOM = null;
    public static final SubtitleErrorCode SUBTITLE_ERROR_CODE_POST_PROCESS_ERROR = null;
    public static final SubtitleErrorCode SUBTITLE_ERROR_CODE_POST_PROCESS_TIMEOUT = null;
    public static final SubtitleErrorCode SUBTITLE_ERROR_CODE_SUCCESS = null;
    public static final SubtitleErrorCode SUBTITLE_ERROR_CODE_UNKNOW = null;
    public static final SubtitleErrorCode SUBTITLE_ERROR_CODE_UNSUPPORTED_LANGUAGE = null;
    private int value;

    static {
        SubtitleErrorCode r100 = new SubtitleErrorCode("SUBTITLE_ERROR_CODE_UNKNOW", 0, -1);
        SUBTITLE_ERROR_CODE_UNKNOW = r100;
        SubtitleErrorCode r101 = new SubtitleErrorCode("SUBTITLE_ERROR_CODE_SUCCESS", 1, 0);
        SUBTITLE_ERROR_CODE_SUCCESS = r101;
        SubtitleErrorCode r102 = new SubtitleErrorCode("SUBTITLE_ERROR_CODE_POST_PROCESS_ERROR", 2, 1);
        SUBTITLE_ERROR_CODE_POST_PROCESS_ERROR = r102;
        SubtitleErrorCode r103 = new SubtitleErrorCode("SUBTITLE_ERROR_CODE_ASR_CONNECTION_ERROR", 3, 2);
        SUBTITLE_ERROR_CODE_ASR_CONNECTION_ERROR = r103;
        SubtitleErrorCode r104 = new SubtitleErrorCode("SUBTITLE_ERROR_CODE_ASR_SERVICE_ERROR", 4, 3);
        SUBTITLE_ERROR_CODE_ASR_SERVICE_ERROR = r104;
        SubtitleErrorCode r105 = new SubtitleErrorCode("SUBTITLE_ERROR_CODE_BEFORE_JOIN_ROOM", 5, 4);
        SUBTITLE_ERROR_CODE_BEFORE_JOIN_ROOM = r105;
        SubtitleErrorCode r110 = new SubtitleErrorCode("SUBTITLE_ERROR_CODE_ALREADY_ON", 6, 5);
        SUBTITLE_ERROR_CODE_ALREADY_ON = r110;
        SubtitleErrorCode r111 = new SubtitleErrorCode("SUBTITLE_ERROR_CODE_UNSUPPORTED_LANGUAGE", 7, 6);
        SUBTITLE_ERROR_CODE_UNSUPPORTED_LANGUAGE = r111;
        SubtitleErrorCode r112 = new SubtitleErrorCode("SUBTITLE_ERROR_CODE_POST_PROCESS_TIMEOUT", 8, 7);
        SUBTITLE_ERROR_CODE_POST_PROCESS_TIMEOUT = r112;
        $VALUES = new SubtitleErrorCode[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public static SubtitleErrorCode[] values() {
        return (SubtitleErrorCode[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static SubtitleErrorCode fromId(int r100) {
        SubtitleErrorCode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        SubtitleErrorCode r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return SUBTITLE_ERROR_CODE_UNKNOW;
    }

    public static SubtitleErrorCode valueOf(String r100) {
        return (SubtitleErrorCode) a.a(SubtitleErrorCode.class, r100);
    }

    private SubtitleErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
