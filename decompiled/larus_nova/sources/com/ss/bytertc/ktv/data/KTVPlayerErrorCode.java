package com.ss.bytertc.ktv.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum KTVPlayerErrorCode extends Enum<KTVPlayerErrorCode> {
    private static final /* synthetic */ KTVPlayerErrorCode[] $VALUES = null;
    public static final KTVPlayerErrorCode AUDIO_TRACK_ERROR = null;
    public static final KTVPlayerErrorCode AUDIO_VOLUME_ERROR = null;
    public static final KTVPlayerErrorCode FILE_ERROR = null;
    public static final KTVPlayerErrorCode FILE_NOT_EXIST = null;
    public static final KTVPlayerErrorCode MIX_ID_ERROR = null;
    public static final KTVPlayerErrorCode NOT_JOIN_ROOM = null;
    public static final KTVPlayerErrorCode OK = null;
    public static final KTVPlayerErrorCode PARAM = null;
    public static final KTVPlayerErrorCode PITCH_ERROR = null;
    public static final KTVPlayerErrorCode POSITION_ERROR = null;
    public static final KTVPlayerErrorCode STARTING_ERROR = null;
    public static final KTVPlayerErrorCode START_ERROR = null;
    public static final KTVPlayerErrorCode TYPE_ERROR = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.ktv.data.KTVPlayerErrorCode$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$ktv$data$KTVPlayerErrorCode = null;

        static {
            int[] r100 = new int[KTVPlayerErrorCode.values().length];
            $SwitchMap$com$ss$bytertc$ktv$data$KTVPlayerErrorCode = r100;
            r100[KTVPlayerErrorCode.OK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L34:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVPlayerErrorCode[KTVPlayerErrorCode.FILE_NOT_EXIST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L40:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVPlayerErrorCode[KTVPlayerErrorCode.FILE_ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L54:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVPlayerErrorCode[KTVPlayerErrorCode.NOT_JOIN_ROOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L36:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVPlayerErrorCode[KTVPlayerErrorCode.PARAM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L42:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVPlayerErrorCode[KTVPlayerErrorCode.START_ERROR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L46:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVPlayerErrorCode[KTVPlayerErrorCode.MIX_ID_ERROR.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L50:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVPlayerErrorCode[KTVPlayerErrorCode.POSITION_ERROR.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L32:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVPlayerErrorCode[KTVPlayerErrorCode.AUDIO_VOLUME_ERROR.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L38:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVPlayerErrorCode[KTVPlayerErrorCode.TYPE_ERROR.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L44:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVPlayerErrorCode[KTVPlayerErrorCode.PITCH_ERROR.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L48:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVPlayerErrorCode[KTVPlayerErrorCode.AUDIO_TRACK_ERROR.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L30:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVPlayerErrorCode[KTVPlayerErrorCode.STARTING_ERROR.ordinal()] = 13;     // Catch: NoSuchFieldError -> L29
            return;
        }
    }

    static {
        KTVPlayerErrorCode r100 = new KTVPlayerErrorCode("OK", 0, 0);
        OK = r100;
        KTVPlayerErrorCode r101 = new KTVPlayerErrorCode("FILE_NOT_EXIST", 1, -3020);
        FILE_NOT_EXIST = r101;
        KTVPlayerErrorCode r102 = new KTVPlayerErrorCode("FILE_ERROR", 2, -3021);
        FILE_ERROR = r102;
        KTVPlayerErrorCode r103 = new KTVPlayerErrorCode("NOT_JOIN_ROOM", 3, -3022);
        NOT_JOIN_ROOM = r103;
        KTVPlayerErrorCode r104 = new KTVPlayerErrorCode("PARAM", 4, -3023);
        PARAM = r104;
        KTVPlayerErrorCode r105 = new KTVPlayerErrorCode("START_ERROR", 5, -3024);
        START_ERROR = r105;
        KTVPlayerErrorCode r110 = new KTVPlayerErrorCode("MIX_ID_ERROR", 6, -3025);
        MIX_ID_ERROR = r110;
        KTVPlayerErrorCode r111 = new KTVPlayerErrorCode("POSITION_ERROR", 7, -3026);
        POSITION_ERROR = r111;
        KTVPlayerErrorCode r112 = new KTVPlayerErrorCode("AUDIO_VOLUME_ERROR", 8, -3027);
        AUDIO_VOLUME_ERROR = r112;
        KTVPlayerErrorCode r113 = new KTVPlayerErrorCode("TYPE_ERROR", 9, -3028);
        TYPE_ERROR = r113;
        KTVPlayerErrorCode r114 = new KTVPlayerErrorCode("PITCH_ERROR", 10, -3029);
        PITCH_ERROR = r114;
        KTVPlayerErrorCode r106 = new KTVPlayerErrorCode("AUDIO_TRACK_ERROR", 11, -3030);
        AUDIO_TRACK_ERROR = r106;
        KTVPlayerErrorCode r107 = new KTVPlayerErrorCode("STARTING_ERROR", 12, -3031);
        STARTING_ERROR = r107;
        $VALUES = new KTVPlayerErrorCode[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107};
    }

    public static KTVPlayerErrorCode[] values() {
        return (KTVPlayerErrorCode[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(AnonymousClass1.$SwitchMap$com$ss$bytertc$ktv$data$KTVPlayerErrorCode[ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L7;
            case 12: goto L6;
            case 13: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "KTV_PLAYER_ERROR_CODE_STARTING_ERROR";
    L6:
        return "KTV_PLAYER_ERROR_CODE_AUDIO_TRACK_ERROR";
    L7:
        return "KTV_PLAYER_ERROR_CODE_PITCH_ERROR";
    L8:
        return "KTV_PLAYER_ERROR_CODE_TYPE_ERROR";
    L9:
        return "KTV_PLAYER_ERROR_CODE_AUDIO_VOLUME_ERROR";
    L10:
        return "KTV_PLAYER_ERROR_CODE_POSITION_ERROR";
    L11:
        return "KTV_PLAYER_ERROR_CODE_MIX_ID_ERROR";
    L12:
        return "KTV_PLAYER_ERROR_CODE_START_ERROR";
    L13:
        return "KTV_PLAYER_ERROR_CODE_PARAM";
    L14:
        return "KTV_PLAYER_ERROR_CODE_NOT_JOIN_ROOM";
    L15:
        return "KTV_PLAYER_ERROR_CODE_FILE_ERROR";
    L16:
        return "KTV_PLAYER_ERROR_CODE_FILE_NOT_EXIST";
    L17:
        return "KTV_PLAYER_ERROR_CODE_OK";
    }

    public int value() {
        return this.value;
    }

    public static KTVPlayerErrorCode fromId(int r100) {
        KTVPlayerErrorCode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        KTVPlayerErrorCode r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static KTVPlayerErrorCode valueOf(String r100) {
        return (KTVPlayerErrorCode) a.a(KTVPlayerErrorCode.class, r100);
    }

    private KTVPlayerErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
