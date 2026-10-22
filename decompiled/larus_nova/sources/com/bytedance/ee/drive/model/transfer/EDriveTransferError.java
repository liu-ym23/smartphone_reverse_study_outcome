package com.bytedance.ee.drive.model.transfer;

import com.ttnet.org.chromium.net.NetError;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EDriveTransferError[] f242662a = null;
    private final int codeNum;

    public static EDriveTransferError valueOf(String r100) {
        return (EDriveTransferError) a.a(EDriveTransferError.class, r100);
    }

    public static EDriveTransferError[] values() {
        return (EDriveTransferError[]) f242662a.clone();
    }

    static {
        EDriveTransferError r100 = new EDriveTransferError("UNDEFINED", 0, 0);
        UNDEFINED = r100;
        EDriveTransferError r101 = new EDriveTransferError("TRANSFER_QUEUE_DESTROYED", 1, -110);
        TRANSFER_QUEUE_DESTROYED = r101;
        EDriveTransferError r102 = new EDriveTransferError("TRANSFER_TASK_EXISTED", 2, NetError.ERR_SOCKS_CONNECTION_FAILED);
        TRANSFER_TASK_EXISTED = r102;
        EDriveTransferError r103 = new EDriveTransferError("REMOTE_URL_INVALID", 3, NetError.ERR_PROXY_CONNECTION_FAILED);
        REMOTE_URL_INVALID = r103;
        EDriveTransferError r104 = new EDriveTransferError("LOCAL_FILE_INVALID", 4, NetError.ERR_HTTPS_PROXY_TUNNEL_RESPONSE_REDIRECT);
        LOCAL_FILE_INVALID = r104;
        EDriveTransferError r105 = new EDriveTransferError("LOCAL_FILE_WRITE_FAILED", 5, NetError.ERR_SSL_CLIENT_AUTH_SIGNATURE_FAILED);
        LOCAL_FILE_WRITE_FAILED = r105;
        EDriveTransferError r110 = new EDriveTransferError("TRANSFER_REQUEST_FAILED", 6, NetError.ERR_SOCKET_SET_RECEIVE_BUFFER_SIZE_ERROR);
        TRANSFER_REQUEST_FAILED = r110;
        EDriveTransferError r111 = new EDriveTransferError("TRANSFER_RESPONSE_FAILED", 7, NetError.ERR_UNABLE_TO_REUSE_CONNECTION_FOR_PROXY_AUTH);
        TRANSFER_RESPONSE_FAILED = r111;
        f242662a = new EDriveTransferError[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public final int getCodeNum() {
        return this.codeNum;
    }

    public final DriveTransferException toException(String r100, Throwable r101) {
        return new DriveTransferException(this.codeNum, r100, r101);
    }

    public EDriveTransferError(String r100, int r101, int r102) {
        super(r100, r101);
        this.codeNum = r102;
    }

    public static /* synthetic */ DriveTransferException toException$default(EDriveTransferError r100, String r101, Throwable r102, int r103, Object r104) {
        if (r104 != null) goto L12;
        if ((r103 & 1) == 0) goto L7;
        r101 = null;
    L7:
        if ((r103 & 2) == 0) goto L10;
        r102 = null;
    L10:
        return r100.toException(r101, r102);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toException");
    }
}
