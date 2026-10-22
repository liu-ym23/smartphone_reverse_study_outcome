package com.bytedance.ee.bear.drive.biz.importfile.exception;

import com.bytedance.ee.bear.drive.loader.model.ErrCode;

/* JADX INFO: loaded from: classes16.dex */
public class DriveFailedImportCanSupportException extends DriveImportBaseException {
    private ErrCode mErrCode;

    public DriveFailedImportCanSupportException() {
    }

    public ErrCode getErrCode() {
        return this.mErrCode;
    }

    public DriveFailedImportCanSupportException(ErrCode r100) {
        this.mErrCode = r100;
    }
}
