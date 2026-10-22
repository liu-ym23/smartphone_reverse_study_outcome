package com.ss.android.socialbase.downloader.exception;

import r27.a;

/* JADX INFO: loaded from: classes6.dex */
public final enum RetryCheckStatus extends Enum<RetryCheckStatus> {
    private static final /* synthetic */ RetryCheckStatus[] $VALUES = null;
    public static final RetryCheckStatus CONTINUE = null;
    public static final RetryCheckStatus RETURN = null;

    static {
        RetryCheckStatus r100 = new RetryCheckStatus("RETURN", 0);
        RETURN = r100;
        RetryCheckStatus r101 = new RetryCheckStatus("CONTINUE", 1);
        CONTINUE = r101;
        $VALUES = new RetryCheckStatus[]{r100, r101};
    }

    public static RetryCheckStatus[] values() {
        return (RetryCheckStatus[]) $VALUES.clone();
    }

    public static RetryCheckStatus valueOf(String r100) {
        return (RetryCheckStatus) a.a(RetryCheckStatus.class, r100);
    }

    private RetryCheckStatus(String r100, int r101) {
        super(r100, r101);
    }
}
