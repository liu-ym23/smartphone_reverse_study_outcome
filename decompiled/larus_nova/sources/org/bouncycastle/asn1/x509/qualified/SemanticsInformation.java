package org.bouncycastle.asn1.x509.qualified;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.GeneralName;

/* JADX INFO: loaded from: classes42.dex */
public class SemanticsInformation extends ASN1Object {
    private GeneralName[] nameRegistrationAuthorities;
    private ASN1ObjectIdentifier semanticsIdentifier;

    public SemanticsInformation(ASN1ObjectIdentifier r100) {
        this.semanticsIdentifier = r100;
        this.nameRegistrationAuthorities = null;
    }

    public SemanticsInformation(ASN1ObjectIdentifier r100, GeneralName[] r101) {
        this.semanticsIdentifier = r100;
        this.nameRegistrationAuthorities = cloneNames(r101);
    }

    private SemanticsInformation(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
        if (r100.size() < 1) goto L17;
        Object r102 = r101.nextElement();
        if ((r102 instanceof ASN1ObjectIdentifier) == false) goto L10;
        this.semanticsIdentifier = ASN1ObjectIdentifier.getInstance(r102);
        if (r101.hasMoreElements() == false) goto L9;
        r102 = r101.nextElement();
        goto L10
    L9:
        r102 = null;
    L10:
        if (r102 == null) goto L15;
        ASN1Sequence r103 = ASN1Sequence.getInstance(r102);
        this.nameRegistrationAuthorities = new GeneralName[r103.size()];
        int r104 = 0;
    L13:
        if (r104 >= r103.size()) goto L19;
        this.nameRegistrationAuthorities[r104] = GeneralName.getInstance(r103.getObjectAt(r104));
        r104 = r104 + 1;
        goto L13
    L19:
        return;
    L15:
        return;
    L17:
        throw new IllegalArgumentException("no objects in SemanticsInformation");
    }

    public SemanticsInformation(GeneralName[] r100) {
        this.semanticsIdentifier = null;
        this.nameRegistrationAuthorities = cloneNames(r100);
    }

    private static GeneralName[] cloneNames(GeneralName[] r100) {
        if (r100 == null) goto L5;
        GeneralName[] r101 = new GeneralName[r100.length];
        System.arraycopy(r100, 0, r101, 0, r100.length);
        return r101;
    L5:
        return null;
    }

    public static SemanticsInformation getInstance(Object r100) {
        if ((r100 instanceof SemanticsInformation) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new SemanticsInformation(ASN1Sequence.getInstance(r100));
    L5:
        return (SemanticsInformation) r100;
    }

    public GeneralName[] getNameRegistrationAuthorities() {
        return cloneNames(this.nameRegistrationAuthorities);
    }

    public ASN1ObjectIdentifier getSemanticsIdentifier() {
        return this.semanticsIdentifier;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        ASN1ObjectIdentifier r101 = this.semanticsIdentifier;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        GeneralName[] r102 = this.nameRegistrationAuthorities;
        if (r102 == null) goto L9;
        r100.add(new DERSequence(r102));
    L9:
        return new DERSequence(r100);
    }
}
