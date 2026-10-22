package com.bytedance.ee.bear.drive.loader.download;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.drive.loader.download.platform.api.ServerErrParser;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;

/* JADX INFO: loaded from: classes16.dex */
public class ErrReportHandler {
    private static final String TAG = "ErrReportHandler";

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.loader.download.ErrReportHandler$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$ee$bear$drive$loader$model$ErrCode = null;

        static {
            int[] r100 = new int[ErrCode.values().length];
            $SwitchMap$com$bytedance$ee$bear$drive$loader$model$ErrCode = r100;
            r100[ErrCode.FILE_NOT_FOUND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L56:
            $SwitchMap$com$bytedance$ee$bear$drive$loader$model$ErrCode[ErrCode.OWNER_DELETED_FILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L40:
            $SwitchMap$com$bytedance$ee$bear$drive$loader$model$ErrCode[ErrCode.PERMISSION_DENIED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L52:
            $SwitchMap$com$bytedance$ee$bear$drive$loader$model$ErrCode[ErrCode.POLICY_DENIED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L58:
            $SwitchMap$com$bytedance$ee$bear$drive$loader$model$ErrCode[ErrCode.REQUEST_FILE_INFO_EXP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L42:
            $SwitchMap$com$bytedance$ee$bear$drive$loader$model$ErrCode[ErrCode.COPY_TIMEOUT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L46:
            $SwitchMap$com$bytedance$ee$bear$drive$loader$model$ErrCode[ErrCode.COPY_FAILED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L66:
            $SwitchMap$com$bytedance$ee$bear$drive$loader$model$ErrCode[ErrCode.REQUEST_TRANSFORM_CANCEL_EXP.ordinal()] = 8;     // Catch: NoSuchFieldError -> L27
        L36:
            $SwitchMap$com$bytedance$ee$bear$drive$loader$model$ErrCode[ErrCode.REQUEST_TRANSFORM_SHUTDOWN_EXP.ordinal()] = 9;     // Catch: NoSuchFieldError -> L28
        L60:
            $SwitchMap$com$bytedance$ee$bear$drive$loader$model$ErrCode[ErrCode.REQUEST_TRANSFORM_FILE_ENCRYPTION.ordinal()] = 10;     // Catch: NoSuchFieldError -> L29
        L62:
            $SwitchMap$com$bytedance$ee$bear$drive$loader$model$ErrCode[ErrCode.REQUEST_TRANSFORM_UNKNOW_EXP.ordinal()] = 11;     // Catch: NoSuchFieldError -> L30
        L48:
            $SwitchMap$com$bytedance$ee$bear$drive$loader$model$ErrCode[ErrCode.REQUEST_TRANSFORM_SERVER_EXP.ordinal()] = 12;     // Catch: NoSuchFieldError -> L31
        L54:
            $SwitchMap$com$bytedance$ee$bear$drive$loader$model$ErrCode[ErrCode.REQUEST_PREVIEW_URL_EXP.ordinal()] = 13;     // Catch: NoSuchFieldError -> L32
        L38:
            $SwitchMap$com$bytedance$ee$bear$drive$loader$model$ErrCode[ErrCode.DRIVE_FILE_NOT_SUPPORT_PREVIEW.ordinal()] = 14;     // Catch: NoSuchFieldError -> L33
        L44:
            $SwitchMap$com$bytedance$ee$bear$drive$loader$model$ErrCode[ErrCode.DRIVE_FILE_ZERO_SIZE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L34
        L64:
            $SwitchMap$com$bytedance$ee$bear$drive$loader$model$ErrCode[ErrCode.DRIVE_FILE_OVER_SIZE.ordinal()] = 16;     // Catch: NoSuchFieldError -> L35
            return;
        }
    }

    public ErrReportHandler() {
    }

    public static boolean isExpNotEffectPreview(Throwable r100) {
        if ((r100 instanceof DriveException) == false) goto L18;
        ErrCode r101 = ((DriveException) r100).getErrorCode();
        if (r101 != ErrCode.REQUEST_FILE_INFO_EXP) goto L7;
    L16:
        return true;
    L7:
        if (r101 == ErrCode.REQUEST_PREVIEW_URL_EXP) goto L16;
        if (r101 == ErrCode.REQUEST_TRANSFORM_UNKNOW_EXP) goto L16;
        if (r101 == ErrCode.REQUEST_TRANSFORM_CANCEL_EXP) goto L16;
        if (r101 == ErrCode.NO_NETWORK) goto L16;
        if (r101 == ErrCode.REQUEST_TRANSFORM_SERVER_EXP) goto L16;
        return false;
    L18:
        return false;
    }

    private static boolean isExpNotReported(Throwable r100) {
        if ((r100 instanceof DriveException) == false) goto L32;
        ErrCode r101 = ((DriveException) r100).getErrorCode();
        if (r101 != ErrCode.FILE_NOT_CHANGED) goto L7;
    L30:
        return true;
    L7:
        if (r101 == ErrCode.MANUAL_CACHE_NEED_WIFI) goto L30;
        if (r101 == ErrCode.CACHE_FILE_MODEL_NOT_FOUND) goto L30;
        if (r101 == ErrCode.FILE_DATA_VERSION_CHANGED) goto L30;
        if (r101 == ErrCode.PRELOAD_SIZE_TOO_LARGE) goto L30;
        if (r101 == ErrCode.PROCESSOR_CACHE_MISS) goto L30;
        if (r101 == ErrCode.WPS_PREVIEW_EXP) goto L30;
        if (r101 == ErrCode.SHEET_PREVIEW_EXP) goto L30;
        if (r101 == ErrCode.SLIDES_PREVIEW_EXP) goto L30;
        if (r101 == ErrCode.ENCRYPTION_KEY_DELETED) goto L30;
        if (r101 == ErrCode.PERM_ADMIN_CONTROL) goto L30;
        if (r101 == ErrCode.NO_NETWORK) goto L30;
        if (r101 == ErrCode.PREVIEW_DOWNGRADE_TO_SIMILAR) goto L30;
        return false;
    L32:
        return false;
    }

    public static void handle(com.bytedance.ee.bear.drive.report.a r100, Throwable r101, String r110, int r111) {
        tt5.a.d(TAG, "ErrReportHandler handle err, sourceType: " + r111 + ", err: " + r101);
        if (isExpNotReported(r101) == false) goto L5;
        return;
    L5:
        boolean r102 = false;
        if ((r101 instanceof DriveException) == false) goto L16;
        DriveException r103 = (DriveException) r101;
        if (handleRequestFileInfoExp(r100, r103, r110, r111) == false) goto L10;
    L15:
        r102 = true;
        goto L16
    L10:
        if (handleRequestPreviewUrlExp(r100, r103, r110, r111) == true) goto L15;
        if (handleAbnormalCaseExp(r100, r103, r110, r111) == true) goto L15;
        if (handleRustDownloadFailExp(r100, r103, r110, r111) == true) goto L15;
    L16:
        if (r102 == true) goto L19;
        r100.l("nativeFail", "unknown", r110, r111, t85.b.a(r101));
        return;
    }

    private static boolean handleAbnormalCaseExp(com.bytedance.ee.bear.drive.report.a r100, DriveException r101, String r102, int r103) {
        switch(AnonymousClass1.$SwitchMap$com$bytedance$ee$bear$drive$loader$model$ErrCode[r101.getErrorCode().ordinal()]) {
            case 14: goto L8;
            case 15: goto L7;
            case 16: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        r100.k("nativeFail", "DEC12", r102, r103);
        return true;
    L7:
        r100.k("nativeFail", "DEC13", r102, r103);
        return true;
    L8:
        r100.k("serverFail", "DEC11", r102, r103);
        return true;
    }

    private static boolean handleRequestFileInfoExp(com.bytedance.ee.bear.drive.report.a r100, DriveException r101, String r102, int r110) {
        switch(AnonymousClass1.$SwitchMap$com$bytedance$ee$bear$drive$loader$model$ErrCode[r101.getErrorCode().ordinal()]) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            default: goto L5;
        };
    L13:
        r100.l("nativeFail", "DEC31", r102, r110, t85.b.a(r101));
    L20:
        return true;
    L14:
        r100.l("nativeFail", "DEC32", r102, r110, t85.b.a(r101));
        goto L20
    L15:
        r100.l("nativeFail", "DEC5", r102, r110, t85.b.a(r101));
        goto L20
    L16:
        r100.k("nativeFail", "DEC15", r102, r110);
        goto L20
    L17:
        r100.k("nativeFail", "DEC4", r102, r110);
        goto L20
    L18:
        r100.k("nativeFail", "DEC16", r102, r110);
        goto L20
    L19:
        r100.k("nativeFail", "DEC27", r102, r110);
        goto L20
    L5:
        if (ServerErrParser.isAuthFail(r101.getCause()) == false) goto L25;
        AccountService$Account r103 = ((h0) org.koin.java.a.a(h0.class)).G2();
        com.bytedance.ee.bear.lark.dependency.b r104 = (com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.b.class);
        if (r103 != null) goto L9;
    L21:
        boolean r105 = false;
    L22:
        if (r105 == false) goto L25;
        tt5.a.k(TAG, "isAuthFail accountNotEquals");
        return true;
    L9:
        if (TextUtils.equals(r103.uid, r104.getUserId()) == true) goto L21;
        if (TextUtils.equals(r103.token, r104.getSession()) == true) goto L21;
        r105 = true;
    L25:
        return false;
    }

    private static boolean handleRequestPreviewUrlExp(com.bytedance.ee.bear.drive.report.a r100, DriveException r101, String r110, int r111) {
        switch(AnonymousClass1.$SwitchMap$com$bytedance$ee$bear$drive$loader$model$ErrCode[r101.getErrorCode().ordinal()]) {
            case 8: goto L8;
            case 9: goto L8;
            case 10: goto L7;
            case 11: goto L6;
            case 12: goto L6;
            case 13: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        r100.l("nativeFail", "DEC6", r110, r111, t85.b.a(r101));
        return true;
    L7:
        tt5.a.d("DRIVE_PREVIEW_FLOW", "REQUEST_TRANSFORM_FILE_ENCRYPTION");
        return true;
    L8:
        tt5.a.d("DRIVE_PREVIEW_FLOW", "RequestTransformCancelException");
        return true;
    }

    private static boolean handleRustDownloadFailExp(com.bytedance.ee.bear.drive.report.a r100, DriveException r101, String r110, int r111) {
        if (r101.getErrorCode() != ErrCode.RUST_SUBMIT_ERROR) goto L6;
        r100.l("rustFail", "DEC8", r110, r111, t85.b.a(r101));
        return true;
    L6:
        return false;
    }

    public static void handle(com.bytedance.ee.bear.drive.report.a r100, Throwable r101, String r102, int r103, boolean r110) {
        if (r110 == true) goto L4;
    L6:
        handle(r100, r101, r102, r103);
        return;
    L4:
        if (isExpNotEffectPreview(r101) == false) goto L6;
        r100.l("nativeFail", "DEC30", r102, r103, t85.b.a(r101));
    }
}
