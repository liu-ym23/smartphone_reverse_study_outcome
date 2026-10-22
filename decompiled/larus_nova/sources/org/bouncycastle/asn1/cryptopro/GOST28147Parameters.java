package org.bouncycastle.asn1.cryptopro;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class GOST28147Parameters extends ASN1Object {

    /* JADX INFO: renamed from: iv, reason: collision with root package name */
    private ASN1OctetString f525040iv;
    private ASN1ObjectIdentifier paramSet;

    private GOST28147Parameters(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
        this.f525040iv = (ASN1OctetString) r101.nextElement();
        this.paramSet = (ASN1ObjectIdentifier) r101.nextElement();
    }

    public GOST28147Parameters(byte[] r100, ASN1ObjectIdentifier r101) {
        this.f525040iv = new DEROctetString(r100);
        this.paramSet = r101;
    }

    public static GOST28147Parameters getInstance(Object r100) {
        if ((r100 instanceof GOST28147Parameters) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new GOST28147Parameters(ASN1Sequence.getInstance(r100));
    L5:
        return (GOST28147Parameters) r100;
    }

    public static GOST28147Parameters getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public ASN1ObjectIdentifier getEncryptionParamSet() {
        return this.paramSet;
    }

    public byte[] getIV() {
        return Arrays.clone(this.f525040iv.getOctets());
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.f525040iv);
        r100.add(this.paramSet);
        return new DERSequence(r100);
    }
}
