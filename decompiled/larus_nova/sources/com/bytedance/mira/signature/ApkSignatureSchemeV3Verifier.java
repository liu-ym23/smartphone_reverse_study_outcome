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
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public class ApkSignatureSchemeV3Verifier {
    private static final int APK_SIGNATURE_SCHEME_V3_BLOCK_ID = -262969152;
    private static final int PROOF_OF_ROTATION_ATTR_ID = 1000370060;
    public static final int SF_ATTRIBUTE_ANDROID_APK_SIGNED_ID = 3;

    public static class PlatformNotSupportedException extends Exception {
        public PlatformNotSupportedException(String r100) {
            super(r100);
        }
    }

    public static class VerifiedProofOfRotation {
        public final List<X509Certificate> certs;
        public final List<Integer> flagsList;

        public VerifiedProofOfRotation(List<X509Certificate> r100, List<Integer> r101) {
            this.certs = r100;
            this.flagsList = r101;
        }
    }

    public static class VerifiedSigner {
        public final X509Certificate[] certs;
        public final VerifiedProofOfRotation por;
        public byte[] verityRootHash;

        public VerifiedSigner(X509Certificate[] r100, VerifiedProofOfRotation r101) {
            this.certs = r100;
            this.por = r101;
        }
    }

    public ApkSignatureSchemeV3Verifier() {
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
        return ApkSigningBlockUtils.findSignature(r100, APK_SIGNATURE_SCHEME_V3_BLOCK_ID);
    }

    public static byte[] generateFsverityRootHash(String r100) throws NoSuchAlgorithmException, DigestException, IOException, SignatureNotFoundException {
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

    public static VerifiedSigner plsCertsNoVerifyOnlyCerts(String r100) throws SignatureNotFoundException, SecurityException, IOException {
        return verify(r100, false);
    }

    public static VerifiedSigner verify(String r100) throws SignatureNotFoundException, SecurityException, IOException {
        return verify(r100, true);
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

    private static VerifiedProofOfRotation verifyProofOfRotationStruct(ByteBuffer r110, CertificateFactory r111) throws SecurityException, IOException {
        ArrayList r100 = new ArrayList();
        ArrayList r101 = new ArrayList();
        int r102 = 0;
        r110.getInt();     // Catch: CertificateException -> L29 SignatureException -> L32 InvalidAlgorithmParameterException -> L34 InvalidKeyException -> L36 NoSuchAlgorithmException -> L38 BufferUnderflowException -> L41 IOException -> L43
        HashSet r103 = new HashSet();     // Catch: CertificateException -> L29 SignatureException -> L32 InvalidAlgorithmParameterException -> L34 InvalidKeyException -> L36 NoSuchAlgorithmException -> L38 BufferUnderflowException -> L41 IOException -> L43
        int r104 = -1;
        VerbatimX509Certificate r105 = null;
    L5:
        if (r110.hasRemaining() == false) goto L28;
        r102 = r102 + 1;     // Catch: CertificateException -> L29 SignatureException -> L32 InvalidAlgorithmParameterException -> L34 InvalidKeyException -> L36 NoSuchAlgorithmException -> L38 BufferUnderflowException -> L41 IOException -> L43
        ByteBuffer r106 = ApkSigningBlockUtils.getLengthPrefixedSlice(r110);     // Catch: CertificateException -> L29 SignatureException -> L32 InvalidAlgorithmParameterException -> L34 InvalidKeyException -> L36 NoSuchAlgorithmException -> L38 BufferUnderflowException -> L41 IOException -> L43
        ByteBuffer r107 = ApkSigningBlockUtils.getLengthPrefixedSlice(r106);     // Catch: CertificateException -> L29 SignatureException -> L32 InvalidAlgorithmParameterException -> L34 InvalidKeyException -> L36 NoSuchAlgorithmException -> L38 BufferUnderflowException -> L41 IOException -> L43
        int r108 = r106.getInt();     // Catch: CertificateException -> L29 SignatureException -> L32 InvalidAlgorithmParameterException -> L34 InvalidKeyException -> L36 NoSuchAlgorithmException -> L38 BufferUnderflowException -> L41 IOException -> L43
        int r112 = r106.getInt();     // Catch: CertificateException -> L29 SignatureException -> L32 InvalidAlgorithmParameterException -> L34 InvalidKeyException -> L36 NoSuchAlgorithmException -> L38 BufferUnderflowException -> L41 IOException -> L43
        byte[] r109 = ApkSigningBlockUtils.readLengthPrefixedByteArray(r106);     // Catch: CertificateException -> L29 SignatureException -> L32 InvalidAlgorithmParameterException -> L34 InvalidKeyException -> L36 NoSuchAlgorithmException -> L38 BufferUnderflowException -> L41 IOException -> L43
        if (r105 == null) goto L16;
        Pair<String, ? extends AlgorithmParameterSpec> r113 = ApkSigningBlockUtils.getSignatureAlgorithmJcaSignatureAlgorithm(r104);     // Catch: CertificateException -> L29 SignatureException -> L32 InvalidAlgorithmParameterException -> L34 InvalidKeyException -> L36 NoSuchAlgorithmException -> L38 BufferUnderflowException -> L41 IOException -> L43
        PublicKey r114 = r105.getPublicKey();     // Catch: CertificateException -> L29 SignatureException -> L32 InvalidAlgorithmParameterException -> L34 InvalidKeyException -> L36 NoSuchAlgorithmException -> L38 BufferUnderflowException -> L41 IOException -> L43
        Signature r115 = Signature.getInstance((String) r113.first);     // Catch: CertificateException -> L29 SignatureException -> L32 InvalidAlgorithmParameterException -> L34 InvalidKeyException -> L36 NoSuchAlgorithmException -> L38 BufferUnderflowException -> L41 IOException -> L43
        r115.initVerify(r114);     // Catch: CertificateException -> L29 SignatureException -> L32 InvalidAlgorithmParameterException -> L34 InvalidKeyException -> L36 NoSuchAlgorithmException -> L38 BufferUnderflowException -> L41 IOException -> L43
        Object r116 = r113.second;     // Catch: CertificateException -> L29 SignatureException -> L32 InvalidAlgorithmParameterException -> L34 InvalidKeyException -> L36 NoSuchAlgorithmException -> L38 BufferUnderflowException -> L41 IOException -> L43
        if (r116 == null) goto L11;
        r115.setParameter((AlgorithmParameterSpec) r116);     // Catch: CertificateException -> L29 SignatureException -> L32 InvalidAlgorithmParameterException -> L34 InvalidKeyException -> L36 NoSuchAlgorithmException -> L38 BufferUnderflowException -> L41 IOException -> L43
    L11:
        r115.update(r107);     // Catch: CertificateException -> L29 SignatureException -> L32 InvalidAlgorithmParameterException -> L34 InvalidKeyException -> L36 NoSuchAlgorithmException -> L38 BufferUnderflowException -> L41 IOException -> L43
        if (r115.verify(r109) == true) goto L16;
        throw new SecurityException("Unable to verify signature of certificate #" + r102 + " using " + ((String) r113.first) + " when verifying Proof-of-rotation record");     // Catch: CertificateException -> L29 SignatureException -> L32 InvalidAlgorithmParameterException -> L34 InvalidKeyException -> L36 NoSuchAlgorithmException -> L38 BufferUnderflowException -> L41 IOException -> L43
    L16:
        r107.rewind();     // Catch: CertificateException -> L29 SignatureException -> L32 InvalidAlgorithmParameterException -> L34 InvalidKeyException -> L36 NoSuchAlgorithmException -> L38 BufferUnderflowException -> L41 IOException -> L43
        byte[] r117 = ApkSigningBlockUtils.readLengthPrefixedByteArray(r107);     // Catch: CertificateException -> L29 SignatureException -> L32 InvalidAlgorithmParameterException -> L34 InvalidKeyException -> L36 NoSuchAlgorithmException -> L38 BufferUnderflowException -> L41 IOException -> L43
        int r118 = r107.getInt();     // Catch: CertificateException -> L29 SignatureException -> L32 InvalidAlgorithmParameterException -> L34 InvalidKeyException -> L36 NoSuchAlgorithmException -> L38 BufferUnderflowException -> L41 IOException -> L43
        if (r105 == null) goto L22;
        if (r104 == r118) goto L22;
        throw new SecurityException("Signing algorithm ID mismatch for certificate #" + r102 + " when verifying Proof-of-rotation record");     // Catch: CertificateException -> L29 SignatureException -> L32 InvalidAlgorithmParameterException -> L34 InvalidKeyException -> L36 NoSuchAlgorithmException -> L38 BufferUnderflowException -> L41 IOException -> L43
    L22:
        r105 = new VerbatimX509Certificate((X509Certificate) r111.generateCertificate(new ByteArrayInputStream(r117)), r117);     // Catch: CertificateException -> L29 SignatureException -> L32 InvalidAlgorithmParameterException -> L34 InvalidKeyException -> L36 NoSuchAlgorithmException -> L38 BufferUnderflowException -> L41 IOException -> L43
        if (r103.contains(r105) == true) goto L26;
        r103.add(r105);     // Catch: CertificateException -> L29 SignatureException -> L32 InvalidAlgorithmParameterException -> L34 InvalidKeyException -> L36 NoSuchAlgorithmException -> L38 BufferUnderflowException -> L41 IOException -> L43
        r100.add(r105);     // Catch: CertificateException -> L29 SignatureException -> L32 InvalidAlgorithmParameterException -> L34 InvalidKeyException -> L36 NoSuchAlgorithmException -> L38 BufferUnderflowException -> L41 IOException -> L43
        r101.add(Integer.valueOf(r108));     // Catch: CertificateException -> L29 SignatureException -> L32 InvalidAlgorithmParameterException -> L34 InvalidKeyException -> L36 NoSuchAlgorithmException -> L38 BufferUnderflowException -> L41 IOException -> L43
        r104 = r112;
        goto L5
    L26:
        throw new SecurityException("Encountered duplicate entries in Proof-of-rotation record at certificate #" + r102 + ".  All signing certificates should be unique");     // Catch: CertificateException -> L29 SignatureException -> L32 InvalidAlgorithmParameterException -> L34 InvalidKeyException -> L36 NoSuchAlgorithmException -> L38 BufferUnderflowException -> L41 IOException -> L43
    L28:
        return new VerifiedProofOfRotation(r100, r101);
    L43:
        e = e;
    L45:
        throw new IOException("Failed to parse Proof-of-rotation record", e);
    L41:
        e = e;
    L34:
        e = e;
    L40:
        throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
    L36:
        e = e;
    L38:
        e = e;
    L32:
        e = e;
    L29:
        e = move-exception;
        throw new SecurityException("Failed to decode certificate #0 when verifying Proof-of-rotation record", e);
    }

    private static VerifiedSigner verify(RandomAccessFile r100, boolean r101) throws SignatureNotFoundException, SecurityException, IOException {
        return verify(r100, findSignature(r100), r101);
    }

    private static VerifiedSigner verify(RandomAccessFile r100, SignatureInfo r101, boolean r102) throws SecurityException, IOException {
        ArrayMap r103 = new ArrayMap();
        CertificateFactory r104 = CertificateFactory.getInstance("X.509");     // Catch: CertificateException -> L39
        ByteBuffer r105 = ApkSigningBlockUtils.getLengthPrefixedSlice(r101.signatureBlock);     // Catch: IOException -> L36
        int r106 = 0;
        VerifiedSigner r107 = null;
    L7:
        if (r105.hasRemaining() == false) goto L19;
        r107 = verifySigner(ApkSigningBlockUtils.getLengthPrefixedSlice(r105), r103, r104);     // Catch: SecurityException -> L10 BufferUnderflowException -> L12 IOException -> L14 PlatformNotSupportedException -> L17
        goto L7
    L9:
        r106 = r106 + 1;
    L14:
        e = e;
    L16:
        throw new SecurityException("Failed to parse/verify signer #" + r106 + " block", e);
    L10:
        e = e;
    L12:
        e = e;
        goto L16
    L19:
        if (r106 < 1) goto L35;
        if (r107 == null) goto L35;
        if (r106 != 1) goto L33;
        if (r103.isEmpty() == true) goto L31;
        if (r102 == false) goto L27;
        ApkSigningBlockUtils.verifyIntegrity(r103, r100, r101);
    L27:
        if (r103.containsKey(3) == false) goto L29;
        r107.verityRootHash = ApkSigningBlockUtils.parseVerityDigestAndVerifySourceLength((byte[]) r103.get(3), r100.length(), r101);
    L29:
        return r107;
    L31:
        throw new SecurityException("No content digests found");
    L33:
        throw new SecurityException("APK Signature Scheme V3 only supports one signer: multiple signers found.");
    L35:
        throw new SecurityException("No signers found");
    L36:
        e = move-exception;
        throw new SecurityException("Failed to read list of signers", e);
    L39:
        e = move-exception;
        throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e);
    }

    private static VerifiedSigner verifyAdditionalAttributes(ByteBuffer r100, List<X509Certificate> r101, CertificateFactory r102) throws IOException {
        X509Certificate[] r103 = (X509Certificate[]) r101.toArray(new X509Certificate[r101.size()]);
        VerifiedProofOfRotation r104 = null;
    L4:
        if (r100.hasRemaining() == false) goto L27;
        ByteBuffer r105 = ApkSigningBlockUtils.getLengthPrefixedSlice(r100);
        if (r105.remaining() < 4) goto L25;
        if (r105.getInt() != PROOF_OF_ROTATION_ATTR_ID) goto L4;
        if (r104 != null) goto L23;
        r104 = verifyProofOfRotationStruct(r105, r102);
    L19:
        e = move-exception;
        throw new SecurityException("Failed to encode certificate when comparing Proof-of-rotation record and signing certificate", e);
    L13:
        if (r104.certs.size() <= 0) goto L4;
        List<X509Certificate> r106 = r104.certs;     // Catch: CertificateEncodingException -> L19
        if (Arrays.equals(((X509Certificate) ListProtector.get(r106, r106.size() - 1)).getEncoded(), r103[0].getEncoded()) == true) goto L4;
        throw new SecurityException("Terminal certificate in Proof-of-rotation record does not match APK signing certificate");     // Catch: CertificateEncodingException -> L19
    L23:
        throw new SecurityException("Encountered multiple Proof-of-rotation records when verifying APK Signature Scheme v3 signature");
    L25:
        throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + r105.remaining());
    L27:
        return new VerifiedSigner(r103, r104);
    }

    private static VerifiedSigner verifySigner(ByteBuffer r110, Map<Integer, byte[]> r111, CertificateFactory r112) throws SecurityException, IOException, PlatformNotSupportedException {
        ByteBuffer r100 = ApkSigningBlockUtils.getLengthPrefixedSlice(r110);
        int r101 = r110.getInt();
        int r102 = r110.getInt();
        ByteBuffer r103 = ApkSigningBlockUtils.getLengthPrefixedSlice(r110);
        byte[] r104 = ApkSigningBlockUtils.readLengthPrefixedByteArray(r110);
        ArrayList r105 = new ArrayList();
        byte[] r106 = null;
        byte[] r113 = null;
        int r114 = -1;
        int r115 = 0;
    L4:
        if (r103.hasRemaining() == false) goto L22;
        r115 = r115 + 1;
        ByteBuffer r116 = ApkSigningBlockUtils.getLengthPrefixedSlice(r103);     // Catch: Throwable -> L17 IOException -> L19
        if (r116.remaining() < 8) goto L16;
        int r117 = r116.getInt();     // Catch: Throwable -> L17 IOException -> L19
        r105.add(Integer.valueOf(r117));     // Catch: Throwable -> L17 IOException -> L19
        if (isSupportedSignatureAlgorithm(r117) == false) goto L4;
        if (r114 == (-1)) goto L14;
        if (ApkSigningBlockUtils.compareSignatureAlgorithm(r117, r114) <= 0) goto L4;
    L14:
        r113 = ApkSigningBlockUtils.readLengthPrefixedByteArray(r116);     // Catch: Throwable -> L17 IOException -> L19
        r114 = r117;
        goto L4
    L16:
        throw new SecurityException("Signature record too short");     // Catch: Throwable -> L17 IOException -> L19
    L17:
        e = move-exception;
        throw new SecurityException("Failed to parse signature record #" + r115, e);
    L22:
        if (r114 != (-1)) goto L28;
        if (r115 != 0) goto L27;
        throw new SecurityException("No signatures found");
    L27:
        throw new SecurityException("No supported signatures found");
    L28:
        String r107 = ApkSigningBlockUtils.getSignatureAlgorithmJcaKeyAlgorithm(r114);
        Pair<String, ? extends AlgorithmParameterSpec> r108 = ApkSigningBlockUtils.getSignatureAlgorithmJcaSignatureAlgorithm(r114);
        String r118 = (String) r108.first;
        AlgorithmParameterSpec r109 = (AlgorithmParameterSpec) r108.second;
        PublicKey r119 = KeyFactory.getInstance(r107).generatePublic(new X509EncodedKeySpec(r104));     // Catch: SignatureException -> L90 InvalidAlgorithmParameterException -> L92 Throwable -> L94 InvalidKeySpecException -> L96 NoSuchAlgorithmException -> L98
        Signature r120 = Signature.getInstance(r118);     // Catch: SignatureException -> L90 InvalidAlgorithmParameterException -> L92 Throwable -> L94 InvalidKeySpecException -> L96 NoSuchAlgorithmException -> L98
        r120.initVerify(r119);     // Catch: SignatureException -> L90 InvalidAlgorithmParameterException -> L92 Throwable -> L94 InvalidKeySpecException -> L96 NoSuchAlgorithmException -> L98
        if (r109 == null) goto L32;
        r120.setParameter(r109);     // Catch: SignatureException -> L90 InvalidAlgorithmParameterException -> L92 Throwable -> L94 InvalidKeySpecException -> L96 NoSuchAlgorithmException -> L98
    L32:
        r120.update(r100);     // Catch: SignatureException -> L90 InvalidAlgorithmParameterException -> L92 Throwable -> L94 InvalidKeySpecException -> L96 NoSuchAlgorithmException -> L98
        if (r120.verify(r113) == false) goto L89;
        r100.clear();
        ByteBuffer r121 = ApkSigningBlockUtils.getLengthPrefixedSlice(r100);
        ArrayList r122 = new ArrayList();
        int r123 = 0;
    L36:
        if (r121.hasRemaining() == false) goto L51;
        r123 = r123 + 1;
        ByteBuffer r124 = ApkSigningBlockUtils.getLengthPrefixedSlice(r121);     // Catch: Throwable -> L45 IOException -> L47
        if (r124.remaining() < 8) goto L44;
        int r125 = r124.getInt();     // Catch: Throwable -> L45 IOException -> L47
        r122.add(Integer.valueOf(r125));     // Catch: Throwable -> L45 IOException -> L47
        if (r125 != r114) goto L36;
        r106 = ApkSigningBlockUtils.readLengthPrefixedByteArray(r124);     // Catch: Throwable -> L45 IOException -> L47
        goto L36
    L44:
        throw new IOException("Record too short");     // Catch: Throwable -> L45 IOException -> L47
    L45:
        e = move-exception;
        throw new IOException("Failed to parse digest record #" + r123, e);
    L51:
        if (r105.equals(r122) == false) goto L87;
        int r126 = ApkSigningBlockUtils.getSignatureAlgorithmContentDigestAlgorithm(r114);
        byte[] r127 = r111.put(Integer.valueOf(r126), r106);
        if (r127 != null) goto L55;
    L59:
        ByteBuffer r128 = ApkSigningBlockUtils.getLengthPrefixedSlice(r100);
        ArrayList r129 = new ArrayList();
        int r130 = 0;
    L61:
        if (r128.hasRemaining() == false) goto L69;
        r130 = r130 + 1;
        byte[] r131 = ApkSigningBlockUtils.readLengthPrefixedByteArray(r128);
        r129.add(new VerbatimX509Certificate((X509Certificate) r112.generateCertificate(new ByteArrayInputStream(r131)), r131));
    L65:
        e = move-exception;
        throw new SecurityException("Failed to decode certificate #" + r130, e);
    L69:
        if (r129.isEmpty() == true) goto L85;
        if (Arrays.equals(r104, ((X509Certificate) ListProtector.get(r129, 0)).getPublicKey().getEncoded()) == false) goto L83;
        if (r100.getInt() != r101) goto L81;
        if (r100.getInt() != r102) goto L79;
        return verifyAdditionalAttributes(ApkSigningBlockUtils.getLengthPrefixedSlice(r100), r129, r112);
    L79:
        throw new SecurityException("maxSdkVersion mismatch between signed and unsigned in v3 signer block.");
    L81:
        throw new SecurityException("minSdkVersion mismatch between signed and unsigned in v3 signer block.");
    L83:
        throw new SecurityException("Public key mismatch between certificate and signature record");
    L85:
        throw new SecurityException("No certificates listed");
    L55:
        if (MessageDigest.isEqual(r127, r106) == true) goto L59;
        throw new SecurityException(ApkSigningBlockUtils.getContentDigestAlgorithmJcaDigestAlgorithm(r126) + " contents digest does not match the digest specified by a preceding signer");
    L87:
        throw new SecurityException("Signature algorithms don't match between digests and signatures records");
    L89:
        throw new SecurityException(r118 + " signature did not verify");
    L94:
        e = move-exception;
        throw new SecurityException("Failed to verify " + r118 + " signature", e);
    }
}
