package com.bytedance.ee.bear.drive.loader.download.platform.api;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.net.CloudReqFun;
import com.bytedance.ee.eenet.httpclient.rust.exception.RustIOException;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes16.dex */
public class ServerErrParser {
    private static final Pattern TTNET_UNUSABLE_CODE_PATTEN = null;

    public ServerErrParser() {
    }

    static {
        TTNET_UNUSABLE_CODE_PATTEN = PatternProtector.compile("-102|-103|-105|-118|-106|-109|-192|-193|-194|-195|-207|Timeout|Offline");
    }

    public static boolean isAuthFail(Throwable r100) {
        return isHttErrorCodeEqual(r100, 401);
    }

    public static boolean isDriveCopyFail(Throwable r100) {
        return ax4.d.b(r100, 90001072);
    }

    public static boolean isDriveCopying(Throwable r100) {
        return ax4.d.b(r100, 90001071);
    }

    public static boolean isFileDeleteByOwner(Throwable r100) {
        return ax4.d.b(r100, 1002);
    }

    public static boolean isFileNotFound(Throwable r100) {
        return ax4.d.b(r100, 3);
    }

    public static boolean isNoNetwork(Throwable r100) {
        boolean r101 = true;
        if ((r100 instanceof CloudReqFun.OkHttpReqException) == false) goto L9;
        Exception r102 = ((CloudReqFun.OkHttpReqException) r100).exceptionObj;
        if ((r102 instanceof RustIOException) == false) goto L9;
        if ("Offline".equalsIgnoreCase(r102.getMessage()) == false) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
    L14:
        if (r103 == false) goto L16;
    L20:
        r101 = r103;
    L21:
        tt5.a.h("DriveComponent", "isNoNetwork()=" + r101);
        return r101;
    L16:
        if (TextUtils.isEmpty(r100.getMessage()) == true) goto L20;
        if (TTNET_UNUSABLE_CODE_PATTEN.matcher(r100.getMessage()).find() == false) goto L20;
    L12:
        if (i75.g.a() == false) goto L14;
        r103 = true;
    L9:
        r103 = false;
        goto L10
    }

    public static boolean isPermissionDenied(Throwable r100) {
        return ax4.d.b(r100, 4);
    }

    public static boolean isPolicyDenied(Throwable r100) {
        if (ax4.d.b(r100, 10009) == false) goto L5;
    L8:
        return true;
    L5:
        if (ax4.d.b(r100, 10013) == true) goto L8;
        return false;
    }

    public static boolean isPreviewDLPFail(Throwable r100) {
        return ax4.d.b(r100, 900099003);
    }

    public static boolean isHttErrorCodeEqual(Throwable r100, int r101) {
        if ((r100 instanceof NetService.HttpErrorException) == false) goto L8;
        int r102 = ((NetService.HttpErrorException) r100).getCode();
        tt5.a.h("DriveComponent", "isHttErrorCodeEqual(): code = " + r102);
        if (r102 != r101) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    public static DriveException parseErr(Throwable r100, ErrCode r101) {
        if (isFileNotFound(r100) == false) goto L6;
        return new DriveException(ErrCode.FILE_NOT_FOUND);
    L6:
        if (isPermissionDenied(r100) == false) goto L9;
        return new DriveException(ErrCode.PERMISSION_DENIED);
    L9:
        if (isPolicyDenied(r100) == false) goto L12;
        return new DriveException(ErrCode.POLICY_DENIED);
    L12:
        if (isFileDeleteByOwner(r100) == false) goto L15;
        return new DriveException(ErrCode.OWNER_DELETED_FILE);
    L15:
        if (ax4.d.b(r100, 90002104) == false) goto L18;
        return new DriveException(ErrCode.STATIC_RESOURCE_FROZEN_BY_ADMIN);
    L18:
        if (ax4.d.b(r100, 90002105) == false) goto L21;
        return new DriveException(ErrCode.STATIC_RESOURCE_SHREDDED_BY_ADMIN);
    L21:
        if (isDriveCopying(r100) == false) goto L24;
        return new DriveException(ErrCode.COPY_TIMEOUT);
    L24:
        if (isDriveCopyFail(r100) == false) goto L27;
        return new DriveException(ErrCode.COPY_FAILED);
    L27:
        if (ax4.d.b(r100, 900099021) == false) goto L30;
        return new DriveException(ErrCode.TNS_BLOCK_VIEW, r100);
    L30:
        if (ax4.d.b(r100, 900021001) == false) goto L33;
        return new DriveException(ErrCode.ENCRYPTION_KEY_DELETED);
    L33:
        if (ax4.d.b(r100, 900099001) == true) goto L42;
        if (ax4.d.b(r100, 900099002) == true) goto L42;
        if (isNoNetwork(r100) == false) goto L54;
        return new DriveException(ErrCode.NO_NETWORK);
    L54:
        return new DriveException(r101, r100);
    L42:
        return new DriveException(ErrCode.DLP_UPLOAD_CONTROL);
    }
}
