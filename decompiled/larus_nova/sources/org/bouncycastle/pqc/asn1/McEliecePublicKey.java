package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

/* JADX INFO: loaded from: classes42.dex */
public class McEliecePublicKey extends ASN1Object {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final GF2Matrix f525505g;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f525506n;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f525507t;

    public McEliecePublicKey(int r100, int r101, GF2Matrix r102) {
        this.f525506n = r100;
        this.f525507t = r101;
        this.f525505g = new GF2Matrix(r102);
    }

    private McEliecePublicKey(ASN1Sequence r100) {
        this.f525506n = ((ASN1Integer) r100.getObjectAt(0)).intValueExact();
        this.f525507t = ((ASN1Integer) r100.getObjectAt(1)).intValueExact();
        this.f525505g = new GF2Matrix(((ASN1OctetString) r100.getObjectAt(2)).getOctets());
    }

    public static McEliecePublicKey getInstance(Object r100) {
        if ((r100 instanceof McEliecePublicKey) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new McEliecePublicKey(ASN1Sequence.getInstance(r100));
    L5:
        return (McEliecePublicKey) r100;
    }

    public GF2Matrix getG() {
        return new GF2Matrix(this.f525505g);
    }

    public int getN() {
        return this.f525506n;
    }

    public int getT() {
        return this.f525507t;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector();
        r100.add(new ASN1Integer(this.f525506n));
        r100.add(new ASN1Integer(this.f525507t));
        r100.add(new DEROctetString(this.f525505g.getEncoded()));
        return new DERSequence(r100);
    }
}
