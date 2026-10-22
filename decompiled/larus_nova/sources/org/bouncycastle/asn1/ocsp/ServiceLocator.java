package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AuthorityInformationAccess;

/* JADX INFO: loaded from: classes42.dex */
public class ServiceLocator extends ASN1Object {
    private final X500Name issuer;
    private final AuthorityInformationAccess locator;

    private ServiceLocator(ASN1Sequence r100) {
        this.issuer = X500Name.getInstance(r100.getObjectAt(0));
        if (r100.size() != 2) goto L5;
        AuthorityInformationAccess r101 = AuthorityInformationAccess.getInstance(r100.getObjectAt(1));
    L6:
        this.locator = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public static ServiceLocator getInstance(Object r100) {
        if ((r100 instanceof ServiceLocator) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ServiceLocator(ASN1Sequence.getInstance(r100));
    L5:
        return (ServiceLocator) r100;
    }

    public X500Name getIssuer() {
        return this.issuer;
    }

    public AuthorityInformationAccess getLocator() {
        return this.locator;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.issuer);
        AuthorityInformationAccess r101 = this.locator;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
