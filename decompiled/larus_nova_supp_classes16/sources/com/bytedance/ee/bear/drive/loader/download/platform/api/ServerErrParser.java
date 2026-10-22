package com.bytedance.ee.bear.drive.loader.download.platform.api;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.PreviewStatus;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.net.CloudReqFun;
import com.bytedance.ee.eenet.httpclient.rust.exception.RustIOException;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ServerErrParser {
    private static final Pattern TTNET_UNUSABLE_CODE_PATTEN = null;

    public ServerErrParser() {
    }

    static {
        TTNET_UNUSABLE_CODE_PATTEN = PatternProtector.compile("-102|-103|-105|-118|-106|-109|-192|-193|-194|-195|-207|Timeout|Offline");
    }

    public static boolean isAuthFail(Throwable r1) {
        return isHttErrorCodeEqual(r1, 401);
    }

    public static boolean isDriveCopyFail(Throwable r1) {
        return ax4.d.b(r1, 90001072);
    }

    public static boolean isDriveCopying(Throwable r1) {
        return ax4.d.b(r1, 90001071);
    }

    public static boolean isFileDeleteByOwner(Throwable r1) {
        return ax4.d.b(r1, PreviewStatus.OVER_MUCH_NODES_IN_TOTAL);
    }

    public static boolean isFileNotFound(Throwable r1) {
        return ax4.d.b(r1, 3);
    }

    public static boolean isNoNetwork(Throwable r3) {
        boolean r1 = true;
        if ((r3 instanceof CloudReqFun.OkHttpReqException) == false) goto L9;
        Exception r0 = ((CloudReqFun.OkHttpReqException) r3).exceptionObj;
        if ((r0 instanceof RustIOException) == false) goto L9;
        if ("Offline".equalsIgnoreCase(r0.getMessage()) == false) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
    L14:
        if (r2 == false) goto L16;
    L20:
        r1 = r2;
    L21:
        tt5.a.h("DriveComponent", "isNoNetwork()=" + r1);
        return r1;
    L16:
        if (TextUtils.isEmpty(r3.getMessage()) == true) goto L20;
        if (TTNET_UNUSABLE_CODE_PATTEN.matcher(r3.getMessage()).find() == false) goto L20;
    L12:
        if (i75.g.a() == false) goto L14;
        r2 = true;
    L9:
        r2 = false;
        goto L10
    }

    public static boolean isPermissionDenied(Throwable r1) {
        return ax4.d.b(r1, 4);
    }

    public static boolean isPolicyDenied(Throwable r1) {
        if (ax4.d.b(r1, 10009) == false) goto L5;
    L8:
        return true;
    L5:
        if (ax4.d.b(r1, 10013) == true) goto L8;
        return false;
    }

    public static boolean isPreviewDLPFail(Throwable r1) {
        return ax4.d.b(r1, 900099003);
    }

    public static boolean isHttErrorCodeEqual(Throwable r3, int r4) {
        if ((r3 instanceof NetService.HttpErrorException) == false) goto L8;
        int r5 = ((NetService.HttpErrorException) r3).getCode();
        tt5.a.h("DriveComponent", "isHttErrorCodeEqual(): code = " + r5);
        if (r5 != r4) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    public static DriveException parseErr(Throwable r1, ErrCode r2) {
        if (isFileNotFound(r1) == false) goto L6;
        return new DriveException(ErrCode.FILE_NOT_FOUND);
    L6:
        if (isPermissionDenied(r1) == false) goto L9;
        return new DriveException(ErrCode.PERMISSION_DENIED);
    L9:
        if (isPolicyDenied(r1) == false) goto L12;
        return new DriveException(ErrCode.POLICY_DENIED);
    L12:
        if (isFileDeleteByOwner(r1) == false) goto L15;
        return new DriveException(ErrCode.OWNER_DELETED_FILE);
    L15:
        if (ax4.d.b(r1, 90002104) == false) goto L18;
        return new DriveException(ErrCode.STATIC_RESOURCE_FROZEN_BY_ADMIN);
    L18:
        if (ax4.d.b(r1, 90002105) == false) goto L21;
        return new DriveException(ErrCode.STATIC_RESOURCE_SHREDDED_BY_ADMIN);
    L21:
        if (isDriveCopying(r1) == false) goto L24;
        return new DriveException(ErrCode.COPY_TIMEOUT);
    L24:
        if (isDriveCopyFail(r1) == false) goto L27;
        return new DriveException(ErrCode.COPY_FAILED);
    L27:
        if (ax4.d.b(r1, 900099021) == false) goto L30;
        return new DriveException(ErrCode.TNS_BLOCK_VIEW, r1);
    L30:
        if (ax4.d.b(r1, 900021001) == false) goto L33;
        return new DriveException(ErrCode.ENCRYPTION_KEY_DELETED);
    L33:
        if (ax4.d.b(r1, 900099001) == true) goto L42;
        if (ax4.d.b(r1, 900099002) == true) goto L42;
        if (isNoNetwork(r1) == false) goto L54;
        return new DriveException(ErrCode.NO_NETWORK);
    L54:
        return new DriveException(r2, r1);
    L42:
        return new DriveException(ErrCode.DLP_UPLOAD_CONTROL);
    }
}
