package org.bouncycastle.crypto.util;

import java.security.SecureRandom;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.kisa.KISAObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.generators.DESKeyGenerator;
import org.bouncycastle.crypto.generators.DESedeKeyGenerator;

/* JADX INFO: loaded from: classes42.dex */
public class CipherKeyGeneratorFactory {
    private CipherKeyGeneratorFactory() {
    }

    private static CipherKeyGenerator createCipherKeyGenerator(SecureRandom r100, int r101) {
        CipherKeyGenerator r102 = new CipherKeyGenerator();
        r102.init(new KeyGenerationParameters(r100, r101));
        return r102;
    }

    public static CipherKeyGenerator createKeyGenerator(ASN1ObjectIdentifier r100, SecureRandom r101) throws IllegalArgumentException {
        if (NISTObjectIdentifiers.id_aes128_CBC.equals(r100) == false) goto L7;
        return createCipherKeyGenerator(r101, 128);
    L7:
        if (NISTObjectIdentifiers.id_aes192_CBC.equals(r100) == false) goto L11;
        return createCipherKeyGenerator(r101, 192);
    L11:
        if (NISTObjectIdentifiers.id_aes256_CBC.equals(r100) == false) goto L15;
        return createCipherKeyGenerator(r101, 256);
    L15:
        if (NISTObjectIdentifiers.id_aes128_GCM.equals(r100) == false) goto L19;
        return createCipherKeyGenerator(r101, 128);
    L19:
        if (NISTObjectIdentifiers.id_aes192_GCM.equals(r100) == false) goto L23;
        return createCipherKeyGenerator(r101, 192);
    L23:
        if (NISTObjectIdentifiers.id_aes256_GCM.equals(r100) == false) goto L27;
        return createCipherKeyGenerator(r101, 256);
    L27:
        if (PKCSObjectIdentifiers.des_EDE3_CBC.equals(r100) == false) goto L31;
        DESedeKeyGenerator r102 = new DESedeKeyGenerator();
        r102.init(new KeyGenerationParameters(r101, 192));
        return r102;
    L31:
        if (NTTObjectIdentifiers.id_camellia128_cbc.equals(r100) == false) goto L35;
        return createCipherKeyGenerator(r101, 128);
    L35:
        if (NTTObjectIdentifiers.id_camellia192_cbc.equals(r100) == false) goto L39;
        return createCipherKeyGenerator(r101, 192);
    L39:
        if (NTTObjectIdentifiers.id_camellia256_cbc.equals(r100) == false) goto L43;
        return createCipherKeyGenerator(r101, 256);
    L43:
        if (KISAObjectIdentifiers.id_seedCBC.equals(r100) == false) goto L47;
        return createCipherKeyGenerator(r101, 128);
    L47:
        if (AlgorithmIdentifierFactory.CAST5_CBC.equals(r100) == false) goto L51;
        return createCipherKeyGenerator(r101, 128);
    L51:
        if (OIWObjectIdentifiers.desCBC.equals(r100) == false) goto L55;
        DESKeyGenerator r103 = new DESKeyGenerator();
        r103.init(new KeyGenerationParameters(r101, 64));
        return r103;
    L55:
        if (PKCSObjectIdentifiers.f525059rc4.equals(r100) == false) goto L59;
        return createCipherKeyGenerator(r101, 128);
    L59:
        if (PKCSObjectIdentifiers.RC2_CBC.equals(r100) == false) goto L63;
        return createCipherKeyGenerator(r101, 128);
    L63:
        throw new IllegalArgumentException("cannot recognise cipher: " + r100);
    }
}
