package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.crmf.PKIPublicationInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class CMCPublicationInfo extends ASN1Object {
    private final ASN1Sequence certHashes;
    private final AlgorithmIdentifier hashAlg;
    private final PKIPublicationInfo pubInfo;

    private CMCPublicationInfo(ASN1Sequence r100) {
        if (r100.size() != 3) goto L7;
        this.hashAlg = AlgorithmIdentifier.getInstance(r100.getObjectAt(0));
        this.certHashes = ASN1Sequence.getInstance(r100.getObjectAt(1));
        this.pubInfo = PKIPublicationInfo.getInstance(r100.getObjectAt(2));
        return;
    L7:
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public CMCPublicationInfo(AlgorithmIdentifier r100, byte[][] r101, PKIPublicationInfo r102) {
        this.hashAlg = r100;
        ASN1EncodableVector r103 = new ASN1EncodableVector(r101.length);
        int r104 = 0;
    L4:
        if (r104 == r101.length) goto L6;
        r103.add(new DEROctetString(Arrays.clone(r101[r104])));
        r104 = r104 + 1;
        goto L4
    L6:
        this.certHashes = new DERSequence(r103);
        this.pubInfo = r102;
    }

    public static CMCPublicationInfo getInstance(Object r100) {
        if ((r100 instanceof CMCPublicationInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CMCPublicationInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (CMCPublicationInfo) r100;
    }

    public byte[][] getCertHashes() {
        int r100 = this.certHashes.size();
        byte[][] r101 = new byte[r100][];
        int r102 = 0;
    L3:
        if (r102 == r100) goto L5;
        r101[r102] = Arrays.clone(ASN1OctetString.getInstance(this.certHashes.getObjectAt(r102)).getOctets());
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    public AlgorithmIdentifier getHashAlg() {
        return this.hashAlg;
    }

    public PKIPublicationInfo getPubInfo() {
        return this.pubInfo;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.hashAlg);
        r100.add(this.certHashes);
        r100.add(this.pubInfo);
        return new DERSequence(r100);
    }
}
