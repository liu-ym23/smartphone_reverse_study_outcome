package org.bouncycastle.jcajce.provider.digest;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;

/* JADX INFO: loaded from: classes42.dex */
abstract class DigestAlgorithmProvider extends AlgorithmProvider {
    public DigestAlgorithmProvider() {
    }

    public void addHMACAlgorithm(ConfigurableProvider r100, String r101, String r102, String r103) {
        String r104 = "HMAC" + r101;
        r100.addAlgorithm("Mac." + r104, r102);
        r100.addAlgorithm("Alg.Alias.Mac.HMAC-" + r101, r104);
        r100.addAlgorithm("Alg.Alias.Mac.HMAC/" + r101, r104);
        r100.addAlgorithm("KeyGenerator." + r104, r103);
        r100.addAlgorithm("Alg.Alias.KeyGenerator.HMAC-" + r101, r104);
        r100.addAlgorithm("Alg.Alias.KeyGenerator.HMAC/" + r101, r104);
    }

    public void addHMACAlias(ConfigurableProvider r100, String r101, ASN1ObjectIdentifier r102) {
        String r103 = "HMAC" + r101;
        r100.addAlgorithm("Alg.Alias.Mac." + r102, r103);
        r100.addAlgorithm("Alg.Alias.KeyGenerator." + r102, r103);
    }
}
