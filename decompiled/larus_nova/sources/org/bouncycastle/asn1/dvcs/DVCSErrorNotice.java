package org.bouncycastle.asn1.dvcs;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cmp.PKIStatusInfo;
import org.bouncycastle.asn1.x509.GeneralName;

/* JADX INFO: loaded from: classes42.dex */
public class DVCSErrorNotice extends ASN1Object {
    private GeneralName transactionIdentifier;
    private PKIStatusInfo transactionStatus;

    private DVCSErrorNotice(ASN1Sequence r100) {
        this.transactionStatus = PKIStatusInfo.getInstance(r100.getObjectAt(0));
        if (r100.size() <= 1) goto L6;
        this.transactionIdentifier = GeneralName.getInstance(r100.getObjectAt(1));
        return;
    }

    public DVCSErrorNotice(PKIStatusInfo r100) {
        this(r100, null);
    }

    public DVCSErrorNotice(PKIStatusInfo r100, GeneralName r101) {
        this.transactionStatus = r100;
        this.transactionIdentifier = r101;
    }

    public static DVCSErrorNotice getInstance(Object r100) {
        if ((r100 instanceof DVCSErrorNotice) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new DVCSErrorNotice(ASN1Sequence.getInstance(r100));
    L5:
        return (DVCSErrorNotice) r100;
    }

    public static DVCSErrorNotice getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public GeneralName getTransactionIdentifier() {
        return this.transactionIdentifier;
    }

    public PKIStatusInfo getTransactionStatus() {
        return this.transactionStatus;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.transactionStatus);
        GeneralName r101 = this.transactionIdentifier;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("DVCSErrorNotice {\ntransactionStatus: ");
        r100.append(this.transactionStatus);
        r100.append("\n");
        if (this.transactionIdentifier == null) goto L5;
        String r101 = "transactionIdentifier: " + this.transactionIdentifier + "\n";
    L6:
        r100.append(r101);
        r100.append("}\n");
        return r100.toString();
    L5:
        r101 = "";
        goto L6
    }
}
