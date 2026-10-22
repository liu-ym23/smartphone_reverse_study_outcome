package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class EncryptedValue extends ASN1Object {
    private DERBitString encSymmKey;
    private DERBitString encValue;
    private AlgorithmIdentifier intendedAlg;
    private AlgorithmIdentifier keyAlg;
    private AlgorithmIdentifier symmAlg;
    private ASN1OctetString valueHint;

    private EncryptedValue(ASN1Sequence r100) {
        int r101 = 0;
    L4:
        if ((r100.getObjectAt(r101) instanceof ASN1TaggedObject) == false) goto L23;
        ASN1TaggedObject r102 = (ASN1TaggedObject) r100.getObjectAt(r101);
        int r103 = r102.getTagNo();
        if (r103 != 0) goto L8;
        this.intendedAlg = AlgorithmIdentifier.getInstance(r102, false);
    L22:
        r101 = r101 + 1;
        goto L4
    L8:
        if (r103 != 1) goto L10;
        this.symmAlg = AlgorithmIdentifier.getInstance(r102, false);
        goto L22
    L10:
        if (r103 != 2) goto L12;
        this.encSymmKey = DERBitString.getInstance(r102, false);
        goto L22
    L12:
        if (r103 != 3) goto L14;
        this.keyAlg = AlgorithmIdentifier.getInstance(r102, false);
        goto L22
    L14:
        if (r103 != 4) goto L17;
        this.valueHint = ASN1OctetString.getInstance(r102, false);
        goto L22
    L17:
        throw new IllegalArgumentException("Unknown tag encountered: " + r102.getTagNo());
    L23:
        this.encValue = DERBitString.getInstance(r100.getObjectAt(r101));
    }

    public EncryptedValue(AlgorithmIdentifier r100, AlgorithmIdentifier r101, DERBitString r102, AlgorithmIdentifier r103, ASN1OctetString r104, DERBitString r105) {
        if (r105 == null) goto L7;
        this.intendedAlg = r100;
        this.symmAlg = r101;
        this.encSymmKey = r102;
        this.keyAlg = r103;
        this.valueHint = r104;
        this.encValue = r105;
        return;
    L7:
        throw new IllegalArgumentException("'encValue' cannot be null");
    }

    private void addOptional(ASN1EncodableVector r100, int r101, ASN1Encodable r102) {
        if (r102 == null) goto L5;
        r100.add(new DERTaggedObject(false, r101, r102));
        return;
    }

    public static EncryptedValue getInstance(Object r100) {
        if ((r100 instanceof EncryptedValue) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new EncryptedValue(ASN1Sequence.getInstance(r100));
    L5:
        return (EncryptedValue) r100;
    }

    public DERBitString getEncSymmKey() {
        return this.encSymmKey;
    }

    public DERBitString getEncValue() {
        return this.encValue;
    }

    public AlgorithmIdentifier getIntendedAlg() {
        return this.intendedAlg;
    }

    public AlgorithmIdentifier getKeyAlg() {
        return this.keyAlg;
    }

    public AlgorithmIdentifier getSymmAlg() {
        return this.symmAlg;
    }

    public ASN1OctetString getValueHint() {
        return this.valueHint;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(6);
        addOptional(r100, 0, this.intendedAlg);
        addOptional(r100, 1, this.symmAlg);
        addOptional(r100, 2, this.encSymmKey);
        addOptional(r100, 3, this.keyAlg);
        addOptional(r100, 4, this.valueHint);
        r100.add(this.encValue);
        return new DERSequence(r100);
    }
}
