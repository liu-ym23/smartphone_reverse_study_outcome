package org.bouncycastle.asn1.pkcs;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class RC2CBCParameter extends ASN1Object {

    /* JADX INFO: renamed from: iv, reason: collision with root package name */
    ASN1OctetString f525060iv;
    ASN1Integer version;

    public RC2CBCParameter(int r100, byte[] r101) {
        this.version = new ASN1Integer(r100);
        this.f525060iv = new DEROctetString(r101);
    }

    private RC2CBCParameter(ASN1Sequence r100) {
        if (r100.size() != 1) goto L5;
        this.version = null;
        ASN1Encodable r101 = r100.getObjectAt(0);
    L6:
        this.f525060iv = (ASN1OctetString) r101;
        return;
    L5:
        this.version = (ASN1Integer) r100.getObjectAt(0);
        r101 = r100.getObjectAt(1);
        goto L6
    }

    public RC2CBCParameter(byte[] r100) {
        this.version = null;
        this.f525060iv = new DEROctetString(r100);
    }

    public static RC2CBCParameter getInstance(Object r100) {
        if ((r100 instanceof RC2CBCParameter) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new RC2CBCParameter(ASN1Sequence.getInstance(r100));
    L5:
        return (RC2CBCParameter) r100;
    }

    public byte[] getIV() {
        return this.f525060iv.getOctets();
    }

    public BigInteger getRC2ParameterVersion() {
        ASN1Integer r100 = this.version;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        ASN1Integer r101 = this.version;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        r100.add(this.f525060iv);
        return new DERSequence(r100);
    }
}
