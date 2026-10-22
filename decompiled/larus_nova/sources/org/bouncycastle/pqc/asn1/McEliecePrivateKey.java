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
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

/* JADX INFO: loaded from: classes42.dex */
public class McEliecePrivateKey extends ASN1Object {
    private byte[] encField;
    private byte[] encGp;
    private byte[] encP1;
    private byte[] encP2;
    private byte[] encSInv;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f525503k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f525504n;

    public McEliecePrivateKey(int r100, int r101, GF2mField r102, PolynomialGF2mSmallM r103, Permutation r104, Permutation r105, GF2Matrix r106) {
        this.f525504n = r100;
        this.f525503k = r101;
        this.encField = r102.getEncoded();
        this.encGp = r103.getEncoded();
        this.encSInv = r106.getEncoded();
        this.encP1 = r104.getEncoded();
        this.encP2 = r105.getEncoded();
    }

    private McEliecePrivateKey(ASN1Sequence r100) {
        this.f525504n = ((ASN1Integer) r100.getObjectAt(0)).intValueExact();
        this.f525503k = ((ASN1Integer) r100.getObjectAt(1)).intValueExact();
        this.encField = ((ASN1OctetString) r100.getObjectAt(2)).getOctets();
        this.encGp = ((ASN1OctetString) r100.getObjectAt(3)).getOctets();
        this.encP1 = ((ASN1OctetString) r100.getObjectAt(4)).getOctets();
        this.encP2 = ((ASN1OctetString) r100.getObjectAt(5)).getOctets();
        this.encSInv = ((ASN1OctetString) r100.getObjectAt(6)).getOctets();
    }

    public static McEliecePrivateKey getInstance(Object r100) {
        if ((r100 instanceof McEliecePrivateKey) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new McEliecePrivateKey(ASN1Sequence.getInstance(r100));
    L5:
        return (McEliecePrivateKey) r100;
    }

    public GF2mField getField() {
        return new GF2mField(this.encField);
    }

    public PolynomialGF2mSmallM getGoppaPoly() {
        return new PolynomialGF2mSmallM(getField(), this.encGp);
    }

    public int getK() {
        return this.f525503k;
    }

    public int getN() {
        return this.f525504n;
    }

    public Permutation getP1() {
        return new Permutation(this.encP1);
    }

    public Permutation getP2() {
        return new Permutation(this.encP2);
    }

    public GF2Matrix getSInv() {
        return new GF2Matrix(this.encSInv);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector();
        r100.add(new ASN1Integer(this.f525504n));
        r100.add(new ASN1Integer(this.f525503k));
        r100.add(new DEROctetString(this.encField));
        r100.add(new DEROctetString(this.encGp));
        r100.add(new DEROctetString(this.encP1));
        r100.add(new DEROctetString(this.encP2));
        r100.add(new DEROctetString(this.encSInv));
        return new DERSequence(r100);
    }
}
