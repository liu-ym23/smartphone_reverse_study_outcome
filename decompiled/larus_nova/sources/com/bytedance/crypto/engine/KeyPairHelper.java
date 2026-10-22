package com.bytedance.crypto.engine;

import android.content.Context;
import android.os.Bundle;
import android.security.keystore.KeyGenParameterSpec;
import com.bytedance.crypto.cloudtrans.CloudTransException;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.ECGenParameterSpec;
import java.util.Arrays;
import java.util.List;
import kotlin.UByte;

/* JADX INFO: loaded from: classes6.dex */
public class KeyPairHelper {
    private static final String ANDROID_KEYSTORE = "AndroidKeyStore";
    private static final int TAG_OCTET_STRING = 4;
    private static final int TAG_SEQUENCE = 48;

    /* JADX INFO: loaded from: classes15.dex */
    public static class SequenceParser {
        private final byte[] data;
        private int offset;

        public SequenceParser(byte[] r100) {
            if (r100[0] != 48) goto L10;
            this.data = r100;
            int r101 = 1;
            this.offset = 1;
            int r102 = KeyPairHelper.access$000(r100, 1);
            int r103 = this.offset;
            if (r102 <= 127) goto L7;
            r101 = 1 + (r102 / 128);
        L7:
            this.offset = r103 + r101;
            return;
        L10:
            throw new IOException("Expected SEQUENCE tag (0x30)");
        }

        public boolean hasNext() {
            if (this.offset >= this.data.length) goto L5;
            return true;
        L5:
            return false;
        }

        public byte[] nextElement() {
            if (hasNext() == false) goto L11;
            byte[] r100 = this.data;
            int r101 = this.offset;
            byte r102 = r100[r101];
            int r103 = KeyPairHelper.access$000(r100, r101 + 1);
            if (r103 <= 127) goto L7;
            int r104 = (r103 / 128) + 1;
        L8:
            int r105 = (r104 + 1) + r103;
            byte[] r106 = this.data;
            int r107 = this.offset;
            byte[] r108 = Arrays.copyOfRange(r106, r107, r107 + r105);
            this.offset += r105;
            return r108;
        L7:
            r104 = 1;
            goto L8
        L11:
            throw new IOException("No more elements in sequence");
        }
    }

    public KeyPairHelper() {
    }

    public static /* synthetic */ int access$000(byte[] r100, int r101) {
        return decodeLength(r100, r101);
    }

    private static int decodeLength(byte[] r100, int r101) {
        int r102 = r100[r101] & 255;
        if (r102 > 127) goto L5;
        return r102;
    L5:
        int r103 = r102 & 127;
        int r104 = 0;
        int r105 = 0;
    L6:
        if (r104 >= r103) goto L8;
        r105 = (r105 << 8) | (r100[(r101 + 1) + r104] & UByte.MAX_VALUE);
        r104 = r104 + 1;
        goto L6
    L8:
        return r105;
    }

    public static void deleteBDKey(Context r100, String r101) {
        LogUtils.i("KeyPairHelper", "deleteKey succeed, alias:" + r101 + " ret:" + FrameworkSecurityCompat.deleteKey(r100, r101, new Bundle()));
    }

    public static void deleteKey(String r100) {
        KeyStore r101 = KeyStore.getInstance(ANDROID_KEYSTORE);     // Catch: NoSuchAlgorithmException -> L4 IOException -> L6 Throwable -> L8 CertificateException -> L10
        r101.load(null);     // Catch: NoSuchAlgorithmException -> L4 IOException -> L6 Throwable -> L8 CertificateException -> L10
        r101.deleteEntry(r100);     // Catch: NoSuchAlgorithmException -> L4 IOException -> L6 Throwable -> L8 CertificateException -> L10
        return;
    L8:
        e = move-exception;
        LogUtils.e("KeyPairHelper", "deleteKey failed", e);
    }

    public static void generateECDSABDKeyPair(Context r100, String r101) {
        Bundle r102 = new Bundle();
        r102.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_ALGO(), FrameworkSecurityCompat.KeyManagerConst.KEY_ALGORITHM_ECC());
        r102.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_LEN(), 256);
        r102.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_PURPOSE(), FrameworkSecurityCompat.KeyManagerConst.PURPOSE_ATTEST_KEY() | FrameworkSecurityCompat.KeyManagerConst.PURPOSE_AGREE_KEY());
        int r103 = FrameworkSecurityCompat.generateKeyPair(r100, r101, r102);
        if (r103 != FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L6;
        return;
    L6:
        throw new CloudTransException("generate ecdsa keypair failed, error: key manager generate key pair failed, ret:" + r103);
    }

    public static KeyPair generateECDSAKeyPair(String r100, String r101) {
        KeyPairGenerator r102 = KeyPairGenerator.getInstance(CryptoConst.ALGORITHM_EC, ANDROID_KEYSTORE);     // Catch: Throwable -> L7 InvalidAlgorithmParameterException -> L9 NoSuchProviderException -> L11 NoSuchAlgorithmException -> L13
        r102.initialize(new KeyGenParameterSpec.Builder(r100, 68).setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1")).setDigests(new String[]{"SHA-256"}).setAttestationChallenge(r101.getBytes()).setKeySize(256).build());     // Catch: Throwable -> L7 InvalidAlgorithmParameterException -> L9 NoSuchProviderException -> L11 NoSuchAlgorithmException -> L13
        KeyPair r103 = r102.generateKeyPair();     // Catch: Throwable -> L7 InvalidAlgorithmParameterException -> L9 NoSuchProviderException -> L11 NoSuchAlgorithmException -> L13
        if (r103 == null) goto L6;
        return r103;
    L6:
        throw new CloudTransException("generate ecdsa keypair failed, error: key pair is null");     // Catch: Throwable -> L7 InvalidAlgorithmParameterException -> L9 NoSuchProviderException -> L11 NoSuchAlgorithmException -> L13
    L7:
        e = move-exception;
        throw new CloudTransException("generate ecdsa keypair failed, error:" + e.getMessage());
    }

    public static Certificate[] getBDCertificateChain(Context r100, String r101, String r102) {
        Bundle r103 = new Bundle();
        r103.putString(FrameworkSecurityCompat.KeyManagerConst.CHALLENGE(), r102);
        FrameworkSecurityCompat.KmResult r104 = FrameworkSecurityCompat.keyAttestation(r100, r101, r103);
        if (r104.getResultCode() != FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L13;
        List<Certificate> r105 = r104.getCertChain();
        if (r105 == null) goto L11;
        if (r105.isEmpty() == true) goto L11;
        return (Certificate[]) r105.toArray(new Certificate[0]);
    L11:
        throw new CloudTransException("load cert chain failed, error: cert chain is empty");
    L13:
        throw new CloudTransException("load cert chain failed, error: key manager attest key failed, ret:" + r104.getResultCode());
    }

    public static Certificate[] getCertificateChain(String r100) {
        KeyStore r101 = KeyStore.getInstance(ANDROID_KEYSTORE);     // Catch: Exception -> L11
        r101.load(null);     // Catch: Exception -> L11
        Certificate[] r102 = r101.getCertificateChain(r100);     // Catch: Exception -> L11
        if (r102 == null) goto L10;
        if (r102.length == 0) goto L10;
        LogUtils.i("challenge", "challenge:".concat(new String(getChallengeFromAttestation((X509Certificate) r102[0]))));     // Catch: Exception -> L11
        return r102;
    L10:
        throw new CloudTransException("load cert chain failed, error: cert chain is empty");     // Catch: Exception -> L11
    L11:
        e = move-exception;
        throw new CloudTransException("load cert failed, error:" + e.getMessage());
    }

    public static byte[] getChallengeFromAttestation(X509Certificate r100) {
        byte[] r101 = r100.getExtensionValue("1.3.6.1.4.1.11129.2.1.17");
        if (r101 == null) goto L19;
        SequenceParser r102 = new SequenceParser(removeOuterOctetString(r101));
        int r103 = 0;
    L6:
        if (r102.hasNext() == false) goto L17;
        byte[] r104 = r102.nextElement();
        if (r103 == 4) goto L10;
        r103 = r103 + 1;
        goto L6
    L10:
        if (r104[0] != 4) goto L14;
        return parseOctetString(r104);
    L14:
        throw new IOException("Unexpected ASN.1 tag at index 4: " + r104[0]);
    L17:
        throw new IOException("Challenge not found at index 4");
    L19:
        throw new RuntimeException("No Attestation Extension found");
    }

    public static KeyPair loadKeyPair(String r100) {
        KeyStore r101 = KeyStore.getInstance(ANDROID_KEYSTORE);     // Catch: UnrecoverableKeyException -> L4 Throwable -> L6 IOException -> L8 KeyStoreException -> L10 CertificateException -> L12
        r101.load(null);     // Catch: UnrecoverableKeyException -> L4 Throwable -> L6 IOException -> L8 KeyStoreException -> L10 CertificateException -> L12
        return new KeyPair(r101.getCertificate(r100).getPublicKey(), (PrivateKey) r101.getKey(r100, null));
    L6:
        e = move-exception;
        throw new CloudTransException("load key pair failed, error:" + e.getMessage());
    }

    private static byte[] parseOctetString(byte[] r100) {
        if (r100[0] != 4) goto L10;
        int r101 = decodeLength(r100, 1);
        int r102 = 2;
        if (r101 <= 127) goto L8;
        r102 = 2 + (r101 / 128);
    L8:
        return Arrays.copyOfRange(r100, r102, r101 + r102);
    L10:
        throw new IOException("Expected OCTET STRING tag (0x04)");
    }

    private static byte[] removeOuterOctetString(byte[] r100) {
        if (r100[0] != 4) goto L10;
        int r101 = decodeLength(r100, 1);
        int r102 = 2;
        if (r101 <= 127) goto L8;
        r102 = 2 + (r101 / 128);
    L8:
        return Arrays.copyOfRange(r100, r102, r101 + r102);
    L10:
        throw new IOException("Expected OCTET STRING tag (0x04)");
    }
}
