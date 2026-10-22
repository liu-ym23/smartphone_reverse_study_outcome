package com.bytedance.ee.bear.drive.loader.download.platform.processor.misc;

import com.bytedance.ee.bear.drive.loader.download.platform.abs.IPreviewGetModel;
import com.bytedance.ee.bear.drive.loader.download.platform.api.ServerErrParser;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import w75.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PGErrorParser {
    private static final String TAG = "DrivePlatform_PGErrorHandler";

    public PGErrorParser() {
    }

    public static DriveException parseErr(IPreviewGetModel r3, c r4, Throwable r5, boolean r6) {
        if (r3 != null) goto L12;
        if (r6 == false) goto L7;
        return new DriveException(ErrCode.REQUEST_TRANSFORM_SHUTDOWN_EXP, "processor is shutdown. ", r5, r4);
    L7:
        if (ServerErrParser.isNoNetwork(r5) == false) goto L11;
        return new DriveException(ErrCode.NO_NETWORK, r5);
    L11:
        return new DriveException(ErrCode.REQUEST_PREVIEW_URL_EXP, r5);
    L12:
        int r7 = r3.getStatus();
        if (r7 == 9) goto L32;
        if (r7 == 10) goto L30;
        switch(r7) {
            case 1: goto L28;
            case 2: goto L28;
            case 3: goto L26;
            case 4: goto L30;
            case 5: goto L24;
            case 6: goto L22;
            default: goto L18;
        };
    L18:
        switch(r7) {
            case 1001: goto L30;
            case 1002: goto L30;
            case 1003: goto L30;
            default: goto L20;
        };
    L20:
        return new DriveException(ErrCode.REQUEST_TRANSFORM_UNKNOW_EXP, "unknown url server state error, status= " + r7 + " ext= " + r4.I(), r4);
    L22:
        return new DriveException(ErrCode.DRIVE_FILE_ZERO_SIZE);
    L24:
        return new DriveException(ErrCode.DRIVE_FILE_OVER_SIZE);
    L26:
        return new DriveException(ErrCode.REQUEST_TRANSFORM_SERVER_EXP, "preview url server state error, status= " + r7 + " ext= " + r4.I(), r4);
    L28:
        return new DriveException(ErrCode.REQUEST_TRANSFORM_CANCEL_EXP, "preview url server state error, status= " + r7 + " ext= " + r4.I(), r4);
    L30:
        return new DriveException(ErrCode.DRIVE_FILE_NOT_SUPPORT_PREVIEW);
    L32:
        return new DriveException(ErrCode.REQUEST_TRANSFORM_FILE_ENCRYPTION);
    }
}
