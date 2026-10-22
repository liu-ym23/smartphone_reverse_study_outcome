package androidx.biometric;

import android.security.identity.IdentityCredential;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class BiometricPrompt$CryptoObject {
    private final Cipher mCipher;
    private final IdentityCredential mIdentityCredential;
    private final Mac mMac;
    private final Signature mSignature;

    public Cipher getCipher() {
        return this.mCipher;
    }

    public IdentityCredential getIdentityCredential() {
        return this.mIdentityCredential;
    }

    public Mac getMac() {
        return this.mMac;
    }

    public Signature getSignature() {
        return this.mSignature;
    }

    public BiometricPrompt$CryptoObject(IdentityCredential r2) {
        this.mSignature = null;
        this.mCipher = null;
        this.mMac = null;
        this.mIdentityCredential = r2;
    }

    public BiometricPrompt$CryptoObject(Signature r1) {
        this.mSignature = r1;
        this.mCipher = null;
        this.mMac = null;
        this.mIdentityCredential = null;
    }

    public BiometricPrompt$CryptoObject(Cipher r2) {
        this.mSignature = null;
        this.mCipher = r2;
        this.mMac = null;
        this.mIdentityCredential = null;
    }

    public BiometricPrompt$CryptoObject(Mac r2) {
        this.mSignature = null;
        this.mCipher = null;
        this.mMac = r2;
        this.mIdentityCredential = null;
    }
}
