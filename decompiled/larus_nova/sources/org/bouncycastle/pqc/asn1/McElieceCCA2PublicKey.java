package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

/* JADX INFO: loaded from: classes42.dex */
public class McElieceCCA2PublicKey extends ASN1Object {
    private final AlgorithmIdentifier digest;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final GF2Matrix f525500g;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f525501n;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f525502t;

    public McElieceCCA2PublicKey(int r100, int r101, GF2Matrix r102, AlgorithmIdentifier r103) {
        this.f525501n = r100;
        this.f525502t = r101;
        this.f525500g = new GF2Matrix(r102.getEncoded());
        this.digest = r103;
    }

    private McElieceCCA2PublicKey(ASN1Sequence r100) {
        this.f525501n = ((ASN1Integer) r100.getObjectAt(0)).intValueExact();
        this.f525502t = ((ASN1Integer) r100.getObjectAt(1)).intValueExact();
        this.f525500g = new GF2Matrix(((ASN1OctetString) r100.getObjectAt(2)).getOctets());
        this.digest = AlgorithmIdentifier.getInstance(r100.getObjectAt(3));
    }

    public static McElieceCCA2PublicKey getInstance(Object r100) {
        if ((r100 instanceof McElieceCCA2PublicKey) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new McElieceCCA2PublicKey(ASN1Sequence.getInstance(r100));
    L5:
        return (McElieceCCA2PublicKey) r100;
    }

    public AlgorithmIdentifier getDigest() {
        return this.digest;
    }

    public GF2Matrix getG() {
        return this.f525500g;
    }

    public int getN() {
        return this.f525501n;
    }

    public int getT() {
        return this.f525502t;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector();
        r100.add(new ASN1Integer(this.f525501n));
        r100.add(new ASN1Integer(this.f525502t));
        r100.add(new DEROctetString(this.f525500g.getEncoded()));
        r100.add(this.digest);
        return new DERSequence(r100);
    }
}
