package org.bouncycastle.jcajce.provider.asymmetric;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.jcajce.provider.asymmetric.gost.KeyFactorySpi;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

/* JADX INFO: loaded from: classes42.dex */
public class GOST {
    private static final String PREFIX = "org.bouncycastle.jcajce.provider.asymmetric.gost.";

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public Mappings() {
        }

        @Override // org.bouncycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider r100) {
            r100.addAlgorithm("KeyPairGenerator.GOST3410", "org.bouncycastle.jcajce.provider.asymmetric.gost.KeyPairGeneratorSpi");
            r100.addAlgorithm("Alg.Alias.KeyPairGenerator.GOST-3410", "GOST3410");
            r100.addAlgorithm("Alg.Alias.KeyPairGenerator.GOST-3410-94", "GOST3410");
            r100.addAlgorithm("KeyFactory.GOST3410", "org.bouncycastle.jcajce.provider.asymmetric.gost.KeyFactorySpi");
            r100.addAlgorithm("Alg.Alias.KeyFactory.GOST-3410", "GOST3410");
            r100.addAlgorithm("Alg.Alias.KeyFactory.GOST-3410-94", "GOST3410");
            r100.addAlgorithm("AlgorithmParameters.GOST3410", "org.bouncycastle.jcajce.provider.asymmetric.gost.AlgorithmParametersSpi");
            r100.addAlgorithm("AlgorithmParameterGenerator.GOST3410", "org.bouncycastle.jcajce.provider.asymmetric.gost.AlgorithmParameterGeneratorSpi");
            ASN1ObjectIdentifier r101 = CryptoProObjectIdentifiers.gostR3410_94;
            registerOid(r100, r101, "GOST3410", new KeyFactorySpi());
            registerOidAlgorithmParameterGenerator(r100, r101, "GOST3410");
            r100.addAlgorithm("Signature.GOST3410", "org.bouncycastle.jcajce.provider.asymmetric.gost.SignatureSpi");
            r100.addAlgorithm("Alg.Alias.Signature.GOST-3410", "GOST3410");
            r100.addAlgorithm("Alg.Alias.Signature.GOST-3410-94", "GOST3410");
            r100.addAlgorithm("Alg.Alias.Signature.GOST3411withGOST3410", "GOST3410");
            r100.addAlgorithm("Alg.Alias.Signature.GOST3411WITHGOST3410", "GOST3410");
            r100.addAlgorithm("Alg.Alias.Signature.GOST3411WithGOST3410", "GOST3410");
            r100.addAlgorithm("Alg.Alias.Signature." + CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94, "GOST3410");
            r100.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator.GOST-3410", "GOST3410");
            r100.addAlgorithm("Alg.Alias.AlgorithmParameters.GOST-3410", "GOST3410");
        }
    }

    public GOST() {
    }
}
