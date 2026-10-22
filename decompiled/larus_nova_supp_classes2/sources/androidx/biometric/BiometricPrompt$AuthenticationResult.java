package androidx.biometric;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class BiometricPrompt$AuthenticationResult {
    private final int mAuthenticationType;
    private final BiometricPrompt$CryptoObject mCryptoObject;

    public int getAuthenticationType() {
        return this.mAuthenticationType;
    }

    public BiometricPrompt$CryptoObject getCryptoObject() {
        return this.mCryptoObject;
    }

    public BiometricPrompt$AuthenticationResult(BiometricPrompt$CryptoObject r1, int r2) {
        this.mCryptoObject = r1;
        this.mAuthenticationType = r2;
    }
}
