package androidx.biometric;

import android.hardware.biometrics.BiometricManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class BiometricManager$Api30Impl {
    private BiometricManager$Api30Impl() {
    }

    public static int canAuthenticate(BiometricManager r0, int r1) {
        return r0.canAuthenticate(r1);
    }
}
