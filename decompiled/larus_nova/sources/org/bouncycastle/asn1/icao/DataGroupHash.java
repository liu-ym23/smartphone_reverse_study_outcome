package org.bouncycastle.asn1.icao;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class DataGroupHash extends ASN1Object {
    ASN1OctetString dataGroupHashValue;
    ASN1Integer dataGroupNumber;

    public DataGroupHash(int r100, ASN1OctetString r101) {
        this.dataGroupNumber = new ASN1Integer(r100);
        this.dataGroupHashValue = r101;
    }

    private DataGroupHash(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
        this.dataGroupNumber = ASN1Integer.getInstance(r101.nextElement());
        this.dataGroupHashValue = ASN1OctetString.getInstance(r101.nextElement());
    }

    public static DataGroupHash getInstance(Object r100) {
        if ((r100 instanceof DataGroupHash) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new DataGroupHash(ASN1Sequence.getInstance(r100));
    L5:
        return (DataGroupHash) r100;
    }

    public ASN1OctetString getDataGroupHashValue() {
        return this.dataGroupHashValue;
    }

    public int getDataGroupNumber() {
        return this.dataGroupNumber.intValueExact();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.dataGroupNumber);
        r100.add(this.dataGroupHashValue);
        return new DERSequence(r100);
    }
}
