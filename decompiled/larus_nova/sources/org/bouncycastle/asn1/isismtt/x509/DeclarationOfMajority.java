package org.bouncycastle.asn1.isismtt.x509;

import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Choice;
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

/* JADX INFO: loaded from: classes42.dex */
public class DeclarationOfMajority extends ASN1Object implements ASN1Choice {
    public static final int dateOfBirth = 2;
    public static final int fullAgeAtCountry = 1;
    public static final int notYoungerThan = 0;
    private ASN1TaggedObject declaration;

    public DeclarationOfMajority(int r100) {
        this.declaration = new DERTaggedObject(false, 0, new ASN1Integer(r100));
    }

    public DeclarationOfMajority(ASN1GeneralizedTime r100) {
        this.declaration = new DERTaggedObject(false, 2, r100);
    }

    private DeclarationOfMajority(ASN1TaggedObject r100) {
        if (r100.getTagNo() > 2) goto L7;
        this.declaration = r100;
        return;
    L7:
        throw new IllegalArgumentException("Bad tag number: " + r100.getTagNo());
    }

    public DeclarationOfMajority(boolean r100, String r101) {
        if (r101.length() > 2) goto L10;
        if (r100 == false) goto L7;
        this.declaration = new DERTaggedObject(false, 1, new DERSequence(new DERPrintableString(r101, true)));
        return;
    L7:
        ASN1EncodableVector r102 = new ASN1EncodableVector(2);
        r102.add(ASN1Boolean.FALSE);
        r102.add(new DERPrintableString(r101, true));
        this.declaration = new DERTaggedObject(false, 1, new DERSequence(r102));
        return;
    L10:
        throw new IllegalArgumentException("country can only be 2 characters");
    }

    public static DeclarationOfMajority getInstance(Object r100) {
        if (r100 == null) goto L13;
        if ((r100 instanceof DeclarationOfMajority) == true) goto L13;
        if ((r100 instanceof ASN1TaggedObject) == false) goto L11;
        return new DeclarationOfMajority((ASN1TaggedObject) r100);
    L11:
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L13:
        return (DeclarationOfMajority) r100;
    }

    public ASN1Sequence fullAgeAtCountry() {
        if (this.declaration.getTagNo() == 1) goto L7;
        return null;
    L7:
        return ASN1Sequence.getInstance(this.declaration, false);
    }

    public ASN1GeneralizedTime getDateOfBirth() {
        if (this.declaration.getTagNo() == 2) goto L7;
        return null;
    L7:
        return ASN1GeneralizedTime.getInstance(this.declaration, false);
    }

    public int getType() {
        return this.declaration.getTagNo();
    }

    public int notYoungerThan() {
        if (this.declaration.getTagNo() == 0) goto L7;
        return -1;
    L7:
        return ASN1Integer.getInstance(this.declaration, false).intValueExact();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.declaration;
    }
}
