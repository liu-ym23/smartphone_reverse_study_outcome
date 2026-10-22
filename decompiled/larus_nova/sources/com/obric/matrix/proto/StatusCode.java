package com.obric.matrix.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.ss.videoarch.liveplayer.log.LiveError;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
public final enum StatusCode extends Enum<StatusCode> implements WireEnum {
    private static final /* synthetic */ StatusCode[] $VALUES = null;
    public static final ProtoAdapter<StatusCode> ADAPTER = null;
    public static final StatusCode API_NO_PERMISSION = null;
    public static final StatusCode CMD_NOT_SUPPORT = null;
    public static final StatusCode ERROR_UNKNOW = null;
    public static final StatusCode ILLEGAL_REQUEST_PARAM = null;
    public static final StatusCode INVALID_APPKEY = null;
    public static final StatusCode OK = null;
    public static final StatusCode REQUEST_BODY_IS_NULL = null;
    public static final StatusCode REQUEST_DATA_PARSE_ERROR = null;
    public static final StatusCode USER_NO_LOGIN = null;
    private final int value;

    static {
        StatusCode r100 = new StatusCode("OK", 0, 0);
        OK = r100;
        StatusCode r101 = new StatusCode("INVALID_APPKEY", 1, -100001);
        INVALID_APPKEY = r101;
        StatusCode r102 = new StatusCode("USER_NO_LOGIN", 2, LiveError.PLAYER_DATASOURCE);
        USER_NO_LOGIN = r102;
        StatusCode r103 = new StatusCode("REQUEST_BODY_IS_NULL", 3, LiveError.PLAYER_INTERNAL);
        REQUEST_BODY_IS_NULL = r103;
        StatusCode r104 = new StatusCode("ERROR_UNKNOW", 4, LiveError.RESPONSE_ERROR);
        ERROR_UNKNOW = r104;
        StatusCode r105 = new StatusCode("REQUEST_DATA_PARSE_ERROR", 5, LiveError.LIVE_DATA_EMPTY);
        REQUEST_DATA_PARSE_ERROR = r105;
        StatusCode r110 = new StatusCode("CMD_NOT_SUPPORT", 6, LiveError.LIVE_API_URL_INVALID);
        CMD_NOT_SUPPORT = r110;
        StatusCode r111 = new StatusCode("API_NO_PERMISSION", 7, LiveError.STALL_RETRY_TIMEOUT);
        API_NO_PERMISSION = r111;
        StatusCode r112 = new StatusCode("ILLEGAL_REQUEST_PARAM", 8, LiveError.NETWORK_IO_ERROR);
        ILLEGAL_REQUEST_PARAM = r112;
        $VALUES = new StatusCode[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
        ADAPTER = new ProtoAdapter_StatusCode();
    }

    public static StatusCode[] values() {
        return (StatusCode[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }

    public static StatusCode fromValue(int r100) {
        if (r100 == 0) goto L23;
        switch(r100) {
            case -100008: goto L21;
            case -100007: goto L19;
            case -100006: goto L17;
            case -100005: goto L15;
            case -100004: goto L13;
            case -100003: goto L11;
            case -100002: goto L9;
            case -100001: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return INVALID_APPKEY;
    L9:
        return USER_NO_LOGIN;
    L11:
        return REQUEST_BODY_IS_NULL;
    L13:
        return ERROR_UNKNOW;
    L15:
        return REQUEST_DATA_PARSE_ERROR;
    L17:
        return CMD_NOT_SUPPORT;
    L19:
        return API_NO_PERMISSION;
    L21:
        return ILLEGAL_REQUEST_PARAM;
    L23:
        return OK;
    }

    public static StatusCode valueOf(String r100) {
        return (StatusCode) a.a(StatusCode.class, r100);
    }

    private StatusCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
