package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class AccessDescription extends ASN1Object {
    public static final ASN1ObjectIdentifier id_ad_caIssuers = null;
    public static final ASN1ObjectIdentifier id_ad_ocsp = null;
    GeneralName accessLocation;
    ASN1ObjectIdentifier accessMethod;

    static {
        id_ad_caIssuers = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.48.2");
        id_ad_ocsp = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.48.1");
    }

    public AccessDescription(ASN1ObjectIdentifier r100, GeneralName r101) {
        this.accessMethod = r100;
        this.accessLocation = r101;
    }

    private AccessDescription(ASN1Sequence r100) {
        this.accessMethod = null;
        this.accessLocation = null;
        if (r100.size() != 2) goto L7;
        this.accessMethod = ASN1ObjectIdentifier.getInstance(r100.getObjectAt(0));
        this.accessLocation = GeneralName.getInstance(r100.getObjectAt(1));
        return;
    L7:
        throw new IllegalArgumentException("wrong number of elements in sequence");
    }

    public static AccessDescription getInstance(Object r100) {
        if ((r100 instanceof AccessDescription) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new AccessDescription(ASN1Sequence.getInstance(r100));
    L5:
        return (AccessDescription) r100;
    }

    public GeneralName getAccessLocation() {
        return this.accessLocation;
    }

    public ASN1ObjectIdentifier getAccessMethod() {
        return this.accessMethod;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.accessMethod);
        r100.add(this.accessLocation);
        return new DERSequence(r100);
    }

    public String toString() {
        return "AccessDescription: Oid(" + this.accessMethod.getId() + ")";
    }
}
