package org.bouncycastle.asn1.cms.ecc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class ECCCMSSharedInfo extends ASN1Object {
    private final byte[] entityUInfo;
    private final AlgorithmIdentifier keyInfo;
    private final byte[] suppPubInfo;

    private ECCCMSSharedInfo(ASN1Sequence r100) {
        this.keyInfo = AlgorithmIdentifier.getInstance(r100.getObjectAt(0));
        if (r100.size() != 2) goto L5;
        this.entityUInfo = null;
        this.suppPubInfo = ASN1OctetString.getInstance((ASN1TaggedObject) r100.getObjectAt(1), true).getOctets();
        return;
    L5:
        this.entityUInfo = ASN1OctetString.getInstance((ASN1TaggedObject) r100.getObjectAt(1), true).getOctets();
        this.suppPubInfo = ASN1OctetString.getInstance((ASN1TaggedObject) r100.getObjectAt(2), true).getOctets();
    }

    public ECCCMSSharedInfo(AlgorithmIdentifier r100, byte[] r101) {
        this.keyInfo = r100;
        this.entityUInfo = null;
        this.suppPubInfo = Arrays.clone(r101);
    }

    public ECCCMSSharedInfo(AlgorithmIdentifier r100, byte[] r101, byte[] r102) {
        this.keyInfo = r100;
        this.entityUInfo = Arrays.clone(r101);
        this.suppPubInfo = Arrays.clone(r102);
    }

    public static ECCCMSSharedInfo getInstance(Object r100) {
        if ((r100 instanceof ECCCMSSharedInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ECCCMSSharedInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (ECCCMSSharedInfo) r100;
    }

    public static ECCCMSSharedInfo getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.keyInfo);
        byte[] r101 = this.entityUInfo;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(true, 0, new DEROctetString(r101)));
    L5:
        r100.add(new DERTaggedObject(true, 2, new DEROctetString(this.suppPubInfo)));
        return new DERSequence(r100);
    }
}
