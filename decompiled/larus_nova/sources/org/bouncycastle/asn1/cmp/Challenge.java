package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class Challenge extends ASN1Object {
    private ASN1OctetString challenge;
    private AlgorithmIdentifier owf;
    private ASN1OctetString witness;

    private Challenge(ASN1Sequence r100) {
        int r101 = 0;
        if (r100.size() != 3) goto L5;
        this.owf = AlgorithmIdentifier.getInstance(r100.getObjectAt(0));
        r101 = 1;
    L5:
        this.witness = ASN1OctetString.getInstance(r100.getObjectAt(r101));
        this.challenge = ASN1OctetString.getInstance(r100.getObjectAt(r101 + 1));
    }

    public Challenge(AlgorithmIdentifier r100, byte[] r101, byte[] r102) {
        this.owf = r100;
        this.witness = new DEROctetString(r101);
        this.challenge = new DEROctetString(r102);
    }

    public Challenge(byte[] r100, byte[] r101) {
        this(null, r100, r101);
    }

    private void addOptional(ASN1EncodableVector r100, ASN1Encodable r101) {
        if (r101 == null) goto L5;
        r100.add(r101);
        return;
    }

    public static Challenge getInstance(Object r100) {
        if ((r100 instanceof Challenge) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new Challenge(ASN1Sequence.getInstance(r100));
    L5:
        return (Challenge) r100;
    }

    public byte[] getChallenge() {
        return this.challenge.getOctets();
    }

    public AlgorithmIdentifier getOwf() {
        return this.owf;
    }

    public byte[] getWitness() {
        return this.witness.getOctets();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        addOptional(r100, this.owf);
        r100.add(this.witness);
        r100.add(this.challenge);
        return new DERSequence(r100);
    }
}
