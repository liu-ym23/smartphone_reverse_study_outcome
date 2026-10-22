package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;

/* JADX INFO: loaded from: classes42.dex */
public class CMCStatusInfo extends ASN1Object {
    private final ASN1Sequence bodyList;
    private final CMCStatus cMCStatus;
    private final OtherInfo otherInfo;
    private final DERUTF8String statusString;

    public static class OtherInfo extends ASN1Object implements ASN1Choice {
        private final CMCFailInfo failInfo;
        private final PendInfo pendInfo;

        public OtherInfo(CMCFailInfo r100) {
            this(r100, null);
        }

        private OtherInfo(CMCFailInfo r100, PendInfo r101) {
            this.failInfo = r100;
            this.pendInfo = r101;
        }

        public OtherInfo(PendInfo r100) {
            this(null, r100);
        }

        public static /* synthetic */ OtherInfo access$000(Object r100) {
            return getInstance(r100);
        }

        private static OtherInfo getInstance(Object r100) {
            if ((r100 instanceof OtherInfo) == false) goto L7;
            return (OtherInfo) r100;
        L7:
            if ((r100 instanceof ASN1Encodable) == false) goto L17;
            ASN1Primitive r101 = ((ASN1Encodable) r100).toASN1Primitive();
            if ((r101 instanceof ASN1Integer) == false) goto L13;
            return new OtherInfo(CMCFailInfo.getInstance(r101));
        L13:
            if ((r101 instanceof ASN1Sequence) == false) goto L17;
            return new OtherInfo(PendInfo.getInstance(r101));
        L17:
            throw new IllegalArgumentException("unknown object in getInstance(): ".concat(r100.getClass().getName()));
        }

        public boolean isFailInfo() {
            if (this.failInfo == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
        public ASN1Primitive toASN1Primitive() {
            PendInfo r100 = this.pendInfo;
            if (r100 == null) goto L7;
            return r100.toASN1Primitive();
        L7:
            return this.failInfo.toASN1Primitive();
        }
    }

    private CMCStatusInfo(ASN1Sequence r100) {
        if (r100.size() < 2) goto L20;
        if (r100.size() > 4) goto L20;
        this.cMCStatus = CMCStatus.getInstance(r100.getObjectAt(0));
        this.bodyList = ASN1Sequence.getInstance(r100.getObjectAt(1));
        if (r100.size() <= 3) goto L11;
        this.statusString = DERUTF8String.getInstance(r100.getObjectAt(2));
        ASN1Encodable r101 = r100.getObjectAt(3);
    L9:
        this.otherInfo = OtherInfo.access$000(r101);
        return;
    L11:
        if (r100.size() > 2) goto L13;
        this.statusString = null;
    L17:
        this.otherInfo = null;
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

    public CMCStatusInfo(CMCStatus r100, ASN1Sequence r101, DERUTF8String r102, OtherInfo r103) {
        this.cMCStatus = r100;
        this.bodyList = r101;
        this.statusString = r102;
        this.otherInfo = r103;
    }

    public static CMCStatusInfo getInstance(Object r100) {
        if ((r100 instanceof CMCStatusInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CMCStatusInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (CMCStatusInfo) r100;
    }

    public BodyPartID[] getBodyList() {
        return Utils.toBodyPartIDArray(this.bodyList);
    }

    public CMCStatus getCMCStatus() {
        return this.cMCStatus;
    }

    public OtherInfo getOtherInfo() {
        return this.otherInfo;
    }

    public DERUTF8String getStatusString() {
        return this.statusString;
    }

    public boolean hasOtherInfo() {
        if (this.otherInfo == null) goto L5;
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
        OtherInfo r102 = this.otherInfo;
        if (r102 == null) goto L9;
        r100.add(r102);
    L9:
        return new DERSequence(r100);
    }
}
