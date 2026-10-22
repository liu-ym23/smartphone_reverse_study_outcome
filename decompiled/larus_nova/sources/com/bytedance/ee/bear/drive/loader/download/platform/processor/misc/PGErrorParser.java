package com.bytedance.ee.bear.drive.loader.download.platform.processor.misc;

import com.bytedance.ee.bear.drive.loader.download.platform.abs.IPreviewGetModel;
import com.bytedance.ee.bear.drive.loader.download.platform.api.ServerErrParser;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import w75.c;

/* JADX INFO: loaded from: classes16.dex */
public class PGErrorParser {
    private static final String TAG = "DrivePlatform_PGErrorHandler";

    public PGErrorParser() {
    }

    public static DriveException parseErr(IPreviewGetModel r100, c r101, Throwable r102, boolean r103) {
        if (r100 != null) goto L12;
        if (r103 == false) goto L7;
        return new DriveException(ErrCode.REQUEST_TRANSFORM_SHUTDOWN_EXP, "processor is shutdown. ", r102, r101);
    L7:
        if (ServerErrParser.isNoNetwork(r102) == false) goto L11;
        return new DriveException(ErrCode.NO_NETWORK, r102);
    L11:
        return new DriveException(ErrCode.REQUEST_PREVIEW_URL_EXP, r102);
    L12:
        int r104 = r100.getStatus();
        if (r104 == 9) goto L32;
        if (r104 == 10) goto L30;
        switch(r104) {
            case 1: goto L28;
            case 2: goto L28;
            case 3: goto L26;
            case 4: goto L30;
            case 5: goto L24;
            case 6: goto L22;
            default: goto L18;
        };
    L18:
        switch(r104) {
            case 1001: goto L30;
            case 1002: goto L30;
            case 1003: goto L30;
            default: goto L20;
        };
    L20:
        return new DriveException(ErrCode.REQUEST_TRANSFORM_UNKNOW_EXP, "unknown url server state error, status= " + r104 + " ext= " + r101.I(), r101);
    L22:
        return new DriveException(ErrCode.DRIVE_FILE_ZERO_SIZE);
    L24:
        return new DriveException(ErrCode.DRIVE_FILE_OVER_SIZE);
    L26:
        return new DriveException(ErrCode.REQUEST_TRANSFORM_SERVER_EXP, "preview url server state error, status= " + r104 + " ext= " + r101.I(), r101);
    L28:
        return new DriveException(ErrCode.REQUEST_TRANSFORM_CANCEL_EXP, "preview url server state error, status= " + r104 + " ext= " + r101.I(), r101);
    L30:
        return new DriveException(ErrCode.DRIVE_FILE_NOT_SUPPORT_PREVIEW);
    L32:
        return new DriveException(ErrCode.REQUEST_TRANSFORM_FILE_ENCRYPTION);
    }
}
