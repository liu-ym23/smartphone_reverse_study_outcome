package androidx.biometric;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class DeviceUtils {
    private DeviceUtils() {
    }

    public static boolean canAssumeStrongBiometrics(Context r2, String r3) {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return false;
    L7:
        return isModelInList(r2, r3, 2130903041);
    }

    public static boolean shouldDelayShowingPrompt(Context r2, String r3) {
        if (Build.VERSION.SDK_INT == 29) goto L7;
        return false;
    L7:
        return isModelInList(r2, r3, 2130903053);
    }

    public static boolean shouldHideFingerprintDialog(Context r2, String r3) {
        if (Build.VERSION.SDK_INT == 28) goto L7;
        return false;
    L7:
        return isModelInPrefixList(r2, r3, 2130903055);
    }

    private static boolean isModelInList(Context r3, String r4, int r5) {
        if (r4 != null) goto L5;
        return false;
    L5:
        String[] r6 = r3.getResources().getStringArray(r5);
        int r7 = r6.length;
        int r1 = 0;
    L6:
        if (r1 >= r7) goto L12;
        if (r4.equals(r6[r1]) == true) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    private static boolean isModelInPrefixList(Context r3, String r4, int r5) {
        if (r4 != null) goto L5;
        return false;
    L5:
        String[] r6 = r3.getResources().getStringArray(r5);
        int r7 = r6.length;
        int r1 = 0;
    L6:
        if (r1 >= r7) goto L12;
        if (r4.startsWith(r6[r1]) == true) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    private static boolean isVendorInList(Context r3, String r4, int r5) {
        if (r4 != null) goto L5;
        return false;
    L5:
        String[] r6 = r3.getResources().getStringArray(r5);
        int r7 = r6.length;
        int r1 = 0;
    L6:
        if (r1 >= r7) goto L12;
        if (r4.equalsIgnoreCase(r6[r1]) == true) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public static boolean shouldUseFingerprintForCrypto(Context r3, String r4, String r5) {
        if (Build.VERSION.SDK_INT == 28) goto L6;
        return false;
    L6:
        if (isVendorInList(r3, r4, 2130903050) == false) goto L8;
    L9:
        return true;
    L8:
        if (isModelInPrefixList(r3, r5, 2130903049) == true) goto L9;
        return false;
    }
}
