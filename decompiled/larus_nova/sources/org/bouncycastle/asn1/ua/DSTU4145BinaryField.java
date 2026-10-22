package org.bouncycastle.asn1.ua;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class DSTU4145BinaryField extends ASN1Object {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f525062j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f525063k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f525064l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f525065m;

    public DSTU4145BinaryField(int r100, int r101) {
        this(r100, r101, 0, 0);
    }

    public DSTU4145BinaryField(int r100, int r101, int r102, int r103) {
        this.f525065m = r100;
        this.f525063k = r101;
        this.f525062j = r102;
        this.f525064l = r103;
    }

    private DSTU4145BinaryField(ASN1Sequence r100) {
        this.f525065m = ASN1Integer.getInstance(r100.getObjectAt(0)).intPositiveValueExact();
        if ((r100.getObjectAt(1) instanceof ASN1Integer) == false) goto L6;
        this.f525063k = ((ASN1Integer) r100.getObjectAt(1)).intPositiveValueExact();
        return;
    L6:
        if ((r100.getObjectAt(1) instanceof ASN1Sequence) == false) goto L10;
        ASN1Sequence r101 = ASN1Sequence.getInstance(r100.getObjectAt(1));
        this.f525063k = ASN1Integer.getInstance(r101.getObjectAt(0)).intPositiveValueExact();
        this.f525062j = ASN1Integer.getInstance(r101.getObjectAt(1)).intPositiveValueExact();
        this.f525064l = ASN1Integer.getInstance(r101.getObjectAt(2)).intPositiveValueExact();
        return;
    L10:
        throw new IllegalArgumentException("object parse error");
    }

    public static DSTU4145BinaryField getInstance(Object r100) {
        if ((r100 instanceof DSTU4145BinaryField) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new DSTU4145BinaryField(ASN1Sequence.getInstance(r100));
    L5:
        return (DSTU4145BinaryField) r100;
    }

    public int getK1() {
        return this.f525063k;
    }

    public int getK2() {
        return this.f525062j;
    }

    public int getK3() {
        return this.f525064l;
    }

    public int getM() {
        return this.f525065m;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(new ASN1Integer(this.f525065m));
        if (this.f525062j != 0) goto L5;
        r100.add(new ASN1Integer(this.f525063k));
    L7:
        return new DERSequence(r100);
    L5:
        ASN1EncodableVector r101 = new ASN1EncodableVector(3);
        r101.add(new ASN1Integer(this.f525063k));
        r101.add(new ASN1Integer(this.f525062j));
        r101.add(new ASN1Integer(this.f525064l));
        r100.add(new DERSequence(r101));
        goto L7
    }
}
