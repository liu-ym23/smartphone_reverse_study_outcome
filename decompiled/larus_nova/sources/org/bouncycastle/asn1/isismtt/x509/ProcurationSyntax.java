package org.bouncycastle.asn1.isismtt.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.DirectoryString;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.IssuerSerial;

/* JADX INFO: loaded from: classes42.dex */
public class ProcurationSyntax extends ASN1Object {
    private IssuerSerial certRef;
    private String country;
    private GeneralName thirdPerson;
    private DirectoryString typeOfSubstitution;

    public ProcurationSyntax(String r100, DirectoryString r101, GeneralName r102) {
        this.country = r100;
        this.typeOfSubstitution = r101;
        this.thirdPerson = r102;
        this.certRef = null;
    }

    public ProcurationSyntax(String r100, DirectoryString r101, IssuerSerial r102) {
        this.country = r100;
        this.typeOfSubstitution = r101;
        this.thirdPerson = null;
        this.certRef = r102;
    }

    private ProcurationSyntax(ASN1Sequence r100) {
        if (r100.size() < 1) goto L24;
        if (r100.size() > 3) goto L24;
        Enumeration r101 = r100.getObjects();
    L8:
        if (r101.hasMoreElements() == false) goto L22;
        ASN1TaggedObject r102 = ASN1TaggedObject.getInstance(r101.nextElement());
        int r103 = r102.getTagNo();
        if (r103 != 1) goto L12;
        this.country = DERPrintableString.getInstance(r102, true).getString();
        goto L8
    L12:
        if (r103 != 2) goto L13;
        this.typeOfSubstitution = DirectoryString.getInstance(r102, true);
        goto L8
    L13:
        if (r103 != 3) goto L19;
        ASN1Primitive r104 = r102.getObject();
        if ((r104 instanceof ASN1TaggedObject) == true) goto L16;
        this.certRef = IssuerSerial.getInstance(r104);
        goto L8
    L16:
        this.thirdPerson = GeneralName.getInstance(r104);
        goto L8
    L19:
        throw new IllegalArgumentException("Bad tag number: " + r102.getTagNo());
    L22:
        return;
    L24:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public static ProcurationSyntax getInstance(Object r100) {
        if (r100 == null) goto L13;
        if ((r100 instanceof ProcurationSyntax) == true) goto L13;
        if ((r100 instanceof ASN1Sequence) == false) goto L11;
        return new ProcurationSyntax((ASN1Sequence) r100);
    L11:
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L13:
        return (ProcurationSyntax) r100;
    }

    public IssuerSerial getCertRef() {
        return this.certRef;
    }

    public String getCountry() {
        return this.country;
    }

    public GeneralName getThirdPerson() {
        return this.thirdPerson;
    }

    public DirectoryString getTypeOfSubstitution() {
        return this.typeOfSubstitution;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        String r101 = this.country;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(true, 1, new DERPrintableString(r101, true)));
    L5:
        DirectoryString r102 = this.typeOfSubstitution;
        if (r102 == null) goto L8;
        r100.add(new DERTaggedObject(true, 2, r102));
    L8:
        GeneralName r103 = this.thirdPerson;
        if (r103 == null) goto L11;
        r100.add(new DERTaggedObject(true, 3, r103));
    L13:
        return new DERSequence(r100);
    L11:
        r100.add(new DERTaggedObject(true, 3, this.certRef));
        goto L13
    }
}
