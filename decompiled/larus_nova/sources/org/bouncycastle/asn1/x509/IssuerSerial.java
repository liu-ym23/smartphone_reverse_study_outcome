package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.X500Name;

/* JADX INFO: loaded from: classes42.dex */
public class IssuerSerial extends ASN1Object {
    GeneralNames issuer;
    DERBitString issuerUID;
    ASN1Integer serial;

    private IssuerSerial(ASN1Sequence r100) {
        if (r100.size() != 2) goto L5;
    L9:
        this.issuer = GeneralNames.getInstance(r100.getObjectAt(0));
        this.serial = ASN1Integer.getInstance(r100.getObjectAt(1));
        if (r100.size() != 3) goto L13;
        this.issuerUID = DERBitString.getInstance(r100.getObjectAt(2));
        return;
    L13:
        return;
    L5:
        if (r100.size() == 3) goto L9;
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public IssuerSerial(X500Name r100, BigInteger r101) {
        this(new GeneralNames(new GeneralName(r100)), new ASN1Integer(r101));
    }

    public IssuerSerial(GeneralNames r100, BigInteger r101) {
        this(r100, new ASN1Integer(r101));
    }

    public IssuerSerial(GeneralNames r100, ASN1Integer r101) {
        this.issuer = r100;
        this.serial = r101;
    }

    public static IssuerSerial getInstance(Object r100) {
        if ((r100 instanceof IssuerSerial) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new IssuerSerial(ASN1Sequence.getInstance(r100));
    L5:
        return (IssuerSerial) r100;
    }

    public static IssuerSerial getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public GeneralNames getIssuer() {
        return this.issuer;
    }

    public DERBitString getIssuerUID() {
        return this.issuerUID;
    }

    public ASN1Integer getSerial() {
        return this.serial;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.issuer);
        r100.add(this.serial);
        DERBitString r101 = this.issuerUID;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
