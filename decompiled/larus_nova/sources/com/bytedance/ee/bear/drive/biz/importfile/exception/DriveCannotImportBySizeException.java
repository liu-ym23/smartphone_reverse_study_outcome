package com.bytedance.ee.bear.drive.biz.importfile.exception;

import f85.a;

/* JADX INFO: loaded from: classes16.dex */
public class DriveCannotImportBySizeException extends DriveImportBaseException {
    private a mFileModel;

    public a getFileModel() {
        return this.mFileModel;
    }

    public DriveCannotImportBySizeException(a r100) {
        this.mFileModel = r100;
    }
}
