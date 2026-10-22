package androidx.biometric;

import android.os.Build;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class AuthenticatorUtils {
    private static final int BIOMETRIC_CLASS_MASK = 32767;

    private AuthenticatorUtils() {
    }

    public static boolean isDeviceCredentialAllowed(int r1) {
        if ((r1 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isSomeBiometricAllowed(int r0) {
        if ((r0 & BIOMETRIC_CLASS_MASK) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isWeakBiometricAllowed(int r1) {
        if ((r1 & 255) != 255) goto L5;
        return true;
    L5:
        return false;
    }

    public static String convertToString(int r1) {
        if (r1 != 15) goto L5;
        return "BIOMETRIC_STRONG";
    L5:
        if (r1 != 255) goto L7;
        return "BIOMETRIC_WEAK";
    L7:
        if (r1 != 32768) goto L9;
        return "DEVICE_CREDENTIAL";
    L9:
        if (r1 != 32783) goto L11;
        return "BIOMETRIC_STRONG | DEVICE_CREDENTIAL";
    L11:
        if (r1 != 33023) goto L13;
        return "BIOMETRIC_WEAK | DEVICE_CREDENTIAL";
    L13:
        return String.valueOf(r1);
    }

    public static boolean isSupportedCombination(int r3) {
        if (r3 != 15) goto L5;
        return true;
    L5:
        if (r3 != 255) goto L7;
        return true;
    L7:
        if (r3 == 32768) goto L24;
        if (r3 != 32783) goto L11;
        int r4 = Build.VERSION.SDK_INT;
        if (r4 >= 28) goto L19;
        return true;
    L19:
        if (r4 > 29) goto L30;
        return false;
    L30:
        return true;
    L11:
        if (r3 == 33023) goto L33;
        if (r3 == 0) goto L28;
        return false;
    L28:
        return true;
    L33:
        return true;
    L24:
        if (Build.VERSION.SDK_INT >= 30) goto L34;
        return false;
    L34:
        return true;
    }

    public static int getConsolidatedAuthenticators(BiometricPrompt.PromptInfo r1, BiometricPrompt$CryptoObject r2) {
        if (r1.getAllowedAuthenticators() != 0) goto L13;
        if (r2 == null) goto L7;
        int r3 = 15;
    L9:
        if (r1.isDeviceCredentialAllowed() == false) goto L12;
        return 32768 | r3;
    L12:
        return r3;
    L7:
        r3 = 255;
        goto L9
    L13:
        return r1.getAllowedAuthenticators();
    }
}
