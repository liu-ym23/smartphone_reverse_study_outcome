package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;

/* JADX INFO: loaded from: classes42.dex */
public class CMCStatusInfoBuilder {
    private final ASN1Sequence bodyList;
    private final CMCStatus cMCStatus;
    private CMCStatusInfo.OtherInfo otherInfo;
    private DERUTF8String statusString;

    public CMCStatusInfoBuilder(CMCStatus r100, BodyPartID r101) {
        this.cMCStatus = r100;
        this.bodyList = new DERSequence(r101);
    }

    public CMCStatusInfoBuilder(CMCStatus r100, BodyPartID[] r101) {
        this.cMCStatus = r100;
        this.bodyList = new DERSequence(r101);
    }

    public CMCStatusInfo build() {
        return new CMCStatusInfo(this.cMCStatus, this.bodyList, this.statusString, this.otherInfo);
    }

    public CMCStatusInfoBuilder setOtherInfo(CMCFailInfo r100) {
        this.otherInfo = new CMCStatusInfo.OtherInfo(r100);
        return this;
    }

    public CMCStatusInfoBuilder setOtherInfo(PendInfo r100) {
        this.otherInfo = new CMCStatusInfo.OtherInfo(r100);
        return this;
    }

    public CMCStatusInfoBuilder setStatusString(String r100) {
        this.statusString = new DERUTF8String(r100);
        return this;
    }
}
