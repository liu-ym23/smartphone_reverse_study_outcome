package org.bouncycastle.asn1.cmc;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class PublishTrustAnchors extends ASN1Object {
    private final ASN1Sequence anchorHashes;
    private final AlgorithmIdentifier hashAlgorithm;
    private final ASN1Integer seqNumber;

    public PublishTrustAnchors(BigInteger r100, AlgorithmIdentifier r101, byte[][] r102) {
        this.seqNumber = new ASN1Integer(r100);
        this.hashAlgorithm = r101;
        ASN1EncodableVector r103 = new ASN1EncodableVector(r102.length);
        int r104 = 0;
    L4:
        if (r104 == r102.length) goto L6;
        r103.add(new DEROctetString(Arrays.clone(r102[r104])));
        r104 = r104 + 1;
        goto L4
    L6:
        this.anchorHashes = new DERSequence(r103);
    }

    private PublishTrustAnchors(ASN1Sequence r100) {
        if (r100.size() != 3) goto L7;
        this.seqNumber = ASN1Integer.getInstance(r100.getObjectAt(0));
        this.hashAlgorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(1));
        this.anchorHashes = ASN1Sequence.getInstance(r100.getObjectAt(2));
        return;
    L7:
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public static PublishTrustAnchors getInstance(Object r100) {
        if ((r100 instanceof PublishTrustAnchors) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PublishTrustAnchors(ASN1Sequence.getInstance(r100));
    L5:
        return (PublishTrustAnchors) r100;
    }

    public byte[][] getAnchorHashes() {
        int r100 = this.anchorHashes.size();
        byte[][] r101 = new byte[r100][];
        int r102 = 0;
    L3:
        if (r102 == r100) goto L5;
        r101[r102] = Arrays.clone(ASN1OctetString.getInstance(this.anchorHashes.getObjectAt(r102)).getOctets());
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public BigInteger getSeqNumber() {
        return this.seqNumber.getValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.seqNumber);
        r100.add(this.hashAlgorithm);
        r100.add(this.anchorHashes);
        return new DERSequence(r100);
    }
}
