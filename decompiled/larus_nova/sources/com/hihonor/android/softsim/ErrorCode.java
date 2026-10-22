package com.hihonor.android.softsim;

import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final enum ErrorCode extends Enum<ErrorCode> {
    public static final ErrorCode SOFTSIM_GENERIC_ERROR = null;
    public static final ErrorCode SOFTSIM_ILLEGAL_PARAMETER = null;
    public static final ErrorCode SOFTSIM_SERVICE_NOT_READY = null;
    public static final ErrorCode SOFTSIM_SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ErrorCode[] f276471a = null;

    static {
        ErrorCode r100 = new ErrorCode("SOFTSIM_SUCCESS", 0);
        SOFTSIM_SUCCESS = r100;
        ErrorCode r101 = new ErrorCode("SOFTSIM_GENERIC_ERROR", 1);
        SOFTSIM_GENERIC_ERROR = r101;
        ErrorCode r102 = new ErrorCode("SOFTSIM_SERVICE_NOT_READY", 2);
        SOFTSIM_SERVICE_NOT_READY = r102;
        ErrorCode r103 = new ErrorCode("SOFTSIM_ILLEGAL_PARAMETER", 3);
        SOFTSIM_ILLEGAL_PARAMETER = r103;
        f276471a = new ErrorCode[]{r100, r101, r102, r103};
    }

    public static ErrorCode[] values() {
        return (ErrorCode[]) f276471a.clone();
    }

    public int getValue() {
        throw new RuntimeException("Stub!");
    }

    public static ErrorCode getErrorCode(int r100) {
        throw new RuntimeException("Stub!");
    }

    public static ErrorCode valueOf(String r100) {
        return (ErrorCode) a.a(ErrorCode.class, r100);
    }

    public ErrorCode(String r100, int r101) {
        super(r100, r101);
    }
}
