package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;

/* JADX INFO: loaded from: classes42.dex */
public class CMCStatusInfoV2 extends ASN1Object {
    private final ASN1Sequence bodyList;
    private final CMCStatus cMCStatus;
    private final OtherStatusInfo otherStatusInfo;
    private final DERUTF8String statusString;

    private CMCStatusInfoV2(ASN1Sequence r100) {
        if (r100.size() < 2) goto L20;
        if (r100.size() > 4) goto L20;
        this.cMCStatus = CMCStatus.getInstance(r100.getObjectAt(0));
        this.bodyList = ASN1Sequence.getInstance(r100.getObjectAt(1));
        if (r100.size() > 2) goto L9;
        this.statusString = null;
    L17:
        this.otherStatusInfo = null;
        return;
    L9:
        if (r100.size() != 4) goto L13;
        this.statusString = DERUTF8String.getInstance(r100.getObjectAt(2));
        ASN1Encodable r101 = r100.getObjectAt(3);
    L11:
        this.otherStatusInfo = OtherStatusInfo.getInstance(r101);
        return;
    L13:
        if ((r100.getObjectAt(2) instanceof DERUTF8String) == false) goto L15;
        this.statusString = DERUTF8String.getInstance(r100.getObjectAt(2));
        goto L17
    L15:
        this.statusString = null;
        r101 = r100.getObjectAt(2);
    L20:
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public CMCStatusInfoV2(CMCStatus r100, ASN1Sequence r101, DERUTF8String r102, OtherStatusInfo r103) {
        this.cMCStatus = r100;
        this.bodyList = r101;
        this.statusString = r102;
        this.otherStatusInfo = r103;
    }

    public static CMCStatusInfoV2 getInstance(Object r100) {
        if ((r100 instanceof CMCStatusInfoV2) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CMCStatusInfoV2(ASN1Sequence.getInstance(r100));
    L5:
        return (CMCStatusInfoV2) r100;
    }

    public BodyPartID[] getBodyList() {
        return Utils.toBodyPartIDArray(this.bodyList);
    }

    public OtherStatusInfo getOtherStatusInfo() {
        return this.otherStatusInfo;
    }

    public DERUTF8String getStatusString() {
        return this.statusString;
    }

    public CMCStatus getcMCStatus() {
        return this.cMCStatus;
    }

    public boolean hasOtherInfo() {
        if (this.otherStatusInfo == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(4);
        r100.add(this.cMCStatus);
        r100.add(this.bodyList);
        DERUTF8String r101 = this.statusString;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        OtherStatusInfo r102 = this.otherStatusInfo;
        if (r102 == null) goto L9;
        r100.add(r102);
    L9:
        return new DERSequence(r100);
    }
}
