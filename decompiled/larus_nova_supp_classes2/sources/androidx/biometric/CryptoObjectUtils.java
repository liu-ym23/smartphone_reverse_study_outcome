package androidx.biometric;

import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.security.identity.IdentityCredential;
import android.security.keystore.KeyGenParameterSpec;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class CryptoObjectUtils {
    private static final String FAKE_KEY_NAME = "androidxBiometric";
    private static final String KEYSTORE_INSTANCE = "AndroidKeyStore";
    private static final String TAG = "CryptoObjectUtils";

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static KeyGenParameterSpec buildKeyGenParameterSpec(KeyGenParameterSpec.Builder r0) {
            return r0.build();
        }

        public static void setBlockModeCBC(KeyGenParameterSpec.Builder r1) {
            r1.setBlockModes(new String[]{"CBC"});
        }

        public static void setEncryptionPaddingPKCS7(KeyGenParameterSpec.Builder r1) {
            r1.setEncryptionPaddings(new String[]{"PKCS7Padding"});
        }

        public static KeyGenParameterSpec.Builder createKeyGenParameterSpecBuilder(String r1, int r2) {
            return new KeyGenParameterSpec.Builder(r1, r2);
        }

        public static void initKeyGenerator(KeyGenerator r0, KeyGenParameterSpec r1) throws InvalidAlgorithmParameterException {
            r0.init(r1);
        }
    }

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static BiometricPrompt.CryptoObject create(Signature r1) {
            return new BiometricPrompt.CryptoObject(r1);
        }

        public static Cipher getCipher(BiometricPrompt.CryptoObject r0) {
            return r0.getCipher();
        }

        public static Mac getMac(BiometricPrompt.CryptoObject r0) {
            return r0.getMac();
        }

        public static Signature getSignature(BiometricPrompt.CryptoObject r0) {
            return r0.getSignature();
        }

        public static BiometricPrompt.CryptoObject create(Cipher r1) {
            return new BiometricPrompt.CryptoObject(r1);
        }

        public static BiometricPrompt.CryptoObject create(Mac r1) {
            return new BiometricPrompt.CryptoObject(r1);
        }
    }

    public static class Api30Impl {
        private Api30Impl() {
        }

        public static BiometricPrompt.CryptoObject create(IdentityCredential r1) {
            return new BiometricPrompt.CryptoObject(r1);
        }

        public static IdentityCredential getIdentityCredential(BiometricPrompt.CryptoObject r0) {
            return r0.getIdentityCredential();
        }
    }

    private CryptoObjectUtils() {
    }

    public static BiometricPrompt$CryptoObject createFakeCryptoObject() {
        KeyStore r3 = KeyStore.getInstance(KEYSTORE_INSTANCE);     // Catch: Throwable -> L5
        r3.load(null);     // Catch: Throwable -> L5
        KeyGenParameterSpec.Builder r4 = Api23Impl.createKeyGenParameterSpecBuilder(FAKE_KEY_NAME, 3);     // Catch: Throwable -> L5
        Api23Impl.setBlockModeCBC(r4);     // Catch: Throwable -> L5
        Api23Impl.setEncryptionPaddingPKCS7(r4);     // Catch: Throwable -> L5
        KeyGenerator r1 = KeyGenerator.getInstance("AES", KEYSTORE_INSTANCE);     // Catch: Throwable -> L5
        Api23Impl.initKeyGenerator(r1, Api23Impl.buildKeyGenParameterSpec(r4));     // Catch: Throwable -> L5
        r1.generateKey();     // Catch: Throwable -> L5
        SecretKey r0 = (SecretKey) r3.getKey(FAKE_KEY_NAME, null);     // Catch: Throwable -> L5
        Cipher r2 = Cipher.getInstance("AES/CBC/PKCS7Padding");     // Catch: Throwable -> L5
        r2.init(1, r0);     // Catch: Throwable -> L5
        return new BiometricPrompt$CryptoObject(r2);
    L5:
        return null;
    }

    public static BiometricPrompt$CryptoObject unwrapFromBiometricPrompt(BiometricPrompt.CryptoObject r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Cipher r1 = Api28Impl.getCipher(r3);
        if (r1 != null) goto L8;
        Signature r2 = Api28Impl.getSignature(r3);
        if (r2 != null) goto L12;
        Mac r4 = Api28Impl.getMac(r3);
        if (r4 == null) goto L18;
        return new BiometricPrompt$CryptoObject(r4);
    L18:
        if (Build.VERSION.SDK_INT < 30) goto L23;
        IdentityCredential r5 = Api30Impl.getIdentityCredential(r3);
        if (r5 != null) goto L22;
        return null;
    L22:
        return new BiometricPrompt$CryptoObject(r5);
    L23:
        return null;
    L12:
        return new BiometricPrompt$CryptoObject(r2);
    L8:
        return new BiometricPrompt$CryptoObject(r1);
    }

    public static BiometricPrompt$CryptoObject unwrapFromFingerprintManager(FingerprintManagerCompat.CryptoObject r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Cipher r1 = r2.getCipher();
        if (r1 != null) goto L8;
        Signature r3 = r2.getSignature();
        if (r3 != null) goto L12;
        Mac r4 = r2.getMac();
        if (r4 != null) goto L16;
        return null;
    L16:
        return new BiometricPrompt$CryptoObject(r4);
    L12:
        return new BiometricPrompt$CryptoObject(r3);
    L8:
        return new BiometricPrompt$CryptoObject(r1);
    }

    public static BiometricPrompt.CryptoObject wrapForBiometricPrompt(BiometricPrompt$CryptoObject r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Cipher r1 = r3.getCipher();
        if (r1 != null) goto L8;
        Signature r2 = r3.getSignature();
        if (r2 != null) goto L12;
        Mac r4 = r3.getMac();
        if (r4 == null) goto L18;
        return Api28Impl.create(r4);
    L18:
        if (Build.VERSION.SDK_INT < 30) goto L23;
        IdentityCredential r5 = r3.getIdentityCredential();
        if (r5 == null) goto L23;
        return Api30Impl.create(r5);
    L23:
        return null;
    L12:
        return Api28Impl.create(r2);
    L8:
        return Api28Impl.create(r1);
    }

    public static FingerprintManagerCompat.CryptoObject wrapForFingerprintManager(BiometricPrompt$CryptoObject r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Cipher r1 = r3.getCipher();
        if (r1 != null) goto L8;
        Signature r2 = r3.getSignature();
        if (r2 != null) goto L12;
        Mac r4 = r3.getMac();
        if (r4 == null) goto L18;
        return new FingerprintManagerCompat.CryptoObject(r4);
    L18:
        if (Build.VERSION.SDK_INT < 30) goto L20;
        r3.getIdentityCredential();
    L20:
        return null;
    L12:
        return new FingerprintManagerCompat.CryptoObject(r2);
    L8:
        return new FingerprintManagerCompat.CryptoObject(r1);
    }
}
