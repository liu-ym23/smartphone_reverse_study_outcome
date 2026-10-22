package org.bouncycastle.asn1.cmp;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class PKIStatusInfo extends ASN1Object {
    DERBitString failInfo;
    ASN1Integer status;
    PKIFreeText statusString;

    private PKIStatusInfo(ASN1Sequence r100) {
        this.status = ASN1Integer.getInstance(r100.getObjectAt(0));
        this.statusString = null;
        this.failInfo = null;
        if (r100.size() <= 2) goto L7;
        this.statusString = PKIFreeText.getInstance(r100.getObjectAt(1));
        ASN1Encodable r101 = r100.getObjectAt(2);
    L5:
        this.failInfo = DERBitString.getInstance(r101);
        return;
    L7:
        if (r100.size() <= 1) goto L14;
        r101 = r100.getObjectAt(1);
        if ((r101 instanceof DERBitString) == true) goto L5;
        this.statusString = PKIFreeText.getInstance(r101);
        return;
    }

    public PKIStatusInfo(PKIStatus r100) {
        this.status = ASN1Integer.getInstance(r100.toASN1Primitive());
    }

    public PKIStatusInfo(PKIStatus r100, PKIFreeText r101) {
        this.status = ASN1Integer.getInstance(r100.toASN1Primitive());
        this.statusString = r101;
    }

    public PKIStatusInfo(PKIStatus r100, PKIFreeText r101, PKIFailureInfo r102) {
        this.status = ASN1Integer.getInstance(r100.toASN1Primitive());
        this.statusString = r101;
        this.failInfo = r102;
    }

    public static PKIStatusInfo getInstance(Object r100) {
        if ((r100 instanceof PKIStatusInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PKIStatusInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (PKIStatusInfo) r100;
    }

    public static PKIStatusInfo getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public DERBitString getFailInfo() {
        return this.failInfo;
    }

    public BigInteger getStatus() {
        return this.status.getValue();
    }

    public PKIFreeText getStatusString() {
        return this.statusString;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.status);
        PKIFreeText r101 = this.statusString;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        DERBitString r102 = this.failInfo;
        if (r102 == null) goto L9;
        r100.add(r102);
    L9:
        return new DERSequence(r100);
    }
}
