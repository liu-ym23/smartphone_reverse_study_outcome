package androidx.biometric;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class ErrorUtils {
    private ErrorUtils() {
    }

    public static boolean isKnownError(int r0) {
        switch(r0) {
            case 1: goto L5;
            case 2: goto L5;
            case 3: goto L5;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L3;
            case 7: goto L5;
            case 8: goto L5;
            case 9: goto L5;
            case 10: goto L5;
            case 11: goto L5;
            case 12: goto L5;
            case 13: goto L5;
            case 14: goto L5;
            case 15: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }

    public static boolean isLockoutError(int r1) {
        if (r1 != 7) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 9) goto L8;
        return false;
    }

    public static String getFingerprintErrorString(Context r1, int r2) {
        if (r1 != null) goto L6;
        return "";
    L6:
        if (r2 == 1) goto L21;
        if (r2 == 7) goto L19;
        switch(r2) {
            case 9: goto L19;
            case 10: goto L17;
            case 11: goto L15;
            case 12: goto L13;
            default: goto L11;
        };
    L11:
        return r1.getString(2131896083);
    L13:
        return r1.getString(2131897023);
    L15:
        return r1.getString(2131897025);
    L17:
        return r1.getString(2131897026);
    L19:
        return r1.getString(2131897024);
    L21:
        return r1.getString(2131897022);
    }
}
