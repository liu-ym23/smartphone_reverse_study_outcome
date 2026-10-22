package org.bouncycastle.asn1.cryptopro;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class Gost2814789KeyWrapParameters extends ASN1Object {
    private final ASN1ObjectIdentifier encryptionParamSet;
    private final byte[] ukm;

    public Gost2814789KeyWrapParameters(ASN1ObjectIdentifier r100) {
        this(r100, null);
    }

    public Gost2814789KeyWrapParameters(ASN1ObjectIdentifier r100, byte[] r101) {
        this.encryptionParamSet = r100;
        this.ukm = Arrays.clone(r101);
    }

    private Gost2814789KeyWrapParameters(ASN1Sequence r100) {
        if (r100.size() != 2) goto L6;
        this.encryptionParamSet = ASN1ObjectIdentifier.getInstance(r100.getObjectAt(0));
        this.ukm = ASN1OctetString.getInstance(r100.getObjectAt(1)).getOctets();
        return;
    L6:
        if (r100.size() != 1) goto L10;
        this.encryptionParamSet = ASN1ObjectIdentifier.getInstance(r100.getObjectAt(0));
        this.ukm = null;
        return;
    L10:
        throw new IllegalArgumentException("unknown sequence length: " + r100.size());
    }

    public static Gost2814789KeyWrapParameters getInstance(Object r100) {
        if ((r100 instanceof Gost2814789KeyWrapParameters) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new Gost2814789KeyWrapParameters(ASN1Sequence.getInstance(r100));
    L5:
        return (Gost2814789KeyWrapParameters) r100;
    }

    public ASN1ObjectIdentifier getEncryptionParamSet() {
        return this.encryptionParamSet;
    }

    public byte[] getUkm() {
        return Arrays.clone(this.ukm);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.encryptionParamSet);
        byte[] r101 = this.ukm;
        if (r101 == null) goto L6;
        r100.add(new DEROctetString(r101));
    L6:
        return new DERSequence(r100);
    }
}
