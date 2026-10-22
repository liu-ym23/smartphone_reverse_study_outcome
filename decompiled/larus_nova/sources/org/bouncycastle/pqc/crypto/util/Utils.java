package org.bouncycastle.pqc.crypto.util;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.SPHINCS256KeyParams;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSKeyParameters;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes42.dex */
class Utils {
    static final AlgorithmIdentifier AlgID_qTESLA_p_I = null;
    static final AlgorithmIdentifier AlgID_qTESLA_p_III = null;
    static final AlgorithmIdentifier SPHINCS_SHA3_256 = null;
    static final AlgorithmIdentifier SPHINCS_SHA512_256 = null;
    static final AlgorithmIdentifier XMSS_SHA256 = null;
    static final AlgorithmIdentifier XMSS_SHA512 = null;
    static final AlgorithmIdentifier XMSS_SHAKE128 = null;
    static final AlgorithmIdentifier XMSS_SHAKE256 = null;
    static final Map categories = null;

    static {
        ASN1ObjectIdentifier r100 = PQCObjectIdentifiers.qTESLA_p_I;
        AlgID_qTESLA_p_I = new AlgorithmIdentifier(r100);
        ASN1ObjectIdentifier r101 = PQCObjectIdentifiers.qTESLA_p_III;
        AlgID_qTESLA_p_III = new AlgorithmIdentifier(r101);
        SPHINCS_SHA3_256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha3_256);
        SPHINCS_SHA512_256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512_256);
        XMSS_SHA256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256);
        XMSS_SHA512 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512);
        XMSS_SHAKE128 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_shake128);
        XMSS_SHAKE256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_shake256);
        HashMap r102 = new HashMap();
        categories = r102;
        r102.put(r100, Integers.valueOf(5));
        r102.put(r101, Integers.valueOf(6));
    }

    public Utils() {
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

    public static AlgorithmIdentifier qTeslaLookupAlgID(int r100) {
        if (r100 == 5) goto L11;
        if (r100 != 6) goto L9;
        return AlgID_qTESLA_p_III;
    L9:
        throw new IllegalArgumentException("unknown security category: " + r100);
    L11:
        return AlgID_qTESLA_p_I;
    }

    public static int qTeslaLookupSecurityCategory(AlgorithmIdentifier r100) {
        return ((Integer) categories.get(r100.getAlgorithm())).intValue();
    }

    public static AlgorithmIdentifier sphincs256LookupTreeAlgID(String r100) {
        if (r100.equals("SHA3-256") == false) goto L7;
        return SPHINCS_SHA3_256;
    L7:
        if (r100.equals(SPHINCSKeyParameters.SHA512_256) == false) goto L11;
        return SPHINCS_SHA512_256;
    L11:
        throw new IllegalArgumentException("unknown tree digest: ".concat(r100));
    }

    public static String sphincs256LookupTreeAlgName(SPHINCS256KeyParams r100) {
        AlgorithmIdentifier r101 = r100.getTreeDigest();
        if (r101.getAlgorithm().equals(SPHINCS_SHA3_256.getAlgorithm()) == false) goto L7;
        return "SHA3-256";
    L7:
        if (r101.getAlgorithm().equals(SPHINCS_SHA512_256.getAlgorithm()) == false) goto L11;
        return SPHINCSKeyParameters.SHA512_256;
    L11:
        throw new IllegalArgumentException("unknown tree digest: " + r101.getAlgorithm());
    }

    public static AlgorithmIdentifier xmssLookupTreeAlgID(String r100) {
        if (r100.equals("SHA-256") == false) goto L7;
        return XMSS_SHA256;
    L7:
        if (r100.equals("SHA-512") == false) goto L11;
        return XMSS_SHA512;
    L11:
        if (r100.equals("SHAKE128") == false) goto L15;
        return XMSS_SHAKE128;
    L15:
        if (r100.equals("SHAKE256") == false) goto L19;
        return XMSS_SHAKE256;
    L19:
        throw new IllegalArgumentException("unknown tree digest: ".concat(r100));
    }
}
