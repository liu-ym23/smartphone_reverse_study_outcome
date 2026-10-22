package com.bytedance.router.listener.error;

import r27.a;

/* JADX INFO: loaded from: classes21.dex */
public final enum ErrorType extends Enum<ErrorType> {
    public static final ErrorType EXCEPTION = null;
    public static final ErrorType INTERCEPT = null;
    public static final ErrorType NOTFOUND = null;
    public static final ErrorType PARAMERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ErrorType[] f267558a = null;

    static {
        ErrorType r100 = new ErrorType("PARAMERROR", 0);
        PARAMERROR = r100;
        ErrorType r101 = new ErrorType("NOTFOUND", 1);
        NOTFOUND = r101;
        ErrorType r102 = new ErrorType("EXCEPTION", 2);
        EXCEPTION = r102;
        ErrorType r103 = new ErrorType("INTERCEPT", 3);
        INTERCEPT = r103;
        f267558a = new ErrorType[]{r100, r101, r102, r103};
    }

    public static ErrorType[] values() {
        return (ErrorType[]) f267558a.clone();
    }

    public static ErrorType valueOf(String r100) {
        return (ErrorType) a.a(ErrorType.class, r100);
    }

    public ErrorType(String r100, int r101) {
        super(r100, r101);
    }
}
