package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class POPOSigningKey extends ASN1Object {
    private AlgorithmIdentifier algorithmIdentifier;
    private POPOSigningKeyInput poposkInput;
    private DERBitString signature;

    private POPOSigningKey(ASN1Sequence r100) {
        int r101 = 0;
        if ((r100.getObjectAt(0) instanceof ASN1TaggedObject) == false) goto L9;
        ASN1TaggedObject r102 = (ASN1TaggedObject) r100.getObjectAt(0);
        if (r102.getTagNo() != 0) goto L8;
        this.poposkInput = POPOSigningKeyInput.getInstance(r102.getObject());
        r101 = 1;
        goto L9
    L8:
        throw new IllegalArgumentException("Unknown POPOSigningKeyInput tag: " + r102.getTagNo());
    L9:
        this.algorithmIdentifier = AlgorithmIdentifier.getInstance(r100.getObjectAt(r101));
        this.signature = DERBitString.getInstance(r100.getObjectAt(r101 + 1));
    }

    public POPOSigningKey(POPOSigningKeyInput r100, AlgorithmIdentifier r101, DERBitString r102) {
        this.poposkInput = r100;
        this.algorithmIdentifier = r101;
        this.signature = r102;
    }

    public static POPOSigningKey getInstance(Object r100) {
        if ((r100 instanceof POPOSigningKey) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new POPOSigningKey(ASN1Sequence.getInstance(r100));
    L5:
        return (POPOSigningKey) r100;
    }

    public static POPOSigningKey getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public AlgorithmIdentifier getAlgorithmIdentifier() {
        return this.algorithmIdentifier;
    }

    public POPOSigningKeyInput getPoposkInput() {
        return this.poposkInput;
    }

    public DERBitString getSignature() {
        return this.signature;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        POPOSigningKeyInput r101 = this.poposkInput;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(false, 0, r101));
    L5:
        r100.add(this.algorithmIdentifier);
        r100.add(this.signature);
        return new DERSequence(r100);
    }
}
