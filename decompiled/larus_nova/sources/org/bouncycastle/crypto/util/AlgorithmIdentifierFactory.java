package org.bouncycastle.crypto.util;

import java.security.SecureRandom;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cms.GCMParameters;
import org.bouncycastle.asn1.kisa.KISAObjectIdentifiers;
import org.bouncycastle.asn1.misc.CAST5CBCParameters;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RC2CBCParameter;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class AlgorithmIdentifierFactory {
    static final ASN1ObjectIdentifier CAST5_CBC = null;
    static final ASN1ObjectIdentifier IDEA_CBC = null;
    private static final short[] rc2Table = null;

    static {
        IDEA_CBC = new ASN1ObjectIdentifier("1.3.6.1.4.1.188.7.1.1.2").intern();
        CAST5_CBC = new ASN1ObjectIdentifier("1.2.840.113533.7.66.10").intern();
        rc2Table = new short[]{189, 86, 234, 242, 162, 241, 172, 42, 176, 147, 209, 156, 27, 51, 253, 208, 48, 4, 182, 220, 125, 223, 50, 75, 247, 203, 69, 155, 49, 187, 33, 90, 65, 159, 225, 217, 74, 77, 158, 218, 160, 104, 44, 195, 39, 95, 128, 54, 62, 238, 251, 149, 26, 254, 206, 168, 52, 169, 19, 240, 166, 63, 216, 12, 120, 36, 175, 35, 82, 193, 103, 23, 245, 102, 144, 231, 232, 7, 184, 96, 72, 230, 30, 83, 243, 146, 164, 114, 140, 8, 21, 110, 134, 0, 132, 250, 244, 127, 138, 66, 25, 246, 219, 205, 20, 141, 80, 18, 186, 60, 6, 78, 236, 179, 53, 17, 161, 136, 142, 43, 148, 153, 183, 113, 116, 211, 228, 191, 58, 222, 150, 14, 188, 10, 237, 119, 252, 55, 107, 3, 121, 137, 98, 198, 215, 192, 210, 124, 106, 139, 34, 163, 91, 5, 93, 2, 117, 213, 97, 227, 24, 143, 85, 81, 173, 31, 11, 94, 133, 229, 194, 87, 99, 202, 61, 108, 180, 197, 204, 112, 178, 145, 89, 13, 71, 32, 200, 79, 88, 224, 1, 226, 22, 56, 196, 111, 59, 15, 101, 70, 190, 126, 45, 123, 130, 249, 64, 181, 29, 115, 248, 235, 38, 199, 135, 151, 37, 84, 177, 40, 170, 152, 157, 165, 100, 109, 122, 212, 16, 129, 68, 239, 73, 214, 174, 46, 221, 118, 92, 47, 167, 28, 201, 9, 105, 154, 131, 207, 41, 57, 185, 233, 76, 255, 67, 171};
    }

    private AlgorithmIdentifierFactory() {
    }

    public static AlgorithmIdentifier generateEncryptionAlgID(ASN1ObjectIdentifier r100, int r101, SecureRandom r102) throws IllegalArgumentException {
        if (r100.equals(NISTObjectIdentifiers.id_aes128_CBC) == false) goto L5;
    L49:
        byte[] r103 = new byte[16];
        r102.nextBytes(r103);
        return new AlgorithmIdentifier(r100, new DEROctetString(r103));
    L5:
        if (r100.equals(NISTObjectIdentifiers.id_aes192_CBC) == true) goto L49;
        if (r100.equals(NISTObjectIdentifiers.id_aes256_CBC) == true) goto L49;
        if (r100.equals(NTTObjectIdentifiers.id_camellia128_cbc) == true) goto L49;
        if (r100.equals(NTTObjectIdentifiers.id_camellia192_cbc) == true) goto L49;
        if (r100.equals(NTTObjectIdentifiers.id_camellia256_cbc) == true) goto L49;
        if (r100.equals(KISAObjectIdentifiers.id_seedCBC) == true) goto L49;
        if (r100.equals(NISTObjectIdentifiers.id_aes128_GCM) == false) goto L20;
    L47:
        byte[] r104 = new byte[16];
        r102.nextBytes(r104);
        return new AlgorithmIdentifier(r100, new GCMParameters(r104, 12));
    L20:
        if (r100.equals(NISTObjectIdentifiers.id_aes192_GCM) == true) goto L47;
        if (r100.equals(NISTObjectIdentifiers.id_aes256_GCM) == true) goto L47;
        if (r100.equals(PKCSObjectIdentifiers.des_EDE3_CBC) == false) goto L27;
    L45:
        byte[] r105 = new byte[8];
        r102.nextBytes(r105);
        return new AlgorithmIdentifier(r100, new DEROctetString(r105));
    L27:
        if (r100.equals(IDEA_CBC) == true) goto L45;
        if (r100.equals(OIWObjectIdentifiers.desCBC) == true) goto L45;
        if (r100.equals(CAST5_CBC) == false) goto L36;
        byte[] r106 = new byte[8];
        r102.nextBytes(r106);
        return new AlgorithmIdentifier(r100, new CAST5CBCParameters(r106, r101));
    L36:
        if (r100.equals(PKCSObjectIdentifiers.f525059rc4) == false) goto L40;
        return new AlgorithmIdentifier(r100, DERNull.INSTANCE);
    L40:
        if (r100.equals(PKCSObjectIdentifiers.RC2_CBC) == false) goto L44;
        byte[] r107 = new byte[8];
        r102.nextBytes(r107);
        return new AlgorithmIdentifier(r100, new RC2CBCParameter(rc2Table[128(0x80, float:1.8E-43)], r107));
    L44:
        throw new IllegalArgumentException("unable to match algorithm");
    }
}
