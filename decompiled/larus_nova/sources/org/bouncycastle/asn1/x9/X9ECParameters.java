package org.bouncycastle.asn1.x9;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.field.PolynomialExtensionField;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class X9ECParameters extends ASN1Object implements X9ObjectIdentifiers {
    private static final BigInteger ONE = null;
    private ECCurve curve;
    private X9FieldID fieldID;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private X9ECPoint f525094g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BigInteger f525095h;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private BigInteger f525096n;
    private byte[] seed;

    static {
        ONE = BigInteger.valueOf(1);
    }

    private X9ECParameters(ASN1Sequence r100) {
        if ((r100.getObjectAt(0) instanceof ASN1Integer) == false) goto L16;
        if (((ASN1Integer) r100.getObjectAt(0)).hasValue(ONE) == false) goto L16;
        this.f525096n = ((ASN1Integer) r100.getObjectAt(4)).getValue();
        if (r100.size() != 6) goto L9;
        this.f525095h = ((ASN1Integer) r100.getObjectAt(5)).getValue();
    L9:
        X9Curve r101 = new X9Curve(X9FieldID.getInstance(r100.getObjectAt(1)), this.f525096n, this.f525095h, ASN1Sequence.getInstance(r100.getObjectAt(2)));
        this.curve = r101.getCurve();
        ASN1Encodable r102 = r100.getObjectAt(3);
        if ((r102 instanceof X9ECPoint) == false) goto L12;
        this.f525094g = (X9ECPoint) r102;
    L13:
        this.seed = r101.getSeed();
        return;
    L12:
        this.f525094g = new X9ECPoint(this.curve, (ASN1OctetString) r102);
    L16:
        throw new IllegalArgumentException("bad version in X9ECParameters");
    }

    public X9ECParameters(ECCurve r100, X9ECPoint r101, BigInteger r102) {
        this(r100, r101, r102, null, null);
    }

    public X9ECParameters(ECCurve r100, X9ECPoint r101, BigInteger r102, BigInteger r110) {
        this(r100, r101, r102, r110, null);
    }

    public X9ECParameters(ECCurve r100, X9ECPoint r101, BigInteger r102, BigInteger r103, byte[] r104) {
        this.curve = r100;
        this.f525094g = r101;
        this.f525096n = r102;
        this.f525095h = r103;
        this.seed = Arrays.clone(r104);
        if (ECAlgorithms.isFpCurve(r100) == false) goto L7;
        X9FieldID r105 = new X9FieldID(r100.getField().getCharacteristic());
    L5:
        this.fieldID = r105;
        return;
    L7:
        if (ECAlgorithms.isF2mCurve(r100) == false) goto L18;
        int[] r106 = ((PolynomialExtensionField) r100.getField()).getMinimalPolynomial().getExponentsPresent();
        if (r106.length != 3) goto L12;
        r105 = new X9FieldID(r106[2], r106[1]);
        goto L5
    L12:
        if (r106.length != 5) goto L16;
        r105 = new X9FieldID(r106[4], r106[1], r106[2], r106[3]);
        goto L5
    L16:
        throw new IllegalArgumentException("Only trinomial and pentomial curves are supported");
    L18:
        throw new IllegalArgumentException("'curve' is of an unsupported type");
    }

    public static X9ECParameters getInstance(Object r100) {
        if ((r100 instanceof X9ECParameters) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new X9ECParameters(ASN1Sequence.getInstance(r100));
    L5:
        return (X9ECParameters) r100;
    }

    public X9ECPoint getBaseEntry() {
        return this.f525094g;
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public X9Curve getCurveEntry() {
        return new X9Curve(this.curve, this.seed);
    }

    public X9FieldID getFieldIDEntry() {
        return this.fieldID;
    }

    public ECPoint getG() {
        return this.f525094g.getPoint();
    }

    public BigInteger getH() {
        return this.f525095h;
    }

    public BigInteger getN() {
        return this.f525096n;
    }

    public byte[] getSeed() {
        return Arrays.clone(this.seed);
    }

    public boolean hasSeed() {
        if (this.seed == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(6);
        r100.add(new ASN1Integer(ONE));
        r100.add(this.fieldID);
        r100.add(new X9Curve(this.curve, this.seed));
        r100.add(this.f525094g);
        r100.add(new ASN1Integer(this.f525096n));
        BigInteger r101 = this.f525095h;
        if (r101 == null) goto L6;
        r100.add(new ASN1Integer(r101));
    L6:
        return new DERSequence(r100);
    }
}
