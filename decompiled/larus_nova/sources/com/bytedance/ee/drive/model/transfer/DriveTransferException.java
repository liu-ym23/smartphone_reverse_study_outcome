package com.bytedance.ee.drive.model.transfer;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/drive/model/transfer/DriveTransferException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "errorCode", "", "errorMsg", "", "cause", "", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "getErrorCode", "()I", "drive-model_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DriveTransferException extends RuntimeException {
    private final int errorCode;

    public final int getErrorCode() {
        return this.errorCode;
    }

    public DriveTransferException(int r100, String r101, Throwable r102) {
        super(r101, r102);
        this.errorCode = r100;
    }

    public /* synthetic */ DriveTransferException(int r100, String r101, Throwable r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102);
    }
}
