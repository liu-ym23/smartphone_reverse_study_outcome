package org.bouncycastle.pqc.jcajce.provider;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

/* JADX INFO: loaded from: classes42.dex */
public class LMS {
    private static final String PREFIX = "org.bouncycastle.pqc.jcajce.provider.lms.";

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public Mappings() {
        }

        @Override // org.bouncycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider r100) {
            r100.addAlgorithm("KeyFactory.LMS", "org.bouncycastle.pqc.jcajce.provider.lms.LMSKeyFactorySpi");
            StringBuilder r101 = new StringBuilder("Alg.Alias.KeyFactory.");
            ASN1ObjectIdentifier r102 = PKCSObjectIdentifiers.id_alg_hss_lms_hashsig;
            r101.append(r102);
            r100.addAlgorithm(r101.toString(), "LMS");
            r100.addAlgorithm("KeyPairGenerator.LMS", "org.bouncycastle.pqc.jcajce.provider.lms.LMSKeyPairGeneratorSpi");
            r100.addAlgorithm("Alg.Alias.KeyPairGenerator." + r102, "LMS");
            r100.addAlgorithm("Signature.LMS", "org.bouncycastle.pqc.jcajce.provider.lms.LMSSignatureSpi$generic");
            r100.addAlgorithm("Alg.Alias.Signature." + r102, "LMS");
        }
    }

    public LMS() {
    }
}
