package org.bouncycastle.asn1.x509.sigi;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.DirectoryString;

/* JADX INFO: loaded from: classes42.dex */
public class PersonalData extends ASN1Object {
    private ASN1GeneralizedTime dateOfBirth;
    private String gender;
    private BigInteger nameDistinguisher;
    private NameOrPseudonym nameOrPseudonym;
    private DirectoryString placeOfBirth;
    private DirectoryString postalAddress;

    private PersonalData(ASN1Sequence r100) {
        if (r100.size() < 1) goto L25;
        Enumeration r101 = r100.getObjects();
        this.nameOrPseudonym = NameOrPseudonym.getInstance(r101.nextElement());
    L6:
        if (r101.hasMoreElements() == false) goto L23;
        ASN1TaggedObject r102 = ASN1TaggedObject.getInstance(r101.nextElement());
        int r103 = r102.getTagNo();
        if (r103 != 0) goto L9;
        this.nameDistinguisher = ASN1Integer.getInstance(r102, false).getValue();
        goto L6
    L9:
        if (r103 != 1) goto L11;
        this.dateOfBirth = ASN1GeneralizedTime.getInstance(r102, false);
        goto L6
    L11:
        if (r103 != 2) goto L13;
        this.placeOfBirth = DirectoryString.getInstance(r102, true);
        goto L6
    L13:
        if (r103 != 3) goto L15;
        this.gender = DERPrintableString.getInstance(r102, false).getString();
        goto L6
    L15:
        if (r103 != 4) goto L18;
        this.postalAddress = DirectoryString.getInstance(r102, true);
        goto L6
    L18:
        throw new IllegalArgumentException("Bad tag number: " + r102.getTagNo());
    L23:
        return;
    L25:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public PersonalData(NameOrPseudonym r100, BigInteger r101, ASN1GeneralizedTime r102, DirectoryString r103, String r104, DirectoryString r105) {
        this.nameOrPseudonym = r100;
        this.dateOfBirth = r102;
        this.gender = r104;
        this.nameDistinguisher = r101;
        this.postalAddress = r105;
        this.placeOfBirth = r103;
    }

    public static PersonalData getInstance(Object r100) {
        if (r100 == null) goto L13;
        if ((r100 instanceof PersonalData) == true) goto L13;
        if ((r100 instanceof ASN1Sequence) == false) goto L11;
        return new PersonalData((ASN1Sequence) r100);
    L11:
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L13:
        return (PersonalData) r100;
    }

    public ASN1GeneralizedTime getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getGender() {
        return this.gender;
    }

    public BigInteger getNameDistinguisher() {
        return this.nameDistinguisher;
    }

    public NameOrPseudonym getNameOrPseudonym() {
        return this.nameOrPseudonym;
    }

    public DirectoryString getPlaceOfBirth() {
        return this.placeOfBirth;
    }

    public DirectoryString getPostalAddress() {
        return this.postalAddress;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(6);
        r100.add(this.nameOrPseudonym);
        BigInteger r101 = this.nameDistinguisher;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(false, 0, new ASN1Integer(r101)));
    L5:
        ASN1GeneralizedTime r102 = this.dateOfBirth;
        if (r102 == null) goto L8;
        r100.add(new DERTaggedObject(false, 1, r102));
    L8:
        DirectoryString r103 = this.placeOfBirth;
        if (r103 == null) goto L11;
        r100.add(new DERTaggedObject(true, 2, r103));
    L11:
        String r104 = this.gender;
        if (r104 == null) goto L14;
        r100.add(new DERTaggedObject(false, 3, new DERPrintableString(r104, true)));
    L14:
        DirectoryString r105 = this.postalAddress;
        if (r105 == null) goto L18;
        r100.add(new DERTaggedObject(true, 4, r105));
    L18:
        return new DERSequence(r100);
    }
}
