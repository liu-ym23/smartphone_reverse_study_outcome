package org.bouncycastle.asn1.cmp;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class CertStatus extends ASN1Object {
    private ASN1OctetString certHash;
    private ASN1Integer certReqId;
    private PKIStatusInfo statusInfo;

    private CertStatus(ASN1Sequence r100) {
        this.certHash = ASN1OctetString.getInstance(r100.getObjectAt(0));
        this.certReqId = ASN1Integer.getInstance(r100.getObjectAt(1));
        if (r100.size() <= 2) goto L6;
        this.statusInfo = PKIStatusInfo.getInstance(r100.getObjectAt(2));
        return;
    }

    public CertStatus(byte[] r100, BigInteger r101) {
        this.certHash = new DEROctetString(r100);
        this.certReqId = new ASN1Integer(r101);
    }

    public CertStatus(byte[] r100, BigInteger r101, PKIStatusInfo r102) {
        this.certHash = new DEROctetString(r100);
        this.certReqId = new ASN1Integer(r101);
        this.statusInfo = r102;
    }

    public static CertStatus getInstance(Object r100) {
        if ((r100 instanceof CertStatus) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CertStatus(ASN1Sequence.getInstance(r100));
    L5:
        return (CertStatus) r100;
    }

    public ASN1OctetString getCertHash() {
        return this.certHash;
    }

    public ASN1Integer getCertReqId() {
        return this.certReqId;
    }

    public PKIStatusInfo getStatusInfo() {
        return this.statusInfo;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.certHash);
        r100.add(this.certReqId);
        PKIStatusInfo r101 = this.statusInfo;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
