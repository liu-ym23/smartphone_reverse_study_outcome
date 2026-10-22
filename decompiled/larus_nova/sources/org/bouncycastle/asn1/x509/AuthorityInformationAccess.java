package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class AuthorityInformationAccess extends ASN1Object {
    private AccessDescription[] descriptions;

    public AuthorityInformationAccess(ASN1ObjectIdentifier r100, GeneralName r101) {
        this(new AccessDescription(r100, r101));
    }

    private AuthorityInformationAccess(ASN1Sequence r100) {
        if (r100.size() < 1) goto L10;
        this.descriptions = new AccessDescription[r100.size()];
        int r101 = 0;
    L6:
        if (r101 == r100.size()) goto L8;
        this.descriptions[r101] = AccessDescription.getInstance(r100.getObjectAt(r101));
        r101 = r101 + 1;
        goto L6
    L8:
        return;
    L10:
        throw new IllegalArgumentException("sequence may not be empty");
    }

    public AuthorityInformationAccess(AccessDescription r100) {
        this.descriptions = new AccessDescription[]{r100};
    }

    public AuthorityInformationAccess(AccessDescription[] r100) {
        this.descriptions = copy(r100);
    }

    private static AccessDescription[] copy(AccessDescription[] r100) {
        AccessDescription[] r101 = new AccessDescription[r100.length];
        System.arraycopy(r100, 0, r101, 0, r100.length);
        return r101;
    }

    public static AuthorityInformationAccess fromExtensions(Extensions r100) {
        return getInstance(Extensions.getExtensionParsedValue(r100, Extension.authorityInfoAccess));
    }

    public static AuthorityInformationAccess getInstance(Object r100) {
        if ((r100 instanceof AuthorityInformationAccess) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new AuthorityInformationAccess(ASN1Sequence.getInstance(r100));
    L5:
        return (AuthorityInformationAccess) r100;
    }

    public AccessDescription[] getAccessDescriptions() {
        return copy(this.descriptions);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.descriptions);
    }

    public String toString() {
        return "AuthorityInformationAccess: Oid(" + this.descriptions[0].getAccessMethod().getId() + ")";
    }
}
