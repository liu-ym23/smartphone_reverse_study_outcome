package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;

/* JADX INFO: loaded from: classes42.dex */
public class CMCStatusInfoV2Builder {
    private final ASN1Sequence bodyList;
    private final CMCStatus cMCStatus;
    private OtherStatusInfo otherInfo;
    private DERUTF8String statusString;

    public CMCStatusInfoV2Builder(CMCStatus r100, BodyPartID r101) {
        this.cMCStatus = r100;
        this.bodyList = new DERSequence(r101);
    }

    public CMCStatusInfoV2Builder(CMCStatus r100, BodyPartID[] r101) {
        this.cMCStatus = r100;
        this.bodyList = new DERSequence(r101);
    }

    public CMCStatusInfoV2 build() {
        return new CMCStatusInfoV2(this.cMCStatus, this.bodyList, this.statusString, this.otherInfo);
    }

    public CMCStatusInfoV2Builder setOtherInfo(CMCFailInfo r100) {
        this.otherInfo = new OtherStatusInfo(r100);
        return this;
    }

    public CMCStatusInfoV2Builder setOtherInfo(ExtendedFailInfo r100) {
        this.otherInfo = new OtherStatusInfo(r100);
        return this;
    }

    public CMCStatusInfoV2Builder setOtherInfo(PendInfo r100) {
        this.otherInfo = new OtherStatusInfo(r100);
        return this;
    }

    public CMCStatusInfoV2Builder setStatusString(String r100) {
        this.statusString = new DERUTF8String(r100);
        return this;
    }
}
