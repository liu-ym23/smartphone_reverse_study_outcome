package m55;

import com.bytedance.ee.bear.drive.biz.importfile.request.error.ImportFailedType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static ImportFailedType a(int r2) {
        tt5.a.h("ErrorCodeV2", "import" + r2);
        if (r2 == 100) goto L54;
        if (r2 == 110) goto L52;
        if (r2 == 1002) goto L52;
        if (r2 == 1004) goto L50;
        if (r2 == 1015) goto L48;
        if (r2 == 1024) goto L46;
        if (r2 == 104) goto L44;
        if (r2 == 105) goto L50;
        if (r2 == 112) goto L50;
        if (r2 == 113) goto L50;
        if (r2 == 124) goto L50;
        if (r2 == 125) goto L48;
        if (r2 == 1019) goto L42;
        if (r2 == 1020) goto L40;
        switch(r2) {
            case 115: goto L38;
            case 116: goto L52;
            case 117: goto L36;
            case 118: goto L50;
            case 119: goto L36;
            case 120: goto L50;
            case 121: goto L50;
            default: goto L31;
        };
    L31:
        switch(r2) {
            case 1007: goto L50;
            case 1008: goto L52;
            case 1009: goto L38;
            case 1010: goto L50;
            case 1011: goto L50;
            case 1012: goto L36;
            case 1013: goto L50;
            default: goto L32;
        };
    L32:
        switch(r2) {
            case 7000: goto L38;
            case 7001: goto L38;
            case 7002: goto L38;
            default: goto L34;
        };
    L34:
        return ImportFailedType.FailedCanRetry;
    L36:
        return ImportFailedType.FailedNotExist;
    L38:
        return ImportFailedType.FailedImportBlockNumberOverLimit;
    L40:
        return ImportFailedType.ImDlpProgress;
    L42:
        return ImportFailedType.ImDlpFail;
    L44:
        return ImportFailedType.FailedOverLimitCount;
    L46:
        return ImportFailedType.EncryptFile;
    L48:
        return ImportFailedType.FailedEmptyFile;
    L50:
        return ImportFailedType.FailedCanContactSupport;
    L52:
        return ImportFailedType.FailedNoPermisson;
    L54:
        return ImportFailedType.FailedEncrypt;
    }

    public static boolean b(int r2) {
        tt5.a.h("ErrorCodeV2", "isImportEncryptFailed, errorCode: " + r2);
        if (r2 != 100) goto L5;
        return true;
    L5:
        if (r2 != 118) goto L7;
        return true;
    L7:
        if (r2 != 124) goto L9;
        return true;
    L9:
        if (r2 != 120) goto L11;
        return true;
    L11:
        if (r2 == 121) goto L20;
        switch(r2) {
            case 112: goto L21;
            case 113: goto L21;
            case 114: goto L21;
            default: goto L13;
        };
    L13:
        return false;
    L21:
        return true;
    L20:
        return true;
    }
}
