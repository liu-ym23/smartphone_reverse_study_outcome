package androidx.biometric;

import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class BiometricErrorData {
    private final int mErrorCode;
    private final CharSequence mErrorMessage;

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.mErrorCode), convertToString(this.mErrorMessage)});
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public CharSequence getErrorMessage() {
        return this.mErrorMessage;
    }

    private static String convertToString(CharSequence r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.toString();
    }

    private boolean isErrorMessageEqualTo(CharSequence r2) {
        String r0 = convertToString(this.mErrorMessage);
        String r3 = convertToString(r2);
        if (r0 != null) goto L5;
        if (r3 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0 != null) goto L7;
    L9:
        return false;
    L7:
        if (r0.equals(r3) == false) goto L9;
        goto L8
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof BiometricErrorData) == false) goto L10;
        BiometricErrorData r5 = (BiometricErrorData) r4;
        if (this.mErrorCode == r5.mErrorCode) goto L7;
        return false;
    L7:
        if (isErrorMessageEqualTo(r5.mErrorMessage) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public BiometricErrorData(int r1, CharSequence r2) {
        this.mErrorCode = r1;
        this.mErrorMessage = r2;
    }
}
