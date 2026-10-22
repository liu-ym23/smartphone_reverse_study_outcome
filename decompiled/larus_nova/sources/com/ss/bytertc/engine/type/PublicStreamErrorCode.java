package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum PublicStreamErrorCode extends Enum<PublicStreamErrorCode> {
    private static final /* synthetic */ PublicStreamErrorCode[] $VALUES = null;
    public static final PublicStreamErrorCode ERROR_CODE_PULL_NO_PUSH_STREAM = null;
    public static final PublicStreamErrorCode ERROR_CODE_PUSH_ERROR = null;
    public static final PublicStreamErrorCode ERROR_CODE_PUSH_INTERNAL_ERROR = null;
    public static final PublicStreamErrorCode ERROR_CODE_PUSH_PARAM_ERROR = null;
    public static final PublicStreamErrorCode ERROR_CODE_PUSH_STATE_ERROR = null;
    public static final PublicStreamErrorCode ERROR_CODE_PUSH_TIMEOUT = null;
    public static final PublicStreamErrorCode ERROR_CODE_SUCCESS = null;
    private final int value;

    static {
        PublicStreamErrorCode r100 = new PublicStreamErrorCode("ERROR_CODE_SUCCESS", 0, 0);
        ERROR_CODE_SUCCESS = r100;
        PublicStreamErrorCode r101 = new PublicStreamErrorCode("ERROR_CODE_PUSH_PARAM_ERROR", 1, 1191);
        ERROR_CODE_PUSH_PARAM_ERROR = r101;
        PublicStreamErrorCode r102 = new PublicStreamErrorCode("ERROR_CODE_PUSH_STATE_ERROR", 2, 1192);
        ERROR_CODE_PUSH_STATE_ERROR = r102;
        PublicStreamErrorCode r103 = new PublicStreamErrorCode("ERROR_CODE_PUSH_INTERNAL_ERROR", 3, 1193);
        ERROR_CODE_PUSH_INTERNAL_ERROR = r103;
        PublicStreamErrorCode r104 = new PublicStreamErrorCode("ERROR_CODE_PUSH_ERROR", 4, 1195);
        ERROR_CODE_PUSH_ERROR = r104;
        PublicStreamErrorCode r105 = new PublicStreamErrorCode("ERROR_CODE_PUSH_TIMEOUT", 5, 1196);
        ERROR_CODE_PUSH_TIMEOUT = r105;
        PublicStreamErrorCode r110 = new PublicStreamErrorCode("ERROR_CODE_PULL_NO_PUSH_STREAM", 6, 1300);
        ERROR_CODE_PULL_NO_PUSH_STREAM = r110;
        $VALUES = new PublicStreamErrorCode[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static PublicStreamErrorCode[] values() {
        return (PublicStreamErrorCode[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static PublicStreamErrorCode fromId(int r100) {
        PublicStreamErrorCode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        PublicStreamErrorCode r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return ERROR_CODE_SUCCESS;
    }

    public static PublicStreamErrorCode valueOf(String r100) {
        return (PublicStreamErrorCode) a.a(PublicStreamErrorCode.class, r100);
    }

    private PublicStreamErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
