package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class XMSSMTKeyParams extends ASN1Object {
    private final int height;
    private final int layers;
    private final AlgorithmIdentifier treeDigest;
    private final ASN1Integer version;

    public XMSSMTKeyParams(int r100, int r101, AlgorithmIdentifier r102) {
        this.version = new ASN1Integer(0);
        this.height = r100;
        this.layers = r101;
        this.treeDigest = r102;
    }

    private XMSSMTKeyParams(ASN1Sequence r100) {
        this.version = ASN1Integer.getInstance(r100.getObjectAt(0));
        this.height = ASN1Integer.getInstance(r100.getObjectAt(1)).intValueExact();
        this.layers = ASN1Integer.getInstance(r100.getObjectAt(2)).intValueExact();
        this.treeDigest = AlgorithmIdentifier.getInstance(r100.getObjectAt(3));
    }

    public static XMSSMTKeyParams getInstance(Object r100) {
        if ((r100 instanceof XMSSMTKeyParams) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new XMSSMTKeyParams(ASN1Sequence.getInstance(r100));
    L5:
        return (XMSSMTKeyParams) r100;
    }

    public int getHeight() {
        return this.height;
    }

    public int getLayers() {
        return this.layers;
    }

    public AlgorithmIdentifier getTreeDigest() {
        return this.treeDigest;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector();
        r100.add(this.version);
        r100.add(new ASN1Integer(this.height));
        r100.add(new ASN1Integer(this.layers));
        r100.add(this.treeDigest);
        return new DERSequence(r100);
    }
}
