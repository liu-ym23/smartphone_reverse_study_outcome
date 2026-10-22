package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes42.dex */
public class ECNamedDomainParameters extends ECDomainParameters {
    private ASN1ObjectIdentifier name;

    public ECNamedDomainParameters(ASN1ObjectIdentifier r100, X9ECParameters r101) {
        super(r101);
        this.name = r100;
    }

    public ECNamedDomainParameters(ASN1ObjectIdentifier r100, ECDomainParameters r101) {
        super(r101.getCurve(), r101.getG(), r101.getN(), r101.getH(), r101.getSeed());
        this.name = r100;
    }

    public ECNamedDomainParameters(ASN1ObjectIdentifier r100, ECCurve r101, ECPoint r110, BigInteger r111) {
        this(r100, r101, r110, r111, ECConstants.ONE, null);
    }

    public ECNamedDomainParameters(ASN1ObjectIdentifier r100, ECCurve r101, ECPoint r110, BigInteger r111, BigInteger r112) {
        this(r100, r101, r110, r111, r112, null);
    }

    public ECNamedDomainParameters(ASN1ObjectIdentifier r100, ECCurve r101, ECPoint r102, BigInteger r110, BigInteger r111, byte[] r112) {
        super(r101, r102, r110, r111, r112);
        this.name = r100;
    }

    public ASN1ObjectIdentifier getName() {
        return this.name;
    }
}
