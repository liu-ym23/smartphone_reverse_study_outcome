package org.bouncycastle.asn1.x9;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class KeySpecificInfo extends ASN1Object {
    private ASN1ObjectIdentifier algorithm;
    private ASN1OctetString counter;

    public KeySpecificInfo(ASN1ObjectIdentifier r100, ASN1OctetString r101) {
        this.algorithm = r100;
        this.counter = r101;
    }

    private KeySpecificInfo(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
        this.algorithm = (ASN1ObjectIdentifier) r101.nextElement();
        this.counter = (ASN1OctetString) r101.nextElement();
    }

    public static KeySpecificInfo getInstance(Object r100) {
        if ((r100 instanceof KeySpecificInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new KeySpecificInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (KeySpecificInfo) r100;
    }

    public ASN1ObjectIdentifier getAlgorithm() {
        return this.algorithm;
    }

    public ASN1OctetString getCounter() {
        return this.counter;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.algorithm);
        r100.add(this.counter);
        return new DERSequence(r100);
    }
}
