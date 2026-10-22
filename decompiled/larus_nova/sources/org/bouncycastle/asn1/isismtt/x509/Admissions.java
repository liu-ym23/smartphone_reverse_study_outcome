package org.bouncycastle.asn1.isismtt.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.GeneralName;

/* JADX INFO: loaded from: classes42.dex */
public class Admissions extends ASN1Object {
    private GeneralName admissionAuthority;
    private NamingAuthority namingAuthority;
    private ASN1Sequence professionInfos;

    private Admissions(ASN1Sequence r100) {
        if (r100.size() > 3) goto L27;
        Enumeration r101 = r100.getObjects();
        ASN1Encodable r102 = (ASN1Encodable) r101.nextElement();
        if ((r102 instanceof ASN1TaggedObject) == false) goto L15;
        ASN1TaggedObject r103 = (ASN1TaggedObject) r102;
        int r104 = r103.getTagNo();
        if (r104 == 0) goto L12;
        if (r104 != 1) goto L11;
        this.namingAuthority = NamingAuthority.getInstance(r103, true);
    L13:
        r102 = (ASN1Encodable) r101.nextElement();
        goto L15
    L11:
        throw new IllegalArgumentException("Bad tag number: " + r103.getTagNo());
    L12:
        this.admissionAuthority = GeneralName.getInstance(r103, true);
    L15:
        if ((r102 instanceof ASN1TaggedObject) == false) goto L21;
        ASN1TaggedObject r105 = (ASN1TaggedObject) r102;
        if (r105.getTagNo() != 1) goto L20;
        this.namingAuthority = NamingAuthority.getInstance(r105, true);
        r102 = (ASN1Encodable) r101.nextElement();
        goto L21
    L20:
        throw new IllegalArgumentException("Bad tag number: " + r105.getTagNo());
    L21:
        this.professionInfos = ASN1Sequence.getInstance(r102);
        if (r101.hasMoreElements() == true) goto L25;
        return;
    L25:
        throw new IllegalArgumentException("Bad object encountered: " + r101.nextElement().getClass());
    L27:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public Admissions(GeneralName r100, NamingAuthority r101, ProfessionInfo[] r102) {
        this.admissionAuthority = r100;
        this.namingAuthority = r101;
        this.professionInfos = new DERSequence(r102);
    }

    public static Admissions getInstance(Object r100) {
        if (r100 == null) goto L13;
        if ((r100 instanceof Admissions) == true) goto L13;
        if ((r100 instanceof ASN1Sequence) == false) goto L11;
        return new Admissions((ASN1Sequence) r100);
    L11:
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L13:
        return (Admissions) r100;
    }

    public GeneralName getAdmissionAuthority() {
        return this.admissionAuthority;
    }

    public NamingAuthority getNamingAuthority() {
        return this.namingAuthority;
    }

    public ProfessionInfo[] getProfessionInfos() {
        ProfessionInfo[] r100 = new ProfessionInfo[this.professionInfos.size()];
        Enumeration r101 = this.professionInfos.getObjects();
        int r102 = 0;
    L4:
        if (r101.hasMoreElements() == false) goto L6;
        r100[r102] = ProfessionInfo.getInstance(r101.nextElement());
        r102 = r102 + 1;
        goto L4
    L6:
        return r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        GeneralName r101 = this.admissionAuthority;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(true, 0, r101));
    L5:
        NamingAuthority r102 = this.namingAuthority;
        if (r102 == null) goto L8;
        r100.add(new DERTaggedObject(true, 1, r102));
    L8:
        r100.add(this.professionInfos);
        return new DERSequence(r100);
    }
}
