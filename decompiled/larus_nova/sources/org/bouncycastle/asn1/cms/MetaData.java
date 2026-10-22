package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;

/* JADX INFO: loaded from: classes42.dex */
public class MetaData extends ASN1Object {
    private DERUTF8String fileName;
    private ASN1Boolean hashProtected;
    private DERIA5String mediaType;
    private Attributes otherMetaData;

    public MetaData(ASN1Boolean r100, DERUTF8String r101, DERIA5String r102, Attributes r103) {
        this.hashProtected = r100;
        this.fileName = r101;
        this.mediaType = r102;
        this.otherMetaData = r103;
    }

    private MetaData(ASN1Sequence r100) {
        this.hashProtected = ASN1Boolean.getInstance(r100.getObjectAt(0));
        int r101 = 1;
        if (1 >= r100.size()) goto L8;
        if ((r100.getObjectAt(1) instanceof DERUTF8String) == false) goto L8;
        this.fileName = DERUTF8String.getInstance(r100.getObjectAt(1));
        r101 = 2;
    L8:
        if (r101 >= r100.size()) goto L13;
        if ((r100.getObjectAt(r101) instanceof DERIA5String) == false) goto L13;
        int r102 = r101 + 1;
        this.mediaType = DERIA5String.getInstance(r100.getObjectAt(r101));
        r101 = r102;
    L13:
        if (r101 >= r100.size()) goto L16;
        this.otherMetaData = Attributes.getInstance(r100.getObjectAt(r101));
        return;
    }

    public static MetaData getInstance(Object r100) {
        if ((r100 instanceof MetaData) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new MetaData(ASN1Sequence.getInstance(r100));
    L5:
        return (MetaData) r100;
    }

    public DERUTF8String getFileName() {
        return this.fileName;
    }

    public DERIA5String getMediaType() {
        return this.mediaType;
    }

    public Attributes getOtherMetaData() {
        return this.otherMetaData;
    }

    public boolean isHashProtected() {
        return this.hashProtected.isTrue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(4);
        r100.add(this.hashProtected);
        DERUTF8String r101 = this.fileName;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        DERIA5String r102 = this.mediaType;
        if (r102 == null) goto L8;
        r100.add(r102);
    L8:
        Attributes r103 = this.otherMetaData;
        if (r103 == null) goto L12;
        r100.add(r103);
    L12:
        return new DERSequence(r100);
    }
}
