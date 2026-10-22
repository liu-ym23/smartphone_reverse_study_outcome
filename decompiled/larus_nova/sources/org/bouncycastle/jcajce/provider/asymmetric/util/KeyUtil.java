package org.bouncycastle.jcajce.provider.asymmetric.util;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

/* JADX INFO: loaded from: classes42.dex */
public class KeyUtil {
    public KeyUtil() {
    }

    public static byte[] getEncodedPrivateKeyInfo(PrivateKeyInfo r100) {
        return r100.getEncoded(ASN1Encoding.DER);
    L4:
        return null;
    }

    public static byte[] getEncodedPrivateKeyInfo(AlgorithmIdentifier r100, ASN1Encodable r101) {
        return getEncodedPrivateKeyInfo(new PrivateKeyInfo(r100, r101.toASN1Primitive()));
    L4:
        return null;
    }

    public static byte[] getEncodedSubjectPublicKeyInfo(AlgorithmIdentifier r100, ASN1Encodable r101) {
        return getEncodedSubjectPublicKeyInfo(new SubjectPublicKeyInfo(r100, r101));
    L4:
        return null;
    }

    public static byte[] getEncodedSubjectPublicKeyInfo(AlgorithmIdentifier r100, byte[] r101) {
        return getEncodedSubjectPublicKeyInfo(new SubjectPublicKeyInfo(r100, r101));
    L4:
        return null;
    }

    public static byte[] getEncodedSubjectPublicKeyInfo(SubjectPublicKeyInfo r100) {
        return r100.getEncoded(ASN1Encoding.DER);
    L4:
        return null;
    }
}
