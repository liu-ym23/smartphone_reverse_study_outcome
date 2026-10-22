package org.bouncycastle.asn1.isismtt.x509;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x500.DirectoryString;

/* JADX INFO: loaded from: classes42.dex */
public class AdditionalInformationSyntax extends ASN1Object {
    private DirectoryString information;

    public AdditionalInformationSyntax(String r100) {
        this(new DirectoryString(r100));
    }

    private AdditionalInformationSyntax(DirectoryString r100) {
        this.information = r100;
    }

    public static AdditionalInformationSyntax getInstance(Object r100) {
        if ((r100 instanceof AdditionalInformationSyntax) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new AdditionalInformationSyntax(DirectoryString.getInstance(r100));
    L5:
        return (AdditionalInformationSyntax) r100;
    }

    public DirectoryString getInformation() {
        return this.information;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.information.toASN1Primitive();
    }
}
