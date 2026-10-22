package org.bouncycastle.pqc.jcajce.provider.lms;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Xof;

/* JADX INFO: loaded from: classes42.dex */
class DigestUtil {
    public DigestUtil() {
    }

    public static byte[] getDigestResult(Digest r100) {
        int r101 = getDigestSize(r100);
        byte[] r102 = new byte[r101];
        if ((r100 instanceof Xof) == false) goto L5;
        ((Xof) r100).doFinal(r102, 0, r101);
    L6:
        return r102;
    L5:
        r100.doFinal(r102, 0);
        goto L6
    }

    public static int getDigestSize(Digest r100) {
        boolean r101 = r100 instanceof Xof;
        int r102 = r100.getDigestSize();
        if (r101 == true) goto L5;
        return r102;
    L5:
        return r102 * 2;
    }

    public static String getXMSSDigestName(ASN1ObjectIdentifier r100) {
        if (r100.equals(NISTObjectIdentifiers.id_sha256) == false) goto L7;
        return "SHA256";
    L7:
        if (r100.equals(NISTObjectIdentifiers.id_sha512) == false) goto L11;
        return "SHA512";
    L11:
        if (r100.equals(NISTObjectIdentifiers.id_shake128) == false) goto L15;
        return "SHAKE128";
    L15:
        if (r100.equals(NISTObjectIdentifiers.id_shake256) == false) goto L19;
        return "SHAKE256";
    L19:
        throw new IllegalArgumentException("unrecognized digest OID: " + r100);
    }
}
