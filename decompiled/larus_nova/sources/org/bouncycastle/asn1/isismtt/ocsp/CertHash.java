package org.bouncycastle.asn1.isismtt.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class CertHash extends ASN1Object {
    private byte[] certificateHash;
    private AlgorithmIdentifier hashAlgorithm;

    private CertHash(ASN1Sequence r100) {
        if (r100.size() != 2) goto L7;
        this.hashAlgorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(0));
        this.certificateHash = ASN1OctetString.getInstance(r100.getObjectAt(1)).getOctets();
        return;
    L7:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public CertHash(AlgorithmIdentifier r100, byte[] r101) {
        this.hashAlgorithm = r100;
        byte[] r102 = new byte[r101.length];
        this.certificateHash = r102;
        System.arraycopy(r101, 0, r102, 0, r101.length);
    }

    public static CertHash getInstance(Object r100) {
        if (r100 == null) goto L13;
        if ((r100 instanceof CertHash) == true) goto L13;
        if ((r100 instanceof ASN1Sequence) == false) goto L11;
        return new CertHash((ASN1Sequence) r100);
    L11:
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L13:
        return (CertHash) r100;
    }

    public byte[] getCertificateHash() {
        return Arrays.clone(this.certificateHash);
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.hashAlgorithm);
        r100.add(new DEROctetString(this.certificateHash));
        return new DERSequence(r100);
    }
}
