package org.bouncycastle.pqc.asn1;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class ParSet extends ASN1Object {
    private static final BigInteger ZERO = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int[] f525508h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int[] f525509k;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f525510t;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int[] f525511w;

    static {
        ZERO = BigInteger.valueOf(0);
    }

    public ParSet(int r100, int[] r101, int[] r102, int[] r103) {
        this.f525510t = r100;
        this.f525508h = r101;
        this.f525511w = r102;
        this.f525509k = r103;
    }

    private ParSet(ASN1Sequence r100) {
        if (r100.size() != 4) goto L18;
        int r101 = 0;
        this.f525510t = checkBigIntegerInIntRangeAndPositive(r100.getObjectAt(0));
        ASN1Sequence r102 = (ASN1Sequence) r100.getObjectAt(1);
        ASN1Sequence r103 = (ASN1Sequence) r100.getObjectAt(2);
        ASN1Sequence r104 = (ASN1Sequence) r100.getObjectAt(3);
        if (r102.size() != this.f525510t) goto L16;
        if (r103.size() != this.f525510t) goto L16;
        if (r104.size() != this.f525510t) goto L16;
        this.f525508h = new int[r102.size()];
        this.f525511w = new int[r103.size()];
        this.f525509k = new int[r104.size()];
    L12:
        if (r101 >= this.f525510t) goto L14;
        this.f525508h[r101] = checkBigIntegerInIntRangeAndPositive(r102.getObjectAt(r101));
        this.f525511w[r101] = checkBigIntegerInIntRangeAndPositive(r103.getObjectAt(r101));
        this.f525509k[r101] = checkBigIntegerInIntRangeAndPositive(r104.getObjectAt(r101));
        r101 = r101 + 1;
        goto L12
    L14:
        return;
    L16:
        throw new IllegalArgumentException("invalid size of sequences");
    L18:
        throw new IllegalArgumentException("sie of seqOfParams = " + r100.size());
    }

    private static int checkBigIntegerInIntRangeAndPositive(ASN1Encodable r100) {
        int r101 = ((ASN1Integer) r100).intValueExact();
        if (r101 <= 0) goto L6;
        return r101;
    L6:
        throw new IllegalArgumentException("BigInteger not in Range: " + r101);
    }

    public static ParSet getInstance(Object r100) {
        if ((r100 instanceof ParSet) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ParSet(ASN1Sequence.getInstance(r100));
    L5:
        return (ParSet) r100;
    }

    public int[] getH() {
        return Arrays.clone(this.f525508h);
    }

    public int[] getK() {
        return Arrays.clone(this.f525509k);
    }

    public int getT() {
        return this.f525510t;
    }

    public int[] getW() {
        return Arrays.clone(this.f525511w);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector();
        ASN1EncodableVector r101 = new ASN1EncodableVector();
        ASN1EncodableVector r102 = new ASN1EncodableVector();
        int r103 = 0;
    L3:
        int[] r104 = this.f525508h;
        if (r103 >= r104.length) goto L6;
        r100.add(new ASN1Integer(r104[r103]));
        r101.add(new ASN1Integer(this.f525511w[r103]));
        r102.add(new ASN1Integer(this.f525509k[r103]));
        r103 = r103 + 1;
        goto L3
    L6:
        ASN1EncodableVector r105 = new ASN1EncodableVector();
        r105.add(new ASN1Integer(this.f525510t));
        r105.add(new DERSequence(r100));
        r105.add(new DERSequence(r101));
        r105.add(new DERSequence(r102));
        return new DERSequence(r105);
    }
}
