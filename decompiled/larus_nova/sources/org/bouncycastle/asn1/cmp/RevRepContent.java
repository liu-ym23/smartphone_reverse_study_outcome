package org.bouncycastle.asn1.cmp;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.crmf.CertId;
import org.bouncycastle.asn1.x509.CertificateList;

/* JADX INFO: loaded from: classes42.dex */
public class RevRepContent extends ASN1Object {
    private ASN1Sequence crls;
    private ASN1Sequence revCerts;
    private ASN1Sequence status;

    private RevRepContent(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
        this.status = ASN1Sequence.getInstance(r101.nextElement());
    L4:
        if (r101.hasMoreElements() == false) goto L9;
        ASN1TaggedObject r102 = ASN1TaggedObject.getInstance(r101.nextElement());
        int r103 = r102.getTagNo();
        ASN1Sequence r104 = ASN1Sequence.getInstance(r102, true);
        if (r103 == 0) goto L7;
        this.crls = r104;
        goto L4
    L7:
        this.revCerts = r104;
        goto L4
    }

    private void addOptional(ASN1EncodableVector r100, int r101, ASN1Encodable r102) {
        if (r102 == null) goto L5;
        r100.add(new DERTaggedObject(true, r101, r102));
        return;
    }

    public static RevRepContent getInstance(Object r100) {
        if ((r100 instanceof RevRepContent) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new RevRepContent(ASN1Sequence.getInstance(r100));
    L5:
        return (RevRepContent) r100;
    }

    public CertificateList[] getCrls() {
        ASN1Sequence r100 = this.crls;
        if (r100 != null) goto L6;
        return null;
    L6:
        int r101 = r100.size();
        CertificateList[] r102 = new CertificateList[r101];
        int r103 = 0;
    L7:
        if (r103 == r101) goto L9;
        r102[r103] = CertificateList.getInstance(this.crls.getObjectAt(r103));
        r103 = r103 + 1;
        goto L7
    L9:
        return r102;
    }

    public CertId[] getRevCerts() {
        ASN1Sequence r100 = this.revCerts;
        if (r100 != null) goto L6;
        return null;
    L6:
        int r101 = r100.size();
        CertId[] r102 = new CertId[r101];
        int r103 = 0;
    L7:
        if (r103 == r101) goto L9;
        r102[r103] = CertId.getInstance(this.revCerts.getObjectAt(r103));
        r103 = r103 + 1;
        goto L7
    L9:
        return r102;
    }

    public PKIStatusInfo[] getStatus() {
        int r100 = this.status.size();
        PKIStatusInfo[] r101 = new PKIStatusInfo[r100];
        int r102 = 0;
    L3:
        if (r102 == r100) goto L5;
        r101[r102] = PKIStatusInfo.getInstance(this.status.getObjectAt(r102));
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.status);
        addOptional(r100, 0, this.revCerts);
        addOptional(r100, 1, this.crls);
        return new DERSequence(r100);
    }
}
