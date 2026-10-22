package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cmp.CMPObjectIdentifiers;
import org.bouncycastle.asn1.cmp.PBMParameter;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class PKMACValue extends ASN1Object {
    private AlgorithmIdentifier algId;
    private DERBitString value;

    private PKMACValue(ASN1Sequence r100) {
        this.algId = AlgorithmIdentifier.getInstance(r100.getObjectAt(0));
        this.value = DERBitString.getInstance(r100.getObjectAt(1));
    }

    public PKMACValue(PBMParameter r100, DERBitString r101) {
        this(new AlgorithmIdentifier(CMPObjectIdentifiers.passwordBasedMac, r100), r101);
    }

    public PKMACValue(AlgorithmIdentifier r100, DERBitString r101) {
        this.algId = r100;
        this.value = r101;
    }

    public static PKMACValue getInstance(Object r100) {
        if ((r100 instanceof PKMACValue) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PKMACValue(ASN1Sequence.getInstance(r100));
    L5:
        return (PKMACValue) r100;
    }

    public static PKMACValue getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public AlgorithmIdentifier getAlgId() {
        return this.algId;
    }

    public DERBitString getValue() {
        return this.value;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.algId);
        r100.add(this.value);
        return new DERSequence(r100);
    }
}
