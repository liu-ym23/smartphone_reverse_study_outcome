package org.bouncycastle.jce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.GOST3410NamedParameters;
import org.bouncycastle.asn1.cryptopro.GOST3410ParamSetParameters;
import org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.jce.interfaces.GOST3410Params;

/* JADX INFO: loaded from: classes42.dex */
public class GOST3410ParameterSpec implements AlgorithmParameterSpec, GOST3410Params {
    private String digestParamSetOID;
    private String encryptionParamSetOID;
    private String keyParamSetOID;
    private GOST3410PublicKeyParameterSetSpec keyParameters;

    public GOST3410ParameterSpec(String r100) {
        this(r100, CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet.getId(), null);
    }

    public GOST3410ParameterSpec(String r100, String r101) {
        this(r100, r101, null);
    }

    public GOST3410ParameterSpec(String r100, String r101, String r102) {
        GOST3410ParamSetParameters r103 = GOST3410NamedParameters.getByOID(new ASN1ObjectIdentifier(r100));     // Catch: IllegalArgumentException -> L5
    L9:
        if (r103 == null) goto L13;
        this.keyParameters = new GOST3410PublicKeyParameterSetSpec(r103.getP(), r103.getQ(), r103.getA());
        this.keyParamSetOID = r100;
        this.digestParamSetOID = r101;
        this.encryptionParamSetOID = r102;
        return;
    L13:
        throw new IllegalArgumentException("no key parameter set for passed in name/OID.");
    L5:
        ASN1ObjectIdentifier r104 = GOST3410NamedParameters.getOID(r100);
        if (r104 == null) goto L8;
        r100 = r104.getId();
        r103 = GOST3410NamedParameters.getByOID(r104);
        goto L9
    L8:
        r103 = null;
        goto L9
    }

    public GOST3410ParameterSpec(GOST3410PublicKeyParameterSetSpec r100) {
        this.keyParameters = r100;
        this.digestParamSetOID = CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet.getId();
        this.encryptionParamSetOID = null;
    }

    public static GOST3410ParameterSpec fromPublicKeyAlg(GOST3410PublicKeyAlgParameters r100) {
        if (r100.getEncryptionParamSet() == null) goto L7;
        return new GOST3410ParameterSpec(r100.getPublicKeyParamSet().getId(), r100.getDigestParamSet().getId(), r100.getEncryptionParamSet().getId());
    L7:
        return new GOST3410ParameterSpec(r100.getPublicKeyParamSet().getId(), r100.getDigestParamSet().getId());
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof GOST3410ParameterSpec) == false) goto L15;
        GOST3410ParameterSpec r101 = (GOST3410ParameterSpec) r100;
        if (this.keyParameters.equals(r101.keyParameters) == true) goto L7;
        return false;
    L7:
        if (this.digestParamSetOID.equals(r101.digestParamSetOID) == false) goto L17;
        String r102 = this.encryptionParamSetOID;
        String r103 = r101.encryptionParamSetOID;
        if (r102 == r103) goto L13;
        if (r102 != null) goto L12;
        return false;
    L12:
        if (r102.equals(r103) == true) goto L13;
        return false;
    L13:
        return true;
    L17:
        return false;
    L15:
        return false;
    }

    @Override // org.bouncycastle.jce.interfaces.GOST3410Params
    public String getDigestParamSetOID() {
        return this.digestParamSetOID;
    }

    @Override // org.bouncycastle.jce.interfaces.GOST3410Params
    public String getEncryptionParamSetOID() {
        return this.encryptionParamSetOID;
    }

    @Override // org.bouncycastle.jce.interfaces.GOST3410Params
    public String getPublicKeyParamSetOID() {
        return this.keyParamSetOID;
    }

    @Override // org.bouncycastle.jce.interfaces.GOST3410Params
    public GOST3410PublicKeyParameterSetSpec getPublicKeyParameters() {
        return this.keyParameters;
    }

    public int hashCode() {
        int r100 = this.keyParameters.hashCode() ^ this.digestParamSetOID.hashCode();
        String r101 = this.encryptionParamSetOID;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 ^ r102;
    L5:
        r102 = 0;
        goto L7
    }
}
