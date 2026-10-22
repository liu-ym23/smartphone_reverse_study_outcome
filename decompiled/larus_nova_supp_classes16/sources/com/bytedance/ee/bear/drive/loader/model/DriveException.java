package com.bytedance.ee.bear.drive.loader.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveException extends Exception {
    private final ErrCode errorCode;
    private Object extra;

    @Override // java.lang.Throwable
    public String toString() {
        String r0 = String.format("%s[%s]", new Object[]{"DriveException", this.errorCode.name()});
        String r1 = getLocalizedMessage();
        if (r1 != null) goto L5;
        return r0;
    L5:
        return r0 + ": " + r1;
    }

    public ErrCode getErrorCode() {
        return this.errorCode;
    }

    public Object getExtra() {
        return this.extra;
    }

    public DriveException(ErrCode r1) {
        this.errorCode = r1;
    }

    public void setExtra(Object r1) {
        this.extra = r1;
    }

    public DriveException(ErrCode r1, Object r2) {
        this.errorCode = r1;
        this.extra = r2;
    }

    public DriveException(ErrCode r1, String r2) {
        super(r2);
        this.errorCode = r1;
    }

    public DriveException(ErrCode r2, Throwable r3) {
        this(r2, null, r3);
    }

    public DriveException(ErrCode r1, String r2, Object r3) {
        super(r2);
        this.errorCode = r1;
        this.extra = r3;
    }

    public DriveException(ErrCode r1, String r2, Throwable r3) {
        super(r2, r3);
        this.errorCode = r1;
    }

    public DriveException(ErrCode r1, String r2, Throwable r3, Object r4) {
        super(r2, r3);
        this.errorCode = r1;
        this.extra = r4;
    }
}
