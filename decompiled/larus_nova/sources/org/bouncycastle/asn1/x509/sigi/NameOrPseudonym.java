package org.bouncycastle.asn1.x509.sigi;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.DirectoryString;

/* JADX INFO: loaded from: classes42.dex */
public class NameOrPseudonym extends ASN1Object implements ASN1Choice {
    private ASN1Sequence givenName;
    private DirectoryString pseudonym;
    private DirectoryString surname;

    public NameOrPseudonym(String r100) {
        this(new DirectoryString(r100));
    }

    private NameOrPseudonym(ASN1Sequence r100) {
        if (r100.size() != 2) goto L11;
        if ((r100.getObjectAt(0) instanceof ASN1String) == false) goto L9;
        this.surname = DirectoryString.getInstance(r100.getObjectAt(0));
        this.givenName = ASN1Sequence.getInstance(r100.getObjectAt(1));
        return;
    L9:
        throw new IllegalArgumentException("Bad object encountered: " + r100.getObjectAt(0).getClass());
    L11:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public NameOrPseudonym(DirectoryString r100) {
        this.pseudonym = r100;
    }

    public NameOrPseudonym(DirectoryString r100, ASN1Sequence r101) {
        this.surname = r100;
        this.givenName = r101;
    }

    public static NameOrPseudonym getInstance(Object r100) {
        if (r100 == null) goto L17;
        if ((r100 instanceof NameOrPseudonym) == true) goto L17;
        if ((r100 instanceof ASN1String) == false) goto L11;
        return new NameOrPseudonym(DirectoryString.getInstance(r100));
    L11:
        if ((r100 instanceof ASN1Sequence) == false) goto L15;
        return new NameOrPseudonym((ASN1Sequence) r100);
    L15:
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L17:
        return (NameOrPseudonym) r100;
    }

    public DirectoryString[] getGivenName() {
        DirectoryString[] r100 = new DirectoryString[this.givenName.size()];
        Enumeration r101 = this.givenName.getObjects();
        int r102 = 0;
    L4:
        if (r101.hasMoreElements() == false) goto L6;
        r100[r102] = DirectoryString.getInstance(r101.nextElement());
        r102 = r102 + 1;
        goto L4
    L6:
        return r100;
    }

    public DirectoryString getPseudonym() {
        return this.pseudonym;
    }

    public DirectoryString getSurname() {
        return this.surname;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        DirectoryString r100 = this.pseudonym;
        if (r100 != null) goto L5;
        ASN1EncodableVector r101 = new ASN1EncodableVector(2);
        r101.add(this.surname);
        r101.add(this.givenName);
        return new DERSequence(r101);
    L5:
        return r100.toASN1Primitive();
    }
}
