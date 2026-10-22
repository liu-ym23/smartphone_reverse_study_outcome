package com.ss.bytertc.engine.live;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MixedStreamTaskErrorCode extends Enum<MixedStreamTaskErrorCode> {
    private static final /* synthetic */ MixedStreamTaskErrorCode[] $VALUES = null;
    public static final MixedStreamTaskErrorCode AUTHENTICATION_BY_CDN = null;
    public static final MixedStreamTaskErrorCode BASE = null;
    public static final MixedStreamTaskErrorCode INVALID_PARAM_BY_SERVER = null;
    public static final MixedStreamTaskErrorCode INVALID_STATE_BY_SERVER = null;
    public static final MixedStreamTaskErrorCode MAX = null;
    public static final MixedStreamTaskErrorCode MIX_IMAGE_FAIL = null;
    public static final MixedStreamTaskErrorCode OK = null;
    public static final MixedStreamTaskErrorCode PUSH_WTN_FAILED = null;
    public static final MixedStreamTaskErrorCode SIGNAL_REQUEST_TIMEOUT = null;
    public static final MixedStreamTaskErrorCode STREAM_SYNC_WORSE = null;
    public static final MixedStreamTaskErrorCode SUB_TIMEOUT_BY_SERVER = null;
    public static final MixedStreamTaskErrorCode TIMEOUT = null;
    public static final MixedStreamTaskErrorCode UNKNOWN_BY_SERVER = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.live.MixedStreamTaskErrorCode$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode = null;

        static {
            int[] r100 = new int[MixedStreamTaskErrorCode.values().length];
            $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode = r100;
            r100[MixedStreamTaskErrorCode.OK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L34:
            $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode[MixedStreamTaskErrorCode.BASE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L40:
            $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode[MixedStreamTaskErrorCode.TIMEOUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L54:
            $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode[MixedStreamTaskErrorCode.INVALID_PARAM_BY_SERVER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L36:
            $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode[MixedStreamTaskErrorCode.SUB_TIMEOUT_BY_SERVER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L42:
            $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode[MixedStreamTaskErrorCode.INVALID_STATE_BY_SERVER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L46:
            $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode[MixedStreamTaskErrorCode.AUTHENTICATION_BY_CDN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L50:
            $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode[MixedStreamTaskErrorCode.UNKNOWN_BY_SERVER.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L32:
            $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode[MixedStreamTaskErrorCode.SIGNAL_REQUEST_TIMEOUT.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L38:
            $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode[MixedStreamTaskErrorCode.MIX_IMAGE_FAIL.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L44:
            $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode[MixedStreamTaskErrorCode.STREAM_SYNC_WORSE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L48:
            $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode[MixedStreamTaskErrorCode.PUSH_WTN_FAILED.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L30:
            $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode[MixedStreamTaskErrorCode.MAX.ordinal()] = 13;     // Catch: NoSuchFieldError -> L29
            return;
        }
    }

    static {
        MixedStreamTaskErrorCode r100 = new MixedStreamTaskErrorCode("OK", 0, 0);
        OK = r100;
        MixedStreamTaskErrorCode r101 = new MixedStreamTaskErrorCode("BASE", 1, 1090);
        BASE = r101;
        MixedStreamTaskErrorCode r102 = new MixedStreamTaskErrorCode("TIMEOUT", 2, 1091);
        TIMEOUT = r102;
        MixedStreamTaskErrorCode r103 = new MixedStreamTaskErrorCode("INVALID_PARAM_BY_SERVER", 3, 1092);
        INVALID_PARAM_BY_SERVER = r103;
        MixedStreamTaskErrorCode r104 = new MixedStreamTaskErrorCode("SUB_TIMEOUT_BY_SERVER", 4, 1093);
        SUB_TIMEOUT_BY_SERVER = r104;
        MixedStreamTaskErrorCode r105 = new MixedStreamTaskErrorCode("INVALID_STATE_BY_SERVER", 5, 1094);
        INVALID_STATE_BY_SERVER = r105;
        MixedStreamTaskErrorCode r110 = new MixedStreamTaskErrorCode("AUTHENTICATION_BY_CDN", 6, 1095);
        AUTHENTICATION_BY_CDN = r110;
        MixedStreamTaskErrorCode r111 = new MixedStreamTaskErrorCode("UNKNOWN_BY_SERVER", 7, 1096);
        UNKNOWN_BY_SERVER = r111;
        MixedStreamTaskErrorCode r112 = new MixedStreamTaskErrorCode("SIGNAL_REQUEST_TIMEOUT", 8, 1097);
        SIGNAL_REQUEST_TIMEOUT = r112;
        MixedStreamTaskErrorCode r113 = new MixedStreamTaskErrorCode("MIX_IMAGE_FAIL", 9, 1098);
        MIX_IMAGE_FAIL = r113;
        MixedStreamTaskErrorCode r114 = new MixedStreamTaskErrorCode("STREAM_SYNC_WORSE", 10, 1099);
        STREAM_SYNC_WORSE = r114;
        MixedStreamTaskErrorCode r106 = new MixedStreamTaskErrorCode("PUSH_WTN_FAILED", 11, 1195);
        PUSH_WTN_FAILED = r106;
        MixedStreamTaskErrorCode r107 = new MixedStreamTaskErrorCode("MAX", 12, 1199);
        MAX = r107;
        $VALUES = new MixedStreamTaskErrorCode[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107};
    }

    public static MixedStreamTaskErrorCode[] values() {
        return (MixedStreamTaskErrorCode[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskErrorCode[ordinal()]) {
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
        return "MAX";
    L6:
        return "PUSH_WTN_FAILED";
    L7:
        return "STREAM_SYNC_WORSE";
    L8:
        return "MIX_IMAGE_FAIL";
    L9:
        return "SIGNAL_REQUEST_TIMEOUT";
    L10:
        return "UNKNOWN_BY_SERVER";
    L11:
        return "AUTHENTICATION_BY_CDN";
    L12:
        return "INVALID_STATE_BY_SERVER";
    L13:
        return "SUB_TIMEOUT_BY_SERVER";
    L14:
        return "INVALID_PARAM_BY_SERVER";
    L15:
        return "TIMEOUT";
    L16:
        return "BASE";
    L17:
        return "OK";
    }

    public int value() {
        return this.value;
    }

    public static MixedStreamTaskErrorCode fromId(int r100) {
        MixedStreamTaskErrorCode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        MixedStreamTaskErrorCode r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static MixedStreamTaskErrorCode valueOf(String r100) {
        return (MixedStreamTaskErrorCode) a.a(MixedStreamTaskErrorCode.class, r100);
    }

    private MixedStreamTaskErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
