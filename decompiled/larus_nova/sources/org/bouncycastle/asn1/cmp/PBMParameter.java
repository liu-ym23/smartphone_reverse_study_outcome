package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class PBMParameter extends ASN1Object {
    private ASN1Integer iterationCount;

    /* JADX INFO: renamed from: mac, reason: collision with root package name */
    private AlgorithmIdentifier f525026mac;
    private AlgorithmIdentifier owf;
    private ASN1OctetString salt;

    public PBMParameter(ASN1OctetString r100, AlgorithmIdentifier r101, ASN1Integer r102, AlgorithmIdentifier r103) {
        this.salt = r100;
        this.owf = r101;
        this.iterationCount = r102;
        this.f525026mac = r103;
    }

    private PBMParameter(ASN1Sequence r100) {
        this.salt = ASN1OctetString.getInstance(r100.getObjectAt(0));
        this.owf = AlgorithmIdentifier.getInstance(r100.getObjectAt(1));
        this.iterationCount = ASN1Integer.getInstance(r100.getObjectAt(2));
        this.f525026mac = AlgorithmIdentifier.getInstance(r100.getObjectAt(3));
    }

    public PBMParameter(byte[] r100, AlgorithmIdentifier r101, int r102, AlgorithmIdentifier r103) {
        this(new DEROctetString(r100), r101, new ASN1Integer(r102), r103);
    }

    public static PBMParameter getInstance(Object r100) {
        if ((r100 instanceof PBMParameter) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PBMParameter(ASN1Sequence.getInstance(r100));
    L5:
        return (PBMParameter) r100;
    }

    public ASN1Integer getIterationCount() {
        return this.iterationCount;
    }

    public AlgorithmIdentifier getMac() {
        return this.f525026mac;
    }

    public AlgorithmIdentifier getOwf() {
        return this.owf;
    }

    public ASN1OctetString getSalt() {
        return this.salt;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(4);
        r100.add(this.salt);
        r100.add(this.owf);
        r100.add(this.iterationCount);
        r100.add(this.f525026mac);
        return new DERSequence(r100);
    }
}
