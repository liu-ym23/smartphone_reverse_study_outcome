package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.x500.DirectoryString;

/* JADX INFO: loaded from: classes42.dex */
public class SignerLocation extends ASN1Object {
    private DirectoryString countryName;
    private DirectoryString localityName;
    private ASN1Sequence postalAddress;

    private SignerLocation(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
    L4:
        if (r101.hasMoreElements() == false) goto L25;
        ASN1TaggedObject r102 = (ASN1TaggedObject) r101.nextElement();
        int r103 = r102.getTagNo();
        if (r103 != 0) goto L7;
        this.countryName = DirectoryString.getInstance(r102, true);
        goto L4
    L7:
        if (r103 != 1) goto L9;
        this.localityName = DirectoryString.getInstance(r102, true);
        goto L4
    L9:
        if (r103 != 2) goto L22;
        if (r102.isExplicit() == false) goto L13;
        ASN1Sequence r104 = ASN1Sequence.getInstance(r102, true);
    L14:
        this.postalAddress = r104;
        ASN1Sequence r105 = this.postalAddress;
        if (r105 == null) goto L4;
        if (r105.size() <= 6) goto L4;
        throw new IllegalArgumentException("postal address must contain less than 6 strings");
    L13:
        r104 = ASN1Sequence.getInstance(r102, false);
        goto L14
    L22:
        throw new IllegalArgumentException("illegal tag");
    }

    public SignerLocation(DERUTF8String r100, DERUTF8String r101, ASN1Sequence r102) {
        this(DirectoryString.getInstance(r100), DirectoryString.getInstance(r101), r102);
    }

    private SignerLocation(DirectoryString r100, DirectoryString r101, ASN1Sequence r102) {
        if (r102 != null) goto L5;
    L9:
        this.countryName = r100;
        this.localityName = r101;
        this.postalAddress = r102;
        return;
    L5:
        if (r102.size() <= 6) goto L9;
        throw new IllegalArgumentException("postal address must contain less than 6 strings");
    }

    public SignerLocation(DirectoryString r100, DirectoryString r101, DirectoryString[] r102) {
        this(r100, r101, new DERSequence(r102));
    }

    public static SignerLocation getInstance(Object r100) {
        if (r100 == null) goto L9;
        if ((r100 instanceof SignerLocation) == true) goto L9;
        return new SignerLocation(ASN1Sequence.getInstance(r100));
    L9:
        return (SignerLocation) r100;
    }

    public DirectoryString getCountry() {
        return this.countryName;
    }

    public DERUTF8String getCountryName() {
        if (this.countryName != null) goto L7;
        return null;
    L7:
        return new DERUTF8String(getCountry().getString());
    }

    public DirectoryString getLocality() {
        return this.localityName;
    }

    public DERUTF8String getLocalityName() {
        if (this.localityName != null) goto L7;
        return null;
    L7:
        return new DERUTF8String(getLocality().getString());
    }

    public DirectoryString[] getPostal() {
        ASN1Sequence r100 = this.postalAddress;
        if (r100 != null) goto L6;
        return null;
    L6:
        int r101 = r100.size();
        DirectoryString[] r102 = new DirectoryString[r101];
        int r103 = 0;
    L7:
        if (r103 == r101) goto L9;
        r102[r103] = DirectoryString.getInstance(this.postalAddress.getObjectAt(r103));
        r103 = r103 + 1;
        goto L7
    L9:
        return r102;
    }

    public ASN1Sequence getPostalAddress() {
        return this.postalAddress;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        DirectoryString r101 = this.countryName;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(true, 0, r101));
    L5:
        DirectoryString r102 = this.localityName;
        if (r102 == null) goto L8;
        r100.add(new DERTaggedObject(true, 1, r102));
    L8:
        ASN1Sequence r103 = this.postalAddress;
        if (r103 == null) goto L12;
        r100.add(new DERTaggedObject(true, 2, r103));
    L12:
        return new DERSequence(r100);
    }
}
