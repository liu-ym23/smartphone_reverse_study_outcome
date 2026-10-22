package org.bouncycastle.pqc.jcajce.provider;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.jcajce.provider.qtesla.QTESLAKeyFactorySpi;

/* JADX INFO: loaded from: classes42.dex */
public class QTESLA {
    private static final String PREFIX = "org.bouncycastle.pqc.jcajce.provider.qtesla.";

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public Mappings() {
        }

        @Override // org.bouncycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider r100) {
            r100.addAlgorithm("KeyFactory.QTESLA", "org.bouncycastle.pqc.jcajce.provider.qtesla.QTESLAKeyFactorySpi");
            r100.addAlgorithm("KeyPairGenerator.QTESLA", "org.bouncycastle.pqc.jcajce.provider.qtesla.KeyPairGeneratorSpi");
            r100.addAlgorithm("Signature.QTESLA", "org.bouncycastle.pqc.jcajce.provider.qtesla.SignatureSpi$qTESLA");
            ASN1ObjectIdentifier r101 = PQCObjectIdentifiers.qTESLA_p_I;
            addSignatureAlgorithm(r100, "QTESLA-P-I", "org.bouncycastle.pqc.jcajce.provider.qtesla.SignatureSpi$PI", r101);
            ASN1ObjectIdentifier r102 = PQCObjectIdentifiers.qTESLA_p_III;
            addSignatureAlgorithm(r100, "QTESLA-P-III", "org.bouncycastle.pqc.jcajce.provider.qtesla.SignatureSpi$PIII", r102);
            QTESLAKeyFactorySpi r103 = new QTESLAKeyFactorySpi();
            registerOid(r100, r101, "QTESLA-P-I", r103);
            registerOid(r100, r102, "QTESLA-P-III", r103);
        }
    }

    public QTESLA() {
    }
}
