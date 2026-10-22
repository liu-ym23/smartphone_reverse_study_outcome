package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class PKIData extends ASN1Object {
    private final TaggedContentInfo[] cmsSequence;
    private final TaggedAttribute[] controlSequence;
    private final OtherMsg[] otherMsgSequence;
    private final TaggedRequest[] reqSequence;

    private PKIData(ASN1Sequence r100) {
        if (r100.size() != 4) goto L22;
        int r101 = 0;
        ASN1Sequence r102 = (ASN1Sequence) r100.getObjectAt(0);
        this.controlSequence = new TaggedAttribute[r102.size()];
        int r103 = 0;
    L5:
        TaggedAttribute[] r104 = this.controlSequence;
        if (r103 >= r104.length) goto L8;
        r104[r103] = TaggedAttribute.getInstance(r102.getObjectAt(r103));
        r103 = r103 + 1;
        goto L5
    L8:
        ASN1Sequence r105 = (ASN1Sequence) r100.getObjectAt(1);
        this.reqSequence = new TaggedRequest[r105.size()];
        int r106 = 0;
    L9:
        TaggedRequest[] r107 = this.reqSequence;
        if (r106 >= r107.length) goto L12;
        r107[r106] = TaggedRequest.getInstance(r105.getObjectAt(r106));
        r106 = r106 + 1;
        goto L9
    L12:
        ASN1Sequence r108 = (ASN1Sequence) r100.getObjectAt(2);
        this.cmsSequence = new TaggedContentInfo[r108.size()];
        int r109 = 0;
    L13:
        TaggedContentInfo[] r110 = this.cmsSequence;
        if (r109 >= r110.length) goto L16;
        r110[r109] = TaggedContentInfo.getInstance(r108.getObjectAt(r109));
        r109 = r109 + 1;
        goto L13
    L16:
        ASN1Sequence r111 = (ASN1Sequence) r100.getObjectAt(3);
        this.otherMsgSequence = new OtherMsg[r111.size()];
    L17:
        OtherMsg[] r112 = this.otherMsgSequence;
        if (r101 >= r112.length) goto L20;
        r112[r101] = OtherMsg.getInstance(r111.getObjectAt(r101));
        r101 = r101 + 1;
        goto L17
    L20:
        return;
    L22:
        throw new IllegalArgumentException("Sequence not 4 elements.");
    }

    public PKIData(TaggedAttribute[] r100, TaggedRequest[] r101, TaggedContentInfo[] r102, OtherMsg[] r103) {
        this.controlSequence = copy(r100);
        this.reqSequence = copy(r101);
        this.cmsSequence = copy(r102);
        this.otherMsgSequence = copy(r103);
    }

    private OtherMsg[] copy(OtherMsg[] r100) {
        int r101 = r100.length;
        OtherMsg[] r102 = new OtherMsg[r101];
        System.arraycopy(r100, 0, r102, 0, r101);
        return r102;
    }

    private TaggedAttribute[] copy(TaggedAttribute[] r100) {
        int r101 = r100.length;
        TaggedAttribute[] r102 = new TaggedAttribute[r101];
        System.arraycopy(r100, 0, r102, 0, r101);
        return r102;
    }

    private TaggedContentInfo[] copy(TaggedContentInfo[] r100) {
        int r101 = r100.length;
        TaggedContentInfo[] r102 = new TaggedContentInfo[r101];
        System.arraycopy(r100, 0, r102, 0, r101);
        return r102;
    }

    private TaggedRequest[] copy(TaggedRequest[] r100) {
        int r101 = r100.length;
        TaggedRequest[] r102 = new TaggedRequest[r101];
        System.arraycopy(r100, 0, r102, 0, r101);
        return r102;
    }

    public static PKIData getInstance(Object r100) {
        if ((r100 instanceof PKIData) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PKIData(ASN1Sequence.getInstance(r100));
    L5:
        return (PKIData) r100;
    }

    public TaggedContentInfo[] getCmsSequence() {
        return copy(this.cmsSequence);
    }

    public TaggedAttribute[] getControlSequence() {
        return copy(this.controlSequence);
    }

    public OtherMsg[] getOtherMsgSequence() {
        return copy(this.otherMsgSequence);
    }

    public TaggedRequest[] getReqSequence() {
        return copy(this.reqSequence);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{new DERSequence(this.controlSequence), new DERSequence(this.reqSequence), new DERSequence(this.cmsSequence), new DERSequence(this.otherMsgSequence)});
    }
}
