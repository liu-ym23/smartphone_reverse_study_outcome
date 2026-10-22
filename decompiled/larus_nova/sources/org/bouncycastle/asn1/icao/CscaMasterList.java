package org.bouncycastle.asn1.icao;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.x509.Certificate;

/* JADX INFO: loaded from: classes42.dex */
public class CscaMasterList extends ASN1Object {
    private Certificate[] certList;
    private ASN1Integer version;

    private CscaMasterList(ASN1Sequence r100) {
        this.version = new ASN1Integer(0);
        if (r100 == null) goto L16;
        if (r100.size() == 0) goto L16;
        if (r100.size() != 2) goto L14;
        int r101 = 0;
        this.version = ASN1Integer.getInstance(r100.getObjectAt(0));
        ASN1Set r102 = ASN1Set.getInstance(r100.getObjectAt(1));
        this.certList = new Certificate[r102.size()];
    L9:
        Certificate[] r103 = this.certList;
        if (r101 >= r103.length) goto L12;
        r103[r101] = Certificate.getInstance(r102.getObjectAt(r101));
        r101 = r101 + 1;
        goto L9
    L12:
        return;
    L14:
        throw new IllegalArgumentException("Incorrect sequence size: " + r100.size());
    L16:
        throw new IllegalArgumentException("null or empty sequence passed.");
    }

    public CscaMasterList(Certificate[] r100) {
        this.version = new ASN1Integer(0);
        this.certList = copyCertList(r100);
    }

    private Certificate[] copyCertList(Certificate[] r100) {
        int r101 = r100.length;
        Certificate[] r102 = new Certificate[r101];
        int r103 = 0;
    L3:
        if (r103 == r101) goto L5;
        r102[r103] = r100[r103];
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public static CscaMasterList getInstance(Object r100) {
        if ((r100 instanceof CscaMasterList) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CscaMasterList(ASN1Sequence.getInstance(r100));
    L5:
        return (CscaMasterList) r100;
    }

    public Certificate[] getCertStructs() {
        return copyCertList(this.certList);
    }

    public int getVersion() {
        return this.version.intValueExact();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.version);
        r100.add(new DERSet(this.certList));
        return new DERSequence(r100);
    }
}
