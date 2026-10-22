package org.bouncycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers;

/* JADX INFO: loaded from: classes42.dex */
public class GOST3410ParameterSpec implements AlgorithmParameterSpec {
    private final ASN1ObjectIdentifier digestParamSet;
    private final ASN1ObjectIdentifier encryptionParamSet;
    private final ASN1ObjectIdentifier publicKeyParamSet;

    public GOST3410ParameterSpec(String r100) {
        this(getOid(r100), getDigestOid(r100), null);
    }

    public GOST3410ParameterSpec(ASN1ObjectIdentifier r100, ASN1ObjectIdentifier r101) {
        this(r100, r101, null);
    }

    public GOST3410ParameterSpec(ASN1ObjectIdentifier r100, ASN1ObjectIdentifier r101, ASN1ObjectIdentifier r102) {
        this.publicKeyParamSet = r100;
        this.digestParamSet = r101;
        this.encryptionParamSet = r102;
    }

    private static ASN1ObjectIdentifier getDigestOid(String r100) {
        if (r100.indexOf("12-512") <= 0) goto L7;
        return RosstandartObjectIdentifiers.id_tc26_gost_3411_12_512;
    L7:
        if (r100.indexOf("12-256") <= 0) goto L11;
        return RosstandartObjectIdentifiers.id_tc26_gost_3411_12_256;
    L11:
        return CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet;
    }

    private static ASN1ObjectIdentifier getOid(String r100) {
        return ECGOST3410NamedCurves.getOID(r100);
    }

    public ASN1ObjectIdentifier getDigestParamSet() {
        return this.digestParamSet;
    }

    public ASN1ObjectIdentifier getEncryptionParamSet() {
        return this.encryptionParamSet;
    }

    public ASN1ObjectIdentifier getPublicKeyParamSet() {
        return this.publicKeyParamSet;
    }

    public String getPublicKeyParamSetName() {
        return ECGOST3410NamedCurves.getName(getPublicKeyParamSet());
    }
}
