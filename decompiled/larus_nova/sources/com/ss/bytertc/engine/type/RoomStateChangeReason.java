package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum RoomStateChangeReason extends Enum<RoomStateChangeReason> {
    private static final /* synthetic */ RoomStateChangeReason[] $VALUES = null;
    public static final RoomStateChangeReason DUPLICATE_LOGIN = null;
    public static final RoomStateChangeReason EXCEEDS_THE_UPPER_LIMIT = null;
    public static final RoomStateChangeReason INVALID_TOKEN = null;
    public static final RoomStateChangeReason JOIN_ROOM = null;
    public static final RoomStateChangeReason JOIN_ROOM_FAILED = null;
    public static final RoomStateChangeReason KICKED_OUT = null;
    public static final RoomStateChangeReason LEAVE_ROOM = null;
    public static final RoomStateChangeReason LICENSE_EXPIRED = null;
    public static final RoomStateChangeReason LICENSE_FILE_PATH_ERROR = null;
    public static final RoomStateChangeReason LICENSE_FUNCTION_NOT_FOUND = null;
    public static final RoomStateChangeReason LICENSE_ILLEGAL = null;
    public static final RoomStateChangeReason LICENSE_INFORMATION_NOT_MATCH = null;
    public static final RoomStateChangeReason LICENSE_NOT_MATCH_WITH_CACHE = null;
    public static final RoomStateChangeReason LICENSE_PARAMETER_ERROR = null;
    public static final RoomStateChangeReason RECONNECT = null;
    public static final RoomStateChangeReason ROOM_DISMISS = null;
    public static final RoomStateChangeReason ROOM_FORBIDDEN = null;
    public static final RoomStateChangeReason SERVER_LICENSE_EXPIRED = null;
    public static final RoomStateChangeReason STATE_ABNORMAL_SERVER_STATUS = null;
    public static final RoomStateChangeReason TOKEN_EXPIRED = null;
    public static final RoomStateChangeReason UNKNOWN = null;
    public static final RoomStateChangeReason UPDATE_TOKEN_WITH_INVALID_TOKEN = null;
    public static final RoomStateChangeReason USER_FORBIDDEN = null;
    public static final RoomStateChangeReason WITHOUT_LICENSE_AUTHENTICATE_SDK = null;
    private int value;

    static {
        RoomStateChangeReason r100 = new RoomStateChangeReason("JOIN_ROOM", 0, 0);
        JOIN_ROOM = r100;
        RoomStateChangeReason r101 = new RoomStateChangeReason("RECONNECT", 1, 1);
        RECONNECT = r101;
        RoomStateChangeReason r102 = new RoomStateChangeReason("LEAVE_ROOM", 2, 2);
        LEAVE_ROOM = r102;
        RoomStateChangeReason r103 = new RoomStateChangeReason("JOIN_ROOM_FAILED", 3, -2001);
        JOIN_ROOM_FAILED = r103;
        RoomStateChangeReason r104 = new RoomStateChangeReason("INVALID_TOKEN", 4, -1000);
        INVALID_TOKEN = r104;
        RoomStateChangeReason r105 = new RoomStateChangeReason("TOKEN_EXPIRED", 5, -1009);
        TOKEN_EXPIRED = r105;
        RoomStateChangeReason r110 = new RoomStateChangeReason("UPDATE_TOKEN_WITH_INVALID_TOKEN", 6, -1010);
        UPDATE_TOKEN_WITH_INVALID_TOKEN = r110;
        RoomStateChangeReason r111 = new RoomStateChangeReason("ROOM_FORBIDDEN", 7, -1025);
        ROOM_FORBIDDEN = r111;
        RoomStateChangeReason r112 = new RoomStateChangeReason("USER_FORBIDDEN", 8, -1026);
        USER_FORBIDDEN = r112;
        RoomStateChangeReason r113 = new RoomStateChangeReason("KICKED_OUT", 9, -1006);
        KICKED_OUT = r113;
        RoomStateChangeReason r114 = new RoomStateChangeReason("ROOM_DISMISS", 10, -1011);
        ROOM_DISMISS = r114;
        RoomStateChangeReason r106 = new RoomStateChangeReason("DUPLICATE_LOGIN", 11, -1004);
        DUPLICATE_LOGIN = r106;
        RoomStateChangeReason r107 = new RoomStateChangeReason("WITHOUT_LICENSE_AUTHENTICATE_SDK", 12, -1012);
        WITHOUT_LICENSE_AUTHENTICATE_SDK = r107;
        RoomStateChangeReason r108 = new RoomStateChangeReason("SERVER_LICENSE_EXPIRED", 13, -1017);
        SERVER_LICENSE_EXPIRED = r108;
        RoomStateChangeReason r109 = new RoomStateChangeReason("EXCEEDS_THE_UPPER_LIMIT", 14, -1018);
        EXCEEDS_THE_UPPER_LIMIT = r109;
        RoomStateChangeReason r115 = new RoomStateChangeReason("LICENSE_PARAMETER_ERROR", 15, -1019);
        LICENSE_PARAMETER_ERROR = r115;
        RoomStateChangeReason r116 = new RoomStateChangeReason("LICENSE_FILE_PATH_ERROR", 16, -1020);
        LICENSE_FILE_PATH_ERROR = r116;
        RoomStateChangeReason r117 = new RoomStateChangeReason("LICENSE_ILLEGAL", 17, -1021);
        LICENSE_ILLEGAL = r117;
        RoomStateChangeReason r118 = new RoomStateChangeReason("LICENSE_EXPIRED", 18, -1022);
        LICENSE_EXPIRED = r118;
        RoomStateChangeReason r119 = new RoomStateChangeReason("LICENSE_INFORMATION_NOT_MATCH", 19, -1023);
        LICENSE_INFORMATION_NOT_MATCH = r119;
        RoomStateChangeReason r120 = new RoomStateChangeReason("LICENSE_NOT_MATCH_WITH_CACHE", 20, -1024);
        LICENSE_NOT_MATCH_WITH_CACHE = r120;
        RoomStateChangeReason r121 = new RoomStateChangeReason("LICENSE_FUNCTION_NOT_FOUND", 21, ErrorCode.ERROR_CODE_JOIN_ROOM_LICENSE_FUNCTION_NOT_FOUND);
        LICENSE_FUNCTION_NOT_FOUND = r121;
        RoomStateChangeReason r122 = new RoomStateChangeReason("STATE_ABNORMAL_SERVER_STATUS", 22, ErrorCode.ERROR_CODE_ABNORMAL_SERVER_STATUS);
        STATE_ABNORMAL_SERVER_STATUS = r122;
        RoomStateChangeReason r123 = new RoomStateChangeReason("UNKNOWN", 23, -1001);
        UNKNOWN = r123;
        $VALUES = new RoomStateChangeReason[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123};
    }

    public static RoomStateChangeReason[] values() {
        return (RoomStateChangeReason[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static RoomStateChangeReason valueOf(int r100) {
        if (r100 == (-2001)) goto L70;
        if (r100 == (-1084)) goto L68;
        if (r100 == (-1006)) goto L66;
        if (r100 == (-1004)) goto L64;
        if (r100 == (-1001)) goto L62;
        if (r100 == (-1000)) goto L60;
        if (r100 == 0) goto L58;
        if (r100 == 1) goto L56;
        if (r100 == 2) goto L54;
        switch(r100) {
            case -1027: goto L52;
            case -1026: goto L50;
            case -1025: goto L48;
            case -1024: goto L46;
            case -1023: goto L44;
            case -1022: goto L42;
            case -1021: goto L40;
            case -1020: goto L38;
            case -1019: goto L36;
            case -1018: goto L34;
            case -1017: goto L32;
            default: goto L20;
        };
    L20:
        switch(r100) {
            case -1012: goto L30;
            case -1011: goto L28;
            case -1010: goto L26;
            case -1009: goto L24;
            default: goto L21;
        };
    L21:
        return null;
    L24:
        return TOKEN_EXPIRED;
    L26:
        return UPDATE_TOKEN_WITH_INVALID_TOKEN;
    L28:
        return ROOM_DISMISS;
    L30:
        return WITHOUT_LICENSE_AUTHENTICATE_SDK;
    L32:
        return SERVER_LICENSE_EXPIRED;
    L34:
        return EXCEEDS_THE_UPPER_LIMIT;
    L36:
        return LICENSE_PARAMETER_ERROR;
    L38:
        return LICENSE_FILE_PATH_ERROR;
    L40:
        return LICENSE_ILLEGAL;
    L42:
        return LICENSE_EXPIRED;
    L44:
        return LICENSE_INFORMATION_NOT_MATCH;
    L46:
        return LICENSE_NOT_MATCH_WITH_CACHE;
    L48:
        return ROOM_FORBIDDEN;
    L50:
        return USER_FORBIDDEN;
    L52:
        return LICENSE_FUNCTION_NOT_FOUND;
    L54:
        return LEAVE_ROOM;
    L56:
        return RECONNECT;
    L58:
        return JOIN_ROOM;
    L60:
        return INVALID_TOKEN;
    L62:
        return UNKNOWN;
    L64:
        return DUPLICATE_LOGIN;
    L66:
        return KICKED_OUT;
    L68:
        return STATE_ABNORMAL_SERVER_STATUS;
    L70:
        return JOIN_ROOM_FAILED;
    }

    public static RoomStateChangeReason valueOf(String r100) {
        return (RoomStateChangeReason) a.a(RoomStateChangeReason.class, r100);
    }

    private RoomStateChangeReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
