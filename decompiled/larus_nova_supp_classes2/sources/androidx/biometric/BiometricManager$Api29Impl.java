package androidx.biometric;

import android.content.Context;
import android.hardware.biometrics.BiometricManager;
import android.hardware.biometrics.BiometricPrompt;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class BiometricManager$Api29Impl {
    private BiometricManager$Api29Impl() {
    }

    public static Method getCanAuthenticateWithCryptoMethod() {
        return BiometricManager.class.getMethod("canAuthenticate", new Class[]{BiometricPrompt.CryptoObject.class});
    L4:
        return null;
    }

    public static int canAuthenticate(BiometricManager r0) {
        return r0.canAuthenticate();
    }

    public static BiometricManager create(Context r1) {
        return (BiometricManager) r1.getSystemService(BiometricManager.class);
    }
}
