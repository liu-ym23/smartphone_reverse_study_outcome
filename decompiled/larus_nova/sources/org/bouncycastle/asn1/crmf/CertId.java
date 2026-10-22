package org.bouncycastle.asn1.crmf;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.GeneralName;

/* JADX INFO: loaded from: classes42.dex */
public class CertId extends ASN1Object {
    private GeneralName issuer;
    private ASN1Integer serialNumber;

    private CertId(ASN1Sequence r100) {
        this.issuer = GeneralName.getInstance(r100.getObjectAt(0));
        this.serialNumber = ASN1Integer.getInstance(r100.getObjectAt(1));
    }

    public CertId(GeneralName r100, BigInteger r101) {
        this(r100, new ASN1Integer(r101));
    }

    public CertId(GeneralName r100, ASN1Integer r101) {
        this.issuer = r100;
        this.serialNumber = r101;
    }

    public static CertId getInstance(Object r100) {
        if ((r100 instanceof CertId) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CertId(ASN1Sequence.getInstance(r100));
    L5:
        return (CertId) r100;
    }

    public static CertId getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public GeneralName getIssuer() {
        return this.issuer;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.issuer);
        r100.add(this.serialNumber);
        return new DERSequence(r100);
    }
}
