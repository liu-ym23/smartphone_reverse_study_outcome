package com.bytedance.crypto.obfuscated;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.crypto.keymanager.AttestKeyManager;
import com.bytedance.crypto.modeldist.ModelDistConst;
import com.bytedance.crypto.modeldist.ModelInitResult;
import com.bytedance.crypto.utils.CertUtils;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes15.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c f204234a;

    public c() {
    }

    public static c a() {
        if (f204234a != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f204234a != null) goto L9;
        f204234a = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f204234a;
    }

    public int a(Context r100, InputStream r101, OutputStream r102, String r103) {
        if (r100 == null) goto L11;
        if (r101 == null) goto L11;
        if (r102 == null) goto L11;
        if (r103 == null) goto L11;
        if (r103.isEmpty() == true) goto L11;
        return b.a(r100, r101, r102, r103, ModelDistConst.EXTERNAL_DEVICE_KEY_ALIAS);
    L11:
        LogUtils.e("ModelDistributionManagerImpl", "Invalid input params.");
        return -2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int a(InputStream r110) {
        ConcurrentHashMap<String, Object> r100 = b.f204233a;
        if (r110 != null) goto L5;
        LogUtils.e("ModelDistUtils", "InputStream is null!!");
        return -2;
    L5:
        DataInputStream r101 = new DataInputStream(r110);
        f r102 = null;
        MessageDigest r103 = MessageDigest.getInstance("SHA-256");     // Catch: Exception -> L48
        int r104 = r101.readInt();     // Catch: Exception -> L48
        if (r104 == 329978795) goto L9;
        StringBuilder r105 = new StringBuilder();     // Catch: Exception -> L48
        r105.append("Model magic number mismatch, excepted: 329978795, actually: ");     // Catch: Exception -> L48
        r105.append(r104);     // Catch: Exception -> L48
    L46:
        LogUtils.e("ModelDistUtils", r105.toString());     // Catch: Exception -> L48
    L50:
        if (r102 != null) goto L52;
        LogUtils.e("ModelDistUtils", "Parse model signature info failed!!");
        return -8;
    L52:
        LogUtils.d("ModelDistUtils", "modelSignatureInfo.getModelDigest()" + CryptoUtils.byteArrayToHexString(r102.f204240a));
        X509Certificate r106 = CertUtils.pemStringToX509("-----BEGIN CERTIFICATE-----\nMIIChDCCAgugAwIBAgIUGCf2KtXCv2wJLJDhPWmqC4NogUcwCgYIKoZIzj0EAwMw\nWzESMBAGA1UEChMJQnl0ZURhbmNlMR8wHQYDVQQLExZCeXRlRGFuY2UgU21hcnQg\nRGV2aWNlMSQwIgYDVQQDExtCeXRlRGFuY2UgU21hcnQgRGV2aWNlIFJvb3QwHhcN\nMjUwMjI3MDQxNzI0WhcNNDUxMjMxMTYwMDAwWjBXMRIwEAYDVQQKEwlCeXRlRGFu\nY2UxHzAdBgNVBAsTFkJ5dGVEYW5jZSBTbWFydCBEZXZpY2UxIDAeBgNVBAMTF0J5\ndGVEYW5jZSBTbWFydCBTSUdOIENBMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE\nqEY1tOqjueVxviuVOIBdV+g2BqMOKTRYmTSx0vC9M2fKGCcJeFE32VqtYPtvyDgB\nmVZbvZYxnwdo6dx0MD6RtKOBsDCBrTAOBgNVHQ8BAf8EBAMCAYYwDwYDVR0TAQH/\nBAUwAwEB/zAdBgNVHQ4EFgQUYCEn27oKiFHtO+Q1xHonw5OL4QEwHwYDVR0jBBgw\nFoAU7K7HzdlIzACUAX0TGkAcXyFk6yQwSgYIKwYBBQUHAQEEPjA8MDoGCCsGAQUF\nBzABhi5odHRwOi8vbmV4dXMtcHJvZHVjdGlvbi5ieXRlZGFuY2UubmV0L3BjYS9v\nY3NwMAoGCCqGSM49BAMDA2cAMGQCMEafgMxo9+h04fWDCdF46K2II1RrOC9BUrRS\n50o7HM4wRjYNXTsF11J2enOaTzixzwIwL9l+Hq3OlSYLvRTOnIRD+DmpeSeTsbaV\nrMdjGbg1eRm2P59lkfFFES1BssyzQ5xd\n-----END CERTIFICATE-----");
        if (r106 != null) goto L57;
        LogUtils.e("ModelDistUtils", "Load the preset server signing certificate failed!!");
    L55:
        return -11;
    L57:
        if (CertUtils.validateCertChain(r106, r102.f204242c) == true) goto L60;
        LogUtils.e("ModelDistUtils", "Certificate verification failed!!");
        goto L55
    L60:
        if (CryptoUtils.verifyECDSASignature(((X509Certificate) ListProtector.get(r102.f204242c, 0)).getPublicKey(), r102.f204240a, r102.f204241b, CryptoConst.ALGORITHM_NONEwithECDSA) == true) goto L62;
        LogUtils.e("ModelDistUtils", "Signature verification failed!!");
        return -12;
    L62:
        return 0;
    L9:
        r103.update(CryptoUtils.intToBytes(r104));     // Catch: Exception -> L48
        byte r107 = r101.readByte();     // Catch: Exception -> L48
        LogUtils.d("ModelDistUtils", "version: " + r107);     // Catch: Exception -> L48
        r103.update(r107);     // Catch: Exception -> L48
        int r108 = r101.readByte();     // Catch: Exception -> L48
        if (r108 == 12) goto L12;
        r105 = new StringBuilder();     // Catch: Exception -> L48
        r105.append("Invalid iv len: ");     // Catch: Exception -> L48
        r105.append(r108);     // Catch: Exception -> L48
        goto L46
    L12:
        LogUtils.d("ModelDistUtils", "dataIVLen: " + r108);     // Catch: Exception -> L48
        r103.update(r108);     // Catch: Exception -> L48
        byte[] r109 = new byte[r108];     // Catch: Exception -> L48
        r101.readFully(r109);     // Catch: Exception -> L48
        r103.update(r109);     // Catch: Exception -> L48
        int r111 = r101.readInt();     // Catch: Exception -> L48
        if (r111 > 0) goto L15;
    L45:
        r105 = new StringBuilder();     // Catch: Exception -> L48
        r105.append("Invalid blockSize: ");     // Catch: Exception -> L48
        r105.append(r111);     // Catch: Exception -> L48
        goto L46
    L15:
        if (r111 > 1048576) goto L45;
        LogUtils.d("ModelDistUtils", "blockSize: " + r111);     // Catch: Exception -> L48
        r103.update(CryptoUtils.intToBytes(r111));     // Catch: Exception -> L48
        int r112 = r101.readInt();     // Catch: Exception -> L48
        LogUtils.d("ModelDistUtils", "cipherLen: " + r112);     // Catch: Exception -> L48
        r103.update(CryptoUtils.intToBytes(r112));     // Catch: Exception -> L48
        byte[] r113 = new byte[32768];     // Catch: Exception -> L48
        long r114 = 0;
    L18:
        long r115 = r112;
        if (r114 >= r115) goto L23;
        int r116 = r101.read(r113, 0, (int) Math.min(32768, r115 - r114));     // Catch: Exception -> L48
        if (r116 == (-1)) goto L23;
        r103.update(r113, 0, r116);     // Catch: Exception -> L48
        r114 = r114 + ((long) r116);     // Catch: Exception -> L48
    L23:
        long r117 = r101.readLong();     // Catch: Exception -> L48
        LogUtils.d("ModelDistUtils", "plainDataLen: " + r117);     // Catch: Exception -> L48
        r103.update(CryptoUtils.longToBytes(r117));     // Catch: Exception -> L48
        long r118 = 0;
    L25:
        if (r118 >= r117) goto L29;
        int r119 = r101.read(r113, 0, (int) Math.min(32768, r117 - r118));     // Catch: Exception -> L48
        if (r119 == (-1)) goto L29;
        r103.update(r113, 0, r119);     // Catch: Exception -> L48
        r118 = r118 + ((long) r119);     // Catch: Exception -> L48
    L29:
        byte[] r120 = r103.digest();     // Catch: Exception -> L48
        int r121 = r101.readInt();     // Catch: Exception -> L48
        if (r121 > 0) goto L32;
    L44:
        r105 = new StringBuilder();     // Catch: Exception -> L48
        r105.append("Invalid signatureLen: ");     // Catch: Exception -> L48
    L43:
        r105.append(r121);     // Catch: Exception -> L48
        goto L46
    L32:
        if (r121 > 128) goto L44;
        byte[] r122 = new byte[r121];     // Catch: Exception -> L48
        r101.readFully(r122);     // Catch: Exception -> L48
        LogUtils.d("ModelDistUtils", "signatureLen: " + r121);     // Catch: Exception -> L48
        r121 = r101.readInt();     // Catch: Exception -> L48
        if (r121 <= 0) goto L42;
        if (r121 > 32768) goto L42;
        LogUtils.d("ModelDistUtils", "certificateLen: " + r121);     // Catch: Exception -> L48
        byte[] r123 = new byte[r121];     // Catch: Exception -> L48
        r101.readFully(r123);     // Catch: Exception -> L48
        List<X509Certificate> r124 = CertUtils.convertToX509Certificates(r123);     // Catch: Exception -> L48
        if (r124.size() != 1) goto L50;
        LogUtils.d("ModelDistUtils", "certificates.size(): " + r124.size());     // Catch: Exception -> L48
        r102 = new f(r120, r122, r124);     // Catch: Exception -> L48
    L42:
        r105 = new StringBuilder();     // Catch: Exception -> L48
        r105.append("Invalid certificateLen: ");     // Catch: Exception -> L48
    L48:
        e = move-exception;
        LogUtils.e("ModelDistUtils", "parseModelHeader failed, exception: " + e.getMessage());
        goto L50
    }

    public ModelInitResult a(Context r110, String r111, String r112, Bundle r113) {
        if (r110 != null) goto L5;
    L38:
        LogUtils.e("ModelDistributionManagerImpl", "Input params is invalid.");
        return new ModelInitResult(-2, "");
    L5:
        if (b.a(r111) == false) goto L38;
        if (r113 == null) goto L38;
        boolean r100 = false;
        int r101 = r113.getInt(ModelDistConst.KEY_ATTEST_STRATEGY, 0);
        FrameworkSecurityCompat.KmResult r102 = FrameworkSecurityCompat.getCertificateChain(r110, r111, new Bundle());
        List<Certificate> r103 = r102.getCertChain();
        if (r102.getResultCode() != FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L14;
        if (r103 == null) goto L14;
        if (r103.size() != 4) goto L14;
        r100 = true;
    L14:
        if (r100 == false) goto L22;
        if (r101 != 1) goto L19;
        return b.a(r103, true);
    L19:
        if (r101 != 2) goto L22;
        return new ModelInitResult(-13, "");
    L22:
        LogUtils.i("ModelDistributionManagerImpl", "Regenerate the certificate chain.");
        List<Certificate> r104 = null;
        if (b.a(r111) == true) goto L40;
        String r105 = "Invalid input params.";
    L25:
        LogUtils.e("ModelDistUtils", r105);
    L37:
        return b.a(r104, true);
    L40:
        AttestKeyManager r106 = AttestKeyManager.getInstance();     // Catch: Exception -> L34
        r106.deleteAttestKey(r110, r111);     // Catch: Exception -> L34
        Bundle r107 = new Bundle();     // Catch: Exception -> L34
        r107.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_ALGO(), FrameworkSecurityCompat.KeyManagerConst.KEY_ALGORITHM_ECC());     // Catch: Exception -> L34
        r107.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_LEN(), 256);     // Catch: Exception -> L34
        r107.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_PURPOSE(), FrameworkSecurityCompat.KeyManagerConst.PURPOSE_AGREE_KEY() | FrameworkSecurityCompat.KeyManagerConst.PURPOSE_ATTEST_KEY());     // Catch: Exception -> L34
        List<Certificate> r108 = r106.getAttestCertChain(r110, r111, r112, true, r107);     // Catch: Exception -> L34
        if (r108 != null) goto L29;
    L32:
        LogUtils.e("ModelDistUtils", "The issued certificate chain is invalid.");     // Catch: Exception -> L34
        goto L37
    L29:
        if (r108.size() != 4) goto L32;
        r104 = r108;
    L34:
        e = move-exception;
        r105 = "generateCertChain failed, exception: " + e.getMessage();
        goto L25
    }
}
