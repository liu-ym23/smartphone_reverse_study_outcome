package org.bouncycastle.asn1.cmc;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.GeneralName;

/* JADX INFO: loaded from: classes42.dex */
public class GetCert extends ASN1Object {
    private final GeneralName issuerName;
    private final BigInteger serialNumber;

    private GetCert(ASN1Sequence r100) {
        if (r100.size() != 2) goto L7;
        this.issuerName = GeneralName.getInstance(r100.getObjectAt(0));
        this.serialNumber = ASN1Integer.getInstance(r100.getObjectAt(1)).getValue();
        return;
    L7:
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public GetCert(GeneralName r100, BigInteger r101) {
        this.issuerName = r100;
        this.serialNumber = r101;
    }

    public static GetCert getInstance(Object r100) {
        if ((r100 instanceof GetCert) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new GetCert(ASN1Sequence.getInstance(r100));
    L5:
        return (GetCert) r100;
    }

    public GeneralName getIssuerName() {
        return this.issuerName;
    }

    public BigInteger getSerialNumber() {
        return this.serialNumber;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.issuerName);
        r100.add(new ASN1Integer(this.serialNumber));
        return new DERSequence(r100);
    }
}
