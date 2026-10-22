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

/* JADX INFO: loaded from: classes41.dex */
public final class ApkSignatureSchemeV3Verifier {

    public static class PlatformNotSupportedException extends Exception {
        public PlatformNotSupportedException(String r100) {
            super(r100);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<X509Certificate> f462885a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<Integer> f462886b;

        public a(List<X509Certificate> r100, List<Integer> r101) {
            this.f462885a = r100;
            this.f462886b = r101;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final X509Certificate[] f462887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f462888b;

        public b(X509Certificate[] r100, a r101) {
            this.f462887a = r100;
            this.f462888b = r101;
        }
    }

    public static b a(RandomAccessFile r100, String r101) throws IOException, SignatureNotFoundException {
        m r102 = g.f462897a.get(r101).get(-262969152);
        if (r102 == null) goto L43;
        ArrayMap r103 = new ArrayMap();
        CertificateFactory r104 = CertificateFactory.getInstance("X.509");     // Catch: CertificateException -> L39
        ByteBuffer r105 = g.g(r102.f462910a);     // Catch: IOException -> L36
        int r106 = 0;
        b r107 = null;
    L9:
        if (r105.hasRemaining() == false) goto L21;
        r107 = c(g.g(r105), r103, r104);     // Catch: SecurityException -> L12 BufferUnderflowException -> L14 IOException -> L16 PlatformNotSupportedException -> L19
        goto L9
    L11:
        r106 = r106 + 1;
    L16:
        e = e;
    L18:
        throw new SecurityException("Failed to parse/verify signer #" + r106 + " block", e);
    L12:
        e = e;
    L14:
        e = e;
        goto L18
    L21:
        if (r106 < 1) goto L35;
        if (r107 == null) goto L35;
        if (r106 != 1) goto L33;
        if (r103.isEmpty() == true) goto L31;
        g.n(r103, r100, r102);
        if (r103.containsKey(3) == false) goto L29;
        g.k((byte[]) r103.get(3), r100.length(), r102);
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
    L43:
        throw new SignatureNotFoundException("findVerifiedSigner, No APK Signature Scheme v3 signature in package");
    }

    public static b b(ByteBuffer r110, List<X509Certificate> r111, CertificateFactory r112) throws IOException {
        ArrayList r100 = (ArrayList) r111;
        X509Certificate[] r101 = (X509Certificate[]) r100.toArray(new X509Certificate[r100.size()]);
        a r102 = null;
    L4:
        if (r110.hasRemaining() == false) goto L84;
        ByteBuffer r103 = g.g(r110);
        if (r103.remaining() < 4) goto L82;
        if (r103.getInt() != 1000370060) goto L4;
        if (r102 != null) goto L80;
        ArrayList r104 = new ArrayList();
        ArrayList r105 = new ArrayList();
        r103.getInt();     // Catch: CertificateException -> L58 SignatureException -> L62 InvalidAlgorithmParameterException -> L64 InvalidKeyException -> L66 NoSuchAlgorithmException -> L68 Throwable -> L73 IOException -> L75
        HashSet r106 = new HashSet();     // Catch: CertificateException -> L58 SignatureException -> L62 InvalidAlgorithmParameterException -> L64 InvalidKeyException -> L66 NoSuchAlgorithmException -> L68 Throwable -> L73 IOException -> L75
        int r113 = 0;
        VerbatimX509Certificate r114 = null;
        int r115 = -1;
    L88:
    L52:
        e = e;
    L57:
        Throwable r107 = e;
        int r108 = r113;
    L72:
        throw new SecurityException("Failed to verify signature over signed data for certificate #" + r108 + " when verifying Proof-of-rotation record", r107);
    L54:
        e = e;
    L56:
        e = e;
    L50:
        e = e;
    L48:
        e = move-exception;
        CertificateException r109 = e;
        int r116 = r113;
    L61:
        throw new SecurityException("Failed to decode certificate #" + r116 + " when verifying Proof-of-rotation record", r109);
    L15:
        if (r103.hasRemaining() == false) goto L37;
        r113 = r113 + 1;     // Catch: CertificateException -> L48 SignatureException -> L50 InvalidAlgorithmParameterException -> L52 InvalidKeyException -> L54 NoSuchAlgorithmException -> L56 Throwable -> L73 IOException -> L75
        ByteBuffer r117 = g.g(r103);     // Catch: CertificateException -> L48 SignatureException -> L50 InvalidAlgorithmParameterException -> L52 InvalidKeyException -> L54 NoSuchAlgorithmException -> L56 Throwable -> L73 IOException -> L75
        ByteBuffer r118 = g.g(r117);     // Catch: CertificateException -> L48 SignatureException -> L50 InvalidAlgorithmParameterException -> L52 InvalidKeyException -> L54 NoSuchAlgorithmException -> L56 Throwable -> L73 IOException -> L75
        int r119 = r117.getInt();     // Catch: CertificateException -> L48 SignatureException -> L50 InvalidAlgorithmParameterException -> L52 InvalidKeyException -> L54 NoSuchAlgorithmException -> L56 Throwable -> L73 IOException -> L75
        int r120 = r117.getInt();     // Catch: CertificateException -> L48 SignatureException -> L50 InvalidAlgorithmParameterException -> L52 InvalidKeyException -> L54 NoSuchAlgorithmException -> L56 Throwable -> L73 IOException -> L75
        byte[] r121 = g.l(r117);     // Catch: CertificateException -> L48 SignatureException -> L50 InvalidAlgorithmParameterException -> L52 InvalidKeyException -> L54 NoSuchAlgorithmException -> L56 Throwable -> L73 IOException -> L75
        if (r114 == null) goto L26;
        Pair<String, ? extends AlgorithmParameterSpec> r122 = g.j(r115);     // Catch: CertificateException -> L48 SignatureException -> L50 InvalidAlgorithmParameterException -> L52 InvalidKeyException -> L54 NoSuchAlgorithmException -> L56 Throwable -> L73 IOException -> L75
        PublicKey r123 = r114.getPublicKey();     // Catch: CertificateException -> L48 SignatureException -> L50 InvalidAlgorithmParameterException -> L52 InvalidKeyException -> L54 NoSuchAlgorithmException -> L56 Throwable -> L73 IOException -> L75
        Signature r124 = Signature.getInstance((String) r122.first);     // Catch: CertificateException -> L48 SignatureException -> L50 InvalidAlgorithmParameterException -> L52 InvalidKeyException -> L54 NoSuchAlgorithmException -> L56 Throwable -> L73 IOException -> L75
        r124.initVerify(r123);     // Catch: CertificateException -> L48 SignatureException -> L50 InvalidAlgorithmParameterException -> L52 InvalidKeyException -> L54 NoSuchAlgorithmException -> L56 Throwable -> L73 IOException -> L75
        Object r125 = r122.second;     // Catch: CertificateException -> L48 SignatureException -> L50 InvalidAlgorithmParameterException -> L52 InvalidKeyException -> L54 NoSuchAlgorithmException -> L56 Throwable -> L73 IOException -> L75
        if (r125 == null) goto L21;
        r124.setParameter((AlgorithmParameterSpec) r125);     // Catch: CertificateException -> L48 SignatureException -> L50 InvalidAlgorithmParameterException -> L52 InvalidKeyException -> L54 NoSuchAlgorithmException -> L56 Throwable -> L73 IOException -> L75
    L21:
        r124.update(r118);     // Catch: CertificateException -> L48 SignatureException -> L50 InvalidAlgorithmParameterException -> L52 InvalidKeyException -> L54 NoSuchAlgorithmException -> L56 Throwable -> L73 IOException -> L75
        if (r124.verify(r121) == true) goto L26;
        throw new SecurityException("Unable to verify signature of certificate #" + r113 + " using " + ((String) r122.first) + " when verifying Proof-of-rotation record");     // Catch: CertificateException -> L48 SignatureException -> L50 InvalidAlgorithmParameterException -> L52 InvalidKeyException -> L54 NoSuchAlgorithmException -> L56 Throwable -> L73 IOException -> L75
    L26:
        r118.rewind();     // Catch: CertificateException -> L48 SignatureException -> L50 InvalidAlgorithmParameterException -> L52 InvalidKeyException -> L54 NoSuchAlgorithmException -> L56 Throwable -> L73 IOException -> L75
        byte[] r126 = g.l(r118);     // Catch: CertificateException -> L48 SignatureException -> L50 InvalidAlgorithmParameterException -> L52 InvalidKeyException -> L54 NoSuchAlgorithmException -> L56 Throwable -> L73 IOException -> L75
        int r127 = r118.getInt();     // Catch: CertificateException -> L48 SignatureException -> L50 InvalidAlgorithmParameterException -> L52 InvalidKeyException -> L54 NoSuchAlgorithmException -> L56 Throwable -> L73 IOException -> L75
        if (r114 == null) goto L32;
        if (r115 == r127) goto L32;
        throw new SecurityException("Signing algorithm ID mismatch for certificate #" + r113 + " when verifying Proof-of-rotation record");     // Catch: CertificateException -> L48 SignatureException -> L50 InvalidAlgorithmParameterException -> L52 InvalidKeyException -> L54 NoSuchAlgorithmException -> L56 Throwable -> L73 IOException -> L75
    L32:
        r114 = new VerbatimX509Certificate((X509Certificate) r112.generateCertificate(new ByteArrayInputStream(r126)), r126);     // Catch: CertificateException -> L48 SignatureException -> L50 InvalidAlgorithmParameterException -> L52 InvalidKeyException -> L54 NoSuchAlgorithmException -> L56 Throwable -> L73 IOException -> L75
        if (r106.contains(r114) == true) goto L36;
        r106.add(r114);     // Catch: CertificateException -> L48 SignatureException -> L50 InvalidAlgorithmParameterException -> L52 InvalidKeyException -> L54 NoSuchAlgorithmException -> L56 Throwable -> L73 IOException -> L75
        r104.add(r114);     // Catch: CertificateException -> L48 SignatureException -> L50 InvalidAlgorithmParameterException -> L52 InvalidKeyException -> L54 NoSuchAlgorithmException -> L56 Throwable -> L73 IOException -> L75
        r105.add(Integer.valueOf(r119));     // Catch: CertificateException -> L48 SignatureException -> L50 InvalidAlgorithmParameterException -> L52 InvalidKeyException -> L54 NoSuchAlgorithmException -> L56 Throwable -> L73 IOException -> L75
        r115 = r120;
        goto L88
    L36:
        throw new SecurityException("Encountered duplicate entries in Proof-of-rotation record at certificate #" + r113 + ".  All signing certificates should be unique");     // Catch: CertificateException -> L48 SignatureException -> L50 InvalidAlgorithmParameterException -> L52 InvalidKeyException -> L54 NoSuchAlgorithmException -> L56 Throwable -> L73 IOException -> L75
    L37:
        r102 = new a(r104, r105);
    L45:
        e = move-exception;
        throw new SecurityException("Failed to encode certificate when comparing Proof-of-rotation record and signing certificate", e);
    L39:
        if (r104.size() <= 0) goto L4;
        if (Arrays.equals(((X509Certificate) ListProtector.get(r104, r104.size() - 1)).getEncoded(), r101[0].getEncoded()) == true) goto L4;
        throw new SecurityException("Terminal certificate in Proof-of-rotation record does not match APK signing certificate");     // Catch: CertificateEncodingException -> L45
    L73:
        e = move-exception;
        throw new IOException("Failed to parse Proof-of-rotation record", e);
    L64:
        e = e;
    L63:
        r107 = e;
        r108 = 0;
    L66:
        e = e;
    L68:
        e = e;
    L62:
        e = e;
    L58:
        e = move-exception;
        r109 = e;
        r116 = 0;
        goto L61
    L80:
        throw new SecurityException("Encountered multiple Proof-of-rotation records when verifying APK Signature Scheme v3 signature");
    L82:
        throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + r103.remaining());
    L84:
        return new b(r101, r102);
    }

    public static b c(ByteBuffer r110, Map<Integer, byte[]> r111, CertificateFactory r112) throws SecurityException, IOException, PlatformNotSupportedException {
        ByteBuffer r100 = g.g(r110);
        int r101 = r110.getInt();
        int r102 = r110.getInt();
        ByteBuffer r103 = g.g(r110);
        byte[] r104 = g.l(r110);
        ArrayList r105 = new ArrayList();
        int r113 = -1;
        int r114 = 0;
        byte[] r115 = null;
    L3:
        boolean r116 = true;
        int r117 = 8;
        if (r103.hasRemaining() == false) goto L35;
        r114 = r114 + 1;
        ByteBuffer r118 = g.g(r103);     // Catch: BufferUnderflowException -> L30 Throwable -> L32
        if (r118.remaining() < 8) goto L29;
        int r106 = r118.getInt();     // Catch: BufferUnderflowException -> L30 Throwable -> L32
        r105.add(Integer.valueOf(r106));     // Catch: BufferUnderflowException -> L30 Throwable -> L32
        if (r106 != 513) goto L11;
    L22:
        if (r116 == false) goto L3;
        if (r113 == (-1)) goto L27;
        if (g.a(r106, r113) <= 0) goto L3;
    L27:
        r115 = g.l(r118);     // Catch: BufferUnderflowException -> L30 Throwable -> L32
        r113 = r106;
        goto L3
    L11:
        if (r106 == 514) goto L22;
        if (r106 == 769) goto L22;
        if (r106 == 1057) goto L22;
        if (r106 == 1059) goto L22;
        if (r106 == 1061) goto L22;
        switch(r106) {
            case 257: goto L22;
            case 258: goto L22;
            case 259: goto L22;
            case 260: goto L22;
            default: goto L21;
        };     // Catch: BufferUnderflowException -> L30 Throwable -> L32
    L21:
        r116 = false;
        goto L22
    L29:
        throw new SecurityException("Signature record too short");     // Catch: BufferUnderflowException -> L30 Throwable -> L32
    L32:
        e = move-exception;
        throw new SecurityException("Failed to parse signature record #" + r114, e);
    L35:
        if (r113 != (-1)) goto L41;
        if (r114 != 0) goto L40;
        throw new SecurityException("No signatures found");
    L40:
        throw new SecurityException("No supported signatures found");
    L41:
        String r107 = g.i(r113);
        Pair<String, ? extends AlgorithmParameterSpec> r108 = g.j(r113);
        String r109 = (String) r108.first;
        AlgorithmParameterSpec r119 = (AlgorithmParameterSpec) r108.second;
        PublicKey r120 = KeyFactory.getInstance(r107).generatePublic(new X509EncodedKeySpec(r104));     // Catch: SignatureException -> L104 InvalidAlgorithmParameterException -> L106 InvalidKeyException -> L108 InvalidKeySpecException -> L110 Throwable -> L112
        Signature r121 = Signature.getInstance(r109);     // Catch: SignatureException -> L104 InvalidAlgorithmParameterException -> L106 InvalidKeyException -> L108 InvalidKeySpecException -> L110 Throwable -> L112
        r121.initVerify(r120);     // Catch: SignatureException -> L104 InvalidAlgorithmParameterException -> L106 InvalidKeyException -> L108 InvalidKeySpecException -> L110 Throwable -> L112
        if (r119 == null) goto L45;
        r121.setParameter(r119);     // Catch: SignatureException -> L104 InvalidAlgorithmParameterException -> L106 InvalidKeyException -> L108 InvalidKeySpecException -> L110 Throwable -> L112
    L45:
        r121.update(r100);     // Catch: SignatureException -> L104 InvalidAlgorithmParameterException -> L106 InvalidKeyException -> L108 InvalidKeySpecException -> L110 Throwable -> L112
        if (r121.verify(r115) == false) goto L103;
        r100.clear();
        ByteBuffer r122 = g.g(r100);
        ArrayList r123 = new ArrayList();
        byte[] r124 = null;
        int r125 = 0;
    L49:
        if (r122.hasRemaining() == false) goto L65;
        r125 = r125 + 1;
        ByteBuffer r126 = g.g(r122);     // Catch: Throwable -> L59 IOException -> L61
        if (r126.remaining() < r117) goto L58;
        int r127 = r126.getInt();     // Catch: Throwable -> L59 IOException -> L61
        r123.add(Integer.valueOf(r127));     // Catch: Throwable -> L59 IOException -> L61
        if (r127 != r113) goto L56;
        r124 = g.l(r126);     // Catch: Throwable -> L59 IOException -> L61
    L56:
        r117 = 8;
        goto L49
    L58:
        throw new IOException("Record too short");     // Catch: Throwable -> L59 IOException -> L61
    L59:
        e = move-exception;
        throw new IOException("Failed to parse digest record #" + r125, e);
    L65:
        if (r105.equals(r123) == false) goto L101;
        int r128 = g.h(r113);
        byte[] r129 = (byte[]) ((ArrayMap) r111).put(Integer.valueOf(r128), r124);
        if (r129 != null) goto L69;
    L73:
        ByteBuffer r130 = g.g(r100);
        ArrayList r131 = new ArrayList();
        int r132 = 0;
    L75:
        if (r130.hasRemaining() == false) goto L83;
        r132 = r132 + 1;
        byte[] r133 = g.l(r130);
        r131.add(new VerbatimX509Certificate((X509Certificate) r112.generateCertificate(new ByteArrayInputStream(r133)), r133));
    L79:
        e = move-exception;
        throw new SecurityException("Failed to decode certificate #" + r132, e);
    L83:
        if (r131.isEmpty() == true) goto L99;
        if (Arrays.equals(r104, ((X509Certificate) ListProtector.get(r131, 0)).getPublicKey().getEncoded()) == false) goto L97;
        if (r100.getInt() != r101) goto L95;
        if (r100.getInt() != r102) goto L93;
        return b(g.g(r100), r131, r112);
    L93:
        throw new SecurityException("maxSdkVersion mismatch between signed and unsigned in v3 signer block.");
    L95:
        throw new SecurityException("minSdkVersion mismatch between signed and unsigned in v3 signer block.");
    L97:
        throw new SecurityException("Public key mismatch between certificate and signature record");
    L99:
        throw new SecurityException("No certificates listed");
    L69:
        if (MessageDigest.isEqual(r129, r124) == true) goto L73;
        throw new SecurityException(g.e(r128).concat(" contents digest does not match the digest specified by a preceding signer"));
    L101:
        throw new SecurityException("Signature algorithms don't match between digests and signatures records");
    L103:
        throw new SecurityException(r109 + " signature did not verify");
    L112:
        e = move-exception;
        throw new SecurityException("Failed to verify " + r109 + " signature", e);
    }
}
