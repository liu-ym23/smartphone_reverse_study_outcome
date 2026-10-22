package com.bytedance.ee.drive.model.transfer;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/drive/model/transfer/EDriveTransferError;", "", "", "errorMsg", "", "cause", "Lcom/bytedance/ee/drive/model/transfer/DriveTransferException;", "toException", "", "codeNum", "I", "getCodeNum", "()I", "UNDEFINED", "TRANSFER_QUEUE_DESTROYED", "TRANSFER_TASK_EXISTED", "REMOTE_URL_INVALID", "LOCAL_FILE_INVALID", "LOCAL_FILE_WRITE_FAILED", "TRANSFER_REQUEST_FAILED", "TRANSFER_RESPONSE_FAILED", "drive-model_release"}, k = 1, mv = {1, 7, 1})
public final enum EDriveTransferError extends Enum<EDriveTransferError> {
    public static final EDriveTransferError LOCAL_FILE_INVALID = null;
    public static final EDriveTransferError LOCAL_FILE_WRITE_FAILED = null;
    public static final EDriveTransferError REMOTE_URL_INVALID = null;
    public static final EDriveTransferError TRANSFER_QUEUE_DESTROYED = null;
    public static final EDriveTransferError TRANSFER_REQUEST_FAILED = null;
    public static final EDriveTransferError TRANSFER_RESPONSE_FAILED = null;
    public static final EDriveTransferError TRANSFER_TASK_EXISTED = null;
    public static final EDriveTransferError UNDEFINED = null;
    public static final /* synthetic */ EDriveTransferError[] a = null;
    private final int codeNum;

    public static EDriveTransferError valueOf(String r1) {
        return (EDriveTransferError) a.a(EDriveTransferError.class, r1);
    }

    public static EDriveTransferError[] values() {
        return (EDriveTransferError[]) a.clone();
    }

    static {
        EDriveTransferError r0 = new EDriveTransferError("UNDEFINED", 0, 0);
        UNDEFINED = r0;
        EDriveTransferError r1 = new EDriveTransferError("TRANSFER_QUEUE_DESTROYED", 1, -110);
        TRANSFER_QUEUE_DESTROYED = r1;
        EDriveTransferError r3 = new EDriveTransferError("TRANSFER_TASK_EXISTED", 2, -120);
        TRANSFER_TASK_EXISTED = r3;
        EDriveTransferError r4 = new EDriveTransferError("REMOTE_URL_INVALID", 3, -130);
        REMOTE_URL_INVALID = r4;
        EDriveTransferError r6 = new EDriveTransferError("LOCAL_FILE_INVALID", 4, -140);
        LOCAL_FILE_INVALID = r6;
        EDriveTransferError r8 = new EDriveTransferError("LOCAL_FILE_WRITE_FAILED", 5, -141);
        LOCAL_FILE_WRITE_FAILED = r8;
        EDriveTransferError r10 = new EDriveTransferError("TRANSFER_REQUEST_FAILED", 6, -160);
        TRANSFER_REQUEST_FAILED = r10;
        EDriveTransferError r12 = new EDriveTransferError("TRANSFER_RESPONSE_FAILED", 7, -170);
        TRANSFER_RESPONSE_FAILED = r12;
        a = new EDriveTransferError[]{r0, r1, r3, r4, r6, r8, r10, r12};
    }

    public final int getCodeNum() {
        return this.codeNum;
    }

    public final DriveTransferException toException(String r3, Throwable r4) {
        return new DriveTransferException(this.codeNum, r3, r4);
    }

    public EDriveTransferError(String r1, int r2, int r3) {
        super(r1, r2);
        this.codeNum = r3;
    }

    public static /* synthetic */ DriveTransferException toException$default(EDriveTransferError r1, String r2, Throwable r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 1) == 0) goto L7;
        r2 = null;
    L7:
        if ((r4 & 2) == 0) goto L10;
        r3 = null;
    L10:
        return r1.toException(r2, r3);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toException");
    }
}
