package org.bouncycastle.asn1.dvcs;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.GeneralName;

/* JADX INFO: loaded from: classes42.dex */
public class DVCSRequest extends ASN1Object {
    private Data data;
    private DVCSRequestInformation requestInformation;
    private GeneralName transactionIdentifier;

    private DVCSRequest(ASN1Sequence r100) {
        this.requestInformation = DVCSRequestInformation.getInstance(r100.getObjectAt(0));
        this.data = Data.getInstance(r100.getObjectAt(1));
        if (r100.size() <= 2) goto L6;
        this.transactionIdentifier = GeneralName.getInstance(r100.getObjectAt(2));
        return;
    }

    public DVCSRequest(DVCSRequestInformation r100, Data r101) {
        this(r100, r101, null);
    }

    public DVCSRequest(DVCSRequestInformation r100, Data r101, GeneralName r102) {
        this.requestInformation = r100;
        this.data = r101;
        this.transactionIdentifier = r102;
    }

    public static DVCSRequest getInstance(Object r100) {
        if ((r100 instanceof DVCSRequest) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new DVCSRequest(ASN1Sequence.getInstance(r100));
    L5:
        return (DVCSRequest) r100;
    }

    public static DVCSRequest getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public Data getData() {
        return this.data;
    }

    public DVCSRequestInformation getRequestInformation() {
        return this.requestInformation;
    }

    public GeneralName getTransactionIdentifier() {
        return this.transactionIdentifier;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.requestInformation);
        r100.add(this.data);
        GeneralName r101 = this.transactionIdentifier;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("DVCSRequest {\nrequestInformation: ");
        r100.append(this.requestInformation);
        r100.append("\ndata: ");
        r100.append(this.data);
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
