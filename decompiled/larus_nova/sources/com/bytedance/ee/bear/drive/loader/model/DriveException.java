package com.bytedance.ee.bear.drive.loader.model;

/* JADX INFO: loaded from: classes16.dex */
public final class DriveException extends Exception {
    private final ErrCode errorCode;
    private Object extra;

    @Override // java.lang.Throwable
    public String toString() {
        String r100 = String.format("%s[%s]", new Object[]{"DriveException", this.errorCode.name()});
        String r101 = getLocalizedMessage();
        if (r101 != null) goto L5;
        return r100;
    L5:
        return r100 + ": " + r101;
    }

    public ErrCode getErrorCode() {
        return this.errorCode;
    }

    public Object getExtra() {
        return this.extra;
    }

    public DriveException(ErrCode r100) {
        this.errorCode = r100;
    }

    public void setExtra(Object r100) {
        this.extra = r100;
    }

    public DriveException(ErrCode r100, Object r101) {
        this.errorCode = r100;
        this.extra = r101;
    }

    public DriveException(ErrCode r100, String r101) {
        super(r101);
        this.errorCode = r100;
    }

    public DriveException(ErrCode r100, Throwable r101) {
        this(r100, null, r101);
    }

    public DriveException(ErrCode r100, String r101, Object r102) {
        super(r101);
        this.errorCode = r100;
        this.extra = r102;
    }

    public DriveException(ErrCode r100, String r101, Throwable r102) {
        super(r101, r102);
        this.errorCode = r100;
    }

    public DriveException(ErrCode r100, String r101, Throwable r102, Object r103) {
        super(r101, r102);
        this.errorCode = r100;
        this.extra = r103;
    }
}
