package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.crmf.CertReqMessages;
import org.bouncycastle.asn1.pkcs.CertificationRequest;

/* JADX INFO: loaded from: classes42.dex */
public class PKIBody extends ASN1Object implements ASN1Choice {
    public static final int TYPE_CA_KEY_UPDATE_ANN = 15;
    public static final int TYPE_CERT_ANN = 16;
    public static final int TYPE_CERT_CONFIRM = 24;
    public static final int TYPE_CERT_REP = 3;
    public static final int TYPE_CERT_REQ = 2;
    public static final int TYPE_CONFIRM = 19;
    public static final int TYPE_CRL_ANN = 18;
    public static final int TYPE_CROSS_CERT_REP = 14;
    public static final int TYPE_CROSS_CERT_REQ = 13;
    public static final int TYPE_ERROR = 23;
    public static final int TYPE_GEN_MSG = 21;
    public static final int TYPE_GEN_REP = 22;
    public static final int TYPE_INIT_REP = 1;
    public static final int TYPE_INIT_REQ = 0;
    public static final int TYPE_KEY_RECOVERY_REP = 10;
    public static final int TYPE_KEY_RECOVERY_REQ = 9;
    public static final int TYPE_KEY_UPDATE_REP = 8;
    public static final int TYPE_KEY_UPDATE_REQ = 7;
    public static final int TYPE_NESTED = 20;
    public static final int TYPE_P10_CERT_REQ = 4;
    public static final int TYPE_POLL_REP = 26;
    public static final int TYPE_POLL_REQ = 25;
    public static final int TYPE_POPO_CHALL = 5;
    public static final int TYPE_POPO_REP = 6;
    public static final int TYPE_REVOCATION_ANN = 17;
    public static final int TYPE_REVOCATION_REP = 12;
    public static final int TYPE_REVOCATION_REQ = 11;
    private ASN1Encodable body;
    private int tagNo;

    public PKIBody(int r100, ASN1Encodable r101) {
        this.tagNo = r100;
        this.body = getBodyForType(r100, r101);
    }

    private PKIBody(ASN1TaggedObject r100) {
        int r101 = r100.getTagNo();
        this.tagNo = r101;
        this.body = getBodyForType(r101, r100.getObject());
    }

    private static ASN1Encodable getBodyForType(int r100, ASN1Encodable r101) {
        switch(r100) {
            case 0: goto L58;
            case 1: goto L56;
            case 2: goto L54;
            case 3: goto L52;
            case 4: goto L50;
            case 5: goto L48;
            case 6: goto L46;
            case 7: goto L44;
            case 8: goto L42;
            case 9: goto L40;
            case 10: goto L38;
            case 11: goto L36;
            case 12: goto L34;
            case 13: goto L32;
            case 14: goto L30;
            case 15: goto L28;
            case 16: goto L26;
            case 17: goto L24;
            case 18: goto L22;
            case 19: goto L20;
            case 20: goto L18;
            case 21: goto L16;
            case 22: goto L14;
            case 23: goto L12;
            case 24: goto L10;
            case 25: goto L8;
            case 26: goto L6;
            default: goto L4;
        };
    L4:
        throw new IllegalArgumentException("unknown tag number: " + r100);
    L6:
        return PollRepContent.getInstance(r101);
    L8:
        return PollReqContent.getInstance(r101);
    L10:
        return CertConfirmContent.getInstance(r101);
    L12:
        return ErrorMsgContent.getInstance(r101);
    L14:
        return GenRepContent.getInstance(r101);
    L16:
        return GenMsgContent.getInstance(r101);
    L18:
        return PKIMessages.getInstance(r101);
    L20:
        return PKIConfirmContent.getInstance(r101);
    L22:
        return CRLAnnContent.getInstance(r101);
    L24:
        return RevAnnContent.getInstance(r101);
    L26:
        return CMPCertificate.getInstance(r101);
    L28:
        return CAKeyUpdAnnContent.getInstance(r101);
    L30:
        return CertRepMessage.getInstance(r101);
    L32:
        return CertReqMessages.getInstance(r101);
    L34:
        return RevRepContent.getInstance(r101);
    L36:
        return RevReqContent.getInstance(r101);
    L38:
        return KeyRecRepContent.getInstance(r101);
    L40:
        return CertReqMessages.getInstance(r101);
    L42:
        return CertRepMessage.getInstance(r101);
    L44:
        return CertReqMessages.getInstance(r101);
    L46:
        return POPODecKeyRespContent.getInstance(r101);
    L48:
        return POPODecKeyChallContent.getInstance(r101);
    L50:
        return CertificationRequest.getInstance(r101);
    L52:
        return CertRepMessage.getInstance(r101);
    L54:
        return CertReqMessages.getInstance(r101);
    L56:
        return CertRepMessage.getInstance(r101);
    L58:
        return CertReqMessages.getInstance(r101);
    }

    public static PKIBody getInstance(Object r100) {
        if (r100 == null) goto L13;
        if ((r100 instanceof PKIBody) == true) goto L13;
        if ((r100 instanceof ASN1TaggedObject) == false) goto L11;
        return new PKIBody((ASN1TaggedObject) r100);
    L11:
        throw new IllegalArgumentException("Invalid object: ".concat(r100.getClass().getName()));
    L13:
        return (PKIBody) r100;
    }

    public ASN1Encodable getContent() {
        return this.body;
    }

    public int getType() {
        return this.tagNo;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(true, this.tagNo, this.body);
    }
}
