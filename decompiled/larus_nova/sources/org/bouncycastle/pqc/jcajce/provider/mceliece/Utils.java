package org.bouncycastle.pqc.jcajce.provider.mceliece;

import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

/* JADX INFO: loaded from: classes42.dex */
class Utils {
    public Utils() {
    }

    public static AlgorithmIdentifier getDigAlgId(String r100) {
        if (r100.equals("SHA-1") == false) goto L7;
        return new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
    L7:
        if (r100.equals(McElieceCCA2KeyGenParameterSpec.SHA224) == false) goto L11;
        return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha224, DERNull.INSTANCE);
    L11:
        if (r100.equals("SHA-256") == false) goto L15;
        return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256, DERNull.INSTANCE);
    L15:
        if (r100.equals(McElieceCCA2KeyGenParameterSpec.SHA384) == false) goto L19;
        return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha384, DERNull.INSTANCE);
    L19:
        if (r100.equals("SHA-512") == false) goto L23;
        return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512, DERNull.INSTANCE);
    L23:
        throw new IllegalArgumentException("unrecognised digest algorithm: ".concat(r100));
    }

    public static Digest getDigest(AlgorithmIdentifier r100) {
        if (r100.getAlgorithm().equals(OIWObjectIdentifiers.idSHA1) == false) goto L7;
        return DigestFactory.createSHA1();
    L7:
        if (r100.getAlgorithm().equals(NISTObjectIdentifiers.id_sha224) == false) goto L11;
        return DigestFactory.createSHA224();
    L11:
        if (r100.getAlgorithm().equals(NISTObjectIdentifiers.id_sha256) == false) goto L15;
        return DigestFactory.createSHA256();
    L15:
        if (r100.getAlgorithm().equals(NISTObjectIdentifiers.id_sha384) == false) goto L19;
        return DigestFactory.createSHA384();
    L19:
        if (r100.getAlgorithm().equals(NISTObjectIdentifiers.id_sha512) == false) goto L23;
        return DigestFactory.createSHA512();
    L23:
        throw new IllegalArgumentException("unrecognised OID in digest algorithm identifier: " + r100.getAlgorithm());
    }
}
