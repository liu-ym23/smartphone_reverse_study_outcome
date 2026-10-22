package androidx.biometric;

import android.hardware.biometrics.BiometricPrompt;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class AuthenticationCallbackProvider {
    private BiometricPrompt.AuthenticationCallback mBiometricCallback;
    private FingerprintManagerCompat.AuthenticationCallback mFingerprintCallback;
    final Listener mListener;

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static BiometricPrompt.AuthenticationCallback createCallback(final Listener r1) {
            return new AnonymousClass1(r1);
        }
    }

    public static class Api30Impl {
        private Api30Impl() {
        }

        public static int getAuthenticationType(BiometricPrompt.AuthenticationResult r0) {
            return r0.getAuthenticationType();
        }
    }

    public static class Listener {
        public Listener() {
        }

        public void onError(int r1, CharSequence r2) {
        }

        public void onFailure() {
        }

        public void onHelp(CharSequence r1) {
        }

        public void onSuccess(BiometricPrompt$AuthenticationResult r1) {
        }
    }

    public BiometricPrompt.AuthenticationCallback getBiometricCallback() {
        if (this.mBiometricCallback != null) goto L6;
        this.mBiometricCallback = Api28Impl.createCallback(this.mListener);
    L6:
        return this.mBiometricCallback;
    }

    public FingerprintManagerCompat.AuthenticationCallback getFingerprintCallback() {
        if (this.mFingerprintCallback != null) goto L6;
        this.mFingerprintCallback = new AnonymousClass1(this);
    L6:
        return this.mFingerprintCallback;
    }

    public AuthenticationCallbackProvider(Listener r1) {
        this.mListener = r1;
    }
}
