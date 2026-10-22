package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class EncryptedPOP extends ASN1Object {
    private final ContentInfo cms;
    private final TaggedRequest request;
    private final AlgorithmIdentifier thePOPAlgID;
    private final byte[] witness;
    private final AlgorithmIdentifier witnessAlgID;

    private EncryptedPOP(ASN1Sequence r100) {
        if (r100.size() != 5) goto L7;
        this.request = TaggedRequest.getInstance(r100.getObjectAt(0));
        this.cms = ContentInfo.getInstance(r100.getObjectAt(1));
        this.thePOPAlgID = AlgorithmIdentifier.getInstance(r100.getObjectAt(2));
        this.witnessAlgID = AlgorithmIdentifier.getInstance(r100.getObjectAt(3));
        this.witness = Arrays.clone(ASN1OctetString.getInstance(r100.getObjectAt(4)).getOctets());
        return;
    L7:
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public EncryptedPOP(TaggedRequest r100, ContentInfo r101, AlgorithmIdentifier r102, AlgorithmIdentifier r103, byte[] r104) {
        this.request = r100;
        this.cms = r101;
        this.thePOPAlgID = r102;
        this.witnessAlgID = r103;
        this.witness = Arrays.clone(r104);
    }

    public static EncryptedPOP getInstance(Object r100) {
        if ((r100 instanceof EncryptedPOP) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new EncryptedPOP(ASN1Sequence.getInstance(r100));
    L5:
        return (EncryptedPOP) r100;
    }

    public ContentInfo getCms() {
        return this.cms;
    }

    public TaggedRequest getRequest() {
        return this.request;
    }

    public AlgorithmIdentifier getThePOPAlgID() {
        return this.thePOPAlgID;
    }

    public byte[] getWitness() {
        return Arrays.clone(this.witness);
    }

    public AlgorithmIdentifier getWitnessAlgID() {
        return this.witnessAlgID;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(5);
        r100.add(this.request);
        r100.add(this.cms);
        r100.add(this.thePOPAlgID);
        r100.add(this.witnessAlgID);
        r100.add(new DEROctetString(this.witness));
        return new DERSequence(r100);
    }
}
