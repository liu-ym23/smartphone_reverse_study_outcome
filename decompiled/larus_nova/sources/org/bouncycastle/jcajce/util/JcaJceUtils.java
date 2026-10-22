package org.bouncycastle.jcajce.util;

import java.io.IOException;
import java.security.AlgorithmParameters;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;

/* JADX INFO: loaded from: classes42.dex */
public class JcaJceUtils {
    private JcaJceUtils() {
    }

    public static ASN1Encodable extractParameters(AlgorithmParameters r100) throws IOException {
        return ASN1Primitive.fromByteArray(r100.getEncoded("ASN.1"));
    L5:
        return ASN1Primitive.fromByteArray(r100.getEncoded());
    }

    public static String getDigestAlgName(ASN1ObjectIdentifier r100) {
        if (PKCSObjectIdentifiers.f525058md5.equals(r100) == false) goto L7;
        return "MD5";
    L7:
        if (OIWObjectIdentifiers.idSHA1.equals(r100) == false) goto L11;
        return "SHA1";
    L11:
        if (NISTObjectIdentifiers.id_sha224.equals(r100) == false) goto L15;
        return "SHA224";
    L15:
        if (NISTObjectIdentifiers.id_sha256.equals(r100) == false) goto L19;
        return "SHA256";
    L19:
        if (NISTObjectIdentifiers.id_sha384.equals(r100) == false) goto L23;
        return "SHA384";
    L23:
        if (NISTObjectIdentifiers.id_sha512.equals(r100) == false) goto L27;
        return "SHA512";
    L27:
        if (TeleTrusTObjectIdentifiers.ripemd128.equals(r100) == false) goto L31;
        return "RIPEMD128";
    L31:
        if (TeleTrusTObjectIdentifiers.ripemd160.equals(r100) == false) goto L35;
        return "RIPEMD160";
    L35:
        if (TeleTrusTObjectIdentifiers.ripemd256.equals(r100) == false) goto L39;
        return "RIPEMD256";
    L39:
        if (CryptoProObjectIdentifiers.gostR3411.equals(r100) == false) goto L43;
        return "GOST3411";
    L43:
        return r100.getId();
    }

    public static void loadParameters(AlgorithmParameters r100, ASN1Encodable r101) throws IOException {
        r100.init(r101.toASN1Primitive().getEncoded(), "ASN.1");     // Catch: Exception -> L4
        return;
    L4:
        r100.init(r101.toASN1Primitive().getEncoded());
    }
}
