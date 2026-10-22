package org.bouncycastle.asn1.dvcs;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cmp.PKIStatusInfo;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.PolicyInformation;

/* JADX INFO: loaded from: classes42.dex */
public class DVCSCertInfo extends ASN1Object {
    private static final int DEFAULT_VERSION = 1;
    private static final int TAG_CERTS = 3;
    private static final int TAG_DV_STATUS = 0;
    private static final int TAG_POLICY = 1;
    private static final int TAG_REQ_SIGNATURE = 2;
    private ASN1Sequence certs;
    private DVCSRequestInformation dvReqInfo;
    private PKIStatusInfo dvStatus;
    private Extensions extensions;
    private DigestInfo messageImprint;
    private PolicyInformation policy;
    private ASN1Set reqSignature;
    private DVCSTime responseTime;
    private ASN1Integer serialNumber;
    private int version;

    private DVCSCertInfo(ASN1Sequence r100) {
        this.version = 1;
        ASN1Encodable r101 = r100.getObjectAt(0);
        this.version = ASN1Integer.getInstance(r101).intValueExact();     // Catch: IllegalArgumentException -> L6
        r101 = r100.getObjectAt(1);     // Catch: IllegalArgumentException -> L29
    L5:
        int r102 = 2;
    L7:
        this.dvReqInfo = DVCSRequestInformation.getInstance(r101);
        int r103 = r102 + 1;
        this.messageImprint = DigestInfo.getInstance(r100.getObjectAt(r102));
        int r104 = r103 + 1;
        this.serialNumber = ASN1Integer.getInstance(r100.getObjectAt(r103));
        int r105 = r104 + 1;
        this.responseTime = DVCSTime.getInstance(r100.getObjectAt(r104));
    L9:
        if (r105 >= r100.size()) goto L28;
        int r106 = r105 + 1;
        ASN1Encodable r107 = r100.getObjectAt(r105);
        if ((r107 instanceof ASN1TaggedObject) == false) goto L30;
        ASN1TaggedObject r108 = ASN1TaggedObject.getInstance(r107);
        int r109 = r108.getTagNo();
        if (r109 == 0) goto L23;
        if (r109 == 1) goto L22;
        if (r109 != 2) goto L17;
        this.reqSignature = ASN1Set.getInstance(r108, false);
    L27:
        r105 = r106;
        goto L9
    L17:
        if (r109 != 3) goto L20;
        this.certs = ASN1Sequence.getInstance(r108, false);
        goto L27
    L20:
        throw new IllegalArgumentException("Unknown tag encountered: " + r109);
    L22:
        this.policy = PolicyInformation.getInstance(ASN1Sequence.getInstance(r108, false));
        goto L27
    L23:
        this.dvStatus = PKIStatusInfo.getInstance(r108, false);
        goto L27
    L30:
        this.extensions = Extensions.getInstance(r107);     // Catch: IllegalArgumentException -> L26
        goto L27
    L28:
        return;
    L6:
        r102 = 1;
        goto L7
    }

    public DVCSCertInfo(DVCSRequestInformation r100, DigestInfo r101, ASN1Integer r102, DVCSTime r103) {
        this.version = 1;
        this.dvReqInfo = r100;
        this.messageImprint = r101;
        this.serialNumber = r102;
        this.responseTime = r103;
    }

    public static DVCSCertInfo getInstance(Object r100) {
        if ((r100 instanceof DVCSCertInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new DVCSCertInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (DVCSCertInfo) r100;
    }

    public static DVCSCertInfo getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    private void setDvReqInfo(DVCSRequestInformation r100) {
        this.dvReqInfo = r100;
    }

    private void setMessageImprint(DigestInfo r100) {
        this.messageImprint = r100;
    }

    private void setVersion(int r100) {
        this.version = r100;
    }

    public TargetEtcChain[] getCerts() {
        ASN1Sequence r100 = this.certs;
        if (r100 != null) goto L5;
        return null;
    L5:
        return TargetEtcChain.arrayFromSequence(r100);
    }

    public DVCSRequestInformation getDvReqInfo() {
        return this.dvReqInfo;
    }

    public PKIStatusInfo getDvStatus() {
        return this.dvStatus;
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public DigestInfo getMessageImprint() {
        return this.messageImprint;
    }

    public PolicyInformation getPolicy() {
        return this.policy;
    }

    public ASN1Set getReqSignature() {
        return this.reqSignature;
    }

    public DVCSTime getResponseTime() {
        return this.responseTime;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    public int getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(10);
        int r101 = this.version;
        if (r101 == 1) goto L5;
        r100.add(new ASN1Integer(r101));
    L5:
        r100.add(this.dvReqInfo);
        r100.add(this.messageImprint);
        r100.add(this.serialNumber);
        r100.add(this.responseTime);
        PKIStatusInfo r102 = this.dvStatus;
        if (r102 == null) goto L8;
        r100.add(new DERTaggedObject(false, 0, r102));
    L8:
        PolicyInformation r103 = this.policy;
        if (r103 == null) goto L11;
        r100.add(new DERTaggedObject(false, 1, r103));
    L11:
        ASN1Set r104 = this.reqSignature;
        if (r104 == null) goto L14;
        r100.add(new DERTaggedObject(false, 2, r104));
    L14:
        ASN1Sequence r105 = this.certs;
        if (r105 == null) goto L17;
        r100.add(new DERTaggedObject(false, 3, r105));
    L17:
        Extensions r106 = this.extensions;
        if (r106 == null) goto L21;
        r100.add(r106);
    L21:
        return new DERSequence(r100);
    }

    public String toString() {
        StringBuffer r100 = new StringBuffer("DVCSCertInfo {\n");
        if (this.version == 1) goto L5;
        r100.append("version: " + this.version + "\n");
    L5:
        r100.append("dvReqInfo: " + this.dvReqInfo + "\n");
        r100.append("messageImprint: " + this.messageImprint + "\n");
        r100.append("serialNumber: " + this.serialNumber + "\n");
        r100.append("responseTime: " + this.responseTime + "\n");
        if (this.dvStatus == null) goto L9;
        r100.append("dvStatus: " + this.dvStatus + "\n");
    L9:
        if (this.policy == null) goto L12;
        r100.append("policy: " + this.policy + "\n");
    L12:
        if (this.reqSignature == null) goto L15;
        r100.append("reqSignature: " + this.reqSignature + "\n");
    L15:
        if (this.certs == null) goto L18;
        r100.append("certs: " + this.certs + "\n");
    L18:
        if (this.extensions == null) goto L20;
        r100.append("extensions: " + this.extensions + "\n");
    L20:
        r100.append("}\n");
        return r100.toString();
    }
}
