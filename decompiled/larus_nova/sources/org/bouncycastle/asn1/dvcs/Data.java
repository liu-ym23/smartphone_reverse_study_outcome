package org.bouncycastle.asn1.dvcs;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.DigestInfo;

/* JADX INFO: loaded from: classes42.dex */
public class Data extends ASN1Object implements ASN1Choice {
    private ASN1Sequence certs;
    private ASN1OctetString message;
    private DigestInfo messageImprint;

    public Data(ASN1OctetString r100) {
        this.message = r100;
    }

    private Data(ASN1Sequence r100) {
        this.certs = r100;
    }

    public Data(TargetEtcChain r100) {
        this.certs = new DERSequence(r100);
    }

    public Data(DigestInfo r100) {
        this.messageImprint = r100;
    }

    public Data(byte[] r100) {
        this.message = new DEROctetString(r100);
    }

    public Data(TargetEtcChain[] r100) {
        this.certs = new DERSequence(r100);
    }

    public static Data getInstance(Object r100) {
        if ((r100 instanceof Data) == false) goto L7;
        return (Data) r100;
    L7:
        if ((r100 instanceof ASN1OctetString) == false) goto L11;
        return new Data((ASN1OctetString) r100);
    L11:
        if ((r100 instanceof ASN1Sequence) == false) goto L15;
        return new Data(DigestInfo.getInstance(r100));
    L15:
        if ((r100 instanceof ASN1TaggedObject) == false) goto L19;
        return new Data(ASN1Sequence.getInstance((ASN1TaggedObject) r100, false));
    L19:
        throw new IllegalArgumentException("Unknown object submitted to getInstance: ".concat(r100.getClass().getName()));
    }

    public static Data getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(r100.getObject());
    }

    public TargetEtcChain[] getCerts() {
        ASN1Sequence r100 = this.certs;
        if (r100 != null) goto L6;
        return null;
    L6:
        int r101 = r100.size();
        TargetEtcChain[] r102 = new TargetEtcChain[r101];
        int r103 = 0;
    L7:
        if (r103 == r101) goto L9;
        r102[r103] = TargetEtcChain.getInstance(this.certs.getObjectAt(r103));
        r103 = r103 + 1;
        goto L7
    L9:
        return r102;
    }

    public ASN1OctetString getMessage() {
        return this.message;
    }

    public DigestInfo getMessageImprint() {
        return this.messageImprint;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1OctetString r100 = this.message;
        if (r100 != null) goto L5;
        DigestInfo r101 = this.messageImprint;
        if (r101 == null) goto L11;
        return r101.toASN1Primitive();
    L11:
        return new DERTaggedObject(false, 0, this.certs);
    L5:
        return r100.toASN1Primitive();
    }

    public String toString() {
        if (this.message == null) goto L8;
        StringBuilder r100 = new StringBuilder("Data {\n");
        Object r101 = this.message;
    L5:
        r100.append(r101);
        r100.append("}\n");
        return r100.toString();
    L8:
        if (this.messageImprint == null) goto L10;
        r100 = new StringBuilder("Data {\n");
        r101 = this.messageImprint;
        goto L5
    L10:
        r100 = new StringBuilder("Data {\n");
        r101 = this.certs;
        goto L5
    }
}
