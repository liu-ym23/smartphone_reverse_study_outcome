package org.bouncycastle.asn1.esf;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1UTCTime;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.X500Name;

/* JADX INFO: loaded from: classes42.dex */
public class CrlIdentifier extends ASN1Object {
    private ASN1UTCTime crlIssuedTime;
    private X500Name crlIssuer;
    private ASN1Integer crlNumber;

    private CrlIdentifier(ASN1Sequence r100) {
        if (r100.size() < 2) goto L11;
        if (r100.size() > 3) goto L11;
        this.crlIssuer = X500Name.getInstance(r100.getObjectAt(0));
        this.crlIssuedTime = ASN1UTCTime.getInstance(r100.getObjectAt(1));
        if (r100.size() <= 2) goto L12;
        this.crlNumber = ASN1Integer.getInstance(r100.getObjectAt(2));
        return;
    L12:
        return;
    L11:
        throw new IllegalArgumentException();
    }

    public CrlIdentifier(X500Name r100, ASN1UTCTime r101) {
        this(r100, r101, null);
    }

    public CrlIdentifier(X500Name r100, ASN1UTCTime r101, BigInteger r102) {
        this.crlIssuer = r100;
        this.crlIssuedTime = r101;
        if (r102 == null) goto L6;
        this.crlNumber = new ASN1Integer(r102);
        return;
    }

    public static CrlIdentifier getInstance(Object r100) {
        if ((r100 instanceof CrlIdentifier) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CrlIdentifier(ASN1Sequence.getInstance(r100));
    L5:
        return (CrlIdentifier) r100;
    }

    public ASN1UTCTime getCrlIssuedTime() {
        return this.crlIssuedTime;
    }

    public X500Name getCrlIssuer() {
        return this.crlIssuer;
    }

    public BigInteger getCrlNumber() {
        ASN1Integer r100 = this.crlNumber;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.crlIssuer.toASN1Primitive());
        r100.add(this.crlIssuedTime);
        ASN1Integer r101 = this.crlNumber;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
