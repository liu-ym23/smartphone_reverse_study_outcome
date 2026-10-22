package org.bouncycastle.asn1.cmp;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.GeneralName;

/* JADX INFO: loaded from: classes42.dex */
public class PKIHeader extends ASN1Object {
    public static final int CMP_1999 = 1;
    public static final int CMP_2000 = 2;
    public static final GeneralName NULL_NAME = null;
    private PKIFreeText freeText;
    private ASN1Sequence generalInfo;
    private ASN1GeneralizedTime messageTime;
    private AlgorithmIdentifier protectionAlg;
    private ASN1Integer pvno;
    private ASN1OctetString recipKID;
    private ASN1OctetString recipNonce;
    private GeneralName recipient;
    private GeneralName sender;
    private ASN1OctetString senderKID;
    private ASN1OctetString senderNonce;
    private ASN1OctetString transactionID;

    static {
        NULL_NAME = new GeneralName(X500Name.getInstance(new DERSequence()));
    }

    public PKIHeader(int r100, GeneralName r101, GeneralName r102) {
        this(new ASN1Integer(r100), r101, r102);
    }

    private PKIHeader(ASN1Integer r100, GeneralName r101, GeneralName r102) {
        this.pvno = r100;
        this.sender = r101;
        this.recipient = r102;
    }

    private PKIHeader(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
        this.pvno = ASN1Integer.getInstance(r101.nextElement());
        this.sender = GeneralName.getInstance(r101.nextElement());
        this.recipient = GeneralName.getInstance(r101.nextElement());
    L4:
        if (r101.hasMoreElements() == false) goto L18;
        ASN1TaggedObject r102 = (ASN1TaggedObject) r101.nextElement();
        switch(r102.getTagNo()) {
            case 0: goto L17;
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            default: goto L8;
        };
    L8:
        throw new IllegalArgumentException("unknown tag number: " + r102.getTagNo());
    L10:
        this.freeText = PKIFreeText.getInstance(r102, true);
        goto L4
    L11:
        this.recipNonce = ASN1OctetString.getInstance(r102, true);
        goto L4
    L12:
        this.senderNonce = ASN1OctetString.getInstance(r102, true);
        goto L4
    L13:
        this.transactionID = ASN1OctetString.getInstance(r102, true);
        goto L4
    L14:
        this.recipKID = ASN1OctetString.getInstance(r102, true);
        goto L4
    L15:
        this.senderKID = ASN1OctetString.getInstance(r102, true);
        goto L4
    L16:
        this.protectionAlg = AlgorithmIdentifier.getInstance(r102, true);
        goto L4
    L17:
        this.messageTime = ASN1GeneralizedTime.getInstance(r102, true);
        goto L4
    L9:
        this.generalInfo = ASN1Sequence.getInstance(r102, true);
        goto L4
    }

    private void addOptional(ASN1EncodableVector r100, int r101, ASN1Encodable r102) {
        if (r102 == null) goto L5;
        r100.add(new DERTaggedObject(true, r101, r102));
        return;
    }

    public static PKIHeader getInstance(Object r100) {
        if ((r100 instanceof PKIHeader) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PKIHeader(ASN1Sequence.getInstance(r100));
    L5:
        return (PKIHeader) r100;
    }

    public PKIFreeText getFreeText() {
        return this.freeText;
    }

    public InfoTypeAndValue[] getGeneralInfo() {
        ASN1Sequence r100 = this.generalInfo;
        if (r100 != null) goto L6;
        return null;
    L6:
        int r101 = r100.size();
        InfoTypeAndValue[] r102 = new InfoTypeAndValue[r101];
        int r103 = 0;
    L7:
        if (r103 >= r101) goto L9;
        r102[r103] = InfoTypeAndValue.getInstance(this.generalInfo.getObjectAt(r103));
        r103 = r103 + 1;
        goto L7
    L9:
        return r102;
    }

    public ASN1GeneralizedTime getMessageTime() {
        return this.messageTime;
    }

    public AlgorithmIdentifier getProtectionAlg() {
        return this.protectionAlg;
    }

    public ASN1Integer getPvno() {
        return this.pvno;
    }

    public ASN1OctetString getRecipKID() {
        return this.recipKID;
    }

    public ASN1OctetString getRecipNonce() {
        return this.recipNonce;
    }

    public GeneralName getRecipient() {
        return this.recipient;
    }

    public GeneralName getSender() {
        return this.sender;
    }

    public ASN1OctetString getSenderKID() {
        return this.senderKID;
    }

    public ASN1OctetString getSenderNonce() {
        return this.senderNonce;
    }

    public ASN1OctetString getTransactionID() {
        return this.transactionID;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(12);
        r100.add(this.pvno);
        r100.add(this.sender);
        r100.add(this.recipient);
        addOptional(r100, 0, this.messageTime);
        addOptional(r100, 1, this.protectionAlg);
        addOptional(r100, 2, this.senderKID);
        addOptional(r100, 3, this.recipKID);
        addOptional(r100, 4, this.transactionID);
        addOptional(r100, 5, this.senderNonce);
        addOptional(r100, 6, this.recipNonce);
        addOptional(r100, 7, this.freeText);
        addOptional(r100, 8, this.generalInfo);
        return new DERSequence(r100);
    }
}
