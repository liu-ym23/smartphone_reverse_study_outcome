package com.bytedance.mira.signature;

import android.util.ArrayMap;
import android.util.Pair;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
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

/* JADX INFO: loaded from: classes21.dex */
public class ApkSignatureSchemeV2Verifier {
    private static final int APK_SIGNATURE_SCHEME_V2_BLOCK_ID = 1896449818;
    public static final int SF_ATTRIBUTE_ANDROID_APK_SIGNED_ID = 2;
    private static final int STRIPPING_PROTECTION_ATTR_ID = -1091571699;

    public static class VerifiedSigner {
        public final X509Certificate[][] certs;
        public final byte[] verityRootHash;

        public VerifiedSigner(X509Certificate[][] r100, byte[] r101) {
            this.certs = r100;
            this.verityRootHash = r101;
        }
    }

    public ApkSignatureSchemeV2Verifier() {
    }

    private static boolean isSupportedSignatureAlgorithm(int r100) {
        if (r100 != 513) goto L5;
        return true;
    L5:
        if (r100 != 514) goto L7;
        return true;
    L7:
        if (r100 != 769) goto L9;
        return true;
    L9:
        if (r100 != 1057) goto L11;
        return true;
    L11:
        if (r100 != 1059) goto L13;
        return true;
    L13:
        if (r100 == 1061) goto L23;
        switch(r100) {
            case 257: goto L24;
            case 258: goto L24;
            case 259: goto L24;
            case 260: goto L24;
            default: goto L15;
        };
    L15:
        return false;
    L24:
        return true;
    L23:
        return true;
    }

    private static SignatureInfo findSignature(RandomAccessFile r100) throws IOException, SignatureNotFoundException {
        return ApkSigningBlockUtils.findSignature(r100, APK_SIGNATURE_SCHEME_V2_BLOCK_ID);
    }

    public static byte[] generateFsverityRootHash(String r100) throws IOException, SignatureNotFoundException, DigestException, NoSuchAlgorithmException {
        RandomAccessFile r101 = new RandomAccessFile(r100, "r");
        SignatureInfo r102 = findSignature(r101);     // Catch: Throwable -> L10
        byte[] r103 = verify(r101, false).verityRootHash;     // Catch: Throwable -> L10
        if (r103 != null) goto L7;
        r101.close();
        return null;
    L7:
        byte[] r104 = ApkVerityBuilder.generateFsverityRootHash(r101, ByteBuffer.wrap(r103), r102);     // Catch: Throwable -> L10
        r101.close();
        return r104;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L15
    L17:
        throw th;
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    }

    public static byte[] getVerityRootHash(String r100) throws IOException, SignatureNotFoundException, SecurityException {
        RandomAccessFile r101 = new RandomAccessFile(r100, "r");
        findSignature(r101);     // Catch: Throwable -> L6
        byte[] r102 = verify(r101, false).verityRootHash;     // Catch: Throwable -> L6
        r101.close();
        return r102;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L11
    L13:
        throw th;
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public static boolean hasSignature(String r100) throws IOException {
        RandomAccessFile r101 = new RandomAccessFile(r100, "r");     // Catch: SignatureNotFoundException -> L15
        findSignature(r101);     // Catch: Throwable -> L7
        r101.close();     // Catch: SignatureNotFoundException -> L15
        return true;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L12
    L14:
        throw th;     // Catch: SignatureNotFoundException -> L15
    L12:
        th = move-exception;
        th.addSuppressed(th);     // Catch: SignatureNotFoundException -> L15
    L15:
        return false;
    }

    public static X509Certificate[][] plsCertsNoVerifyOnlyCerts(String r100) throws SignatureNotFoundException, SecurityException, IOException {
        return verify(r100, false).certs;
    }

    public static X509Certificate[][] verify(String r100) throws SignatureNotFoundException, SecurityException, IOException {
        return verify(r100, true).certs;
    }

    private static void verifyAdditionalAttributes(ByteBuffer r100) throws SecurityException, IOException {
    L3:
        if (r100.hasRemaining() == false) goto L20;
        ByteBuffer r101 = ApkSigningBlockUtils.getLengthPrefixedSlice(r100);
        if (r101.remaining() < 4) goto L19;
        if (r101.getInt() != STRIPPING_PROTECTION_ATTR_ID) goto L3;
        if (r101.remaining() < 4) goto L17;
        if (r101.getInt() != 3) goto L3;
        throw new SecurityException("V2 signature indicates APK is signed using APK Signature Scheme v3, but none was found. Signature stripped?");
    L17:
        throw new IOException("V2 Signature Scheme Stripping Protection Attribute  value too small. Expected 4 bytes, but found " + r101.remaining());
    L19:
        throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + r101.remaining());
    }

    public static byte[] generateApkVerity(String r100, ByteBufferFactory r101) throws IOException, SignatureNotFoundException, SecurityException, DigestException, NoSuchAlgorithmException {
        RandomAccessFile r102 = new RandomAccessFile(r100, "r");
        byte[] r103 = ApkSigningBlockUtils.generateApkVerity(r100, r101, findSignature(r102));     // Catch: Throwable -> L6
        r102.close();
        return r103;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L11
    L13:
        throw th;
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    private static VerifiedSigner verify(String r100, boolean r101) throws SignatureNotFoundException, SecurityException, IOException {
        RandomAccessFile r102 = new RandomAccessFile(r100, "r");
        VerifiedSigner r103 = verify(r102, r101);     // Catch: Throwable -> L6
        r102.close();
        return r103;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L11
    L13:
        throw th;
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    private static VerifiedSigner verify(RandomAccessFile r100, boolean r101) throws SignatureNotFoundException, SecurityException, IOException {
        return verify(r100, findSignature(r100), r101);
    }

    private static VerifiedSigner verify(RandomAccessFile r100, SignatureInfo r101, boolean r102) throws SecurityException, IOException {
        ArrayMap r103 = new ArrayMap();
        ArrayList r104 = new ArrayList();
        CertificateFactory r105 = CertificateFactory.getInstance("X.509");     // Catch: CertificateException -> L37
        ByteBuffer r106 = ApkSigningBlockUtils.getLengthPrefixedSlice(r101.signatureBlock);     // Catch: IOException -> L34
        int r107 = 0;
    L7:
        if (r106.hasRemaining() == false) goto L19;
        r107 = r107 + 1;
        r104.add(verifySigner(ApkSigningBlockUtils.getLengthPrefixedSlice(r106), r103, r105));     // Catch: Throwable -> L11 BufferUnderflowException -> L13 IOException -> L15
    L11:
        e = move-exception;
        throw new SecurityException("Failed to parse/verify signer #" + r107 + " block", e);
    L19:
        if (r107 < 1) goto L33;
        if (r103.isEmpty() == true) goto L31;
        if (r102 == false) goto L25;
        ApkSigningBlockUtils.verifyIntegrity(r103, r100, r101);
    L25:
        if (r103.containsKey(3) == false) goto L27;
        byte[] r108 = ApkSigningBlockUtils.parseVerityDigestAndVerifySourceLength((byte[]) r103.get(3), r100.length(), r101);
    L29:
        return new VerifiedSigner((X509Certificate[][]) r104.toArray(new X509Certificate[r104.size()][]), r108);
    L27:
        r108 = null;
        goto L29
    L31:
        throw new SecurityException("No content digests found");
    L33:
        throw new SecurityException("No signers found");
    L34:
        e = move-exception;
        throw new SecurityException("Failed to read list of signers", e);
    L37:
        e = move-exception;
        throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e);
    }

    private static X509Certificate[] verifySigner(ByteBuffer r110, Map<Integer, byte[]> r111, CertificateFactory r112) throws SecurityException, IOException {
        ByteBuffer r100 = ApkSigningBlockUtils.getLengthPrefixedSlice(r110);
        ByteBuffer r101 = ApkSigningBlockUtils.getLengthPrefixedSlice(r110);
        byte[] r113 = ApkSigningBlockUtils.readLengthPrefixedByteArray(r110);
        ArrayList r102 = new ArrayList();
        byte[] r103 = null;
        byte[] r104 = null;
        int r105 = -1;
        int r106 = 0;
    L4:
        if (r101.hasRemaining() == false) goto L22;
        r106 = r106 + 1;
        ByteBuffer r107 = ApkSigningBlockUtils.getLengthPrefixedSlice(r101);     // Catch: Throwable -> L17 IOException -> L19
        if (r107.remaining() < 8) goto L16;
        int r114 = r107.getInt();     // Catch: Throwable -> L17 IOException -> L19
        r102.add(Integer.valueOf(r114));     // Catch: Throwable -> L17 IOException -> L19
        if (isSupportedSignatureAlgorithm(r114) == false) goto L4;
        if (r105 == (-1)) goto L14;
        if (ApkSigningBlockUtils.compareSignatureAlgorithm(r114, r105) <= 0) goto L4;
    L14:
        r104 = ApkSigningBlockUtils.readLengthPrefixedByteArray(r107);     // Catch: Throwable -> L17 IOException -> L19
        r105 = r114;
        goto L4
    L16:
        throw new SecurityException("Signature record too short");     // Catch: Throwable -> L17 IOException -> L19
    L17:
        e = move-exception;
        throw new SecurityException("Failed to parse signature record #" + r106, e);
    L22:
        if (r105 != (-1)) goto L28;
        if (r106 != 0) goto L27;
        throw new SecurityException("No signatures found");
    L27:
        throw new SecurityException("No supported signatures found");
    L28:
        String r108 = ApkSigningBlockUtils.getSignatureAlgorithmJcaKeyAlgorithm(r105);
        Pair<String, ? extends AlgorithmParameterSpec> r109 = ApkSigningBlockUtils.getSignatureAlgorithmJcaSignatureAlgorithm(r105);
        String r115 = (String) r109.first;
        AlgorithmParameterSpec r116 = (AlgorithmParameterSpec) r109.second;
        PublicKey r117 = KeyFactory.getInstance(r108).generatePublic(new X509EncodedKeySpec(r113));     // Catch: SignatureException -> L82 InvalidAlgorithmParameterException -> L84 InvalidKeyException -> L86 InvalidKeySpecException -> L88 Throwable -> L90
        Signature r118 = Signature.getInstance(r115);     // Catch: SignatureException -> L82 InvalidAlgorithmParameterException -> L84 InvalidKeyException -> L86 InvalidKeySpecException -> L88 Throwable -> L90
        r118.initVerify(r117);     // Catch: SignatureException -> L82 InvalidAlgorithmParameterException -> L84 InvalidKeyException -> L86 InvalidKeySpecException -> L88 Throwable -> L90
        if (r116 == null) goto L32;
        r118.setParameter(r116);     // Catch: SignatureException -> L82 InvalidAlgorithmParameterException -> L84 InvalidKeyException -> L86 InvalidKeySpecException -> L88 Throwable -> L90
    L32:
        r118.update(r100);     // Catch: SignatureException -> L82 InvalidAlgorithmParameterException -> L84 InvalidKeyException -> L86 InvalidKeySpecException -> L88 Throwable -> L90
        if (r118.verify(r104) == false) goto L81;
        r100.clear();
        ByteBuffer r119 = ApkSigningBlockUtils.getLengthPrefixedSlice(r100);
        ArrayList r120 = new ArrayList();
        int r121 = 0;
    L36:
        if (r119.hasRemaining() == false) goto L51;
        r121 = r121 + 1;
        ByteBuffer r122 = ApkSigningBlockUtils.getLengthPrefixedSlice(r119);     // Catch: Throwable -> L45 IOException -> L47
        if (r122.remaining() < 8) goto L44;
        int r123 = r122.getInt();     // Catch: Throwable -> L45 IOException -> L47
        r120.add(Integer.valueOf(r123));     // Catch: Throwable -> L45 IOException -> L47
        if (r123 != r105) goto L36;
        r103 = ApkSigningBlockUtils.readLengthPrefixedByteArray(r122);     // Catch: Throwable -> L45 IOException -> L47
        goto L36
    L44:
        throw new IOException("Record too short");     // Catch: Throwable -> L45 IOException -> L47
    L45:
        e = move-exception;
        throw new IOException("Failed to parse digest record #" + r121, e);
    L51:
        if (r102.equals(r120) == false) goto L79;
        int r124 = ApkSigningBlockUtils.getSignatureAlgorithmContentDigestAlgorithm(r105);
        byte[] r125 = r111.put(Integer.valueOf(r124), r103);
        if (r125 != null) goto L55;
    L59:
        ByteBuffer r126 = ApkSigningBlockUtils.getLengthPrefixedSlice(r100);
        ArrayList r127 = new ArrayList();
        int r128 = 0;
    L61:
        if (r126.hasRemaining() == false) goto L69;
        r128 = r128 + 1;
        byte[] r129 = ApkSigningBlockUtils.readLengthPrefixedByteArray(r126);
        r127.add(new VerbatimX509Certificate((X509Certificate) r112.generateCertificate(new ByteArrayInputStream(r129)), r129));
    L65:
        e = move-exception;
        throw new SecurityException("Failed to decode certificate #" + r128, e);
    L69:
        if (r127.isEmpty() == true) goto L77;
        if (Arrays.equals(r113, ((X509Certificate) ListProtector.get(r127, 0)).getPublicKey().getEncoded()) == false) goto L75;
        verifyAdditionalAttributes(ApkSigningBlockUtils.getLengthPrefixedSlice(r100));
        return (X509Certificate[]) r127.toArray(new X509Certificate[r127.size()]);
    L75:
        throw new SecurityException("Public key mismatch between certificate and signature record");
    L77:
        throw new SecurityException("No certificates listed");
    L55:
        if (MessageDigest.isEqual(r125, r103) == true) goto L59;
        throw new SecurityException(ApkSigningBlockUtils.getContentDigestAlgorithmJcaDigestAlgorithm(r124) + " contents digest does not match the digest specified by a preceding signer");
    L79:
        throw new SecurityException("Signature algorithms don't match between digests and signatures records");
    L81:
        throw new SecurityException(r115 + " signature did not verify");
    L90:
        e = move-exception;
        throw new SecurityException("Failed to verify " + r115 + " signature", e);
    }
}
