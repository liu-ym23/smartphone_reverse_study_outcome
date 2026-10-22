package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.crmf.CertTemplate;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.X509Extensions;

/* JADX INFO: loaded from: classes42.dex */
public class RevDetails extends ASN1Object {
    private CertTemplate certDetails;
    private Extensions crlEntryDetails;

    private RevDetails(ASN1Sequence r100) {
        this.certDetails = CertTemplate.getInstance(r100.getObjectAt(0));
        if (r100.size() <= 1) goto L6;
        this.crlEntryDetails = Extensions.getInstance(r100.getObjectAt(1));
        return;
    }

    public RevDetails(CertTemplate r100) {
        this.certDetails = r100;
    }

    public RevDetails(CertTemplate r100, Extensions r101) {
        this.certDetails = r100;
        this.crlEntryDetails = r101;
    }

    public RevDetails(CertTemplate r100, X509Extensions r101) {
        this.certDetails = r100;
        this.crlEntryDetails = Extensions.getInstance(r101.toASN1Primitive());
    }

    public static RevDetails getInstance(Object r100) {
        if ((r100 instanceof RevDetails) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new RevDetails(ASN1Sequence.getInstance(r100));
    L5:
        return (RevDetails) r100;
    }

    public CertTemplate getCertDetails() {
        return this.certDetails;
    }

    public Extensions getCrlEntryDetails() {
        return this.crlEntryDetails;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.certDetails);
        Extensions r101 = this.crlEntryDetails;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
