package org.bouncycastle.asn1.cms;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class EnvelopedData extends ASN1Object {
    private EncryptedContentInfo encryptedContentInfo;
    private OriginatorInfo originatorInfo;
    private ASN1Set recipientInfos;
    private ASN1Set unprotectedAttrs;
    private ASN1Integer version;

    public EnvelopedData(ASN1Sequence r100) {
        this.version = (ASN1Integer) r100.getObjectAt(0);
        ASN1Encodable r101 = r100.getObjectAt(1);
        int r102 = 2;
        if ((r101 instanceof ASN1TaggedObject) == false) goto L5;
        this.originatorInfo = OriginatorInfo.getInstance((ASN1TaggedObject) r101, false);
        r101 = r100.getObjectAt(2);
        r102 = 3;
    L5:
        this.recipientInfos = ASN1Set.getInstance(r101);
        int r103 = r102 + 1;
        this.encryptedContentInfo = EncryptedContentInfo.getInstance(r100.getObjectAt(r102));
        if (r100.size() <= r103) goto L9;
        this.unprotectedAttrs = ASN1Set.getInstance((ASN1TaggedObject) r100.getObjectAt(r103), false);
        return;
    }

    public EnvelopedData(OriginatorInfo r100, ASN1Set r101, EncryptedContentInfo r102, ASN1Set r103) {
        this.version = new ASN1Integer(calculateVersion(r100, r101, r103));
        this.originatorInfo = r100;
        this.recipientInfos = r101;
        this.encryptedContentInfo = r102;
        this.unprotectedAttrs = r103;
    }

    public EnvelopedData(OriginatorInfo r100, ASN1Set r101, EncryptedContentInfo r102, Attributes r103) {
        this.version = new ASN1Integer(calculateVersion(r100, r101, ASN1Set.getInstance(r103)));
        this.originatorInfo = r100;
        this.recipientInfos = r101;
        this.encryptedContentInfo = r102;
        this.unprotectedAttrs = ASN1Set.getInstance(r103);
    }

    public static int calculateVersion(OriginatorInfo r100, ASN1Set r101, ASN1Set r102) {
        if (r100 != null) goto L17;
        if (r102 != null) goto L18;
        Enumeration r103 = r101.getObjects();
    L8:
        if (r103.hasMoreElements() == false) goto L12;
        if (RecipientInfo.getInstance(r103.nextElement()).getVersion().intValueExact() == 0) goto L8;
        return 2;
    L12:
        return 0;
    L18:
        return 2;
    L17:
        return 2;
    }

    public static EnvelopedData getInstance(Object r100) {
        if ((r100 instanceof EnvelopedData) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new EnvelopedData(ASN1Sequence.getInstance(r100));
    L5:
        return (EnvelopedData) r100;
    }

    public static EnvelopedData getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public EncryptedContentInfo getEncryptedContentInfo() {
        return this.encryptedContentInfo;
    }

    public OriginatorInfo getOriginatorInfo() {
        return this.originatorInfo;
    }

    public ASN1Set getRecipientInfos() {
        return this.recipientInfos;
    }

    public ASN1Set getUnprotectedAttrs() {
        return this.unprotectedAttrs;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(5);
        r100.add(this.version);
        OriginatorInfo r101 = this.originatorInfo;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(false, 0, r101));
    L5:
        r100.add(this.recipientInfos);
        r100.add(this.encryptedContentInfo);
        ASN1Set r102 = this.unprotectedAttrs;
        if (r102 == null) goto L9;
        r100.add(new DERTaggedObject(false, 1, r102));
    L9:
        return new BERSequence(r100);
    }
}
