package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class DigestInfo extends ASN1Object {
    private AlgorithmIdentifier algId;
    private byte[] digest;

    public DigestInfo(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
        this.algId = AlgorithmIdentifier.getInstance(r101.nextElement());
        this.digest = ASN1OctetString.getInstance(r101.nextElement()).getOctets();
    }

    public DigestInfo(AlgorithmIdentifier r100, byte[] r101) {
        this.digest = Arrays.clone(r101);
        this.algId = r100;
    }

    public static DigestInfo getInstance(Object r100) {
        if ((r100 instanceof DigestInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new DigestInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (DigestInfo) r100;
    }

    public static DigestInfo getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public AlgorithmIdentifier getAlgorithmId() {
        return this.algId;
    }

    public byte[] getDigest() {
        return Arrays.clone(this.digest);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.algId);
        r100.add(new DEROctetString(this.digest));
        return new DERSequence(r100);
    }
}
