package com.volcengine.zeus.signature;

import android.util.ArrayMap;
import android.util.Pair;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public final class b {
    public static X509Certificate[][] a(RandomAccessFile r100, String r101) throws SignatureNotFoundException, SecurityException, IOException {
        m r102 = g.f462897a.get(r101).get(1896449818);
        if (r102 == null) goto L40;
        ArrayMap r103 = new ArrayMap();
        ArrayList r104 = new ArrayList();
        CertificateFactory r105 = CertificateFactory.getInstance("X.509");     // Catch: CertificateException -> L36
        ByteBuffer r106 = g.g(r102.f462910a);     // Catch: IOException -> L33
        int r107 = 0;
    L9:
        if (r106.hasRemaining() == false) goto L21;
        r107 = r107 + 1;
        r104.add(b(g.g(r106), r103, r105));     // Catch: Throwable -> L13 BufferUnderflowException -> L15 IOException -> L17
    L13:
        e = move-exception;
        throw new SecurityException("Failed to parse/verify signer #" + r107 + " block", e);
    L21:
        if (r107 < 1) goto L32;
        if (r103.isEmpty() == true) goto L30;
        g.n(r103, r100, r102);
        if (r103.containsKey(3) == false) goto L28;
        g.k((byte[]) r103.get(3), r100.length(), r102);
    L28:
        return (X509Certificate[][]) r104.toArray(new X509Certificate[r104.size()][]);
    L30:
        throw new SecurityException("No content digests found");
    L32:
        throw new SecurityException("No signers found");
    L33:
        e = move-exception;
        throw new SecurityException("Failed to read list of signers", e);
    L36:
        e = move-exception;
        throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e);
    L40:
        throw new SignatureNotFoundException("findVerifiedSigner, No APK Signature Scheme v2 signature in package");
    }

    public static X509Certificate[] b(ByteBuffer r110, Map<Integer, byte[]> r111, CertificateFactory r112) throws SecurityException, IOException {
        ByteBuffer r100 = g.g(r110);
        ByteBuffer r101 = g.g(r110);
        byte[] r113 = g.l(r110);
        ArrayList r102 = new ArrayList();
        byte[] r103 = null;
        byte[] r104 = null;
        int r105 = -1;
        int r106 = 0;
    L3:
        boolean r114 = true;
        if (r101.hasRemaining() == false) goto L35;
        r106 = r106 + 1;
        ByteBuffer r107 = g.g(r101);     // Catch: Throwable -> L30 IOException -> L32
        if (r107.remaining() < 8) goto L29;
        int r115 = r107.getInt();     // Catch: Throwable -> L30 IOException -> L32
        r102.add(Integer.valueOf(r115));     // Catch: Throwable -> L30 IOException -> L32
        if (r115 != 513) goto L11;
    L22:
        if (r114 == false) goto L3;
        if (r105 == (-1)) goto L27;
        if (g.a(r115, r105) <= 0) goto L3;
    L27:
        r104 = g.l(r107);     // Catch: Throwable -> L30 IOException -> L32
        r105 = r115;
        goto L3
    L11:
        if (r115 == 514) goto L22;
        if (r115 == 769) goto L22;
        if (r115 == 1057) goto L22;
        if (r115 == 1059) goto L22;
        if (r115 == 1061) goto L22;
        switch(r115) {
            case 257: goto L22;
            case 258: goto L22;
            case 259: goto L22;
            case 260: goto L22;
            default: goto L21;
        };     // Catch: Throwable -> L30 IOException -> L32
    L21:
        r114 = false;
        goto L22
    L29:
        throw new SecurityException("Signature record too short");     // Catch: Throwable -> L30 IOException -> L32
    L30:
        e = move-exception;
        throw new SecurityException("Failed to parse signature record #" + r106, e);
    L35:
        if (r105 != (-1)) goto L41;
        if (r106 != 0) goto L40;
        throw new SecurityException("No signatures found");
    L40:
        throw new SecurityException("No supported signatures found");
    L41:
        String r108 = g.i(r105);
        Pair<String, ? extends AlgorithmParameterSpec> r109 = g.j(r105);
        String r116 = (String) r109.first;
        AlgorithmParameterSpec r117 = (AlgorithmParameterSpec) r109.second;
        PublicKey r118 = KeyFactory.getInstance(r108).generatePublic(new X509EncodedKeySpec(r113));     // Catch: SignatureException -> L114 InvalidAlgorithmParameterException -> L116 Throwable -> L118 InvalidKeySpecException -> L120 NoSuchAlgorithmException -> L122
        Signature r119 = Signature.getInstance(r116);     // Catch: SignatureException -> L114 InvalidAlgorithmParameterException -> L116 Throwable -> L118 InvalidKeySpecException -> L120 NoSuchAlgorithmException -> L122
        r119.initVerify(r118);     // Catch: SignatureException -> L114 InvalidAlgorithmParameterException -> L116 Throwable -> L118 InvalidKeySpecException -> L120 NoSuchAlgorithmException -> L122
        if (r117 == null) goto L45;
        r119.setParameter(r117);     // Catch: SignatureException -> L114 InvalidAlgorithmParameterException -> L116 Throwable -> L118 InvalidKeySpecException -> L120 NoSuchAlgorithmException -> L122
    L45:
        r119.update(r100);     // Catch: SignatureException -> L114 InvalidAlgorithmParameterException -> L116 Throwable -> L118 InvalidKeySpecException -> L120 NoSuchAlgorithmException -> L122
        if (r119.verify(r104) == false) goto L113;
        r100.clear();
        ByteBuffer r120 = g.g(r100);
        ArrayList r121 = new ArrayList();
        int r122 = 0;
    L49:
        if (r120.hasRemaining() == false) goto L64;
        r122 = r122 + 1;
        ByteBuffer r123 = g.g(r120);     // Catch: Throwable -> L58 IOException -> L60
        if (r123.remaining() < 8) goto L57;
        int r124 = r123.getInt();     // Catch: Throwable -> L58 IOException -> L60
        r121.add(Integer.valueOf(r124));     // Catch: Throwable -> L58 IOException -> L60
        if (r124 != r105) goto L49;
        r103 = g.l(r123);     // Catch: Throwable -> L58 IOException -> L60
        goto L49
    L57:
        throw new IOException("Record too short");     // Catch: Throwable -> L58 IOException -> L60
    L58:
        e = move-exception;
        throw new IOException("Failed to parse digest record #" + r122, e);
    L64:
        if (r102.equals(r121) == false) goto L111;
        int r125 = g.h(r105);
        byte[] r126 = (byte[]) ((ArrayMap) r111).put(Integer.valueOf(r125), r103);
        if (r126 != null) goto L68;
    L72:
        ByteBuffer r127 = g.g(r100);
        ArrayList r128 = new ArrayList();
        int r129 = 0;
    L74:
        if (r127.hasRemaining() == false) goto L82;
        r129 = r129 + 1;
        byte[] r130 = g.l(r127);
        r128.add(new VerbatimX509Certificate((X509Certificate) r112.generateCertificate(new ByteArrayInputStream(r130)), r130));
    L78:
        e = move-exception;
        throw new SecurityException("Failed to decode certificate #" + r129, e);
    L82:
        if (r128.isEmpty() == true) goto L109;
        if (Arrays.equals(r113, ((X509Certificate) ListProtector.get(r128, 0)).getPublicKey().getEncoded()) == false) goto L107;
        ByteBuffer r131 = g.g(r100);
    L87:
        if (r131.hasRemaining() == false) goto L105;
        ByteBuffer r132 = g.g(r131);
        if (r132.remaining() < 4) goto L103;
        if (r132.getInt() != (-1091571699)) goto L87;
        if (r132.remaining() < 4) goto L101;
        if (r132.getInt() != 3) goto L87;
        throw new SecurityException("V2 signature indicates APK is signed using APK Signature Scheme v3, but none was found. Signature stripped?");
    L101:
        throw new IOException("V2 Signature Scheme Stripping Protection Attribute  value too small. Expected 4 bytes, but found " + r132.remaining());
    L103:
        throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + r132.remaining());
    L105:
        return (X509Certificate[]) r128.toArray(new X509Certificate[r128.size()]);
    L107:
        throw new SecurityException("Public key mismatch between certificate and signature record");
    L109:
        throw new SecurityException("No certificates listed");
    L68:
        if (MessageDigest.isEqual(r126, r103) == true) goto L72;
        throw new SecurityException(g.e(r125).concat(" contents digest does not match the digest specified by a preceding signer"));
    L111:
        throw new SecurityException("Signature algorithms don't match between digests and signatures records");
    L113:
        throw new SecurityException(r116 + " signature did not verify");
    L118:
        e = move-exception;
        throw new SecurityException("Failed to verify " + r116 + " signature", e);
    }
}
