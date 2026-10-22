package com.bytedance.ee.bear.drive.loader.download;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.drive.loader.download.platform.api.ServerErrParser;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ErrReportHandler {
    private static final String TAG = "ErrReportHandler";

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.loader.download.ErrReportHandler$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$ee$bear$drive$loader$model$ErrCode = null;

        static {
            int[] r0 = new int[ErrCode.values().length];
            $SwitchMap$com$bytedance$ee$bear$drive$loader$model$ErrCode = r0;
            r0[ErrCode.FILE_NOT_FOUND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
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

    public static boolean isExpNotEffectPreview(Throwable r2) {
        if ((r2 instanceof DriveException) == false) goto L18;
        ErrCode r3 = ((DriveException) r2).getErrorCode();
        if (r3 != ErrCode.REQUEST_FILE_INFO_EXP) goto L7;
    L16:
        return true;
    L7:
        if (r3 == ErrCode.REQUEST_PREVIEW_URL_EXP) goto L16;
        if (r3 == ErrCode.REQUEST_TRANSFORM_UNKNOW_EXP) goto L16;
        if (r3 == ErrCode.REQUEST_TRANSFORM_CANCEL_EXP) goto L16;
        if (r3 == ErrCode.NO_NETWORK) goto L16;
        if (r3 == ErrCode.REQUEST_TRANSFORM_SERVER_EXP) goto L16;
        return false;
    L18:
        return false;
    }

    private static boolean isExpNotReported(Throwable r2) {
        if ((r2 instanceof DriveException) == false) goto L32;
        ErrCode r3 = ((DriveException) r2).getErrorCode();
        if (r3 != ErrCode.FILE_NOT_CHANGED) goto L7;
    L30:
        return true;
    L7:
        if (r3 == ErrCode.MANUAL_CACHE_NEED_WIFI) goto L30;
        if (r3 == ErrCode.CACHE_FILE_MODEL_NOT_FOUND) goto L30;
        if (r3 == ErrCode.FILE_DATA_VERSION_CHANGED) goto L30;
        if (r3 == ErrCode.PRELOAD_SIZE_TOO_LARGE) goto L30;
        if (r3 == ErrCode.PROCESSOR_CACHE_MISS) goto L30;
        if (r3 == ErrCode.WPS_PREVIEW_EXP) goto L30;
        if (r3 == ErrCode.SHEET_PREVIEW_EXP) goto L30;
        if (r3 == ErrCode.SLIDES_PREVIEW_EXP) goto L30;
        if (r3 == ErrCode.ENCRYPTION_KEY_DELETED) goto L30;
        if (r3 == ErrCode.PERM_ADMIN_CONTROL) goto L30;
        if (r3 == ErrCode.NO_NETWORK) goto L30;
        if (r3 == ErrCode.PREVIEW_DOWNGRADE_TO_SIMILAR) goto L30;
        return false;
    L32:
        return false;
    }

    public static void handle(com.bytedance.ee.bear.drive.report.a r8, Throwable r9, String r10, int r11) {
        tt5.a.d(TAG, "ErrReportHandler handle err, sourceType: " + r11 + ", err: " + r9);
        if (isExpNotReported(r9) == false) goto L5;
        return;
    L5:
        boolean r1 = false;
        if ((r9 instanceof DriveException) == false) goto L16;
        DriveException r0 = (DriveException) r9;
        if (handleRequestFileInfoExp(r8, r0, r10, r11) == false) goto L10;
    L15:
        r1 = true;
        goto L16
    L10:
        if (handleRequestPreviewUrlExp(r8, r0, r10, r11) == true) goto L15;
        if (handleAbnormalCaseExp(r8, r0, r10, r11) == true) goto L15;
        if (handleRustDownloadFailExp(r8, r0, r10, r11) == true) goto L15;
    L16:
        if (r1 == true) goto L19;
        r8.l("nativeFail", "unknown", r10, r11, t85.b.a(r9));
        return;
    }

    private static boolean handleAbnormalCaseExp(com.bytedance.ee.bear.drive.report.a r1, DriveException r2, String r3, int r4) {
        switch(AnonymousClass1.$SwitchMap$com$bytedance$ee$bear$drive$loader$model$ErrCode[r2.getErrorCode().ordinal()]) {
            case 14: goto L8;
            case 15: goto L7;
            case 16: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        r1.k("nativeFail", "DEC12", r3, r4);
        return true;
    L7:
        r1.k("nativeFail", "DEC13", r3, r4);
        return true;
    L8:
        r1.k("serverFail", "DEC11", r3, r4);
        return true;
    }

    private static boolean handleRequestFileInfoExp(com.bytedance.ee.bear.drive.report.a r7, DriveException r8, String r9, int r10) {
        switch(AnonymousClass1.$SwitchMap$com$bytedance$ee$bear$drive$loader$model$ErrCode[r8.getErrorCode().ordinal()]) {
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
        r7.l("nativeFail", "DEC31", r9, r10, t85.b.a(r8));
    L20:
        return true;
    L14:
        r7.l("nativeFail", "DEC32", r9, r10, t85.b.a(r8));
        goto L20
    L15:
        r7.l("nativeFail", "DEC5", r9, r10, t85.b.a(r8));
        goto L20
    L16:
        r7.k("nativeFail", "DEC15", r9, r10);
        goto L20
    L17:
        r7.k("nativeFail", "DEC4", r9, r10);
        goto L20
    L18:
        r7.k("nativeFail", "DEC16", r9, r10);
        goto L20
    L19:
        r7.k("nativeFail", "DEC27", r9, r10);
        goto L20
    L5:
        if (ServerErrParser.isAuthFail(r8.getCause()) == false) goto L25;
        AccountService$Account r0 = ((h0) org.koin.java.a.a(h0.class)).G2();
        com.bytedance.ee.bear.lark.dependency.b r2 = (com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.b.class);
        if (r0 != null) goto L9;
    L21:
        boolean r1 = false;
    L22:
        if (r1 == false) goto L25;
        tt5.a.k(TAG, "isAuthFail accountNotEquals");
        return true;
    L9:
        if (TextUtils.equals(r0.uid, r2.getUserId()) == true) goto L21;
        if (TextUtils.equals(r0.token, r2.getSession()) == true) goto L21;
        r1 = true;
    L25:
        return false;
    }

    private static boolean handleRequestPreviewUrlExp(com.bytedance.ee.bear.drive.report.a r8, DriveException r9, String r10, int r11) {
        switch(AnonymousClass1.$SwitchMap$com$bytedance$ee$bear$drive$loader$model$ErrCode[r9.getErrorCode().ordinal()]) {
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
        r8.l("nativeFail", "DEC6", r10, r11, t85.b.a(r9));
        return true;
    L7:
        tt5.a.d("DRIVE_PREVIEW_FLOW", "REQUEST_TRANSFORM_FILE_ENCRYPTION");
        return true;
    L8:
        tt5.a.d("DRIVE_PREVIEW_FLOW", "RequestTransformCancelException");
        return true;
    }

    private static boolean handleRustDownloadFailExp(com.bytedance.ee.bear.drive.report.a r8, DriveException r9, String r10, int r11) {
        if (r9.getErrorCode() != ErrCode.RUST_SUBMIT_ERROR) goto L6;
        r8.l("rustFail", "DEC8", r10, r11, t85.b.a(r9));
        return true;
    L6:
        return false;
    }

    public static void handle(com.bytedance.ee.bear.drive.report.a r6, Throwable r7, String r8, int r9, boolean r10) {
        if (r10 == true) goto L4;
    L6:
        handle(r6, r7, r8, r9);
        return;
    L4:
        if (isExpNotEffectPreview(r7) == false) goto L6;
        r6.l("nativeFail", "DEC30", r8, r9, t85.b.a(r7));
    }
}
