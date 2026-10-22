package androidx.biometric;

import android.hardware.biometrics.BiometricManager;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface BiometricManager$Injector {
    BiometricManager getBiometricManager();

    FingerprintManagerCompat getFingerprintManager();

    boolean isDeviceSecurable();

    boolean isDeviceSecuredWithCredential();

    boolean isFingerprintHardwarePresent();

    boolean isStrongBiometricGuaranteed();
}
