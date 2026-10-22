package org.bouncycastle.crypto.params;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class ECGOST3410Parameters extends ECNamedDomainParameters {
    private final ASN1ObjectIdentifier digestParamSet;
    private final ASN1ObjectIdentifier encryptionParamSet;
    private final ASN1ObjectIdentifier publicKeyParamSet;

    public ECGOST3410Parameters(ECDomainParameters r100, ASN1ObjectIdentifier r101, ASN1ObjectIdentifier r102) {
        this(r100, r101, r102, null);
    }

    public ECGOST3410Parameters(ECDomainParameters r100, ASN1ObjectIdentifier r101, ASN1ObjectIdentifier r102, ASN1ObjectIdentifier r103) {
        super(r101, r100);
        if ((r100 instanceof ECNamedDomainParameters) == true) goto L5;
    L9:
        this.publicKeyParamSet = r101;
        this.digestParamSet = r102;
        this.encryptionParamSet = r103;
        return;
    L5:
        if (r101.equals(((ECNamedDomainParameters) r100).getName()) == true) goto L9;
        throw new IllegalArgumentException("named parameters do not match publicKeyParamSet value");
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
}
