package org.bouncycastle.asn1.isismtt.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.GeneralName;

/* JADX INFO: loaded from: classes42.dex */
public class AdmissionSyntax extends ASN1Object {
    private GeneralName admissionAuthority;
    private ASN1Sequence contentsOfAdmissions;

    private AdmissionSyntax(ASN1Sequence r100) {
        int r101 = r100.size();
        if (r101 != 1) goto L5;
        ASN1Encodable r102 = r100.getObjectAt(0);
    L10:
        this.contentsOfAdmissions = ASN1Sequence.getInstance(r102);
        return;
    L5:
        if (r101 != 2) goto L8;
        this.admissionAuthority = GeneralName.getInstance(r100.getObjectAt(0));
        r102 = r100.getObjectAt(1);
        goto L10
    L8:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public AdmissionSyntax(GeneralName r100, ASN1Sequence r101) {
        this.admissionAuthority = r100;
        this.contentsOfAdmissions = r101;
    }

    public static AdmissionSyntax getInstance(Object r100) {
        if (r100 == null) goto L13;
        if ((r100 instanceof AdmissionSyntax) == true) goto L13;
        if ((r100 instanceof ASN1Sequence) == false) goto L11;
        return new AdmissionSyntax((ASN1Sequence) r100);
    L11:
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L13:
        return (AdmissionSyntax) r100;
    }

    public GeneralName getAdmissionAuthority() {
        return this.admissionAuthority;
    }

    public Admissions[] getContentsOfAdmissions() {
        Admissions[] r100 = new Admissions[this.contentsOfAdmissions.size()];
        Enumeration r101 = this.contentsOfAdmissions.getObjects();
        int r102 = 0;
    L4:
        if (r101.hasMoreElements() == false) goto L6;
        r100[r102] = Admissions.getInstance(r101.nextElement());
        r102 = r102 + 1;
        goto L4
    L6:
        return r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        GeneralName r101 = this.admissionAuthority;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        r100.add(this.contentsOfAdmissions);
        return new DERSequence(r100);
    }
}
