package org.bouncycastle.jcajce.provider.util;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;

/* JADX INFO: loaded from: classes42.dex */
public abstract class AsymmetricAlgorithmProvider extends AlgorithmProvider {
    public AsymmetricAlgorithmProvider() {
    }

    public void addSignatureAlgorithm(ConfigurableProvider r100, String r101, String r102, String r103, ASN1ObjectIdentifier r104) {
        String r105 = r101 + "WITH" + r102;
        String r106 = r101 + "with" + r102;
        String r107 = r101 + "With" + r102;
        String r108 = r101 + HTTP.URL_DEFAULT + r102;
        r100.addAlgorithm("Signature." + r105, r103);
        r100.addAlgorithm("Alg.Alias.Signature." + r106, r105);
        r100.addAlgorithm("Alg.Alias.Signature." + r107, r105);
        r100.addAlgorithm("Alg.Alias.Signature." + r108, r105);
        r100.addAlgorithm("Alg.Alias.Signature." + r104, r105);
        r100.addAlgorithm("Alg.Alias.Signature.OID." + r104, r105);
    }

    public void addSignatureAlgorithm(ConfigurableProvider r100, String r101, String r102, ASN1ObjectIdentifier r103) {
        r100.addAlgorithm("Signature." + r101, r102);
        r100.addAlgorithm("Alg.Alias.Signature." + r103, r101);
        r100.addAlgorithm("Alg.Alias.Signature.OID." + r103, r101);
    }

    public void registerOid(ConfigurableProvider r100, ASN1ObjectIdentifier r101, String r102, AsymmetricKeyInfoConverter r103) {
        r100.addAlgorithm("Alg.Alias.KeyFactory." + r101, r102);
        r100.addAlgorithm("Alg.Alias.KeyPairGenerator." + r101, r102);
        r100.addKeyInfoConverter(r101, r103);
    }

    public void registerOidAlgorithmParameterGenerator(ConfigurableProvider r100, ASN1ObjectIdentifier r101, String r102) {
        r100.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + r101, r102);
        r100.addAlgorithm("Alg.Alias.AlgorithmParameters." + r101, r102);
    }

    public void registerOidAlgorithmParameters(ConfigurableProvider r100, ASN1ObjectIdentifier r101, String r102) {
        r100.addAlgorithm("Alg.Alias.AlgorithmParameters." + r101, r102);
    }
}
