package com.bytedance.mira.signature;

import android.content.pm.Signature;
import com.bytedance.mira.compat.q.DoubleReflector;
import com.bytedance.mira.log.MiraMonitor;
import com.bytedance.mira.util.OSUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.DigestException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes21.dex */
public class ApkSignatureVerifier {

    public static class Result {
        public final Certificate[][] certs;
        public final int signatureSchemeVersion;
        public final Signature[] sigs;

        public Result(Certificate[][] r100, Signature[] r101, int r102) {
            this.certs = r100;
            this.sigs = r101;
            this.signatureSchemeVersion = r102;
        }
    }

    public ApkSignatureVerifier() {
    }

    public static Signature[] convertToSignatures(Certificate[][] r100) throws CertificateEncodingException {
        Signature[] r101 = new Signature[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L23;
        if (OSUtil.isAndroidLP() == false) goto L21;
        Constructor r103 = DoubleReflector.getConstructor(Signature.class, new Class[]{Certificate[].class});
        if (r103 == null) goto L10;
        r103.setAccessible(true);
    L10:
        if (r103 == null) goto L22;
        if (r103.isAccessible() == false) goto L22;
        r101[r102] = (Signature) r103.newInstance(new Object[]{r100[r102]});     // Catch: InvocationTargetException -> L15 IllegalAccessException -> L17 InstantiationException -> L19
    L17:
        e = move-exception;
        e.printStackTrace();
    L19:
        e = move-exception;
        e.printStackTrace();
    L15:
        e = move-exception;
        e.printStackTrace();
    L22:
        r102 = r102 + 1;
        goto L4
    L21:
        r101[r102] = new Signature(r100[r102][0].getEncoded());
        goto L22
    L23:
        return r101;
    }

    public static byte[] generateFsverityRootHash(String r100) throws NoSuchAlgorithmException, DigestException, IOException {
        return ApkSignatureSchemeV3Verifier.generateFsverityRootHash(r100);
    L4:
        return ApkSignatureSchemeV2Verifier.generateFsverityRootHash(r100);
    L6:
        return null;
    }

    public static byte[] getVerityRootHash(String r100) throws IOException, SignatureNotFoundException, SecurityException {
        return ApkSignatureSchemeV3Verifier.getVerityRootHash(r100);
    L5:
        return ApkSignatureSchemeV2Verifier.getVerityRootHash(r100);
    }

    public static byte[] generateApkVerity(String r100, ByteBufferFactory r101) throws IOException, SignatureNotFoundException, SecurityException, DigestException, NoSuchAlgorithmException {
        return ApkSignatureSchemeV3Verifier.generateApkVerity(r100, r101);
    L5:
        return ApkSignatureSchemeV2Verifier.generateApkVerity(r100, r101);
    }

    public static SigningDetails plsCertsNoVerifyOnlyCerts(String r110, int r111) throws VerifyException {
        if (r111 > 3) goto L39;
        ApkSignatureSchemeV3Verifier.VerifiedSigner r100 = ApkSignatureSchemeV3Verifier.plsCertsNoVerifyOnlyCerts(r110);     // Catch: Exception -> L13 SignatureNotFoundException -> L16
        Signature[] r112 = convertToSignatures(new Certificate[][]{r100.certs});     // Catch: Exception -> L13 SignatureNotFoundException -> L16
        ApkSignatureSchemeV3Verifier.VerifiedProofOfRotation r113 = r100.por;     // Catch: Exception -> L13 SignatureNotFoundException -> L16
        if (r113 == null) goto L10;
        int r114 = r113.certs.size();     // Catch: Exception -> L13 SignatureNotFoundException -> L16
        Signature[] r115 = new Signature[r114];     // Catch: Exception -> L13 SignatureNotFoundException -> L16
        int[] r116 = new int[r100.por.flagsList.size()];     // Catch: Exception -> L13 SignatureNotFoundException -> L16
        int r117 = 0;
    L8:
        if (r117 >= r114) goto L11;
        r115[r117] = new Signature(((X509Certificate) ListProtector.get(r100.por.certs, r117)).getEncoded());     // Catch: Exception -> L13 SignatureNotFoundException -> L16
        r116[r117] = ((Integer) ListProtector.get(r100.por.flagsList, r117)).intValue();     // Catch: Exception -> L13 SignatureNotFoundException -> L16
        r117 = r117 + 1;     // Catch: Exception -> L13 SignatureNotFoundException -> L16
    L11:
        return new SigningDetails(r112, 3, r115, r116);
    L10:
        r115 = null;
        r116 = null;
    L16:
        e = move-exception;
        if (r111 >= 3) goto L37;
        if (r111 > 2) goto L35;
        return new SigningDetails(convertToSignatures(ApkSignatureSchemeV2Verifier.plsCertsNoVerifyOnlyCerts(r110)), 2);
    L25:
        e = move-exception;
        if (r111 >= 2) goto L33;
        if (r111 > 1) goto L31;
        return ApkSignatureSchemeV1Verifier.verify(r110, false);
    L31:
        throw new VerifyException(4, "No signature found in package of version " + r111 + " or newer for package " + r110);
    L33:
        throw new VerifyException(4, "No APK Signature Scheme v2 signature in package " + r110, e);
    L22:
        e = move-exception;
        throw new VerifyException(4, "Failed to collect certificates from " + r110 + " using APK Signature Scheme v2", e);
    L35:
        throw new VerifyException(4, "No signature found in package of version " + r111 + " or newer for package " + r110);
    L37:
        throw new VerifyException(4, "No APK Signature Scheme v3 signature in package " + r110, e);
    L13:
        e = move-exception;
        throw new VerifyException(4, "Failed to collect certificates from " + r110 + " using APK Signature Scheme v3", e);
    L39:
        throw new VerifyException(4, "No signature found in package of version " + r111 + " or newer for package " + r110);
    }

    public static SigningDetails verify(String r110, int r111) throws VerifyException {
        if (r111 > 3) goto L42;
        MiraMonitor.reportSignEvent(MiraMonitor.SCHEMA_V3);     // Catch: Exception -> L13 SignatureNotFoundException -> L16
        ApkSignatureSchemeV3Verifier.VerifiedSigner r100 = ApkSignatureSchemeV3Verifier.verify(r110);     // Catch: Exception -> L13 SignatureNotFoundException -> L16
        int r112 = 0;
        Signature[] r113 = convertToSignatures(new Certificate[][]{r100.certs});     // Catch: Exception -> L13 SignatureNotFoundException -> L16
        ApkSignatureSchemeV3Verifier.VerifiedProofOfRotation r114 = r100.por;     // Catch: Exception -> L13 SignatureNotFoundException -> L16
        if (r114 == null) goto L10;
        int r115 = r114.certs.size();     // Catch: Exception -> L13 SignatureNotFoundException -> L16
        Signature[] r116 = new Signature[r115];     // Catch: Exception -> L13 SignatureNotFoundException -> L16
        int[] r117 = new int[r100.por.flagsList.size()];     // Catch: Exception -> L13 SignatureNotFoundException -> L16
    L8:
        if (r112 >= r115) goto L11;
        r116[r112] = new Signature(((X509Certificate) ListProtector.get(r100.por.certs, r112)).getEncoded());     // Catch: Exception -> L13 SignatureNotFoundException -> L16
        r117[r112] = ((Integer) ListProtector.get(r100.por.flagsList, r112)).intValue();     // Catch: Exception -> L13 SignatureNotFoundException -> L16
        r112 = r112 + 1;     // Catch: Exception -> L13 SignatureNotFoundException -> L16
    L11:
        return new SigningDetails(r113, 3, r116, r117);
    L10:
        r116 = null;
        r117 = null;
    L16:
        e = move-exception;
        MiraMonitor.reportSignEvent(MiraMonitor.SCHEMA_V3_NOT_FOUND, e, null);
        if (r111 >= 3) goto L40;
        if (r111 > 2) goto L38;
        MiraMonitor.reportSignEvent(MiraMonitor.SCHEMA_V2);     // Catch: Exception -> L23 SignatureNotFoundException -> L26
        return new SigningDetails(convertToSignatures(ApkSignatureSchemeV2Verifier.verify(r110)), 2);
    L26:
        e = move-exception;
        MiraMonitor.reportSignEvent(MiraMonitor.SCHEMA_V2_NOT_FOUND, e, null);
        if (r111 >= 2) goto L36;
        if (r111 > 1) goto L34;
        return ApkSignatureSchemeV1Verifier.verify(r110, true);
    L34:
        throw new VerifyException(4, "No signature found in package of version " + r111 + " or newer for package " + r110);
    L36:
        throw new VerifyException(4, "No APK Signature Scheme v2 signature in package " + r110, e);
    L23:
        e = move-exception;
        MiraMonitor.reportSignEvent(MiraMonitor.SCHEMA_V2_ERROR, e, null);
        throw new VerifyException(4, "Failed to collect certificates from " + r110 + " using APK Signature Scheme v2", e);
    L38:
        throw new VerifyException(4, "No signature found in package of version " + r111 + " or newer for package " + r110);
    L40:
        throw new VerifyException(4, "No APK Signature Scheme v3 signature in package " + r110, e);
    L13:
        e = move-exception;
        MiraMonitor.reportSignEvent(MiraMonitor.SCHEMA_V3_ERROR, e, null);
        throw new VerifyException(4, "Failed to collect certificates from " + r110 + " using APK Signature Scheme v3", e);
    L42:
        throw new VerifyException(4, "No signature found in package of version " + r111 + " or newer for package " + r110);
    }
}
