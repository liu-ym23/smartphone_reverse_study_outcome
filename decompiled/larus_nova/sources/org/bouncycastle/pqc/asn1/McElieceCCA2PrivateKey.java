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
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

/* JADX INFO: loaded from: classes42.dex */
public class McElieceCCA2PrivateKey extends ASN1Object {
    private AlgorithmIdentifier digest;
    private byte[] encField;
    private byte[] encGp;
    private byte[] encP;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f525498k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f525499n;

    public McElieceCCA2PrivateKey(int r100, int r101, GF2mField r102, PolynomialGF2mSmallM r103, Permutation r104, AlgorithmIdentifier r105) {
        this.f525499n = r100;
        this.f525498k = r101;
        this.encField = r102.getEncoded();
        this.encGp = r103.getEncoded();
        this.encP = r104.getEncoded();
        this.digest = r105;
    }

    private McElieceCCA2PrivateKey(ASN1Sequence r100) {
        this.f525499n = ((ASN1Integer) r100.getObjectAt(0)).intValueExact();
        this.f525498k = ((ASN1Integer) r100.getObjectAt(1)).intValueExact();
        this.encField = ((ASN1OctetString) r100.getObjectAt(2)).getOctets();
        this.encGp = ((ASN1OctetString) r100.getObjectAt(3)).getOctets();
        this.encP = ((ASN1OctetString) r100.getObjectAt(4)).getOctets();
        this.digest = AlgorithmIdentifier.getInstance(r100.getObjectAt(5));
    }

    public static McElieceCCA2PrivateKey getInstance(Object r100) {
        if ((r100 instanceof McElieceCCA2PrivateKey) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new McElieceCCA2PrivateKey(ASN1Sequence.getInstance(r100));
    L5:
        return (McElieceCCA2PrivateKey) r100;
    }

    public AlgorithmIdentifier getDigest() {
        return this.digest;
    }

    public GF2mField getField() {
        return new GF2mField(this.encField);
    }

    public PolynomialGF2mSmallM getGoppaPoly() {
        return new PolynomialGF2mSmallM(getField(), this.encGp);
    }

    public int getK() {
        return this.f525498k;
    }

    public int getN() {
        return this.f525499n;
    }

    public Permutation getP() {
        return new Permutation(this.encP);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector();
        r100.add(new ASN1Integer(this.f525499n));
        r100.add(new ASN1Integer(this.f525498k));
        r100.add(new DEROctetString(this.encField));
        r100.add(new DEROctetString(this.encGp));
        r100.add(new DEROctetString(this.encP));
        r100.add(this.digest);
        return new DERSequence(r100);
    }
}
