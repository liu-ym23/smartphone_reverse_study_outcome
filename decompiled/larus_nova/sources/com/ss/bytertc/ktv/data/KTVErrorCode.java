package com.ss.bytertc.ktv.data;

import com.ss.android.download.api.config.HttpMethod;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum KTVErrorCode extends Enum<KTVErrorCode> {
    private static final /* synthetic */ KTVErrorCode[] $VALUES = null;
    public static final KTVErrorCode APPID_INVALID = null;
    public static final KTVErrorCode CLEAR_CACHE_FAILED = null;
    public static final KTVErrorCode DOWNLOAD = null;
    public static final KTVErrorCode DOWNLOADING = null;
    public static final KTVErrorCode DOWNLOAD_CANCELED = null;
    public static final KTVErrorCode DOWNLOAD_TIMEOUT = null;
    public static final KTVErrorCode FILE_RENAME_FAILED = null;
    public static final KTVErrorCode GET_LYRIC_FAILED = null;
    public static final KTVErrorCode GET_MUSIC_FAILED = null;
    public static final KTVErrorCode INSUFFICIENT_DISK_SPACE = null;
    public static final KTVErrorCode INTERNAL_DOMAIN = null;
    public static final KTVErrorCode MIDI_DOWNLOAD_FAILED = null;
    public static final KTVErrorCode MUSIC_DECRYPTION_FAILED = null;
    public static final KTVErrorCode MUSIC_DOWNLOAD = null;
    public static final KTVErrorCode MUSIC_TAKEDOWN = null;
    public static final KTVErrorCode NETWORK = null;
    public static final KTVErrorCode NOT_JOIN_ROOM = null;
    public static final KTVErrorCode OK = null;
    public static final KTVErrorCode PARAS_INVALID = null;
    public static final KTVErrorCode PARSE_DATA = null;
    public static final KTVErrorCode SYSTEM_BUSY = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.ktv.data.KTVErrorCode$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$ktv$data$KTVErrorCode = null;

        static {
            int[] r100 = new int[KTVErrorCode.values().length];
            $SwitchMap$com$ss$bytertc$ktv$data$KTVErrorCode = r100;
            r100[KTVErrorCode.OK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L72:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVErrorCode[KTVErrorCode.APPID_INVALID.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L52:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVErrorCode[KTVErrorCode.PARAS_INVALID.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L66:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVErrorCode[KTVErrorCode.GET_MUSIC_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L74:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVErrorCode[KTVErrorCode.GET_LYRIC_FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L54:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVErrorCode[KTVErrorCode.MUSIC_TAKEDOWN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L58:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVErrorCode[KTVErrorCode.MUSIC_DOWNLOAD.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
        L86:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVErrorCode[KTVErrorCode.MIDI_DOWNLOAD_FAILED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L32
        L48:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVErrorCode[KTVErrorCode.SYSTEM_BUSY.ordinal()] = 9;     // Catch: NoSuchFieldError -> L33
        L78:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVErrorCode[KTVErrorCode.NETWORK.ordinal()] = 10;     // Catch: NoSuchFieldError -> L34
        L82:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVErrorCode[KTVErrorCode.NOT_JOIN_ROOM.ordinal()] = 11;     // Catch: NoSuchFieldError -> L35
        L62:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVErrorCode[KTVErrorCode.PARSE_DATA.ordinal()] = 12;     // Catch: NoSuchFieldError -> L36
        L70:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVErrorCode[KTVErrorCode.DOWNLOAD.ordinal()] = 13;     // Catch: NoSuchFieldError -> L37
        L50:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVErrorCode[KTVErrorCode.DOWNLOADING.ordinal()] = 14;     // Catch: NoSuchFieldError -> L38
        L56:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVErrorCode[KTVErrorCode.INTERNAL_DOMAIN.ordinal()] = 15;     // Catch: NoSuchFieldError -> L39
        L84:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVErrorCode[KTVErrorCode.INSUFFICIENT_DISK_SPACE.ordinal()] = 16;     // Catch: NoSuchFieldError -> L40
        L46:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVErrorCode[KTVErrorCode.MUSIC_DECRYPTION_FAILED.ordinal()] = 17;     // Catch: NoSuchFieldError -> L41
        L76:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVErrorCode[KTVErrorCode.FILE_RENAME_FAILED.ordinal()] = 18;     // Catch: NoSuchFieldError -> L42
        L80:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVErrorCode[KTVErrorCode.DOWNLOAD_TIMEOUT.ordinal()] = 19;     // Catch: NoSuchFieldError -> L43
        L60:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVErrorCode[KTVErrorCode.CLEAR_CACHE_FAILED.ordinal()] = 20;     // Catch: NoSuchFieldError -> L44
        L68:
            $SwitchMap$com$ss$bytertc$ktv$data$KTVErrorCode[KTVErrorCode.DOWNLOAD_CANCELED.ordinal()] = 21;     // Catch: NoSuchFieldError -> L45
            return;
        }
    }

    static {
        KTVErrorCode r100 = new KTVErrorCode("OK", 0, 0);
        OK = r100;
        KTVErrorCode r101 = new KTVErrorCode("APPID_INVALID", 1, -3000);
        APPID_INVALID = r101;
        KTVErrorCode r102 = new KTVErrorCode("PARAS_INVALID", 2, -3001);
        PARAS_INVALID = r102;
        KTVErrorCode r103 = new KTVErrorCode("GET_MUSIC_FAILED", 3, -3002);
        GET_MUSIC_FAILED = r103;
        KTVErrorCode r104 = new KTVErrorCode("GET_LYRIC_FAILED", 4, -3003);
        GET_LYRIC_FAILED = r104;
        KTVErrorCode r105 = new KTVErrorCode("MUSIC_TAKEDOWN", 5, -3004);
        MUSIC_TAKEDOWN = r105;
        KTVErrorCode r110 = new KTVErrorCode("MUSIC_DOWNLOAD", 6, -3005);
        MUSIC_DOWNLOAD = r110;
        KTVErrorCode r111 = new KTVErrorCode("MIDI_DOWNLOAD_FAILED", 7, -3006);
        MIDI_DOWNLOAD_FAILED = r111;
        KTVErrorCode r112 = new KTVErrorCode("SYSTEM_BUSY", 8, -3007);
        SYSTEM_BUSY = r112;
        KTVErrorCode r113 = new KTVErrorCode("NETWORK", 9, -3008);
        NETWORK = r113;
        KTVErrorCode r114 = new KTVErrorCode("NOT_JOIN_ROOM", 10, -3009);
        NOT_JOIN_ROOM = r114;
        KTVErrorCode r106 = new KTVErrorCode("PARSE_DATA", 11, -3010);
        PARSE_DATA = r106;
        KTVErrorCode r107 = new KTVErrorCode(HttpMethod.DOWNLOAD, 12, -3011);
        DOWNLOAD = r107;
        KTVErrorCode r108 = new KTVErrorCode("DOWNLOADING", 13, -3012);
        DOWNLOADING = r108;
        KTVErrorCode r109 = new KTVErrorCode("INTERNAL_DOMAIN", 14, -3013);
        INTERNAL_DOMAIN = r109;
        KTVErrorCode r115 = new KTVErrorCode("INSUFFICIENT_DISK_SPACE", 15, -3014);
        INSUFFICIENT_DISK_SPACE = r115;
        KTVErrorCode r116 = new KTVErrorCode("MUSIC_DECRYPTION_FAILED", 16, -3015);
        MUSIC_DECRYPTION_FAILED = r116;
        KTVErrorCode r117 = new KTVErrorCode("FILE_RENAME_FAILED", 17, -3016);
        FILE_RENAME_FAILED = r117;
        KTVErrorCode r118 = new KTVErrorCode("DOWNLOAD_TIMEOUT", 18, -3017);
        DOWNLOAD_TIMEOUT = r118;
        KTVErrorCode r119 = new KTVErrorCode("CLEAR_CACHE_FAILED", 19, -3018);
        CLEAR_CACHE_FAILED = r119;
        KTVErrorCode r120 = new KTVErrorCode("DOWNLOAD_CANCELED", 20, -3019);
        DOWNLOAD_CANCELED = r120;
        $VALUES = new KTVErrorCode[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120};
    }

    public static KTVErrorCode[] values() {
        return (KTVErrorCode[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(AnonymousClass1.$SwitchMap$com$ss$bytertc$ktv$data$KTVErrorCode[ordinal()]) {
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            case 10: goto L16;
            case 11: goto L15;
            case 12: goto L14;
            case 13: goto L13;
            case 14: goto L12;
            case 15: goto L11;
            case 16: goto L10;
            case 17: goto L9;
            case 18: goto L8;
            case 19: goto L7;
            case 20: goto L6;
            case 21: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "KTV_ERROR_CODE_DOWNLOAD_CANCELED";
    L6:
        return "KTV_ERROR_CODE_CLEAR_CACHE_FAILED";
    L7:
        return "KTV_ERROR_CODE_DOWNLOAD_TIMEOUT";
    L8:
        return "KTV_ERROR_CODE_FILE_RENAME_FAILED";
    L9:
        return "KTV_ERROR_CODE_MUSIC_DECRYPTION_FAILED";
    L10:
        return "KTV_ERROR_CODE_INSUFFICIENT_DISK_SPACE";
    L11:
        return "KTV_ERROR_CODE_INTERNAL_DOMAIN";
    L12:
        return "KTV_ERROR_CODE_DOWNLOADING";
    L13:
        return "KTV_ERROR_CODE_DOWNLOAD";
    L14:
        return "KTV_ERROR_CODE_PARSE_DATA";
    L15:
        return "KTV_ERROR_CODE_NOT_JOIN_ROOM";
    L16:
        return "KTV_ERROR_CODE_NETWORK";
    L17:
        return "ERROR_CODE_KTV_SYSTEM_BUSY";
    L18:
        return "KTV_ERROR_CODE_MIDI_DOWNLOAD_FAILED";
    L19:
        return "KTV_ERROR_CODE_MUSIC_DOWNLOAD";
    L20:
        return "KTV_ERROR_CODE_MUSIC_TAKEDOWN";
    L21:
        return "KTV_ERROR_CODE_GET_LYRIC_FAILED";
    L22:
        return "KTV_ERROR_CODE_GET_MUSIC_FAILED";
    L23:
        return "KTV_ERROR_CODE_PARAS_INVALID";
    L24:
        return "KTV_ERROR_CODE_APPID_INVALID";
    L25:
        return "KTV_ERROR_CODE_OK";
    }

    public int value() {
        return this.value;
    }

    public static KTVErrorCode fromId(int r100) {
        KTVErrorCode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        KTVErrorCode r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static KTVErrorCode valueOf(String r100) {
        return (KTVErrorCode) a.a(KTVErrorCode.class, r100);
    }

    private KTVErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
