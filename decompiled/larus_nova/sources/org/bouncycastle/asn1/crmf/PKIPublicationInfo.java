package org.bouncycastle.asn1.crmf;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class PKIPublicationInfo extends ASN1Object {
    public static final ASN1Integer dontPublish = null;
    public static final ASN1Integer pleasePublish = null;
    private ASN1Integer action;
    private ASN1Sequence pubInfos;

    static {
        dontPublish = new ASN1Integer(0);
        pleasePublish = new ASN1Integer(1);
    }

    public PKIPublicationInfo(BigInteger r100) {
        this(new ASN1Integer(r100));
    }

    public PKIPublicationInfo(ASN1Integer r100) {
        this.action = r100;
    }

    private PKIPublicationInfo(ASN1Sequence r100) {
        this.action = ASN1Integer.getInstance(r100.getObjectAt(0));
        if (r100.size() <= 1) goto L6;
        this.pubInfos = ASN1Sequence.getInstance(r100.getObjectAt(1));
        return;
    }

    public PKIPublicationInfo(SinglePubInfo r100) {
        if (r100 == null) goto L4;
        SinglePubInfo[] r101 = {r100};
    L5:
        this(r101);
        return;
    L4:
        r101 = null;
        goto L5
    }

    public PKIPublicationInfo(SinglePubInfo[] r100) {
        this.action = pleasePublish;
        if (r100 == null) goto L5;
        this.pubInfos = new DERSequence(r100);
        return;
    L5:
        this.pubInfos = null;
    }

    public static PKIPublicationInfo getInstance(Object r100) {
        if ((r100 instanceof PKIPublicationInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PKIPublicationInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (PKIPublicationInfo) r100;
    }

    public ASN1Integer getAction() {
        return this.action;
    }

    public SinglePubInfo[] getPubInfos() {
        ASN1Sequence r100 = this.pubInfos;
        if (r100 != null) goto L6;
        return null;
    L6:
        int r101 = r100.size();
        SinglePubInfo[] r102 = new SinglePubInfo[r101];
        int r103 = 0;
    L7:
        if (r103 == r101) goto L9;
        r102[r103] = SinglePubInfo.getInstance(this.pubInfos.getObjectAt(r103));
        r103 = r103 + 1;
        goto L7
    L9:
        return r102;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.action);
        ASN1Sequence r101 = this.pubInfos;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
