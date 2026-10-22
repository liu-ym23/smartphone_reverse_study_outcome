package org.bouncycastle.asn1.x500;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBMPString;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERT61String;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.DERUniversalString;

/* JADX INFO: loaded from: classes42.dex */
public class DirectoryString extends ASN1Object implements ASN1Choice, ASN1String {
    private ASN1String string;

    public DirectoryString(String r100) {
        this.string = new DERUTF8String(r100);
    }

    private DirectoryString(DERBMPString r100) {
        this.string = r100;
    }

    private DirectoryString(DERPrintableString r100) {
        this.string = r100;
    }

    private DirectoryString(DERT61String r100) {
        this.string = r100;
    }

    private DirectoryString(DERUTF8String r100) {
        this.string = r100;
    }

    private DirectoryString(DERUniversalString r100) {
        this.string = r100;
    }

    public static DirectoryString getInstance(Object r100) {
        if (r100 == null) goto L29;
        if ((r100 instanceof DirectoryString) == true) goto L29;
        if ((r100 instanceof DERT61String) == false) goto L11;
        return new DirectoryString((DERT61String) r100);
    L11:
        if ((r100 instanceof DERPrintableString) == false) goto L15;
        return new DirectoryString((DERPrintableString) r100);
    L15:
        if ((r100 instanceof DERUniversalString) == false) goto L19;
        return new DirectoryString((DERUniversalString) r100);
    L19:
        if ((r100 instanceof DERUTF8String) == false) goto L23;
        return new DirectoryString((DERUTF8String) r100);
    L23:
        if ((r100 instanceof DERBMPString) == false) goto L27;
        return new DirectoryString((DERBMPString) r100);
    L27:
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L29:
        return (DirectoryString) r100;
    }

    public static DirectoryString getInstance(ASN1TaggedObject r100, boolean r101) {
        if (r101 == false) goto L6;
        return getInstance(r100.getObject());
    L6:
        throw new IllegalArgumentException("choice item must be explicitly tagged");
    }

    @Override // org.bouncycastle.asn1.ASN1String
    public String getString() {
        return this.string.getString();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ((ASN1Encodable) this.string).toASN1Primitive();
    }

    public String toString() {
        return this.string.getString();
    }
}
