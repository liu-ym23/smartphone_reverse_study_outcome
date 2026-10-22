package org.bouncycastle.jcajce.provider.symmetric;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.engines.RC4Engine;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseStreamCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;

/* JADX INFO: loaded from: classes42.dex */
public final class ARC4 {

    public static class Base extends BaseStreamCipher {
        public Base() {
            super(new RC4Engine(), 0);
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("RC4", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        private static final String PREFIX = null;

        static {
            PREFIX = ARC4.class.getName();
        }

        public Mappings() {
        }

        @Override // org.bouncycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider r100) {
            StringBuilder r101 = new StringBuilder();
            String r102 = PREFIX;
            r101.append(r102);
            r101.append("$Base");
            r100.addAlgorithm("Cipher.ARC4", r101.toString());
            r100.addAlgorithm("Alg.Alias.Cipher", PKCSObjectIdentifiers.f525059rc4, "ARC4");
            r100.addAlgorithm("Alg.Alias.Cipher.ARCFOUR", "ARC4");
            r100.addAlgorithm("Alg.Alias.Cipher.RC4", "ARC4");
            r100.addAlgorithm("KeyGenerator.ARC4", r102 + "$KeyGen");
            r100.addAlgorithm("Alg.Alias.KeyGenerator.RC4", "ARC4");
            r100.addAlgorithm("Alg.Alias.KeyGenerator.1.2.840.113549.3.4", "ARC4");
            r100.addAlgorithm("SecretKeyFactory.PBEWITHSHAAND128BITRC4", r102 + "$PBEWithSHAAnd128BitKeyFactory");
            r100.addAlgorithm("SecretKeyFactory.PBEWITHSHAAND40BITRC4", r102 + "$PBEWithSHAAnd40BitKeyFactory");
            StringBuilder r103 = new StringBuilder("Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier r104 = PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC4;
            r103.append(r104);
            r100.addAlgorithm(r103.toString(), "PKCS12PBE");
            StringBuilder r105 = new StringBuilder("Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier r106 = PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC4;
            r105.append(r106);
            r100.addAlgorithm(r105.toString(), "PKCS12PBE");
            r100.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND40BITRC4", "PKCS12PBE");
            r100.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND128BITRC4", "PKCS12PBE");
            r100.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDRC4", "PKCS12PBE");
            r100.addAlgorithm("Cipher.PBEWITHSHAAND128BITRC4", r102 + "$PBEWithSHAAnd128Bit");
            r100.addAlgorithm("Cipher.PBEWITHSHAAND40BITRC4", r102 + "$PBEWithSHAAnd40Bit");
            r100.addAlgorithm("Alg.Alias.SecretKeyFactory", r104, "PBEWITHSHAAND128BITRC4");
            r100.addAlgorithm("Alg.Alias.SecretKeyFactory", r106, "PBEWITHSHAAND40BITRC4");
            r100.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND128BITRC4", "PBEWITHSHAAND128BITRC4");
            r100.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND40BITRC4", "PBEWITHSHAAND40BITRC4");
            r100.addAlgorithm("Alg.Alias.Cipher", r104, "PBEWITHSHAAND128BITRC4");
            r100.addAlgorithm("Alg.Alias.Cipher", r106, "PBEWITHSHAAND40BITRC4");
        }
    }

    public static class PBEWithSHAAnd128Bit extends BaseStreamCipher {
        public PBEWithSHAAnd128Bit() {
            super(new RC4Engine(), 0, 128, 1);
        }
    }

    public static class PBEWithSHAAnd128BitKeyFactory extends PBESecretKeyFactory {
        public PBEWithSHAAnd128BitKeyFactory() {
            super("PBEWithSHAAnd128BitRC4", PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC4, true, 2, 1, 128, 0);
        }
    }

    public static class PBEWithSHAAnd40Bit extends BaseStreamCipher {
        public PBEWithSHAAnd40Bit() {
            super(new RC4Engine(), 0, 40, 1);
        }
    }

    public static class PBEWithSHAAnd40BitKeyFactory extends PBESecretKeyFactory {
        public PBEWithSHAAnd40BitKeyFactory() {
            super("PBEWithSHAAnd128BitRC4", PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC4, true, 2, 1, 40, 0);
        }
    }

    private ARC4() {
    }
}
