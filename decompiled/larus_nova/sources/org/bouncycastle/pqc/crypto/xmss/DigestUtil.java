package org.bouncycastle.pqc.crypto.xmss;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.digests.SHAKEDigest;

/* JADX INFO: loaded from: classes42.dex */
class DigestUtil {
    private static Map<String, ASN1ObjectIdentifier> nameToOid;
    private static Map<ASN1ObjectIdentifier, String> oidToName;

    static {
        nameToOid = new HashMap();
        oidToName = new HashMap();
        Map<String, ASN1ObjectIdentifier> r100 = nameToOid;
        ASN1ObjectIdentifier r101 = NISTObjectIdentifiers.id_sha256;
        r100.put("SHA-256", r101);
        Map<String, ASN1ObjectIdentifier> r102 = nameToOid;
        ASN1ObjectIdentifier r103 = NISTObjectIdentifiers.id_sha512;
        r102.put("SHA-512", r103);
        Map<String, ASN1ObjectIdentifier> r104 = nameToOid;
        ASN1ObjectIdentifier r105 = NISTObjectIdentifiers.id_shake128;
        r104.put("SHAKE128", r105);
        Map<String, ASN1ObjectIdentifier> r106 = nameToOid;
        ASN1ObjectIdentifier r107 = NISTObjectIdentifiers.id_shake256;
        r106.put("SHAKE256", r107);
        oidToName.put(r101, "SHA-256");
        oidToName.put(r103, "SHA-512");
        oidToName.put(r105, "SHAKE128");
        oidToName.put(r107, "SHAKE256");
    }

    public DigestUtil() {
    }

    public static Digest getDigest(ASN1ObjectIdentifier r100) {
        if (r100.equals(NISTObjectIdentifiers.id_sha256) == false) goto L7;
        return new SHA256Digest();
    L7:
        if (r100.equals(NISTObjectIdentifiers.id_sha512) == false) goto L11;
        return new SHA512Digest();
    L11:
        if (r100.equals(NISTObjectIdentifiers.id_shake128) == false) goto L15;
        return new SHAKEDigest(128);
    L15:
        if (r100.equals(NISTObjectIdentifiers.id_shake256) == false) goto L19;
        return new SHAKEDigest(256);
    L19:
        throw new IllegalArgumentException("unrecognized digest OID: " + r100);
    }

    public static String getDigestName(ASN1ObjectIdentifier r100) {
        String r101 = oidToName.get(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new IllegalArgumentException("unrecognized digest oid: " + r100);
    }

    public static ASN1ObjectIdentifier getDigestOID(String r100) {
        ASN1ObjectIdentifier r101 = nameToOid.get(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new IllegalArgumentException("unrecognized digest name: " + r100);
    }

    public static int getDigestSize(Digest r100) {
        boolean r101 = r100 instanceof Xof;
        int r102 = r100.getDigestSize();
        if (r101 == true) goto L5;
        return r102;
    L5:
        return r102 * 2;
    }
}
