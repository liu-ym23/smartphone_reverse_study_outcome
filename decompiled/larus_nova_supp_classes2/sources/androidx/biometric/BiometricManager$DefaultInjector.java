package androidx.biometric;

import android.content.Context;
import android.hardware.biometrics.BiometricManager;
import android.os.Build;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class BiometricManager$DefaultInjector implements BiometricManager$Injector {
    private final Context mContext;

    @Override // androidx.biometric.BiometricManager$Injector
    public BiometricManager getBiometricManager() {
        return BiometricManager$Api29Impl.create(this.mContext);
    }

    @Override // androidx.biometric.BiometricManager$Injector
    public FingerprintManagerCompat getFingerprintManager() {
        return FingerprintManagerCompat.from(this.mContext);
    }

    @Override // androidx.biometric.BiometricManager$Injector
    public boolean isDeviceSecurable() {
        if (KeyguardUtils.getKeyguardManager(this.mContext) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.biometric.BiometricManager$Injector
    public boolean isDeviceSecuredWithCredential() {
        return KeyguardUtils.isDeviceSecuredWithCredential(this.mContext);
    }

    @Override // androidx.biometric.BiometricManager$Injector
    public boolean isFingerprintHardwarePresent() {
        return PackageUtils.hasSystemFeatureFingerprint(this.mContext);
    }

    @Override // androidx.biometric.BiometricManager$Injector
    public boolean isStrongBiometricGuaranteed() {
        return DeviceUtils.canAssumeStrongBiometrics(this.mContext, Build.MODEL);
    }

    public BiometricManager$DefaultInjector(Context r1) {
        this.mContext = r1.getApplicationContext();
    }
}
