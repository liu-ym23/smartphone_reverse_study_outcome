package org.bouncycastle.asn1.x509;

import java.io.IOException;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class SubjectPublicKeyInfo extends ASN1Object {
    private AlgorithmIdentifier algId;
    private DERBitString keyData;

    public SubjectPublicKeyInfo(ASN1Sequence r100) {
        if (r100.size() != 2) goto L7;
        Enumeration r101 = r100.getObjects();
        this.algId = AlgorithmIdentifier.getInstance(r101.nextElement());
        this.keyData = DERBitString.getInstance(r101.nextElement());
        return;
    L7:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public SubjectPublicKeyInfo(AlgorithmIdentifier r100, ASN1Encodable r101) throws IOException {
        this.keyData = new DERBitString(r101);
        this.algId = r100;
    }

    public SubjectPublicKeyInfo(AlgorithmIdentifier r100, byte[] r101) {
        this.keyData = new DERBitString(r101);
        this.algId = r100;
    }

    public static SubjectPublicKeyInfo getInstance(Object r100) {
        if ((r100 instanceof SubjectPublicKeyInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new SubjectPublicKeyInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (SubjectPublicKeyInfo) r100;
    }

    public static SubjectPublicKeyInfo getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public AlgorithmIdentifier getAlgorithm() {
        return this.algId;
    }

    public AlgorithmIdentifier getAlgorithmId() {
        return this.algId;
    }

    public ASN1Primitive getPublicKey() throws IOException {
        return ASN1Primitive.fromByteArray(this.keyData.getOctets());
    }

    public DERBitString getPublicKeyData() {
        return this.keyData;
    }

    public ASN1Primitive parsePublicKey() throws IOException {
        return ASN1Primitive.fromByteArray(this.keyData.getOctets());
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.algId);
        r100.add(this.keyData);
        return new DERSequence(r100);
    }
}
