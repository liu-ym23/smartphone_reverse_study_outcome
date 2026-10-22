package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.crmf.CertId;
import org.bouncycastle.asn1.x509.CertificateList;

/* JADX INFO: loaded from: classes42.dex */
public class RevRepContentBuilder {
    private ASN1EncodableVector crls;
    private ASN1EncodableVector revCerts;
    private ASN1EncodableVector status;

    public RevRepContentBuilder() {
        this.status = new ASN1EncodableVector();
        this.revCerts = new ASN1EncodableVector();
        this.crls = new ASN1EncodableVector();
    }

    public RevRepContentBuilder add(PKIStatusInfo r100) {
        this.status.add(r100);
        return this;
    }

    public RevRepContentBuilder add(PKIStatusInfo r100, CertId r101) {
        if (this.status.size() != this.revCerts.size()) goto L7;
        this.status.add(r100);
        this.revCerts.add(r101);
        return this;
    L7:
        throw new IllegalStateException("status and revCerts sequence must be in common order");
    }

    public RevRepContentBuilder addCrl(CertificateList r100) {
        this.crls.add(r100);
        return this;
    }

    public RevRepContent build() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(new DERSequence(this.status));
        if (this.revCerts.size() == 0) goto L6;
        r100.add(new DERTaggedObject(true, 0, new DERSequence(this.revCerts)));
    L6:
        if (this.crls.size() == 0) goto L9;
        r100.add(new DERTaggedObject(true, 1, new DERSequence(this.crls)));
    L9:
        return RevRepContent.getInstance(new DERSequence(r100));
    }
}
