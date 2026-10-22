package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("net::android")
public class AndroidKeyStore {
    private static final String TAG = "AndroidKeyStore";

    public AndroidKeyStore() {
    }

    private static String getPrivateKeyClassName(PrivateKey r100) {
        return r100.getClass().getName();
    }

    private static boolean privateKeySupportsCipher(PrivateKey r100, String r101) {
        Cipher.getInstance(r101).init(1, r100);     // Catch: Exception -> L5 Throwable -> L8
        return true;
    L5:
        e = move-exception;
        Log.e(TAG, "Exception while checking support for " + r101 + ": " + e, new Object[0]);
    L7:
        return false;
    }

    private static boolean privateKeySupportsSignature(PrivateKey r100, String r101) {
        Signature.getInstance(r101).initSign(r100);     // Catch: Exception -> L6 Throwable -> L9
        return true;
    L6:
        e = move-exception;
        Log.e(TAG, "Exception while checking support for " + r101 + ": " + e, new Object[0]);
    L8:
        return false;
    }

    private static byte[] encryptWithPrivateKey(PrivateKey r100, String r101, byte[] r102) {
        Cipher r103 = Cipher.getInstance(r101);     // Catch: Throwable -> L10 NoSuchAlgorithmException -> L12
        r103.init(1, r100);     // Catch: Exception -> L7
        return r103.doFinal(r102);
    L7:
        e = move-exception;
        Log.e(TAG, "Exception while encrypting input with " + r101 + " and " + r100.getAlgorithm() + " private key (" + r100.getClass().getName() + "): " + e, new Object[0]);
        return null;
    L10:
        e = move-exception;
        Log.e(TAG, "Cipher " + r101 + " not supported: " + e, new Object[0]);
        return null;
    }

    private static byte[] signWithPrivateKey(PrivateKey r100, String r101, byte[] r102) {
        Signature r103 = Signature.getInstance(r101);     // Catch: NoSuchAlgorithmException -> L9
        r103.initSign(r100);     // Catch: Exception -> L6
        r103.update(r102);     // Catch: Exception -> L6
        return r103.sign();
    L6:
        e = move-exception;
        Log.e(TAG, "Exception while signing message with " + r101 + " and " + r100.getAlgorithm() + " private key (" + r100.getClass().getName() + "): " + e, new Object[0]);
        return null;
    L9:
        e = move-exception;
        Log.e(TAG, "Signature algorithm " + r101 + " not supported: " + e, new Object[0]);
        return null;
    }
}
