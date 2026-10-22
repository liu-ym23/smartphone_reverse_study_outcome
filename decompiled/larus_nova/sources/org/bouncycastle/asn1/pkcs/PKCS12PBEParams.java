package org.bouncycastle.asn1.pkcs;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class PKCS12PBEParams extends ASN1Object {
    ASN1Integer iterations;

    /* JADX INFO: renamed from: iv, reason: collision with root package name */
    ASN1OctetString f525055iv;

    private PKCS12PBEParams(ASN1Sequence r100) {
        this.f525055iv = (ASN1OctetString) r100.getObjectAt(0);
        this.iterations = ASN1Integer.getInstance(r100.getObjectAt(1));
    }

    public PKCS12PBEParams(byte[] r100, int r101) {
        this.f525055iv = new DEROctetString(r100);
        this.iterations = new ASN1Integer(r101);
    }

    public static PKCS12PBEParams getInstance(Object r100) {
        if ((r100 instanceof PKCS12PBEParams) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PKCS12PBEParams(ASN1Sequence.getInstance(r100));
    L5:
        return (PKCS12PBEParams) r100;
    }

    public byte[] getIV() {
        return this.f525055iv.getOctets();
    }

    public BigInteger getIterations() {
        return this.iterations.getValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.f525055iv);
        r100.add(this.iterations);
        return new DERSequence(r100);
    }
}
