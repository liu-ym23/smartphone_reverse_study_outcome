package org.bouncycastle.asn1.misc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class IDEACBCPar extends ASN1Object {

    /* JADX INFO: renamed from: iv, reason: collision with root package name */
    ASN1OctetString f525049iv;

    private IDEACBCPar(ASN1Sequence r100) {
        if (r100.size() != 1) goto L5;
        ASN1OctetString r101 = (ASN1OctetString) r100.getObjectAt(0);
    L6:
        this.f525049iv = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public IDEACBCPar(byte[] r100) {
        this.f525049iv = new DEROctetString(r100);
    }

    public static IDEACBCPar getInstance(Object r100) {
        if ((r100 instanceof IDEACBCPar) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new IDEACBCPar(ASN1Sequence.getInstance(r100));
    L5:
        return (IDEACBCPar) r100;
    }

    public byte[] getIV() {
        ASN1OctetString r100 = this.f525049iv;
        if (r100 != null) goto L5;
        return null;
    L5:
        return Arrays.clone(r100.getOctets());
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(1);
        ASN1OctetString r101 = this.f525049iv;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
